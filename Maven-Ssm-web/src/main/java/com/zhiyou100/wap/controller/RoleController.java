package com.zhiyou100.wap.controller;



import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.wap.model.Role;
import com.zhiyou100.wap.model.RoleBack;
import com.zhiyou100.wap.service.RoleService;
@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	RoleService rs;
	@RequestMapping("/roleList.action")
	public ModelAndView  roleselect(){
		Role role = new Role();
		List<Role> list = rs.selectRole(role);
		ModelAndView view = new ModelAndView();
		view.addObject("list", list);
		view.setViewName("role/roleList");
		return view;
	}
	
	@RequestMapping("/updateRole.action")
	public ModelAndView  roleById(@RequestParam(value = "id",required=true,defaultValue="1")Integer theid){
		Role ro = rs.selectById(theid);
		ModelAndView view = new ModelAndView();
		view.addObject("role",ro);
		view.setViewName("/role/updateRole");
		return view;
	}
//	@RequestMapping(value="/updateRole.action",method=RequestMethod.GET)
//	public String  roleadd(Role r,Model a){
//		a.addAttribute("data","222");
//		rs.updateRole(r);
//		
////		return "redirect:/role/roleList.action";
//		return "forward:/role/roleList.action";
//	}
	@RequestMapping(value="/updateRole.action",method=RequestMethod.POST)
	public String  roleadd11(RoleBack r ,MultipartFile pic) throws Exception{
		String str = UUID.randomUUID().toString().replaceAll("-","");
		String ext = FilenameUtils.getExtension(pic.getOriginalFilename());
		
		String fileName = str+"."+ext;
		String path ="D:\\Develop\\unload";
		pic.transferTo(new File(path+"\\"+fileName));
		r.getRe().setrPic(fileName);
		rs.updateRole(r.getRe());
		
		return "redirect:/role/roleList.action";
	}
//	@RequestMapping("/role/upRole.action")
//	public ModelAndView  rolepack(RoleBack rb){
//		
//		rs.updateRole(rb.getRe());
//		System.out.println(rb);
//		return null;
//	}
	/*@RequestMapping("/role/upRole.action")
	public ModelAndView  rolepack(RoleBack rb,String[]st){
		
//		rs.updateRole(rb.getRe());
		System.out.println(rb);
		System.out.println(Arrays.toString(st));
		return null;
	}*/
	@RequestMapping("/reo.action")
	public ModelAndView  rolepack(RoleBack rb){
		List<Role> list = rb.getItemList();
		for (Role r : list) {
			rs.updateallRole(r);
		}
		return null;
	}
	
}

