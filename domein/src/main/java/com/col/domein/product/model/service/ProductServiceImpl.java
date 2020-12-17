package com.col.domein.product.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.col.domein.product.model.dao.ProductDao;
import com.col.domein.product.model.vo.Attachement;
import com.col.domein.product.model.vo.BoardProductSaleContent;
import com.col.domein.product.model.vo.Product;
import com.col.domein.product.model.vo.ProductAll;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao dao;
	@Autowired
	SqlSession session;
	@Override
	public int insertProductFileList(
			Product p, List<Attachement> files) {
		// TODO Auto-generated method stub
		int result=dao.insertProduct(session,p);
		//mapper-insert값을 받아서 
	
		System.out.printf("ProductNo:",p.getProductNo());
		if(result>0) {
			if(files !=null) {
				for(Attachement a: files) {
					a.setProductNo(p.getProductNo());
					//for(int i=0; i<files.size();i++) {
					//	int no=++i;
					//	System.out.println("번호"+no);
					//	a.setProductImageNo(no);
					//	System.out.println("파일번호:"+a.getProductImageNo());
				//	}
					result=dao.insertAttachment(session,a);
				}
			}
		}
		return result;
	}
	
	//BoardSaleContent
	@Override
	public int insertBoardSContent(BoardProductSaleContent bp) {
		// TODO Auto-generated method stub
		int result=dao.insertBoardSContent(session,bp);
		return result ;
	}

	
	//상품list
	@Override
	public List<Map> selectProductList(int cPage, int numPerpage) {
		// TODO Auto-generated method stub
		
		return dao.selectProductList(session,cPage,numPerpage);
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return dao.selectCount(session);
	}

	@Override
	public List<Map> selectProductDetail(int productNo) {
		// TODO Auto-generated method stub
		return dao.selectProductDetail(session,productNo);
	}


	
}
