package io.renren.service;

import io.renren.entity.WdataEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wbcwhy
 * @email wbc0128@163.com
 * @date 2017-05-01 14:19:54
 */
public interface WdataService {
	
	WdataEntity queryObject(Long id);
	
	List<WdataEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WdataEntity wdata);
	
	void update(WdataEntity wdata);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	List<WdataEntity> selecWMore();
}
