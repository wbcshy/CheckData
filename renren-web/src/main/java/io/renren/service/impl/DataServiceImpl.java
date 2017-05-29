package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.DataDao;
import io.renren.entity.DataEntity;
import io.renren.service.DataService;



@Service("dataService")
public class DataServiceImpl implements DataService {

	@Autowired
	private DataDao dataDao;
	
	@Override
	public DataEntity queryObject(String id){
		return dataDao.queryObject(id);
	}
	
	@Override
	public List<DataEntity> queryList(Map<String, Object> map){
		return dataDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return dataDao.queryTotal(map);
	}
	
	@Override
	public void save(DataEntity data){
		dataDao.save(data);
	}
	
	@Override
	public void update(DataEntity data){
		dataDao.update(data);
	}
	
	@Override
	public void delete(String id){
		dataDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		dataDao.deleteBatch(ids);
	}

	@Override
	public List<DataEntity> seleEchar(){ return dataDao.seleEchar(); }
	
}
