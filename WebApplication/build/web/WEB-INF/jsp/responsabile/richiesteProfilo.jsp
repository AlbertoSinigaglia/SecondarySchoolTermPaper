<%-- 
    Document   : richiesteProfilo
    Created on : 23-apr-2018, 16.38.29
    Author     : alberto
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Richieste di accesso</title>
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
            .input{
                border-radius:5px;
                font-weight:normal !important;
            }
            .bottone{
                float:right;
                color:white;
                background-color:#42A5F5;
                border: 1px solid #42A5F5;
                border-radius:5px;
                font-weight:bold;
                padding:3px 5px;
                font-size:20px;
            }
            .biancohover:hover{
                background-color:#c3e0ff !important;
                color:#42A5F5!important;
                border: 2px solid #c3e0ff !important;
            }
            .bottone:hover {
                background-color: #64B5F6 !important;
                border-color:#64B5F6 !important;
                color: white;
            }
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
        </header>
        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:340px;margin-right:40px;  min-height:700px;">
            <div class="w3-container" id="columns" style="margin-top:75px;">
                <!-- Services -->
                <div class="w3-row">
                    <div class="w3-col l12" id="services" style="margin-top:40px; padding-bottom:15px !important;">
                        <div class="w3-row">
                            <h1 class="w3-xxxlarge w3-text-blue"><b>Richieste profilo:</b></h1>
                            <hr style="width:100%;border:5px solid #42A5F5" class="w3-round">
                            <div class="w3-col l5" id="services" style="margin-top:40px; padding-bottom:15px !important;">
                                <h1 class="w3-large w3-text-blue"><b>Dipendenti:</b></h1>
                                <c:if test="${richiesteDip==null||richiesteDip.size()==0}">
                                    <div class="w3-container w3-card w3-white w3-margin-bottom" >
                                        <div class="w3-row">
                                            <div class="w3-col l12">
                                                <h4 class="w3-text-grey w3-padding-16"><i class="fa fa-suitcase fa-fw w3-margin-right w3-small w3-text-teal"></i>Nessuna richiesta</h4>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                            <c:forEach items="${richiesteDip}" var="dip">
                                <div class="w3-container w3-card w3-white w3-margin-bottom" style="padding-bottom:15px !important;">
                                    <div class="w3-container">
                                        <h5 class="w3-opacity"><b></b></h5>
                                        <h4>
                                            Nome: ${dip.nome} <br>
                                            Cognome: ${dip.cognome} <br>
                                            Email: ${dip.email} <br>
                                            Telefono 1: ${dip.tel}<br>
                                            <c:if test="${dip.tel2!=null}">Telefono 2: ${dip.tel2}</c:if>
                                        </h4>
                                        <hr>
                                        <a href="accettaRichiesta?email=${dip.email}" class="bottone"> ACCETTA</a>
                                    </div>
                                </div>
                            </c:forEach>
                            </div>
                            <div class="w3-col l2" id="services" style="margin-top:40px; padding-bottom:15px !important;"></div>
                            <div class="w3-col l5" id="services" style="margin-top:40px; padding-bottom:15px !important;">
                                <h1 class="w3-large w3-text-blue"><b>Clienti:</b></h1>
                                <c:if test="${richiesteCli==null||richiesteCli.size()==0}">
                                    <div class="w3-container w3-card w3-white w3-margin-bottom" >
                                        <div class="w3-row">
                                            <div class="w3-col l12">
                                                <h4 class="w3-text-grey w3-padding-16"><i class="fa fa-suitcase fa-fw w3-margin-right w3-small w3-text-teal"></i>Nessuna richiesta</h4>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                            <c:forEach items="${richiesteCli}" var="cli">
                                <div class="w3-container w3-card w3-white w3-margin-bottom" style="padding-bottom:15px !important;">
                                    <div class="w3-container">
                                        <h5 class="w3-opacity"><b></b></h5>
                                        <h4>
                                            Denominazione: ${cli.azienda} <br>
                                            Partita IVA: ${cli.piva} <br>
                                            Telefono 1: ${cli.tel} <br>
                                            <c:if test="${cli.tel2!=null}">Telefono 2: ${cli.tel2}<br></c:if>
                                            Email: ${cli.email}
                                        </h4>
                                        <hr>
                                        <a href="accettaRichiesta?piva=${cli.piva}" class="bottone"> ACCETTA</a>
                                    </div>
                                </div>
                            </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End page content -->
        </div>
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
        </script>
    </body>
</html>
