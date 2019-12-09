package org.projet6.escalade.consumer.contract.dao;

import org.projet6.escalade.model.bean.member.Member;

import java.util.List;

public interface MemberDao {
    public List<Member> getListMembers();
    public void insertMember(Member pMember);
    public Member getConnectedMember(String login, String password);
    public Member selectOneMemberById(int memberId);
}
