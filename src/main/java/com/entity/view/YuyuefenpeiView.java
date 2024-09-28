package com.entity.view;

import com.entity.YuyuefenpeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 预约分配
 */
@TableName("yuyuefenpei")
public class YuyuefenpeiView  extends YuyuefenpeiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YuyuefenpeiView(){
	}
 
 	public YuyuefenpeiView(YuyuefenpeiEntity yuyuefenpeiEntity){
 	try {
			BeanUtils.copyProperties(this, yuyuefenpeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
