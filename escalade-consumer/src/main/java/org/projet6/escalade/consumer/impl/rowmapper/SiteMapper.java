package org.projet6.escalade.consumer.impl.rowmapper;

import org.projet6.escalade.model.bean.site.Site;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class SiteMapper implements RowMapper<Site> {
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
