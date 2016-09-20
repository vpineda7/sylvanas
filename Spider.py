# simple spider baidu logo image

import urllib
import re

def getHtml(url):

    page = urllib.urlopen(url)
    return page.read()

def getElement(html):

    reg = re.compile(r'src="(.+?\.png)"')

    return re.findall(reg,html)

def save(elements):

    x = 0
    for element in elements:
        urllib.urlretrieve("http:"+element, '%s.png' %x)
        x+=1

html = getHtml("http://www.baidu.com")

elements = getElement(html)

print elements

save(elements)
