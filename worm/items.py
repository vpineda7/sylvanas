# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# http://doc.scrapy.org/en/latest/topics/items.html

import scrapy

class SchoolItem(scrapy.Item):
    # 校名
    name = scrapy.Field()
    # 所在地
    location = scrapy.Field()
    # 小学，中学，大学
