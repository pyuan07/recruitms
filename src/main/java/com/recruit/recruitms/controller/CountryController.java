package com.recruit.recruitms.controller;

import com.recruit.recruitms.entity.Country;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.service.impl.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/country")
@CrossOrigin
public class CountryController {

    private final CountryService _countryService;

    @Autowired
    public CountryController(CountryService service) {
        this._countryService = service;
    }

    @GetMapping
    public ResponseEntity<List<Country>> getAll(){
        return ResponseEntity.ok(_countryService.getAll());
    }

    @GetMapping(path="/iso/{iso}")
    public ResponseEntity<Country> getCountryByIso(@PathVariable("iso") String iso){
        return ResponseEntity.ok(_countryService.getByIso(iso));
    }

    @GetMapping(path="/iso/{code}")
    public ResponseEntity<Country> getCountryByCode(@PathVariable("code") String code){
        return ResponseEntity.ok(_countryService.getByCode(code));
    }

}
