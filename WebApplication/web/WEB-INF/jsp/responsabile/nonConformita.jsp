<%-- 
    Document   : nonConformita
    Created on : 14-apr-2018, 11.46.14
    Author     : FSEVERI\sinigaglia3584
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="wba.model.Dipendente"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Non conformità</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../resources/css/w3.css">
        <link rel="stylesheet" href="../resources/css/style.css">
        <link href="https://fonts.googleapis.com/css?family=Crete+Round" rel="stylesheet">
        <meta http-equiv="cache-control" content="max-age=0" />
        <meta http-equiv="cache-control" content="no-cache" />
        <meta http-equiv="expires" content="0" />
        <style>
            body,h1,h2,h3,h4,h5 {font-family: "Poppins", sans-serif}
            body {font-size:16px;}
            .w3-half img{margin-bottom:-6px;margin-top:16px;opacity:0.8;cursor:pointer}
            .w3-half img:hover{opacity:1}
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
            <span class="font_google"></span>
        </header>
        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:340px;margin-right:40px">
            <div class="w3-container" id="columns" style="margin-top:75px">
                <!-- Services -->
                <div class="w3-row">
                    <div class="w3-col l12" id="services">
                        <h1 class="w3-xxxlarge w3-text-blue"><b>Non Conformita'</b></h1>
                        <hr style="width:100%;border:5px solid #42A5F5" class="w3-round">
                        
                        <c:if test="${nc==null||nc.size()==0}">
                            <div class="w3-container w3-card w3-white w3-margin-bottom" >
                                <div class="w3-row">
                                    <div class="w3-col l12">
                                        <h2 class="w3-text-grey w3-padding-16"><i class="fa fa-suitcase fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>Nessuna non confromità trovata in questa fase</h2>
                                    </div>
                                </div>
                            </div>
                        </c:if>
<c:forEach items="${nc}" var="nc">
                        
                        
                        <div class="w3-container w3-card w3-white w3-margin-bottom" onclick="javascript:location.href='infoNC?nr=${nc.nr}'">
                            <div class="w3-row">
                                <div class="w3-col l8">
                                    <h2 class="w3-text-grey w3-padding-16"><i class="fa fa-suitcase fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>NC nr: ${nc.nr}</h2>
                                </div>
    <c:if test="${nc.dataFine!=null}">
                                    <div class="w3-col l4 ">
                                        <center><p class="w3-padding-16" style="font-size:20px;">Categoria: <span style="color:red; font-weight:bold;"> Chiusa</span></p></center>
                                    </div>
    </c:if>
    <c:if test="${nc.dataFine==null&&nc.dataInizio!=null&&nc.azioneContenimento!=null}">
                                    <div class="w3-col l4 ">
                                        <center><p class="w3-padding-16" style="font-size:20px;">Categoria: <span style="color:yellow; font-weight:bold;"> In Esecuzione</span></p></center>
                                    </div>
    </c:if>
    <c:if test="${nc.dataFine==null&&nc.dataInizio!=null&&nc.azioneContenimento==null}">
                                    <div class="w3-col l4 ">
                                        <center><p class="w3-padding-16" style="font-size:20px;">Categoria: <span style="color:green; font-weight:bold;"> Aperta</span></p></center>
                                    </div>
    </c:if>
                            </div>
                            <div class="w3-container">
                                <h5 class="w3-opacity"><b></b></h5>
                                <h6 class="w3-text-teal"><i class="fa fa-calendar fa-fw"></i>Data inizio: ${nc.realDataInizio()} </h6>
                                <p>Descrizione problema: <br> ${nc.descrProblema}</p>
                                <hr>
                            </div>
                            <div class="w3-container">
                                <h6 class="w3-opacity"><b>Aperta da: <span style="font-weight:strong">  ${nc.dipendenteRisc.nome} ${nc.dipendenteRisc.cognome} ${nc.cliente.piva}</span></b></h6>
                                <br>
                            </div>
                        </div>
                        
</c:forEach>
                        
                        
                        
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

