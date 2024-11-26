package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logouts")
public class Logout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener la sesión actual si existe
        HttpSession session = req.getSession(false);

        if (session != null) {
            // Invalida la sesión existente
            session.invalidate();
        }

        // Agregar un mensaje en la URL como parámetro (opcional)
        resp.sendRedirect(req.getContextPath() + "/login.jsp?logoutMessage=Has cerrado sesión exitosamente.");
    }
}

