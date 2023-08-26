package weather.weatherback.repository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import weather.weatherback.domain.Member;
import weather.weatherback.domain.MemberInput;

import java.util.Optional;

public interface MemberService extends UserDetailsService {

    // 회원 가입
    boolean register(MemberInput parameter);

    // 로그인
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
