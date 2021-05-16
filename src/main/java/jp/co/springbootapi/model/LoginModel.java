package jp.co.springbootapi.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginModel {
	private int status;
	private String message;
	private String token;
	private String shop_name;
}
