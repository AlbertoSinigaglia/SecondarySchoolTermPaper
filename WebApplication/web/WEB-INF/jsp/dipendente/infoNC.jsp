<%-- 
    Document   : infoNC
    Created on : 19-apr-2018, 16.59.40
    Author     : alberto
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Informazioni NC</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../resources/css/w3.css">
        <link href="https://fonts.googleapis.com/css?family=Crete+Round" rel="stylesheet">
        <link rel="stylesheet" href="../resources/css/style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <meta http-equiv="cache-control" content="max-age=0" />
        <meta http-equiv="cache-control" content="no-cache" />
        <meta http-equiv="expires" content="0" />
        <style>
            body,h1,h2,h3,h4,h5 {font-family: "Poppins", sans-serif}
            body {font-size:16px;}
            .w3-half img{margin-bottom:-6px;margin-top:16px;opacity:0.8;cursor:pointer}
            .w3-half img:hover{opacity:1}
            p.inline {display: inline;}
            p.inline {display: inline; background-color: #E0E0E0; padding:10px !important; margin-right: 10px; border-radius: 5px;}
            .nomarginbottom{margin-bottom:0px!important}
            .nomargintop{margin-top:0px!important}
            .modifica{
                color: #2196F3!important;
                text-align:center;
            }
        </style>
    </head>
    <body>
        <!-- Sidebar/menu -->
        <nav class="w3-sidebar w3-blue w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar">
            <br>
            <div class="w3-container">
                <h3 class="w3-padding-64"><b>Dipendente<br></b></h3>
            </div>
            <div class="w3-bar-block">
                <li onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white"><a href="./">Homepage</a></li>
                <li onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white"><a href="creaSegnalazione">Segnalazioni</a></li>
                <li class="w3-bar-item">
                    Non Conformit&aacute;:
                    <ul style="list-style-type: circle !important;" class="nomargin">
                        <li onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white padding_li" href="aperte">&#x25B8; <a href="aperte">Aperte</a></li>
                        <li onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white padding_li" href="esec">&#x25B8; <a href="chiuse">Chiuse</a></li>
                        <li onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white padding_li" href="chiuse">&#x25B8; <a href="esec">In corso</a></li>
                    </ul>
                </li>
                <li onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white"><a href="logout">Logout</a></li>
            </div>
        </nav>
        <!-- Top menu on small screens -->
        <header class="w3-container w3-top w3-hide-large w3-blue w3-xlarge w3-padding">
            <a href="javascript:void(0)" class="w3-button w3-blue w3-margin-right w3-hover-white" onclick="w3_open()">☰</a>
            <span class="font_google">Info NC</span>
        </header>
        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:340px;margin-right:40px">
            <div class="w3-container" id="columns" style="margin-top:75px">
                <!-- Services -->
                <div class="w3-row">
                    <div class="w3-col l12" id="services">
                        <div class="w3-row">
                            <div class="w3-col l10">
                                <h1 class="w3-xxxlarge w3-text-blue"><b>Report NC:</b></h1>
                            </div>
<c:if test="${nc.dataFine==null}">
                            <div class="w3-col l2" style="padding-top:20px;">
                                <h1 class="w3-xlarge modifica" onClick="location.href='modifica?nr=${nc.nr}'"><i class="material-icons">edit</i>  Modifica</h1>
                            </div>
</c:if>
                        </div>
                        <hr style="width:100%;border:5px solid #42A5F5" class="w3-round">
                        <div class="w3-container w3-card w3-white w3-margin-bottom">
                            <div class="w3-row">
                                <div class="w3-col l10 m8">
                                    <h2 class="w3-text-grey w3-padding-16"><i class="fa fa-suitcase fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>NC nr: ${nc.nr}</h2>
                                </div>
<c:if test="${nc.dataFine!=null}">
                                    <div class="w3-col l2 ">
                                        <center><p class="w3-padding-16" style="font-size:20px;">Categoria: <span style="color:red; font-weight:bold;"> Chiusa</span></p></center>
                                    </div>
</c:if>
<c:if test="${nc.dataFine==null&&nc.dataInizio!=null&&nc.azioneContenimento!=null}">
                                    <div class="w3-col l2 ">
                                        <center><p class="w3-padding-16" style="font-size:20px;">Categoria: <span style="color:yellow; font-weight:bold;"> In Esecuzione</span></p></center>
                                    </div>
</c:if>
<c:if test="${nc.dataFine==null&&nc.dataInizio!=null&&nc.azioneContenimento==null}">
                                    <div class="w3-col l2">
                                        <center><p class="w3-padding-16" style="font-size:20px;">Categoria: <span style="color:green; font-weight:bold;"> Aperta</span></p></center>
                                    </div>
</c:if>
                            </div>
                            <hr>
                            <div class="w3-container">
                                <h6 class="w3-text-teal"><span class="w3-text-black">Aperta il:</span> <i class="fa fa-calendar fa-fw"></i>${nc.dataInizio}</h6>
<c:if test="${nc.dataFine!=null}">
                                <h6 class="w3-text-teal"><span class="w3-text-black">Chiusa il:</span> <i class="fa fa-calendar fa-fw"></i>${nc.dataFine}</h6>
</c:if>
                                <h6 class="w3-text-teal"><span class="w3-text-black">Aperta da:</span> <i class="fa fa-calendar fa-fw"></i>${dipendenteRisc} </h6>
                                <h5 class="w3-opacity"><b>Gruppo di analisi:</b></h5>
                                <label style="margin-bottom:8px !important;">
<c:forEach items="${nc.dipendentiGest}" var="dip">
                                    <p class="inline">${dip.cognome} ${dip.nome}</p>
</c:forEach>
                                </label>
                                <h5 class="w3-opacity nomarginbottom" style="margin-top: 20px;"><b>Descrizione del problema:</b></h5>
                                <p class="nomargintop">${nc.descrProblema}</p>
                                <h5 class="w3-opacity nomarginbottom"><b>Azioni per evitare il ripetersi del problema:</b></h5>
                                <p class="nomargintop">${nc.azioniRicorrenza}</p>
                                <h5 class="w3-opacity nomarginbottom"><b>Cause:</b></h5>
                                <p class="nomargintop">${nc.cause}</p>
                                <h5 class="w3-opacity nomarginbottom"><b>Descrizione spedizione e rientro del materiale con il problema descritto:</b></h5>
                                <p class="nomargintop">${nc.descrSpedizione}</p>
                                <h5 class="w3-opacity nomarginbottom"><b>Azione contenimento:</b></h5>
                                <p class="nomargintop">${nc.azioneContenimento}</p>
                                <h5 class="w3-opacity nomarginbottom"><b>Azione correttiva:</b></h5>
                                <p class="nomargintop">${nc.azioneCorrettiva}</p>
                                <hr>
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
