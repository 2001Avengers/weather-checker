package weather.weatherback.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import weather.weatherback.MemberJoinForm;
import weather.weatherback.domain.Member;
import weather.weatherback.repository.MemberRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member create(String email, String password, String region, Boolean rainOn, Boolean snowOn, Boolean dustOn, Boolean uvOn) {


        Member member = new Member();
        member.setEmail(email);
        member.setRegion(region);
        member.setRainOn(rainOn);
        member.setSnowOn(snowOn);
        member.setDustOn(dustOn);
        member.setUvOn(uvOn);
        member.setCreatedDate(LocalDateTime.now());


        String encPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        member.setPassword(encPassword);
        this.memberRepository.save(member);
        return member;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> optionalMember = memberRepository.findByEmail(username);
        if (!optionalMember.isPresent()) {
            throw new UsernameNotFoundException("회원 정보가 없습니다.");
        }

        Member member = optionalMember.get();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(member.getEmail(), member.getPassword(), grantedAuthorities);
    }
}
