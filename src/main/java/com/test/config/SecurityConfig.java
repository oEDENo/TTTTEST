//package com.test.config;
//
//import com.test.board.service.user.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@RequiredArgsConstructor
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
////    private final CustomUserDetailsService customUserDetailsService;
////    private final UserService userService;
//
//    @Bean
//    public BCryptPasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(customUserDetailsService).passwordEncoder(encoder());
////    }
//
////    @Override
////    public void configure(AuthenticationManagerBuilder auth) throws Exception { // 9
////        auth.userDetailsService(userService)
////                // 해당 서비스(userService)에서는 UserDetailsService를 implements해서
////                // loadUserByUsername() 구현해야함 (서비스 참고)
////                .passwordEncoder(new BCryptPasswordEncoder());
////    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
//        web
//                .ignoring().antMatchers( "/css/**", "/js/**", "/img/**","/fonts.font-awesome/**","/plugin/**","/scripts/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                // 페이지 권한 설정
//                .csrf().disable()   // Spring Security에서는 csrf 토큰 없이 요청하면 해당 요청을 막기 때문에 임시 비활성화 처리해줌
//                .authorizeRequests()
//                .antMatchers("/", "/board/**","/user/**" /*, "/posts/read/**", "/posts/search/**"*/)
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()// 로그인 설정
//                .formLogin()
//                .loginPage("/auth/login")
//                .loginProcessingUrl("loginProc")
//                .defaultSuccessUrl("/")
//                .and()// 로그아웃 설정
//                .logout()
//                .logoutSuccessUrl("/")
//                .invalidateHttpSession(true);
//    }
//
//}
