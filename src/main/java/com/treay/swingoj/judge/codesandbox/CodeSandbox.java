package com.treay.swingoj.judge.codesandbox;

import com.treay.swingoj.model.codesandbox.ExecuteCodeRequest;
import com.treay.swingoj.model.codesandbox.ExecuteCodeResponse;

/**
 * @auther Treay_kz
 * @Date 2024/7/27 21:02
 */
public interface CodeSandbox {
    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
