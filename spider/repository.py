#!/usr/bin/python
#coding=utf-8

from pymongo import MongoClient

def save(_db, _coll, _docs):

    client = MongoClient()
    coll = client[_db][_coll]

    return coll.insert_one(_docs)

def update(_db, _coll, _docs, _condition):

    client = MongoClient()
    coll = client[_db][_coll]

    return coll.update_many(_docs, _condition)

def find(_db, _coll, _condition):

    client = MongoClient()
    coll = client[_db][_coll]

    return coll.find(_condition)

def delete(_db, _coll, _condition):

    client = MongoClient()
    coll = client[_db][_coll]

    return coll.delete_many(_condition);
