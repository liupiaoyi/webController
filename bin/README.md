# webController

Spring MVC and thyneleaf
		
	MVC
		model:实体
		view:页面
		controller:处理代码

thymeleaf:类似jsp

spring data jpa内部封装，不需要加@controller,@service 等注解

COC--约定优于配置
	src/main/resources/templates jsp等
	src/main/resources/static    css,图片等静态资源


传递多个参数

	@RequestParam Map<String,String> params 必须加注解
	@ModelAttribute("user") User user,Model model

	http协议：head封装信息。 参数应该放在 body 里
		@RequestHeader("user-Agent")浏览器信息
		@RequestHeader("Accept-Encoding") 原生信息/request.getHeader("Accept-Encoding")

Thymeleaf+SpringMVC
	
	后台设置属性：model.addAttribute("messages", message);
				request.setAttribute("messages", message);
	
	前台展示： 	th:text="${attributeName}" ！！！！！！！！！！！！！

重定向和转发

	redict: 重定向。两次请求(内部)     	参数request获取的到
	forward:转发。  一次请求(浏览器请求)

JSON

		格式：	{id:1, name: "zhangsan", ....}
		方法：① @ResponseBody
			 ② RestController 接口
			 ③ json 视图
		底层：jackson