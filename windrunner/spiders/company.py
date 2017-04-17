# -*- coding: utf-8 -*-
'''
拉勾
'''
import scrapy

class CompanySpider(scrapy.Spider):
    '''
    name: 爬虫名和mongodb集合名
    resources: 是否使用浏览器加载(doc, xhr)
    '''
    name = "company"
    resources = "doc"

    def start_requests(self):
        pass
    def parse(self, response):
        pass
    