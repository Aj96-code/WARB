package com.example.warb.JPAEntities;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
@Component
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "FirstName", length = 50)
    private String firstName;

    @Column(name = "MiddleName", length = 50)
    private String middleName;

    @Column(name = "LastName", length = 50)
    private String lastName;

    @Column(name = "BirthCertNum", length = 20)
    private String birthCertNum;

    @Column(name = "DOB")
    private LocalDate dob;

    @Column(name = "DareReg")
    private LocalDate dareReg;

    @Column(name = "SportsHouse", length = 20)
    private String sportsHouse;

    @Column(name = "Club", length = 20)
    private String club;

    @Column(name = "Gender", length = 10)
    private String gender;

    @Column(name = "StudentAddress", length = 200)
    private String studentAddress;

    @Column(name = "MotherName", length = 100)
    private String motherName;

    @Column(name = "MotherOccupation", length = 100)
    private String motherOccupation;

    @Column(name = "MotherTel", length = 20)
    private String motherTel;

    @Column(name = "FatherName", length = 100)
    private String fatherName;

    @Column(name = "FatherTel", length = 20)
    private String fatherTel;

    @Column(name = "FatherAddress", length = 200)
    private String fatherAddress;

    @Column(name = "GuardianName", length = 100)
    private String guardianName;

    @Column(name = "GuardianOccupation", length = 100)
    private String guardianOccupation;

    @Column(name = "GuardianAddress", length = 200)
    private String guardianAddress;

    @Column(name = "GuardianTel", length = 20)
    private String guardianTel;

    @Column(name = "Photo", length = 10000)
    private String photo;

    @Lob
    @Column(name = "ERN")
    private String ern;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthCertNum() {
        return birthCertNum;
    }

    public void setBirthCertNum(String birthCertNum) {
        this.birthCertNum = birthCertNum;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDareReg() {
        return dareReg;
    }

    public void setDareReg(LocalDate dareReg) {
        this.dareReg = dareReg;
    }

    public String getSportsHouse() {
        return sportsHouse;
    }

    public void setSportsHouse(String sportsHouse) {
        this.sportsHouse = sportsHouse;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherOccupation() {
        return motherOccupation;
    }

    public void setMotherOccupation(String motherOccupation) {
        this.motherOccupation = motherOccupation;
    }

    public String getMotherTel() {
        return motherTel;
    }

    public void setMotherTel(String motherTel) {
        this.motherTel = motherTel;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherTel() {
        return fatherTel;
    }

    public void setFatherTel(String fatherTel) {
        this.fatherTel = fatherTel;
    }

    public String getFatherAddress() {
        return fatherAddress;
    }

    public void setFatherAddress(String fatherAddress) {
        this.fatherAddress = fatherAddress;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianOccupation() {
        return guardianOccupation;
    }

    public void setGuardianOccupation(String guardianOccupation) {
        this.guardianOccupation = guardianOccupation;
    }

    public String getGuardianAddress() {
        return guardianAddress;
    }

    public void setGuardianAddress(String guardianAddress) {
        this.guardianAddress = guardianAddress;
    }

    public String getGuardianTel() {
        return guardianTel;
    }

    public void setGuardianTel(String guardianTel) {
        this.guardianTel = guardianTel;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getErn() {
        return ern;
    }

    public void setErn(String ern) {
        this.ern = ern;
    }

}