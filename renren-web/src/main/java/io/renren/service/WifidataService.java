package io.renren.service;

import io.renren.entity.WifidataEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wbcwhy
 * @email wbc0128@163.com
 * @date 2017-04-30 00:50:34
 */
public interface WifidataService {
	
	WifidataEntity queryObject(Long id);
	
	List<WifidataEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WifidataEntity wifidata);
	
	void update(WifidataEntity wifidata);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
