package org.woodwhales.ncov.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.woodwhales.ncov.entity.Role;
import org.woodwhales.ncov.repository.RoleRespository;
import org.woodwhales.ncov.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRespository roleRespository;
	
	@Override
	public List<Role> listRolesByUserCode(String userCode) {
		return roleRespository.listRolesByUserCode(userCode);
	}

}
