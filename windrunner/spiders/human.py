# -*- coding: utf-8 -*-
'''
未知
'''
import scrapy

class HumanSpider(scrapy.Spider):
    '''
    name: 爬虫名和mongodb集合名
    resources: 是否使用浏览器加载(doc, xhr)
    '''
    name = "human"
    resources = "doc"

    def start_requests(self):
        pass

    def parse(self, response):
        pass
    