package jp.co.springbootapi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.dsdb2")
public class Db2Config {

	private String driverClassName;
	private String url;
	private String username;
	private String password;

	@Bean(name = "dsdb2")
	public DataSource createProductServiceDataSource() {
	   return DataSourceBuilder
			   .create()
			   .driverClassName(driverClassName)
			   .url(url)
			   .username(username)
			   .password(password)
			   .build();
	}
	@Bean(name = "jdbcdb2")
	public JdbcTemplate createJdbcTemplateDb2(@Qualifier("dsdb2") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
