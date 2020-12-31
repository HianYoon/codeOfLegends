package com.col.domein.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


@Repository
public class BoardDaoImpl implements BoardDao{

	@Override
	public List<Map> selectBoardList(SqlSession session, int cPage, int numPerpage) {
		// TODO Auto-generated method stub
		return session.selectList("board.selectBoardList",null,
				new RowBounds((cPage-1)*numPerpage,numPerpage));
	}

	@Override
	public int selectCount(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("board.selectCount");
	}
	
	/*
	 * @Override public int insertBoard(SqlSession session, BoardKnowBattle board) {
	 * // TODO Auto-generated method stub return
	 * session.insert("board.insertBoard",board); }
	 */

}

