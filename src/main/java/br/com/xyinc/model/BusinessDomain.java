package br.com.xyinc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by manuele on 18/10/17.
 */
@Entity
public class BusinessDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
