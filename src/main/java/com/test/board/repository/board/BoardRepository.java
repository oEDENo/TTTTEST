package com.test.board.repository.board;

import com.test.board.entity.Board;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository <Board, Long>, BoardRepositoryCustom {
    List<Board> findAllByDeleteYn(final char deleteYn, final Sort sort);
}
