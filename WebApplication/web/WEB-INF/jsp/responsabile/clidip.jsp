<%-- 
    Document   : richiestaRegistrazione
    Created on : 11-apr-2018, 19.47.25
    Author     : alberto
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Registrazione</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../resources/css/w3.css">
        <link href="https://fonts.googleapis.com/css?family=Crete+Round" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"rel="stylesheet">
        <link rel="stylesheet" href="../resources/css/style.css">
        <link rel="stylesheet" href="../resources/css/formStyle.css">
        <meta http-equiv="cache-control" content="max-age=0" />
        <meta http-equiv="cache-control" content="no-cache" />
        <meta http-equiv="expires" content="0" />
        <style>
            body,h1,h2,h3,h4,h5 {font-family: "Poppins", sans-serif}
            body {font-size:16px;}
            .w3-half img{margin-bottom:-6px;margin-top:16px;opacity:0.8;cursor:pointer}
            .w3-half img:hover{opacity:1}
            .input{
                border-radius:5px !important;
                font-weight:normal !important;
            }
            .bottone{
                color:white;
                background-color:#42A5F5;
                border: 1px solid #42A5F5;
                border-radius:5px;
                font-weight:bold;
                padding:15px 30px;
                font-size:20px;
            }
            .bottone:hover{
                background-color:white;
                color:#42A5F5;
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
            <span class="font_google">Accesso</span>
        </header>
        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:340px;margin-right:40px;  min-height:700px;">
            <div class="w3-container" id="columns" style="margin-top:75px;">
                <!-- Services -->
                <div class="w3-row">
                    <div class="w3-col l12" id="services" style="margin-top:40px">
                        <h1 class="w3-xxxlarge w3-text-blue"><b>Gestione profili dipendente e cliente</b></h1>
                        <hr style="width:100%;border:5px solid #42A5F5" class="w3-round">
                        <div class="w3-container w3-card w3-white w3-margin-bottom">
                            <div class="w3-container w3-padding-16">
                                <div class="tab-content">
                                    <ul class="tab-group">
                                        <li class="tab active"><a href="#signup">Dipendenti</a></li>
                                        <li class="tab"><a href="#login">Clienti</a></li>
                                    </ul>
                                    <div id="signup">
                                        <c:forEach items="${dipendenti}" var="dip">
                                            <div class="w3-container w3-padding-16" onclick="location.href='infoDip?email=${dip.email}'>
                                                <div class="w3-row">
                                                    <div class="w3-col l11">
                                                        <h4 class="w3-text-teal w3-padding-8"><b>Dipendente: ${dip.nome} ${dip.cognome}<br></b></h4>
                                                        <b>Email identificativa:</b><br>
                                                        ${dip.email}<br>
                                                        <b>Telefono personale:</b><br>
                                                        ${dip.tel}<br>
                                                        <c:if test="${dip.tel2!=null&&dip.tel!=''}">
                                                        <b>Telefono secondario</b><br>
                                                        ${dip.tel2}<br>
                                                        </c:if>
                                                    </div>
                                                    <div class="w3-col l1 m0 s0">
                                                        <a href="infoDip?email=${dip.email}"><i class="material-icons" style="font-size:35px; margin-top:20px;">info</i></a>
                                                    </div>
                                                </div>
                                            </div>
                                            <hr>
                                        </c:forEach>
                                    </div>
                                        
                                    <div id="login">
                                        <c:forEach items="${clienti}" var="cli">
                                            <div class="w3-container w3-padding-16" onclick="location.href='infoCli?piva=${cli.piva}'">
                                                <div class="w3-row">
                                                    <div class="w3-col l11">
                                                        <h4 class="w3-text-teal w3-padding-8"><b>Denominazione azienda: ${cli.azienda}<br></b></h4>
                                                        <b>P.IVA identificativa:</b><br>
                                                        ${cli.piva}<br>
                                                        <b>Email di riferimento</b><br>
                                                        ${cli.email}<br>
                                                        <b>Telefono:</b><br>
                                                        ${cli.tel}<br>
                                                        <c:if test="${cli.tel2!=null&&cli.tel != ''}">
                                                        <b>Telefono secondario</b><br>
                                                        ${cli.tel2}<br>
                                                        </c:if>
                                                    </div>
                                                    <div class="w3-col l1 m0 s0">
                                                        <a href="infoCli?piva=${cli.piva}"><i class="material-icons" style="font-size:35px; margin-top:20px;">info</i></a>
                                                    </div>
                                                </div>
                                            </div>
                                            <hr>
                                        </c:forEach>
                                    </div>
                                    <!-- tab-content -->
                                </div>
                                <!-- End page content -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="../resources/js/form.js"></script>
        <script>
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
