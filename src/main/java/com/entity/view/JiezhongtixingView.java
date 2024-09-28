package com.entity.view;

import com.entity.JiezhongtixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 接种提醒
 */
@TableName("jiezhongtixing")
public class JiezhongtixingView  extends JiezhongtixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiezhongtixingView(){
	}
 
 	public JiezhongtixingView(JiezhongtixingEntity jiezhongtixingEntity){
 	try {
			BeanUtils.copyProperties(this, jiezhongtixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
