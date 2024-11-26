package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import servicio.LoginServiceImplement;
import servicio.LoginServices;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet({"/loginservlet", "/login.html"})
public class LoginServlet extends HttpServlet {
    private static final String USERNAME = "admin1";
    private static final String PASSWORD = "12345";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginServices auth = new LoginServiceImplement();
        Optional<String> usernameOptional = auth.getUsername(req);

        // Verifica si el usuario ya ha iniciado sesión
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Bienvenido</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Bienvenido " + session.getAttribute("username") + ", ya iniciaste sesión</h1>");
            out.println("<a href='" + req.getContextPath() + "/index.html'>Volver al inicio</a>");
            out.println("<a href='" + req.getContextPath() + "/logouts'>Cerrar Sesión</a>");
            out.println("</body>");
            out.println("</html>");
        } else {
            // Si no hay sesión, redirige al formulario de inicio de sesión
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            // Crear sesión y guardar usuario
            HttpSession session = req.getSession();
            session.setAttribute("username", username);

            // Redirigir a la página de inicio
            resp.sendRedirect(req.getContextPath() + "/index.html");
        } else {
            // Si las credenciales son incorrectas, vuelve al login con un mensaje de error
            req.setAttribute("errorMessage", "Usuario o contraseña inválidos.");
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
