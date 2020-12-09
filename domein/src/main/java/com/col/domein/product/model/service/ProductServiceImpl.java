package com.col.domein.product.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.col.domein.product.model.dao.ProductDao;
import com.col.domein.product.model.vo.Attachement;
import com.col.domein.product.model.vo.Product;
import com.col.domein.product.model.vo.ProductBoardContent;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao dao;
	@Autowired
	SqlSession session;
	@Override
	public int insertProductFileList(Product p, ProductBoardContent pbc, List<Attachement> files) {
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
		System.out.printf("ArticleNo:",p.getArticleNo());
		if(result>0) {
			if(pbc !=null) {
				pbc.setArticleNo(p.getArticleNo());
				result=dao.insertProductContent(session,pbc);
			}
		}
		return result;
	}

}
