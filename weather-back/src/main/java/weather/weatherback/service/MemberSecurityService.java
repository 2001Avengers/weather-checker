package weather.weatherback.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import weather.weatherback.domain.Member;
import weather.weatherback.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberSecurityService implements UserDetailsService {

    private final MemberRepository memberRepository;

    // 회원 가입
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Member> _member = this.memberRepository.findByEmail(email);
        if (_member.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
        }
        Member member = _member.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if ("admin".equals(email)) {
            authorities.add(new SimpleGrantedAuthority(MemberRole.ADMIN.getRoleUser()));
        } else {
            authorities.add(new SimpleGrantedAuthority(MemberRole.USER.getRoleUser()));
        }
        return new User(member.getEmail(), member.getPassword(), authorities);
    }

}
