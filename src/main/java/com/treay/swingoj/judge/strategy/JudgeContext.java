package com.treay.swingoj.judge.strategy;

import com.treay.swingoj.model.codesandbox.JudgeInfo;
import com.treay.swingoj.model.codesandbox.JudgeCase;
import com.treay.swingoj.model.entity.QuestionSubmit;
import com.treay.swingoj.model.entity.Question;
import lombok.Data;

import java.util.List;

/**
 * @auther Treay_kz
 * @Date 2024/7/27 21:35
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;
}
