package com.col.domein.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.col.domein.board.model.vo.Attachment;
import com.col.domein.board.model.vo.Board;
import com.col.domein.product.model.vo.Attachement;

@Service
public interface BoardService {
	  
	List<Map> selectBoardList(int cPage, int numPerpage);
	List<Map> selectBkbArticles(int threadKey);
	int selectCount();
	Board selectBoardOne(int articleNo);
	int insertBoard(Board board,List<Attachment> files);

}
