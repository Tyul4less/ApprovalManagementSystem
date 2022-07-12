package com.approval.test.board.dto.request;

import lombok.Getter;
import org.apache.ibatis.type.Alias;

@Getter
@Alias("BoardCommentSeqRequest")
public class BoardCommentSeqRequest {

    private int commentSeq;

}
