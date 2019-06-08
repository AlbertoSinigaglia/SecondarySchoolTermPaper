<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Segnalazioni</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../resources/css/w3.css">
        <link rel="stylesheet" href="../resources/css/style.css">
        <link href="https://fonts.googleapis.com/css?family=Crete+Round" rel="stylesheet">
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
                padding: 3px 20px;
                font-size: 20px;
                float:right;
                margin-top:10px;
            }

            .bottone:hover {
                background-color: white;
                color: #42A5F5;
            }
            select, textarea{display: block;
                             width: 90%;
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
            <span class="font_google">Segnalazioni</span>
        </header>
        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:340px;margin-right:40px;  min-height:700px;">
            <div class="w3-container" id="columns" style="margin-top:75px;">
                <!-- Services -->
                <div class="w3-row">
                    <div class="w3-col l12" id="services" style="margin-top:40px">
                        <h1 class="w3-xxxlarge w3-text-blue"><b>Compila la tua segnalazione</b></h1>


                        <hr style="width:100%;border:5px solid #42A5F5" class="w3-round">
                        <div class="w3-container w3-card w3-white w3-margin-bottom">
                            <form action="nuovaSegnalazione" method="POST" id="form" onsubmit="return check()">
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
                                        <br>
                                        <div class="form-group" style="margin-top:40px;">
                                            <label>Problematica :</label>
                                            <textarea  placeholder="Descrivi la problematica riscontrata" name="problematica" id="textarea" style="height:auto !important; width:95%;font-size:16px;"></textarea>
                                        </div>
                                        <hr style="margin-bottom:0px;">
                                        <div class="form-group">
                                            <button type="submit" name="invia" class="bottone" >Invia</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <p style="color:red" id="errore"></p>
                        </div>
                    </div>
                </div>
                <!-- segnalazioni passate-->
                <div class="w3-row">
                    <div class="w3-col l12" id="services" style="margin-top:40px">
                        <h1 class="w3-xxxlarge w3-text-blue"><b>Segnazioni eseguite</b></h1>
                        <hr style="width:100%;border:5px solid #42A5F5" class="w3-round">
                        <c:if test="${segnalazioni==null||segnalazioni.size()==0}">
                            <div class="w3-container w3-card w3-white w3-margin-bottom">
                                <div class="w3-container">
                                    <div class="w3-container">
                                        <h3 class="w3-text-grey w3-padding-8" style="margin-top:0px !important;"><i class="fa fa-suitcase fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>Nessuna segnalazione</h3>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <c:forEach items="${segnalazioni}" var="segnalazione">
                            <div class="w3-container w3-card w3-white w3-margin-bottom">
                                <div class="w3-container">
                                    <div class="w3-container">
                                        <h5 class="w3-opacity"><b></b></h5>
                                        <h6 class="w3-text-teal"><i class="fa fa-calendar fa-fw"></i>Segnalazione su ${segnalazione.pezzo.nome} di ${segnalazione.articolo.nome} </h6>
                                        <p>Descrizione problema: <br> ${segnalazione.descrProblema}</p>
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
            var bool = false;
            function ajax(value) {
                if (!bool) {
                    document.getElementById("s1").remove(0);
                    bool = true;
                }
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