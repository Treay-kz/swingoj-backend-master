package com.treay.swingoj.model.dto.questionsubmit;

import lombok.Data;

/**
 * @Description: 提交代码请求
 * @auther Treay_kz
 * @Date 2024/7/27 13:30
 */
@Data
public class QuestionSubmitAddRequest {

    /**
     * 编程语言
     */
    private String language;

    /**
     * 用户代码
     */
    private String code;

    /**
     * 题目 id
     */
    private Long questionId;

    private static final long serialVersionUID = 1L;
}
