import os
import pandas as pd

# 读取 xlsx 文件
filename = os.path.join(os.path.dirname(os.getcwd()), "data", "山东省宝鸡市公共资源交易记录.xlsx")
df = pd.read_excel(filename)

# 布尔索引，选择不含缺失值和值不为 -1 的记录
df = df[(df['标项'].notna()) & (df['招标人'].notna()) & (df['中标人'].notna()) & (df['中标价格'] != -1)]

# 保存处理后的 DataFrame 到 xlsx 文件
filename = os.path.join(os.path.dirname(os.getcwd()), "data", "山东省宝鸡市公共资源交易记录_clean.xlsx")
df.to_excel(filename, index=False)