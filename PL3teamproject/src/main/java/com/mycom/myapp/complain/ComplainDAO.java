package com.mycom.myapp.complain;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComplainDAO {
	
	@Autowired
	SqlSession sqlSession;

	public int insertComplain(ComplainVO vo) {	
		return sqlSession.insert("Complain.insertComplain",vo);
	}
	
	public int deleteComplain(int seq) {	
		return sqlSession.delete("Complain.deleteComplain",seq);
	}
	
	public int updateComplain(ComplainVO vo) {
		return sqlSession.update("Complain.updateComplain",vo);
	}
	
	public ComplainVO getComplain(int seq) {
		return sqlSession.selectOne("Complain.getComplain",seq);
	}
	
	public List<ComplainVO> getComplainList() {
		return sqlSession.selectList("Complain.getComplainList");
	}
 }
