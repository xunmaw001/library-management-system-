package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YuelanshiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 阅览室座位预约
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yuelanshi_order")
public class YuelanshiOrderView extends YuelanshiOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 订单类型的值
	*/
	@ColumnInfo(comment="订单类型的字典表值",type="varchar(200)")
	private String yuelanshiOrderValue;

	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;
	//级联表 阅览室
		/**
		* 阅览室名称
		*/

		@ColumnInfo(comment="阅览室名称",type="varchar(200)")
		private String yuelanshiName;
		/**
		* 阅览室照片
		*/

		@ColumnInfo(comment="阅览室照片",type="varchar(200)")
		private String yuelanshiPhoto;
		/**
		* 阅览室类型
		*/
		@ColumnInfo(comment="阅览室类型",type="int(11)")
		private Integer yuelanshiTypes;
			/**
			* 阅览室类型的值
			*/
			@ColumnInfo(comment="阅览室类型的字典表值",type="varchar(200)")
			private String yuelanshiValue;
		/**
		* 房间
		*/

		@ColumnInfo(comment="房间",type="int(11)")
		private Integer sectionNumber;
		/**
		* 座位
		*/

		@ColumnInfo(comment="座位",type="int(11)")
		private Integer zuoweiNumber;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yuelanshiDelete;
		/**
		* 阅览室简介
		*/

		@ColumnInfo(comment="阅览室简介",type="text")
		private String yuelanshiContent;



	public YuelanshiOrderView() {

	}

	public YuelanshiOrderView(YuelanshiOrderEntity yuelanshiOrderEntity) {
		try {
			BeanUtils.copyProperties(this, yuelanshiOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 订单类型的值
	*/
	public String getYuelanshiOrderValue() {
		return yuelanshiOrderValue;
	}
	/**
	* 设置： 订单类型的值
	*/
	public void setYuelanshiOrderValue(String yuelanshiOrderValue) {
		this.yuelanshiOrderValue = yuelanshiOrderValue;
	}


	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}
	//级联表的get和set 阅览室

		/**
		* 获取： 阅览室名称
		*/
		public String getYuelanshiName() {
			return yuelanshiName;
		}
		/**
		* 设置： 阅览室名称
		*/
		public void setYuelanshiName(String yuelanshiName) {
			this.yuelanshiName = yuelanshiName;
		}

		/**
		* 获取： 阅览室照片
		*/
		public String getYuelanshiPhoto() {
			return yuelanshiPhoto;
		}
		/**
		* 设置： 阅览室照片
		*/
		public void setYuelanshiPhoto(String yuelanshiPhoto) {
			this.yuelanshiPhoto = yuelanshiPhoto;
		}
		/**
		* 获取： 阅览室类型
		*/
		public Integer getYuelanshiTypes() {
			return yuelanshiTypes;
		}
		/**
		* 设置： 阅览室类型
		*/
		public void setYuelanshiTypes(Integer yuelanshiTypes) {
			this.yuelanshiTypes = yuelanshiTypes;
		}


			/**
			* 获取： 阅览室类型的值
			*/
			public String getYuelanshiValue() {
				return yuelanshiValue;
			}
			/**
			* 设置： 阅览室类型的值
			*/
			public void setYuelanshiValue(String yuelanshiValue) {
				this.yuelanshiValue = yuelanshiValue;
			}

		/**
		* 获取： 房间
		*/
		public Integer getSectionNumber() {
			return sectionNumber;
		}
		/**
		* 设置： 房间
		*/
		public void setSectionNumber(Integer sectionNumber) {
			this.sectionNumber = sectionNumber;
		}

		/**
		* 获取： 座位
		*/
		public Integer getZuoweiNumber() {
			return zuoweiNumber;
		}
		/**
		* 设置： 座位
		*/
		public void setZuoweiNumber(Integer zuoweiNumber) {
			this.zuoweiNumber = zuoweiNumber;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYuelanshiDelete() {
			return yuelanshiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYuelanshiDelete(Integer yuelanshiDelete) {
			this.yuelanshiDelete = yuelanshiDelete;
		}

		/**
		* 获取： 阅览室简介
		*/
		public String getYuelanshiContent() {
			return yuelanshiContent;
		}
		/**
		* 设置： 阅览室简介
		*/
		public void setYuelanshiContent(String yuelanshiContent) {
			this.yuelanshiContent = yuelanshiContent;
		}


	@Override
	public String toString() {
		return "YuelanshiOrderView{" +
			", yuelanshiOrderValue=" + yuelanshiOrderValue +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yuelanshiName=" + yuelanshiName +
			", yuelanshiPhoto=" + yuelanshiPhoto +
			", sectionNumber=" + sectionNumber +
			", zuoweiNumber=" + zuoweiNumber +
			", yuelanshiDelete=" + yuelanshiDelete +
			", yuelanshiContent=" + yuelanshiContent +
			"} " + super.toString();
	}
}
