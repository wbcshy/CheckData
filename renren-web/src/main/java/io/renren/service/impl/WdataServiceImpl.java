package io.renren.service.impl;

import io.renren.entity.WdataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.WdataDao;
import io.renren.service.WdataService;



@Service("wdataService")
public class WdataServiceImpl implements WdataService {
	@Autowired
	private WdataDao wdataDao;
	
	@Override
	public WdataEntity queryObject(Long id){
		return wdataDao.queryObject(id);
	}
	
	@Override
	public List<WdataEntity> queryList(Map<String, Object> map){
		return wdataDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return wdataDao.queryTotal(map);
	}
	
	@Override
	public void save(WdataEntity wdata){
		wdataDao.save(wdata);
	}
	
	@Override
	public void update(WdataEntity wdata){
		wdataDao.update(wdata);
	}
	
	@Override
	public void delete(Long id){
		wdataDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		wdataDao.deleteBatch(ids);
	}

	@Override
	public List<WdataEntity> selecWMore() {
		return wdataDao.selecWMore();
	}

}
