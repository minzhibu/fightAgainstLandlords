package com.sjm.PlayingCards.controller;

import com.sjm.PlayingCards.common.CommonResult;
import com.sjm.PlayingCards.dto.TouristInformation;
import com.sjm.PlayingCards.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 游客登录测试dev2
     * @return CommonResult
     */
    @PostMapping("/tourist")
    public CommonResult<TouristInformation> touristLogin(){
        return CommonResult.success(loginService.loginTourist());
    }
}
