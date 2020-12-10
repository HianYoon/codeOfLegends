package com.col.domein.product.model.service;

import java.util.List;

import com.col.domein.product.model.vo.Attachement;
import com.col.domein.product.model.vo.Product;
import com.col.domein.product.model.vo.ProductBoardContent;

public interface ProductService {

	int insertProductFileList(Product p, ProductBoardContent pbc, List<Attachement> files);

}
