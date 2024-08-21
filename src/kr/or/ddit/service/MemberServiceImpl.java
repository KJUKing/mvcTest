package kr.or.ddit.service;

import kr.or.ddit.dao.IMemberDao;
import kr.or.ddit.dao.MemberDaoImpl;
import kr.or.ddit.vo.MemberVO;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MemberServiceImpl implements IMemberService{

    private IMemberDao dao;

    public MemberServiceImpl() {
        dao = new MemberDaoImpl();
    }
    @Override
    public int insertMember(MemberVO memVo) {
        return dao.insertMember(memVo);
    }

    @Override
    public int deleteMember(String memId) {
        return dao.deleteMember(memId);
    }

    @Override
    public int updateMember(MemberVO memVo) {
        return dao.updateMember(memVo);
    }

    @Override
    public List<MemberVO> getAllMember() {
        return dao.getAllMember();
    }

    @Override
    public int getMemberIdCount(String memId) {
        return dao.getMemberIdCount(memId);
    }

    @Override
    public int updateMemberV2(Map<String, String> paramMap) {
        return dao.updateMemberV2(paramMap);
    }
}
