package com.czt.service.impl;

import com.czt.entity.Dept;
import com.czt.mapper.DeptMapper;
import com.czt.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> deptAlls() {
        return deptMapper.deptAlls();
    }
}
