package org.projet6.escalade.consumer.impl.rowmapper;

import org.projet6.escalade.model.bean.awaiting_topo.AwaitingTopo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class AwaitingTopoMapper implements RowMapper<AwaitingTopo> {
    public AwaitingTopo mapRow(ResultSet pRS, int pRowNum) throws SQLException {
        AwaitingTopo vAwaitingTopo = new AwaitingTopo(pRS.getInt("id"));
        vAwaitingTopo.setMemberId(Integer.parseInt(pRS.getString("memberId")));
        vAwaitingTopo.setBuyerId(Integer.parseInt(pRS.getString("buyerId")));
        vAwaitingTopo.setTopoId(pRS.getInt("topoId"));

        return vAwaitingTopo;
    }
}
