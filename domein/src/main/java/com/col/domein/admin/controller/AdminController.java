package com.col.domein.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.col.domein.common.pageBar.PageBarFactory;
import com.col.domein.member.model.service.MemberService;
import com.col.domein.member.model.vo.Member;
import com.col.domein.product.model.service.ProductService;

@Controller
public class AdminController {

	@Autowired
	private MemberService ms;
	
	@Autowired
	private ProductService ps;
	
	
	@RequestMapping("admin/userList.do")
	public String searchUser(Model m,@RequestParam(value="cPage",defaultValue="1")int cPage,
			@RequestParam(value="numPerpage",defaultValue="10")int numPerpage) {
		
		List<Map> list = ms.selectMemberList(cPage,numPerpage);
		int totalData = ms.selectMemberCount();
		m.addAttribute("list",list);
		m.addAttribute("totalData",totalData);
		m.addAttribute("pageBar",PageBarFactory.getPageBar(totalData, cPage, numPerpage, "userList.do"));
		return "admin/user/searchUser";
	}
	
	@RequestMapping("admin/userInfo.do")
	public String userInfo(Model m, int memberKey, int businessKey) {
		
		
		Member member = ms.selectMemberByMemberKey(memberKey);
		m.addAttribute("m",member);
		m.addAttribute("businessKey",businessKey);
		m.addAttribute("productList",ps.selectProductByBusinessKey(businessKey));
		return "admin/user/userInfo";
	}
	
	@RequestMapping("admin/searchUser.do")
	public String searchUser(Model m, String keyword, String searchOption) {
		
		
		List<Map> list = ms.searchUser(keyword,searchOption);
		String option = searchOption;
		m.addAttribute("list",list);
		m.addAttribute("option",option);
		return "admin/user/searchUser";
		
	}
	
	@RequestMapping("admin/blindArticle.do")
	public String blindArticle(Model m, int productNo, int memberKey,int businessKey, String businessNo,int status) {
		//ARTICLE_STATUS_NO = 0 : 중지
		//ARTICLE_STATUS_NO = 1 : 정상
		//ARTICLE_STATUS_NO = 3 : 블라인드
		//ARTICLE_STATUS_NO = 9 : 삭제
		int result = ps.blindProduct(productNo,status);
		Member member = ms.selectMemberByMemberKey(memberKey);
		m.addAttribute("m",member);
		m.addAttribute("businessKey",businessKey);
		m.addAttribute("businessNo",businessNo);
		m.addAttribute("productList",ps.selectProductByBusinessKey(businessKey));
		
		return "admin/user/userInfo";
	}
	@RequestMapping("article/blindArticle.do")
	public String blindArticle(Model m, int productNo,int status,@RequestParam(value="cPage",defaultValue="1")int cPage,
			@RequestParam(value="numPerpage",defaultValue="10")int numPerpage) {
		//ARTICLE_STATUS_NO = 0 : 중지
		//ARTICLE_STATUS_NO = 1 : 정상
		//ARTICLE_STATUS_NO = 3 : 블라인드
		//ARTICLE_STATUS_NO = 9 : 삭제
		int result = ps.blindProduct(productNo,status);
		int totalData = ps.selectCount();
		List<Map> productList = ps.selectProductList(cPage, numPerpage);
		
		m.addAttribute("productList",productList);
		m.addAttribute("pageBar",PageBarFactory.getPageBar(totalData, cPage, numPerpage, "articleList.do"));
		return "admin/article/articleList";
	}
	//게시글 ======================================================================
	@RequestMapping("admin/articleList.do")
	public String articleList(Model m,@RequestParam(value="cPage",defaultValue="1")int cPage,
			@RequestParam(value="numPerpage",defaultValue="10")int numPerpage) {
		int totalData = ps.selectCount();
		List<Map> productList = ps.selectProductList(cPage, numPerpage);
		
		m.addAttribute("productList",productList);
		m.addAttribute("pageBar",PageBarFactory.getPageBar(totalData, cPage, numPerpage, "articleList.do"));
		return "admin/article/articleList";
	}
	@RequestMapping("admin/deleteArticle.do")
	public String deleteArticleArticle(Model m, int productNo,int status,@RequestParam(value="cPage",defaultValue="1")int cPage,
			@RequestParam(value="numPerpage",defaultValue="10")int numPerpage) {
		//ARTICLE_STATUS_NO = 0 : 중지
		//ARTICLE_STATUS_NO = 1 : 정상
		//ARTICLE_STATUS_NO = 3 : 블라인드
		//ARTICLE_STATUS_NO = 9 : 삭제
		int result = ps.blindProduct(productNo,status);
		int totalData = ps.selectCount();
		List<Map> productList = ps.selectProductList(cPage, numPerpage);
		
		m.addAttribute("productList",productList);
		m.addAttribute("pageBar",PageBarFactory.getPageBar(totalData, cPage, numPerpage, "articleList.do"));
		return "admin/article/articleList";
	}
}
