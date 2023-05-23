<template>
  <div class="main">
    <div class="top_title">

      <img src="../assets/images/top_title.png"/>
    </div>
    <div class="datas">
      <div class="data_left">
        <div class="left_top">
          <div class="left_top_title">本月交易动态</div>
          <div class="left_top_main">
            <div class="left_main_circle">
              <p class="counter-value circle_num1">479</p>
              <span class="span_font">注册企业<br/>(个)</span>
            </div>
            <div class="left_main_circle">
              <p class="counter-value circle_num2">185</p>
              <span class="span_font">入场登记<br/>(家)</span>
            </div>
            <div class="left_main_circle">
              <p class="counter-value circle_num3">69</p>
              <span class="span_font">交易场次<br/>(次)</span>
            </div>
            <div class="left_main_circle">
              <p class="counter-value circle_num4">633</p>
              <span class="span_font">发布公告<br/>(条)</span>
            </div>
          </div>
        </div>
        <div class="left_bottom">
          <div class="left_top_title">本年度交易数据</div>
          <div id="Business_type" class="left_top_main left_bottom_main" style="width: 300px;height:200px"></div>
        </div>
      </div>
      <div class="data_middle">
        <div class="middle_top">
          <div class="middle_top_list">
            <div class="list_title">年度交易金额</div>
            <div class="list_num list_num1"><span class="counter-value">714.63</span>亿元</div>
            <div class="today_list_font">今日交易金额<span>2.65</span>亿元</div>
          </div>
          <div class="middle_top_list">
            <div class="list_title">年度交易宗数</div>
            <div class="list_num list_num2"><span class="counter-value">746</span>宗</div>
            <div class="today_list_font">今日交易场次<span>27</span>场</div>
          </div>
          <div class="middle_top_list">
            <div class="list_title">市场主体总数</div>
            <div class="list_num list_num3"><span class="counter-value">28295</span>家</div>
            <div class="today_list_font">市场主体活跃度指数<span>29.04</span></div>
          </div>
        </div>
        <div id="map" class="middle_bottom"></div>
      </div>
      <div class="data_right">
        <div class="right_top">
          <div class="left_top_title">省外主体Top5</div>
          <div id="Land_analysis" class="left_top_main right_top_main" style="width: 300px;height:200px"></div>
        </div>
        <div class="right_bottom">
          <div class="left_top_title">市场开放趋势</div>
          <div id="Information_Delivery" class="left_top_main right_top_main" style="width: 300px;height:200px"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import $ from 'jquery'
import * as echarts from 'echarts';
// import * as HighCharts from 'highcharts'
import Highcharts from 'highcharts'
// import hunan from '../assets/pack/hunan'

export default {
  name: "Visualization",
  components:{},
  data(){
    return{
      options:[
        // 指定图表的配置项和数据
        {
          tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
          },
          legend: {
            x : 'center',
            y : 'bottom',
            data: ['工程建设','政府采购','土地','产权','其他'],
            textStyle: {
              color:'#4ADEFE',
            }
          },
          series : [
            {
              name: '访问来源',
              type: 'pie',
              radius: ['30%', '55%'],
              center: ['45%', '35%'],
              avoidLabelOverlap: false,
              data:[
                {value:168.92, name:'工程建设'},
                {value:22.11, name:'政府采购'},
                {value:36.14, name:'土地'},
                {value:20.98, name:'其他'},
                {value:487.47, name:'产权'}

              ],
              itemStyle: {
                emphasis: {
                  shadowBlur: 10,
                  shadowOffsetX: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
              }
            }
          ],
          color : ['#F3DB5D','#009AFF','#F77474','#28DCCF','#FF5937']
        },
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
              ['product', '市场主体数', '活跃指数'],
              ['广东省', 2005, 52.22],
              ['北京市', 1421, 37.01],
              ['江苏省', 1020, 26.56],
              ['浙江省', 766, 20.00],
              ['湖南省', 651, 17.00],
            ]
          },
          xAxis: {
            type: 'category',
            axisLine: {
              show: false,
              lineStyle: {
                color: "#4ADEFE",
              },
            },
            // data: ["岳阳市","益阳市","长沙市","株洲市","衡阳市","永州市","娄底市","郴州市","湘潭市"],
            axisTick: {
              alignWithLabel: true
            }
          },
          yAxis: {
            axisLine: {
              lineStyle: {
                color: "#4ADEFE",
              }
            },
            splitLine: {
              lineStyle: {
                color: '#4ADEFE'
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
              ['product', '交易金额', '交易宗数'],
              ['2019年', 826.49, 1711],
              ['2020年', 922.18, 1777],
              ['2021年', 1154.09, 1743],
              ['2022年', 692.48, 1488],
              ['2023年', 168.92, 309]
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
        // {
        //   title: {
        //     text: ''
        //   },
        //   tooltip: {
        //     enabled: false
        //   },
        //   chart: {
        //     backgroundColor: 'transparent',
        //   },
        //   legend: {
        //     enabled: true,
        //   },
        //   colorAxis: {
        //     minColor: '#0666D5',
        //     maxColor: '#062A6C'
        //   },
        //   series: [{
        //     data: this.Random_data,
        //     borderColor: '#6099EC',
        //     borderWidth: 0.5,
        //     mapData: Highcharts.maps['cn/hunan'],
        //     name: '',
        //     joinBy: ['name'], // 根据 name 属性进行关联
        //     states: {
        //       enabled: true,
        //       hover: {
        //         color: '#F3DB5C'
        //       }
        //     },
        //     dataLabels: {
        //       enabled: true,
        //       color: '#4ADEFE',
        //       format: '{point.name}'
        //     },
        //     cursor: 'pointer',
        //     events: {
        //       // click: function(e) {
        //       //   if(e.point.name == "长沙") {
        //       //     $(".list_num1 span").text('6666');
        //       //     $(".list_num2 span").text('903.22');
        //       //     $(".list_num3 span").text('1356.77');
        //       //
        //       //     $(".circle_num1").text('1800.35');
        //       //     $(".circle_num2").text('892.95');
        //       //     $(".circle_num3").text('2016.15');
        //       //
        //       //     this.option[0].series[0].data = [
        //       //       {value:100, name:'土地经营权'},
        //       //       {value:240, name:'土地流转权'},
        //       //       {value:130, name:'房屋所有权'},
        //       //       {value:200, name:'集体建设用地'},
        //       //       {value:400, name:'林权'}
        //       //     ]
        //       //     myChart1.setOption(option1);
        //       //
        //       //     data[0].color = "#F3DB5C";
        //       //     new Highcharts.Map('map', this.options[3]);
        //       //     this.numInit();
        //       //   }
        //       // }
        //     }
        //   }]
        // }
      ],
      Random_data:[
        {"name":"长沙","value":46},
        {"name":"株洲","value":81},
        {"name":"湘潭","value":94},
        {"name":"衡阳","value":40},
        {"name":"邵阳","value":67},
        {"name":"岳阳","value":38},
        {"name":"常德","value":50},
        {"name":"张家界","value":48},
        {"name":"益阳","value":77},
        {"name":"郴州","value":78},
        {"name":"永州","value":57},
        {"name":"怀化","value":83},
        {"name":"娄底","value":43},
        {"name":"湘西","value":75}
      ]
    }
  },
  mounted() {
    console.log(echarts.version)
    console.log(Highcharts.version)
    // console.log(hunan.features)
    this.OSnow()
    this.numInit()
    // 基于准备好的dom，初始化echarts实例
    //需要延迟加载
    setTimeout(()=>{
      var i = 0;
      var myChart1 = echarts.init(document.getElementById('Business_type'));
      myChart1.setOption(this.options[0]);
      var myChart2 = echarts.init(document.getElementById('Land_analysis'));
      myChart2.setOption(this.options[1]);
      var myChart3 = echarts.init(document.getElementById('Information_Delivery'));
      myChart3.setOption(this.options[3]);
      //自己写的
      var myChart4 = echarts.init(document.getElementById('map'));
      myChart4.setOption(this.options[2]);
      // 初始化图表
      // var map = new Highcharts.Map('map', this.options[3]);
    })
  },
  methods:{
    OSnow(){
      var agent = navigator.userAgent.toLowerCase();
      var isMac = /macintosh|mac os x/i.test(navigator.userAgent);
      if (agent.indexOf("win32") >= 0 || agent.indexOf("wow32") >= 0) {
        $(".main").css("height","880px");
      }
      if (agent.indexOf("win64") >= 0 || agent.indexOf("wow64") >= 0) {
        $(".main").css("height","880px");
      }
      if(isMac){

      }
    },
    numInit() {
      $('.counter-value').each(function(){
        $(this).prop('Counter',0).animate({
          Counter: $(this).text()
        },{
          duration: 2500,
          easing: 'swing',
          step: function (now){
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
