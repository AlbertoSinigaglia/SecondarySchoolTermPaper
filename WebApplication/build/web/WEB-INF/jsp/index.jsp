<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false" %>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="resources/css/w3.css">
        <link href="https://fonts.googleapis.com/css?family=Crete+Round" rel="stylesheet">
        <link rel="stylesheet" href="resources/css/style.css">
        <meta http-equiv="cache-control" content="max-age=0" />
        <meta http-equiv="cache-control" content="no-cache" />
        <meta http-equiv="expires" content="0" />
        <style>
            .bottone-input{background-color:#2196F3 !important; color:white !important;  border-radius:5px !important; font-weight:normal !important;     transition: all 0.5s ease;}
            .bottone-input:hover{background-color:#1565C0 !important;}
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
                padding: 15px 30px;
                font-size: 20px;
            }

            .bottone:hover {
                background-color: white;
                color: #42A5F5;
            }
            .errore{border-radius: 5px; background-color:#FF8A65; text-align: center; border-width: 2px; color:#b71c1c;}
        </style>
    </head>

    <body>
        <!-- Sidebar/menu -->
        <nav class="w3-sidebar w3-blue w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar">
            <br>
            <div class="w3-container">
                <h3 class="w3-padding-64" style="padding-bottom:15px !important;"><b>Primo accesso?</b></h3>
            </div>
            <div class="w3-bar-block">

                <div class="w3-container">
                    <h5 class="w3-opacity"><b></b></h5>
                    <p>Iter per la convalida dei requisiti:</p>
                    <ol>
                        <li>Aver effettuato la richiesta di registrazione</li>
                        <li>Attendere la conferma del responsabile</li>
                        <li>Attendere che il sistema salvi i dati</li>
                        <li>Dopodiche' sara' possibile accedere tramite il pannello apposito</li>
                    </ol>
                </div>
                <div class="w3-row">
                    <br>
                    <br>
                    <center>
                        <button onclick="location.href = 'richiestaRegistrazione'" class="bottone">Richiedi accesso</button>
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
                        <h1 class="w3-xxxlarge w3-text-blue"><b>Accesso:</b></h1>

                        <hr style="width:100%;border:5px solid #42A5F5" class="w3-round">
                        <form id="form" class="w3-container" action="homepage" method="post">
                            <div id="errore" class="errore w3-col l12 "></div>
                            <input class="w3-input input" type="text" name="username" id="username" placeholder="Email o P.IVA" style="margin-bottom:8px;">
                            <input class="w3-input input" type="password" name="password" id="password" placeholder="Password" style="margin-bottom:12px;">
                            <input type="button" onclick="check();" class="w3-input bottone-input" value="Accedi">
                        </form>
                    </div>
                </div>
            </div>
            <!-- End page content -->
        </div>
        <script>
            function w3_open() {
                document.getElementById("mySidebar").style.display = "block";
                document.getElementById("myOverlay").style.display = "block";
            }

            function w3_close() {
                document.getElementById("mySidebar").style.display = "none";
                document.getElementById("myOverlay").style.display = "none";
            }
            function check(){
                var username= document.getElementById("username").value;
                var password= document.getElementById("password").value;
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        if(this.responseText==1){
                            document.getElementById("errore").innerHTML="Errore: l'abbinamento username e password non è stato trovato nel database";
                            document.getElementById("errore").style.borderColor="#b71c1c";
                            document.getElementById("errore").style.borderStyle="solid";
                            document.getElementById("errore").style.padding="5px 7px";
                            submitt(false);
                            return;
                        }
                        submitt(true);
                        return;
                    }
                };
                xhttp.open("GET", "/WebApplication/ajax/exist?username=" + username+"&password="+password, true);
                xhttp.send();
            }
            function submitt(bool){if(bool)document.getElementById("form").submit();}
        </script>
    </body>
</html>