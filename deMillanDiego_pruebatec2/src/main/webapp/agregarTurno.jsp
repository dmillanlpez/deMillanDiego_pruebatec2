
<%@ include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Turno</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <main class="main-container">
        <section class="form-section">
            <h2 class="titulo" >Agregar Turno</h2>
            <form action="TurnoSV" method="post" class="form">
                <div class="form-group">
                    <label for="id-ciudadano">ID Ciudadano:</label>
                    <input type="text" name="id-ciudadano" id="id-ciudadano" class="form-control" required>
                </div>

                <div class="form-group">
                    <label for="descripcionTram">Descripción del Trámite:</label>
                    <input type="text" name="descripcionTram" id="descripcionTram" class="form-control" required>
                </div>

                <div class="form-group">
                    <label for="estado">Estado:</label>
                    <select name="estado" id="estado" class="form-control" required>
                        <option value="En espera">En espera</option>
                        <option value="Ya atendido">Ya atendido</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="fechaTurno">Fecha del Turno:</label>
                    <input type="date" name="fechaTurno" id="fechaTurno" class="form-control" required>
                </div>

                <button type="submit" class="btn">Agregar</button>
            </form>
        </section>
    </main>
</body>
</html>
