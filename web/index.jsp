<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Plataforma Web - Suscribete</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>   
               
    <h1>Suscribete a nuestro Sitio Web</h1>        
    <p>Introduce tu nombre y tu email para suscribirte a 
        nuestro sitio web y recibir notificaciones.</p>    
    
    <p><i>${message}</i></p>
    
    <form action="emailList" method="post">
        <input type="hidden" name="action" value="add">        
        <label class="pad_top">Nombre:</label>
        <input type="text" name="firstName" value="${user.firstName}" required><br>
        <label class="pad_top">Apellidos:</label>
        <input type="text" name="lastName" value="${user.lastName}" required><br>        
        <label class="pad_top">Email:</label>
        <input type="email" name="email" value="${user.email}" required><br>        
        <label>&nbsp;</label>
        <input type="submit" value="SUSCRIBIRSE" class="margin_left">
    </form>
        
</body>
</html>