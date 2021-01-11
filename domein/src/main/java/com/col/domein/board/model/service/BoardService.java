package com.col.domein.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.col.domein.board.model.vo.Attachment;
import com.col.domein.board.model.vo.Board;

@Service
public interface BoardService {
	  
	List<Map> selectBoardList(int cPage, int numPerpage);
	List<Map> selectBkbArticles(int threadKey);
	int selectCount();
	Board selectBoardOne(int threadKey);
	int insertBoard(Map map);
//	int insertBoard(Board board);
	List<Attachment> selectAttach(int threadKey);
	int insertArticle(Map map);

}
