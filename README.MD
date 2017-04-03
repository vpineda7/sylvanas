# Sylvanas

### Requirements

- Python
- Scrapy
- Selenium
- PhantomJS
- MongoDB

### Installation

### Configuration

remove the file `.pyc`

```bash
vi ~/.profile -> export PYTHONDONTWRITEBYTECODE=x
cd src
source ~/.profile
```

settings.py `json` or `mongodb`(use spider.name as file or collections name) 

```
ITEM_PIPELINES = {
    'windrunner.pipelines.JsonWriterPipeline': 300,
    'windrunner.pipelines.MongoPipeline': 400
}
```

settings.py `mongodb`

```
MONGO_URI = "localhost"
MONGO_DATABASE = "test"
```

### Run

```shell
mongod --dbpath /Users/subin/Library/MongoDB

# scrapy <command> [options] [args]
scrapy list
scrapy crawl [spider_name]
find . -name *.pyc -exec rm -rf {} \;
```

### Testing

```
scrapy shell 'url'
response.css('div.sk')
```

### Appendix

### TODO

- 调整输出的日志
- 解决下载失败后阻塞的问题
- 禁止.pyc文件生成
