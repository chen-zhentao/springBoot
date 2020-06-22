package com.czt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class User {
    private Integer userid;

    private String username;

    private String name;

    private Integer deptid;

    private String email;

    private String phonenum;

    private Integer status;

    private String password;

    private String salt;

    private String deptname;
}
