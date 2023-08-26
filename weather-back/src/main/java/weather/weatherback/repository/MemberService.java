package weather.weatherback.repository;

import weather.weatherback.domain.MemberInput;

public interface MemberService {

    boolean register(MemberInput parameter);
}
