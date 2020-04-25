package org.woodwhales.ncov.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.woodwhales.ncov.entity.User;
import org.woodwhales.ncov.repository.UserRespository;
import org.woodwhales.ncov.service.UserService;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRespository userRespository;
	
	@Override
	public User getUserByUserAccount(String account) {
		if(StringUtils.isBlank(account)) {
			log.warn("account is blank");
			return null;
		}
		
		LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery().eq(User::getAccount, account);
		return userRespository.selectOne(queryWrapper);
	}

}
