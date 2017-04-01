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
    'worm.pipelines.JsonWriterPipeline': 300,
    'worm.pipelines.MongoPipeline': 400
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
```

### Testing

```
scrapy shell 'url'
response.css('div.sk')
```

### Appendix
