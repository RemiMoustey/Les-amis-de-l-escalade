package org.projet6.escalade.consumer.impl.dao;

import org.projet6.escalade.consumer.contract.dao.SiteDao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public abstract class AbstractDaoImpl {

    @Inject
    @Named("dataSource")
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Inject
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
