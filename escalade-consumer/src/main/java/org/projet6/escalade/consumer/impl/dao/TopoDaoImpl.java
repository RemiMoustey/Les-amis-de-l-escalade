package org.projet6.escalade.consumer.impl.dao;

import org.apache.logging.log4j.Logger;
import org.projet6.escalade.consumer.contract.dao.TopoDao;
import org.projet6.escalade.consumer.impl.rowmapper.TopoMapper;
import org.projet6.escalade.model.bean.topo.Topo;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.annotation.ManagedBean;
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
        vParams.registerSqlType("isReserved", Types.BOOLEAN);

        try {
            vJdbcTemplate.update(vSQL, vParams);
        } catch (DuplicateKeyException vEx) {
            LOGGER.error("Le site existe déjà ! id=" + pTopo.getId(), vEx);
        }
    }

    @Override
    public List<Topo> getListToposMember(int memberId) {
        String vSQL = "SELECT id, name, description, place, DATE_FORMAT(date, \'%d/%m/%Y\') AS date_fr, memberId, isAvailable, isReserved FROM topo WHERE memberId=:memberId";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("memberId", memberId);

        return new NamedParameterJdbcTemplate(getDataSource()).query(vSQL, vParams, new TopoMapper());
    }

    @Override
    public List<Topo> getListAvailableTopos(int memberId) {
        String vSQL = "SELECT id, name, description, place, DATE_FORMAT(date, \'%d/%m/%Y\') AS date_fr, memberId, isAvailable, isReserved FROM topo WHERE isAvailable=true AND memberId!=:memberId";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("memberId", memberId);

        return new NamedParameterJdbcTemplate(getDataSource()).query(vSQL, vParams, new TopoMapper());
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
        String vSQL = "SELECT id, name, description, place, DATE_FORMAT(date, \'%d/%m/%Y\') AS date_fr, memberId, isAvailable, isReserved FROM topo WHERE memberId=:memberId AND isAwaiting=true AND isReserved=false";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("memberId", memberId);

        return new NamedParameterJdbcTemplate(getDataSource()).query(vSQL, vParams, new TopoMapper());
    }

    @Override
    public void updateReservation(int topoId) {
        String vSQL = "UPDATE topo SET isReserved=true, isAvailable=false WHERE id=:id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", topoId);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public void deleteAwaiting(int topoId) {
        String vSQL = "DELETE FROM awaiting_topo WHERE topoId=:id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", topoId);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public void updateAvailable(int topoId, boolean isAvailable) {
        String vSQL;
        if (isAvailable) {
            vSQL = "UPDATE topo SET isAvailable=true, isAwaiting=false, isReserved=false WHERE id=:id";
        }
        else {
            vSQL = "UPDATE topo SET isAvailable=false WHERE id=:id";
        }
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", topoId);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }
}
