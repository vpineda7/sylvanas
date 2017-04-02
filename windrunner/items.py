# -*- coding: utf-8 -*-
'''
# 模块说明
'''
# Define here the models for your scraped items
#
# See documentation in:
# http://doc.scrapy.org/en/latest/topics/items.html

import scrapy

# 学校
class SchoolItem(scrapy.Item):

    # 校名
    name = scrapy.Field()
    # 所在地
    location = scrapy.Field()
    # 层次
    level = scrapy.Field()
    # 类别
    classify = scrapy.Field()

# 人物
class HumanItem(scrapy.Item):

    # 姓名
    name = scrapy.Field()
    # 性别
    sex = scrapy.Field()