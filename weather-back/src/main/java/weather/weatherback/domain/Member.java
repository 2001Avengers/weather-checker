package weather.weatherback.domain;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Member {
    @Id
    private String email;

    private String password;

    // 회원 가입 날짜
    private LocalDateTime regDt;

}

/*
@Getter
@Setter
@Entity
public class Member {
    @Id
    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String region;

    @Column
    private boolean rainOn;

    @Column
    private boolean snowOn;

    @Column
    private boolean dustOn;

    @Column
    private boolean uvOn;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<MemberNotif> memberNotifList;
}

 */
