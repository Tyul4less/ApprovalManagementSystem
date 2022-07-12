package com.approval.test.board.service;

import com.approval.test.board.dto.request.*;
import com.approval.test.board.dto.response.BoardCommentResponse;
import com.approval.test.board.dto.response.BoardDetailResponse;
import com.approval.test.board.dto.response.BoardListResponse;
import com.approval.test.board.dto.response.BoardResponse;
import com.approval.test.system.common.util.ObjectUtil;
import com.approval.test.system.common.util.dto.request.FileUploadRequest;
import com.approval.test.board.mapper.BoardMapper;
import com.approval.test.system.common.util.dto.response.FileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardMapper boardMapper;

    public int saveBoard(BoardPostRequest param) {
        boardMapper.saveBoard(param);
        return boardMapper.getSaveBoardSeq(param);
    }

    public BoardListResponse getBoardList(BoardListRequest param){
        List<BoardResponse> boardList = boardMapper.getBoardList(param);
        int totalCount = boardMapper.getBoardListPaging();
        return BoardListResponse.getResult(param, boardList, totalCount);
    }

    public BoardDetailResponse getBoard(int seq){
        BoardDetailResponse board = boardMapper.getBoard(seq);
        List<FileResponse> fileList = boardMapper.getFileList(seq);
        board.setFiles(fileList);
        return board;
    }

    public void editBoard(BoardEditRequest param) {
        boardMapper.editBoard(param);
        if(ObjectUtil.isNullOrEmpty(param.getDeleteFile())) {
            boardMapper.deleteFileList(param.getDeleteFile());
        }
    }

    public void deleteBoard(int seq){
        boardMapper.deleteBoard(seq);
    }

    public void saveComment(BoardCommentRequest param) {
        boardMapper.saveComment(param);
    }

    public List<BoardCommentResponse> getBoardCommentList(int seq){
        System.out.println("seq = " + seq);
        List<BoardCommentResponse> list =  boardMapper.getBoardCommentList(seq);
        System.out.println("list = " + list);
        return list;
    }

    public void editComment(EditCommentRequest param) {
        boardMapper.editComment(param);
    }

    public void deleteComment(int commentSeq) {
        boardMapper.deleteComment(commentSeq);
    }

    public void boardFileData(List<FileUploadRequest> fileDataList, int seq) {
        fileDataList.forEach(e -> {
            e.setSeq(seq);
            boardMapper.boardFileData(e);
        });
    }

}
