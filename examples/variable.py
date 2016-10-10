#!/usr/bin/python
#coding=utf-8

num=20.6
str="hello world!"

a = b = c = 1
a, b, c = 1, 2, "john"

del a,b

# List 列表 有序
list=['adv',78,9.1,'join']

# Final 元组 不能二次赋值，只读列表
tuple = ( 'abcd', 786 , 2.23, 'john', 70.2 )

# Map 字典 无序
dict={'id':12,'name':'join','one':'hello'}

print str
print str[2:5] + c
print list[2:] * 2
print tuple[0]
print dict['id']
print dict.keys() + dict.values()
print oct(int(num))
print eval('tuple[1]')
