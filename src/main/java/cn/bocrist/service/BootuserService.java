package cn.bocrist.service;

import java.util.List;

import cn.bocrist.entity.Bootuser;

public interface BootuserService {
	
	void deleteByPrimaryKey(Short id);
	
	void insert(Bootuser record);
	
	List<Bootuser> selectByExample(String bootname);
	
	Bootuser selectByPrimaryKey(Short id);
	
	void updateByPrimaryKeySelective(Bootuser record);

}
