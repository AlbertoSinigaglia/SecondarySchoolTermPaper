<%-- 
    Document   : articoli
    Created on : 26-apr-2018, 12.58.12
    Author     : alberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Statistiche</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../resources/css/w3.css">
        <link href="https://fonts.googleapis.com/css?family=Crete+Round" rel="stylesheet">
        <link rel="stylesheet" href="../resources/css/style.css">
        <meta http-equiv="cache-control" content="max-age=0" />
        <meta http-equiv="cache-control" content="no-cache" />
        <meta http-equiv="expires" content="0" />
        <style>
            body,h1,h2,h3,h4,h5 {font-family: "Poppins", sans-serif}
            body {font-size:16px;}
            .w3-half img{margin-bottom:-6px;margin-top:16px;opacity:0.8;cursor:pointer}
            .w3-half img:hover{opacity:1}
            input[type=text]:focus {
                border: 1px solid blue;
            }
            label{font-size:18px;}
            .input{
                border-radius:5px;
                font-weight:normal !important;
            }
            .biancohover:hover{
                background-color:#c3e0ff !important;
                color:#42A5F5!important;
                border: 2px solid #c3e0ff !important;
            }
            .input {
                border-radius: 5px;
                font-weight: normal !important;
            }

            .bottone {
                color: white;
                background-color: #42A5F5;
                border: 1px solid #42A5F5;
                border-radius: 5px;
                font-weight: bold;
                padding: 10px 10px;
                border-radius:10px;
                float:right;
                padding: 5px;
                margin: 10px;
                text-decoration: none;
            }

            .bottone:hover {
                background-color: white;
                color: #42A5F5;
            }
            select{background-color: white; border-radius:5px;}
            textarea{border: 3px solid #42A5F5; border-right:0px solid white; border-left:0px solid white; width:100%;font-size: 22px;}
        </style>
    </head>
    <body>
        <!-- Sidebar/menu -->
        <nav class="w3-sidebar w3-blue w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar">
            <br>
            <div class="w3-container">
                <h3 class="w3-padding-64"><b>Responsabile NC <br></b></h3>
            </div>
            <div class="w3-bar-block">
                <li onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white"><a href="./">Homepage</a></li>
                <li class="w3-bar-item">
                    Non Conformit&aacute;:
                    <ul style="list-style-type: circle !important;" class="nomargin">
                        <li onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white padding_li" href="aperte">&#x25B8; <a href="aperte">Aperte</a></li>
                        <li onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white padding_li" href="esec">&#x25B8; <a href="chiuse">Chiuse</a></li>
                        <li onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white padding_li" href="chiuse">&#x25B8; <a href="esec">In corso</a></li>
                    </ul>
                </li>
                <li onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white"><a href="creaSegnalazione">Segnalazioni</a></li>
            <li onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white"><a href="reclami">Reclami</a></li>
            <li onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white"><a href="richiesteProfilo">Richieste profili</a></li>
            <li onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white"><a href="clidip">Clienti e dipendenti</a></li>
            <li onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white"><a href="statistiche">Statistiche</a></li>
            <li onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white"><a href="logout">Logout</a></li>
            </div>
        </nav>
        <!-- Top menu on small screens -->
        <header class="w3-container w3-top w3-hide-large w3-blue w3-xlarge w3-padding">
            <a href="javascript:void(0)" class="w3-button w3-blue w3-margin-right w3-hover-white" onclick="w3_open()">☰</a>
            <span class="font_google">Statistiche</span>
        </header>
        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:340px;margin-right:40px;  min-height:700px;">
            <div class="w3-container" id="columns" style="margin-top:75px;">
                <!-- Services -->
                <div class="w3-row">
                    <div class="w3-col l12" id="services" style="margin-top:40px">
                        <h1 class="w3-xxxlarge w3-text-blue"><b>Statistiche</b></h1>
                        <hr style="width:100%;border:5px solid #42A5F5" class="w3-round">
                        <div class="w3-container w3-card w3-white w3-margin-bottom">
                            <div class="row"><center>
                                <h3 class="w3-xlarge w3-text-black"><b>Analisi andamento non conformità negli anni</b></h3>
                                <div id="chart_div2" style="height:400px;"></div>
                                <div class="row" style="margin: 0px !important; padding: 0px !important; margin-top:20px !important;">
                                    <div class="w3-col l12">
                                        <h3 class="w3-xlarge w3-text-black"><b>Analisi non conformità sui pezzi</b></h3>
                                        <div id="pezzi" style="width: 100%; height: 400px;"></div>
                                    </div>
                                    <div class="w3-col l12">
                                        <h3 class="w3-xlarge w3-text-black"><b>Analisi non conformità sugli articoli</b></h3>
                                        <div id="articoli" style="width: 100%; height: 400px;"></div>
                                    </div>
                                </center></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End page content -->
        </div>
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script>
            // Script to open and close sidebar
            function w3_open() {
                document.getElementById("mySidebar").style.display = "block";
                document.getElementById("myOverlay").style.display = "block";
            }
            function w3_close() {
                document.getElementById("mySidebar").style.display = "none";
                document.getElementById("myOverlay").style.display = "none";
            }


            google.load("visualization", "1", {packages: ["corechart"]});
            google.setOnLoadCallback(drawChart2);
            function drawChart2() {
                var data = google.visualization.arrayToDataTable([
                    ['Mesi',<c:forEach begin="2016" end="${anno}" varStatus="y">'${y.index}',</c:forEach>],
            <c:forEach begin="0" end="11" varStatus="m">
                    [ '${andamento.get(0).get(m.index).mese}',<c:forEach items="${andamento}" var="y">${y.get(m.index).c},</c:forEach>],
            </c:forEach>
                ]);

                var options = {
                    pointSize: 5,
                    hAxis: {title: '', titleTextStyle: {color: '#333'}},
                    vAxis: {minValue: 4,  format: '0', title: 'Numero NC'}
                };

                var chart = new google.visualization.AreaChart(document.getElementById('chart_div2'));
                chart.draw(data, options);
            }

            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Pezzo', 'Numero NC'],
                    <c:forEach items="${pezziNC}" var="pezzo">['${pezzo.denom}', ${pezzo.nc}],</c:forEach>
                ]);
                var options = {
                    is3D: true
                };
                var chart = new google.visualization.PieChart(document.getElementById('pezzi'));
                chart.draw(data, options);
            }
            
            
            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(drawChart3);
            function drawChart3() {
                var data = google.visualization.arrayToDataTable([
                    ['Articolo', 'Numero NC'],
                    <c:forEach items="${articoliNC}" var="articolo">['${articolo.denom}', ${articolo.nc}],</c:forEach>
                ]);
                var options = {
                    is3D: true
                };
                var chart = new google.visualization.PieChart(document.getElementById('articoli'));
                chart.draw(data, options);
            }
        </script>
    </body>
</html>