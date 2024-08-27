package com.treay.swingoj.judge.codesandbox.Impl;

import com.treay.swingoj.judge.codesandbox.CodeSandbox;
import com.treay.swingoj.model.codesandbox.ExecuteCodeRequest;
import com.treay.swingoj.model.codesandbox.ExecuteCodeResponse;
import com.treay.swingoj.model.codesandbox.JudgeInfo;
import com.treay.swingoj.model.enums.JudgeInfoMessageEnum;
import com.treay.swingoj.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * @auther Treay_kz
 * @Date 2024/7/27 21:05
 */
public class ExampleCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();

        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);

        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("Accepted");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
