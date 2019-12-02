package org.projet6.escalade.consumer.impl.dao;

import org.apache.logging.log4j.Logger;
import org.projet6.escalade.consumer.contract.dao.AwaitingTopoDao;
import org.projet6.escalade.model.bean.awaiting_topo.AwaitingTopo;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class AwaitingTopoDaoImpl extends AbstractDaoImpl implements AwaitingTopoDao {

    private Logger LOGGER;

    @Override
    public void insertAwaitingTopo(AwaitingTopo pAwaitingTopo) {
        String vSQL = "INSERT INTO awaiting_topo (topoId, memberId, buyerId) VALUES(:topoId, :memberId, :buyerId)";

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(pAwaitingTopo);
        vParams.registerSqlType("topoId", Types.INTEGER);
        vParams.registerSqlType("memberId", Types.INTEGER);
        vParams.registerSqlType("buyerId", Types.INTEGER);

        try {
            vJdbcTemplate.update(vSQL, vParams);
        } catch (DuplicateKeyException vEx) {
            LOGGER.error("La réservation existe déjà ! id=" + pAwaitingTopo.getId(), vEx);
        }
    }

    @Override
    public List<AwaitingTopo> getListDataAwaitingToposMember(int memberId) {
        String vSQL = "SELECT * FROM awaiting_topo WHERE memberId=" + memberId;

        return new JdbcTemplate(getDataSource()).query(vSQL, new AwaitingTopoMapper());
    }

    @Override
    public List<AwaitingTopo> getListDataAwaitingToposBuyer(int buyerId) {
        String vSQL = "SELECT * FROM awaiting_topo WHERE buyerId=" + buyerId;

        return new JdbcTemplate(getDataSource()).query(vSQL, new AwaitingTopoMapper());
    }

    private static final class AwaitingTopoMapper implements RowMapper<AwaitingTopo> {
        public AwaitingTopo mapRow(ResultSet pRS, int pRowNum) throws SQLException {
            AwaitingTopo vAwaitingTopo = new AwaitingTopo(pRS.getInt("id"));
            vAwaitingTopo.setMemberId(Integer.parseInt(pRS.getString("memberId")));
            vAwaitingTopo.setBuyerId(Integer.parseInt(pRS.getString("buyerId")));
            vAwaitingTopo.setTopoId(pRS.getInt("topoId"));

            return vAwaitingTopo;
        }
    }
}
