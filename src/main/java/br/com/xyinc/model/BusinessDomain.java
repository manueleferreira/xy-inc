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

    @Id
    @GeneratedValue
    private final long id;

    @Column(nullable = false)
    private final String content;

    public BusinessDomain(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return getContent();
    }
}
