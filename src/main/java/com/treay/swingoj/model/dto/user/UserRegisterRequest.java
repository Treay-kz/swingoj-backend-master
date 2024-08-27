package com.treay.swingoj.model.dto.user;

import java.io.Serializable;
import lombok.Data;

/**
 * 用户注册请求体
 *
 * treay
 * 
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;
}
