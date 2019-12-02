package org.projet6.escalade.consumer.impl.dao;

import org.apache.logging.log4j.Logger;
import org.projet6.escalade.consumer.contract.dao.TopoDao;
import org.projet6.escalade.model.bean.topo.Topo;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.annotation.ManagedBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@ManagedBean
public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {

    private Logger LOGGER;

    @Override
    public void insertTopo(Topo pTopo) {
        String vSQL = "INSERT INTO topo (name, description, place, date, memberId, isAvailable) VALUES (:name, :description, :place, :date, :memberId, :isAvailable)";

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(pTopo);
        vParams.registerSqlType("name", Types.VARCHAR);
        vParams.registerSqlType("description", Types.LONGVARCHAR);
        vParams.registerSqlType("place", Types.VARCHAR);
        vParams.registerSqlType("date", Types.DATE);
        vParams.registerSqlType("memberId", Types.INTEGER);
        vParams.registerSqlType("isAvailable", Types.BOOLEAN);

        try {
            vJdbcTemplate.update(vSQL, vParams);
        } catch (DuplicateKeyException vEx) {
            LOGGER.error("Le site existe déjà ! id=" + pTopo.getId(), vEx);
        }
    }

    @Override
    public List<Topo> getListToposMember(int memberId) {
        String vSQL = "SELECT id, name, description, place, DATE_FORMAT(date, \'%d/%m/%Y\') AS date_fr, memberId, isAvailable FROM topo WHERE memberId=" + memberId;

        return new JdbcTemplate(getDataSource()).query(vSQL, new TopoMapper());
    }

    @Override
    public List<Topo> getListAvailableTopos(int memberId) {
        String vSQL = "SELECT id, name, description, place, DATE_FORMAT(date, \'%d/%m/%Y\') AS date_fr, memberId, isAvailable FROM topo WHERE isAvailable=true AND memberId!=" + memberId;

        return new JdbcTemplate(getDataSource()).query(vSQL, new TopoMapper());
    }

    @Override
    public void reserveTopo(int id) {
        String vSQL = "UPDATE topo SET isAwaiting=true WHERE id=:id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", id);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public List<Topo> getListAwaitingTopos(int memberId) {
        String vSQL = "SELECT id, name, description, place, DATE_FORMAT(date, \'%d/%m/%Y\') AS date_fr, memberId, isAvailable FROM topo WHERE memberId=" + memberId + " AND isAwaiting=true";

        return new JdbcTemplate(getDataSource()).query(vSQL, new TopoMapper());
    }

    private static final class TopoMapper implements RowMapper<Topo> {
        public Topo mapRow(ResultSet pRS, int pRowNum) throws SQLException {
            Topo vTopo = new Topo(pRS.getInt("id"));
            vTopo.setName(pRS.getString("name"));
            vTopo.setDescription(pRS.getString("description"));
            vTopo.setPlace(pRS.getString("place"));
            vTopo.setDate(pRS.getString("date_fr"));
            vTopo.setMemberId(pRS.getInt("memberId"));
            vTopo.setIsAvailable(pRS.getBoolean("isAvailable"));

            return vTopo;
        }
    }
}
