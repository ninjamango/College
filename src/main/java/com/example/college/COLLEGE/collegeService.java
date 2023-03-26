package com.example.college.COLLEGE;


import org.springframework.beans.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.college.COLLEGE.collegeRepository;

@Service
public class collegeService {


    private collegeRepository collegeRepositoryobj;
    public collegeService(collegeRepository collegeRepositoryobj) {

        this.collegeRepositoryobj = collegeRepositoryobj;

    }

    public  collegeModel insertCollege(collegeModel college) {

        collegeEntity collegeEntityObj = new collegeEntity();

        BeanUtils.copyProperties(college,collegeEntityObj);

        collegeRepositoryobj.save(collegeEntityObj);

        return college;
    }



}
