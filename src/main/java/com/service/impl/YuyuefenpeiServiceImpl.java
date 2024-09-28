package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YuyuefenpeiDao;
import com.entity.YuyuefenpeiEntity;
import com.service.YuyuefenpeiService;
import com.entity.vo.YuyuefenpeiVO;
import com.entity.view.YuyuefenpeiView;

@Service("yuyuefenpeiService")
public class YuyuefenpeiServiceImpl extends ServiceImpl<YuyuefenpeiDao, YuyuefenpeiEntity> implements YuyuefenpeiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuyuefenpeiEntity> page = this.selectPage(
                new Query<YuyuefenpeiEntity>(params).getPage(),
                new EntityWrapper<YuyuefenpeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuyuefenpeiEntity> wrapper) {
		  Page<YuyuefenpeiView> page =new Query<YuyuefenpeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YuyuefenpeiVO> selectListVO(Wrapper<YuyuefenpeiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuyuefenpeiVO selectVO(Wrapper<YuyuefenpeiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuyuefenpeiView> selectListView(Wrapper<YuyuefenpeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuyuefenpeiView selectView(Wrapper<YuyuefenpeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<YuyuefenpeiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<YuyuefenpeiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<YuyuefenpeiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

}
