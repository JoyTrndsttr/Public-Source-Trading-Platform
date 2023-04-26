import Vue from 'vue'
import Router from 'vue-router'
import Canvas from "../components/Canvas";
import Visualization from "../components/Visualization";
import main from "../components/main"
import SearchPanel from "../components/SearchPanel";
import test from "../components/test";
import EngineeringStatistics from "../components/EngineeringStatistics";

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
          path:'/engineeringStatistics',
          name:'engineeringStatistics',
          component: EngineeringStatistics,
          meta: ['交易分析','工程建设分析']
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
