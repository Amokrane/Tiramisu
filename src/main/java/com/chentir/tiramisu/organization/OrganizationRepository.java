package com.chentir.tiramisu.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Collection;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Collection<Organization> findByOrganizationName(@NonNull String organizationName);
}
