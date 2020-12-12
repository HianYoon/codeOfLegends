package com.col.domein.product.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.col.domein.product.model.dao.ProductDao;
import com.col.domein.product.model.vo.Attachement;
import com.col.domein.product.model.vo.BoardProductSaleContent;
import com.col.domein.product.model.vo.Product;

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
					a.setProduct_No(p.getProductNo());
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


	

}
