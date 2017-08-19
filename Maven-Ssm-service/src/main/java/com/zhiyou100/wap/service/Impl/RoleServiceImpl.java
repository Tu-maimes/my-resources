package com.zhiyou100.wap.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.wap.mapper.RoleMapper;
import com.zhiyou100.wap.model.Role;
import com.zhiyou100.wap.model.RoleExample;
import com.zhiyou100.wap.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper rm;
	
	public List<Role> selectRole(Role re){
		RoleExample example = new RoleExample();
		example.createCriteria().andRNameLike("%"+re.getrName()+"%");
		return rm.selectByExample(null);
	}
	@Override
	
	public Role selectById(Integer theid) {
		return rm.selectByPrimaryKey(theid);
	}

	@Override
	public void updateRole(Role r) {
		rm.updateByPrimaryKeySelective(r);
		
	}
	@Override
	public void updateallRole(Role re) {
		rm.updateByPrimaryKeySelective(re);
	}

}
