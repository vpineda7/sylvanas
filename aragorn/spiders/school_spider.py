# -*- coding: utf-8 -*-
import scrapy

class SchoolSpider(scrapy.Spider):
    
    # 默认使用名字作为存储依据
    name = "school"
    
    # TODO: 等待页面加载完成
    # TODO: 安全认证
    def start_requests(self):
        url = 'http://gkcx.eol.cn/soudaxue/queryschool.html?page='
        #p=1-276
        for num in range(1,2):
            yield scrapy.Request(url=url+str(num), callback=self.parse)
    
    def parse(self, response):
        for one in response.css('tr.getJsXmlTr'):
            yield {
                'name': one.css('td:nth-child(1) a::attr(title)').extract_first()
            }