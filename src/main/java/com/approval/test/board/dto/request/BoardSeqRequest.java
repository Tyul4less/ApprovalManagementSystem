package com.approval.test.board.dto.request;

import lombok.Getter;
import org.apache.ibatis.type.Alias;

@Getter
@Alias("BoardSeqRequest")
public class BoardSeqRequest {

    private Integer seq;

}
