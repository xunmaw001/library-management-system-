
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 阅览室
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yuelanshi")
public class YuelanshiController {
    private static final Logger logger = LoggerFactory.getLogger(YuelanshiController.class);

    private static final String TABLE_NAME = "yuelanshi";

    @Autowired
    private YuelanshiService yuelanshiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private NewsService newsService;//资讯
    @Autowired
    private TushuService tushuService;//图书
    @Autowired
    private TushuLiuyanService tushuLiuyanService;//图书评论
    @Autowired
    private TushuOrderService tushuOrderService;//图书借阅
    @Autowired
    private TushuYuyueService tushuYuyueService;//图书归还申请
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private YuelanshiOrderService yuelanshiOrderService;//阅览室座位预约
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("yuelanshiDeleteStart",1);params.put("yuelanshiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = yuelanshiService.queryPage(params);

        //字典表数据转换
        List<YuelanshiView> list =(List<YuelanshiView>)page.getList();
        for(YuelanshiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YuelanshiEntity yuelanshi = yuelanshiService.selectById(id);
        if(yuelanshi !=null){
            //entity转view
            YuelanshiView view = new YuelanshiView();
            BeanUtils.copyProperties( yuelanshi , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YuelanshiEntity yuelanshi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yuelanshi:{}",this.getClass().getName(),yuelanshi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<YuelanshiEntity> queryWrapper = new EntityWrapper<YuelanshiEntity>()
            .eq("yuelanshi_name", yuelanshi.getYuelanshiName())
            .eq("yuelanshi_types", yuelanshi.getYuelanshiTypes())
            .eq("section_number", yuelanshi.getSectionNumber())
            .eq("zuowei_number", yuelanshi.getZuoweiNumber())
            .eq("yuelanshi_delete", yuelanshi.getYuelanshiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuelanshiEntity yuelanshiEntity = yuelanshiService.selectOne(queryWrapper);
        if(yuelanshiEntity==null){
            yuelanshi.setYuelanshiDelete(1);
            yuelanshi.setCreateTime(new Date());
            yuelanshiService.insert(yuelanshi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YuelanshiEntity yuelanshi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yuelanshi:{}",this.getClass().getName(),yuelanshi.toString());
        YuelanshiEntity oldYuelanshiEntity = yuelanshiService.selectById(yuelanshi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(yuelanshi.getYuelanshiPhoto()) || "null".equals(yuelanshi.getYuelanshiPhoto())){
                yuelanshi.setYuelanshiPhoto(null);
        }

            yuelanshiService.updateById(yuelanshi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YuelanshiEntity> oldYuelanshiList =yuelanshiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<YuelanshiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            YuelanshiEntity yuelanshiEntity = new YuelanshiEntity();
            yuelanshiEntity.setId(id);
            yuelanshiEntity.setYuelanshiDelete(2);
            list.add(yuelanshiEntity);
        }
        if(list != null && list.size() >0){
            yuelanshiService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<YuelanshiEntity> yuelanshiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            YuelanshiEntity yuelanshiEntity = new YuelanshiEntity();
//                            yuelanshiEntity.setYuelanshiName(data.get(0));                    //阅览室名称 要改的
//                            yuelanshiEntity.setYuelanshiPhoto("");//详情和图片
//                            yuelanshiEntity.setYuelanshiTypes(Integer.valueOf(data.get(0)));   //阅览室类型 要改的
//                            yuelanshiEntity.setSectionNumber(Integer.valueOf(data.get(0)));   //房间 要改的
//                            yuelanshiEntity.setZuoweiNumber(Integer.valueOf(data.get(0)));   //座位 要改的
//                            yuelanshiEntity.setYuelanshiDelete(1);//逻辑删除字段
//                            yuelanshiEntity.setYuelanshiContent("");//详情和图片
//                            yuelanshiEntity.setCreateTime(date);//时间
                            yuelanshiList.add(yuelanshiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        yuelanshiService.insertBatch(yuelanshiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<YuelanshiView> returnYuelanshiViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = yuelanshiOrderService.queryPage(params1);
        List<YuelanshiOrderView> orderViewsList =(List<YuelanshiOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(YuelanshiOrderView orderView:orderViewsList){
            Integer yuelanshiTypes = orderView.getYuelanshiTypes();
            if(typeMap.containsKey(yuelanshiTypes)){
                typeMap.put(yuelanshiTypes,typeMap.get(yuelanshiTypes)+1);
            }else{
                typeMap.put(yuelanshiTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("yuelanshiTypes",type);
            PageUtils pageUtils1 = yuelanshiService.queryPage(params2);
            List<YuelanshiView> yuelanshiViewList =(List<YuelanshiView>)pageUtils1.getList();
            returnYuelanshiViewList.addAll(yuelanshiViewList);
            if(returnYuelanshiViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = yuelanshiService.queryPage(params);
        if(returnYuelanshiViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnYuelanshiViewList.size();//要添加的数量
            List<YuelanshiView> yuelanshiViewList =(List<YuelanshiView>)page.getList();
            for(YuelanshiView yuelanshiView:yuelanshiViewList){
                Boolean addFlag = true;
                for(YuelanshiView returnYuelanshiView:returnYuelanshiViewList){
                    if(returnYuelanshiView.getId().intValue() ==yuelanshiView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnYuelanshiViewList.add(yuelanshiView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnYuelanshiViewList = returnYuelanshiViewList.subList(0, limit);
        }

        for(YuelanshiView c:returnYuelanshiViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnYuelanshiViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = yuelanshiService.queryPage(params);

        //字典表数据转换
        List<YuelanshiView> list =(List<YuelanshiView>)page.getList();
        for(YuelanshiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YuelanshiEntity yuelanshi = yuelanshiService.selectById(id);
            if(yuelanshi !=null){


                //entity转view
                YuelanshiView view = new YuelanshiView();
                BeanUtils.copyProperties( yuelanshi , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody YuelanshiEntity yuelanshi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yuelanshi:{}",this.getClass().getName(),yuelanshi.toString());
        Wrapper<YuelanshiEntity> queryWrapper = new EntityWrapper<YuelanshiEntity>()
            .eq("yuelanshi_name", yuelanshi.getYuelanshiName())
            .eq("yuelanshi_types", yuelanshi.getYuelanshiTypes())
            .eq("section_number", yuelanshi.getSectionNumber())
            .eq("zuowei_number", yuelanshi.getZuoweiNumber())
            .eq("yuelanshi_delete", yuelanshi.getYuelanshiDelete())
//            .notIn("yuelanshi_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuelanshiEntity yuelanshiEntity = yuelanshiService.selectOne(queryWrapper);
        if(yuelanshiEntity==null){
            yuelanshi.setYuelanshiDelete(1);
            yuelanshi.setCreateTime(new Date());
        yuelanshiService.insert(yuelanshi);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

