package com.treay.swingoj.model.codesandbox;

import lombok.Data;

/**
 * 判题信息
 * @auther Treay_kz
 * @Date 2024/7/27 18:04
 */
@Data
public class JudgeInfo {
    /**
     * 程序执行信息
     */
    private String message;

    /**
     * 消耗内存
     */
    private Long memory;

    /**
     * 消耗时间（KB）
     */
    private Long time;
}
