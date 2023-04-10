#  毕业设计

## 爬虫

- 爬取网站：[全国公共资源交易平台（陕西省宝鸡市）](http://ggzy.baoji.gov.cn/jydt/001001/001001001/001001001003/subPage.html#)

- 学习网站：[python爬虫入门实战案例教程-入门到精通（收藏版）](https://www.bilibili.com/video/BV1CY411f7yh/?p=3&vd_source=85c9463248b682d1416040a6e43bb69e)
  - Pycharm学生pack获取：[Student Pack License](https://account.jetbrains.com/licenses)

### 爬虫知识

#### 简单爬虫架构

<img src="/Users/wangke/Desktop/毕设相关/毕业设计图片/简单爬虫架构.png" alt="image-20230404135657344" style="zoom:25%;" />

#### requests库

<img src="/Users/wangke/Desktop/毕设相关/毕业设计图片/request网页下载库.png" alt="image-20230404140303501" style="zoom:25%;" />

<img src="/Users/wangke/Library/Application Support/typora-user-images/image-20230404140358093.png" alt="image-20230404140358093" style="zoom:25%;" />

<img src="/Users/wangke/Desktop/毕设相关/毕业设计图片/response响应.png" alt="image-20230404140738253" style="zoom:25%;" />

#### URL管理器

<img src="/Users/wangke/Desktop/毕设相关/毕业设计图片/URL管理器.png" alt="image-20230406203225436" style="zoom:25%;" />

#### HTML简介

<img src="/Users/wangke/Desktop/毕设相关/毕业设计图片/HTML简介.png" alt="image-20230407133959340" style="zoom:25%;" />

#### 网页解析器-Beautiful Soup

- 官网链接：[Beautiful Soup](https://www.crummy.com/software/BeautifulSoup/)
- 中文文档：[Beautiful Soup 4.4.0 文档](https://www.crummy.com/software/BeautifulSoup/bs4/doc.zh/)

<img src="/Users/wangke/Desktop/毕设相关/毕业设计图片/Beautiful Soup语法.png" alt="image-20230407135159382" style="zoom:25%;" />

### 爬虫分模块学习与测试

#### 新建项目与包安装

- 新建项目，选择虚拟环境Virturalenv，Python3.7

- 安装各种包：

  - 位置：

    <img src="/Users/wangke/Desktop/毕设相关/毕业设计图片/安装各种包.png" alt="截屏2023-04-04 13.38.52" style="zoom: 25%;" />

  - 包内容：requests、beautifulsoup4、selenium（点击➕安装各种包），后来要增加openpyxl

  - 测试是否安装成功：

    <img src="/Users/wangke/Desktop/毕设相关/毕业设计图片/测试是否安装成功.png" alt="截屏2023-04-04 13.46.48" style="zoom: 25%;" />

#### 使用命令行与ipython以及requests库使用

- 安装ipython:`python3.7 -m pip install ipython `

  <img src="/Users/wangke/Desktop/毕设相关/毕业设计图片/安装ipython.png" alt="image-20230404141418629" style="zoom:25%;" />

- 直接测试要访问的网站：`ipython` 进入环境

  ```python
  In [1]: clear
  
  In [2]: import requests
  
  In [3]: url = "http://ggzy.baoji.gov.cn/jydt/001001/001001001/001001001003/20230403/769f6a4b-1aa7-4de0-bcf0-004545fa8fe1.html"
  
  In [4]: r = request.get(url)
  ---------------------------------------------------------------------------
  NameError                                 Traceback (most recent call last)
  <ipython-input-4-78d93e84fe98> in <module>
  ----> 1 r = request.get(url)
  
  NameError: name 'request' is not defined
  
  In [5]: r = requests.get(url)
  
  In [6]: r.status_code
  Out[6]: 200
  
  In [7]: r.headers
  Out[7]: {'SS': 's                    ', 'Date': 'Tue, 04 Apr 2023 06:17:27 GMT', 'Content-Type': 'text/html; charset=utf-8', 'Transfer-Encoding': 'chunked', 'Connection': 'keep-alive', 'Last-Modified': 'Mon, 03 Apr 2023 06:33:26 GMT', 'ETag': 'W/"642a7336-1b67"', 'Expires': 'Tue, 04 Apr 2023 06:17:27 GMT', 'Cache-Control': 'no-cache', 'X-Content-Type-Options': 'nosniff', 'X-Xss-Protection': '1', 'Content-Encoding': 'gzip'}
  
  In [8]: r.encodeing
  ---------------------------------------------------------------------------
  AttributeError                            Traceback (most recent call last)
  <ipython-input-8-282c2c621e8c> in <module>
  ----> 1 r.encodeing
  
  AttributeError: 'Response' object has no attribute 'encodeing'
  
  In [9]: r.encoding
  Out[9]: 'utf-8'
  
  In [10]: r.text
  Out[10]: '<!DOCTYPE html>\r\n<html lang="zh-CN">\r\n\r\n\t<head>\r\n\t\t<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">\r\n<meta http-equiv="X-UA-Compatible" content="IE=Edge">\r\n\t\t<meta name="SiteName" content="陕西省公共资源交易中心">\r\n\t\t<meta name="SiteDomain" content="www.sxggzyjy.cn">\r\n\t\t<meta name="SiteIDCt="CA270000000608922730002">\r\n\t\t<meta name="Description" content="陕西省公共资源交易中心">\r\n\t\t<meta name="Keywords" content="新闻资讯，交易信息，办事指南，诚信公开"" href="/js/lib/chosen/chosen.css">\r\n\t\t<link rel="stylesheet" href="/css/common.css?0.1234">\r\n\t\t<link rel="stylesheet" href="/css/subCommon.css?0.1234">\r\n\t\t<link rel="stylesheet" href="/css/detail-page.css?0.1234">\r\n\t\t<script src="/js/lib/jquery.js"></script>\r\n\t\t<title>全国公共资源交易平台（陕西省·宝鸡市）</title>\r\n\t\r\lesheet" href="/css/webBuilderCommonGray.css"></head>\r\n\r\n\t<body>\r\n\t\t<!-- header -->\r\n\t\t<div id="header"></div>\r\n\t\t<script type="text/javascript">\r\n\t\t\tfunction ChangeColor(ColorName) { document.getElementById("c").style.background = ColorName }\r\n\t\t</script>\r\n\t\t<div class="ewb-container ewb-container2">\r\n\t\t\t<!-- location -->\r\n\t\t\t<div class="ewb-location">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t您所在的位置：\r\n\t\t\t\t\t<a href="/">首页</a> &gt;<a href="/jydt/trading.html" >交易大厅<ef="/jydt/001001/subPage.html" >交易公告</a> &gt;<a href="/jydt/001001/001001001/subPage.html" >工程建设项目招标投标</a> &gt;<span id="viewGuid" value="cms_769f6a4b-1aa7-4dfa8fe1">中标/成交公示</span></p>\r\n\t\t\t</div>\r\n\t\t\t<!--startprint-->\r\n\t\t\t<div class="ewb-main" id="c">\r\n\t\t\t\t\r\n\t\t\t\t\t\t\t<h3 class="article-title">宝022 年大中型水库移民后期扶持项目施工Ⅷ标标项中标结果公示</h3>\r\n\t\t\t\t\t\t\t<div class="info-source">\r\n\t\t\t\t\t\t\t\t【信息来源：宝鸡市】\r\n\t\t\t\t\t\t\t\t【信息时间\n\t\t\t\t\t\t\t\t【浏览次数：<span id="infoViewCount"></span>】\r\n\t\t\t\t\t\t\t\t【字号： <a href="javascript:setfont(18)">大</a> <a href="javascript:setfont(16)">中</a>ascript:setfont(14)">小</a>】\r\n\t\t\t\t\t\t\t\t【<a href="javascript:window.print()">我要打印</a>】\r\n\t\t\t\t\t\t\t\t【<a href="javascript:window.close();">关闭</a>】\r\t\t\t<div class="ewb-m-r r" style="width:138px;*margin-top:-30px;">\r\n\t\t\t\t\t                <div class="bdsharebuttonbox"><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a></div>\r\n<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdMini":"2","bdPic":"","bdStyle":"0","bdSize":"16"},"share":{}};with(document)0[(getElementsByTagName(\'head\')[0]||body).appendChild(createElement(\'script\')).src=\'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=\'+~(-new Date()/36e5)];</script>\r\n\t\t\t\t\t            </div> \r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<font style="float: right;margin-right: 10%;margin-top: 10px;">视力保护色：\r\n\t\t\t\t\t\t\t\t<input onclick="ChangeColor(\'#f9f5f1\')" type="button" name="bgcolor" "width:15px;height:15px;background-color:#f9f5f1" height="15" width="15" align="absmiddle">\r\n\t\t\t\t\t\t\t\t<input onclick="ChangeColor(\'#9DDBF4\')" type="button" name="bgcolor22" style="width:15px;height:15px;background-color:#9DDBF4" height="15" width="15" align="absmiddle">\r\n\t\t\t\t\t\t\t\t<input onclick="ChangeColor(\'#DEDEDE\')" type="button" name="bgcolor2" style="width:15px;height:15px;background-color:#DEDEDE" height="15" width="15" align="absmiddle">\r\n\t\t\t\t\t\t\t\t<input onclick="ChangeColor(\'#F9D1D9\')" type="button" name="bgcolor2" style="width:15px;height:15px;background-color:#F9D1D9" height="15" width="15" align="absmiddle">\r\n\t\t\t\t\t\t\t\t<input onclick="ChangeColor(\'#E4C8F8\')" type="button" name="bgcolor2" style="width:15px;height:15px;background-color:#E4C8F8" height="15" width="15" align="absmiddle">\r\n\t\t\t\t\t\t\t\t<input onclick="ChangeColor(\'#ffffff\')" type="button" name="bgcolor2" height="15" style="width:15px;height:15px;background-color:#ffffff" width="15" align="absmiddle">\r\n\t\t\t\t\t\t\t</font>\r\n\t\t\t\t\t\t\t<div class="epoint-article-content" id="mainContent">\r\n\t\t\t\t\t\t\t\t<p><span style="font-size: 12pt;">(招标编号： HBJZ-2023-005)\n</span><br>\n<br>\n<br>\n<br>\n<span style="font-size: 12pt;">一、中标人信息：\n</span><br>\n<span style="font-size: 12pt;">标段(包)[008]宝鸡市凤翔区 2022 年大中span></p>\n<p><span style="font-size: 12pt;">中标人：陕西万宏昌恒建设工程有限公司&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 中标价格： 67.025171 万元\n</span><br>\n<span style="font-si><br>\n<span style="font-size: 12pt;">/\n</span><br>\n<span style="font-size: 12pt;">三、监督部门\n</span><br>\n<span style="font-size: 12pt;">本招标项目的监督部门为宝鸡市凤n<span style="font-size: 12pt;">四、联系方式\n</span><br>\n<br>\n<span style="font-size: 12pt;">招 标 人： 宝鸡市凤翔区水利工作站\n</span><br>\n<span style="font-size: 12pt; 址： 宝鸡市凤翔区北大街 122 号\n</span><br>\n<span style="font-size: 12pt;">联 系 人： 王女士\n</span><br>\n<span style="font-size: 12pt;">电&nbsp;&nbsp;&nbsp; 话： 0917-<span style="font-size: 12pt;">电子邮件： \\\n</span><br>\n<br>\n<br>\n<span style="font-size: 12pt;">招标代理机构： 陕西恒信项目管理有限公司\n</span><br>\n<span style="fonbsp;&nbsp; 址：&nbsp; 陕西省宝鸡市金台区大庆路西建国际 1113 室\n</span><br>\n<span style="font-size: 12pt;">联 系 人：&nbsp; 李工\n</span><br>\n<span style="font-size: 12pt>电&nbsp;&nbsp;&nbsp; 话：&nbsp; 17729591066\n</span><br>\n<span style="font-size: 12pt;">电子邮件：&nbsp; 962108786@qq.com</span></p></div>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t<iframe id="yzmhide"\r\n\t\t\tstyle="position: fixed; width: 1px; height: 1px; bottom: 0; right: 0; opacity: 0;"\r\n\t\t\tsrc=""></iframe>\r\n\t\t\t\r\n\t\t</div>\r\n\t\t<!-- footer -->\r\n\t\t<div id="footer"></div>\r\n\t\t</div>\r\n\t\t<!-- 页面脚本 -->\r\n\t<script>\r\n\t\tfunction setfont(size) {\r\n\t\t\t$("#mainContent").removeClass()n\t\t\t$("#mainContent").addClass("epoint-article-content");\r\n\t\t\t$("#mainContent span").removeClass();\r\n\t\t\t$("#mainContent p").removeClass();\r\n\t\t\t$("#mainContent a").removeClass();\r\n\t\t\t$("#mainContent").addClass("ewb-"+size);\r\n\t\t\t$("#mainContent span").addClass("ewb-"+size);\r\n\t\t\t$("#mainContent p").addClass("ewb-"+size);\r\n\t\t\t$("#mainContent a").addClass("ewb-"+size);\r\n\t\t}\r\n\t</script>\r\n\t<script src="/js/webBuilderCommon.js"></script>\r\n    <script src="/js/pageView2.js"></script>\r\n    <script src="/js/lib/libsCommon.min.js"></script>\r\n    <script src="/js/lib/chosen/chosen.jquery.min.js"></script>\r\n    <script src="/js/common.js"></script>\r\n\t<script src="/js/lib/layer2/layer.js"></script>\r\n\t<script src="/js/mydetail.js"></script>\r\n\t</body>\r\n\r\n</html>\r\n'
  
  In [11]: r.cookies
  Out[11]: <RequestsCookieJar[]>
  
  In [12]: history
  clear
  import requests
  url = "http://ggzy.baoji.gov.cn/jydt/001001/001001001/001001001003/20230403/769f6a4b-1aa7-4de0-bcf0-004545fa8fe1.html"
  r = request.get(url)
  r = requests.get(url)
  r.status_code
  r.headers
  r.encodeing
  r.encoding
  r.text
  r.cookies
  history
  ```

- 注意：
  - 如果在r.headers中的content-type中没有显示的说明编码格式可能会导致乱码，此时加上`r.encoding="utf-8"`

#### URL管理器使用

- 建立package utils以及新建python文件url_maneger

- 编写api并测试

  ```python
  class UrlManager():
      def __init__(self):
          self.new_urls = set()
          self.old_urls = set()
  
      def add_new_url(self, url):
          if url is None or len(url) == 0:
              return
          if url in self.new_urls or url in self.old_urls:
              return
          self.new_urls.add(url)
  
      def add_new_urls(self, urls):
          if urls is None or len(urls) == 0:
              return
          for url in urls:
              self.add_new_url(url)
  
      def get_url(self):
          if self.has_new_url():
              url = self.new_urls.pop()
              self.old_urls.add(url)
              return url
  
      def has_new_url(self):
          return len(self.new_urls) > 0
  
  
  if __name__ == "__main__":
      url_manager = UrlManager()
      url_manager.add_new_url("a")
      url_manager.add_new_urls(["a", "b"])
      print(url_manager.new_urls, "###", url_manager.old_urls)
      print("#"*30)
      print(url_manager.get_url(), "###",url_manager.new_urls, "###", url_manager.old_urls)
  ```

  <img src="/Users/wangke/Desktop/毕设相关/毕业设计图片/url_manager使用.png" alt="image-20230407133801107" style="zoom:25%;" />

#### 网页解析器使用

- down下网页源码
  - 在Chrome中在爬取的网站中右键点击，选择显示网页源代码，并将源代码复制到test.html中

- 练习使用

```python
import requests
from bs4 import BeautifulSoup
import selenium

with open("test.html") as fin:
    html_doc = fin.read()

soup = BeautifulSoup(html_doc,"html.parser")

#查看链接
links = soup.find_all("a")
for link in links:
    print(link.name,link["href"],link.get_text())

#查看图片链接
img = soup.find_all("img")

#查找部分内容的子元素
div_node = soup.find("div", id="1")
div_node.find_all("a")
```

- 爬取span元素实例

  <img src="/Users/wangke/Desktop/毕设相关/毕业设计图片/网页解析器尝试.png" alt="image-20230407144130705" style="zoom:25%;" />

### 实战

#### 确认爬取目标

<img src="/Users/wangke/Desktop/毕设相关/毕业设计图片/待爬取的界面.png" alt="image-20230407145343894" style="zoom:25%;" />

- 我们可以发现第一页的链接是：`http://ggzy.baoji.gov.cn/jydt/001001/001001001/1.html`，第二页就是`2.html`

#### 分析并请求AJAX数据

<img src="/Users/wangke/Desktop/毕设相关/毕业设计图片/页面分析.png" alt="image-20230407150116526" style="zoom:25%;" />

- 用fn+F12检查网页，打开network，勾选preserve log以及Disable cache
- 找到一个最像请求内容的请求，1.html，虽然没有Payload和Response给我们查看，但是我们基本可以判断这个就是待请求的url
- 这个请求没有参数，就页面号不同，我们还可以获取到请求方法是GET

#### 解析文章数据，批量爬取并存到excel文件

- 查看源码后发现这些中标结果的链接在div中

  <img src="/Users/wangke/Desktop/毕设相关/毕业设计图片/查看源码.png" alt="image-20230407152218615" style="zoom:25%;" />

- 思路是先找所有页面，将每个页面的url加到url_manager中，然后再访问这些url，将span元素提取出来，用正则表达式提取需要的信息，最后封装到数组中

- 代码：

  ```python
  import requests
  from bs4 import BeautifulSoup
  import selenium
  from utils.url_manager import UrlManager
  import pandas as pd
  import re
  
  #URL管理器
  url_manager = UrlManager()
  #将所有页面中所有url添加到url管理器中
  scr_url = "http://ggzy.baoji.gov.cn/jydt/001001/001001001/"
  for count in range(1, 600):
      url = scr_url + str(count) + ".html"
      print("正在爬取页面"+str(count))#查看访问的链接
      resp = requests.get(url)
      soup = BeautifulSoup(resp.text, "html.parser")
      div_categorypagingcontent = soup.find("div", id="categorypagingcontent")
      ul = div_categorypagingcontent.find("ul")#第一个为真正的内容，后面的是页码
      links = ul.find_all("a")
      for link in links:
          # print(link.name,link["href"],link.get_text())#查看每一个页面
          url_manager.add_new_url("http://ggzy.baoji.gov.cn"+link["href"])
  
  print(url_manager.new_urls)
  #访问每一个url，将数据存到bids中
  bids = []
  while url_manager.has_new_url():
      print("剩余待处理url:"+str(url_manager.new_url_left()))
      url = url_manager.get_url()
      resp = requests.get(url)
      soup = BeautifulSoup(resp.text, "html.parser")
      #判断是哪种页面
      h3 = soup.find("h3").text
      # print(h3)
      pattern = re.compile('中标结果公示')
      if pattern.search(h3):
          print(h3)
          bid = {"project": "", "tenderee": "", "winner": "", "price": -1}
          match = re.findall(r"^(.*?)中标结果公示", h3)
          if match:
              bid["project"] = match[0]
          spans = soup.find_all("span")
          for span in spans:
              text = span.get_text()
              text = text.replace("：", ":")  # 把中文冒号换成英文冒号
              match = re.search(r"中标人:([\u4e00-\u9fa5]+)\s*中标价格:([\d\.]+)\s*万元", text)
              if match:
                  bid["winner"] = match.group(1)
                  bid["price"] = match.group(2)
              match = re.search(r"招 标 人:([\u4e00-\u9fa5]+)\s", text)
              if match:
                  bid["tenderee"] = match.group(1)
              # match = re.search(r"标段", text)
              # if match:
              #     arr = text.split(":")
              #     if len(arr)>1:
              #         bid["project"] = arr[1]
          bid = [bid["project"], bid["tenderee"], bid["winner"], bid["price"]]
          bids.append(bid)
  print(bids)
  
  #存入表格
  df = pd.DataFrame(bids,columns=["标项", "招标人", "中标人", "中标价格"])
  df.to_excel("山东省宝鸡市公共资源交易记录.xlsx",index=False)
  ```

- 处理过程

  <img src="/Users/wangke/Desktop/毕设相关/毕业设计图片/处理过程.png" alt="image-20230407183940460" style="zoom:25%;" />

  - 事实上，我们爬取了600个页面，一共6000条url，其中选取了中标结果公示结尾的记录约1200条

- 结果

  <img src="/Users/wangke/Desktop/毕设相关/毕业设计图片/山东省宝鸡市公共资源交易记录.png" alt="image-20230407191751119" style="zoom:25%;" />

  - 可以看到仍然有一些缺失值和不正常的值，这些都将在数据预处理阶段被处理

## 数据预处理

### 数据清洗

- 可以看到爬取下来的值只需要去除一下缺失记录和中标价格为-1的记录

- 需要安装`xlrd==1.2.0`

- 代码

  ```python
  import pandas as pd
  
  # 读取 xlsx 文件
  df = pd.read_excel('山东省宝鸡市公共资源交易记录.xlsx')
  
  # 布尔索引，选择不含缺失值和值不为 -1 的记录
  df = df[(df['标项'].notna()) & (df['招标人'].notna()) & (df['中标人'].notna()) & (df['中标价格'] != -1)]
  
  # 保存处理后的 DataFrame 到 xlsx 文件
  df.to_excel('山东省宝鸡市公共资源交易记录_clean.xlsx', index=False)
  ```

- 效果

  <img src="/Users/wangke/Desktop/毕设相关/毕业设计图片/清洗后的数据.png" alt="image-20230408145604456" style="zoom:25%;" />

### 关系模式分解

- 如图所示爬取下来的数据有4列，前三列定义为实体，后面一列是属性

- 实体有:Project,Tenderee,Winner；关系有Bid,Win；price是project的属性

- 我们可以将表分解（这里的表PRTP_all.xls就是之前清洗后的数据，并修改了表头）：

  ```python
  import os
  import pandas as pd
  
  # 读取 xlsx 文件
  # filename = os.path.join(os.path.dirname(os.getcwd()), "data", "PRTP_all.csv")
  df = pd.read_excel("../data/PRTP_all.xls")
  
  
  # 分解project.csv
  project_df = df[['project']].drop_duplicates()
  project_df['project_id'] = range(1, len(project_df)+1)
  project_df.to_csv('../data/project.csv', index=False)
  
  # 分解tenderee.csv
  tenderee_df = df[['tenderee']].drop_duplicates()
  tenderee_df['tenderee_id'] = range(1, len(tenderee_df)+1)
  tenderee_df.to_csv('../data/tenderee.csv', index=False)
  
  # 分解winner.csv
  winner_df = df[['winner']].drop_duplicates()
  winner_df['winner_id'] = range(1, len(winner_df)+1)
  winner_df.to_csv('../data/winner.csv', index=False)
  
  # 分解bid.csv
  bid_df = df[['project', 'tenderee']].merge(project_df, on='project').merge(tenderee_df, on='tenderee')
  bid_df = bid_df[['tenderee_id', 'project_id']]
  bid_df.to_csv('../data/bid.csv', index=False)
  
  # 分解win.csv
  win_df = df[['project', 'winner']].merge(project_df, on='project').merge(winner_df, on='winner')
  win_df = win_df[['winner_id', 'project_id']]
  win_df.to_csv('../data/win.csv', index=False)
  
  # 分解price.csv
  price_df = df[['project', 'price']].merge(project_df, on='project')
  price_df = price_df[['project_id', 'price']]
  price_df.to_csv('../data/price.csv', index=False)
  ```

### 导入Neo4j

- Neo4j下载与安装

  - 安装 JRE---下载 Neo4j ---配置环境变量---注册 Neo4j 服务
  - JRE 下载地址: https://www.oracle.com/technetwork/java/javase/downloads/index.html
  - Neo4j 下载地址: https://neo4j.com/download-center/

- 运行

  - 环境变量(mac环境)：
    - `sudo vim ~/.bash_profile`
    - `export PATH=$PATH:/Users/wangke/Desktop/SoftWare/neo4j/bin`
    - `source ~/.bash_profile`
  - `neo4j start`

- 将excel表放到neo4j安装目录的import目录下

- 导入表

  ```cypher
  LOAD CSV WITH HEADERS FROM "file:///project.csv" AS line
  CREATE (project_name:Project {project_id: toInteger(line.project_id), project_name: line.project});
  LOAD CSV WITH HEADERS FROM "file:///tenderee.csv" AS line
  CREATE (:Tenderee {tenderee_id: toInteger(line.tenderee_id), tenderee_name: line.tenderee});
  LOAD CSV WITH HEADERS FROM "file:///winner.csv" AS line
  CREATE (:Winner {winner_id: toInteger(line.winner_id), winner_name: line.winner});
  LOAD CSV WITH HEADERS FROM "file:///bid.csv" AS line
  MATCH (t:Tenderee), (p:Project)
  WHERE t.tenderee_id = toInteger(line.tenderee_id)
  AND p.project_id = toInteger(line.project_id)
  MERGE (t)-[:BID]->(p);
  LOAD CSV WITH HEADERS FROM "file:///win.csv" AS line
  MATCH (w:Winner), (p:Project)
  WHERE w.winner_id = toInteger(line.winner_id)
  AND p.project_id = toInteger(line.project_id)
  MERGE (w)-[:WIN]->(p);
  LOAD CSV WITH HEADERS FROM "file:///price.csv" AS line
  MATCH (p:Project)
  WHERE p.project_id = toInteger(line.project_id)
  SET p.price = toFloat(line.price)
  ```

- 效果

  <img src="/Users/wangke/Desktop/毕设相关/毕业设计图片/neo4j效果.png" alt="image-20230410170400140" style="zoom:25%;" />

  - 注意：将展示图放大后点击Tenderee或BID等可以调节结点颜色、大小以及显示的属性
  - 这里可以看到中标人陕西龚隆建设...拿到了宝鸡高新技术...的两个项目，拿到了宝鸡市陈仓区...的一个项目

## 知识储备

### 知识图谱

学习链接：[知识图谱实战：从0到1带你构建知识图谱！看完直接搞定毕设！](https://www.bilibili.com/video/BV1UY411D7Bf/?spm_id_from=333.337.search-card.all.click&vd_source=85c9463248b682d1416040a6e43bb69e)

- 知识图谱是一种揭示实体之间关系的语义网络，可以对现实世界的事物及其相互关系进行形式化地描述。现在的知识图谱已被用来泛指各种大规模的知识库。
- 三元组：实体2-关系-实体2；实体-属性-属性值；确定哪些是属性，哪些是实体取决于知识图谱的使用方式和想完成的任务
- 关键技术
  - 知识抽取：非结构化到结构化的过程
    - 实体抽取：如何识别：基于规则和词典的方法、基于机器学习的模型预测方法
    - 关系抽取：
      - 限定领域关系抽取：F(实体1，实体2，文本)->关系，是一种有监督分类任务，两种训练方式：pipeline vs 联合训练
      - 开放领域关系抽取：基于序列标注，可以做远程监督
    - 属性抽取：借鉴关系抽取
  - 知识融合：清洗提升数据质量
    - 实体对齐：将不同来源的知识认定为真实世界的同一实体，实体相似度
    - 实体消歧：将同一名称但指代不同事物的实体区分开
    - 属性对齐：不同数据源对于实体属性的记录可能使用不同的词语
  - 知识推理：挖掘补充或补全数据
    - 在已有的知识库基础上进一步挖掘隐含的知识，从而丰富、扩展知识库
      - 基于规则+句法：传递性、实例性
      - 基于模型
  - 知识表示：为应用做准备
    - 将知识图谱中实体、关系、属性等转化为向量
    - 利用向量间的计算关系，反映实体间的关联性
    - TransE

## 论文准备

- 知识图谱的可视化技术

  1. 网络图可视化技术：即将知识图谱中的节点和边通过某种布局算法展示成网络图。比较常用的网络图布局算法包括：Force-directed布局、Circle布局、Fruchterman-Reingold布局等；而常用的网络图可视化工具包括：D3.js、Cytoscape、Gephi等。
  2. 桑基图可视化技术：桑基图可将多个维度的数据关系展现在一张图上，可以用来展示知识图谱中各类节点之间的关系。常见的桑基图可视化工具包括：Echarts、Tableau等。
  3. 地图可视化技术：将知识图谱中的节点和边以地理位置的方式展示在地图上，便于直观理解和分析空间规律。常见的地图可视化工具包括：Leaflet、OpenLayers、百度地图开发平台等。
  4. 三维可视化技术：将知识图谱中的节点和边以 3D 的方式展示出来，可以加强用户对知识图谱的直观理解和感知。常见的三维可视化工具包括：Three.js、WebGL等。
  5. 其他可视化技术：比如时间轴可视化、流程图可视化、关系图可视化等。

- 可视化内容

  - 知识图谱可视化技术能够可视化出知识图谱中的各种节点（或实体）之间的关系，以及这些关系的属性信息。比如，通过一张可视化的知识图谱可以看到：
    1. 实体之间的关系类型：比如，人和人之间可能有家庭关系、社交关系、组织关系等；产品和零部件之间可能有生产关系、销售关系、装配关系等。
    2. 实体之间的关系强度：比如，你可以通过节点之间的连线粗细、连线颜色、连线类型等属性信息来反映节点之间的关系强度。
    3. 实体的属性信息：比如，对于一个人节点，你可以通过可视化来展示他的姓名、性别、出生日期、教育背景、工作履历等一系列属性信息；对于一个产品节点，你可以展示其价格、品牌、规格等属性信息。
    4. 实体和属性信息之间的关系：比如，你可以通过节点和边的不同颜色、形状、标签等来反映实体和属性之间的关系属性。
  - 除了以上节点和边的可视化之外，不同的可视化技术还能够提供一些交互式特性，比如可以支持用户搜索、高亮、展开、收起等操作，方便用户更加深入的探索知识图谱中各个节点的关系。

- 知识图谱

  - Jena

    - Jena是一个流行的Java框架，用于处理语义Web数据。语义Web是一个分布式的知识库，其中的信息以机器可读的方式进行表示，以便能够自动处理、检索和共享信息。在语义Web中，知识抽取是一项重要的任务，它涉及从非结构化和半结构化数据中提取出有用的信息。

    - 利用Jena进行知识抽取通常涉及以下步骤：

      1.定义Ontology:Ontology是描述语义Web数据的模型。它定义了实体（如人、组织、事件等）以及它们之间的关系。在Jena中，Ontology由RDF Schema（RDFS）或Web Ontology Language（OWL）定义。RDFS是一种基本的知识建模语言，用于定义类、属性和关系。OWL则提供了更丰富的表达能力，可以定义更复杂的关系和逻辑。

      2.创建RDF Graph:RDF（Resource Description Framework）是语义Web数据的标准格式。它使用三元组（主语、谓语、宾语）表示知识，并通过URI（Uniform Resource Identifier）标识实体。在Jena中，RDF数据以图形（Graph）形式存储，每个节点都是一个URI或者一个文字值。

      3.导入数据:知识抽取的第一步是将非结构化或半结构化数据转换为RDF格式。这可以通过各种方式实现，例如使用Jena API或解析器将XML、JSON或HTML转换为RDF Graph。在导入数据之前，需要将数据映射到Ontology中定义的实体和属性上。

      4.实体识别:实体识别是指从文本中识别出与Ontology中定义的实体相对应的文本。在Jena中，可以使用OpenNLP或Stanford NLP等开源自然语言处理工具来实现实体识别。这些工具可以识别出人名、组织、地点、时间等实体，并将它们映射到Ontology中定义的类别上。

      5.关系抽取:关系抽取是指从文本中提取出实体之间的关系。例如，从句子“公司采购项目”中提取出“公司”和“项目”之间的“采购”关系。在Jena中，可以使用各种自然语言处理技术来实现关系抽取，例如依存句法分析、命名实体识别、关键词抽取等。

      6.RDF三元组生成:在完成实体识别和关系抽取后，需要将提取的信息转换为RDF Graph中的三元组形式。例如，将“公司采购项目”转换为三元组形式：公司（主语）采购（谓语）项目（宾语）。

  - Aprioris

    - 在知识图谱中，关联规则挖掘是一个重要的任务，可以用于发现实体之间的关系，进而丰富知识图谱的内容。Apriori算法是一种经典的关联规则挖掘算法，可以用于从大规模数据集中挖掘出频繁项集及其关联规则。

    - Aprioris算法具体步骤如下：

      1.找出所有频繁项集：频繁项集指的是在数据集中出现频率达到预定最小支持度阈值的项集。首先扫描数据集，统计每个项的出现次数，计算出所有单项的支持度，并把单项支持度高于预定最小支持度阈值的项作为频繁1-项集。然后，使用频繁1-项集构建候选2-项集，即两个单项的组合，统计候选2-项集在数据集中出现的次数，筛选出支持度高于预定最小支持度阈值的频繁2-项集。然后，使用频繁2-项集构建候选3-项集，即三个单项的组合，统计候选3-项集在数据集中出现的次数，筛选出支持度高于预定最小支持度阈值的频繁3-项集。以此类推，直到没有更多的频繁项集可以挖掘。

      2.生成关联规则：在找出所有频繁项集之后，可以根据频繁项集生成关联规则。一条关联规则可以写成 A -> B，表示当事务集合包含项集A时，事务集合也会包含项集B。关联规则的生成可以采用以下步骤：

    - 对于一个频繁k-项集，可以将其划分成多个频繁(k-1)-项集，比如{k1, k2, k3}可以划分成{k1, k2}和{k1, k3}和{k2, k3}。然后，计算每个(k-1)-项集作为前件，和剩余的一个项作为后件的置信度，筛选出置信度高于预定最小置信度阈值的关联规则。

    - Apriori算法的优点在于它是一种较为简单和经典的频繁项集挖掘算法，具有良好的可解释性和可扩展性。但是，Apriori算法也存在一些缺点，比如其需要多次扫描数据集，计算频繁项集的代价较高，同时会产生大量的候选项集，导致算法效率较低。