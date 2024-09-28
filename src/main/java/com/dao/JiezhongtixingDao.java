package com.dao;

import com.entity.JiezhongtixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiezhongtixingVO;
import com.entity.view.JiezhongtixingView;


/**
 * 接种提醒
 */
public interface JiezhongtixingDao extends BaseMapper<JiezhongtixingEntity> {
	
	List<JiezhongtixingVO> selectListVO(@Param("ew") Wrapper<JiezhongtixingEntity> wrapper);
	
	JiezhongtixingVO selectVO(@Param("ew") Wrapper<JiezhongtixingEntity> wrapper);
	
	List<JiezhongtixingView> selectListView(@Param("ew") Wrapper<JiezhongtixingEntity> wrapper);

	List<JiezhongtixingView> selectListView(Pagination page,@Param("ew") Wrapper<JiezhongtixingEntity> wrapper);
	
	JiezhongtixingView selectView(@Param("ew") Wrapper<JiezhongtixingEntity> wrapper);
	

}
