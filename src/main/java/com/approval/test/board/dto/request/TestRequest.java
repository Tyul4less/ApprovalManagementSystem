package com.approval.test.board.dto.request;

import lombok.Getter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@ToString
@Getter
public class TestRequest {

    List<MultipartFile> files;
}
