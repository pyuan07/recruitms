package com.recruit.recruitms.repository;

import com.recruit.recruitms.entity.Application;
import com.recruit.recruitms.entity.Employer;
import com.recruit.recruitms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, User> {


}
