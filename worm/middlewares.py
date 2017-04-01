# -*- coding: utf-8 -*-

from selenium import webdriver
from scrapy.http import HtmlResponse

class DynamicDownloaderMiddleware(object):

    def process_request(self, request, spider):

        spider.logger.info('正在使用webkit加载动态页面')

        driver = webdriver.PhantomJS()
        # driver = webdriver.Firefox()
        driver.get(request.url)
        body = driver.page_source
        # driver.close()
        return HtmlResponse(driver.current_url, body=body, encoding='utf-8', request=request)
