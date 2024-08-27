package com.treay.swingoj.model.dto.question;

import com.treay.swingoj.model.codesandbox.JudgeCase;
import com.treay.swingoj.model.codesandbox.JudgeConfig;
import lombok.Data;

import java.util.List;

/**
 * 题目更新请求
 * @auther Treay_kz
 * @Date 2024/7/27 13:26
 */
@Data
public class QuestionUpdateRequest {

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
     * 标签列表
     */
    private List<String> tags;

    /**
     * 题目答案
     */
    private String answer;

    /**
     * 判题用例
     */
    private List<JudgeCase> judgeCase;

    /**
     * 判题配置
     */
    private JudgeConfig judgeConfig;

    private static final long serialVersionUID = 1L;
}
