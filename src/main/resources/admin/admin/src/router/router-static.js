import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import news from '@/views/modules/news/list'
    import tushu from '@/views/modules/tushu/list'
    import tushuLiuyan from '@/views/modules/tushuLiuyan/list'
    import tushuOrder from '@/views/modules/tushuOrder/list'
    import tushuYuyue from '@/views/modules/tushuYuyue/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yuelanshi from '@/views/modules/yuelanshi/list'
    import yuelanshiOrder from '@/views/modules/yuelanshiOrder/list'
    import config from '@/views/modules/config/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryTushu from '@/views/modules/dictionaryTushu/list'
    import dictionaryTushuOrder from '@/views/modules/dictionaryTushuOrder/list'
    import dictionaryTushuYuyueYesno from '@/views/modules/dictionaryTushuYuyueYesno/list'
    import dictionaryYuelanshi from '@/views/modules/dictionaryYuelanshi/list'
    import dictionaryYuelanshiOrder from '@/views/modules/dictionaryYuelanshiOrder/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryNews',
        name: '资讯类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryTushu',
        name: '图书类型',
        component: dictionaryTushu
    }
    ,{
        path: '/dictionaryTushuOrder',
        name: '借阅类型',
        component: dictionaryTushuOrder
    }
    ,{
        path: '/dictionaryTushuYuyueYesno',
        name: '报名状态',
        component: dictionaryTushuYuyueYesno
    }
    ,{
        path: '/dictionaryYuelanshi',
        name: '阅览室类型',
        component: dictionaryYuelanshi
    }
    ,{
        path: '/dictionaryYuelanshiOrder',
        name: '订单类型',
        component: dictionaryYuelanshiOrder
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/news',
        name: '资讯',
        component: news
      }
    ,{
        path: '/tushu',
        name: '图书',
        component: tushu
      }
    ,{
        path: '/tushuLiuyan',
        name: '图书评论',
        component: tushuLiuyan
      }
    ,{
        path: '/tushuOrder',
        name: '图书借阅',
        component: tushuOrder
      }
    ,{
        path: '/tushuYuyue',
        name: '图书归还申请',
        component: tushuYuyue
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/yuelanshi',
        name: '阅览室',
        component: yuelanshi
      }
    ,{
        path: '/yuelanshiOrder',
        name: '阅览室座位预约',
        component: yuelanshiOrder
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
