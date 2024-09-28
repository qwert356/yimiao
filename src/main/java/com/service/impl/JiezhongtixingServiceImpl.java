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


import com.dao.JiezhongtixingDao;
import com.entity.JiezhongtixingEntity;
import com.service.JiezhongtixingService;
import com.entity.vo.JiezhongtixingVO;
import com.entity.view.JiezhongtixingView;

@Service("jiezhongtixingService")
public class JiezhongtixingServiceImpl extends ServiceImpl<JiezhongtixingDao, JiezhongtixingEntity> implements JiezhongtixingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiezhongtixingEntity> page = this.selectPage(
                new Query<JiezhongtixingEntity>(params).getPage(),
                new EntityWrapper<JiezhongtixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiezhongtixingEntity> wrapper) {
		  Page<JiezhongtixingView> page =new Query<JiezhongtixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiezhongtixingVO> selectListVO(Wrapper<JiezhongtixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiezhongtixingVO selectVO(Wrapper<JiezhongtixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiezhongtixingView> selectListView(Wrapper<JiezhongtixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiezhongtixingView selectView(Wrapper<JiezhongtixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
