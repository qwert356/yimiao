package com.entity.view;

import com.entity.YimiaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 疫苗信息
 */
@TableName("yimiaoxinxi")
public class YimiaoxinxiView  extends YimiaoxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YimiaoxinxiView(){
	}
 
 	public YimiaoxinxiView(YimiaoxinxiEntity yimiaoxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, yimiaoxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
