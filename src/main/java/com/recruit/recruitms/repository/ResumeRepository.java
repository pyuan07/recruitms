package com.recruit.recruitms.repository;

import com.recruit.recruitms.entity.Resume;
import com.recruit.recruitms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, UUID> {


}
