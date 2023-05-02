<template>
  <div class="mid">
        <div class="left_top_title">交易热力图</div>
        <div id="all" class="graph left_bottom_main"></div>
  </div>
</template>

<script>
import * as echarts from 'echarts';
import $ from "jquery";
import Highcharts from "highcharts";
export default {
  name: "TradingHeatmap",
  data(){
    return{
      options:[
        {
          visualMap: {
            min: 150000000,
            max: 400000000,
            type: 'piecewise',
            orient: 'horizontal',
            left: 'center',
            bottom: '10%',
            pieces: [
              {min: 350000000, label: '4.00亿以上', color: '#7f1100'},
              {min: 300000000, max: 349999999, label: '3.50~4.00亿', color: '#ff5428'},
              {min: 250000000, max: 299999999, label: '3.00~3.50亿', color: '#ff8c71'},
              {min: 200000000, max: 249999999, label: '2.50~3.00亿', color: '#ffd768'},
              {min: 150000000, max: 199999999, label: '1.50~2.50亿', color: '#fefefe'}
            ]
          },
          calendar: {
            top: 'middle',
            left: 'center',
            range: '2022',
            cellSize: ['auto', 13],
            itemStyle: {
              normal: {borderWidth: 0.5, borderColor: '#ccc'}
            },
            yearLabel: {show: false}
          },
          series: {
            type: 'heatmap',
            coordinateSystem: 'calendar',
            data: [] // 初始为空
          }
        }
      ]
    }
  },
  created() {
    // 加载数据
    this.loadData();
  },
  mounted() {
    console.log(echarts.version)
    console.log(Highcharts.version)
    this.OSnow()
    this.numInit()
    setTimeout(()=>{
      var myChart = echarts.init(document.getElementById('all'));
      myChart.setOption(this.options[0]);
    })
  },
  methods: {
    loadData() {
      let data = [];
      for (let i = 1; i <= 12; i++) {
        for (let j = 1; j <= 31; j++) {
          let value = Math.floor(Math.random() * 250000000 + 150000000);
          let date = '2022/' + i.toString().padStart(2, '0') + '/' + j.toString().padStart(2, '0');
          data.push([new Date(date), value]);
        }
      }
      // 通过 $set 方法更新 data 属性的值
      this.$set(this.options[0].series, 'data', data);
      console.log(data)
      console.log(this.options)
    },
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
.mid {
  width: 1200px;
  height: 600px;
  margin: auto;
  margin-top: 2%;
}
.left_top_title {
  font-size: 32px;
  color: #000000;
  padding-left: 10%;
  padding-top: 6%;
}
.graph {
  //top: 10px;
  width: 1200px;
  height: 400px;
  margin: auto;
  margin-top: 4%;
}
</style>
