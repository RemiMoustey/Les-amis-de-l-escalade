package org.projet6.escalade.consumer.impl.dao;

import org.apache.logging.log4j.Logger;
import org.projet6.escalade.consumer.contract.dao.SiteDao;
import org.projet6.escalade.consumer.impl.rowmapper.SiteMapper;
import org.projet6.escalade.model.bean.site.Site;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.annotation.ManagedBean;
import java.sql.Types;
import java.util.List;

@ManagedBean
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {

    private Logger LOGGER;

    @Override
    public List<Site> getListSites() {
        return new JdbcTemplate(getDataSource()).query("SELECT * FROM site", new SiteMapper());
    }

    @Override
    public List<Site> getListSearchedSites(String search, String field) {
        String vSQL = "SELECT * FROM site WHERE " + field + " LIKE '%" + search + "%'";

        return new JdbcTemplate(getDataSource()).query(vSQL, new SiteMapper());
    }

    @Override
    public Site getSearchedSite(String nameSite) {
        String vSQL = "SELECT * FROM site WHERE name=:nameSite";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nameSite", nameSite);

        return new NamedParameterJdbcTemplate(getDataSource()).query(vSQL, vParams, new SiteMapper()).iterator().next();
    }

    @Override
    public void insertSite(Site pSite) {
        String vSQL = "INSERT INTO site (name, description, sectors, numberOfSectors, length, place, grade, numberOfWays) VALUES (:name, :description, :sectors, :numberOfSectors, :length, :place, :grade, :numberOfWays)";

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(pSite);
        vParams.registerSqlType("name", Types.VARCHAR);
        vParams.registerSqlType("description", Types.LONGVARCHAR);
        vParams.registerSqlType("sectors", Types.LONGVARCHAR);
        vParams.registerSqlType("numberOfSectors", Types.INTEGER);
        vParams.registerSqlType("length", Types.INTEGER);
        vParams.registerSqlType("place", Types.VARCHAR);
        vParams.registerSqlType("grade", Types.VARCHAR);
        vParams.registerSqlType("numberOfWays", Types.INTEGER);

        try {
            vJdbcTemplate.update(vSQL, vParams);
        } catch (DuplicateKeyException vEx) {
            LOGGER.error("Le site existe déjà ! id=" + pSite.getId(), vEx);
        }
    }

    @Override
    public void updateOfficial(int id, boolean setOfficial) {
        String vSQL = "UPDATE site SET isOfficial = :isOfficial WHERE id = :id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("isOfficial", setOfficial);
        vParams.addValue("id", id);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }
}
