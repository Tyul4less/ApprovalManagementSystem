package com.approval.test.board.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@Alias("EditCommentRequest")
public class EditCommentRequest {

    private int seq;
    private int commentSeq;
    private String contents;

}
