package weather.weatherback.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

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
}
