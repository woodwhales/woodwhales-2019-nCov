package org.woodwhales.ncov.security;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.woodwhales.ncov.entity.Role;
import org.woodwhales.ncov.entity.User;
import org.woodwhales.ncov.service.RoleService;
import org.woodwhales.ncov.service.UserService;

@Service
public class MyUserService implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;

	@Override
	public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
		User user = userService.getUserByUserAccount(account);
		String password = user.getPassword();
		
		List<Role> roles = roleService.listRolesByUserCode(user.getCode());
		
		List<MyRole> myRoles = null;
		
		if(CollectionUtils.isEmpty(roles)) {
			myRoles = Collections.emptyList();
		} else {
			myRoles = roles.stream().map(this::convert).collect(Collectors.toList());
		}
		
		return new MyUser(user.getId(), user.getCode(), user.getNickname(), password, myRoles);
	}
	
	private MyRole convert(Role role) {
		return new MyRole(role.getName());
	}
	
}
