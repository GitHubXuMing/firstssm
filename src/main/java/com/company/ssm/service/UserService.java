package com.company.ssm.service;

import com.company.ssm.common.Res;
import com.company.ssm.common.ResEnum;
import com.company.ssm.dao.UserDao;
import com.company.ssm.dao.entity.User;
import com.company.ssm.vo.QueryVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserDao userDao;

	@Override
	public Res<?> exist(String username) {
		Res<?> res = null;
		try {
			int result = userDao.exist(username);
			res = (result == 1) ? Res.success(ResEnum.USER_EXIST) : Res.success(ResEnum.USER_NOT_EXIST);
		} catch (Exception e) {
			e.printStackTrace();
			res = Res.error(ResEnum.ERROR);
		}
		return res;
	}

	@Override
	public Res<?> login(String username, String password) {
		Res<?> res = null;
		try {
			User user = userDao.login(username, password);
			res = (user != null) ? Res.success(ResEnum.SUCCESS, user) : Res.error(ResEnum.PASSWORD_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			res = Res.error(ResEnum.ERROR);
		}
		return res;
	}

	@Override
	public Res<?> reg(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		try {
			userDao.insertSelective(user);
			return Res.success(ResEnum.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return Res.error(ResEnum.ERROR);
		}
	}

	@Override
	public Res<?> findByPage(Integer page, Integer size) {
		PageHelper.startPage((page-1)*size,size);
		List<User> users = userDao.findAll();
		if(users != null && users.size()>0){
			PageInfo pageInfo = new PageInfo(users);
			return Res.success(ResEnum.SUCCESS,pageInfo);
		}else{
			return Res.error();
		}
	}

	@Override
	public Res<?> delete(Integer id) {
		if (id == null) {
			return Res.error(ResEnum.ILLEGLE_PARAM);
		}
		try {
			userDao.deleteByPrimaryKey(id);
			return Res.success();
		} catch (Exception e) {
			e.printStackTrace();
			return Res.error(ResEnum.ERROR);
		}
	}

	@Override
	public Res<?> findById(Integer id) {
		if (id == null) {
			return Res.error(ResEnum.ILLEGLE_PARAM);
		}
		try {
			User user = userDao.selectByPrimaryKey(id);
			return user == null ? Res.error(ResEnum.NO_SUCH_DATA) : Res.success(ResEnum.SUCCESS, user);
		} catch (Exception e) {
			e.printStackTrace();
			return Res.error(ResEnum.ERROR);
		}
	}

	@Override
	public Res<?> update(User user) {
		try {
			userDao.updateByPrimaryKeySelective(user);
			return Res.success();
		} catch (Exception e) {
			e.printStackTrace();
			return Res.error(ResEnum.ERROR);
		}
	}

	@Override
	public Res<?> insert(User user) {
		try {
			userDao.insertSelective(user);
			return Res.success();
		} catch (Exception e) {
			e.printStackTrace();
			return Res.error(ResEnum.ERROR);
		}
	}

	@Override
	public Res<?> dynamicSelect(QueryVo qv) {
		try {
			List<User> users = userDao.dynamicSearch(qv);
			if (users != null && users.size() > 0) {
				return Res.success(ResEnum.SUCCESS, users);
			} else {
				return Res.error(ResEnum.NO_DATA_FOUND_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Res.error(ResEnum.ERROR);
		}
	}

}
