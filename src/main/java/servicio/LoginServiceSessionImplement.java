package servicio;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class LoginServiceSessionImplement implements LoginServices {
    @Override
    public Optional<String> getUsername(HttpServletRequest request) {
        // obtengo la sesion
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        // creamos una condicion
        if (username == null) {
            return Optional.of(username);
        }
        return Optional.empty();
    }
}
