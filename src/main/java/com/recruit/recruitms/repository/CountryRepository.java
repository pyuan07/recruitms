package com.recruit.recruitms.repository;

import com.recruit.recruitms.entity.Category;
import com.recruit.recruitms.entity.Country;
import com.recruit.recruitms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    Optional<Country> findByCode(String code);
}
