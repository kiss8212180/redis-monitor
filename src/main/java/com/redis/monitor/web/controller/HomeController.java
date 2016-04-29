package com.redis.monitor.web.controller;

import com.redis.monitor.RedisCacheThreadLocal;
import com.redis.monitor.RedisInfoDetail;
import com.redis.monitor.entity.Operate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
public class HomeController extends BaseProfileController {

	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public ModelAndView index(HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		//TODO redis info信息加载
		List<RedisInfoDetail> rifList = redisManager.getRedisInfo();
		mv.addObject("rifList", rifList);

		//TODO redis memery加载

		//TODO redis keys加载

		//TODO redis slave log加载
		List<Operate> opList = redisManager.findAllOperateDetail();
		mv.addObject("opList", opList);

		Cookie cookie = new Cookie("uuid", RedisCacheThreadLocal.getUuid());
		response.addCookie(cookie);
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "/chartMemery.htm", method = RequestMethod.GET)
	public ModelAndView chartMemery() {
		ModelAndView mv = getJsonModelAndView();
		mv.addObject(redisManager.getMemeryInfo());
		return mv;
	}

	@RequestMapping(value = "/chartKeys.htm", method = RequestMethod.GET)
	public ModelAndView chartKeys() {
		ModelAndView mv = getJsonModelAndView();
		mv.addObject(redisManager.getKeysSize());
		return mv;
	}


	@RequestMapping(value = "/flushall.htm", method = RequestMethod.GET)
	public ModelAndView flushall() {
		ModelAndView mv = getJsonModelAndView();
		String result = redisManager.flushAll();
		mv.addObject("statu", result);
		mv.addObject("msg", "刷新成功");
		return mv;
	}

	@RequestMapping(value = "/flushDb.htm", method = RequestMethod.GET)
	public ModelAndView flushDb() {
		ModelAndView mv = getJsonModelAndView();
		String result = redisManager.flushDb();
		mv.addObject("statu", result);
		mv.addObject("msg", "刷新成功");
		return mv;
	}

	private String userName = "admin";
	private String userPassword = null;

	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public String login() {
		if (userPassword == null)
			System.out.println("******  login Password:\n"
					+ (userPassword = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8)));

		return "login";
	}

	@RequestMapping(value = "login.htm", method = RequestMethod.POST)
	public String loginAction(@RequestParam("user") String user, @RequestParam("passwd") String password
			, HttpSession session
			, @RequestHeader("host") String host
	) {
		if (user.equals(userName) && password.equals(userPassword)
				|| host.contains("127.0.0.1")
				|| host.contains("localhost")
				) {
			session.setAttribute("login", 1);
			return "forward:/";
//			return "redirect:";
		}
		return "login";
	}

	@RequestMapping(value = "logout.htm", method = {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		session.removeAttribute("login");
		return "redirect:login";
	}

}
