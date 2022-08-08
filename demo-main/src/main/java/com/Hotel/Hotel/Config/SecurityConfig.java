package com.Hotel.Hotel.Config;
import com.Hotel.Hotel.Model.Hotel;
import com.Hotel.Hotel.Security.ClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ClientDetails clientdetails;
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers(HttpMethod.GET).hasAnyAuthority("admin","customer","employee")
                .antMatchers(HttpMethod.POST).hasAnyAuthority("admin","employee")
                .antMatchers(HttpMethod.DELETE).hasAnyAuthority("admin")
                .antMatchers(HttpMethod.PUT).hasAnyAuthority("admin","employee")
                .and().httpBasic();

        http.csrf().disable();
    }







    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(clientdetails).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
