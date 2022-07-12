package com.approval.test.board.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PagingResponse {

        private int totalCount;
        private int totalPage;
        private int currentPage;
}
