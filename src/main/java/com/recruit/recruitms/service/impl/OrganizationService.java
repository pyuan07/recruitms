package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.dto.request.CreateOrganizationRequest;
import com.recruit.recruitms.entity.Organization;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.OrganizationRepository;
import com.recruit.recruitms.service.IOrganizationService;
import com.recruit.recruitms.service.ICrudService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrganizationService implements ICrudService<Organization, UUID>, IOrganizationService {
    private final OrganizationRepository repo;
    private final CountryService _countryService;
    private final UserService _userService;

    @Override
    public Organization create(Organization organization) {

        return repo.save(organization);
    }

    @Override
    public Organization createOrganizationByRequest(CreateOrganizationRequest request) {
        Organization organization =
                new Organization(
                        request.getName(),
                        request.getDescription(),
                        request.getAddress(),
                        _countryService.getByIso(request.getCountryISO()),
                        request.getEmail(),
                        request.getPhone(),
                        request.getWebsite(),
                        _userService.getById(request.getOwner()),
                        request.getObjectState()
                );
        return this.create(organization);
    }

    @Override
    public List<Organization> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Organization> getByObjectState(Enum.ObjectState objectState) {
        return repo.findAll().stream().filter(x->x.getObjectState() == objectState).toList();
    }

    @Override
    public Organization getById(UUID id){
        return repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
    }

    @Override
    public Organization update(Organization organization){
        return repo.save(organization);
    }

    @Override
    public boolean delete(UUID id) {
        if(! repo.existsById(id)) throw new ApiRequestException(Constants.NOT_FOUND + " id: "+id);
        //repo.deleteById(id);
        this.terminate(id);
        return true;
    }

    @Override
    public boolean terminate(UUID id){
        Organization organization = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        organization.setObjectState(Enum.ObjectState.TERMINATED);
        repo.save(organization);
        return true;
    }

    @Override
    public boolean activate(UUID id){
        Organization organization = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        organization.setObjectState(Enum.ObjectState.ACTIVE);
        repo.save(organization);
        return true;
    }
}

