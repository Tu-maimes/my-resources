package com.zhiyou100.wap.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.zhiyou100.wap.model.Seek;
import com.zhiyou100.wap.model.User;
import com.zhiyou100.wap.model.UserExample;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);
    List<User> selectByExampleseek(Seek sk);
    Integer selectByExampleCount(Seek sk);
    
    User selectByPrimaryKey(Integer uId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}