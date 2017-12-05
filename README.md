# webController

模板引擎：jsp,jstl,freemarker 用于前后台数据绑定,需要后台支撑(有内置函数，用于转换数据格式；有语法，支持转换--th: ... )

thymeleaf

	语 法	${...} 变量
			*{...}
			#{...} 获取property文件
			@{...} url表达式 <@> 

	html:	th:each="object: ${list}"
			th:text="${object.feild }"

	
	th:object="${ob}" java对象
	th:value="${ob.username}"	显示
	th:field="*{username}"		传数据
	
	th:utext <b>  --- th:text &lt;b&gt;	
	Var name = [[${name}]]


>4个字段用户
--index--table（数据，编辑，新增）---新增-> form -- 保存 后台输出
								  编辑--->后台显示所有数据-->回显




createdate


th:fragment="copy"