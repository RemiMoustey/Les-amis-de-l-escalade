package org.projet6.escalade.model.bean.topo;

public class Topo {
    private Integer id;
    private String name;
    private String description;
    private String place;
    private String date;
    private Integer memberId;
    private Boolean isAvailable;
    private Boolean isReserved;

    public Topo() {

    }

    public Topo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPlace() {
        return place;
    }

    public String getDate() {
        return date;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public Boolean getIsReserved() { return isReserved; }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setIsReserved(Boolean isReserved) { this.isReserved = isReserved; }
}
