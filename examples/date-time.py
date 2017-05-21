#!/usr/bin/python
#coding=utf-8

import time
import calendar

print time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())

print calendar.month(2016,1)
print calendar.isleap(2016)
