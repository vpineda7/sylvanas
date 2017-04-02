# -*- coding: utf-8 -*-

'''
# 模块说明
'''
import scrapy
#from windrunner.items import SchoolItem

class SchoolSpider(scrapy.Spider):
    '''
    # 类说明
    '''

    # 使用名字进行爬取，默认使用名字作为存储依据
    name = "human"

    # 等待页面加载完成
    # 安全认证
    def start_requests(self):
        url = 'http://gkcx.eol.cn/soudaxue/queryschool.html?page='
        #p=1-276
        for num in range(1, 2):
            yield scrapy.Request(url=url+str(num), callback=self.parse)

    def parse(self, response):
        for one in response.css('tr.getJsXmlTr'):

            yield {
                'name': one.css('td:nth-child(1) a::attr(title)').extract_first()
            }
    