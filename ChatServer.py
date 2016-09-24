#!/bin/python

from asyncore import dispatcher
import socket, asyncore

PORT = 5005

class ChatServer(dispatcher):

    def handle_accept(self):
        conn, addr = self.accept()
        print 'Connection attempt from', addr[0]

s = ChatServer()
s.create_socket(socket.AF_INET,socket.SOCK_STREAM)

s.bind(('',PORT))
s.listen(5)

asyncore.loop()
