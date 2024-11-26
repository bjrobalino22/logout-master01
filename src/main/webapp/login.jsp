<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <!-- Enlace a la CDN de Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

  <!-- Estilos personalizados -->
  <style>
    body {
      background-color: #f0f2f5; /* Color de fondo personalizado */
    }

    .card {
      border-radius: 15px;
      border: none;
    }

    .card-title {
      color: #007bff; /* Cambiar color del título */
      font-weight: bold;
    }

    .btn-primary {
      background-color: #28a745; /* Cambiar color del botón */
      border-color: #28a745;
    }

    .btn-primary:hover {
      background-color: #218838;
      border-color: #1e7e34;
    }

    .form-control {
      border-radius: 10px;
    }

    .form-label {
      font-weight: bold;
    }
  </style>
</head>
<body class="d-flex justify-content-center align-items-center vh-100">

<div class="card shadow-sm" style="width: 100%; max-width: 400px;">
  <div class="card-body">
    <h2 class="card-title text-center mb-4">Login</h2>
    <!-- El formulario apunta al servlet de autenticación -->
    <form id="loginForm" action="loginservlet" method="POST">
      <div class="mb-3">
        <label for="username" class="form-label">Usuario</label>
        <input type="text" id="username" name="username" class="form-control" required>
      </div>
      <div class="mb-3">
        <label for="password" class="form-label">Contraseña</label>
        <input type="password" id="password" name="password" class="form-control" required>
      </div>
      <button type="submit" class="btn btn-primary w-100">Ingresar</button>
      <%-- Mensaje de error dinámico, en caso de fallo en el servlet --%>
      <c:if test="${not empty errorMessage}">
        <div class="text-danger mt-3 text-center">${errorMessage}</div>
      </c:if>
    </form>
  </div>
</div>

<!-- Scripts de Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
