package org.projet6.escalade.consumer.contract.dao;

import org.projet6.escalade.model.bean.topo.Topo;

import java.util.List;

public interface TopoDao {
    public void insertTopo(Topo pTopo);
    public List<Topo> getListToposMember(int memberId);
    public List<Topo> getListAvailableTopos(int memberId);
    public void reserveTopo(int id);
    public List<Topo> getListAwaitingTopos(int memberId);
    public void updateReservation(int idTopo);
    public void deleteAwaiting(int idTopo);
    public void updateAvailable(int id, boolean isAvailable);
}
