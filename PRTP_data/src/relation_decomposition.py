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