# Sylvanas

### Requirements

- Python
- Scrapy
- Selenium
- PhantomJS
- MongoDB
- Neo4j

### Installation

```
brew install phantomjs

pip install scrapy
pip install -U selenium

python -m pip install pymongo
pip install neo4j-driver
```
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

### MapReduce

```
 export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_60.jdk/Contents/Home
 export PATH=${JAVA_HOME}/bin:${PATH}
 export HADOOP_CLASSPATH=${JAVA_HOME}/lib/tools.jar

 hadoop com.sun.tools.javac.Main WordCount.java
 jar cf wc.jar WordCount*.class

 hadoop jar wc.jar WordCount ./input ./output
```

### TODO

- 调整输出的日志
- 解决下载失败后阻塞的问题
- 禁止.pyc文件生成
- 开发与生产环境
- Neo4j
