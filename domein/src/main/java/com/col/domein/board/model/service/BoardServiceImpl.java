package com.col.domein.board.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.col.domein.board.model.dao.BoardDao;
import com.col.domein.board.model.vo.Attachment;
import com.col.domein.board.model.vo.Board;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao dao;
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Map> selectBoardList(int cPage, int numPerpage) {
		return dao.selectBoardList(session, numPerpage, numPerpage);
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return dao.selectCount(session);
	}

	@Override
	public int insertBoard(Board board, List<Attachment> files) {
		// TODO Auto-generated method stub
		/* return dao.insertBoard(session, board); */
		int result=dao.insertBoard(session,  board);
		if(result>0) {
			if(files!=null) {
				for(Attachment a:files) {
					result=dao.insertAttachment(session,a);
				}
			}
		}
		return result;
	}

	@Override
	public Board selectBoardOne(int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map> selectBkbArticles(int threadKey) {
		// TODO Auto-generated method stub
		return dao.selectBkbArticles(session,threadKey);
	}
}
