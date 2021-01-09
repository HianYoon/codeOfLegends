package com.col.domein;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.ads.model.service.AdsService;
import com.col.domein.ads.model.vo.BannerAds;
import com.col.domein.auction.model.service.AuctionService;
import com.col.domein.product.model.service.ProductService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	AdsService service;
	@Autowired
	AuctionService Aservice;
	@Autowired
	ProductService Pservice;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		Date day=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		String today=sdf.format(day);		
		System.out.println("오늘의 날짜: "+today);		
		List<BannerAds> accept=service.selectBannerAccept(today);
		JSONArray jAccept=JSONArray.fromObject(accept);
		
		for(BannerAds b:accept) {
			JSONObject jo=new JSONObject();
			jo.put("adsKey",b.getAdsKey());
			jo.put("applicantKey",b.getApplicantKey());			
			jo.put("adsRenamedFileName",b.getAdsRenamedFileName());			
			jo.put("urlLink",b.getUrlLink());			
			jo.put("adsTitle",b.getAdsTitle());			
			jAccept.add(jo);
		}
		List<Map> auction=Aservice.selectAuctionListAll();
		System.out.println(""+auction);
		List<Map> list=Pservice.selecProductListAll();
		System.out.println(""+list);
		mv.addObject("auction",auction);
		mv.addObject("list",list);

		mv.addObject("accept",jAccept);
		mv.setViewName("index");
		return mv;		
	}

	@RequestMapping("/error.do")
	public String error(Model model, @RequestParam(required = false) String msg,
			@RequestParam(required = false) String loc, @RequestParam(required = false) String locDesc) {
		if (msg != null && !msg.equals(""))
			model.addAttribute("msg", msg);
		if (loc != null && !loc.equals(""))
			model.addAttribute("loc", loc);
		if (locDesc != null && !locDesc.equals(""))
			model.addAttribute("locDesc", locDesc);
		else {
			locDesc = "돌아가기";
			model.addAttribute("locDesc", locDesc);
		}
		return "common/error";
	}
}
