# Sylvanas

### Requirements

- Python
- Scrapy
- Selenium
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
    'aragorn.pipelines.JsonWriterPipeline': 300,
    'aragorn.pipelines.MongoPipeline': 400
}
```

settings.py `mongodb`

```
MONGO_URI = "localhost"
MONGO_DATABASE = "test"
```

### Run

```
mongod --dbpath /Users/subin/Library/MongoDB

scrapy crawl spider_name
```

### Testing

```
scrapy shell 'url'
response.css('div.sk')
```

### Appendix
