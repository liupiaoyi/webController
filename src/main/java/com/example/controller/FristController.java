package com.example.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Param;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entity.User;

@Controller
public class FristController {
	
//	@RequestMapping("/index")
//	@ResponseBody
//	public String getInfo() {
//		
//		return "controller 接受参数";
//		
//		
//	}
	
	@RequestMapping("/method1")
	public String method1(String name,String num,HttpServletRequest req) {
		String attribute = (String)req.getAttribute("msg");
		name = attribute;
		System.out.println(name+"==="+num);
		return "toNew";
	}
	
	@RequestMapping("/method2")
	public String method2(@RequestParam( value="name",required=true)String name,
							@RequestParam( value="num",defaultValue="1234") String num) {
		System.out.println(name+"==="+num);
		return "toNew";
	}
	
	@RequestMapping(value="/method3",method=RequestMethod.GET)
	public String method3(HttpServletRequest request) {
		String name = request.getParameter("name");
		String num = request.getParameter("num");
		System.out.println(name+"==="+num);
		
		request.setAttribute("name", name);
		request.setAttribute("num", num);
		return "toNew";
		
	}
	
	
	@RequestMapping(value="method4")
	public String method4(@RequestParam Map<String,String> params) {
		Iterator<Entry<String, String>> iterator = params.entrySet().iterator();
		while( iterator.hasNext() ) {
			Entry<String, String> next = iterator.next();
			System.out.println(next.getKey()+"===="+next.getValue());
		}
		return "toNew";
	}
	
	
	@RequestMapping(value="method5")
	public String method5(@ModelAttribute("user") User user,Model model,HttpServletRequest req) {
		String string = user.toString();
		System.out.println(string);
		
		req.setAttribute("try", "aaaa");
		
		model.addAttribute("user",string);
		return "toNew";
	}
	
	
	
	
	@RequestMapping(value="getHead")
	public String getHead(String id,@RequestHeader("user-Agent") String userAgent,
									@RequestHeader("Accept-Encoding") String encode,HttpServletRequest req) {
		System.out.println(id+"++"+userAgent);
		//1234++				   Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:57.0) Gecko/20100101 Firefox/57.0
		System.out.println("encode=="+encode);
		//encode==						gzip, deflate
		System.out.println(req.getHeader("Accept-Encoding"));
		//							gzip, deflate
		return "toNew";
	}
	
	
	//	http://localhost:8080/addr/zhangsan/info/zs
	@RequestMapping(value="/addr/{addrName}/info/{infoName}")
	public String addrInfo(@PathVariable("addrName") String addrName,@PathVariable("infoName") String infoName) {
		System.out.println("addrName=="+addrName);
		System.out.println("infoName=="+infoName);
		
		return "toNew";
	}
	
	
	
	
	//重定向
	@RequestMapping(value="redirectTest")
	public String redirectTest(Model model,RedirectAttributes redirectAttrs) {
		redirectAttrs.addAttribute("msg", "保存成功");
		
		redirectAttrs.addFlashAttribute("flash", "闪现信息");
		return "redirect:redirectMsg";
	}
	@RequestMapping(value="redirectMsg")
	public String redirectMsg(Model model,RedirectAttributes redirectAttrs,String msg) {
		//前台没有  "msg"  
		System.err.println(msg);//保存成功
		return "toNew";
	}
	
	
	
	
	//转发
	@RequestMapping(value="forwardTest")
	public String forwardTest(Model model) {
		model.addAttribute("msg","保存成功");

		return "forward:forwardMsg";
	}
	
	@RequestMapping(value="forwardMsg")
	public String forwardMsg(String msg,HttpServletRequest req) {
		System.out.println(msg); //null
		System.out.println(req.getAttribute("msg")); //保存成功
		//前台有 "msg"  
		return "toNew";
	}

}
