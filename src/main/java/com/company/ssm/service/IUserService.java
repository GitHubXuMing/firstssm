package com.company.ssm.service;


import com.company.ssm.common.Res;
import com.company.ssm.dao.entity.User;
import com.company.ssm.vo.QueryVo;

public interface IUserService {
	Res<?> exist(String username);

	Res<?> login(String username, String password);

	Res<?> reg(String username, String password);

	Res<?> findByPage(Integer page, Integer size);

	Res<?> delete(Integer id);

	Res<?> findById(Integer id);

	Res<?> update(User user);

	Res<?> insert(User user);

	Res<?> dynamicSelect(QueryVo qv);

}
