package weather.weatherback.domain;

// getter setter 자동으로 만들어줌
import lombok.Data;

@Data
public class MemberInput {
    private String email;
    private String password;

}
