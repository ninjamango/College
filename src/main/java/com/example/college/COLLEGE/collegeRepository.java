package com.example.college.COLLEGE;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface collegeRepository extends JpaRepository<collegeEntity,Long> {




}
