package com.col.domein.product.model.service;

import java.util.List;

import com.col.domein.product.model.vo.Attachement;
import com.col.domein.product.model.vo.Product;

public interface ProductService {

	int insertProductFileList(Product p, List<Attachement> files);

}
