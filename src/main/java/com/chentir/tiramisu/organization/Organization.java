package com.chentir.tiramisu.organization;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String organizationName;

    private String url;


    public Organization(String organizationName, String url) {
        super();
        this.organizationName = organizationName;
        this.url = url;
    }

    public Organization() {
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", organizationName='" + organizationName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

}