# 模块说明

# 浏览器控制器
# import webbrowser
# webbrowser.open_new_tab(url)

# 获取网页
# import urllib.request
# file = urllib.request.urlopen('http://www.python.org/')
# print(file.read().decode('utf-8'))

# HTTP 客户端

# import http.client
# conn = http.client.HTTPSConnection("www.python.org")
# conn.request("GET", "/")
# r1 = conn.getresponse()
# print(r1.status, r1.reason, r1.read())
