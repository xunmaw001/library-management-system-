package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.TushuYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 图书归还申请
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("tushu_yuyue")
public class TushuYuyueView extends TushuYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 报名状态的值
	*/
	@ColumnInfo(comment="报名状态的字典表值",type="varchar(200)")
	private String tushuYuyueYesnoValue;

	//级联表 图书
		/**
		* 图书名称
		*/

		@ColumnInfo(comment="图书名称",type="varchar(200)")
		private String tushuName;
		/**
		* 图书编号
		*/

		@ColumnInfo(comment="图书编号",type="varchar(200)")
		private String tushuUuidNumber;
		/**
		* 图书照片
		*/

		@ColumnInfo(comment="图书照片",type="varchar(200)")
		private String tushuPhoto;
		/**
		* 图书作者
		*/

		@ColumnInfo(comment="图书作者",type="varchar(200)")
		private String tushuZuozhe;
		/**
		* 图书类型
		*/
		@ColumnInfo(comment="图书类型",type="int(11)")
		private Integer tushuTypes;
			/**
			* 图书类型的值
			*/
			@ColumnInfo(comment="图书类型的字典表值",type="varchar(200)")
			private String tushuValue;
		/**
		* 图书介绍
		*/

		@ColumnInfo(comment="图书介绍",type="text")
		private String tushuContent;
		/**
		* 出版时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="出版时间",type="timestamp")
		private Date chubanTime;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer tushuDelete;
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



	public TushuYuyueView() {

	}

	public TushuYuyueView(TushuYuyueEntity tushuYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, tushuYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 报名状态的值
	*/
	public String getTushuYuyueYesnoValue() {
		return tushuYuyueYesnoValue;
	}
	/**
	* 设置： 报名状态的值
	*/
	public void setTushuYuyueYesnoValue(String tushuYuyueYesnoValue) {
		this.tushuYuyueYesnoValue = tushuYuyueYesnoValue;
	}


	//级联表的get和set 图书

		/**
		* 获取： 图书名称
		*/
		public String getTushuName() {
			return tushuName;
		}
		/**
		* 设置： 图书名称
		*/
		public void setTushuName(String tushuName) {
			this.tushuName = tushuName;
		}

		/**
		* 获取： 图书编号
		*/
		public String getTushuUuidNumber() {
			return tushuUuidNumber;
		}
		/**
		* 设置： 图书编号
		*/
		public void setTushuUuidNumber(String tushuUuidNumber) {
			this.tushuUuidNumber = tushuUuidNumber;
		}

		/**
		* 获取： 图书照片
		*/
		public String getTushuPhoto() {
			return tushuPhoto;
		}
		/**
		* 设置： 图书照片
		*/
		public void setTushuPhoto(String tushuPhoto) {
			this.tushuPhoto = tushuPhoto;
		}

		/**
		* 获取： 图书作者
		*/
		public String getTushuZuozhe() {
			return tushuZuozhe;
		}
		/**
		* 设置： 图书作者
		*/
		public void setTushuZuozhe(String tushuZuozhe) {
			this.tushuZuozhe = tushuZuozhe;
		}
		/**
		* 获取： 图书类型
		*/
		public Integer getTushuTypes() {
			return tushuTypes;
		}
		/**
		* 设置： 图书类型
		*/
		public void setTushuTypes(Integer tushuTypes) {
			this.tushuTypes = tushuTypes;
		}


			/**
			* 获取： 图书类型的值
			*/
			public String getTushuValue() {
				return tushuValue;
			}
			/**
			* 设置： 图书类型的值
			*/
			public void setTushuValue(String tushuValue) {
				this.tushuValue = tushuValue;
			}

		/**
		* 获取： 图书介绍
		*/
		public String getTushuContent() {
			return tushuContent;
		}
		/**
		* 设置： 图书介绍
		*/
		public void setTushuContent(String tushuContent) {
			this.tushuContent = tushuContent;
		}

		/**
		* 获取： 出版时间
		*/
		public Date getChubanTime() {
			return chubanTime;
		}
		/**
		* 设置： 出版时间
		*/
		public void setChubanTime(Date chubanTime) {
			this.chubanTime = chubanTime;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getTushuDelete() {
			return tushuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setTushuDelete(Integer tushuDelete) {
			this.tushuDelete = tushuDelete;
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


	@Override
	public String toString() {
		return "TushuYuyueView{" +
			", tushuYuyueYesnoValue=" + tushuYuyueYesnoValue +
			", tushuName=" + tushuName +
			", tushuUuidNumber=" + tushuUuidNumber +
			", tushuPhoto=" + tushuPhoto +
			", tushuZuozhe=" + tushuZuozhe +
			", tushuContent=" + tushuContent +
			", chubanTime=" + DateUtil.convertString(chubanTime,"yyyy-MM-dd") +
			", tushuDelete=" + tushuDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
