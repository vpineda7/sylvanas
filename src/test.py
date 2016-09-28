#!/usr/bin/python
#coding=utf-8

from pymongo import MongoClient

import spider.repository

# client = MongoClient("mongodb://localhost:27017")
client = MongoClient()

#db = client['test']
db = client.test

#coll = db['restaurants']
#coll = db.restaurants
#cursor = coll.find()

cursor = db.restaurants.find({"borough": "Manhattan"})

for document in cursor:
    print(document)
