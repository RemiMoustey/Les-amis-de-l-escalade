package org.projet6.escalade.consumer.impl.rowmapper;

import org.projet6.escalade.model.bean.member.Member;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class MemberMapper implements RowMapper<Member> {
    public Member mapRow(ResultSet pRS, int pRowNum) throws SQLException {
        Member vMember = new Member(pRS.getInt("id"));
        vMember.setLogin(pRS.getString("login"));
        vMember.setPassword(pRS.getString("password"));
        vMember.setEmail(pRS.getString("email"));
        vMember.setPhoneNumber(pRS.getString("phoneNumber"));
        vMember.setAdmin(pRS.getBoolean("isAdmin"));

        return vMember;
    }
}
