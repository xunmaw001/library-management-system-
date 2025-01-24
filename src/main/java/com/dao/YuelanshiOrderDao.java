package com.dao;

import com.entity.YuelanshiOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YuelanshiOrderView;

/**
 * 阅览室座位预约 Dao 接口
 *
 * @author 
 */
public interface YuelanshiOrderDao extends BaseMapper<YuelanshiOrderEntity> {

   List<YuelanshiOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
