package com.recruit.recruitms.repository;

import com.recruit.recruitms.entity.Organization;
import com.recruit.recruitms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, UUID> {

    Optional<Organization> findByEmail(String email);
    Optional<Organization> findByName(String name);

}
