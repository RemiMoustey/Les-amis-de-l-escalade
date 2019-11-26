package org.projet6.escalade.consumer.contract.dao;

import org.projet6.escalade.model.bean.member.Member;

import java.util.List;

public interface MemberDao {
    public void insertMember(Member pMember);
    public List<Member> getConnectedMember(String login, String password);
    public void connectMember(Member pMember);
}
