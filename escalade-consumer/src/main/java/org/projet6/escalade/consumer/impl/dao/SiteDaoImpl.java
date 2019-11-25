package org.projet6.escalade.consumer.impl.dao;

import org.projet6.escalade.consumer.contract.dao.SiteDao;
import org.projet6.escalade.model.bean.site.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.ManagedBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@ManagedBean
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {
    public List<Site> getListSites() {
        return new JdbcTemplate(getDataSource()).query("SELECT * FROM site", new SiteMapper());
    }

    public List<Site> getListSearchedSites(String search, String field) {
        String vSQL = "SELECT * FROM site" + " WHERE " + field + " LIKE '%" + search + "%'";

        return new JdbcTemplate(getDataSource()).query(vSQL, new SiteMapper());
    }

    private static final class SiteMapper implements RowMapper<Site> {
        public Site mapRow(ResultSet pRS, int pRowNum) throws SQLException {
            Site vSite = new Site(pRS.getInt("id"));
            vSite.setName(pRS.getString("name"));
            vSite.setDescription(pRS.getString("description"));
            vSite.setSectors(pRS.getString("sectors"));
            vSite.setNumberOfSectors(pRS.getInt("number_of_sectors"));
            vSite.setLength(pRS.getInt("length"));
            vSite.setPlace(pRS.getString("place"));
            vSite.setGrade(pRS.getString("grade"));
            vSite.setNumberOfWays(pRS.getString("number_of_ways"));
            vSite.setOfficial(pRS.getBoolean("is_official"));

            return vSite;
        }
    }
}
