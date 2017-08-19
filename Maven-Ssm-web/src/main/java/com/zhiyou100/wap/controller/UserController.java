package com.zhiyou100.wap.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.wap.model.Seek;
import com.zhiyou100.wap.model.User;
import com.zhiyou100.wap.service.user.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService us;
	@RequestMapping("/login.action")
	public String  roleselect(User ur,HttpSession hs,Model mo,boolean remember){
	List<User> user =  us.selectlogin(ur);
	
		if(user.size() == 0){
			mo.addAttribute("error","用户名或密码错误");
			return "forward:/index.jsp";
		}
		hs.setAttribute("user", user.get(0));
		
		return "redirect:/admin.jsp";
	}
	@RequestMapping("/loginout.action")
	public String logout(HttpSession hb){
		hb.invalidate();
		return "forward:/index.jsp";
	}
	@RequestMapping("/userList.action")
	public ModelAndView userlist(Seek sk,HttpServletRequest req){
		int currentPage = req.getParameter("page")==null ? 1:Integer.parseInt(req.getParameter("page"));
//		String keyWord = req.getParameter("KeyWord");
//		String searchField = req.getParameter("SearchField");
//		if(keyWord == null ||searchField == null){
//			keyWord="";
//			searchField="u_name";
//		}
//		
//		sk.setKeyWord(keyWord);
//		sk.setSearchField(searchField);
		sk.setCurrentPage(currentPage);
		ModelAndView view = new ModelAndView();
		view.addObject("page",us.userList(sk));
		view.addObject("sk", sk.getKeyWord());
		view.addObject("SearchField", sk.getSearchField());
		view.setViewName("/user/userList");
		return view;
	}
	@RequestMapping("/updateUser.action")
	public ModelAndView updateUser(Integer id){
		User list = us.updateuser(id);
		ModelAndView view = new ModelAndView();
		view.addObject("user",list);
		view.setViewName("/user/updateUser");
		System.out.println(list);
		return view;
	}
	@RequestMapping(value="/updateUser.action",method=RequestMethod.POST)
	public String updatatouser(User user,MultipartFile pictore) throws  IOException{
		String str = UUID.randomUUID().toString().replaceAll("-","");
		String ext = FilenameUtils.getExtension(pictore.getOriginalFilename());
		if(ext != "")
		{
		String fileName = str+"."+ext;
		String path ="D:\\Develop\\unload";
		pictore.transferTo(new File(path+"\\"+fileName));
		user.setuPhone(fileName);
		}
		us.updattouser(user);
		return "redirect:/user/userList.action";
	}
	
}
