package io.renren.controller;

import java.util.List;
import java.util.Map;

import io.renren.entity.WdataEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.service.WdataService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 
 * 
 * @author wbcwhy
 * @email wbc0128@163.com
 * @date 2017-05-01 14:19:54
 */
@RestController
@RequestMapping("wdata")
public class WdataController {
	@Autowired
	private WdataService wdataService;



	/**
	 * 实现的dao层写好的mapper查询
	 * @return List列表，json封装
	 */
	@RequestMapping(value = "/lists")
	@RequiresPermissions("wdata:lists")
	public @ResponseBody
	List<WdataEntity> getWData(){
		List<WdataEntity> result=wdataService.selecWMore();
		return result;    //返回的是一个json数据
	}


	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("wdata:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WdataEntity> wdataList = wdataService.queryList(query);
		int total = wdataService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(wdataList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("wdata:info")
	public R info(@PathVariable("id") Long id){
		WdataEntity wdata = wdataService.queryObject(id);
		
		return R.ok().put("wdata", wdata);
	}



	/**
	 * 保存数据
	 */
	@RequestMapping("/save")
	@RequiresPermissions("wdata:save")
	public R save(@RequestBody WdataEntity wdata){
		wdataService.save(wdata);
		
		return R.ok();
	}
	
	/**
	 * 修改数据
	 */
	@RequestMapping("/update")
	@RequiresPermissions("wdata:update")
	public R update(@RequestBody WdataEntity wdata){
		wdataService.update(wdata);
		
		return R.ok();
	}
	
	/**
	 * 删除数据
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("wdata:delete")
	public R delete(@RequestBody Long[] ids){
		wdataService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
