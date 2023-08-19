package weather.weatherback.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import weather.weatherback.domain.Member;
import weather.weatherback.repository.MemberRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class MemberService implements MemberRepository{
    private final MemberRepository memberRepository;

    public List<Member> getList() {
        return this.memberRepository.findAll();
    }


    @Override
    public boolean sendResetPassword(ResetPasswordInput parameter) {



        return false;
    }
}
