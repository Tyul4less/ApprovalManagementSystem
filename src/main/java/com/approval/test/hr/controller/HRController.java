package com.approval.test.hr.controller;
import com.approval.test.hr.dto.EmpDTO;
import com.approval.test.hr.serviceFacade.HRServiceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class HRController {

    private final HRServiceFacade hrServiceFacade;

    @PostMapping("/findEmpInfo")
    public EmpDTO findHRInfo(@RequestBody EmpDTO param){
        EmpDTO empDto = hrServiceFacade.findHRInfo(param);
        System.out.println("empDto = " + empDto);
        return empDto;
    }

    @PostMapping("/registEmp")
    public void registEmp(@RequestBody EmpDTO param){
        System.out.println("param = " + param);
        hrServiceFacade.registEmp(param);
    }

    @PostMapping("/findExecutive")
    public List<EmpDTO> findExecutive(){
        return hrServiceFacade.findExecutive();
    }

    @PostMapping("/findAllEmp")
    public List<EmpDTO> findAllEmp(@RequestBody(required = false) EmpDTO empDTO){
        return hrServiceFacade.findAllEmp(empDTO);
    }

    @PostMapping("/editEmpInfo")
    public void editEmpInfo(@RequestBody EmpDTO empDTO){
        hrServiceFacade.editEmpInfo(empDTO);
    }

    @PostMapping("/withdrawEmp")
    public void withdrawEmp(@RequestBody EmpDTO empDTO){
        hrServiceFacade.withdrawEmp(empDTO);
    }
}