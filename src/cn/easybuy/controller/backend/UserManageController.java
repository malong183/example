package cn.easybuy.controller.backend;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.easybuy.pojo.User;
import cn.easybuy.service.user.UserService;

@Controller
@RequestMapping(value="/manager")
public class UserManageController {

	private Logger logger = Logger.getLogger(UserManageController.class);
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/login")
	public String login(){
		logger.debug("LoginController welcome AppInfoSystem backend==================");
		return "Login";
	}
	
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public String doLogin(@RequestParam String loginName,@RequestParam String password,HttpServletRequest request,HttpSession session){
		logger.debug("doLogin====================================");
		//调用service方法，进行用户匹配
		User user = null;
		try {
			user = userService.getLoginUser(loginName, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null != user){//登录成功
			//放入session
			session.setAttribute("userSession", user);
			//页面跳转（main.jsp）
			return "redirect:/index";
		}else{
			//页面跳转（login.jsp）带出提示信息--转发
			request.setAttribute("error", "用户名或密码不正确");
			return "Login";
		}
	}
	
	@RequestMapping(value="/main")
	public String main(HttpSession session){
		if(session.getAttribute("userSession") == null){
			return "redirect:/manager/login";
		}
		return "index";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		//清除session
		session.removeAttribute("userSession");
		return "Login";
	}
	
}
