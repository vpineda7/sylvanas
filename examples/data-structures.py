#!/usr/bin/python
#coding=utf-8

# List
squares = []
for x in range(10):
    squares.append(x**2)

squares = list(map(lambda x: x**2, range(10)))

squares = [x**2 for x in range(10)]

# 使用List实现栈
stack = [3, 4, 5]
# 入栈
stack.append(6)
# 出栈
stack.pop()

# 使用List实现队列
from collections import deque
queue = deque(["Eric", "John", "Michael"])
# 入队列
queue.append("Terry")
# 出队列
queue.popleft()
