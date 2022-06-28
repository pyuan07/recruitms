package com.recruit.recruitms.repository;

import com.recruit.recruitms.entity.Organization;
import com.recruit.recruitms.entity.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Long> {


}
