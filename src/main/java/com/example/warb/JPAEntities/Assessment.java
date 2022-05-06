package com.example.warb.JPAEntities;

import javax.persistence.*;


import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;



@Component
@DynamicUpdate
@Entity
@Table(name = "assessment")
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "GenKnowledge")
    private Integer genKnowledge;

    @Column(name = "NumberConcept")
    private Integer numberConcept;

    @Column(name = "OralLang")
    private Integer oralLang;

    @Column(name = "Reading")
    private Integer reading;

    @Column(name = "Structure")
    private Integer structure;

    @Column(name = "Vocab")
    private Integer vocab;

    @Column(name = "StudySkills")
    private Integer studySkills;

    @Column(name = "ComTask")
    private Integer comTask;

    @Column(name = "NumEst")
    private Integer numEst;

    @Column(name = "_Geometry")
    private Integer geometry;

    @Column(name = "Algebra")
    private Integer algebra;

    @Column(name = "Statistics")
    private Integer statistics;

    @Column(name = "LangArtGrade4")
    private Integer langArtGrade4;

    @Column(name = "MathGrade4")
    private Integer mathGrade4;

    @Column(name = "LangArtGrade5")
    private Integer langArtGrade5;

    @Column(name = "MathGrade5")
    private Integer mathGrade5;

    @Column(name = "AbilityTest")
    private Integer abilityTest;

    @Column(name = "MathGrade6")
    private Integer mathGrade6;

    @Column(name = "LangArtGrade6Curri")
    private Integer langArtGrade6Curri;

    @Column(name = "MathGrade6Curri")
    private Integer mathGrade6Curri;

    @Column(name = "Science")
    private Integer science;

    @Column(name = "SocialStudies")
    private Integer socialStudies;

    @Column(name = "WritingDrawing")
    private Integer writingDrawing;

    @Column(name = "Id_Stu")
    private Integer idStu;





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGenKnowledge() {
        return genKnowledge;
    }

    public void setGenKnowledge(Integer genKnowledge) {
        this.genKnowledge = genKnowledge;
    }

    public Integer getNumberConcept() {
        return numberConcept;
    }

    public void setNumberConcept(Integer numberConcept) {
        this.numberConcept = numberConcept;
    }

    public Integer getOralLang() {
        return oralLang;
    }

    public void setOralLang(Integer oralLang) {
        this.oralLang = oralLang;
    }

    public Integer getReading() {
        return reading;
    }

    public void setReading(Integer reading) {
        this.reading = reading;
    }

    public Integer getStructure() {
        return structure;
    }

    public void setStructure(Integer structure) {
        this.structure = structure;
    }

    public Integer getVocab() {
        return vocab;
    }

    public void setVocab(Integer vocab) {
        this.vocab = vocab;
    }

    public Integer getStudySkills() {
        return studySkills;
    }

    public void setStudySkills(Integer studySkills) {
        this.studySkills = studySkills;
    }

    public Integer getComTask() {
        return comTask;
    }

    public void setComTask(Integer comTask) {
        this.comTask = comTask;
    }

    public Integer getNumEst() {
        return numEst;
    }

    public void setNumEst(Integer numEst) {
        this.numEst = numEst;
    }

    public Integer getGeometry() {
        return geometry;
    }

    public void setGeometry(Integer geometry) {
        this.geometry = geometry;
    }

    public Integer getAlgebra() {
        return algebra;
    }

    public void setAlgebra(Integer algebra) {
        this.algebra = algebra;
    }

    public Integer getStatistics() {
        return statistics;
    }

    public void setStatistics(Integer statistics) {
        this.statistics = statistics;
    }

    public Integer getLangArtGrade4() {
        return langArtGrade4;
    }

    public void setLangArtGrade4(Integer langArtGrade4) {
        this.langArtGrade4 = langArtGrade4;
    }

    public Integer getMathGrade4() {
        return mathGrade4;
    }

    public void setMathGrade4(Integer mathGrade4) {
        this.mathGrade4 = mathGrade4;
    }

    public Integer getLangArtGrade5() {
        return langArtGrade5;
    }

    public void setLangArtGrade5(Integer langArtGrade5) {
        this.langArtGrade5 = langArtGrade5;
    }

    public Integer getMathGrade5() {
        return mathGrade5;
    }

    public void setMathGrade5(Integer mathGrade5) {
        this.mathGrade5 = mathGrade5;
    }

    public Integer getAbilityTest() {
        return abilityTest;
    }

    public void setAbilityTest(Integer abilityTest) {
        this.abilityTest = abilityTest;
    }

    public Integer getMathGrade6() {
        return mathGrade6;
    }

    public void setMathGrade6(Integer mathGrade6) {
        this.mathGrade6 = mathGrade6;
    }

    public Integer getLangArtGrade6Curri() {
        return langArtGrade6Curri;
    }

    public void setLangArtGrade6Curri(Integer langArtGrade6Curri) {
        this.langArtGrade6Curri = langArtGrade6Curri;
    }

    public Integer getMathGrade6Curri() {
        return mathGrade6Curri;
    }

    public void setMathGrade6Curri(Integer mathGrade6Curri) {
        this.mathGrade6Curri = mathGrade6Curri;
    }

    public Integer getScience() {
        return science;
    }

    public void setScience(Integer science) {
        this.science = science;
    }

    public Integer getSocialStudies() {
        return socialStudies;
    }

    public void setSocialStudies(Integer socialStudies) {
        this.socialStudies = socialStudies;
    }

    public Integer getWritingDrawing() {
        return writingDrawing;
    }

    public void setWritingDrawing(Integer writingDrawing) {
        this.writingDrawing = writingDrawing;
    }

    public Integer getIdStu() {
        return idStu;
    }

    public void setIdStu(Integer idStu) {
        this.idStu = idStu;
    }
}