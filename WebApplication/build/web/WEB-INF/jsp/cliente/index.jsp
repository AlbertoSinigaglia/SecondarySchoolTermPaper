<%-- 
    Document   : index
    Created on : 26-mar-2018, 0.22.21
    Author     : alberto
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../resources/css/w3.css">
        <link rel="stylesheet" href="../resources/css/style.css">
        <link href="https://fonts.googleapis.com/css?family=Crete+Round" rel="stylesheet">
        <link rel="stylesheet" href="../resources/css/style.css">
        <meta http-equiv="cache-control" content="max-age=0" />
        <meta http-equiv="cache-control" content="no-cache" />
        <link rel="stylesheet" href="../resources/css/formStyle.css">
        <meta http-equiv="expires" content="0" />
        <style>
            body,
            h1,
            h2,
            h3,
            h4,
            h5 {
                font-family: "Poppins", sans-serif
            }

            body {
                font-size: 16px;
            }

            .w3-half img {
                margin-bottom: -6px;
                margin-top: 16px;
                opacity: 0.8;
                cursor: pointer
            }

            .w3-half img:hover {
                opacity: 1
            }

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
                margin-top:20px;
                flot:right;
                font-size: 20px;
            }

            .bottone:hover {
                background-color: white;
                color: #42A5F5;
            }
        </style>
    </head>

    <body>
        <!-- Sidebar/menu -->
        <nav class="w3-sidebar w3-blue w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar">
            <br>
            <div class="w3-container">
                <h3 class="w3-padding-64"><b>Cliente <br></b></h3>
            </div>
            <div class="w3-bar-block">
                <li onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white"><a href="logout">Logout</a></li>
            </div>
        </nav>
        <!-- Top menu on small screens -->
        <header class="w3-container w3-top w3-hide-large w3-blue w3-xlarge w3-padding">
            <a href="javascript:void(0)" class="w3-button w3-blue w3-margin-right w3-hover-white" onclick="w3_open()">☰</a>
            <span class="font_google">Cliente</span>
        </header>
        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
        <!-- !PAGE CONTENT! -->

        <div class="w3-main" style="margin-left:340px;margin-right:40px">
            <div class="w3-container" id="columns" style="margin-top:75px">


                <div class="w3-row">
                    <div class="w3-col l12" id="services" style="margin-top:40px">
                        <h1 class="w3-xxxlarge w3-text-blue"><b>Compila il tuo reclamo</b></h1>
                        <hr style="width:100%;border:5px solid #42A5F5" class="w3-round">
                        <div class="w3-container w3-card w3-white w3-margin-bottom">
                            <form action="nuovoReclamo" method="POST" id="form" onsubmit="return check()">
                                <div class="w3-container">
                                    <h5 class="w3-opacity"><b></b></h5>
                                    <h2><font color="#00BCD4">Complia tutti i seguenti campi:</font></h2>
                                    <div class="row">
                                        <div class="w3-col l6">
                                            <label>Seleziona il prodotto con problematica :</label><br>
                                            <select id="s1" name="s1" onChange="javascript:ajax(this.value)">
                                                <option value="auto">Seleziona articolo</option>
                                                <c:forEach items="${articoli}" var="art">
                                                    <option value="${art.codiceArticolo}">${art.nome}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="w3-col l6">
                                            <label>Seleziona il pezzo con problematica :</label><br>
                                            <select id="s2" name="s2" disabled>
                                                <option value="auto">Seleziona prima l'articolo</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Problematica riscontrata:</label>
                                        <textarea placeholder="Descrivi la problematica riscontrata" name="problematica" id="textarea"></textarea>
                                    </div>
                                    <hr style="margin-bottom:0px;">
                                    <div class="form-group">
                                        <button type="submit" name="invia" class="bottone" onclick="controlla()">Invia</button>
                                    </div>
                                </div>
                            </form>
                            <p style="color:red" id="errore"></p>
                        </div>
                    </div>
                </div>
                <!-- Services -->
                <div class="w3-row">
                    <h1 class="w3-xxxlarge w3-text-blue"><b>Non Conformita'</b></h1>
                    <hr style="width:100%;border:5px solid #42A5F5" class="w3-round">
                    <div class="w3-col l5" id="services" style="margin-top:40px">
                        <h1 class="w3-xxxlarge w3-text-red"><b>Non gestiti</b></h1>
                        <hr style="width:100%;border:5px solid red" class="w3-round">
                        <c:forEach items="${reclamiNG}" var="reclamo">
                            <div class="w3-container w3-card w3-white w3-margin-bottom">
                                <div class="w3-row">
                                    <div class="w3-col l12 s12">
                                        <h2 class="w3-text-grey w3-padding-16"><i class="fa fa-suitcase fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>Reclamo nr: ${reclamo.nr}</h2>
                                    </div>
                                </div>
                                <div class="w3-container">
                                    <p>Descrizione problema:
                                        <br> ${reclamo.descrProblema}</p>
                                    <hr>
                                </div>
                                <div class="w3-container">
                                    <p>Articolo:
                                        <br> <b>${reclamo.articolo.nome}</b></p>
                                    <p>Pezzo:
                                        <br> <b>${reclamo.pezzo.nome}</b></p>
                                    <hr>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="w3-col l2" id="services" style="margin-top:40px"></div>
                    <div class="w3-col l5" id="services" style="margin-top:40px">
                        <h1 class="w3-xxxlarge w3-text-green"><b>Gestiti</b></h1>
                        <hr style="width:100%;border:5px solid green" class="w3-round">
                        <c:forEach items="${reclamiG}" var="reclamo">
                            <div class="w3-container w3-card w3-white w3-margin-bottom">
                                <div class="w3-row">
                                    <div class="w3-col l12 s12">
                                        <h2 class="w3-text-grey w3-padding-16"><i class="fa fa-suitcase fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>Reclamo nr: ${reclamo.nr}</h2>
                                    </div>
                                </div>
                                <div class="w3-container">
                                    <p>Descrizione problema:
                                        <br>${reclamo.descrProblema}</p>
                                    <hr>
                                </div>
                                <div class="w3-container">
                                    <p>Articolo:
                                        <br> <b>${reclamo.articolo.nome}</b></p>
                                    <p>Pezzo:
                                        <br> <b>${reclamo.pezzo.nome}</b></p>
                                    <hr>
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
            function ajax(value) {
                document.getElementById("s1").remove(0);
                document.getElementById("s2").disabled = false;
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        document.getElementById("s2").innerHTML = "";
                        var obj = JSON.parse(this.responseText);
                        var s2 = document.getElementById("s2");
                        for (i = 0; i < obj.id.length; i++) {
                            var opt = document.createElement('option');
                            opt.value = obj.id[i];
                            opt.innerHTML = obj.nome[i];
                            s2.appendChild(opt);
                        }
                    }
                };
                xhttp.open("GET", "/WebApplication/ajax/pezzi?articolo=" + value, true);
                xhttp.send();
            }
            function check() {
                var textarea = document.getElementById("textarea").value;
                var tmp = document.getElementById("s1");
                var s1 = tmp.options[tmp.selectedIndex].value;
                tmp = document.getElementById("s2");
                var s2 = tmp.options[tmp.selectedIndex].value;
                if (s1 != null && s1 != "auto" && s2 != null && s2 != "auto" && textarea != null && textarea != "")
                    return true;
                document.getElementById("errore").innerHTML = "Attenzione: selezinare sia un articolo che un prodotto e fornire una descrizione valida";
                return false;
            }
        </script>
    </body>

</html>

