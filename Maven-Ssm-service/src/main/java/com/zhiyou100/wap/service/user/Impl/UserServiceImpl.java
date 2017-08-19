package com.zhiyou100.wap.service.user.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.wap.mapper.UserMapper;
import com.zhiyou100.wap.model.Seek;
import com.zhiyou100.wap.model.User;
import com.zhiyou100.wap.model.UserExample;
import com.zhiyou100.wap.service.user.UserService;
import com.zhiyou100.wap.tools.Page;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper um;
	@Override
	public List<User> selectlogin(User ur) {
		UserExample example = new UserExample();
		example.createCriteria().andUNameEqualTo(ur.getuName()).andUPwdEqualTo(ur.getuPwd());
		List<User> us =um.selectByExample(example);
		return us;
	}
	@Override
	public Page<User> userList(Seek sk) {
		Page<User> page = new Page<>();
		page.setPage(sk.getCurrentPage());
		sk.setCurrentPage((sk.getCurrentPage()-1)*5);
		List<User> list = um.selectByExampleseek(sk);
		Integer count = um.selectByExampleCount(sk);
		page.setRows(list);
		page.setSize(5);
		page.setTotal(count);
		return page;
	}
	@Override
	public User updateuser(Integer id) {
		
		return um.selectByPrimaryKey(id);
	}
	@Override
	public void updattouser(User user) {
		um.updateByPrimaryKeySelective(user);
	}
	
}
