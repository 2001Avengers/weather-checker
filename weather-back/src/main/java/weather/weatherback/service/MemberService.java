package weather.weatherback.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import weather.weatherback.domain.Member;
import weather.weatherback.domain.MemberInput;
import weather.weatherback.repository.MemberRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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

        Member member = new Member();
        member.setEmail(parameter.getEmail());
        member.setPassword(parameter.getPassword());
        member.setRegDt(LocalDateTime.now());
        memberRepository.save(member);
        return true;
    }

    /*
    public List<Member> getList() {
        return this.memberRepository.findAll();
    }

     */
}
