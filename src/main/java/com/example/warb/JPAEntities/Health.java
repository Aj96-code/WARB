package com.example.warb.JPAEntities;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@DynamicUpdate
@Table(name = "health")
public class Health {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "PhysicalDefects", length = 100)
    private String physicalDefects;

    @Column(name = "Asthmatic", length = 10)
    private String asthmatic;

    @Column(name = "UrinaryDisoder", length = 10)
    private String urinaryDisoder;

    @Column(name = "EarProblem", length = 10)
    private String earProblem;

    @Column(name = "EyeProblem", length = 10)
    private String eyeProblem;

    @Column(name = "Other", length = 100)
    private String other;
    @Column(name="HeartProblem", length = 100)
    private String HeartProblem;

    public String getHeartProblem() {
        return HeartProblem;
    }

    public void setHeartProblem(String heartProblem) {
        HeartProblem = heartProblem;
    }

    @Column(name = "Id_Stu")
    private Integer idStu;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhysicalDefects() {
        return physicalDefects;
    }

    public void setPhysicalDefects(String physicalDefects) {
        this.physicalDefects = physicalDefects;
    }

    public String getAsthmatic() {
        return asthmatic;
    }

    public void setAsthmatic(String asthmatic) {
        this.asthmatic = asthmatic;
    }

    public String getUrinaryDisoder() {
        return urinaryDisoder;
    }

    public void setUrinaryDisoder(String urinaryDisoder) {
        this.urinaryDisoder = urinaryDisoder;
    }

    public String getEarProblem() {
        return earProblem;
    }

    public void setEarProblem(String earProblem) {
        this.earProblem = earProblem;
    }

    public String getEyeProblem() {
        return eyeProblem;
    }

    public void setEyeProblem(String eyeProblem) {
        this.eyeProblem = eyeProblem;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Integer getIdStu() {
        return idStu;
    }

    public void setIdStu(int idStu) {
        this.idStu = idStu;
    }

}