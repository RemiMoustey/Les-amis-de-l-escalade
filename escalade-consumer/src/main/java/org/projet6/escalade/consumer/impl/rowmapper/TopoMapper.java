package org.projet6.escalade.consumer.impl.rowmapper;

import org.projet6.escalade.model.bean.topo.Topo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class TopoMapper implements RowMapper<Topo> {
    public Topo mapRow(ResultSet pRS, int pRowNum) throws SQLException {
        Topo vTopo = new Topo(pRS.getInt("id"));
        vTopo.setName(pRS.getString("name"));
        vTopo.setDescription(pRS.getString("description"));
        vTopo.setPlace(pRS.getString("place"));
        vTopo.setDate(pRS.getString("date_fr"));
        vTopo.setMemberId(pRS.getInt("memberId"));
        vTopo.setIsAvailable(pRS.getBoolean("isAvailable"));
        vTopo.setIsReserved(pRS.getBoolean("isReserved"));

        return vTopo;
    }
}
