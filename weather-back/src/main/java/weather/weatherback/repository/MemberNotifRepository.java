package weather.weatherback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import weather.weatherback.domain.MemberNotif;

public interface MemberNotifRepository extends JpaRepository<MemberNotif, Integer> {

}
