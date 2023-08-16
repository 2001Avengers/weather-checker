package weather.weatherback.domain;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Member {
    @Id
    @Column
    private String email;

    @Column
    private String pw;

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
