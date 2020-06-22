package com.czt.controller;

import com.czt.entity.Dept;
import com.czt.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/list")
    public List<Dept> deptAlls(){
        return  deptService.deptAlls();
    }

}
