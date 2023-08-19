package weather.weatherback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import weather.weatherback.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

    // 입력한 이메일로 비밀번호 초기화 정보를 전송
    boolean sendResetPassword(ResetPasswordInput parameter);

}
