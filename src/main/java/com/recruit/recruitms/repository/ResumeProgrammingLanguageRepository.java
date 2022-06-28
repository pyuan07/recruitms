package com.recruit.recruitms.repository;

import com.recruit.recruitms.entity.ResumeProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeProgrammingLanguageRepository extends JpaRepository<ResumeProgrammingLanguage, Long> {


}
