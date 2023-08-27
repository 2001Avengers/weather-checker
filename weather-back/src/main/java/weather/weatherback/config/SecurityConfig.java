package weather.weatherback.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
<<<<<<< Updated upstream
import weather.weatherback.UserAuthenticationFailureHandler;
import weather.weatherback.service.MemberService;
=======
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
>>>>>>> Stashed changes


@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final MemberService memberService;

    @Bean
    UserAuthenticationFailureHandler getFailureHandler() {
        return new UserAuthenticationFailureHandler();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
<<<<<<< Updated upstream
                        .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/member/join")).permitAll())

                .csrf(AbstractHttpConfigurer::disable)
//                .csrf((csrf) -> csrf
//                        .ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")))
//                .headers((headers) -> headers
//                        .addHeaderWriter(new XFrameOptionsHeaderWriter(
//                                XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
                .formLogin((formLogin) -> formLogin
                        .loginPage("/member/login")
                        .failureHandler(getFailureHandler())
                        .defaultSuccessUrl("/")
                        .permitAll())
=======
                        .requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
                // post 요청에 csrf 해제
                .csrf((csrf) -> csrf
                        .ignoringRequestMatchers(new AntPathRequestMatcher("/**")))
//                .csrf(AbstractHttpConfigurer::disable)

                // 로그인
                .formLogin((formLogin) -> formLogin
                        .loginPage("/member/login")
                        .defaultSuccessUrl("/") ) // 로그인 성공 시 이동하는 페이지
                // 로그아웃
>>>>>>> Stashed changes
                .logout((logout) -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true))
        ;
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService)
                .passwordEncoder(passwordEncoder());
    }



//    @Bean
//    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
}
