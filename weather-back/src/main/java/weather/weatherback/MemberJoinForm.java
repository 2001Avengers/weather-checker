package weather.weatherback;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberJoinForm {
    @NotEmpty(message = "이메일을 입력하세요.")
    @Email
    private String email;

    @NotEmpty(message = "비밀번호를 입력하세요.")
    private String password1;

    @NotEmpty(message = "비밀번호를 확인하세요.")
    private String password2;

    @NotEmpty(message = "지역을 선택하세요.")
    private String region;

    private Boolean rainOn;

    private Boolean snowOn;

    private Boolean dustOn;

    private Boolean uvOn;

    private LocalDateTime createdDate;
}
