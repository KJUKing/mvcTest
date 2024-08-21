package kr.or.ddit.dao;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.vo.MemberVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MemberDaoImpl implements IMemberDao{
    @Override
    public int insertMember(MemberVO memVo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int cnt = 0; //반환값이 저장될 변수

        try {
            conn = DBUtil.getConnection();

            String sql = "insert into MYMEMBER" +
                    "(MEM_ID, MEM_PASS, MEM_NAME, MEM_TEL, MEM_ADDR) values(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memVo.getMem_id());
            pstmt.setString(2, memVo.getMeme_pass());
            pstmt.setString(3, memVo.getMem_name());
            pstmt.setString(4, memVo.getMem_tel());
            pstmt.setString(5, memVo.getMem_addr());
            cnt = pstmt.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (pstmt != null) try {
                pstmt.close();
            } catch (SQLException e) {
            };
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            };
        }

        return cnt;
    }

    @Override
    public int deleteMember(String memId) {
        Connection  conn = null;
        PreparedStatement pstmt = null;
        int cnt = 0;

        try {
            conn = DBUtil.getConnection();
            String sql = "delete from MYMEMBER where MEM_ID = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memId);

            cnt = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (pstmt != null) try {
                pstmt.close();
            } catch (SQLException e) {
            };
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            };
        }

        return cnt;
    }

    @Override
    public int updateMember(MemberVO memVo) {

        Connection  conn = null;
        PreparedStatement pstmt = null;
        int cnt = 0;

        try {
            conn = DBUtil.getConnection();
            String sql = "update mymember set mem_pass=?, " +
                    " mem_name=?, mem_tel=?, mem_addr=? " +
                    "where MEM_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memVo.getMeme_pass());
            pstmt.setString(2, memVo.getMem_name());
            pstmt.setString(3, memVo.getMem_tel());
            pstmt.setString(4, memVo.getMem_addr());
            pstmt.setString(5, memVo.getMem_id());
            cnt = pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (pstmt != null) try {
                pstmt.close();
            } catch (SQLException e) {
            };
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            };
        }

        return cnt;
    }

    @Override
    public List<MemberVO> getAllMember() {
        Connection  conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<MemberVO> memberList = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "select * from MYMEMBER";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            memberList = new ArrayList<>();
            while (rs.next()) {
                MemberVO memVo = new MemberVO();
                memVo.setMem_id(rs.getString("MEM_ID"));
                memVo.setMeme_pass(rs.getString("MEM_PASS"));
                memVo.setMem_name(rs.getString("MEM_NAME"));
                memVo.setMem_tel(rs.getString("MEM_TEL"));
                memVo.setMem_addr(rs.getString("MEM_ADDR"));
                memberList.add(memVo);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            };
            if (pstmt != null) try {
                pstmt.close();
            } catch (SQLException e) {
            };
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            };
        }
        return memberList;
    }

    @Override
    public int getMemberIdCount(String memId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0; // 반환값 변수

        try {
            conn = DBUtil.getConnection();

            String sql = "select count(*) cnt from MYMEMBER where mem_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt("cnt");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            };
            if (pstmt != null) try {
                pstmt.close();
            } catch (SQLException e) {
            };
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            };
        }

        return count;
    }

    @Override
    public int updateMemberV2(Map<String, String> paramMap) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int cnt = 0;
        try {

            conn = DBUtil.getConnection();
            String sql = "update mymember set " + paramMap.get("FIELD") + " = ? where MEM_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, paramMap.get("DATA"));
            pstmt.setString(2, paramMap.get("MEMID"));
            cnt = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (pstmt != null) try {
                pstmt.close();
            } catch (SQLException e) {
            };
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            };
        }

        return cnt;
    }

}
