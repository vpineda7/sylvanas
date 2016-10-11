#!/usr/bin/python
#coding=utf-8

import json

f = open('help.py', 'r')

#_all = f.read()
#_line = f.readline()

for line in f:
    print(line, end='')

w = open('hello', 'w')

w.write('this is a test\n')

f.close()
w.close()

json.dump([1, 'simple', 'list'], open('hello','w'))

x = json.load(open('hello','r'))

print(x)
