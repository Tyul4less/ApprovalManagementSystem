package com.approval.test.system.common.util.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@Alias("FileResponse")
public class FileResponse {

    private int seq;
    private String fileOriginalName;
    private String fileRandomName;
    private String fileUrl;
}
