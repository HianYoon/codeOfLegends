package com.col.domein.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.col.domein.board.model.vo.Attachment;
import com.col.domein.board.model.vo.Board;


@Repository
public class BoardDaoImpl implements BoardDao{

	@Override
	public List<Map> selectBoardList(SqlSession session, int cPage, int numPerpage) {
		// TODO Auto-generated method stub
		return session.selectList("community.selectBoardList",null,
				new RowBounds((cPage-1)*numPerpage,numPerpage));
	}

	@Override
	public int selectCount(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("community.selectCount");
	}

	@Override
	public Board selectBoardOne(SqlSession session, int boardNo) {
		// TODO Auto-generated method stub
		return session.selectOne("community.selectBoardOne",boardNo);
	}

	@Override
	public int insertBoard(SqlSession session, Attachment a) {
		// TODO Auto-generated method stub
		return session.insert("community.insertAttachment", a);
	}

	@Override
	public int insertBoard(SqlSession session, Board board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAttachment(SqlSession session, Attachment a) {
		// TODO Auto-generated method stub
		return 0;
	}

}

