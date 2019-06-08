<%-- 
    Document   : richiestaRegistrazione
    Created on : 11-apr-2018, 19.47.25
    Author     : alberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Registrazione</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="resources/css/w3.css">
        <link href="https://fonts.googleapis.com/css?family=Crete+Round" rel="stylesheet">
        <link rel="stylesheet" href="resources/style.css">
        <link rel="stylesheet" href="resources/css/formStyle.css">
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
                <h3 class="w3-padding-64" style="padding-bottom:0px !important;"><b>Attenzione:</b></h3>
            </div>
            <div class="w3-bar-block">
                <div class="w3-container">
                    <h5><b>
                            Dopo l'invio del modulo, bisognerà attendere la convalida del profilo da parte del responsabile.
                        </b></h5>
                </div>
                <div class="w3-row">
                    <br>
                    <br>
                    <center>
                        <button onclick="location.href = 'login'" class="bottone">Torna al login</button>
                    </center>
                </div>
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
                        <h1 class="w3-xxxlarge w3-text-blue"><b>Iscrizione</b></h1>
                        <hr style="width:100%;border:5px solid #42A5F5" class="w3-round">
                        <div class="w3-container w3-card w3-white w3-margin-bottom">
                            <div class="w3-container w3-padding-16">
                                <div class="tab-content">
                                    <ul class="tab-group">
                                        <li class="tab active"><a href="#signup">Dipendente</a></li>
                                        <li class="tab"><a href="#login">Cliente</a></li>
                                    </ul>
                                    <div id="signup">
                                        <form action="richiediRegDip" onsubmit="return controllaDip();" method="post">
                                            <div class="top-row">
                                                <div class="field-wrap">
                                                    <input type="text" required autocomplete="off" class="w3-input input" name="NOME" id="NOME"placeholder="Nome" />
                                                </div>
                                                <div class="field-wrap">
                                                    <input type="text" required autocomplete="off" class="w3-input input" name="COGNOME" id="COGNOME" placeholder="Cognome" />
                                                </div>
                                            </div>
                                            <div class="field-wrap">
                                                <input type="text" required autocomplete="off" class="w3-input input" name="EMAIL" id="EMAIL" placeholder="Email" />
                                            </div>
                                            <div class="top-row">
                                                <div class="field-wrap">
                                                    <input type="text" required autocomplete="off" class="w3-input input" name="TEL1" id="TEL1" placeholder="Telefono personale" />
                                                </div>
                                                <div class="field-wrap">
                                                    <input type="text" autocomplete="off" class="w3-input input" name="TEL2" id="TEL2" placeholder="Telefono secondario (opzionale)"/>
                                                </div>
                                            </div>
                                            <div class="field-wrap">
                                                <input type="password" required autocomplete="off" class="w3-input input" name="PASS1" id="PASS1" placeholder="Password" />
                                            </div>
                                            <div class="field-wrap">
                                                <input type="password" required autocomplete="off" class="w3-input input" name="PASS2" id="PASS2" placeholder="Ripeti password" />
                                            </div>
                                            <button type="submit" class="button button-block" />Invia modulo</button>
                                        </form>
                                    </div>

                                    <div id="login">
                                        <form action="richiediRegCli" onsubmit="return controllaCli();" method="post" id="formC">
                                            <div class="field-wrap">
                                                <input type="text" required autocomplete="off" class="w3-input input" name="DENOM" id="DENOMC" placeholder="Denominazione Azienda" />
                                            </div>
                                            <div class="field-wrap">
                                                <input type="numeric" required autocomplete="off" class="w3-input input" name="PIVA" id="PIVAC" placeholder="Partita IVA" />
                                                <div class="top-row" style="margin-top:10px;">
                                                    <div class="field-wrap">
                                                        <input type="numeric" required autocomplete="off" class="w3-input input" name="TEL1" id="TEL1C" placeholder="Telefono" />
                                                    </div>
                                                    <div class="field-wrap">
                                                        <input type="numeric" autocomplete="off" class="w3-input input" name="TEL2" id="TEL2C" placeholder="Telefono 2 (opzionale)" />
                                                    </div>
                                                </div>
                                                <div class="field-wrap">
                                                    <input type="password" required autocomplete="off" class="w3-input input" id="PASS1C" name="PASS1" placeholder="Password" />
                                                </div>
                                                <div class="field-wrap">
                                                    <input type="password" required autocomplete="off" class="w3-input input" id="PASS2C" name="PASS2" placeholder="Ripeti password" />
                                                </div>
                                                <div class="field-wrap">
                                                    <input type="email" required autocomplete="off" class="w3-input input"name="EMAIL" id="EMAILC" placeholder="Email di riferimento" />
                                                </div>
                                                <button type="submit" class="button button-block" />Invia modulo</button>
                                            </div>
                                        </form>
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
        <script src="resources/js/form.js"></script>
        <script>
        function w3_open() {
            document.getElementById("mySidebar").style.display = "block";
            document.getElementById("myOverlay").style.display = "block";
        }

        function w3_close() {
            document.getElementById("mySidebar").style.display = "none";
            document.getElementById("myOverlay").style.display = "none";
        }
        function controllaDip() {
            resetDip();
            var errore = false;
            var element = document.getElementById("NOME").value;
            var tmp = new RegExp(/^[a-zA-Z]+$/).test(element);
            if (element === "" || tmp == false) {
                document.getElementById("NOME").style.borderColor = "red";
                errore = true;
            }
            element = document.getElementById("COGNOME").value;
            tmp = new RegExp(/^[a-zA-Z]+$/).test(element);
            if (element == "" || tmp == false) {
                document.getElementById("COGNOME").style.borderColor = "red";
                errore = true;
            }
            element = document.getElementById("EMAIL").value;
            tmp = new RegExp(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/).test(element);
            if (element == "" || tmp == false) {
                document.getElementById("EMAIL").style.borderColor = "red";
                errore = true;
            }
            element = document.getElementById("TEL1").value;
            tmp = new RegExp(/^[0-9]+$/).test(element);
            if (element == "" || tmp == false) {
                document.getElementById("TEL1").style.borderColor = "red";
                errore = true;
            }
            element = document.getElementById("TEL2").value;
            if (element != "" || element == null) {
                tmp = new RegExp(/^[0-9]+$/).test(element);
                if (element == "" || tmp == false) {
                    document.getElementById("TEL2").style.borderColor = "red";
                    errore = true;
                }
            }

            var element1 = document.getElementById("PASS1").value;
            var element2 = document.getElementById("PASS2").value;
            if (element1 == "" || element2 == "" || element1 != element2) {
                document.getElementById("PASS1").style.borderColor = "red";
                document.getElementById("PASS2").style.borderColor = "red";
                errore = true;
            }
            return !errore;
        }
        function resetDip() {
            document.getElementById("PASS1").style.borderColor = "grey";
            document.getElementById("PASS2").style.borderColor = "grey";
            document.getElementById("TEL2").style.borderColor = "grey";
            document.getElementById("TEL1").style.borderColor = "grey";
            document.getElementById("EMAIL").style.borderColor = "grey";
            document.getElementById("NOME").style.borderColor = "grey";
            document.getElementById("COGNOME").style.borderColor = "grey";
        }




        function controllaCli() {
            resetDip();
            var errore = false;
            var element = document.getElementById("DENOMC").value;
            var tmp = new RegExp(/^[a-zA-Z]+$/).test(element);
            if (element === "" || tmp == false) {
                document.getElementById("DENOMC").style.borderColor = "red";
                errore = true;
            }
            element = document.getElementById("PIVAC").value;
            tmp = new RegExp(/^[0-9]+$/).test(element);
            if (element == "" || tmp == false || element.length != 11) {
                document.getElementById("PIVAC").style.borderColor = "red";
                errore = true;
            }
            element = document.getElementById("EMAILC").value;
            tmp = new RegExp(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/).test(element);
            if (element == "" || tmp == false) {
                document.getElementById("EMAILC").style.borderColor = "red";
                errore = true;
            }
            element = document.getElementById("TEL1C").value;
            tmp = new RegExp(/^[0-9]+$/).test(element);
            if (element == "" || tmp == false) {
                document.getElementById("TEL1C").style.borderColor = "red";
                errore = true;
            }
            element = document.getElementById("TEL2C").value;
            if (element != "" || element == null) {
                tmp = new RegExp(/^[0-9]+$/).test(element);
                if (element == "" || tmp == false) {
                    document.getElementById("TEL2C").style.borderColor = "red";
                    errore = true;
                }
            }
            var element1 = document.getElementById("PASS1C").value;
            var element2 = document.getElementById("PASS2C").value;
            if (element1 == "" || element2 == "" || element1 != element2) {
                document.getElementById("PASS1C").style.borderColor = "red";
                document.getElementById("PASS2C").style.borderColor = "red";
                errore = true;
            }
            return !errore;
        }
        function resetCli() {
            document.getElementById("PASS1C").style.borderColor = "grey";
            document.getElementById("PASS2C").style.borderColor = "grey";
            document.getElementById("TEL2C").style.borderColor = "grey";
            document.getElementById("TEL1C").style.borderColor = "grey";
            document.getElementById("EMAILC").style.borderColor = "grey";
            document.getElementById("DENOMC").style.borderColor = "grey";
            document.getElementById("PIVAC").style.borderColor = "grey";
        }
        </script>
    </body>

</html>
