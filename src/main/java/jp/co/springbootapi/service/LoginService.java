package jp.co.springbootapi.service;

import static jp.co.springbootapi.utility.Const.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.springbootapi.model.LoginModel;
import jp.co.springbootapi.repository.LoginRepository;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

	private LoginModel loginModel;

    public LoginModel main(String shop_cd, String password) {

    	// loginModelを初期化(複数回呼び出し時に前回分が残っている為)
    	loginModel = new LoginModel();

    	// リクエストパラメータ入力チェック
    	if(!inputCheck(shop_cd, password)) return loginModel;

    	// DB2にログイン認証＋店舗名取得
    	String shop_name = loginRepository.getByShopCdAndPassword(shop_cd, password);
		if(shop_name.isEmpty()) {
			// 失敗時は認証エラーを返却
        	loginModel.setStatus(HTTP_CODE_401);
        	loginModel.setMessage(HTTP_MSG_401);
            return loginModel;
		}


    	// 返却パラメータをセット
    	loginModel.setStatus(HTTP_CODE_200);
    	loginModel.setMessage(HTTP_MSG_200);
    	loginModel.setToken(password);
    	loginModel.setShop_name(shop_name);

        return loginModel;
    }

	// リクエストパラメータ入力チェック
    private boolean inputCheck(String shop_cd, String password) {
    	// 店舗名(未入力 or 4桁以外)
    	if(shop_cd.isEmpty() || shop_cd.length() != 4) {
        	loginModel.setStatus(HTTP_CODE_400);
        	loginModel.setMessage(HTTP_MSG_400_SHOP_CP);
        	return false;
    	}
    	// パスワード(未入力)
    	if(password.isEmpty()) {
        	loginModel.setStatus(HTTP_CODE_400);
        	loginModel.setMessage(HTTP_MSG_400_PASSWORD);
        	return false;
    	}
    	return true;
    }
}
