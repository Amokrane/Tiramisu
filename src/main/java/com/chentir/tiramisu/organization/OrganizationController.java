package com.chentir.tiramisu.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class OrganizationController {

    @Autowired OrganizationRepository organizationRepository;

    @RequestMapping("/organizations")
    Collection<Organization> organizations() {
        return organizationRepository.findAll();
    }
}
