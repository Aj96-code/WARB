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
    @Transient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Stu")
    private Student idStu;

    @Column(name = "ability_test")
    private Integer abilityTest1;

    @Column(name = "com_task")
    private Integer comTask1;

    @Column(name = "gen_knowledge")
    private Integer genKnowledge1;

    @Column(name = "geometry")
    private Integer geometry1;

    @Column(name = "lang_art_grade4")
    private Integer langArtGrade41;

    @Column(name = "lang_art_grade5")
    private Integer langArtGrade51;

    @Column(name = "lang_art_grade6curri")
    private Integer langArtGrade6curri;

    @Column(name = "math_grade4")
    private Integer mathGrade41;

    @Column(name = "math_grade5")
    private Integer mathGrade51;

    @Column(name = "math_grade6")
    private Integer mathGrade61;

    @Column(name = "math_grade6curri")
    private Integer mathGrade6curri;

    @Column(name = "num_est")
    private Integer numEst1;

    @Column(name = "number_concept")
    private Integer numberConcept1;

    @Column(name = "oral_lang")
    private Integer oralLang1;

    @Column(name = "social_studies")
    private Integer socialStudies1;

    @Column(name = "study_skills")
    private Integer studySkills1;

    @Column(name = "writing_drawing")
    private Integer writingDrawing1;

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

    public Student getIdStu() {
        return idStu;
    }

    public void setIdStu(Student idStu) {
        this.idStu = idStu;
    }

    public Integer getAbilityTest1() {
        return abilityTest1;
    }

    public void setAbilityTest1(Integer abilityTest1) {
        this.abilityTest1 = abilityTest1;
    }

    public Integer getComTask1() {
        return comTask1;
    }

    public void setComTask1(Integer comTask1) {
        this.comTask1 = comTask1;
    }

    public Integer getGenKnowledge1() {
        return genKnowledge1;
    }

    public void setGenKnowledge1(Integer genKnowledge1) {
        this.genKnowledge1 = genKnowledge1;
    }

    public Integer getGeometry1() {
        return geometry1;
    }

    public void setGeometry1(Integer geometry1) {
        this.geometry1 = geometry1;
    }

    public Integer getLangArtGrade41() {
        return langArtGrade41;
    }

    public void setLangArtGrade41(Integer langArtGrade41) {
        this.langArtGrade41 = langArtGrade41;
    }

    public Integer getLangArtGrade51() {
        return langArtGrade51;
    }

    public void setLangArtGrade51(Integer langArtGrade51) {
        this.langArtGrade51 = langArtGrade51;
    }

    public Integer getLangArtGrade6curri() {
        return langArtGrade6curri;
    }

    public void setLangArtGrade6curri(Integer langArtGrade6curri) {
        this.langArtGrade6curri = langArtGrade6curri;
    }

    public Integer getMathGrade41() {
        return mathGrade41;
    }

    public void setMathGrade41(Integer mathGrade41) {
        this.mathGrade41 = mathGrade41;
    }

    public Integer getMathGrade51() {
        return mathGrade51;
    }

    public void setMathGrade51(Integer mathGrade51) {
        this.mathGrade51 = mathGrade51;
    }

    public Integer getMathGrade61() {
        return mathGrade61;
    }

    public void setMathGrade61(Integer mathGrade61) {
        this.mathGrade61 = mathGrade61;
    }

    public Integer getMathGrade6curri() {
        return mathGrade6curri;
    }

    public void setMathGrade6curri(Integer mathGrade6curri) {
        this.mathGrade6curri = mathGrade6curri;
    }

    public Integer getNumEst1() {
        return numEst1;
    }

    public void setNumEst1(Integer numEst1) {
        this.numEst1 = numEst1;
    }

    public Integer getNumberConcept1() {
        return numberConcept1;
    }

    public void setNumberConcept1(Integer numberConcept1) {
        this.numberConcept1 = numberConcept1;
    }

    public Integer getOralLang1() {
        return oralLang1;
    }

    public void setOralLang1(Integer oralLang1) {
        this.oralLang1 = oralLang1;
    }

    public Integer getSocialStudies1() {
        return socialStudies1;
    }

    public void setSocialStudies1(Integer socialStudies1) {
        this.socialStudies1 = socialStudies1;
    }

    public Integer getStudySkills1() {
        return studySkills1;
    }

    public void setStudySkills1(Integer studySkills1) {
        this.studySkills1 = studySkills1;
    }

    public Integer getWritingDrawing1() {
        return writingDrawing1;
    }

    public void setWritingDrawing1(Integer writingDrawing1) {
        this.writingDrawing1 = writingDrawing1;
    }

}