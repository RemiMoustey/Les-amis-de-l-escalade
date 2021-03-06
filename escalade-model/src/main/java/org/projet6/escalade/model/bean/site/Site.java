package org.projet6.escalade.model.bean.site;

public class Site {

    // ==================== Attributes ====================
    private Integer id;
    private String name;
    private String description;
    private String sectors;
    private Integer numberOfSectors;
    private Integer length;
    private String place;
    private String grade;
    private String numberOfWays;
    private Boolean isOfficial;

    // ==================== Constructors ====================
    public Site() {

    }

    public Site(Integer pId) { id = pId; }

    // ==================== Getters/Setters ====================

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSectors() {
        return sectors;
    }

    public Integer getNumberOfSectors() {
        return numberOfSectors;
    }

    public Integer getLength() {
        return length;
    }

    public String getPlace() {
        return place;
    }

    public String getGrade() {
        return grade;
    }

    public String getNumberOfWays() {
        return numberOfWays;
    }

    public Boolean getOfficial() {
        return isOfficial;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSectors(String sectors) {
        this.sectors = sectors;
    }

    public void setNumberOfSectors(Integer numberOfSectors) {
        this.numberOfSectors = numberOfSectors;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setNumberOfWays(String numberOfWays) {
        this.numberOfWays = numberOfWays;
    }

    public void setOfficial(Boolean official) {
        isOfficial = official;
    }

}
