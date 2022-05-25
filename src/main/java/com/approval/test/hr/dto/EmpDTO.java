package com.approval.test.hr.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class EmpDTO {
    String
        empName,
        empId,
        empPw,

        deptCode,
        deptName,

        positionCode,
        positionName,

        status,
        statusName;

    int empNumber;

    LocalDate joinDate, withdrawDate;
}
