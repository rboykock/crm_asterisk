package pro.cherkassy.rboyko.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by rboyko on 16.03.17.
 */
@Entity
@Table(name = "notes")
public class Note implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "subject")
    private String subject;
    @Column(name = "description")
    private String description;
    @Column(name="date")
    private Long date;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "customer_id")
    private Integer customerId;

    public Note() {

    }

    public Note(String subject, String description, Long date, String userName, Integer customerId) {
        this.subject = subject;
        this.description = description;
        this.date = date;
        this.userName = userName;
        this.customerId=customerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getUser_name() {
        return userName;
    }

    public void setUser_name(String user_name) {
        this.userName = user_name;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

}

