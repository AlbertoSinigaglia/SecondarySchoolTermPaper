<%--
    Document   : pezzi
    Created on : 23-apr-2018, 23.35.35
    Author     : alberto
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Pezzi</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../resources/css/w3.css">
        <link href="https://fonts.googleapis.com/css?family=Crete+Round" rel="stylesheet">
        <link rel="stylesheet" href="../resources/css/formStyle.css">
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
            }

            .bottone:hover {
                background-color: white;
                color: #42A5F5;
            }
            select{background-color: white; border-radius:5px;}
            textarea{border: 3px solid #42A5F5; border-right:0px solid white; border-left:0px solid white;}
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
            <span class="font_google">Gestione pezzi</span>
        </header>
        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:340px;margin-right:40px;  min-height:700px;">
            <div class="w3-container" id="columns" style="margin-top:75px;">
                <!-- Services -->
                <div class="w3-row">
                    <div class="w3-col l12" id="services" style="margin-top:40px">
                        <h1 class="w3-xxxlarge w3-text-blue"><b>Compila i campi per inserire un nuovo prodotto</b></h1>
                        <hr style="width:100%;border:5px solid #42A5F5" class="w3-round">
                        <div class="w3-container w3-card w3-white w3-margin-bottom">
                            <c:if test="${pezzo!=null}">
                                <form action="modificaPezzo" method="POST" id="form">
                                    <input hidden="true" name="nr" value="${pezzo.codicePezzo}">
                            </c:if>
                            <c:if test="${pezzo==null}">
                                <form action="addPezzo" method="POST" id="form">
                            </c:if>
                                <div class="w3-container">
                                    <h5 class="w3-opacity"><b></b></h5>
                                        <div class="form-group">
                                            <label>Nome identificativo :</label>
                                            <input type="text" name="nome" style="width:100%" value="${pezzo.nome}">
                                        </div>
                                        <div class="form-group">
                                            <label>Descrizione :</label>
                                            <textarea  placeholder="Descrivi il nuovo pezzo" name="descrizione" id="textarea">${pezzo.descrizione}</textarea>
                                        </div>
                                        <hr style="margin-bottom:0px;">
                                        <div class="form-group">
                                            <button type="submit" name="invia" class="bottone" onclick="controlla()">Conferma</button>
                                        </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- segnalazioni passate-->
                <div class="w3-row">
                    <div class="w3-col l12" id="services" style="margin-top:40px">
                        <h1 class="w3-xxxlarge w3-text-blue"><b>Pezzi registrati</b></h1>
                        <hr style="width:100%;border:5px solid #42A5F5" class="w3-round">
<c:forEach items="${pezzi}" var="pezzo">
                        <div class="w3-container w3-card w3-white w3-margin-bottom">
                            <div class="w3-container">
                                <div class="w3-container">
                                    <h5 class="w3-text-teal"><i class="fa fa-calendar fa-fw"></i><b>Nome pezzo:</b> ${pezzo.nome}</h5>
                                    <p><b>Descrizione:</b> <br> ${pezzo.descrizione}</p>
                                    <a href ="pezzi?id=${pezzo.codicePezzo}" class="bottone">Modifica</a>
                                    <button onclick="javascript:elimina(${pezzo.codicePezzo})" class="bottone">Elimina</button>
                                    <hr>
                                </div>
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
            function elimina(value) {
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    var r = this.responseText;
                    if (r == 2)
                        if (confirm("questo pezzo non è associato ad articoli, procedere all'eliminazione?"))
                            ajax(value);
                    if (r == 1)
                        if (confirm("questo pezzo è associato ad almeno un articolo ma a nessuna non conformità, eliminandolo lo rimoverà anche da quel articolo, continuare?"))
                            ajax(value);
                    if (r == 0)
                        confirm("attenzione: questo pezzo è associato ad alcuni articoli che a fanno parte di alcune non conformità, quindi non è possibile eliminare il pezzo");
                    if (r == 1)
                        confirm("non hai i permessi per eseguire questa operazione");
                }
            };
            xhttp.open("GET", "/WebApplication/ajax/hasArticoli?idpezzo=" + value, true);
            xhttp.send();
        }
        function ajax(value) {
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "/WebApplication/ajax/eliminaPezzo?idpezzo=" + value, true);
            xhttp.send();
            location.href="pezzi";
        }
        </script>
    </body>
</html>