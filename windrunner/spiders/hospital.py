# -*- coding: utf-8 -*-

import scrapy
#from windrunner.items import SchoolItem

class HospitalSpider(scrapy.Spider):

    # 爬虫名和mongodb集合名
    name = "hospital"
    # 不使用浏览器加载
    resources = "doc"

    def start_requests(self):
        # 北京市预约挂号统一平台
        urll = 'http://www.bjguahao.gov.cn/hp/'
        urlr = ',0,0,0.htm'
        # p = 16
        for num in range(1, 17):
            yield scrapy.Request(url=urll+str(num)+urlr, callback=self.parse)

    def parse(self, response):
        for one in response.xpath('//*[@id="yiyuan_content"]/div'):

            yield {
                'name': one.xpath('dl/dd/p/a/text()').extract_first(),
                'level':one.xpath('dl/dd/p/span/text()').extract_first(),
                'telephone':one.xpath('string(dl/dd/div/p[2])').extract_first(),
                'address':one.xpath('string(dl/dd/div/p[3])').extract_first()
            }
    