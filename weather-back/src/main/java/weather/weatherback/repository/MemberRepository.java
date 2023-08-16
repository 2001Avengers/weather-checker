package weather.weatherback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import weather.weatherback.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
