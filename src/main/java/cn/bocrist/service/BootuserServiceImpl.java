package cn.bocrist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.bocrist.dao.BootuserMapper;
import cn.bocrist.entity.Bootuser;
@Service
public class BootuserServiceImpl implements BootuserService{
	@Autowired
	private BootuserMapper  bootusermapper;
	
	public void deleteByPrimaryKey(Short id) {
		bootusermapper.deleteByPrimaryKey(id);
	}
	
	public void insert(Bootuser record) {
		bootusermapper.insert(record);
	}

	public List<Bootuser> selectByExample(String bootname){
		return bootusermapper.selectByExample(bootname);		
	}
	
	public Bootuser selectByPrimaryKey(Short id) {
		return bootusermapper.selectByPrimaryKey(id);	
	}
	
	public void updateByPrimaryKeySelective(Bootuser record) {
		bootusermapper.updateByPrimaryKeySelective(record);
	}
}
