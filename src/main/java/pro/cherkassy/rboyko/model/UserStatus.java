package pro.cherkassy.rboyko.model;

import pro.cherkassy.rboyko.enums.Status;

import javax.persistence.*;

/**
 * Created by rboyko on 12.04.17.
 */
@Entity
@Table(name="user_status")
public class UserStatus {
    @Id
    @Column(name = "extension")
    private String extension;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public UserStatus() {
    }

    public UserStatus(String extension, Status status) {
        this.extension = extension;
        this.status = status;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
