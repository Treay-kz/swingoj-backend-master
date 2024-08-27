package com.treay.swingoj.judge.service.Impl;

import cn.hutool.json.JSONUtil;
import com.treay.swingoj.common.ErrorCode;
import com.treay.swingoj.exception.ThrowUtils;
import com.treay.swingoj.judge.JudgeManager;
import com.treay.swingoj.judge.codesandbox.CodeSandbox;
import com.treay.swingoj.judge.codesandbox.CodeSandboxFactory;
import com.treay.swingoj.judge.codesandbox.CodeSandboxProxy;
import com.treay.swingoj.judge.service.JudgeService;
import com.treay.swingoj.judge.strategy.JudgeContext;
import com.treay.swingoj.model.codesandbox.ExecuteCodeRequest;
import com.treay.swingoj.model.codesandbox.ExecuteCodeResponse;
import com.treay.swingoj.model.codesandbox.JudgeInfo;
import com.treay.swingoj.model.codesandbox.JudgeCase;
import com.treay.swingoj.model.entity.Question;
import com.treay.swingoj.model.entity.QuestionSubmit;
import com.treay.swingoj.model.enums.QuestionSubmitStatusEnum;
import com.treay.swingoj.service.QuestionService;
import com.treay.swingoj.service.QuestionSubmitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @auther Treay_kz
 * @Date 2024/7/27 20:59
 */
@Slf4j
@Service
public class JudgeServiceImpl implements JudgeService {

    @Resource
    private QuestionService questionService;
    @Resource
    private QuestionSubmitService questionSubmitService;

    @Value("${spring.codesandbox.type}")
    private String judgeType;

    @Resource
    private JudgeManager judgeManager;


    @Override
    public QuestionSubmit doJudge(long questionSubmitId) {
        /*
            1.发送题目代码，题目的输入用例
            2. 处理返回结果
         */
        // 1. 发送前的合法性校验
        QuestionSubmit oldquestionSubmit = questionSubmitService.getById(questionSubmitId);
        ThrowUtils.throwIf(oldquestionSubmit == null, ErrorCode.PARAMS_ERROR);

        Question question = questionService.getById(oldquestionSubmit.getQuestionId());
        Integer status = oldquestionSubmit.getStatus();
        ThrowUtils.throwIf(QuestionSubmitStatusEnum.getEnumByValue(status) != QuestionSubmitStatusEnum.WAITING, ErrorCode.PARAMS_ERROR);
        // 2. 修改判题状态
        QuestionSubmit updateQuestionSubmit = new QuestionSubmit();
        updateQuestionSubmit.setId(questionSubmitId);
        updateQuestionSubmit.setStatus(QuestionSubmitStatusEnum.RUNNING.getValue());
        boolean update = questionSubmitService.updateById(updateQuestionSubmit);
        ThrowUtils.throwIf(!update, ErrorCode.PARAMS_ERROR);

        // 3. 调用判题接口
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(judgeType);
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        String judgeCase = question.getJudgeCase();
        List<JudgeCase> judgeCaseList = JSONUtil.toList(judgeCase, JudgeCase.class);
        List<String> inputList = judgeCaseList.stream().map(JudgeCase::getInput).collect(Collectors.toList());
        // 调用沙箱
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(oldquestionSubmit.getCode())
                .language(oldquestionSubmit.getLanguage())
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        log.info("执行结果: {}",executeCodeResponse.getOutputList());
        // 4.根据沙箱执行结果，设置判题信息和状态
        JudgeContext judgeContext = new JudgeContext();
        judgeContext.setJudgeInfo(executeCodeResponse.getJudgeInfo());
        judgeContext.setInputList(inputList);
        judgeContext.setOutputList(executeCodeResponse.getOutputList());
        judgeContext.setJudgeCaseList(judgeCaseList);
        judgeContext.setQuestion(question);
        judgeContext.setQuestionSubmit(oldquestionSubmit);
        // 进行判题
        JudgeInfo judgeInfo = judgeManager.doJudge(judgeContext);
        QuestionSubmit questionSubmit = new QuestionSubmit();
        questionSubmit.setId(questionSubmitId);
        questionSubmit.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo));
        questionSubmit.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        boolean result = questionSubmitService.updateById(questionSubmit);
        ThrowUtils.throwIf(!result, ErrorCode.PARAMS_ERROR);
        return questionSubmitService.getById(questionSubmitId);
    }

}
