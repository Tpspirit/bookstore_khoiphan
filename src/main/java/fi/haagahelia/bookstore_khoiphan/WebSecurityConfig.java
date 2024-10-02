package fi.haagahelia.bookstore_khoiphan;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {

    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http
            .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
            .formLogin(formlogin -> formlogin.loginPage("/login").defaultSuccessUrl("/booklist", true).permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        List<UserDetails> users = new ArrayList();
        UserDetails user1 = User.withDefaultPasswordEncoder()
            .username("user")
            .password("user")
            .roles("USER")
            .build();
        users.add(user1);

        UserDetails admin = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("admin")
            .roles("ADMIN")
            .build();
        users.add(admin);

        return new InMemoryUserDetailsManager(users);

    }
}
