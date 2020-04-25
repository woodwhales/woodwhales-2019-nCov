package org.woodwhales.ncov.service;

import java.util.List;

import org.woodwhales.ncov.entity.Role;

public interface RoleService {

	public List<Role> listRolesByUserCode(String userCode);
}
