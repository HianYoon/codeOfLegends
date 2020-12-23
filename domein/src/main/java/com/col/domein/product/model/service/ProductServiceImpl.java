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
					int fs=files.size();
					System.out.println("숫자몇이니"+fs);
					for(int i=1; i<fs;i++) {
						int no =i++;
						System.out.println("번호"+no);
						a.setProductImageNo(no);
						System.out.println("파일번호:"+a.getProductImageNo());
					}
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
	public List<Map> selectProductDetail(int articleNo) {
		// TODO Auto-generated method stub
		return dao.selectProductDetail(session,articleNo);
	}
	
	//내상품조회
	@Override
	public List<Map> selectProductUpdate(int businessKey) {
		// TODO Auto-generated method stub
		return dao.selectProductUpdate(session,businessKey);
	}
	//내상품선택시

	@Override
	public List<Map> selectProductOne(int articleNo) {
		// TODO Auto-generated method stub
		return dao.selectProductOne(session,articleNo);
	}
	//상품삭제
	@Override
	public int productDelete(int articleNo) {
		// TODO Auto-generated method stub
		return dao.DeleteProduct(session,articleNo);
	}

	@Override
	public int updateBDS(ProductAll p) {
		// TODO Auto-generated method stub
		return dao.updateBDS(session,p);
	}
//상품 PDS 수정
	@Override
	public int updatePDS(ProductAll p,List<Attachement> files) {
	
		
		// TODO Auto-generated method stub
		int result=dao.updatePDS(session, p);
		if(result>0) {
			if(files !=null) {
				for(Attachement a: files) {
					a.setProductNo(p.getProductNo());
					int fs=files.size();
					System.out.println("숫자몇이니"+fs);
					for(int i=1; i<fs;i++) {
						int no =i++;
						System.out.println("번호"+no);
						a.setProductImageNo(no);
						System.out.println("파일번호:"+a.getProductImageNo());
					}
					result=dao.updateAttachment(session,a);
				}
			}
		}
		return result;
	}

	@Override
	public List<Map> selectProductByBusinessKey(int businessKey) {
		// TODO Auto-generated method stub
		return dao.selectProductByBusinessKey(session,businessKey);
	}	
	
	
}
