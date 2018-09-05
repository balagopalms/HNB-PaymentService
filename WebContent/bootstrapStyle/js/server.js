var http = require('http');

var options = {
		  host: 'localhost',
		  port: '8585',
		  path: '/nodejs/fetchData',
		  method: 'POST',
		  headers: {
		    'Content-Type': 'application/json; charset=utf-8',
		  }
		};

var req = http.request(options, function(res) {
	  var msg = '';

	  res.setEncoding('utf8');
	  res.on('data', function(chunk) {
	    msg += chunk;
	  });
	  res.on('end', function() {
	    console.log(JSON.parse(msg));
	  });
	});