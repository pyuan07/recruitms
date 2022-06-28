package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.constant.Constants;
import com.recruit.recruitms.entity.Staff;
import com.recruit.recruitms.entity.User;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.exception.ApiRequestException;
import com.recruit.recruitms.repository.StaffRepository;
import com.recruit.recruitms.service.ICrudService;
import com.recruit.recruitms.service.IStaffService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StaffService implements ICrudService<Staff, UUID>, IStaffService {
    private final StaffRepository repo;
    private final UserService userService;

    public Staff create(Staff staff) {
        User user = userService.create(staff.getUser());
        staff.setUserId(user.getUserId());
        return repo.save(staff);
    }

    public List<Staff> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Staff> getByObjectState(Enum.ObjectState objectState) {
        return repo.findAll().stream().filter(x->x.getUser().getObjectState() == objectState).toList();
    }

    public Staff getById(UUID id){
        return repo.findById(userService.getById(id)).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
    }

    public Staff update(Staff staff){
        return repo.save(staff);
    }

    public boolean delete(UUID id) {
        if(! repo.existsById(userService.getById(id))) throw new ApiRequestException(Constants.NOT_FOUND + " id: "+id);
        //repo.deleteById(id);
        this.terminate(id);
        return true;
    }

    public boolean terminate(UUID id){
        Staff staff = repo.findById(userService.getById(id)).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        staff.getUser().setObjectState(Enum.ObjectState.TERMINATED);
        repo.save(staff);
        return true;
    }

    public boolean activate(UUID id){
        Staff staff = repo.findById(userService.getById(id)).orElseThrow(()-> new ApiRequestException(Constants.NOT_FOUND + " id: "+ id));
        staff.getUser().setObjectState(Enum.ObjectState.ACTIVE);
        repo.save(staff);
        return true;
    }
}