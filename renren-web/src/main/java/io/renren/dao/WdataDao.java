package io.renren.dao;

import io.renren.entity.WdataEntity;

import java.util.List;

/**
 * 
 * 
 * @author wbcwhy
 * @email wbc0128@163.com
 * @date 2017-05-01 14:19:54
 */
public interface WdataDao extends BaseDao<WdataEntity> {
    List<WdataEntity> selecWMore();
}
