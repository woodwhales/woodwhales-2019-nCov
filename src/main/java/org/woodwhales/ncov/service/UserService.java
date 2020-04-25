package org.woodwhales.ncov.service;

import org.woodwhales.ncov.entity.User;

public interface UserService {
	
	User getUserByUserAccount(String userName);
}
