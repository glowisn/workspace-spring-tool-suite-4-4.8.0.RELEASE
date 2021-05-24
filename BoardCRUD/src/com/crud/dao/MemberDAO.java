package com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.crud.bean.MemberVO;
import com.crud.common.JDBCUtil;

public class MemberDAO {
	
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	private final String MEMBER_INSERT = "insert into member (userid, password, username, email, photo, detail) values (?,shal(?),?,?,?,?)";
	private final String MEMBER_UPDATE = "update member set username=?, email=?, photo=?, detail=? where seq=?";
	private final String MEMBER_DELETE = "delete from member  where sid=?";
	private final String MEMBER_SELECT = "select * from member  where sid=?";
	private final String MEMBER_LIST = "select * from member order by regdate desc";

	public int insertMember(MemberVO vo) {
		System.out.println("===> JDBC로 insertMember() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_INSERT);
			stmt.setString(1, vo.getUserid());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getUsername());
			stmt.setString(4, vo.getEmail());
			stmt.setString(5, vo.getPhoto());
			stmt.setString(6, vo.getDetail());
			stmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 글 삭제
	public void deleteMember(MemberVO vo) {
		System.out.println("===> JDBC로 deleteMember() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_DELETE);
			stmt.setInt(1, vo.getSid());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int updateMember(MemberVO vo) {
		System.out.println("===> JDBC로 updateMember() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_UPDATE);
			stmt.setString(1, vo.getUsername());
			stmt.setString(2, vo.getEmail());
			stmt.setString(3, vo.getPhoto());
			stmt.setString(4, vo.getDetail());
			stmt.setInt(5, vo.getSid());
			
			
			System.out.println(vo.getUsername() + "-" + vo.getEmail() + "-" + vo.getPhoto() + "-" + vo.getDetail());
			stmt.executeUpdate();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}	
	
	public MemberVO getMember(int seq) {
		MemberVO one = new MemberVO();
		System.out.println("===> JDBC로 getMember() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_SELECT);
			stmt.setInt(1, seq);
			rs = stmt.executeQuery();
			if(rs.next()) {
				one.setSid(rs.getInt("sid"));
				one.setUserid(rs.getString("userid"));
				one.setUsername(rs.getString("username"));
				one.setEmail(rs.getString("email"));
				one.setPhoto(rs.getString("photo"));
				one.setDetail(rs.getString("detail"));
				one.setRegdate(rs.getDate("regdate"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return one;
	}
	
	public ArrayList<MemberVO> getList(){
		ArrayList<MemberVO> list = null;
		System.out.println("===> JDBC로 getMemberList() 기능 처리");
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(MEMBER_LIST);
			rs = stmt.executeQuery();
			list = new ArrayList<MemberVO>();
			MemberVO one = new MemberVO();
			while(rs.next()) {
				one = new MemberVO();
				one.setSid(rs.getInt("sid"));
				one.setUserid(rs.getString("userid"));
				one.setUsername(rs.getString("username"));
				one.setEmail(rs.getString("email"));
				one.setRegdate(rs.getDate("regdate"));
				list.add(one);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
}
