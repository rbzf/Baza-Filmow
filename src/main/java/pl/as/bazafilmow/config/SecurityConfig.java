package pl.as.bazafilmow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(request-> request.requestMatchers(new AntPathRequestMatcher("/")).permitAll());
        http.authorizeHttpRequests(request-> request.requestMatchers(new AntPathRequestMatcher("/*.png")).permitAll());
        http.authorizeHttpRequests(requests -> requests.anyRequest().authenticated());
        http.formLogin(form -> form.loginPage("/login").permitAll());
        http.csrf().disable();
        return http.build();
    }
}
