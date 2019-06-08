<%-- 
    Document   : errore
    Created on : 23-apr-2018, 17.11.08
    Author     : alberto
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Errore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../resources/css/w3.css">
        <link rel="stylesheet" href="resources/css/w3.css">
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
                padding:7px 15px;
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
                <h5 class="w3-opacity"><b></b></h5>
                <p>Motivi per cui si può trovare in questa pagina:<p>
                <ul>
                    <li>Sta cercando di accedere ad un a pagina che non esiste</li>
                    <li>Sta cercando di accedere a una pagina a cui non le è concesso</li>
                    <li>La richiesta da lei inoltrata non è valida</li>
                    <li>La sessione è scaduta</li>
                </ul>
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
                        <h1 class="w3-xxxlarge w3-text-blue"><b>Ops, errore</b></h1>


                        <hr style="width:100%;border:5px solid #42A5F5" class="w3-round">
                        <div class="w3-container w3-card w3-white w3-margin-bottom" style="padding-bottom:15px !important;">

                            <div class="w3-container">
                                <h5 class="w3-opacity"><b></b></h5>
                                <h2><font color="#00BCD4">Abbiamo riscontrato una problematica.</font></h2>
                                <h4> La pagina da lei ricercata non è stata trovata.</h4>
                            </div>
                            <hr>
                            <div class="w3-row">
                                    <button onclick="location.href='/WebApplication/login'" class="bottone">Torna al login</button>

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