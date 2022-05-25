package com.approval.test.hr.mapper;

import com.approval.test.hr.dto.ApprovalDTO;
import com.approval.test.hr.dto.ApprovalSignDTO;
import com.approval.test.hr.dto.EmpDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ApprovalMapper {

    void insertDocumentContent(ApprovalDTO approvalDTO);
    void insertApprovalSign(ApprovalDTO approvalSignDTO);
    void deleteApprovalExecutive(ApprovalDTO approvalDTO);

    List<ApprovalSignDTO> selectWaitingDocumentList(ApprovalSignDTO approvalSignDTO);
    List<ApprovalDTO> selectApprovalSigns(ApprovalDTO approvalDTO);



    void updateApprovalSign(ApprovalDTO approvalDTO);
    void updateFinalApprovalSign(ApprovalDTO approvalDTO);

    List<ApprovalDTO> selectDocumentList(EmpDTO empDTO);
    ApprovalSignDTO selectDocumentInfo(ApprovalDTO approvalDTO);
    List<ApprovalSignDTO> selectApprovalExecutives(ApprovalDTO approvalDTO);
    void deleteDocument(String documentNumber);
    List<ApprovalDTO> selectTmpDocumentList(EmpDTO empDTO);
    void updateDocumentContent(ApprovalSignDTO approvalSignDTO);

}
