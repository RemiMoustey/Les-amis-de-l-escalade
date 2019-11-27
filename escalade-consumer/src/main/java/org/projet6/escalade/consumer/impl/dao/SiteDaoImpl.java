package org.projet6.escalade.consumer.impl.dao;

import org.apache.logging.log4j.Logger;
import org.projet6.escalade.consumer.contract.dao.SiteDao;
import org.projet6.escalade.model.bean.site.Site;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.annotation.ManagedBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@ManagedBean
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {

    private Logger LOGGER;


    public List<Site> getListSites() {
        return new JdbcTemplate(getDataSource()).query("SELECT * FROM site", new SiteMapper());
    }

    public List<Site> getListSearchedSites(String search, String field) {
        String vSQL = "SELECT * FROM site WHERE " + field + " LIKE '%" + search + "%'";

        return new JdbcTemplate(getDataSource()).query(vSQL, new SiteMapper());
    }

    public Site getSearchedSite(String nameSite) {
        String vSQL = "SELECT * FROM site WHERE name = '" + nameSite + "'";

        return new JdbcTemplate(getDataSource()).query(vSQL, new SiteMapper()).iterator().next();
    }

    private static final class SiteMapper implements RowMapper<Site> {
        public Site mapRow(ResultSet pRS, int pRowNum) throws SQLException {
            Site vSite = new Site(pRS.getInt("id"));
            vSite.setName(pRS.getString("name"));
            vSite.setDescription(pRS.getString("description"));
            vSite.setSectors(pRS.getString("sectors"));
            vSite.setNumberOfSectors(pRS.getInt("numberOfSectors"));
            vSite.setLength(pRS.getInt("length"));
            vSite.setPlace(pRS.getString("place"));
            vSite.setGrade(pRS.getString("grade"));
            vSite.setNumberOfWays(pRS.getString("numberOfWays"));
            vSite.setOfficial(pRS.getBoolean("isOfficial"));

            return vSite;
        }
    }

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
}
