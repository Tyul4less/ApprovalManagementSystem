package com.approval.test.board.dto.response;

import lombok.Getter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@ToString
@Getter
@Alias("BoardCommentResponse")
public class BoardCommentResponse {

    private int seq;
    private int commentSeq;
    private String memberName;
    private String memberIndex;
    private String contents;
    private Timestamp regDT;
    private Timestamp updDT;
}
