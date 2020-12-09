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
		return dao.insertProduct(session,p,pbc);
	}

}
