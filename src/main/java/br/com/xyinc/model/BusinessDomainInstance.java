package br.com.xyinc.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by manuele on 18/10/17.
 */
@Entity
public class BusinessDomainInstance  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "BUSINESS_DOMAIN_ID")
    private BusinessDomain businessDomain;

    public BusinessDomain getBusinessDomain() {
        return businessDomain;
    }

    public void setBusinessDomain(BusinessDomain businessDomain) {
        this.businessDomain = businessDomain;
    }

    public Long getId() {
        return id;
    }

}
