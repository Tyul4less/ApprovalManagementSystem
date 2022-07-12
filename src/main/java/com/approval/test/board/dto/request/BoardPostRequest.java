package com.approval.test.board.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Setter
@Getter
@Alias("BoardPostRequest")
public class BoardPostRequest extends BoardSeqRequest {

    private Integer seq;
    private String memberIndex;
    private String memberName;
    private String title;
    private String contents;
    private Timestamp regDT;
    private Timestamp updDT;
}
