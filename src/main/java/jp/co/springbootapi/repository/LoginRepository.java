package jp.co.springbootapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.springbootapi.entity.ShopEntity;

@Repository
public class LoginRepository {

	@Qualifier("jdbcpsql")
    @Autowired
    JdbcTemplate jdbcpsql;

	@Qualifier("jdbcdb2")
    @Autowired
    JdbcTemplate jdbcdb2;

	// 店舗CD, パスワードを元にレコードを1件取得
	public String getByShopCdAndPassword(String shop_cd, String password) {
//		List<Map<String,Object>> list;
//		list = jdbcpsql.queryForList("select * from t_login");
//		System.out.println(list);
		List<ShopEntity> shopList;
		// SQL文を生成
		String sql = "SELECT * FROM shop WHERE shop_cd = ? AND password = ?";

		// SQL実行(取得結果をShopEntityクラスに自動マッピング)
		shopList = jdbcdb2.query(sql,
				new BeanPropertyRowMapper<ShopEntity>(ShopEntity.class),
				shop_cd, password);

		// 取得した件数が0の場合は空文字、1件以上で店舗名を返却
		if(shopList.size() == 0) return "";
		return shopList.get(0).getShop_name();
	}

}
