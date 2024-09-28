package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuyuefenpeiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuyuefenpeiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuyuefenpeiView;


/**
 * 预约分配
 */
public interface YuyuefenpeiService extends IService<YuyuefenpeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuyuefenpeiVO> selectListVO(Wrapper<YuyuefenpeiEntity> wrapper);
   	
   	YuyuefenpeiVO selectVO(@Param("ew") Wrapper<YuyuefenpeiEntity> wrapper);
   	
   	List<YuyuefenpeiView> selectListView(Wrapper<YuyuefenpeiEntity> wrapper);
   	
   	YuyuefenpeiView selectView(@Param("ew") Wrapper<YuyuefenpeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuyuefenpeiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<YuyuefenpeiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<YuyuefenpeiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<YuyuefenpeiEntity> wrapper);
}

