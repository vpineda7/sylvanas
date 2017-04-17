# -*- coding: utf-8 -*-
'''
中间件
'''
from selenium import webdriver
from scrapy.http import HtmlResponse

class DynamicDownloaderMiddleware(object):
    '''
    使用浏览器内核加载完整页面
    '''
    def process_request(self, request, spider):

        if spider.resources == "xhr":

            spider.logger.info('正在使用webkit加载动态页面')

            driver = webdriver.PhantomJS()
            # driver = webdriver.Firefox()
            driver.get(request.url)
            body = driver.page_source
            # driver.close()
            return HtmlResponse(driver.current_url, body=body, encoding='utf-8', request=request)
        else:
            return
