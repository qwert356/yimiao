package com.entity.vo;

import com.entity.YimiaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 疫苗信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-03-25 21:19:02
 */
public class YimiaoxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 疫苗种类
	 */
	
	private String yimiaozhonglei;
		
	/**
	 * 批次号
	 */
	
	private String picihao;
		
	/**
	 * 有效期
	 */
	
	private String youxiaoqi;
		
	/**
	 * 生产商
	 */
	
	private String shengchanshang;
		
	/**
	 * 疫苗余量
	 */
	
	private Integer yimiaoyuliang;
		
	/**
	 * 注意事项
	 */
	
	private String zhuyishixiang;
		
	/**
	 * 疫苗图片
	 */
	
	private String yimiaotupian;
				
	
	/**
	 * 设置：疫苗种类
	 */
	 
	public void setYimiaozhonglei(String yimiaozhonglei) {
		this.yimiaozhonglei = yimiaozhonglei;
	}
	
	/**
	 * 获取：疫苗种类
	 */
	public String getYimiaozhonglei() {
		return yimiaozhonglei;
	}
				
	
	/**
	 * 设置：批次号
	 */
	 
	public void setPicihao(String picihao) {
		this.picihao = picihao;
	}
	
	/**
	 * 获取：批次号
	 */
	public String getPicihao() {
		return picihao;
	}
				
	
	/**
	 * 设置：有效期
	 */
	 
	public void setYouxiaoqi(String youxiaoqi) {
		this.youxiaoqi = youxiaoqi;
	}
	
	/**
	 * 获取：有效期
	 */
	public String getYouxiaoqi() {
		return youxiaoqi;
	}
				
	
	/**
	 * 设置：生产商
	 */
	 
	public void setShengchanshang(String shengchanshang) {
		this.shengchanshang = shengchanshang;
	}
	
	/**
	 * 获取：生产商
	 */
	public String getShengchanshang() {
		return shengchanshang;
	}
				
	
	/**
	 * 设置：疫苗余量
	 */
	 
	public void setYimiaoyuliang(Integer yimiaoyuliang) {
		this.yimiaoyuliang = yimiaoyuliang;
	}
	
	/**
	 * 获取：疫苗余量
	 */
	public Integer getYimiaoyuliang() {
		return yimiaoyuliang;
	}
				
	
	/**
	 * 设置：注意事项
	 */
	 
	public void setZhuyishixiang(String zhuyishixiang) {
		this.zhuyishixiang = zhuyishixiang;
	}
	
	/**
	 * 获取：注意事项
	 */
	public String getZhuyishixiang() {
		return zhuyishixiang;
	}
				
	
	/**
	 * 设置：疫苗图片
	 */
	 
	public void setYimiaotupian(String yimiaotupian) {
		this.yimiaotupian = yimiaotupian;
	}
	
	/**
	 * 获取：疫苗图片
	 */
	public String getYimiaotupian() {
		return yimiaotupian;
	}
			
}
