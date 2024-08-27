package com.treay.swingoj.judge.service;

import com.treay.swingoj.model.entity.QuestionSubmit;

/**
 * @auther Treay_kz
 * @Date 2024/7/27 20:57
 */
public interface JudgeService {
    /**
     * 判题
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
