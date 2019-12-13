package com.example.CariLawan.model;

import lombok.Getter;
import lombok.Setter;
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
import java.util.Set;

@Setter @Getter
@Entity
@Table(name = "mst_player")
@EntityListeners(AuditingEntityListener.class)
public class Player implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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
    @Size(max = 1)
    @NotNull
    private Gender gender;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "city_id", nullable = false)
    private long city_id;

    @Column(name = "prov_id", nullable = false)
    private long prov_id;

    @Column(name = "team_id")
    private long team_id;

    @Column(name = "sport_id", nullable = false, updatable = false, insertable = false)
    private long sport_id;

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

    @ManyToMany
    @JoinColumn(name="team_id", nullable=false)
    private Team team;

}
