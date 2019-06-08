<%-- 
    Document   : modifica
    Created on : 23-apr-2018, 9.42.07
    Author     : FSEVERI\sinigaglia3584
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Modifica NC</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../resources/css/w3.css">
        <link href="https://fonts.googleapis.com/css?family=Crete+Round" rel="stylesheet">
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
            input[type=text]:focus {
                border: 1px solid blue;
            }
            .input{
                border-radius:5px;
                font-weight:normal !important;
            }
            .bottone {
                color: white;
                background-color: #42A5F5;
                border: 1px solid #42A5F5;
                border-radius: 5px;
                font-weight: bold;
                margin-top:20px;
                padding: 3px 20px;
                font-size: 20px;
                float:right;
                margin-top:10px;
            }

            .bottone:hover {
                background-color: white;
                color: #42A5F5;
            }
            .biancohover:hover{
                background-color:#c3e0ff !important;
                color:#42A5F5!important;
                border: 2px solid #c3e0ff !important;
            }
            textarea{display: block;
                             width: 100%;
                             height: 80px;
                             padding: 6px 12px;
                             font-size: 14px;
                             line-height: 1.42857143;
                             color: #555;
                             background-color: #fff;
                             background-image: none;
                             border: 1px solid #ccc;
                             border-radius: 4px;
                             -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
                             box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
                             -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
                             -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
                             transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
            }
            p.inline {display: inline;}
            p.inline {display: inline; background-color: #E0E0E0; padding:10px !important; margin-right: 10px; border-radius: 5px;}
            
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
            <span class="font_google">Modifica NC</span>
        </header>
        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:340px;margin-right:40px;  min-height:700px;">
            <div class="w3-container" id="columns" style="margin-top:75px;">
                <!-- Services -->
                <div class="w3-row">
                    <div class="w3-col l12" id="services" style="margin-top:40px">
                        <h1 class="w3-xxxlarge w3-text-blue"><b>Modifica della Non Conformit&agrave;</b></h1>


                        <hr style="width:100%;border:5px solid #42A5F5" class="w3-round">
                        <div class="w3-container w3-card w3-white w3-margin-bottom">

                            <form action="applicaModifiche" method="POST">
                                <input name="nr" hidden="true" value="${nc.nr}">
                                <h3><font color="#00BCD4"> Stai modificando la non conformità numero:<b> ${nc.nr}</b></font></h3>
                                <p><b>Personale addetto :</b><br></p>
                                <label style="margin-bottom:8px !important;">
                                <c:forEach items="${nc.dipendentiGest}" var="dip">
                                    <p class="inline">${dip.cognome} ${dip.nome}</p>
                                </c:forEach>
                                </label>
                                <br>
                                <p style="margin-bottom:0px;"><b>Pezzo</b> : ${nc.pezzo.nome} </p>
                                <b>Articolo :</b> ${nc.articolo.nome}
                                <br>
                                <b>Descrizione problema:</b> ${nc.descrProblema}
                                <br>
                                <b>Data riscontro :</b> ${nc.realDataInizio()}
                                <br>
                                <input name="nr" hidden="true" value="${nc.nr}">
                                <div class="row">
                                    <div class="form-group">
                                        <label><b>Azione di contenimento:</b></label>
                                        <textarea class="w3-container w3-opacity w3-card w3-white w3-margin-bottom" name="azioneContenimento">${nc.azioneContenimento}</textarea>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group">
                                        <label><b>Azione corretiva:</b></label>
                                        <textarea class="w3-container w3-opacity w3-card w3-white w3-margin-bottom" name="azioneCorrettiva">${nc.azioneCorrettiva}</textarea>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group">
                                        <label><b>Verifica azioni:</b></label>
                                        <textarea class="w3-container w3-opacity w3-card w3-white w3-margin-bottom"name="verificaAzioni">${nc.verificaAzioni}</textarea>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group">
                                        <label><b>Verifica efficacia:</b></label>
                                        <textarea class="w3-container w3-opacity w3-card w3-white w3-margin-bottom" name="verificaEfficacia">${nc.verificaEfficacia}</textarea>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group">
                                        <label><b>Azioni ricorrenza:</b></label>
                                        <textarea class="w3-container w3-opacity w3-card w3-white w3-margin-bottom" name="azioniRicorrenza">${nc.azioniRicorrenza}</textarea>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group">
                                        <label><b>Cause:</b></label>
                                        <textarea class="w3-container w3-opacity w3-card w3-white w3-margin-bottom" name="cause">${nc.cause}</textarea>
                                    </div>
                                </div>
                                 <div class="row">
                                    <div class="form-group">
                                        <label><b>Descrizione spedizione per il rientro del materiale: </b></label>
                                        <textarea class="w3-container w3-opacity w3-card w3-white w3-margin-bottom" name="descrSpedizione">${nc.descrSpedizione}</textarea>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group">
                                        <label><b>Costo previsto:</b></label>
                                        <textarea class="w3-container w3-opacity w3-card w3-white w3-margin-bottom" name="costo">${nc.costo}</textarea>
                                    </div>
                                </div>
                                <div class="w3-row">
                                    <div class="form-group w3-col l12" style="margin-bottom:10px !important;">
                                        <button type="submit" name="invia" class="bottone">Salva</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End page content -->
        </div>
        <!-- W3.CSS Container -->

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