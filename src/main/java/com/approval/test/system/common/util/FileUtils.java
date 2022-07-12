package com.approval.test.system.common.util;
import com.approval.test.system.common.util.dto.request.FileUploadRequest;
import com.approval.test.system.common.util.dto.response.FileResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class FileUtils {

    public static List<FileUploadRequest> FileUpload(List<MultipartFile> fileItem) throws IOException {

        log.info("파일업로드 시도");
        FileOutputStream fos = null;

        List<FileUploadRequest> array = new ArrayList<>();

        try{
            for(MultipartFile item : fileItem) {
                UUID uuid = UUID.randomUUID();
                System.out.println("item.getOriginalFilename() = " + item.getOriginalFilename());

                String fileExt = item.getOriginalFilename().substring(item.getOriginalFilename().lastIndexOf("."));

                String saveFileName = uuid.toString() + fileExt;
                System.out.println("saveFileName = " + saveFileName);
                String uploadPath = "/users/gwondaewon/Workspace/fileTest/" + saveFileName;
                System.out.println("uploadPath = " + uploadPath);

                byte[] fileData = item.getBytes();
                fos = new FileOutputStream(uploadPath);

                fos.write(fileData);
                System.out.println(item.getOriginalFilename()+", "+uploadPath);

                FileUploadRequest dto = new FileUploadRequest();
                dto.setFileOriginalName(item.getOriginalFilename());
                dto.setFileRandomName(saveFileName);
                dto.setFileUrl("/users/gwondaewon/Workspace/fileTest");
                array.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(fos != null) {
                fos.close();
            }
        }
        return array;
    }

    @GetMapping (value="/fileDownload", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public static ResponseEntity<Object> boardFileDownload(@RequestParam String fileOriginalName, @RequestParam String localPath) {

        System.out.println("다운로드 진입"+fileOriginalName);
        System.out.println("다운로드 진입"+localPath);
        String path = "D:/dev/InteliJWorkSpace/Account4th/Account_SpringBoot/src/main/webapp"+localPath;

        try {
            Path filePath = Paths.get(path);
            Resource resource = new InputStreamResource(Files.newInputStream(filePath)); // 파일 resource 얻기

            File file = new File(path);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-disposition","attachment;filename="+new String(fileOriginalName.getBytes(),"iso-8859-1"));
            //headers.setContentDisposition(ContentDisposition.builder("attachment").filename(fileOriname).build());  // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더

            return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
        }
    }

    public static void FileDelete(List<HashMap<String, String>> deleteList) {
        deleteList.forEach(e -> {

            String path = e.get("path") + e.get("fileRandomName");
            File file = new File(path);

            if( file.exists() ){
                if(file.delete()){
                    System.out.println("파일삭제 성공");
                }else{
                    System.out.println("파일삭제 실패");
                }
            }else{
                System.out.println("파일이 존재하지 않습니다.");
            }
        });
    }

    public static void fileDelete(FileResponse fileResponse){//나중

        File file = new File(fileResponse.getFileUrl());

        if( file.exists() ){ //파일존재여부확인

            if(file.isDirectory()){ //파일이 디렉토리인지 확인

                File[] files = file.listFiles();

                for( int i=0; i<files.length; i++){
                    if( files[i].delete() ){
                        System.out.println(files[i].getName()+" 삭제성공");
                    }else{
                        System.out.println(files[i].getName()+" 삭제실패");
                    }
                }

            }
            if(file.delete()){
                System.out.println("파일삭제 성공");
            }else{
                System.out.println("파일삭제 실패");
            }

        }else{
            System.out.println("파일이 존재하지 않습니다.");
        }

    }
}