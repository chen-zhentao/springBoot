package com.czt.service;

import com.czt.entity.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DeptService {

    /**
     * 查询所有部门
     * @return
     */
    List<Dept> deptAlls();
}
