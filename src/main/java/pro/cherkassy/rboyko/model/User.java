package pro.cherkassy.rboyko.model;

import org.springframework.web.socket.WebSocketSession;
import pro.cherkassy.rboyko.enums.Role;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rboyko on 09.03.17.
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    protected Integer id;
    @Column(name = "full_name")
    protected String fullName;
    @Column(name="login")
    protected String login;
    @Column(name="password")
    protected String password;
    @Column(name="email")
    protected String email;
    @Column(name = "extension")
    protected String extension;
    @Column(name="role")
    @Enumerated(EnumType.STRING)
    protected Role role;

    public User() {
    }

    public User(String fullName, String login, String password, String email, String extension, Role role) {
        this.fullName = fullName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.extension = extension;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

