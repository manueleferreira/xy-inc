package br.com.xyinc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by manuele on 18/10/17.
 */
@Entity
public class BusinessDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String name;

    private List<BusinessDomainAtt> businessDomainAtts;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    @JsonProperty("attributes")
    @OneToMany(mappedBy = "businessDomain", cascade = CascadeType.ALL)
    public List<BusinessDomainAtt> getBusinessDomainAtts() {
        return businessDomainAtts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBusinessDomainAtts(List<BusinessDomainAtt> businessDomainAtts) {
        this.businessDomainAtts = businessDomainAtts;
    }
}
