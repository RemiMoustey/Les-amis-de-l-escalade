package org.projet6.escalade.consumer.contract.dao;

import org.projet6.escalade.model.bean.awaiting_topo.AwaitingTopo;
import org.projet6.escalade.model.bean.topo.Topo;

import java.util.List;

public interface TopoDao {
    public void insertTopo(Topo pTopo);
    public List<Topo> getListToposMember(int memberId);
    public List<Topo> getListAvailableTopos(int memberId);
    public void reserveTopo(int id);
    public List<Topo> getListAwaitingTopos(int memberId);
}
