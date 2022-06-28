package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.entity.Country;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.CountryRepository;
import com.recruit.recruitms.service.ICountryService;
import com.recruit.recruitms.service.ICrudService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryService implements ICountryService {
    private final CountryRepository repo;

    @Override
    public List<Country> getAll() {
        return repo.findAll();
    }

    @Override
    public Country getByIso(String iso){
        return repo.findById(iso).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " iso: "+ iso));
    }

    @Override
    public Country getByCode(String code) {
        return repo.findByCode(code).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " code: "+ code));
    }


}
