package com.approval.test.hr.controller;

import com.approval.test.hr.dto.ApprovalSignDTO;
import com.approval.test.hr.dto.EmpDTO;
import com.approval.test.hr.serviceFacade.ApprovalServiceFacade;
import com.approval.test.hr.dto.ApprovalDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
@CrossOrigin("*")
@Slf4j
public class ApprovalController {

    private final ApprovalServiceFacade approvalServiceFacade;

    /* 승인, 임시저장을 하기 위한 */
    @PostMapping("/signUp")
    public void findHRInfo(@RequestBody ApprovalSignDTO approvalSignDTO){
        approvalServiceFacade.signUp(approvalSignDTO);
    }

    /* 승인해야 할 문서 목록*/
    @PostMapping("/getWaitingDocumentList")
    public List<ApprovalSignDTO> getWaitingDocumentList(@RequestBody ApprovalSignDTO approvalSignDTO ){
        return approvalServiceFacade.getWaitingDocumentList(approvalSignDTO);
    }

    /* 승인 문서에 대한 임직원 */
    @PostMapping("/getApprovalSigns")
    public List<ApprovalDTO> getApprovalSigns(@RequestBody ApprovalDTO empDTO){
        return approvalServiceFacade.getApprovalSigns(empDTO);
    }

    /* 결재 버튼 */
    @PostMapping("/approvalSign")
    public void approvalSign(@RequestBody ApprovalSignDTO approvalSignDTO){
        approvalServiceFacade.approvalSign(approvalSignDTO);
    }
    /* 사용자 문서 목록 조회 */
    @PostMapping("/getApplicationDocumentList")
    public List<ApprovalDTO> getApplicationDocumentList(@RequestBody EmpDTO empDTO){
        return approvalServiceFacade.getApplicationDocumentList(empDTO);
    }
    /* 사용자 문서 목록에서 조회할 문서 클릭시 */
    @PostMapping("/getDocumentInfo")
    public ApprovalSignDTO getDocumentInfo(@RequestBody ApprovalDTO approvalDTO){
        return approvalServiceFacade.getDocumentInfo(approvalDTO);
    }

    @DeleteMapping("/documentDrop")
    public void documentDrop(@RequestParam String documentNumber){
        approvalServiceFacade.documentDrop(documentNumber);
    }

    @PostMapping("/getTmpDocumentList")
    public List<ApprovalDTO> getTmpDocumentList(@RequestBody EmpDTO empDTO){
        return approvalServiceFacade.getTmpDocumentList(empDTO);
    }

    @PostMapping("/editDocumentContent")
    public void editDocumentContent(@RequestBody ApprovalSignDTO approvalSignDTO){
        approvalServiceFacade.editDocumentContent(approvalSignDTO);
    }
}
