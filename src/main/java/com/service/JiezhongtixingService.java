package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiezhongtixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiezhongtixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiezhongtixingView;


/**
 * 接种提醒
 */
public interface JiezhongtixingService extends IService<JiezhongtixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiezhongtixingVO> selectListVO(Wrapper<JiezhongtixingEntity> wrapper);
   	
   	JiezhongtixingVO selectVO(@Param("ew") Wrapper<JiezhongtixingEntity> wrapper);
   	
   	List<JiezhongtixingView> selectListView(Wrapper<JiezhongtixingEntity> wrapper);
   	
   	JiezhongtixingView selectView(@Param("ew") Wrapper<JiezhongtixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiezhongtixingEntity> wrapper);
   	

}

