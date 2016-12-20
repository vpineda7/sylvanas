# Aragorn

### Installation

- Python 2.7

### Requirements

```
$ pip install Scrapy
$ mongod --dbpath /Users/subin/Library/MongoDB
$ mongoimport --db test --collection restaurants --drop --file ~/downloads/primer-dataset.json
```

### Configuration

remove the file `.pyc`

```
$ vi ~/.profile -> export PYTHONDONTWRITEBYTECODE=x
$ cd src
$ source ~/.profile
```

### Debug And Run

```
$ scrapy crawl quotes
```

### HTTP Server

```
$ python -m SimpleHTTPServer 9000
```

### Appendix

> 人过大佛寺, 寺佛大过人.  
> 客上天然居, 居然天上客.  
