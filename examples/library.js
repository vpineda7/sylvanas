// 加载第三方类库
"use strict";
var page = require('webpage').create();

page.open('http://www.baidu.com', function() {
  page.includeJs("https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js", function() {
    var attr = page.evaluate(function() {
      return $("#kw").attr("class");
    });

    console.log(attr);
    //$("#kw").val("hello")

    phantom.exit()
  });
});