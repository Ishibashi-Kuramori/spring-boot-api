package jp.co.springbootapi.utility;

public class Const {

	// privateコンストラクタでインスタンス生成を抑止
	private Const() {}

	// HTTPレスポンスステータスコード
	public static final int HTTP_CODE_200 = 200; // リクエストが成功した
	public static final int HTTP_CODE_400 = 400; // リクエストが無効、サーバーがリクエストを理解できない
	public static final int HTTP_CODE_401 = 401; // 認証エラー
	public static final int HTTP_CODE_500 = 500; // サーバー側で処理エラー

	// HTTPレスポンスメッセージ
	public static final String HTTP_MSG_200 = null;
	public static final String HTTP_MSG_400_SHOP_CP = "入力された店舗コードに誤りがあります。";
	public static final String HTTP_MSG_400_PASSWORD = "入力されたパスワードに誤りがあります。";
	public static final String HTTP_MSG_401 = "認証に失敗しました。";
	public static final String HTTP_MSG_500 = "予期しないエラーが発生しました。";
}
