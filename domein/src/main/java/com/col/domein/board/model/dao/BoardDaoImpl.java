package com.col.domein.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.col.domein.board.model.vo.BoardKnowBattle;


@Repository
public class BoardDaoImpl implements BoardDao{

	@Override
	public List<Map> selectBoardList(SqlSession session, int cPage, int numPerpage) {
		// TODO Auto-generated method stub
//		return session.selectList("board.selectBoardList",null,
//				new RowBounds((cPage-1)*numPerpage,numPerpage));
//		return session.selectList("board.selectBoardList", null,
//				new RowBounds(((cPage - 1) * numPerpage), numPerpage));
		return session.selectList("board.selectBoardList");
	}

	@Override
	public int selectCount(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("board.selectCount");
	}

	@Override
	public BoardKnowBattle selectBoardOne(SqlSession session, int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map> selectBkbArticles(SqlSession session, int threadKey) {
		// TODO Auto-generated method stub
		return session.selectList("board.selectBkbArticles",threadKey);
	}
	
	/*
	 * @Override public int insertBoard(SqlSession session, BoardKnowBattle board) {
	 * // TODO Auto-generated method stub return
	 * session.insert("board.insertBoard",board); }
	 */

}

