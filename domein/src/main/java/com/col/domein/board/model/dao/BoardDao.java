package com.col.domein.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.col.domein.board.model.vo.Attachment;
import com.col.domein.board.model.vo.Board;
import com.col.domein.board.model.vo.BoardKnowBattle;

@Service
public interface BoardDao {

	List<Map> selectBoardList(SqlSession session,int cpage, int numPerpage);
	
	int selectCount(SqlSession session);
	
	/* Board selectBoardOne(SqlSession session,int boardNo); */
	
	int insertBoard(SqlSession session, Board board);

	int insertAttachment(SqlSession session, Attachment a);

	List<Map> selectBkbArticles(SqlSession session,int threadKey);

	BoardKnowBattle selectBoardOne(SqlSession session,int boardNo);
	
}
