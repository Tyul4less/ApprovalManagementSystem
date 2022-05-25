package com.approval.test.hr.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ApprovalDTO extends EmpDTO{

    String
        title,
        content,
        type,
        typeName,
        status,
        statusName;

    int
        documentNumber,
        sequence,
        total;

    LocalDateTime date;

}
