package io.renren.service;

import io.renren.entity.DataEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wbcwhy
 * @email wbc0128@163.com
 * @date 2017-04-30 17:15:30
 */
public interface DataService {
	
	DataEntity queryObject(String id);
	
	List<DataEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DataEntity data);
	
	void update(DataEntity data);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	//添加供echars连接mysql数据的接口,数据的返回值类型应该是一个List<DataEntity>
	List<DataEntity> seleEchar();
}
