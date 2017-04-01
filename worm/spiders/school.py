# -*- coding: utf-8 -*-

import scrapy
#from worm.items import SchoolItem

class SchoolSpider(scrapy.Spider):

    ''' 中国教育在线 所有学校 '''

    # 使用名字进行爬取，默认使用名字作为存储依据
    name = "school"

    # 安全认证
    def start_requests(self):

        url = 'http://gkcx.eol.cn/soudaxue/queryschool.html?page='
        #p=1-276
        for num in range(1, 10):
            yield scrapy.Request(url=url+str(num), callback=self.parse)

    def parse(self, response):

        self.logger.info('正在选择页面元素 [%s]', response.url)

        for one in response.css('tr .op_name'):

            yield {
                'name': one.css('a::attr(title)').extract_first()
            }
            