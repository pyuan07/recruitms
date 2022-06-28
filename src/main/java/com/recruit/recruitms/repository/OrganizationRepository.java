package com.recruit.recruitms.repository;

import com.recruit.recruitms.entity.Image;
import com.recruit.recruitms.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {


}
