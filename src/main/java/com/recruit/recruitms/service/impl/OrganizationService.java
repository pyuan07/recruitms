package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.entity.Organization;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.OrganizationRepository;
import com.recruit.recruitms.service.IOrganizationService;
import com.recruit.recruitms.service.ICrudService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrganizationService implements ICrudService<Organization, Long>, IOrganizationService {
    private final OrganizationRepository repo;

    @Override
    public Organization create(Organization organization) {

        return repo.save(organization);
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
    public Organization getById(Long id){
        return repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
    }

    @Override
    public Organization update(Organization organization){
        return repo.save(organization);
    }

    @Override
    public boolean delete(Long id) {
        if(! repo.existsById(id)) throw new ApiRequestException(Constants.NOT_FOUND + " id: "+id);
        //repo.deleteById(id);
        this.terminate(id);
        return true;
    }

    @Override
    public boolean terminate(Long id){
        Organization organization = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        organization.setObjectState(Enum.ObjectState.TERMINATED);
        repo.save(organization);
        return true;
    }

    @Override
    public boolean activate(Long id){
        Organization organization = repo.findById(id).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        organization.setObjectState(Enum.ObjectState.ACTIVE);
        repo.save(organization);
        return true;
    }
}

