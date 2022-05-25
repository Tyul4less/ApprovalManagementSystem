
package com.approval.test.hr.serviceFacade;

import com.approval.test.hr.dto.ApprovalDTO;
import com.approval.test.hr.dto.ApprovalSignDTO;
import com.approval.test.hr.dto.EmpDTO;
import com.approval.test.hr.mapper.ApprovalMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ApprovalServiceFacade {

    private final ApprovalMapper approvalMapper;

    public void signUp (ApprovalSignDTO approvalSignDTO){

        /* 문서 등록 */
        approvalMapper.insertDocumentContent(approvalSignDTO);

        /* 이미 등록되어 있는것이라면 지움 */
        List<ApprovalSignDTO> executives = approvalSignDTO.getExecutives();
        for(ApprovalSignDTO key : executives){
            log.info("approvalSignDTO.getDate() = {}", key.getEmpNumber());
        }

        approvalMapper.insertApprovalSign(approvalSignDTO);

    }
    public List<ApprovalSignDTO> getWaitingDocumentList(ApprovalSignDTO approvalSignDTO){
        return approvalMapper.selectWaitingDocumentList(approvalSignDTO);
    }
    public List<ApprovalDTO> getApprovalSigns(ApprovalDTO approvalDTO){
        return approvalMapper.selectApprovalSigns(approvalDTO);
    }
    public void approvalSign(ApprovalSignDTO approvalSignDTO){
        if("ST03".equals(approvalSignDTO.getStatus())) { //상수로 바꿔야함
            approvalMapper.updateApprovalSign(approvalSignDTO);
            if (approvalSignDTO.getSequence() == approvalSignDTO.getTotal()) {
                approvalMapper.updateFinalApprovalSign(approvalSignDTO);
            }

        }else if("ST04".equals(approvalSignDTO.getStatus())){
            approvalMapper.updateApprovalSign(approvalSignDTO);
            approvalMapper.updateFinalApprovalSign(approvalSignDTO);
        }
    }
    public List<ApprovalDTO> getApplicationDocumentList(EmpDTO empDTO){
        return approvalMapper.selectDocumentList(empDTO);
    }
    public ApprovalSignDTO getDocumentInfo(ApprovalDTO approvalDTO){
        ApprovalSignDTO approvalSignDTO = approvalMapper.selectDocumentInfo(approvalDTO);
        approvalSignDTO.setExecutives(approvalMapper.selectApprovalExecutives(approvalDTO));
        return approvalSignDTO;
    }
    public void documentDrop(String documentNumber){
        approvalMapper.deleteDocument(documentNumber);
    }
    public List<ApprovalDTO> getTmpDocumentList(EmpDTO empDTO){
        return approvalMapper.selectTmpDocumentList(empDTO);
    }
    public void editDocumentContent(ApprovalSignDTO approvalSignDTO){
        approvalMapper.updateDocumentContent(approvalSignDTO);
    }

}

