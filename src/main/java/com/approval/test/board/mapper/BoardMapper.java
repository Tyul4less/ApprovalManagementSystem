package com.approval.test.board.mapper;

import com.approval.test.board.dto.request.*;
import com.approval.test.board.dto.response.BoardCommentResponse;
import com.approval.test.board.dto.response.BoardDetailResponse;
import com.approval.test.board.dto.response.BoardResponse;
import com.approval.test.system.common.util.dto.request.FileRequest;
import com.approval.test.system.common.util.dto.request.FileUploadRequest;
import com.approval.test.system.common.util.dto.response.FileResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface BoardMapper {

    void saveBoard(BoardPostRequest param);
    int getSaveBoardSeq(BoardPostRequest param);

    List<BoardResponse> getBoardList(BoardListRequest param);
    int getBoardListPaging(BoardListRequest param);

    BoardDetailResponse getBoard(int seq);
    void boardFileData(FileUploadRequest fileDataList);

    List<BoardCommentResponse> getBoardCommentList(int seq);
    void editBoard(BoardEditRequest param);
    void disableBoard(int seq);
    void disableFile(int seq);

    void saveComment(BoardCommentRequest param);
    void editComment(EditCommentRequest param);
    void deleteComment(int commentSeq);

    List<FileResponse> getFileList(int seq);

    void deleteBoardFile(FileRequest file);
}
