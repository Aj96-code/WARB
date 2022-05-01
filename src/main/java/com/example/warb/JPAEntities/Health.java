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
    @Transient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Stu")
    private Student idStu;

    @Column(name = "ear_problem")
    private String earProblem1;

    @Column(name = "eye_problem")
    private String eyeProblem1;

    @Column(name = "physical_defects")
    private String physicalDefects1;

    @Column(name = "urinary_disoder")
    private String urinaryDisoder1;

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

    public Student getIdStu() {
        return idStu;
    }

    public void setIdStu(Student idStu) {
        this.idStu = idStu;
    }

    public String getEarProblem1() {
        return earProblem1;
    }

    public void setEarProblem1(String earProblem1) {
        this.earProblem1 = earProblem1;
    }

    public String getEyeProblem1() {
        return eyeProblem1;
    }

    public void setEyeProblem1(String eyeProblem1) {
        this.eyeProblem1 = eyeProblem1;
    }

    public String getPhysicalDefects1() {
        return physicalDefects1;
    }

    public void setPhysicalDefects1(String physicalDefects1) {
        this.physicalDefects1 = physicalDefects1;
    }

    public String getUrinaryDisoder1() {
        return urinaryDisoder1;
    }

    public void setUrinaryDisoder1(String urinaryDisoder1) {
        this.urinaryDisoder1 = urinaryDisoder1;
    }

}