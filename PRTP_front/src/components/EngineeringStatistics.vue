<template>
  <div class="main">

<!--    <h1>EngineeringStatistics</h1>-->
    <div id="map" class="data_middle" style="width: 600px;height: 400px;left:200px"></div>
<!--    <h1>End</h1>-->
  </div>
</template>

<script>
import * as echarts from 'echarts';
import $ from "jquery";
import Highcharts from "highcharts";
export default {
  name: "EngineeringStatistics",
  data(){
    return{
      options:[
        {
          legend: {
            x : 'right',
            y : 'top',
            textStyle: {
              color:'#4ADEFE',
            }
          },
          grid:{
            x: 30,
            y: 50,
            x2: 0,
            y2: 45
          },
          tooltip: {},
          dataset: {
            source: [
              ['product', '中标家数', '投标家数'],
              ['2019年', 947, 1204],
              ['2020年', 1208, 1049],
              ['2021年', 1600, 1172],
              ['2022年', 1270, 1115],
              ['2023年', 350, 588]
            ]
          },
          xAxis: {
            type: 'category',
            axisLine: {
              lineStyle: {
                color: "#4ADEFE",
              }
            }
          },
          yAxis: {
            axisLine: {
              lineStyle: {
                color: "#4ADEFE",
              }
            },
            splitLine: {
              show: true,
              lineStyle:{
                color: '#4ADEFE',
              }
            }
          },
          series: [
            {
              type: 'bar',
              barMaxWidth: '10',
              itemStyle: {
                normal:{
                  color: '#4ADEFE'
                },
              },
            },
            {
              type: 'bar',
              barMaxWidth: '10',
              itemStyle: {
                normal:{
                  color: '#F3DB5C',
                },
              },
            }
          ]
        },
      ]
    }
  },
  mounted() {
    console.log(echarts.version)
    console.log(Highcharts.version)
    this.OSnow()
    this.numInit()
    setTimeout(()=>{
      var myChart = echarts.init(document.getElementById('map'));
      myChart.setOption(this.options[0]);
    })
  },
  methods: {
    OSnow() {
      var agent = navigator.userAgent.toLowerCase();
      var isMac = /macintosh|mac os x/i.test(navigator.userAgent);
      if (agent.indexOf("win32") >= 0 || agent.indexOf("wow32") >= 0) {
        $(".main").css("height", "880px");
      }
      if (agent.indexOf("win64") >= 0 || agent.indexOf("wow64") >= 0) {
        $(".main").css("height", "880px");
      }
      if (isMac) {

      }
    },
    numInit() {
      $('.counter-value').each(function () {
        $(this).prop('Counter', 0).animate({
          Counter: $(this).text()
        }, {
          duration: 2500,
          easing: 'swing',
          step: function (now) {
            $(this).text(now.toFixed(2));
          }
        });
      });
    },
  }
}
</script>

<style scoped>
@import '../assets/css/globle.css';
@import '../assets/css/index.css';
</style>
