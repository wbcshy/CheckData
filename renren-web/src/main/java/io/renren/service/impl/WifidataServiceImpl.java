package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.WifidataDao;
import io.renren.entity.WifidataEntity;
import io.renren.service.WifidataService;



@Service("wifidataService")
public class WifidataServiceImpl implements WifidataService {
	@Autowired
	private WifidataDao wifidataDao;
	
	@Override
	public WifidataEntity queryObject(Long id){
		return wifidataDao.queryObject(id);
	}
	
	@Override
	public List<WifidataEntity> queryList(Map<String, Object> map){
		return wifidataDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return wifidataDao.queryTotal(map);
	}
	
	@Override
	public void save(WifidataEntity wifidata){
		wifidataDao.save(wifidata);
	}
	
	@Override
	public void update(WifidataEntity wifidata){
		wifidataDao.update(wifidata);
	}
	
	@Override
	public void delete(Long id){
		wifidataDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		wifidataDao.deleteBatch(ids);
	}
	
}
