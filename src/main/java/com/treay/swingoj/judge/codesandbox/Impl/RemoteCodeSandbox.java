package com.treay.swingoj.judge.codesandbox.Impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.treay.swingoj.common.ErrorCode;
import com.treay.swingoj.exception.BusinessException;
import com.treay.swingoj.judge.codesandbox.CodeSandbox;
import com.treay.swingoj.model.codesandbox.ExecuteCodeRequest;
import com.treay.swingoj.model.codesandbox.ExecuteCodeResponse;

/**
 * @auther Treay_kz
 * @Date 2024/7/27 21:06
 */
public class RemoteCodeSandbox implements CodeSandbox {

    private static final String AUTH_REQUEST_HEADER = "auth";

    private static final String AUTH_REQUEST_SECRET = "treay";
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        // todo 改为线上地址
        String url = "http://localhost:8203/executeCode";
        String json = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
                .header(AUTH_REQUEST_HEADER, AUTH_REQUEST_SECRET)
                .body(json)
                .execute()
                .body();
        if (StringUtils.isBlank(responseStr)) {
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR, "executeCode remoteSandbox error, message = " + responseStr);
        }
        return JSONUtil.toBean(responseStr, ExecuteCodeResponse.class);
    }
}
