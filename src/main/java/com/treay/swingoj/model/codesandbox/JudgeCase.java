package com.treay.swingoj.model.codesandbox;

import lombok.Data;

/**
 * * @Description 判题用例
 * @auther Treay_kz
 * @Date 2024/7/27 13:03
 */
@Data
public class JudgeCase {
    /**
     * 输入用例
     */
    private String input;

    /**
     * 输出用例
     */
    private String output;
}
