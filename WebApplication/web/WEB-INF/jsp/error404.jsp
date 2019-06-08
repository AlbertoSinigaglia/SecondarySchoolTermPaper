<%-- 
    Document   : error404
    Created on : 17-mag-2018, 0.03.54
    Author     : albertosinigaglia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>404</title>
        <style>
            
            * {
  transition: all 0.6s;
}

html {
  height: 100%;
}

body {
  font-family: "Lato", sans-serif;
  color: #fff;
  background-color:#2196F3;
  margin: 0;
}

#main {
  display: table;
  width: 100%;
  height: 100vh;
  text-align: center;
}

.fof {
  display: table-cell;
  vertical-align: middle;
}

.fof h1 {
  font-size: 50px;
  display: inline-block;
  padding-right: 12px;
  animation: type 0.5s alternate infinite;
}

@keyframes type {
  from {
    box-shadow: inset -3px 0px 0px #fff;
  }
  to {
    box-shadow: inset -3px 0px 0px transparent;
  }
}

        </style>
    </head>
    <body onclick="location.href='./'">
        <div id="main">
    	<div class="fof">
        		<h1>Error 404</h1>
    	</div>
</div>
    </body>
</html>
