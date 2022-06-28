package com.recruit.recruitms.repository;

import com.recruit.recruitms.entity.Resume;
import com.recruit.recruitms.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {


}
