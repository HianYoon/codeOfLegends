package com.col.domein.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.col.domein.board.model.vo.Attachment;
import com.col.domein.board.model.vo.Board;
import com.col.domein.board.model.vo.BoardKnowBattle;


@Repository
public class BoardDaoImpl implements BoardDao{

	/*
	 * @Override public List<Map> selectBoardList(SqlSession session, int cPage, int
	 * numPerpage) { // TODO Auto-generated method stub return
	 * session.selectList("community.selectBoardList",null, new
	 * RowBounds((cPage-1)*numPerpage,numPerpage)); // return
	 * session.selectList("board.selectBoardList",null, // new
	 * RowBounds((cPage-1)*numPerpage,numPerpage)); // return
	 * session.selectList("board.selectBoardList", null, // new RowBounds(((cPage -
	 * 1) * numPerpage), numPerpage)); return
	 * session.selectList("board.selectBoardList"); }
	 */

	@Override
	public int selectCount(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("board.selectCount");
	}

	/*
	 * @Override public Board selectBoardOne(SqlSession session, int boardNo) { //
	 * TODO Auto-generated method stub return
	 * session.selectOne("community.selectBoardOne",boardNo); }
	 */

	@Override
	public int insertBoard(SqlSession session, Board board) {
		// TODO Auto-generated method stub
		return session.insert("board.insertBoard",board);
	}

	@Override
	public int insertAttachment(SqlSession session, Attachment a) {
		// TODO Auto-generated method stub
		return session.insert("board.insertAttachment",a);
	}

	public List<Map> selectBkbArticles(SqlSession session, int threadKey) {
		// TODO Auto-generated method stub
		return session.selectList("board.selectBkbArticles",threadKey);
	}

	@Override
	public List<Map> selectBoardList(SqlSession session, int cpage, int numPerpage) {
		// TODO Auto-generated method stub
		return null;
		/*
		 * return session.selectList("board.selectBoardList",null, new
		 * RowBounds((cPage-1)*numPerpage,numPerpage));
		 */
	}

	@Override
	public BoardKnowBattle selectBoardOne(SqlSession session, int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * @Override public int insertBoard(SqlSession session, BoardKnowBattle board) {
	 * // TODO Auto-generated method stub return
	 * session.insert("board.insertBoard",board); }
	 */

}

