package com.col.domein.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.col.domein.board.model.vo.Attachment;
import com.col.domein.board.model.vo.BoardKnowBattle;

@Service
public interface BoardService {
	  
	List<Map> selectBoardList(int cPage, int numPerpage);
	List<Map> selectBkbArticles(int threadKey);
	int selectCount();
	BoardKnowBattle selectBoardOne(int boardNo);
	int insertBoard(BoardKnowBattle board,List<Attachment> files);

}
