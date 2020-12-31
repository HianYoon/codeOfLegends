package com.col.domein.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.col.domein.board.model.dao.BoardDao;

@Service
public interface BoardDao {

	List<Map> selectBoardList(SqlSession session,int cpage, int numPerpage);
	int selectCount(SqlSession session);
}
