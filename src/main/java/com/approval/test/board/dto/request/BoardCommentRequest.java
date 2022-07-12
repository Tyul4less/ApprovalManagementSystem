package com.approval.test.board.dto.request;

import lombok.Getter;
import org.apache.ibatis.type.Alias;

@Getter
@Alias("BoardCommentRequest")
public class BoardCommentRequest {

    private int seq;
    private String memberIndex;
    private String contents;
}
