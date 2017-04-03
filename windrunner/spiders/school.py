# -*- coding: utf-8 -*-

import scrapy
#from windrunner.items import SchoolItem

class SchoolSpider(scrapy.Spider):

    # 爬虫名和mongodb集合名
    name = "school"
    # 使用浏览器加载
    resources = "xhr"

    def start_requests(self):

        # 中国教育在线
        url = 'http://gkcx.eol.cn/soudaxue/queryschool.html?page='
        # p=76 下载失败 p=88 下载失败 p=94 下载失败 下载完成
        for num in range(1, 278):
            yield scrapy.Request(url=url+str(num), callback=self.parse)

    def parse(self, response):

        self.logger.info('正在选择页面元素 [%s]', response.url)

        for one in response.xpath('//*[@id="queryschoolad"]/tbody/tr'):

            if one.xpath('string(td[1]/a)').extract_first() != "":
                yield {
                    'name': one.xpath('string(td[1]/a)').extract_first(),
                    'location': one.css('td:nth-child(3)::text').extract_first(),
                    'level': one.xpath('td[4]/text()').extract_first(),
                    'classify':one.xpath('td[2]/i[2]/text()').extract_first().split(" ")[0]
                }
            