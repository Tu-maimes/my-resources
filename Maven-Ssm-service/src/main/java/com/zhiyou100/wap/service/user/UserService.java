package com.zhiyou100.wap.service.user;

import java.util.List;

import com.zhiyou100.wap.model.Seek;
import com.zhiyou100.wap.model.User;
import com.zhiyou100.wap.tools.Page;

public interface UserService {

	List<User> selectlogin(User ur);

	Page userList(Seek sk);

	User updateuser(Integer id);

	void updattouser(User user);


}
