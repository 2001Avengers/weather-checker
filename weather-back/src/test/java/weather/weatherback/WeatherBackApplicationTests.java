package weather.weatherback;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import weather.weatherback.domain.Member;
import weather.weatherback.repository.MemberRepository;
import java.util.List;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class WeatherBackApplicationTests {

	@Autowired
	private MemberRepository memberRepository;

	@Transactional
	@Test
	void testJpa() {
		List<Member> all = this.memberRepository.findAll();
		assertThat(all.size()).isEqualTo(2);
		Member m = all.get(0);
		assertThat(m.getEmail()).isEqualTo("serin@gmail.com");
	}

}
