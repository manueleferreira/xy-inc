package br.com.xyinc.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by manuele on 18/10/17.
 */
@Entity
public class BusinessDomainAtt implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String name;

    private String type;

    private BusinessDomain businessDomain;

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(nullable = false, name = "BUSINESS_DOMAIN_ID")
    public BusinessDomain getBusinessDomain() {
        return businessDomain;
    }

    @Column(nullable = false)
    public String getType() {
        return type;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBusinessDomain(BusinessDomain businessDomain) {
        this.businessDomain = businessDomain;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(long id) {
        this.id = id;
    }
}
