package com.chentir.tiramisu.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.stereotype.Component;

@Component
public class OrganizationCommandLineRunner implements CommandLineRunner {

    @Autowired OrganizationRepository organizationRepository;

    @Override
    public void run(String... args) throws Exception {
        organizationRepository.findAll().forEach(organization -> {
            System.out.println(organization);
        });
    }
}
