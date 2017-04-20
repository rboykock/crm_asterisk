package pro.cherkassy.rboyko.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rboyko on 11.04.17.
 */
@Entity
@Table(name = "diallist")
public class Dial implements Serializable{
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
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "campaign_id")
    private Integer campaignId;

    public Dial() {
    }

    public Dial(String organizationName, String contactPerson, String phoneNumber, Integer customerId, Integer campaignId) {
        this.organizationName = organizationName;
        this.contactPerson = contactPerson;
        this.phoneNumber = phoneNumber;
        this.customerId = customerId;
        this.campaignId = campaignId;
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }
}

