package com.entity.view;

import com.entity.JiezhongyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 接种预约
 */
@TableName("jiezhongyuyue")
public class JiezhongyuyueView  extends JiezhongyuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiezhongyuyueView(){
	}
 
 	public JiezhongyuyueView(JiezhongyuyueEntity jiezhongyuyueEntity){
 	try {
			BeanUtils.copyProperties(this, jiezhongyuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
