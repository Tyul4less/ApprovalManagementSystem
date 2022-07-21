package com.approval.test.system.common.util;

import com.approval.test.system.common.util.dto.request.FileRequest;
import com.approval.test.system.common.util.dto.request.FileUploadRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

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

    public static ResponseEntity<Object> fileDownload(FileRequest fileData) throws IOException {

        System.out.println("다운로드 진입");
        String fileOriginalName = fileData.getFileOriginalName();
        String fileRandomName = fileData.getFileRandomName();
        String fileUrl = fileData.getFileUrl();
        String path = fileUrl + "/" + fileRandomName;
        System.out.println("path = " + path);

        try {
            //Path filePath = Paths.get(path);
            File file = new File(path);
            Resource resource = new InputStreamResource(Files.newInputStream(file.toPath())); // 파일 resource 얻기


            System.out.println("file.getName() = " + file.getName());

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-disposition","inline;filename="+fileOriginalName);
            //headers.setContentDisposition(ContentDisposition.builder("attachment").filename(fileOriname).build());  // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(file.length())
                    .body(resource);
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

    public static Boolean fileDelete(FileRequest param){

        String filePath = param.getFileUrl() + "/" + param.getFileRandomName();
        File file = new File(filePath);
        if( file.exists() ){ //파일존재여부확인
            if(file.isDirectory()){ //파일이 디렉토리인지 확인
                File[] files = file.listFiles();
                for(int i = 0; i< Objects.requireNonNull(files).length; i++){
                    if( files[i].delete() ){
                        log.info(files[i].getName()+" 삭제성공");
                        return true;
                    }else{
                        log.info(files[i].getName()+" 삭제실패");
                        return false;
                    }
                }
            }
            if(file.delete()){
                return true;
            }else{
                log.info("파일삭제 실패");
                return false;
            }
        }else{
            System.out.println("파일이 존재하지 않습니다.");
            return false;
        }
    }
}