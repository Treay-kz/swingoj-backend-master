package com.treay.swingoj.model.dto.question;

import com.treay.swingoj.model.codesandbox.JudgeCase;
import com.treay.swingoj.model.codesandbox.JudgeConfig;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 题目编辑
 * @TableName question
 */
@Data
public class QuestionEditRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表（json 数组）
     */
    private List<String> tags;

    /**
     * 题目答案
     */
    private String answer;

    /**
     * 判题用例（json 数组）
     */
    private List<JudgeCase> judgeCase;

    /**
     * 判题配置（json 对象）
     */
    private JudgeConfig judgeConfig;



    private static final long serialVersionUID = 1L;
}