package br.com.xyinc.controller;

import br.com.xyinc.service.BusinessDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by manuele on 18/10/17.
 */
@RestController
@RequestMapping("/businessDomain")
public class BusinessDomainController {

    @Autowired
    private BusinessDomainService businessDomainService;

}
