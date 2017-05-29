package io.renren.dao;




import io.renren.entity.DataEntity;

import java.util.List;

/**
 * 
 * 
 * @author wbcwhy
 * @email wbc0128@163.com
 * @date 2017-04-30 17:15:30
 */
public interface DataDao extends BaseDao<io.renren.entity.DataEntity>{

    //添加供echars连接mysql数据的接口,数据的返回值类型应该是一个List<DataEntity>
    List<DataEntity> seleEchar();

	
}
