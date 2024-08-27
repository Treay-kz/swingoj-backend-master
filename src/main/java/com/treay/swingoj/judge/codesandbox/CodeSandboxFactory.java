package com.treay.swingoj.judge.codesandbox;

import com.treay.swingoj.judge.codesandbox.Impl.ExampleCodeSandbox;
import com.treay.swingoj.judge.codesandbox.Impl.RemoteCodeSandbox;
import com.treay.swingoj.judge.codesandbox.Impl.ThirdPartyCodeSandbox;

/**
 * @auther Treay_kz
 * @Date 2024/7/27 21:21
 */
public class CodeSandboxFactory {
    /**
     *
     * @param type
     * @return
     */
    public static CodeSandbox newInstance (String type){
        switch (type){
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }

    }
}
