# -*- coding: utf-8 -*-

import json  
import codecs
import pymongo

# JSON FIle
class JsonWriterPipeline(object):

    def open_spider(self, spider):
        # 使用spider.name 作为Json文件名
        self.file = codecs.open(spider.name + '.json', 'w', encoding='utf-8')
        
    def close_spider(self, spider):
        self.file.close()
        
    def process_item(self, item, spider):
        line = json.dumps(dict(item)) + '\n'
        self.file.write(line.decode("unicode_escape"))
        return item

# MongoDB
class MongoPipeline(object):

    def __init__(self, mongo_uri, mongo_db):
        self.mongo_uri = mongo_uri
        self.mongo_db = mongo_db

    @classmethod
    def from_crawler(cls, crawler):
        return cls(
            mongo_uri=crawler.settings.get('MONGO_URI'),
            mongo_db=crawler.settings.get('MONGO_DATABASE', 'test')
        )

    def open_spider(self, spider):
        self.client = pymongo.MongoClient(self.mongo_uri)
        self.db = self.client[self.mongo_db]

        # 使用spider.name作为Collection的名字
        self.collection_name = spider.name

    def close_spider(self, spider):
        self.client.close()

    def process_item(self, item, spider):
        self.db[self.collection_name].insert(dict(item))
        return item