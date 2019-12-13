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
@Table(name = "mst_sport")
@EntityListeners(AuditingEntityListener.class)
public class Sport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = false,updatable = false)
    private long id;

    @Column(name = "sportName", nullable = false)
    @Size(max = 20)
    @NotNull
    private String sportName;

    @Column(name = "minPlayer", nullable = false)
    @NotNull
    private int minPlayer;

    @Column(name = "maxPlayer", nullable = false)
    @NotNull
    private int maxPlayer;

    @Column(name = "createdAt", nullable = false)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false)
    @LastModifiedDate
    private Date updatedAt;

}
