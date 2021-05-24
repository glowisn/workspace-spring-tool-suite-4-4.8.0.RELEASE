package com.mycom.myapp.complain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplainServiceImpl{
	
	@Autowired
	ComplainDAO complainDAO;
	
	public int insertComplain(ComplainVO vo) {
		return complainDAO.insertComplain(vo);
	}
	
	public int deleteComplain(int seq) {
		return complainDAO.deleteComplain(seq);
	}
	
	public int updateComplain(ComplainVO vo) {
		return complainDAO.updateComplain(vo);
	}
	
	public ComplainVO getComplain(int seq) {
		return complainDAO.getComplain(seq);
	}
	
	public List<ComplainVO> getComplainList() {
		return complainDAO.getComplainList();
	}
}
