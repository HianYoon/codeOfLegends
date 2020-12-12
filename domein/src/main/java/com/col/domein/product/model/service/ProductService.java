package com.col.domein.product.model.service;

import java.util.List;

import com.col.domein.product.model.vo.Attachement;
import com.col.domein.product.model.vo.BoardProductSaleContent;
import com.col.domein.product.model.vo.Product;

public interface ProductService {

	




	//boardSaleContent
	int insertBoardSContent(BoardProductSaleContent bp);
	//product && files
	int insertProductFileList(Product p, List<Attachement> files);

}
