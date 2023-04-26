<template>
  <div class="manage_page fillcontain">
    <el-row style="height: 100%;">
      <el-col :span="4"  style="min-height: 100vh; background-color: white;text-align: left">
        <el-menu :default-active="defaultActive" style="min-height: 100%;" theme="dark" router>
          <el-menu-item index="visualization"><i class="el-icon-menu"></i>数据可视化</el-menu-item>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-document"></i>数据源监控</template>
            <el-menu-item index="test">数据上报情况监控</el-menu-item>
            <el-menu-item index="shopList">交易数据采集情况监控</el-menu-item>
            <el-menu-item index="foodList">视频信息监控</el-menu-item>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title"><i class="el-icon-plus"></i>交易分析</template>
            <el-menu-item index="engineeringStatistics">工程建设统计</el-menu-item>
          </el-submenu>
          <el-submenu index="4">
            <template slot="title"><i class="el-icon-star-on"></i>主体分析</template>
            <el-menu-item index="canvas">投标人分析</el-menu-item>
            <el-menu-item index="winner">中标人分析</el-menu-item>
            <el-menu-item index="project">项目分析</el-menu-item>
            <!-- <el-menu-item index="newMember">用户数据</el-menu-item> -->
          </el-submenu>
        </el-menu>
      </el-col>
      <el-col :span="20" style="height: 100%;overflow: auto;">
<!--        <el-breadcrumb separator-class="el-icon-arrow-right">-->
<!--          <el-breadcrumb-item><i class="el-icon-monitor"></i> 数据源监控</el-breadcrumb-item>-->
<!--          <el-breadcrumb-item>数据上报情况监控</el-breadcrumb-item>-->
<!--        </el-breadcrumb>-->
        <head-top></head-top>
        <keep-alive>
          <router-view ></router-view>
        </keep-alive>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import headTop from "./headTop";
export default {
  components:{
    headTop
  },
  computed: {
    defaultActive: function(){
      return this.$route.path.replace('/', '');
    }
  },
}
</script>

<style lang="less" scoped>
  @import '../assets/less/mixin';
  .manage_page{
    min-height: 100vh;
    //background: url(../assets/images/bg.jpg);
  }
</style>
