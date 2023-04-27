<template>
  <div class="datas">
    <div class="data_left">
      <div class="left_top">
        <div class="left_top_title">整体汇总分析</div>
        <div id="all" class="graph left_bottom_main"></div>
      </div>
      <div class="left_bottom">
        <div class="left_top_title">类型分析</div>
        <div id="type1" class="graph left_bottom_main"></div>
      </div>
    </div>
    <div class="data_right">
      <div class="right_top">
        <div class="left_top_title">类别分析</div>
        <div id="type2" class="graph right_top_main"></div>
      </div>
      <div class="right_bottom">
        <div class="left_top_title">交易项目地域分析</div>
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
          legend: {
            x : 'right',
            y : 'top',
            textStyle: {
              color:'#000000',
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
                color: "#000000",
              }
            }
          },
          yAxis: {
            name: '家',
            axisLine: {
              lineStyle: {
                color: "#000000",
              }
            },
            splitLine: {
              show: true,
              lineStyle:{
                color: '#000000',
              }
            }
          },
          series: [
            {
              type: 'bar',
              barMaxWidth: '10',
              itemStyle: {
                normal:{
                  color: '#1fceff'
                },
              },
            },
            {
              type: 'bar',
              barMaxWidth: '10',
              itemStyle: {
                normal:{
                  color: '#fff885',
                },
              },
            }
          ]
        },
        {
          legend: {
            x : 'right',
            y : 'top',
            textStyle: {
              color:'#000000',
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
              ['product', '交易金额', '交易宗数'],
              ['2019年', 1000000, 947],
              ['2020年', 1500000, 1208],
              ['2021年', 1800000, 1600],
              ['2022年', 1200000, 1270],
              ['2023年', 800000, 350]
            ]
          },
          xAxis: {
            type: 'category',
            axisLine: {
              lineStyle: {
                color: "#000000",
              }
            }
          },
          yAxis: [
            {
              name: '交易金额（元）',
              type: 'value',
              axisLine: {
                lineStyle: {
                  color: "#000000",
                }
              },
              splitLine: {
                show: true,
                lineStyle:{
                  color: '#000000',
                }
              },
              axisLabel: {
                formatter: function (value) {
                  return (value/10000).toFixed(1) + '万';
                }
              }
            },
            {
              name: '交易宗数（宗）',
              type: 'value',
              axisLine: {
                lineStyle: {
                  color: "#000000",
                }
              },
              splitLine: {
                show: true,
                lineStyle:{
                  color: '#000000',
                }
              }
            }
          ],
          series: [
            {
              name: '交易金额',
              type: 'bar',
              yAxisIndex: 0,
              barMaxWidth: '10',
              itemStyle: {
                normal:{
                  color: '#1fceff'
                },
              },
              label: {
                show: true,
                position: 'top',
                formatter: '{c}万元'
              }
            },
            {
              name: '交易宗数',
              type: 'bar',
              yAxisIndex: 1,
              barMaxWidth: '10',
              itemStyle: {
                normal:{
                  color: '#fff885',
                },
              },
              label: {
                show: true,
                position: 'top',
                formatter: '{c}宗'
              }
            }
          ]
        },
        {
          legend: {
            x : 'right',
            y : 'top',
            textStyle: {
              color:'#000000',
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
              ['product', '交易金额', '交易宗数'],
              ['2019年', 100000000, 947000],
              ['2020年', 150000000, 1208000],
              ['2021年', 180000000, 1600000],
              ['2022年', 120000000, 1270000],
              ['2023年', 80000000, 350000]
            ]
          },
          xAxis: {
            type: 'category',
            axisLine: {
              lineStyle: {
                color: "#000000",
              }
            }
          },
          yAxis: [
            {
              name: '交易金额（万元）',
              type: 'value',
              axisLine: {
                lineStyle: {
                  color: "#000000",
                }
              },
              splitLine: {
                show: true,
                lineStyle:{
                  color: '#000000',
                }
              },
              axisLabel: {
                formatter: '{value/10000}万'
              }
            },
            {
              name: '交易宗数（千次）',
              type: 'value',
              axisLine: {
                lineStyle: {
                  color: "#000000",
                }
              },
              splitLine: {
                show: true,
                lineStyle:{
                  color: '#000000',
                }
              },
              axisLabel: {
                formatter: '{value/1000}千'
              }
            }
          ],
          series: [
            {
              name: '交易金额',
              type: 'bar',
              yAxisIndex: 0,
              barMaxWidth: '10',
              itemStyle: {
                normal:{
                  color: '#1fceff'
                },
              },
              label: {
                show: true,
                position: 'top',
                formatter: '{c/10000}万'
              }
            },
            {
              name: '交易宗数',
              type: 'bar',
              yAxisIndex: 1,
              barMaxWidth: '10',
              itemStyle: {
                normal:{
                  color: '#fff885',
                },
              },
              label: {
                show: true,
                position: 'top',
                formatter: '{c/1000}千'
              }
            }
          ]
        },
        {
          grid: {
            top: '20px',
            left: '20px',
            right: '20px',
            bottom: '40px',
            containLabel: true
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'line',
              lineStyle: {
                color: '#6c757d'
              }
            }
          },
          legend: {
            top: '8px',
            textStyle: {
              color: '#000'
            },
            data: ['交易金额', '交易宗数']
          },
          dataset: {
            source: [
              ['product', '交易金额', '交易宗数'],
              ['2019年', 15848383, 8797],
              ['2020年', 17004720, 9420],
              ['2021年', 16094790, 8575],
              ['2022年', 17520416, 8965],
              ['2023年', 17645360, 9849]
            ]
          },
          xAxis: {
            type: 'category',
            axisLine: {
              lineStyle: {
                color: '#6c757d'
              }
            }
          },
          yAxis: [{
            name: '交易金额（万元）',
            type: 'value',
            splitLine: {
              lineStyle: {
                color: ['#dce2e8']
              }
            },
            axisLine: {
              lineStyle: {
                color: '#6c757d'
              }
            },
            axisLabel: {
              formatter: function (value, index) {
                return value / 10000;
              },
              lineHeight: 1 //增加坐标轴标签与坐标轴线的距离
            }

          },
            {
              name: '交易宗数（次）',
              type: 'value',
              splitLine: {
                lineStyle: {
                  color: ['#dce2e8']
                }
              },
              axisLine: {
                lineStyle: {
                  color: '#6c757d'
                }
              },
              axisLabel: {
                formatter: function (value, index) {
                  return value / 10000;
                },
                lineHeight: 7 //增加坐标轴标签与坐标轴线的距离
              }
            }
          ],
          series: [{
            name: '交易金额',
            type: 'line',
            smooth: true,
            yAxisIndex: 0,
            itemStyle: {
              normal: {
                color: '#007bff'
              }
            },
            lineStyle: {
              normal: {
                width: 2
              }
            },
            emphasis: {
              itemStyle: {
                normal: {
                  color: '#007bff'
                }
              }
            }
          },
            {
              name: '交易宗数',
              type: 'line',
              smooth: true,
              yAxisIndex: 1,
              itemStyle: {
                normal: {
                  color: '#20c997'
                }
              },
              lineStyle: {
                normal: {
                  width: 2
                }
              },
              emphasis: {
                itemStyle: {
                  normal: {
                    color: '#20c997'
                  }
                }
              }
            }
          ]
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
      var myChart = echarts.init(document.getElementById('area'));
      myChart.setOption(this.options[0]);
      var myChart1 = echarts.init(document.getElementById('type1'));
      myChart1.setOption(this.options[1]);
      var myChart2 = echarts.init(document.getElementById('type2'));
      myChart2.setOption(this.options[2]);
      var myChart3 = echarts.init(document.getElementById('all'));
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
