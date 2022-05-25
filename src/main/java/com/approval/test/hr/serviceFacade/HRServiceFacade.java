package com.approval.test.hr.serviceFacade;

import com.approval.test.hr.mapper.HRMapper;
import com.approval.test.hr.dto.EmpDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class HRServiceFacade {

    private final HRMapper hrMapper;

    public EmpDTO findHRInfo(EmpDTO param) {
        return hrMapper.selectEmpInfo(param);
    }

    public void registEmp(EmpDTO param) {
        hrMapper.insertEmpInfo(param);
    }

    public List<EmpDTO> findExecutive() {
        return hrMapper.selectExecutiveEmp();
    }

    public List<EmpDTO> findAllEmp(EmpDTO empDTO) {
        return hrMapper.selectAllEmp(empDTO);
    }

    public void editEmpInfo(EmpDTO empDTO) {
        hrMapper.updateEmpInfo(empDTO);
    }

    public void withdrawEmp(EmpDTO empDTO) {
        hrMapper.withdrawEmp(empDTO);
    }
}