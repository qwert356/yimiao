package com.dao;

import com.entity.YuyuefenpeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuyuefenpeiVO;
import com.entity.view.YuyuefenpeiView;


/**
 * 预约分配
 */
public interface YuyuefenpeiDao extends BaseMapper<YuyuefenpeiEntity> {
	
	List<YuyuefenpeiVO> selectListVO(@Param("ew") Wrapper<YuyuefenpeiEntity> wrapper);
	
	YuyuefenpeiVO selectVO(@Param("ew") Wrapper<YuyuefenpeiEntity> wrapper);
	
	List<YuyuefenpeiView> selectListView(@Param("ew") Wrapper<YuyuefenpeiEntity> wrapper);

	List<YuyuefenpeiView> selectListView(Pagination page,@Param("ew") Wrapper<YuyuefenpeiEntity> wrapper);
	
	YuyuefenpeiView selectView(@Param("ew") Wrapper<YuyuefenpeiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params")Map<String, Object> params,@Param("ew") Wrapper<YuyuefenpeiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YuyuefenpeiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YuyuefenpeiEntity> wrapper);
}
