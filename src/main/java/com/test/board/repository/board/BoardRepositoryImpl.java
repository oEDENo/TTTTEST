package com.test.board.repository.board;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.board.dto.board.BoardResponseDto;
import com.test.board.entity.Board;
import com.test.board.entity.QBoard;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public Board findBySujiUseQuerydsl(long id) {
        QBoard board = QBoard.board;

        return queryFactory.select(board)
                .from(board)
                .where(board.id.eq(id))
                .fetchOne();
    }
}
