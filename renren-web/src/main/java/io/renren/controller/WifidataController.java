package io.renren.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.entity.WifidataEntity;
import io.renren.service.WifidataService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 
 * 
 * @author wbcwhy
 * @email wbc0128@163.com
 * @date 2017-04-30 00:50:34
 */
@RestController
@RequestMapping("wifidata")
public class WifidataController {
	@Autowired
	private WifidataService wifidataService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("wifidata:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WifidataEntity> wifidataList = wifidataService.queryList(query);
		int total = wifidataService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(wifidataList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("wifidata:info")
	public R info(@PathVariable("id") Long id){
		WifidataEntity wifidata = wifidataService.queryObject(id);
		
		return R.ok().put("wifidata", wifidata);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("wifidata:save")
	public R save(@RequestBody WifidataEntity wifidata){
		wifidataService.save(wifidata);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("wifidata:update")
	public R update(@RequestBody WifidataEntity wifidata){
		wifidataService.update(wifidata);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("wifidata:delete")
	public R delete(@RequestBody Long[] ids){
		wifidataService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
