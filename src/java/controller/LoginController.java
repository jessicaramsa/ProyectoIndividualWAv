package controller;

import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.GestorBD;
import model.Usuario;
import utils.SessionUtils;

/**
 *
 * @author jessicaramsa
 */
@ManagedBean
@SessionScoped
public class LoginController {
    private BigInteger id;
    private String nombre;
    private String apellidos;
    private String rol;
    private String password;
    private String username;
    private String email;
    private GestorBD gestorBD;

    public LoginController() {
        gestorBD = new GestorBD();
    }
    
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GestorBD getGestorBD() {
        return gestorBD;
    }

    public void setGestorBD(GestorBD gestorBD) {
        this.gestorBD = gestorBD;
    }
    
    public String validarLogin() {
        GestorBD gestorBD = new GestorBD();
        boolean valid = gestorBD.localizaUsuario(username, password);
        if (valid) {
            rol = gestorBD.localizaRolUsuario(username);
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", username);
            session.setAttribute("rol", rol);
            return "videojuegos";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_WARN,
                            "Usuario o contraseña incorrectos",
                            "Por favor introduce el username y cotraseña"
                    )
            );
            return "login";
        }
    }
    
    public boolean validarRol(String rol) {
        return true;
    }
    
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }
}
