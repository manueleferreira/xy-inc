package br.com.xyinc.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by manuele on 18/10/17.
 */
@Entity
public class BusinessDomainInstanceAtt implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String attValue;

    @ManyToOne
    @JoinColumn(nullable = false, name = "BUSINESS_DOMAIN_ID")
    private BusinessDomain businessDomain;

    @ManyToOne
    @JoinColumn(nullable = false, name = "BUSINESS_DOMAIN_INSTANCE_ID")
    private BusinessDomainInstance businessDomainInstance;

    @ManyToOne
    @JoinColumn(nullable = false, name = "BUSINESS_DOMAIN_ATT_ID")
    private BusinessDomainInstanceAtt businessDomainInstanceAtt;

    public BusinessDomain getBusinessDomain() {
        return businessDomain;
    }

    public BusinessDomainInstance getBusinessDomainInstance() {
        return businessDomainInstance;
    }

    public BusinessDomainInstanceAtt getBusinessDomainInstanceAtt() {
        return businessDomainInstanceAtt;
    }

    public String getAttValue() {
        return attValue;
    }

    public void setBusinessDomain(BusinessDomain businessDomain) {
        this.businessDomain = businessDomain;
    }

    public void setAttValue(String attValue) {
        this.attValue = attValue;
    }

    public void setBusinessDomainInstance(BusinessDomainInstance businessDomainInstance) {
        this.businessDomainInstance = businessDomainInstance;
    }


    public void setBusinessDomainInstanceAtt(BusinessDomainInstanceAtt businessDomainInstanceAtt) {
        this.businessDomainInstanceAtt = businessDomainInstanceAtt;
    }

    public Long getId() {
        return id;
    }
}
