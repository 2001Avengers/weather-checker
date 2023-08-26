package weather.weatherback.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import weather.weatherback.domain.Member;
import weather.weatherback.domain.MemberInput;
import weather.weatherback.repository.MemberRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService implements weather.weatherback.repository.MemberService {

    private final MemberRepository memberRepository;

    // 회원 가입
    @Override
    public boolean register(MemberInput parameter) {

        // Null 고려 -> Optional
        Optional<Member> optionalMember = memberRepository.findById(parameter.getEmail());
        if (optionalMember.isPresent()) {
            // 동일 이메일 존재
            return false;
        }

        BCryptPasswordEncoder encPassword = new BCryptPasswordEncoder();

        Member member = new Member();
        member.setEmail(parameter.getEmail());
        member.setPassword(encPassword.encode(parameter.getPassword()));
        member.setRegDt(LocalDateTime.now());
        memberRepository.save(member);
        return true;
    }

    // 로그인
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Member> loginUser = this.memberRepository.findByEmail(email);
        if (loginUser.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
        }
        Member member = loginUser.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if ("admin".equals(email)) {
            authorities.add(new SimpleGrantedAuthority(MemberRole.ADMIN.getRoleUser()));
        } else {
            authorities.add(new SimpleGrantedAuthority(MemberRole.USER.getRoleUser()));
        }
        return new User(member.getEmail(), member.getPassword(), authorities);
    }


    /*
    public List<Member> getList() {
        return this.memberRepository.findAll();
    }

     */
}
