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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Stu")
    private Student idStu;

    @Column(name = "year1term1")
    private Integer year1term1;

    @Column(name = "year1term2")
    private Integer year1term2;

    @Column(name = "year1term3")
    private Integer year1term3;

    @Column(name = "year2term1")
    private Integer year2term1;

    @Column(name = "year2term2")
    private Integer year2term2;

    @Column(name = "year2term3")
    private Integer year2term3;

    @Column(name = "year3term1")
    private Integer year3term1;

    @Column(name = "year3term2")
    private Integer year3term2;

    @Column(name = "year3term3")
    private Integer year3term3;

    @Column(name = "year4term1")
    private Integer year4term1;

    @Column(name = "year4term2")
    private Integer year4term2;

    @Column(name = "year4term3")
    private Integer year4term3;

    @Column(name = "year5term1")
    private Integer year5term1;

    @Column(name = "year5term2")
    private Integer year5term2;

    @Column(name = "year5term3")
    private Integer year5term3;

    @Column(name = "year6term1")
    private Integer year6term1;

    @Column(name = "year6term2")
    private Integer year6term2;

    @Column(name = "year6term3")
    private Integer year6term3;

    @Column(name = "idStu", nullable = false)
    private Integer idStu1;

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

    public Student getIdStu() {
        return idStu;
    }

    public void setIdStu(Student idStu) {
        this.idStu = idStu;
    }

    public Integer getYear1term1() {
        return year1term1;
    }

    public void setYear1term1(Integer year1term1) {
        this.year1term1 = year1term1;
    }

    public Integer getYear1term2() {
        return year1term2;
    }

    public void setYear1term2(Integer year1term2) {
        this.year1term2 = year1term2;
    }

    public Integer getYear1term3() {
        return year1term3;
    }

    public void setYear1term3(Integer year1term3) {
        this.year1term3 = year1term3;
    }

    public Integer getYear2term1() {
        return year2term1;
    }

    public void setYear2term1(Integer year2term1) {
        this.year2term1 = year2term1;
    }

    public Integer getYear2term2() {
        return year2term2;
    }

    public void setYear2term2(Integer year2term2) {
        this.year2term2 = year2term2;
    }

    public Integer getYear2term3() {
        return year2term3;
    }

    public void setYear2term3(Integer year2term3) {
        this.year2term3 = year2term3;
    }

    public Integer getYear3term1() {
        return year3term1;
    }

    public void setYear3term1(Integer year3term1) {
        this.year3term1 = year3term1;
    }

    public Integer getYear3term2() {
        return year3term2;
    }

    public void setYear3term2(Integer year3term2) {
        this.year3term2 = year3term2;
    }

    public Integer getYear3term3() {
        return year3term3;
    }

    public void setYear3term3(Integer year3term3) {
        this.year3term3 = year3term3;
    }

    public Integer getYear4term1() {
        return year4term1;
    }

    public void setYear4term1(Integer year4term1) {
        this.year4term1 = year4term1;
    }

    public Integer getYear4term2() {
        return year4term2;
    }

    public void setYear4term2(Integer year4term2) {
        this.year4term2 = year4term2;
    }

    public Integer getYear4term3() {
        return year4term3;
    }

    public void setYear4term3(Integer year4term3) {
        this.year4term3 = year4term3;
    }

    public Integer getYear5term1() {
        return year5term1;
    }

    public void setYear5term1(Integer year5term1) {
        this.year5term1 = year5term1;
    }

    public Integer getYear5term2() {
        return year5term2;
    }

    public void setYear5term2(Integer year5term2) {
        this.year5term2 = year5term2;
    }

    public Integer getYear5term3() {
        return year5term3;
    }

    public void setYear5term3(Integer year5term3) {
        this.year5term3 = year5term3;
    }

    public Integer getYear6term1() {
        return year6term1;
    }

    public void setYear6term1(Integer year6term1) {
        this.year6term1 = year6term1;
    }

    public Integer getYear6term2() {
        return year6term2;
    }

    public void setYear6term2(Integer year6term2) {
        this.year6term2 = year6term2;
    }

    public Integer getYear6term3() {
        return year6term3;
    }

    public void setYear6term3(Integer year6term3) {
        this.year6term3 = year6term3;
    }

    public Integer getIdStu1() {
        return idStu1;
    }

    public void setIdStu1(Integer idStu1) {
        this.idStu1 = idStu1;
    }

}