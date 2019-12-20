package com.example.CariLawan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
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

@Setter @Getter
@Entity
@Table(name = "mst_sport")
@EntityListeners(AuditingEntityListener.class)
public class Sport implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String sport_id;

    @Column(name = "sportName", nullable = false)
    @Size(max = 20)
    @NotNull
    private String sportName;

    @Column(name = "createdAt", nullable = false)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false)
    @LastModifiedDate
    private Date updatedAt;

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "player_id")
//    private Player player_id;
}
