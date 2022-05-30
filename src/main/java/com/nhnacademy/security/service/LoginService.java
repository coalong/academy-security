package com.nhnacademy.security.service;

public interface LoginService {
    boolean matches(String id, String pwd);
}
