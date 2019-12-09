package org.projet6.escalade.consumer.contract.dao;

import org.projet6.escalade.model.bean.awaiting_topo.AwaitingTopo;

import java.util.List;

public interface AwaitingTopoDao {
    public void insertAwaitingTopo(AwaitingTopo pAwaitingTopo);
    public List<AwaitingTopo> getListDataAwaitingToposMember(int memberId);
    public List<AwaitingTopo> getListDataAwaitingToposBuyer(int buyerId);
}