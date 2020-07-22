package com.company.ssm.dao;

import com.company.ssm.dao.entity.User;
import com.company.ssm.vo.QueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;

import java.math.BigDecimal;
import java.util.List;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    User login(@Param("username") String username,@Param("password") String password);

    List<User> dynamicSearch(QueryVo vo);

    int exist(@Param("username") String username);

    List<User> findAll();
}