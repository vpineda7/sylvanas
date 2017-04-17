# -*- coding: utf-8 -*-
'''
存储模型
'''
import scrapy

class SchoolItem(scrapy.Item):
    '''
    校名, 所在地, 层次, 类别
    '''
    name = scrapy.Field()
    location = scrapy.Field()
    level = scrapy.Field()
    classify = scrapy.Field()

