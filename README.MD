# Sylvanas

### Installation

- Python
- Scrapy
- MongoDB

### Requirements

```
$ mongod --dbpath /Users/subin/Library/MongoDB
```

### Configuration

remove the file `.pyc`

```
$ vi ~/.profile -> export PYTHONDONTWRITEBYTECODE=x
$ cd src
$ source ~/.profile
```

settings.py `json` or `mongodb`(use spider.name as file or collections name) 

```
ITEM_PIPELINES = {
    'aragorn.pipelines.JsonWriterPipeline': 300,
    'aragorn.pipelines.MongoPipeline': 400
}
```

settings.py `mongodb`

```
MONGO_URI = "localhost"
MONGO_DATABASE = "test"
```

### Run Spider

```
$ scrapy crawl spider_name
```

### Testing

```
$ scrapy shell 'url'
$ response.css('div.sk')
```

### HTTP Server

```
$ python -m SimpleHTTPServer 9000
```

### Appendix

> 人过大佛寺, 寺佛大过人.  
> 客上天然居, 居然天上客.  
