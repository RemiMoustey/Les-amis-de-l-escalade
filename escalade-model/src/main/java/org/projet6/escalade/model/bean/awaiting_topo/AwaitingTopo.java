package org.projet6.escalade.model.bean.awaiting_topo;

public class AwaitingTopo {
    private Integer id;
    private Integer topoId;
    private Integer memberId;
    private Integer buyerId;

    public AwaitingTopo() {

    }

    public AwaitingTopo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getTopoId() {
        return topoId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTopoId(Integer topoId) {
        this.topoId = topoId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }
}
