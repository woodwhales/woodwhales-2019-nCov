package org.woodwhales.ncov.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.woodwhales.ncov.entity.Role;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface RoleRespository extends BaseMapper<Role> {

	@Select("SELECT r.* from ncov_role as r, ncov_user_role as rp where r.id = rp.role_id and rp.user_code = #{userCode}")
	List<Role> listRolesByUserCode(String userCode);
}
