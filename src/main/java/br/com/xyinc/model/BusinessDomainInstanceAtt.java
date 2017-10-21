package br.com.xyinc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by manuele on 18/10/17.
 */
@Entity
public class BusinessDomainInstanceAtt implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;

    private String attValue;

    private BusinessDomainInstance businessDomainInstance;

    private BusinessDomainAtt businessDomainAtt;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false, name = "BUSINESS_DOMAIN_INSTANCE_ID")
    public BusinessDomainInstance getBusinessDomainInstance() {
        return businessDomainInstance;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false, name = "BUSINESS_DOMAIN_ATT_ID")
    public BusinessDomainAtt getbusinessDomainAtt() {
        return businessDomainAtt;
    }

    @JsonIgnore
    @Column(nullable = false)
    public String getAttValue() {
        return attValue;
    }

    @Transient
    @JsonProperty("att")
    public String getAttNameAndValue() {
        String attName = getbusinessDomainAtt().getName();
        return String.format("%s : %s", attName, getAttValue());
    }

    @JsonIgnore
    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setAttValue(String attValue) {
        this.attValue = attValue;
    }

    public void setBusinessDomainInstance(BusinessDomainInstance businessDomainInstance) {
        this.businessDomainInstance = businessDomainInstance;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBusinessDomainAtt(BusinessDomainAtt businessDomainAtt) {
        this.businessDomainAtt = businessDomainAtt;
    }
}
