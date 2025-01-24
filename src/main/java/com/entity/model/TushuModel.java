package com.entity.model;

import com.entity.TushuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 图书
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TushuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 图书名称
     */
    private String tushuName;


    /**
     * 图书编号
     */
    private String tushuUuidNumber;


    /**
     * 图书照片
     */
    private String tushuPhoto;


    /**
     * 图书作者
     */
    private String tushuZuozhe;


    /**
     * 图书类型
     */
    private Integer tushuTypes;


    /**
     * 图书介绍
     */
    private String tushuContent;


    /**
     * 出版时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date chubanTime;


    /**
     * 逻辑删除
     */
    private Integer tushuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：图书名称
	 */
    public String getTushuName() {
        return tushuName;
    }


    /**
	 * 设置：图书名称
	 */
    public void setTushuName(String tushuName) {
        this.tushuName = tushuName;
    }
    /**
	 * 获取：图书编号
	 */
    public String getTushuUuidNumber() {
        return tushuUuidNumber;
    }


    /**
	 * 设置：图书编号
	 */
    public void setTushuUuidNumber(String tushuUuidNumber) {
        this.tushuUuidNumber = tushuUuidNumber;
    }
    /**
	 * 获取：图书照片
	 */
    public String getTushuPhoto() {
        return tushuPhoto;
    }


    /**
	 * 设置：图书照片
	 */
    public void setTushuPhoto(String tushuPhoto) {
        this.tushuPhoto = tushuPhoto;
    }
    /**
	 * 获取：图书作者
	 */
    public String getTushuZuozhe() {
        return tushuZuozhe;
    }


    /**
	 * 设置：图书作者
	 */
    public void setTushuZuozhe(String tushuZuozhe) {
        this.tushuZuozhe = tushuZuozhe;
    }
    /**
	 * 获取：图书类型
	 */
    public Integer getTushuTypes() {
        return tushuTypes;
    }


    /**
	 * 设置：图书类型
	 */
    public void setTushuTypes(Integer tushuTypes) {
        this.tushuTypes = tushuTypes;
    }
    /**
	 * 获取：图书介绍
	 */
    public String getTushuContent() {
        return tushuContent;
    }


    /**
	 * 设置：图书介绍
	 */
    public void setTushuContent(String tushuContent) {
        this.tushuContent = tushuContent;
    }
    /**
	 * 获取：出版时间
	 */
    public Date getChubanTime() {
        return chubanTime;
    }


    /**
	 * 设置：出版时间
	 */
    public void setChubanTime(Date chubanTime) {
        this.chubanTime = chubanTime;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getTushuDelete() {
        return tushuDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setTushuDelete(Integer tushuDelete) {
        this.tushuDelete = tushuDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
