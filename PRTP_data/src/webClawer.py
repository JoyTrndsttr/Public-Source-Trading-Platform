import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
import requests
from bs4 import BeautifulSoup
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
filename = os.path.join(os.path.dirname(os.getcwd()), "data", "山东省宝鸡市公共资源交易记录.xlsx")
df.to_excel(filename, index=False, encoding="utf-8")
# df.to_excel("山东省宝鸡市公共资源交易记录.xlsx",index=False)
