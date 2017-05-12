"use strict";
var page = require('webpage').create();
var server = require('webserver').create();
var system = require('system');
var host, port;

// 端口号
if (system.args.length !== 2) {
  console.log('使用方式: phantomjs server.js <port>');
  phantom.exit(1);
} else {
  port = system.args[1];
  var listening = server.listen(port, function (request, response) {
      
      console.log("GOT HTTP REQUEST");
      console.log(JSON.stringify(request, null, 4));

      // we set the headers here
      response.statusCode = 200;
      response.headers = {"Cache": "no-cache", "Content-Type": "text/html"};
      // this is also possible:
      response.setHeader("foo", "bar");
      // now we write the body
      // note: the headers above will now be sent implictly
      response.write("<html><head><title>YES!</title></head>");
      // note: writeBody can be called multiple times
      response.write("<body><p>pretty cool :)</body></html>");
      response.close();
  });

  if (!listening) {
      console.log("could not create web server listening on port " + port);
      phantom.exit();
  }
}