package weather.weatherback.domain;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@Entity
public class MemberNotif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String notif_day;

    @Column
    private Time notif_time;

    @ManyToOne
    private Member member;  // Member 엔티티를 참조하기 위한 것
}
