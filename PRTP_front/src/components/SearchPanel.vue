<template>
  <el-card class="box-card search-panel" shadow="hover">
    <div slot="header" class="clearfix">
      <span>搜索结点</span>
      <!--      <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>-->
    </div>
    <div class="text item">


      <el-form ref="form"  label-width="0px">
        <el-form-item>
          <el-select v-model="currentType" placeholder="请选择结点类型" class="type-select">
            <el-option v-for="(type,i) in nodeType" :label="type" :value="urls[i]" :key="type"></el-option>
          </el-select>
        </el-form-item>
        <el-input v-model="input" placeholder="请输入内容"></el-input>
        <el-form-item>
          <el-button type="primary" @click="onSubmit" class="submit-btn">搜索</el-button>
        </el-form-item>
      </el-form>

    </div>
  </el-card>
</template>

<script>
export default {
  name: "SearchPanel",
  data() {
    return {
      input:'',
      ifShow:false,
      currentNode:{},
      currentType:'',
      nodeType:['project','tenderee','winner'],
      urls:['project','tenderee','winner'],
    }
  },
  methods:{
    onSubmit(){
      var _this = this
      console.log(_this.input)
      console.log(_this.currentType)
      if(this.currentType === ""){
        this.$message.error('未选择任何类型');
        return
      }
      else{
        this.axios.get(_this.currentType + '/' +_this.input)
          .then(function (response) {
            console.log(response.data)
            _this.currentNode = response.data
            console.log(_this.currentNode)
            if(response.status === 200) {
              console.log(_this)
              _this.$emit('updateGraph',response.data,_this.currentType)
            }
          })
          .catch(function (error) {
            console.log(error)
          })
      }
      console.log(this.currentNode.projectName)
      console.log(this.currentType)
    }
  }
}
</script>

<style scoped>
.search-panel{
  position: fixed;
  left: 300px;
  top: 60px;
  border-radius: 4px;
  width: 200px;
  cursor: pointer;
}
.search-info{
  width: 50%;
  text-align: left;
  font-size: 12px;
  font-weight: bolder;
}
.type-select{
  margin-top: 25px;
  height: 20px;
}
.submit-btn{
  width: 100%;
  height: 30px;
  line-height: 0px;
  margin-top: 0px;
}
</style>
