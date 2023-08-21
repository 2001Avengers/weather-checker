package weather.weatherback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import weather.weatherback.domain.Member;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findByEmail(String email);

}
