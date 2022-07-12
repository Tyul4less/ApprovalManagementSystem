package com.approval.test.board.dto.request;

import lombok.Getter;
import org.apache.ibatis.type.Alias;

@Getter
@Alias("BoardDeleteRequest")
public class BoardDeleteRequest {

    private int seq;
}
