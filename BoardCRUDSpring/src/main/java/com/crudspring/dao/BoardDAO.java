package com.crudspring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.crudspring.bean.BoardVO;

@Repository
public class BoardDAO {
	
	@Autowired
	JdbcTemplate template;

	public int insertBoard(BoardVO vo) {
		String sql = "insert into BOARD (title, writer, content, category) values ('"
				+ vo.getTitle() +"','"+ vo.getWriter()+ "','"+ vo.getContent()+ "','"+ vo.getCategory()+ "')";
		return template.update(sql);
	}
	
	public int deleteBoard(int seq) {
		String sql = "delete from BOARD where seq="+ seq;
		return template.update(sql);
	}
	
	public int updateBoard(BoardVO vo) {
		String sql = "update BOARD set title ='" + vo.getTitle() +"', writer='"+ vo.getWriter()+ 
				"', content='"+ vo.getContent()+ "', category='"+ vo.getCategory() + "' where seq=" +vo.getSeq();
		//System.out.println(sql);
		return template.update(sql);
	}

	class BoardRowMapper implements RowMapper<BoardVO>{
		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException{
			BoardVO vo = new BoardVO();
			vo.setSeq(rs.getInt("seq"));
			vo.setTitle(rs.getString("title"));
			vo.setContent(rs.getString("content"));
			vo.setWriter(rs.getString("writer"));
			vo.setCategory(rs.getString("category"));
			vo.setRegdate(rs.getDate("regdate"));
			return vo;
		}
	}
	
	public BoardVO getBoard(int seq) {
		String sql = "select * from BOARD where seq=" + seq;
		return template.queryForObject(sql, new BoardRowMapper());
	}
	
	public List<BoardVO> getBoardList(){
		String sql = "select * from BOARD order by regdate desc";
		return template.query(sql, new BoardRowMapper());
	}
	
//	private final String BOARD_INSERT = "insert into BOARD (title, writer, content, category) values (?,?,?,?)";
//	private final String BOARD_UPDATE = "update BOARD set title=?, writer=?, content=?, category=? where seq=?";
//	private final String BOARD_DELETE = "delete from BOARD  where seq=?";
//	private final String BOARD_GET = "select * from BOARD  where seq=?";
//	private final String BOARD_LIST = "select * from BOARD order by seq desc";
//
//	// 글 삭제
//	public void deleteBoard(BoardVO vo) {
//		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BOARD_DELETE);
//			stmt.setInt(1, vo.getSeq());
//			stmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	public int updateBoard(BoardVO vo) {
//		System.out.println("===> JDBC로 updateBoard() 기능 처리");
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BOARD_UPDATE);
//			stmt.setString(1, vo.getTitle());
//			stmt.setString(2, vo.getWriter());
//			stmt.setString(3, vo.getContent());
//			stmt.setString(4, vo.getCategory());
//			stmt.setInt(5, vo.getSeq());
//			
//			
//			System.out.println(vo.getTitle() + "-" + vo.getWriter() + "-" + vo.getContent() + "-" + vo.getCategory());
//			stmt.executeUpdate();
//			return 1;
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}	
//	
//	public BoardVO getBoard(int seq) {
//		BoardVO one = new BoardVO();
//		System.out.println("===> JDBC로 getBoard() 기능 처리");
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BOARD_GET);
//			stmt.setInt(1, seq);
//			rs = stmt.executeQuery();
//			if(rs.next()) {
//				one.setSeq(rs.getInt("seq"));
//				one.setCategory(rs.getString("category"));
//				one.setTitle(rs.getString("title"));
//				one.setWriter(rs.getString("writer"));
//				one.setContent(rs.getString("content"));
//				one.setCnt(rs.getInt("cnt"));
//			}
//			rs.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return one;
//	}
//	
//	public List<BoardVO> getBoardList(){
//		List<BoardVO> list = new ArrayList<BoardVO>();
//		System.out.println("===> JDBC로 getBoardList() 기능 처리");
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BOARD_LIST);
//			rs = stmt.executeQuery();
//			while(rs.next()) {
//				BoardVO one = new BoardVO();
//				one.setSeq(rs.getInt("seq"));
//				one.setCategory(rs.getString("category"));
//				one.setTitle(rs.getString("title"));
//				one.setWriter(rs.getString("writer"));
//				one.setContent(rs.getString("content"));
//				one.setRegdate(rs.getDate("regdate"));
//				one.setCnt(rs.getInt("cnt"));
//				list.add(one);
//			}
//			rs.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//		return list;
//	}
}
