#!/usr/bin/python
#coding=utf-8

import urllib
import re
from pymongo import MongoClient

# 获取文档
def getDocument(url):

    #post
    #param = urllib.urlencode({"username":"1016903103@qq.com","password":"XXXX"})
    #request = urllib.request(url, param)
    #get
    #values={}
    #values['hello'] = 'world'
    #param = urllib.urlencode(values)
    #url = url +'?'+param
    #headers = {'User-Agent' : 'Mozilla/4.0 (compatible; MSIE 5.5; Windows NT)'}
    response = urllib.urlopen(url)

    return response.read()

# 检索指定内容
def getElement(document):

    #选择器 xpath css 正则表达式
    return {
        "name":"hello"
    }

def getJSON(url):
    print url

# 存储
def save(collection):
    client = MongoClient()

# URL-拉钩企业信息-工商
def main():
    url="http://www.lagou.com/gongsi"
    doc=getDocument(url)
    ele=getElement(doc)
    save(ele)

    #getJSON('http://www.lagou.com/gongsi/2-0-0.json')

if __name__ == "__main__":
    main()
