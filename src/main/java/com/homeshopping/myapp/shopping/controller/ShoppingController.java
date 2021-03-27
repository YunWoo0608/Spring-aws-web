package com.homeshopping.myapp.shopping.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.homeshopping.myapp.shopping.model.customer.Customer_VO;
import com.homeshopping.myapp.shopping.model.login.Login_VO;
import com.homeshopping.myapp.shopping.model.pay.Pay_VO;
import com.homeshopping.myapp.shopping.model.product.Product_Detail_VO;
import com.homeshopping.myapp.shopping.model.product.Product_VO;
import com.homeshopping.myapp.shopping.service.customer.Customer_Service;
import com.homeshopping.myapp.shopping.service.login.Login_Service;
import com.homeshopping.myapp.shopping.service.product.Product_Service;
import com.homeshopping.myapp.shopping.service.utils.ScriptsUtils;
import com.homeshopping.myapp.shopping.service.pay.Pay_Service;


@Controller
public class ShoppingController {
	@Autowired
	Login_Service login_Service;
	@Autowired
	Product_Service pro_Service;
	@Autowired 
	Pay_Service pay_Service;
	@Autowired
	Customer_Service cust_Service;
	
	private static final Logger logger = LoggerFactory.getLogger(ShoppingController.class);
	
	@RequestMapping(value = "/")
	public String main(Locale locale, Model model) {
		
		//product_service : 상품 리스트 나열
		model.addAttribute("prolist",pro_Service.getAllList());
		
		return "main";
	}
	
	/* ############################################################
	 * ####################	     로그인 로직	#######################
	 * ############################################################*/
	@RequestMapping(value = "/login")
	public String login(HttpSession session, Model model) {
		
		return "Login/login";
	}
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session, HttpServletResponse response ,Model model) throws IOException {
		
		session.removeAttribute("sID");
		
		ScriptsUtils.alertAndMovePage(response, "로그아웃 됐습니다.", "/");
		return null;
	}
		
	@RequestMapping(value = "/login_do")
	public String login_do(Login_VO login,HttpSession session, HttpServletResponse response,  Model model) throws IOException {
		
		String UserID = login.getsID();
		System.out.println(UserID);
		
		//해당 로그인 정보 조회 ( 일치 , 불일치)
		String type = login_Service.Check_User(UserID);
		
		//성공이면 main으로
		if( type == null ) {
			//존재하지 않는 ID, 틀린 ID 비번이면 login 페이지로 다시
			ScriptsUtils.alertAndMovePage(response, "없거나 잘못된 ID 비번입니다.","/login");
			return null;
		}
		if(type == "admin") {
			//세션에 로그인 값 설정 (관리자의 경우 따로 세션설정을 하는게 좋아보임)
			session.setAttribute("sID", UserID);
			return "Admin/admin_page";
		}else if(type == "cust") {
			//세션에 로그인 값 설정
			session.setAttribute("sID", UserID);
		}

		return "redirect:/";
	}
	
	/* ############################################################
	 * ####################	     상품 로직		#######################
	 * ############################################################*/

	@RequestMapping(value = "/product_detail")
	public String product_detail(HttpServletRequest request, Model model) {
		
		//상품 번호받아오기
		int pr_no = Integer.parseInt(request.getParameter("pr_no"));
		
		//테스트
		System.out.println("Product_detail-상품 번호 받기 : " + pr_no);
		Product_VO pr_vo = pro_Service.getProInfo(pr_no);
		//상품 상세 정보 넘겨주기
		model.addAttribute("pr_vo", pr_vo);
		request.setAttribute("pr_stock_num", pr_vo.getPr_stock_num());
		return "Product/product_detail";
	}
	
	@RequestMapping(value = "/product_detail_do")
	public String product_detail_do(Product_Detail_VO vo,HttpSession session, HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
		
		//로그인했는지 확인
		String custid = (String)session.getAttribute("sID");
		
		if(custid == null) {
			ScriptsUtils.alertAndMovePage(response, "로그인 후 결제 해주세요.", "login");
			return null;
		}
		//결제 계산하기 (물건 값 * 개수)
		Product_VO pr_vo = pro_Service.getProInfo(vo.getPr_no());
		//고객 정보 넘겨주기
		Customer_VO cust_vo = cust_Service.getCustInfo(custid);
		int total = pr_vo.getPr_price() * vo.getCount();
		
		//결제 성공 시 해당 개수 만큼 물건 재고 를 깎야아하므로 세션에 유지시킬 필요가있다.
		//결제 끝나고 세션을 없앤다.
		session.setAttribute("pro_count", vo.getCount());
		//테스트
		System.out.println("Product_detail_do total: " + total);
		
		model.addAttribute("totalPrice", total);
		model.addAttribute("pr_vo", pr_vo);
		model.addAttribute("cust_vo",cust_vo);
		
		return "Pay/pay_test";
	}
	
	
	/* ############################################################
	 * ####################	     결제 로직		#######################
	 * ############################################################*/
	@RequestMapping(value = "/pay_success")
	public String pay_success(HttpSession session, HttpServletResponse response, HttpServletRequest request, Model model) throws IOException, SQLException {
		
		//결제 성공이면 새로운 결제 생성.
		//결제에 필요한 정보 : 고객, 상품, 결제(결제모듈 결과값)
		int c_no = Integer.parseInt(request.getParameter("c_no"));
		int pr_no = Integer.parseInt(request.getParameter("pr_no"));
		int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
		
		//결재 객체 생성
		Pay_VO pay = new Pay_VO();
		pay.setPay_applynum(request.getParameter("apply_num"));
		pay.setPay_paidamount(request.getParameter("paid_amount"));
		pay.setPay_impuid(request.getParameter("imp_uid"));
		pay.setPay_merchant(request.getParameter("merchant_uid"));
		pay.setPay_price(totalPrice);
		
		//결제 생성
		pay_Service.newPay(c_no, pr_no, pay);
		
		//결제 완료 시 해당 상품의 재고 개수 -1
		//재고 정보 가져오기
		
		//산 물건 개수
		int pro_count = (int)session.getAttribute("pro_count");
		//테스트 
		System.out.println("pro_count : " + pro_count);
		int adjstock = pro_Service.getProInfo(pr_no).getPr_stock_num() - pro_count;
		pro_Service.updateStock(pr_no, adjstock);
		
		session.removeAttribute("pro_count");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/pay_list")
	public String pay_list(HttpSession session, HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
		
		String id = (String)session.getAttribute("sID");
		
		if(id == null) {
			ScriptsUtils.alertAndMovePage(response, "로그인 후 이용해주세요.", "/");
		}
		
		int cNO = cust_Service.getCustInfo(id).getC_no();
		List<Pay_VO> payList = pay_Service.showPayList(cNO);
		model.addAttribute("payList", payList);
		
		return "Pay/pay_list";
	}
	
	@RequestMapping(value = "/admin_page")
	public String admin_page(Locale locale, Model model) {
		
		return "Admin/admin_page";
	}
	
	@RequestMapping(value = "/admin_to_customer")
	public String admin_to_customer(Locale locale, Model model) {
		
		return "Admin/admin_to_customer";
	}
	
	@RequestMapping(value = "/admin_to_notice")
	public String admin_to_notice(Locale locale, Model model) {
		
		return "Admin/admin_to_notice";
	}
	
	
	@RequestMapping(value = "/admin_to_product")
	public String admin_to_product(Locale locale, Model model) {
		
		return "Admin/admin_to_product";
	}
	@RequestMapping(value = "/admin_to_pay")
	public String admin_to_pay(Locale locale, Model model) {
		
		return "Admin/admin_to_pay";
	}
	
}