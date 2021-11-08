# covid
作业。主要做四件事
## 搜集数据
1. 数据来源为[腾讯新闻-新冠疫情](https://news.qq.com/zt2020/page/feiyan.htm#/),[WHO](https://covid19.who.int/),[美国政府网站NCHN发布数据集](https://data.cdc.gov/NCHS/Provisional-COVID-19-Deaths-by-Sex-and-Age/9bhg-hcku)，[法国covid医院数据](data.gouv.fr/fr/datasets/donnees-hospitalieres-relatives-a-lepidemie-de-covid-19/)
3. 代码中的模块为spider

## 数据清洗
1. 数据较为规整，只需要将数据简单的入库即可，代码中的实现为Consumer

## 数据统计分析
使用SpringWeb提供以下数据
1. 新冠肺炎分国家给出死亡病例和年龄之间的关系
2. 感染病例和年龄之间的关系，以及分地区的死亡率  

## 数据可视化 
1. 将在网页上展示我们的数据
2. 最后放到公网服务上
