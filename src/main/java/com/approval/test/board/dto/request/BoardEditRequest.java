package com.approval.test.board.dto.request;

import lombok.Getter;
import org.apache.ibatis.type.Alias;

import java.util.HashMap;
import java.util.List;

@Getter
@Alias("BoardEditRequest")
public class BoardEditRequest{

    private Integer seq;
    private String title;
    private String contents;
    private List<HashMap<String, String>> deleteFile;

}
