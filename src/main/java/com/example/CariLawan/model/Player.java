package com.example.CariLawan.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter @Getter
@Entity
@Table(name = "mst_player")
@EntityListeners(AuditingEntityListener.class)
public class Player implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String player_id;

    @Column(name = "playerName", nullable = false)
    @Size(max = 30)
    @NotNull
    private String playerName;

    @Column(name = "email", nullable = false)
    @Size(max = 40)
    @NotNull
    private String email;

    public enum Gender {
        L,P
    }

    @Enumerated(EnumType.STRING)
    @Size(max = 2)
    @NotNull
    private Gender gender;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "phone", nullable = false)
    @Size(max = 16)
    private String phone;

    @Column(name = "sts", nullable = false)
    private int sts;

    @Column(name = "createdAt", nullable = false)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false)
    @LastModifiedDate
    private Date updatedAt;

//    @OneToMany(
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            mappedBy = "player_id"
//    )
//    private List<CfgSport> cfgSports = new ArrayList<>();

}
