import Vue from 'vue'
import Router from 'vue-router'
import Canvas from "../components/Canvas";
import Visualization from "../components/Visualization";
import main from "../components/main"
import SearchPanel from "../components/SearchPanel";
import test from "../components/test";
import EngineeringStatistics from "../components/EngineeringStatistics";
import PurchaseStatistics from "../components/PurchaseStatistics";
import NatureResourceStatistics from "../components/NatureResourceStatistics";
import NationAssetsStatistics from "../components/NationAssetsStatistics";
import TradingHeatMap from "../components/TradingHeatMap";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'main',
      component:main,
      children:[
        {
          path: '/canvas',
          name: 'canvas',
          component: Canvas,
          meta: ['主体分析','投标人分析']
        },
        {
          path:'/tradingHeatmap',
          name:'tradingHeatmap',
          component: TradingHeatMap,
          meta: ['交易分析','交易热力图']
        },
        {
          path:'/engineeringStatistics',
          name:'engineeringStatistics',
          component: EngineeringStatistics,
          meta: ['交易分析','工程建设分析']
        },
        {
          path: '/purchaseStatistics',
          name: 'purchaseStatistics',
          component: PurchaseStatistics,
          meta: ['交易分析','采购项目统计']
        },
        {
          path: '/natureResourceStatistics',
          name: 'natureResourceStatistics',
          component: NatureResourceStatistics,
          meta: ['交易分析','自然资源交易统计']
        },
        {
          path: '/nationAssetsStatistics',
          name: 'nationAssetsStatistics',
          component: NationAssetsStatistics,
          meta: ['交易分析','国资交易统计']
        },
        {
          path:'/test',
          name:'test',
          component: test,
          meta: ['','']
        }
      ]
    },
    {
      path: '/visualization',
      name: 'visualization',
      component: Visualization
    },
  ]
})
