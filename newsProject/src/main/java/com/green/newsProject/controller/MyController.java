package com.green.newsProject.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.newsProject.entity.User;
import com.green.newsProject.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
//@RequestMapping("/")
public class MyController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/")
	public String root(Model model, HttpSession session) {

		return "index";
	}

	@RequestMapping("/registForm")
	public String registForm() {

		return "registForm";
	}

	@RequestMapping("/regist")
	public String regist(Model model, HttpServletRequest request) {

		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String role = request.getParameter("role");

		User user = User.builder().username(username).password1(password1).password2(password2).name(name).tel(tel)
				.addr(addr).role(role).created_at(LocalDateTime.now()).build();

		userRepository.save(user);

		return "loginForm";

	}

	@RequestMapping("/loginForm")
	public String loginForm() {

		return "loginForm";
	}

	@RequestMapping("/login")
	public String login(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User userResult = userRepository.findByUsernameAndPassword1(username, password);
		
		if(userResult != null) {
		log.info("username = " + username);
		log.info("password = " + password);
		System.out.println("username= " + username);
		System.out.println("password=" + password);

		
		String role = userResult.getRole();
		log.info("role = " + role);
		System.out.println("role=" + role );

		
		HttpSession session = request.getSession();
		session.setAttribute("id", username);
		session.setAttribute("role", role);
		
        return "redirect:/"; // 로그인 성공 후 리다이렉트할 페이지로 수정합니다.
        
    } else {
        redirectAttributes.addFlashAttribute("loginError", "Invalid username or password");
        return "redirect:/loginForm"; // 로그인 실패 시 다시 로그인 폼으로 리다이렉트합니다.
    }
		


	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {

		session.getAttribute("id");
		session.invalidate();
		// System.out.println("로그아웃 됨");
		return "redirect:/";
	}
	
	

	

}
