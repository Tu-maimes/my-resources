package com.zhiyou100.wap.service;

import java.util.List;

import com.zhiyou100.wap.model.Role;

public interface RoleService {
	 List<Role> selectRole(Role re);

	Role selectById(Integer id);

	void updateRole(Role r);

	void updateallRole(Role re);

}
