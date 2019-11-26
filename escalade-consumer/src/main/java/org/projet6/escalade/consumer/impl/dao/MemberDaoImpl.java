package org.projet6.escalade.consumer.impl.dao;

import org.apache.logging.log4j.Logger;
import org.projet6.escalade.consumer.contract.dao.MemberDao;
import org.projet6.escalade.model.bean.member.Member;
import org.projet6.escalade.model.bean.site.Site;
import org.springframework.dao.DuplicateKeyException;
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
public class MemberDaoImpl extends AbstractDaoImpl implements MemberDao {

    private Logger LOGGER;

    public void insertMember(Member pMember) {
        String vSQL = "INSERT INTO member (login, password, email, phoneNumber, address, postalCode, town) VALUES (:login, :password, :email, :phoneNumber, :address, :postalCode, :town)";

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(pMember);
        vParams.registerSqlType("login", Types.VARCHAR);
        vParams.registerSqlType("password", Types.VARCHAR);
        vParams.registerSqlType("email", Types.VARCHAR);
        vParams.registerSqlType("phoneNumber", Types.VARCHAR);
        vParams.registerSqlType("address", Types.LONGVARCHAR);
        vParams.registerSqlType("postalCode", Types.INTEGER);
        vParams.registerSqlType("town", Types.VARCHAR);

        try {
            vJdbcTemplate.update(vSQL, vParams);
        } catch (DuplicateKeyException vEx) {
            LOGGER.error("Le membre existe déjà ! id=" + pMember.getId(), vEx);
        }
    }

    public List<Member> getConnectedMember(String login, String password) {
        String vSQL = "SELECT * FROM member WHERE login = '" + login + "' AND password = '" + password + "'";

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        return vJdbcTemplate.query(vSQL, new MemberMapper());
    }

    private static final class MemberMapper implements RowMapper<Member> {
        public Member mapRow(ResultSet pRS, int pRowNum) throws SQLException {
            Member vMember = new Member(pRS.getInt("id"));
            vMember.setLogin(pRS.getString("login"));
            vMember.setPassword(pRS.getString("password"));
            vMember.setConnected(pRS.getBoolean("isConnected"));
            vMember.setEmail(pRS.getString("email"));
            vMember.setPhoneNumber(pRS.getString("phoneNumber"));

            return vMember;
        }
    }

    public void connectMember(Member pMember) {
        String vSQL = "UPDATE member SET isConnected = true WHERE id = :id";

        MapSqlParameterSource vParams = new MapSqlParameterSource().addValue("id", pMember.getId());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSQL, vParams);
    }
}
