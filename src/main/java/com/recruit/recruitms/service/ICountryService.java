package com.recruit.recruitms.service;
import com.recruit.recruitms.entity.Country;
import java.util.List;

public interface ICountryService {
    List<Country> getAll();
    Country getByIso(String iso);

    Country getByCode(String code);

}
