<template>

  <el-container>
    <el-aside>
<!--      目前需要手动控制显示的页面-->
      <search-panel ref="searchPanel" @updateGraph="getQuerySearchResult"></search-panel>
      <detail-panel ref="detailPanel" @update="getQueryResult"></detail-panel>
      <common-panel ref="commonPanel" @updateGrh="getCommonResult"></common-panel>
<!--      <visualization ref="visualization"></visualization>-->
    </el-aside>

    <el-main>
      <div class="container"></div>
    </el-main>
  </el-container>
</template>

<script>
import * as d3 from 'd3'
import DetailPanel from "./DetailPanel";
import SearchPanel from "./SearchPanel";
import CommonPanel from "./CommonPanel";
import Visualization from "./Visualization";
export default {
  name: "Canvas",
  components:{Visualization, SearchPanel, DetailPanel,CommonPanel},
  data () {
    return {
      mode:0,//0代表可视化界面，1代表知识图谱界面
      svgArea:null,
      links:[],
      nodes:[],
      nodesName:[],
      linksName:[],
      simulation:null,
      scale:1,
      width:800,
      height:500,
      colorList:['#fd7623','#3388B1','#D82952','#F3D737','#409071','#D64E52'],
      testGraph:{
        "nodes": [],
        "links": []
      }

    }
  },
  created() {
    this.getGraphData()
  },
  methods: {
    getGraphData(){
      var _this = this
      this.axios.get("project/"+'all')
        // this.axios.get("project/all")
        .then(function (response) {
          console.log(response)
          console.log(response.data)
          for(var item in response.data){
            _this.testGraph["nodes"].push(response.data[item])
          }
          _this.initGraph(_this.testGraph)
          console.log(_this.testGraph)
        })
        .catch(function (error) {
          console.log(error)
        })
    },

    initGraph(data){
      const links = data.links;
      const nodes = data.nodes;

      this.simulation = d3.forceSimulation(nodes)
        .force("link", d3.forceLink(links).id(d => d.id).distance(150))
        .force("collide",d3.forceCollide().radius(()=>30))
        .force("charge", d3.forceManyBody().strength(-10))
        .force("center", d3.forceCenter(this.width / 2, this.height / 2));

      this.svgArea = d3.select(".container")
        .append("svg")
        .attr("viewBox", [0, 0, this.width, this.height])
        .call(d3.zoom().on("zoom",function () {
          g.attr("transform",d3.event.transform)
        }))

      this.addMarkers();

      const g = this.svgArea.append("g")
        .attr("class","content")

      this.links = g.append("g")
        .selectAll("path")
        .data(links,function (d) {
          if(typeof (d.source) === 'object'){
            return d.source.id+"_"+d.relationship+"_"+d.target.id
          }
          else{
            return d.source+"_"+d.relationship+"_"+d.target
          }
        })
        .join("path")
        .attr("marker-end", "url(#positiveMarker)")
        .attr("stroke-width", d => Math.sqrt(d.value))
        .attr("class","link")
        .attr("id",function (d) {
          if(typeof (d.source) === 'object'){
            return d.source.id+"_"+d.relationship+"_"+d.target.id
          }
          else{
            return d.source+"_"+d.relationship+"_"+d.target
          }
        })

      this.linksName = g.append("g")
        .selectAll("text")
        .data(links,function (d) {
          if(typeof (d.source) === 'object'){
            return d.source.id+"_"+d.relationship+"_"+d.target.id
          }
          else{
            return d.source+"_"+d.relationship+"_"+d.target
          }
        })
        .join("text")
        .style('text-anchor','middle')
        .style('fill', 'white')
        .style('font-size', '10px')
        .style('font-weight', 'bold');

      this.linksName
        .append('textPath')
        .attr('xlink:href',d =>"#"+d.source+"_"+d.relationship+"_"+d.target)
        .attr('startOffset','50%')
        .text(d=>d.relationship);

      this.nodes = g.append("g")
        .selectAll("circle")
        .data(nodes,d=>d.id)
        .join("circle")
        .attr("r", 30)
        .attr("class","node")
        .attr("fill", this.color)
        .on("click",this.select)
        .call(this.drag(this.simulation));

      this.nodes.append("title")
        .text(d => d.id);

      this.nodesName = g.append("g")
        .selectAll("text")
        .data(nodes)
        .join("text")
        .text(d => d.id)
        .attr("dx",function () {
          return this.getBoundingClientRect().width/2*(-1)
        })
        .attr("dy",50)
        .attr("class","nodeName")

      this.simulation.on("tick", () => {
        this.links
          .attr("d", function(d){
            if(d.source.x<d.target.x){
              return "M "+d.source.x+" "+ d.source.y +" L "+d.target.x+" "+d.target.y
            }
            else{
              return "M "+d.target.x+" "+ d.target.y +" L "+d.source.x+" "+d.source.y
            }
          })
          .attr("marker-end",function (d) {
            if(d.source.x<d.target.x){
              return "url(#positiveMarker)"
            }
            else{
              return null
            }
          })
          .attr("marker-start",function (d) {
            if(d.source.x<d.target.x){
              return null
            }
            else{
              return "url(#negativeMarker)"
            }
          })

        this.nodes
          .attr("cx", d => d.x)
          .attr("cy", d => d.y);

        this.nodesName
          .attr("x",d => d.x)
          .attr("y",d => d.y);
      });

    },

    addMarkers(){
      const positiveMarker = this.svgArea.append("marker")
        .attr("id","positiveMarker")
        .attr("orient","auto")
        .attr("stroke-width",2)
        .attr("markerUnits", "strokeWidth")
        .attr("markerUnits", "projectSpaceOnUse")
        .attr("viewBox", "0 -5 10 10")
        .attr("refX", 35)
        .attr("refY", 0)
        .attr("markerWidth", 12)
        .attr("markerHeight", 12)
        .append("path")
        .attr("d", "M 0 -5 L 10 0 L 0 5")
        .attr('fill', '#999')
        .attr("stroke-opacity", 0.6);
      const negativeMarker = this.svgArea.append("marker")
        .attr("id","negativeMarker")
        .attr("orient","auto")
        .attr("stroke-width",2)
        .attr("markerUnits", "strokeWidth")
        .attr("markerUnits", "projectSpaceOnUse")
        .attr("viewBox", "0 -5 10 10")
        .attr("refX", -25)
        .attr("refY", 0)
        .attr("markerWidth", 12)
        .attr("markerHeight", 12)
        .append("path")
        .attr("d", "M 10 -5 L 0 0 L 10 5")
        .attr('fill', '#999')
        .attr("stroke-opacity", 0.6);
    },

    updateGraph(data){
      const links = data.links;
      const nodes = data.nodes;
      console.log(links)

      this.links = this.links
        .data(links,function(d){
          if(typeof (d.source) === 'object'){
            return d.source.id+"_"+d.relationship+"_"+d.target.id
          }
          else{
            return d.source+"_"+d.relationship+"_"+d.target
          }
        })
        .join('path')
        .attr("stroke", "#999")
        .attr("stroke-opacity", 0.6)
        .attr("stroke-width", d => Math.sqrt(d.value))
        .attr("marker-end", "url(#positiveMarker)")
        .merge(this.links)
        .attr('id',function (d) {
          if(typeof (d.source) === 'object'){
            return d.source.id+"_"+d.relationship+"_"+d.target.id
          }
          else{
            return d.source+"_"+d.relationship+"_"+d.target
          }
        })
        .attr("class","link");

      this.linksName = this.linksName
        .data(links,function(d){
          if(typeof (d.source) === 'object'){
            return d.source.id+"_"+d.relationship+"_"+d.target.id
          }
          else{
            return d.source+"_"+d.relationship+"_"+d.target
          }
        })
        .join('text')
        .style('text-anchor','middle')
        .style('fill', 'white')
        .style('font-size', '10px')
        .style('font-weight', 'bold');

      this.linksName
        .append('textPath')
        .attr(
          'xlink:href',function (d) {
            if(typeof (d.source) === 'object'){
              return "#"+d.source.id+"_"+d.relationship+"_"+d.target.id
            }
            else{
              return "#"+d.source+"_"+d.relationship+"_"+d.target
            }
          }
        )
        .attr('startOffset','50%')
        .merge(this.linksName)
        .text(d=> d.relationship);


      this.nodes = this.nodes
        .data(nodes,d=>d.id)
        .join("circle")
        .attr("r", 30)
        .attr("class","node")
        .attr("fill", this.color)
        .merge(this.nodes)
        .on("click",this.select)
        .call(this.drag(this.simulation))

      this.nodes.append("title")
        .text(d => d.id);

      this.nodes.attr("cx", d => d.x)
        .attr("cy", d => d.y);

      this.nodesName =  this.nodesName
        .data(nodes)
        .join("text")
        .merge(this.nodesName)
        .text(function (d) {
          return d.id
        })
        .attr("dx",function () {
          return this.getBoundingClientRect().width/2*(-1)
        })
        .attr("dy",50)
        .attr("class","nodeName")

      this.simulation.nodes(nodes)
      this.simulation.force("link").links(links).distance(200)
      this.simulation.force("collide" ,d3.forceCollide().radius(()=>30))
      this.simulation.force("charge", d3.forceManyBody().strength(-10))
      this.simulation.alpha(0.2).restart()
    },

    color(d) {
      return this.colorList[d.group]
    },

    drag(simulation) {
      function dragstarted(d) {
        simulation.alphaTarget(0.3).restart();
        d.fx = d.x;
        d.fy = d.y;
      }

      function dragged(d) {
        d.fx = d3.event.x;
        d.fy = d3.event.y;
      }

      function dragended(d) {
        if (!d3.event.active) simulation.alphaTarget(0.5);
        d.fx = null
        d.fy = null
      }

      return d3.drag()
        .on("start", dragstarted)
        .on("drag", dragged)
        .on("end", dragended);
    },

    select(d){
      var _this = this
      let data = {}
      for(var i in d.obj){
        let ifArray = d.obj[i] instanceof Array
        if(!ifArray){
          data[i] = d.obj[i]
        }
      }
      _this.$refs.detailPanel.currentNode= data
      _this.$refs.detailPanel.ifShow = true
    },

    getQueryResult(result,currentNode,currentType){

        var nodeName = ''
        for(var item in currentNode){
          if(item === "projectId"){
            nodeName = currentNode.projectName
            break
          }
          else if(item === "tendereeId"){
            nodeName = currentNode.tendereeName
            break
          }
          else if(item === "winnerId"){
            nodeName = currentNode.winnerName
            break
          }
        }
        console.log(nodeName)

      for(var i=0;i<result.length;i++){//result:查询得到的节点组
        let flag = true
        for(var j=0;j<this.testGraph.nodes.length;j++){
          if(this.testGraph.nodes[j].id === result[i].id){
            flag = false
          }
        }
        if(flag){
          this.testGraph.nodes.push(result[i])
        }
        else{
          console.log("已存在的节点")
          console.log(result[i])
        }
        this.testGraph.links.push({
          "source":nodeName,
          "target":result[i].id,
          "value":5,
          "relationship":currentType
        })
      }

      for(var i=this.testGraph.links.length-1;i>=0;i--){
        if(this.testGraph.links[i].source.id === nodeName && this.testGraph.links[i].relationship !== currentType){
          let ifRemove = true;
          for(var k=0;k<result.length;k++){
            if(result[k].id === this.testGraph.links[i].target.id){
              ifRemove = false
              console.log("不移除此节点"+result[k].id)
              break
            }
          }
          if(ifRemove){
            console.log(this.testGraph.nodes)
            for(var j=this.testGraph.nodes.length-1;j>=0;j--){
              console.log("移除此节点"+this.testGraph.links[i].target.id)
              if(this.testGraph.nodes[j].id === this.testGraph.links[i].target.id){
                this.testGraph.nodes.splice(j, 1);
              }
            }
            console.log(this.testGraph.nodes)
          }
          this.testGraph.links.splice(i,1)
        }
      }
      this.updateGraph(this.testGraph)
    },

    getCommonResult(result,currentNode1,currentNode2,currentType){

      console.log(currentNode1)
      console.log(currentNode2)
      console.log(result)
      this.testGraph.nodes = []
      this.testGraph.links = []
      for(var i=0;i<result.length;i++){//result:查询得到的节点组
        let flag = true
        for(var j=0;j<this.testGraph.nodes.length;j++){
          if(this.testGraph.nodes[j].id === result[i].id){
            flag = false
          }
        }
        if(flag){
          this.testGraph.nodes.push(result[i])
        }
        else{
          console.log("已存在的节点")
          console.log(result[i])
        }
        if(result[i].id != currentNode1 && result[i].id != currentNode2){
          this.testGraph.links.push({
            "source":currentNode1,
            "target":result[i].id,
            "value":5,
            "relationship":currentType
          })
          this.testGraph.links.push({
            "source":currentNode2,
            "target":result[i].id,
            "value":5,
            "relationship":currentType
          })
        }

      }

      for(var i=this.testGraph.links.length-1;i>=0;i--){
        if(this.testGraph.links[i].source.id === currentNode1 && this.testGraph.links[i].source.id === currentNode2 && this.testGraph.links[i].relationship !== currentType){
          let ifRemove = true;
          for(var k=0;k<result.length;k++){
            if(result[k].id === this.testGraph.links[i].target.id){
              ifRemove = false
              console.log("不移除此节点"+result[k].id)
              break
            }
          }
          if(ifRemove){
            console.log(this.testGraph.nodes)
            for(var j=this.testGraph.nodes.length-1;j>=0;j--){
              console.log("移除此节点"+this.testGraph.links[i].target.id)
              if(this.testGraph.nodes[j].id === this.testGraph.links[i].target.id){
                this.testGraph.nodes.splice(j, 1);
              }
            }
            console.log(this.testGraph.nodes)
          }
          this.testGraph.links.splice(i,1)
        }
      }
      this.updateGraph(this.testGraph)
    },

    getQuerySearchResult(result,currentNode,currentType){
      var _this = this
      console.log(result)
      _this.testGraph["links"] = []
      if(result.length > 1){
        _this.testGraph["nodes"] = []
        for(var item in result){
          _this.testGraph["nodes"].push(result[item])
        }
      }
      else{
        _this.testGraph["nodes"] = [result]
      }
      _this.updateGraph(_this.testGraph)

    }
  }
}
</script>

<style>
body{
  margin: 0px;
}

.container{
  position: fixed;
  width: 600px;
  height: 400px;
  border: 1px solid #2c3e50;
  border-radius:8px;
  margin-top: 150px;
  margin-left: auto;
  margin-right: auto;
  background: #154360 repeating-linear-gradient(30deg,
  hsla(0, 0%, 100%, .1), hsla(0, 0%, 100%, .1) 15px,
  transparent 0, transparent 30px);
}
.node{
  stroke:#fff;
  stroke-width:1;
  cursor: pointer;
}

.node:hover{
  stroke-width:5;
}

.nodeName{
  fill:white;
}

</style>
