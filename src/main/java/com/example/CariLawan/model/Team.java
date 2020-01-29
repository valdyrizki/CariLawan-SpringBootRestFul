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
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "mst_team")
@EntityListeners(AuditingEntityListener.class)
public class Team implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String team_id;

    @Column(name = "teamName", nullable = false)
    @Size(max = 20)
    @NotNull
    private String teamName;

    @Column(name = "teamSts", nullable = false)
    @NotNull
    private int teamSts;

    @Column(name = "level")
    private int level;

    @Column(name = "team_xp")
    private int team_xp;

    @Column(name = "createdAt", nullable = false)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false)
    @LastModifiedDate
    private Date updatedAt;
}
