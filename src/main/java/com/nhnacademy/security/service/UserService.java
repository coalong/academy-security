package com.nhnacademy.security.service;


public interface UserService {
    boolean matches(String userId, String userPwd);
}
