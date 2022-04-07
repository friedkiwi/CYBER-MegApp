package gent.cyber.megapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import javax.sql.DataSource;

@Configuration
@ComponentScan("gent.cyber.megapp.energymon")
@EnableTransactionManagement
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
                .authorizeRequests()
                    // allow front page access
                    .antMatchers("/").permitAll()
                    // allow unauthenticated users to log in
                    .antMatchers("/auth/process-login.action").permitAll()
                    // allow authenticated users to change their passwords
                    .antMatchers("/auth/changePassword.action").access("hasRole('ROLE_USER')")
                    // restrict internal applications to logged in users
                    .antMatchers("/energymon/**").access("hasRole('ROLE_USER')")
                    .and()
                .formLogin()
                    .loginPage("/auth/login.action")
                    .loginProcessingUrl("/auth/process-login.action")
                    .defaultSuccessUrl("/")
                    .failureUrl("/auth/login.action?error")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .and()
                .logout()
                    .logoutUrl("/auth/logout.action?logout")
                    .logoutSuccessUrl("/").and()
                .exceptionHandling()
                    .accessDeniedPage("/auth/accessDenied.action");
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    @Autowired
    private DataSource dataSource;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from users where username=?")
        ;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
