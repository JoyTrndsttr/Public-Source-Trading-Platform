import Vue from 'vue'
import Router from 'vue-router'
import Canvas from "../components/Canvas";
import Visualization from "../components/Visualization";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Visualization',
      component:Visualization
      // name: 'canvas',
      // component: Canvas
    }
  ]
})
