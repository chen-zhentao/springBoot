package com.czt.mapper;

import com.czt.entity.Dept;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptMapper {
    /**
     * 查询所有部门
     * @return
     */
    @Select("select * from tb_dept")
    List<Dept> deptAlls();
}