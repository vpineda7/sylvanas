// 将网页导出成图片
// 例如: phantomjs export.js http://www.baidu.com
"use strict";
var page = require('webpage').create();
var system = require('system');

if (system.args.length === 1) {
  console.log('使用方式: phantomjs export.js [url地址]');
  phantom.exit();
}

var url = system.args[1];

// 访问网站
page.open(url, function(status) {
  
  if(status === "success") {
    
    // 随机文件名
    var t = Date.now();
    // 生成图片
    page.render(t+'.png');
    console.log("图片生成成功");
  }else{
    console.log("图片生成失败");
  }

  phantom.exit();
});