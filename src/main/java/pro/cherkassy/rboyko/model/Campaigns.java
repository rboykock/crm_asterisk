package pro.cherkassy.rboyko.model;

import pro.cherkassy.rboyko.enums.Status;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sergiy on 03.04.2017.
 */

@Entity
@Table(name = "campaigns")
public class Campaigns implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;
    @Column(name = "name")
    protected String name;
    @Column(name = "date_create")
    protected Long date_create;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    protected Status status;

    public Campaigns() {
    }

    public Campaigns(String name, long date_create, Status status) {
        this.name = name;
        this.date_create = date_create;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDate_create() {
        return date_create;
    }

    public void setDate_create(long date_create) {
        this.date_create = date_create;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
