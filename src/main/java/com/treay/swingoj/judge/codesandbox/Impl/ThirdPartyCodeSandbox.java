package com.treay.swingoj.judge.codesandbox.Impl;

import com.treay.swingoj.judge.codesandbox.CodeSandbox;
import com.treay.swingoj.model.codesandbox.ExecuteCodeRequest;
import com.treay.swingoj.model.codesandbox.ExecuteCodeResponse;

/**
 * @auther Treay_kz
 * @Date 2024/7/27 21:06
 */
public class ThirdPartyCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}
