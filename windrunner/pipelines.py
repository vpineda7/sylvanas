# -*- coding: utf-8 -*-
'''
存储方式
'''
import json
import codecs
import pymongo

from neo4j.v1 import GraphDatabase, basic_auth

class JsonWriterPipeline(object):
    '''
    JSON FIle
    '''
    def open_spider(self, spider):
        # 使用spider.name 作为Json文件名
        self.file = codecs.open(spider.name + '.json', 'w', encoding='utf-8')

    def close_spider(self, spider):
        self.file.close()

    def process_item(self, item, spider):
        line = json.dumps(dict(item)) + '\n'
        self.file.write(line.decode("unicode_escape"))
        return item

class Neo4jPipline(object):
    '''
    Neo4j
    '''
    def __init__(self):
        self.driver = GraphDatabase.driver("bolt://localhost:7687", auth=basic_auth("neo4j", "neo4j"))

    def open_spider(self, spider):
        self.session = self.driver.session()

    def close_spider(self, spider):
        self.session.close()

    def process_item(self, item, spider):
        # self.session.run("CREATE (a:Person {name: {name}, title: {title}})",{"name": "Arthur", "title": "King"})
        return item

class MongoPipeline(object):
    '''
    MongoDB
    '''
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