package jp.co.springbootapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.co.springbootapi.model.LoginModel;
import jp.co.springbootapi.service.LoginService;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

	@PostMapping("/api/v1/login")
	public LoginModel greeting(
		@RequestParam(value = "shop_cd", defaultValue = "") String shop_cd,
		@RequestParam(value = "password", defaultValue = "") String password
	) {
		LoginModel loginModel = loginService.main(shop_cd, password);
		return loginModel;
	}

}
