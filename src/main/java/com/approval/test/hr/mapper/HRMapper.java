package com.approval.test.hr.mapper;

import com.approval.test.hr.dto.EmpDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HRMapper{

    EmpDTO selectEmpInfo (EmpDTO param);
    void insertEmpInfo (EmpDTO param);
    List<EmpDTO> selectExecutiveEmp ();
    List<EmpDTO> selectAllEmp (EmpDTO empDTO);
    void updateEmpInfo (EmpDTO empDTO);
    void withdrawEmp (EmpDTO empDTO);
}