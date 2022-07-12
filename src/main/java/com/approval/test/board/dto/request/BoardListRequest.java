package com.approval.test.board.dto.request;

import com.approval.test.system.common.util.ObjectUtil;
import lombok.Getter;
import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Alias("BoardListRequest")
public class BoardListRequest {

    private String keyword;
    //private String status;
    private int rows;
    private int currentPage;

    public String getKeyword(){
        if(ObjectUtil.isNullOrEmpty(keyword)){
            return null;
        }
        return keyword;
    }

    public int getStartIndex() {
        return (currentPage -1) * rows;
    }
}
