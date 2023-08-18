package weather.weatherback.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import weather.weatherback.domain.Member;
import weather.weatherback.repository.MemberRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public List<Member> getList() {
        return this.memberRepository.findAll();
    }
}
