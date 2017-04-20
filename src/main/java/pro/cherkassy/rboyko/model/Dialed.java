package pro.cherkassy.rboyko.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rboyko on 11.04.17.
 */
@Entity
@Table(name="dialedlist")
public class Dialed implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "organization_name")
    private String organizationName;
    @Column(name = "contact_person")
    private String contactPerson;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "time_to_call")
    private Long timeToCall;
    @Column(name = "company_name")
    private String companyName;

    public Dialed() {
    }

    public Dialed(String organizationName, String contactPerson, String phoneNumber, Long timeToCall, String companyName) {
        this.organizationName = organizationName;
        this.contactPerson = contactPerson;
        this.phoneNumber = phoneNumber;
        this.timeToCall = timeToCall;
        this.companyName = companyName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getTimeToCall() {
        return timeToCall;
    }

    public void setTimeToCall(Long timeToCall) {
        this.timeToCall = timeToCall;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
