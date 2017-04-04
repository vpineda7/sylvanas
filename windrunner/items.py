# -*- coding: utf-8 -*-

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
