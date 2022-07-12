package com.approval.test.board.dto.response;

import com.approval.test.board.dto.request.BoardListRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Setter
@Getter
public class BoardListResponse {

    private List<BoardResponse> boardListResponse;
    private PagingResponse pagingResponse;

    public static BoardListResponse getResult(
            BoardListRequest param, List<BoardResponse> boardList, int totalCount){

        BoardListResponse boardListResponse = new BoardListResponse();
        PagingResponse pagingResponse = new PagingResponse();
        int rows = param.getRows();
        int totalPage = 1;
        if (totalCount > rows) {
            totalPage = totalCount % rows > 0 ? totalCount / rows + 1 : totalCount / rows;
        }

        pagingResponse.setTotalCount(totalCount);
        pagingResponse.setTotalPage(totalPage);
        pagingResponse.setCurrentPage(param.getCurrentPage());
        boardListResponse.setBoardListResponse(boardList);
        boardListResponse.setPagingResponse(pagingResponse);
        return boardListResponse;
    }
}
