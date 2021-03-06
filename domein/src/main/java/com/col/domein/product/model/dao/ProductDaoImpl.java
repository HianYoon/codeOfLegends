package com.col.domein.product.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.col.domein.business.model.vo.Business;
import com.col.domein.common.crteria.SearchCriteria;
import com.col.domein.product.model.vo.Attachement;
import com.col.domein.product.model.vo.BoardProductSaleContent;
import com.col.domein.product.model.vo.Product;
import com.col.domein.product.model.vo.ProductAll;

@Repository
public class ProductDaoImpl implements ProductDao {

	//상품 등록 
	@Override
	public int insertProduct(SqlSession session,Product p ) {
		// TODO Auto-generated method stub
		return session.insert("product.insertProduct",p);
	}

	@Override
	public int insertBoardSContent(SqlSession session, BoardProductSaleContent bp) {
		// TODO Auto-generated method stub
		return session.insert("product.insertBoardSContent",bp);
	}
	//파일등록 맵핑값에 주의하자 
	@Override
	public int insertAttachment(SqlSession session, Attachement a) {
		// TODO Auto-generated method stub
		return session.insert("product.insertAttachement",a);
	}
	//상품list
	@Override
	public List<Map> selectProductList(SqlSession session, int cPage, int numPerpage) {
		// TODO Auto-generated method stub
		return session.selectList("product.selectProductList",null,
				new RowBounds((cPage-1)*numPerpage,numPerpage));
	}

	//총상품
	@Override
	public int selectCount(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("product.selectCount");
	}
	//상품detail페이지
	@Override
	public List<Map> selectProductDetail(SqlSession session, int articleNo) {
		// TODO Auto-generated method stub
		return session.selectList("product.selectProductDetail",articleNo);
	}
	//내상품조회
	@Override
	public List<Map> selectProductUpdate(SqlSession session, int businessKey) {
		// TODO Auto-generated method stub
		return session.selectList("product.selectProductMylist",businessKey);
	}
	//내상품 수정버튼 클릭시 불러오기
	@Override
	public List<Map> selectProductOne(SqlSession session, int articleNo) {
		// TODO Auto-generated method stub
		return session.selectList("product.selectProductOne",articleNo);
	}
	//상품삭제
	@Override
	public int deleteProduct(SqlSession session, int articleNo) {
		// TODO Auto-generated method stub
		return session.delete("product.deleteProductOne",articleNo);
	}
	//updateBDS
	@Override
	public int updateBDS(SqlSession session,ProductAll p) {
		// TODO Auto-generated method stub
		return session.update("product.updateBDS",p);
	}
	//상품수정PDS
	@Override
	public int updatePDS(SqlSession session, ProductAll p) {
		// TODO Auto-generated method stub
		System.out.println(""+p);
		return session.update("product.updatePDS",p);
	}
	//상품파일수정

	@Override
	public int updateAttachment(SqlSession session, Attachement a) {
		// TODO Auto-generated method stub
		return session.update("product.updateFiles",a);
	}

	@Override
	public List<Map> selectProductByBusinessKey(SqlSession session, int businessKey) {
		// TODO Auto-generated method stub
		return session.selectList("product.selectProductByBusinessKey",businessKey);
	}
	//검색기능

	@Override
	public List<Map> searchListAll(SqlSession session, SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("product.searchListAll",scri);
	}
	//조회게시물 갯수
	@Override
	public int searchListCount(SqlSession session, SearchCriteria scri) {
		// TODO Auto-generated method stub
		return session.selectOne("product.searchListCount",scri);
	}

	@Override
	public int blindProduct(SqlSession session, int productNo,int status) {
		// TODO Auto-generated method stub
		Map<String,Integer> map = new HashMap();
		map.put("productNo",productNo);
		map.put("status", status);
		return session.update("product.blindProduct",map);
	}

	@Override
	public int updateProductStatusToStoppedByArticleNo(SqlSession session, int articleNo) {
		// TODO Auto-generated method stub
		return session.update("product.updateProductStatusToStoppedByArticleNo", articleNo);
	}

	@Override
	public int updateSaleStatusToStoppedByBusinessKey(SqlSession session, int businessKey) {
		// TODO Auto-generated method stub
		return session.update("product.updateSaleStatusToStoppedByBusinessKey", businessKey);
	}

	@Override
	public int updateBidStatusToStoppedByBusinessKey(SqlSession session, int businessKey) {
		// TODO Auto-generated method stub
		return session.update("product.updateBidStatusToStoppedByBusinessKey", businessKey);
	}

	@Override
	public int updateAuctionStatusToStoppedByBusinessKey(SqlSession session, int businessKey) {
		// TODO Auto-generated method stub
		return session.update("product.updateAuctionStatusToStoppedByBusinessKey",businessKey);
	}

	@Override
	public List<Map> searchArticle(SqlSession session, String keyword, String searchOption) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap();
		map.put("keyword",keyword);
		map.put("searchOption",searchOption);
		return session.selectList("product.searchArticle",map);
	}
	//business키 불러오기
	@Override
	public List<Map> selectBusinessOne(SqlSession session, int memberKey) {
		// TODO Auto-generated method stub
		return session.selectList("product.selectBusinessOne",memberKey);
	}
	//index 페이지 
	@Override
	public List<Map> selecProductListAll(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectList("product.selecProductListAll");
	}

	@Override
	public int seselectArticleNo(SqlSession session, int articleNo) {
		// TODO Auto-generated method stub
		return session.selectOne("product.seselectArticleNo",articleNo);
	}
	
	
	
}
