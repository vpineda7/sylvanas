"use strict";
var system = require('system');

// 第一个参数是文件本身
if (system.args.length === 1) {
  
  console.log('Try to pass some args when invoking this script!');
} else {
  
  system.args.forEach(function (arg, i) {
    console.log(i + ': ' + arg);
  });
}

var t = 10,
interval = setInterval(function(){
  
  if ( t > 0 ) {
    console.log(t--);
  } else {
    console.log("BLAST OFF!");
    phantom.exit();
  }
}, 1000);

//phantom.exit();