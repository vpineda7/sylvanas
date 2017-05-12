// 获取网页源信息
var page = require('webpage').create();
var system = require('system');

if (system.args.length === 1) {
  console.log('使用方式: phantomjs meta.js [url地址]');
  phantom.exit();
}

var url = system.args[1];

page.open(url, function(status) {
  var title = page.evaluate(function() {
    return document.title;
  });

  console.log('Title: ' + title);
  phantom.exit();
});