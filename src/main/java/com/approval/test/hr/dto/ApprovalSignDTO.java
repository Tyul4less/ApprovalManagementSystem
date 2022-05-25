package com.approval.test.hr.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class ApprovalSignDTO extends ApprovalDTO{

    String
        empName,
        opinion;

    List<ApprovalSignDTO> executives;
}
