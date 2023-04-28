<template>
  <div class="datas">
    <div class="data_left">
      <div class="left_top">
        <div class="left_top_title">交易金额分析</div>
        <div id="all" class="graph left_bottom_main"></div>
      </div>
      <div class="left_bottom">
        <div class="left_top_title">采购类型分析</div>
        <div id="type1" class="graph left_bottom_main"></div>
      </div>
    </div>
    <div class="data_right">
      <div class="right_top">
        <div class="left_top_title">交易宗数分析</div>
        <div id="type2" class="graph right_top_main"></div>
      </div>
      <div class="right_bottom">
        <div class="left_top_title">采购方式分析</div>
        <div id="area" class="graph right_top_main"></div>
      </div>
    </div>
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
          grid: {
            x: 50,
            y: 30,
            x2: 20,
            y2: 40,
          },
          tooltip: {},
          xAxis: {
            type: 'category',
            data: ['2019年', '2020年', '2021年', '2022年', '2023年'],
            axisLine: {
              lineStyle: {
                color: '#000000',
              },
            },
          },
          yAxis: {
            type: 'value',
            name: '交易金额（亿元）',
            axisLine: {
              lineStyle: {
                color: '#000000',
              },
            },
            splitLine: {
              show: true,
              lineStyle: {
                color: '#000000',
              },
            },
          },
          series: [{
            data: [826.49, 922.18, 1154.09, 692.48, 168.92],
            type: 'bar',
            barMaxWidth: 20,
            itemStyle: {
              normal: {
                color: '#4281f8'
              },
            },
          }],
        },
        {
          grid: {
            x: 50,
            y: 30,
            x2: 20,
            y2: 40,
          },
          tooltip: {},
          xAxis: {
            type: 'category',
            data: ['2019年', '2020年', '2021年', '2022年', '2023年'],
            axisLine: {
              lineStyle: {
                color: '#000000',
              },
            },
          },
          yAxis: {
            type: 'value',
            name: '交易宗数（宗）',
            axisLine: {
              lineStyle: {
                color: '#000000',
              },
            },
            splitLine: {
              show: true,
              lineStyle: {
                color: '#000000',
              },
            },
          },
          series: [{
            data: [1711,1777,1743,1488,309],
            type: 'bar',
            barMaxWidth: 20,
            itemStyle: {
              normal: {
                color: '#4281f8'
              },
            },
          }],
        },
        {
          grid: {
            x: 50,
            y: 30,
            x2: 20,
            y2: 40,
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'shadow'
            }
          },
          xAxis: {
            type: 'category',
            data: ['2019年', '2020年', '2021年', '2022年', '2023年'],
            axisLine: {
              lineStyle: {
                color: '#000000',
              },
            },
          },
          yAxis: {
            type: 'value',
            name: '交易金额（亿元）',
            axisLine: {
              lineStyle: {
                color: '#000000',
              },
            },
            splitLine: {
              show: true,
              lineStyle: {
                color: '#000000',
              },
            },
          },
          series: [{
            type: 'bar',
            name: '勘查',
            stack: '金额',
            data: [1.61, 3.24, 4.86, 3.24, 0.81],
            itemStyle: {
              normal: {
                color: '#FDB813'
              },
            },
          }, {
            type: 'bar',
            name: '设计',
            stack: '金额',
            data: [3.36, 6.72, 10.08, 6.72, 1.68],
            itemStyle: {
              normal: {
                color: '#58D68D'
              },
            },
          }, {
            type: 'bar',
            name: '监理',
            stack: '金额',
            data: [7.14, 14.28, 21.42, 14.28, 3.57],
            itemStyle: {
              normal: {
                color: '#FB9678'
              },
            },
          }, {
            type: 'bar',
            name: '施工',
            stack: '金额',
            data: [804.81, 1609.62, 2414.43, 1609.62, 402.41],
            itemStyle: {
              normal: {
                color: '#4281f8'
              },
            },
          }, {
            type: 'bar',
            name: '其他',
            stack: '金额',
            data: [9.58, 19.16, 28.74, 19.16, 4.79],
            itemStyle: {
              normal: {
                color: '#E99D9D'
              },
            },
          }],
        },
        {
          tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c}亿元 ({d}%)"
          },
          legend: {
            x : 'center',
            y : 'bottom',
            data: ['房建市政','交通','水利'],
            textStyle: {
              color:'#4ADEFE',
            }
          },
          series : [
            {
              name: '交易金额',
              type: 'pie',
              radius: ['30%', '55%'],
              center: ['45%', '35%'],
              avoidLabelOverlap: false,
              data:[
                {value:162.46, name:'房建市政'},
                {value:1.42, name:'交通'},
                {value:3.98, name:'水利'},
              ],
              itemStyle: {
                emphasis: {
                  shadowBlur: 10,
                  shadowOffsetX: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
              },
              label: {
                formatter: '{b}',
                textStyle: {
                  fontWeight: 'normal',
                  fontSize: 14,
                },
              },
            }
          ],
          color : ['#4281f8','#F3DB5D','#F77474'],
        }
      ]
    }
  },
  mounted() {
    console.log(echarts.version)
    console.log(Highcharts.version)
    this.OSnow()
    this.numInit()
    setTimeout(()=>{
      var myChart = echarts.init(document.getElementById('all'));
      myChart.setOption(this.options[0]);
      var myChart1 = echarts.init(document.getElementById('type2'));
      myChart1.setOption(this.options[1]);
      var myChart2 = echarts.init(document.getElementById('type1'));
      myChart2.setOption(this.options[2]);
      var myChart3 = echarts.init(document.getElementById('area'));
      myChart3.setOption(this.options[3]);
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
.datas {
  width: 95%;
  height: 80%;
  margin: auto;
  margin-top: 2%;
}
.data_left,.data_right {
  float: left;
  height: 100%;
}
.data_left {
  width: 500px;
}
.left_top {
  width: 100%;
  height: 48%;
}
.left_top_title {
  font-size: 16px;
  color: #000000;
  padding-left: 10%;
  padding-top: 6%;
}
.graph {
  //top: 10px;
  width: 450px;
  height: 300px;
  margin: auto;
  margin-top: 4%;
}
.left_bottom {
  width: 100%;
  height: 48%;
  margin-top: 7%;
}

.data_right {
  width: 500px;
}
.right_top {
  width: 100%;
  height: 48%;
}
.right_top_main {
  width: 95%;
}
.right_bottom {
  width: 100%;
  height: 48%;
  margin-top: 6%;
}
</style>
