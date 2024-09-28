package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YuyuefenpeiEntity;
import com.entity.view.YuyuefenpeiView;

import com.service.YuyuefenpeiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

@RestController
@RequestMapping("/yuyuefenpei")
public class YuyuefenpeiController {
    @Autowired
    private YuyuefenpeiService yuyuefenpeiService;

    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuyuefenpeiEntity yuyuefenpei, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yuyuefenpei.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuyuefenpeiEntity> ew = new EntityWrapper<YuyuefenpeiEntity>();
		PageUtils page = yuyuefenpeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuefenpei), params), params));
        return R.ok().put("data", page);
    }

	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuyuefenpeiEntity yuyuefenpei, 
		HttpServletRequest request){
        EntityWrapper<YuyuefenpeiEntity> ew = new EntityWrapper<YuyuefenpeiEntity>();
		PageUtils page = yuyuefenpeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuefenpei), params), params));
        return R.ok().put("data", page);
    }

    @RequestMapping("/lists")
    public R list( YuyuefenpeiEntity yuyuefenpei){
       	EntityWrapper<YuyuefenpeiEntity> ew = new EntityWrapper<YuyuefenpeiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuyuefenpei, "yuyuefenpei")); 
        return R.ok().put("data", yuyuefenpeiService.selectListView(ew));
    }

    @RequestMapping("/query")
    public R query(YuyuefenpeiEntity yuyuefenpei){
        EntityWrapper< YuyuefenpeiEntity> ew = new EntityWrapper< YuyuefenpeiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuyuefenpei, "yuyuefenpei")); 
		YuyuefenpeiView yuyuefenpeiView =  yuyuefenpeiService.selectView(ew);
		return R.ok("查询预约分配成功").put("data", yuyuefenpeiView);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuyuefenpeiEntity yuyuefenpei = yuyuefenpeiService.selectById(id);
        return R.ok().put("data", yuyuefenpei);
    }

	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuyuefenpeiEntity yuyuefenpei = yuyuefenpeiService.selectById(id);
        return R.ok().put("data", yuyuefenpei);
    }

    @RequestMapping("/save")
    public R save(@RequestBody YuyuefenpeiEntity yuyuefenpei, HttpServletRequest request){
    	yuyuefenpei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyuefenpei);

        yuyuefenpeiService.insert(yuyuefenpei);
        return R.ok();
    }

    @RequestMapping("/add")
    public R add(@RequestBody YuyuefenpeiEntity yuyuefenpei, HttpServletRequest request){
    	yuyuefenpei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyuefenpei);

        yuyuefenpeiService.insert(yuyuefenpei);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YuyuefenpeiEntity yuyuefenpei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuyuefenpei);
        yuyuefenpeiService.updateById(yuyuefenpei);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuyuefenpeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<YuyuefenpeiEntity> wrapper = new EntityWrapper<YuyuefenpeiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = yuyuefenpeiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<YuyuefenpeiEntity> ew = new EntityWrapper<YuyuefenpeiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            ew.eq("zhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = yuyuefenpeiService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<YuyuefenpeiEntity> ew = new EntityWrapper<YuyuefenpeiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            ew.eq("zhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = yuyuefenpeiService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<YuyuefenpeiEntity> ew = new EntityWrapper<YuyuefenpeiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            ew.eq("zhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = yuyuefenpeiService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }
}
