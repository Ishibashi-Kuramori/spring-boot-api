package jp.co.springbootapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

// spring-boot-starter-security 周りの各種設定

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(final HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // Basic認証を使わない
                .httpBasic().disable()
                // CSRF設定を使わない
                .csrf().disable()
                // セッションはStatelessなので使わない
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//                .and()
                // USERではないとどのURLでもアクセスできない
//                .authorizeRequests()
//                .anyRequest().hasRole("USER");
    }
}
