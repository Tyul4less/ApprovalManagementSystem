package com.approval.test.board.dto.response;

import com.approval.test.system.common.util.dto.response.FileResponse;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Getter
@Setter
@Alias("BoardDetailResponse")
public class BoardDetailResponse {

    private int seq;
    private String title;
    private String memberName;
    private String memberIndex;
    private String contents;
    private String regDT;
    private String updDT;

    private List<FileResponse> files;

}
