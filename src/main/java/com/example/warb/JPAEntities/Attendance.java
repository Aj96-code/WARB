package com.example.warb.JPAEntities;

import javax.persistence.*;
@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Year1_Term1")
    private Integer year1Term1;

    @Column(name = "Year1_Term2")
    private Integer year1Term2;

    @Column(name = "Year1_Term3")
    private Integer year1Term3;

    @Column(name = "Year2_Term1")
    private Integer year2Term1;

    @Column(name = "Year2_Term2")
    private Integer year2Term2;

    @Column(name = "Year2_Term3")
    private Integer year2Term3;

    @Column(name = "Year3_Term1")
    private Integer year3Term1;

    @Column(name = "Year3_Term2")
    private Integer year3Term2;

    @Column(name = "Year3_Term3")
    private Integer year3Term3;

    @Column(name = "Year4_Term1")
    private Integer year4Term1;

    @Column(name = "Year4_Term2")
    private Integer year4Term2;

    @Column(name = "Year4_Term3")
    private Integer year4Term3;

    @Column(name = "Year5_Term1")
    private Integer year5Term1;

    @Column(name = "Year5_Term2")
    private Integer year5Term2;

    @Column(name = "Year5_Term3")
    private Integer year5Term3;

    @Column(name = "Year6_Term1")
    private Integer year6Term1;

    @Column(name = "Year6_Term2")
    private Integer year6Term2;

    @Column(name = "Year6_Term3")
    private Integer year6Term3;

    @OneToOne(targetEntity = Student.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_Stu")
    private int idStu;
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear1Term1() {
        return year1Term1;
    }

    public void setYear1Term1(Integer year1Term1) {
        this.year1Term1 = year1Term1;
    }

    public Integer getYear1Term2() {
        return year1Term2;
    }

    public void setYear1Term2(Integer year1Term2) {
        this.year1Term2 = year1Term2;
    }

    public Integer getYear1Term3() {
        return year1Term3;
    }

    public void setYear1Term3(Integer year1Term3) {
        this.year1Term3 = year1Term3;
    }

    public Integer getYear2Term1() {
        return year2Term1;
    }

    public void setYear2Term1(Integer year2Term1) {
        this.year2Term1 = year2Term1;
    }

    public Integer getYear2Term2() {
        return year2Term2;
    }

    public void setYear2Term2(Integer year2Term2) {
        this.year2Term2 = year2Term2;
    }

    public Integer getYear2Term3() {
        return year2Term3;
    }

    public void setYear2Term3(Integer year2Term3) {
        this.year2Term3 = year2Term3;
    }

    public Integer getYear3Term1() {
        return year3Term1;
    }

    public void setYear3Term1(Integer year3Term1) {
        this.year3Term1 = year3Term1;
    }

    public Integer getYear3Term2() {
        return year3Term2;
    }

    public void setYear3Term2(Integer year3Term2) {
        this.year3Term2 = year3Term2;
    }

    public Integer getYear3Term3() {
        return year3Term3;
    }

    public void setYear3Term3(Integer year3Term3) {
        this.year3Term3 = year3Term3;
    }

    public Integer getYear4Term1() {
        return year4Term1;
    }

    public void setYear4Term1(Integer year4Term1) {
        this.year4Term1 = year4Term1;
    }

    public Integer getYear4Term2() {
        return year4Term2;
    }

    public void setYear4Term2(Integer year4Term2) {
        this.year4Term2 = year4Term2;
    }

    public Integer getYear4Term3() {
        return year4Term3;
    }

    public void setYear4Term3(Integer year4Term3) {
        this.year4Term3 = year4Term3;
    }

    public Integer getYear5Term1() {
        return year5Term1;
    }

    public void setYear5Term1(Integer year5Term1) {
        this.year5Term1 = year5Term1;
    }

    public Integer getYear5Term2() {
        return year5Term2;
    }

    public void setYear5Term2(Integer year5Term2) {
        this.year5Term2 = year5Term2;
    }

    public Integer getYear5Term3() {
        return year5Term3;
    }

    public void setYear5Term3(Integer year5Term3) {
        this.year5Term3 = year5Term3;
    }

    public Integer getYear6Term1() {
        return year6Term1;
    }

    public void setYear6Term1(Integer year6Term1) {
        this.year6Term1 = year6Term1;
    }

    public Integer getYear6Term2() {
        return year6Term2;
    }

    public void setYear6Term2(Integer year6Term2) {
        this.year6Term2 = year6Term2;
    }

    public Integer getYear6Term3() {
        return year6Term3;
    }

    public void setYear6Term3(Integer year6Term3) {
        this.year6Term3 = year6Term3;
    }

    public int getIdStu() {
        return idStu;
    }

    public void setIdStu(int idStu) {
        this.idStu = idStu;
    }

}