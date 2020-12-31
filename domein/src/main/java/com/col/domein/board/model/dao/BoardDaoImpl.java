package com.col.domein.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao{

	/*
	 * @Autowired private SqlSessionTemplate sqlSession;
	 * 
	 * @Override public List<Map<String, Object>> list(Map<String, Object> map) { //
	 * TODO Auto-generated method stub return sqlSession.selectList("mapper.list",
	 * map); }
	 * 
	 * @Override public List<Map> selectBoardList(SqlSession session, int cPage, int
	 * numPerpage) { // TODO Auto-generated method stub return
	 * session.selectList("board.selectBoardList",null, new
	 * RowBounds((cPage-1)*numPerpage,numPerpage)); }
	 */

	
	/*
	 * public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
	 * 
	 * return (List<Map<String,Object>>)selectList("board.selectBoardList", map); }
	 */
	/*
	 * public List<Board> getBoardList() { return
	 * sqlSession.selectList("getBoardList"); }
	 */
	/* public list */
}

