package com.recruit.recruitms.repository;

import com.recruit.recruitms.entity.Application;
import com.recruit.recruitms.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {


}
