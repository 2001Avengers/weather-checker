package weather.weatherback.domain;

import jakarta.persistence.*;
<<<<<<< Updated upstream

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
=======
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
>>>>>>> Stashed changes

import java.time.LocalDateTime;
import java.util.List;

<<<<<<< Updated upstream
=======
@Getter
@Setter
@Entity
public class Member {
    @Id
    @Column(unique = true)
    private String email;

    private String password;


    // 회원 가입 날짜
    private LocalDateTime createdDate;

}

/*
>>>>>>> Stashed changes
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Member implements Persistable<String> {
    @Id
    @Column(unique = true)
    private String email;

    @CreatedDate
    private LocalDateTime createdDate;

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

    @Override
    public String getId() {
        return email;
    }

    @Transient
    private boolean isNew = true;
    @Override
    public boolean isNew() {
        return isNew;
    }

}