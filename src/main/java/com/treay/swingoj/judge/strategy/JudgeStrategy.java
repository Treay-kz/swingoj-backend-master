package com.treay.swingoj.judge.strategy;

import com.treay.swingoj.model.codesandbox.JudgeInfo;

/**
 * @auther Treay_kz
 * @Date 2024/7/27 21:34
 */
public interface JudgeStrategy {
    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
