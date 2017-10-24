package br.com.xyinc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by manuele on 18/10/17.
 */
@Entity
public class BusinessDomainInstance  implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private BusinessDomain businessDomain;

    private List<BusinessDomainInstanceAtt> businessDomainInstanceAtts;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false, name = "BUSINESS_DOMAIN_ID")
    public BusinessDomain getBusinessDomain() {
        return businessDomain;
    }

    @JsonManagedReference
    @JsonProperty("attributes")
    @OneToMany(mappedBy = "businessDomainInstance", cascade = CascadeType.ALL)
    public List<BusinessDomainInstanceAtt> getBusinessDomainInstanceAtts() {
        return businessDomainInstanceAtts;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setBusinessDomain(BusinessDomain businessDomain) {
        this.businessDomain = businessDomain;
    }

    public void setBusinessDomainInstanceAtts(List<BusinessDomainInstanceAtt> businessDomainInstanceAtts) {
        this.businessDomainInstanceAtts = businessDomainInstanceAtts;
    }

    public void setId(long id) {
        this.id = id;
    }
}
