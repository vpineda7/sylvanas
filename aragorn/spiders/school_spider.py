# -*- coding: utf-8 -*-
import scrapy

class SchoolSpider(scrapy.Spider):
    
    # 默认使用名字作为存储依据
    name = "school"
    
    def start_requests(self):
        url = 'http://www.ruyile.com/xxlb.aspx?p='
        #p=1-15280
        for num in range(1,2):
            yield scrapy.Request(url=url+str(num), callback=self.parse)
    
    def parse(self, response):
        for one in response.css('div.sk'):
            yield {
                'name': one.css('a::text').extract_first()
            }