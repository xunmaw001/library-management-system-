
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
 * 阅览室座位预约
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yuelanshiOrder")
public class YuelanshiOrderController {
    private static final Logger logger = LoggerFactory.getLogger(YuelanshiOrderController.class);

    private static final String TABLE_NAME = "yuelanshiOrder";

    @Autowired
    private YuelanshiOrderService yuelanshiOrderService;


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
    private YuelanshiService yuelanshiService;//阅览室
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
        CommonUtil.checkMap(params);
        PageUtils page = yuelanshiOrderService.queryPage(params);

        //字典表数据转换
        List<YuelanshiOrderView> list =(List<YuelanshiOrderView>)page.getList();
        for(YuelanshiOrderView c:list){
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
        YuelanshiOrderEntity yuelanshiOrder = yuelanshiOrderService.selectById(id);
        if(yuelanshiOrder !=null){
            //entity转view
            YuelanshiOrderView view = new YuelanshiOrderView();
            BeanUtils.copyProperties( yuelanshiOrder , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(yuelanshiOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 阅览室
            //级联表
            YuelanshiEntity yuelanshi = yuelanshiService.selectById(yuelanshiOrder.getYuelanshiId());
            if(yuelanshi != null){
            BeanUtils.copyProperties( yuelanshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYuelanshiId(yuelanshi.getId());
            }
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
    public R save(@RequestBody YuelanshiOrderEntity yuelanshiOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yuelanshiOrder:{}",this.getClass().getName(),yuelanshiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            yuelanshiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        yuelanshiOrder.setCreateTime(new Date());
        yuelanshiOrder.setInsertTime(new Date());
        yuelanshiOrderService.insert(yuelanshiOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YuelanshiOrderEntity yuelanshiOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yuelanshiOrder:{}",this.getClass().getName(),yuelanshiOrder.toString());
        YuelanshiOrderEntity oldYuelanshiOrderEntity = yuelanshiOrderService.selectById(yuelanshiOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            yuelanshiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            yuelanshiOrderService.updateById(yuelanshiOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YuelanshiOrderEntity> oldYuelanshiOrderList =yuelanshiOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        yuelanshiOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<YuelanshiOrderEntity> yuelanshiOrderList = new ArrayList<>();//上传的东西
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
                            YuelanshiOrderEntity yuelanshiOrderEntity = new YuelanshiOrderEntity();
//                            yuelanshiOrderEntity.setYuelanshiOrderUuidNumber(data.get(0));                    //订单号 要改的
//                            yuelanshiOrderEntity.setYuelanshiId(Integer.valueOf(data.get(0)));   //阅览室 要改的
//                            yuelanshiOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            yuelanshiOrderEntity.setYuelanshiOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            yuelanshiOrderEntity.setYuelanshiOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            yuelanshiOrderEntity.setBuySectionNumber(Integer.valueOf(data.get(0)));   //房间 要改的
//                            yuelanshiOrderEntity.setBuyZuoweiNumber(data.get(0));                    //预约的座位 要改的
//                            yuelanshiOrderEntity.setBuyYuelanshiTime(sdf.parse(data.get(0)));          //订购日期 要改的
//                            yuelanshiOrderEntity.setInsertTime(date);//时间
//                            yuelanshiOrderEntity.setCreateTime(date);//时间
                            yuelanshiOrderList.add(yuelanshiOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单号
                                if(seachFields.containsKey("yuelanshiOrderUuidNumber")){
                                    List<String> yuelanshiOrderUuidNumber = seachFields.get("yuelanshiOrderUuidNumber");
                                    yuelanshiOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yuelanshiOrderUuidNumber = new ArrayList<>();
                                    yuelanshiOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("yuelanshiOrderUuidNumber",yuelanshiOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单号
                        List<YuelanshiOrderEntity> yuelanshiOrderEntities_yuelanshiOrderUuidNumber = yuelanshiOrderService.selectList(new EntityWrapper<YuelanshiOrderEntity>().in("yuelanshi_order_uuid_number", seachFields.get("yuelanshiOrderUuidNumber")));
                        if(yuelanshiOrderEntities_yuelanshiOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YuelanshiOrderEntity s:yuelanshiOrderEntities_yuelanshiOrderUuidNumber){
                                repeatFields.add(s.getYuelanshiOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yuelanshiOrderService.insertBatch(yuelanshiOrderList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = yuelanshiOrderService.queryPage(params);

        //字典表数据转换
        List<YuelanshiOrderView> list =(List<YuelanshiOrderView>)page.getList();
        for(YuelanshiOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YuelanshiOrderEntity yuelanshiOrder = yuelanshiOrderService.selectById(id);
            if(yuelanshiOrder !=null){


                //entity转view
                YuelanshiOrderView view = new YuelanshiOrderView();
                BeanUtils.copyProperties( yuelanshiOrder , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(yuelanshiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    YuelanshiEntity yuelanshi = yuelanshiService.selectById(yuelanshiOrder.getYuelanshiId());
                if(yuelanshi != null){
                    BeanUtils.copyProperties( yuelanshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYuelanshiId(yuelanshi.getId());
                }
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
    public R add(@RequestBody YuelanshiOrderEntity yuelanshiOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yuelanshiOrder:{}",this.getClass().getName(),yuelanshiOrder.toString());
            YuelanshiEntity yuelanshiEntity = yuelanshiService.selectById(yuelanshiOrder.getYuelanshiId());
            if(yuelanshiEntity == null){
                return R.error(511,"查不到该阅览室");
            }
            // Double yuelanshiNewMoney = yuelanshiEntity.getYuelanshiNewMoney();

            if(false){
            }
            List<String> buyZuoweiNumberList = new ArrayList<>(Arrays.asList(yuelanshiOrder.getBuyZuoweiNumber().split(",")));//这次购买的座位
            List<String> beforeBuyZuoweiNumberList = new ArrayList<>();//之前已经购买的座位

                    //某天日期的某个分段
            List<YuelanshiOrderEntity> yuelanshiOrderEntityList =
                        yuelanshiOrderService.selectList(new EntityWrapper<YuelanshiOrderEntity>()
                        .eq("yuelanshi_id", yuelanshiOrder.getYuelanshiId())
                        .eq("buy_section_number", yuelanshiOrder.getBuySectionNumber())
                        .notIn("yuelanshi_order_types",102)//已取消预约的订单

                        );
            for(YuelanshiOrderEntity d:yuelanshiOrderEntityList){
                beforeBuyZuoweiNumberList.addAll(Arrays.asList(d.getBuyZuoweiNumber().split(",")));
            }
            buyZuoweiNumberList.retainAll(beforeBuyZuoweiNumberList);//判断当前购买list包含已经被购买的list中是否有重复的  有的话 就保留
            if(buyZuoweiNumberList != null && buyZuoweiNumberList.size()>0 ){
                return R.error(511,buyZuoweiNumberList.toString()+" 的座位已经被使用");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            yuelanshiOrder.setYuelanshiOrderTypes(101); //设置订单状态为已预约
            yuelanshiOrder.setYuelanshiOrderTruePrice(0.0); //设置实付价格
            yuelanshiOrder.setYonghuId(userId); //设置订单支付人id
            yuelanshiOrder.setYuelanshiOrderUuidNumber(String.valueOf(new Date().getTime()));
            yuelanshiOrder.setInsertTime(new Date());
            yuelanshiOrder.setCreateTime(new Date());
                yuelanshiOrderService.insert(yuelanshiOrder);//新增订单


            return R.ok();
    }


    /**
    * 取消预约
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            YuelanshiOrderEntity yuelanshiOrder = yuelanshiOrderService.selectById(id);//当前表service
            Integer buyNumber = yuelanshiOrder.getBuyZuoweiNumber().split(",").length;
            Integer yuelanshiId = yuelanshiOrder.getYuelanshiId();
            if(yuelanshiId == null)
                return R.error(511,"查不到该阅览室");
            YuelanshiEntity yuelanshiEntity = yuelanshiService.selectById(yuelanshiId);
            if(yuelanshiEntity == null)
                return R.error(511,"查不到该阅览室");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            Double zhekou = 1.0;

                //计算金额

                //计算所获得积分
                Double buyJifen = 0.0;





            yuelanshiOrder.setYuelanshiOrderTypes(102);//设置订单状态为已取消预约
            yuelanshiOrderService.updateById(yuelanshiOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            yuelanshiService.updateById(yuelanshiEntity);//更新订单中阅览室的信息

            return R.ok();
    }

    /**
     * 使用
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id  , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        YuelanshiOrderEntity  yuelanshiOrderEntity = yuelanshiOrderService.selectById(id);
        yuelanshiOrderEntity.setYuelanshiOrderTypes(103);//设置订单状态为已使用
        yuelanshiOrderService.updateById( yuelanshiOrderEntity);

        return R.ok();
    }


}

