package org.projet6.escalade.consumer.impl.dao;

import org.apache.logging.log4j.Logger;
import org.projet6.escalade.consumer.contract.dao.TopoDao;
import org.projet6.escalade.model.bean.topo.Topo;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.annotation.ManagedBean;
import java.sql.Types;

@ManagedBean
public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {

    private Logger LOGGER;

    @Override
    public void insertTopo(Topo pTopo) {
        String vSQL = "INSERT INTO topo (name, description, place, date, memberId) VALUES (:name, :description, :place, :date, :memberId)";

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(pTopo);
        vParams.registerSqlType("name", Types.VARCHAR);
        vParams.registerSqlType("description", Types.LONGVARCHAR);
        vParams.registerSqlType("place", Types.VARCHAR);
        vParams.registerSqlType("date", Types.DATE);
        vParams.registerSqlType("memberId", Types.INTEGER);

        try {
            vJdbcTemplate.update(vSQL, vParams);
        } catch (DuplicateKeyException vEx) {
            LOGGER.error("Le site existe déjà ! id=" + pTopo.getId(), vEx);
        }
    }
}
