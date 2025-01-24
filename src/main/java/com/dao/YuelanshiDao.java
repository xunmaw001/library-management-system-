package com.dao;

import com.entity.YuelanshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YuelanshiView;

/**
 * 阅览室 Dao 接口
 *
 * @author 
 */
public interface YuelanshiDao extends BaseMapper<YuelanshiEntity> {

   List<YuelanshiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
