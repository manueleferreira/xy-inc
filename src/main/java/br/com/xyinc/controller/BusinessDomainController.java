package br.com.xyinc.controller;

import br.com.xyinc.model.BusinessDomain;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by manuele on 18/10/17.
 */
@RestController
@RequestMapping("/{businessDomainId}")
public class BusinessDomainController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET)
    public BusinessDomain readBusinessDomain(@PathVariable String businessDomainId) {
        return new BusinessDomain(counter.incrementAndGet(),
                String.format(template, businessDomainId));
    }

}
