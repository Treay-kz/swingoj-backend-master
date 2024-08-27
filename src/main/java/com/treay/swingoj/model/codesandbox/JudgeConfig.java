package com.treay.swingoj.model.codesandbox;

import lombok.Data;

/**
 * @Description: 判题配置
 * @auther Treay_kz
 * @Date 2024/7/27 13:07
 */
@Data
public class JudgeConfig {
    /**
     * 时间限制（ms）
     */
    private Long timeLimit;

    /**
     * 内存限制（KB）1
     */
    private Long memoryLimit;

    /**
     * 堆栈限制（KB）
     */
    private Long stackLimit;
}

