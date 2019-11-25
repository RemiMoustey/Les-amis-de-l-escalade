package org.projet6.escalade.consumer.contract.dao;

import org.projet6.escalade.model.bean.site.Site;

import java.util.List;

public interface SiteDao {
    public List<Site> getListSites();
    public List<Site> getListSearchedSites(String search, String field);
}
