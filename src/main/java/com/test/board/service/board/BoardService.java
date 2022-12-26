package com.test.board.service.board;

import com.test.board.dto.board.BoardRequestDto;
import com.test.board.dto.board.BoardResponseDto;
import com.test.board.entity.Board;
import com.test.board.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long save(final BoardRequestDto params){
        Board entity = boardRepository.save(params.toEntity());
        return entity.getId();
    }

    public List<BoardResponseDto> findAll() {

        Sort sort = Sort.by(Sort.Direction.DESC, "id" /*, "created_date" */);
        List<Board> list = boardRepository.findAll(sort);
//        List<Board> list = boardRepository.findAll();
        return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public Long update(final Long id, final BoardRequestDto params) {

        Board entity = boardRepository.findById(id).orElseThrow();
        entity.update(params.getTitle(), params.getContent(), params.getWriter());
        return id;
    }

    @Transactional
    public Long delete(final Long id) {
        Board entity = boardRepository.findById(id).orElseThrow();
        entity.delete();
        return id;
    }

    @Transactional
    public BoardResponseDto findById(final Long id) {
        Board entity = boardRepository.findById(id).orElseThrow();
        entity.increaseHits();
        return new BoardResponseDto(entity);
    }

    public List<BoardResponseDto> findAllByDeleteYn(final char deleteYn) {

        Sort sort = Sort.by(Sort.Direction.DESC, "id"/*, "created_date"*/);
        List<Board> list = boardRepository.findAllByDeleteYn(deleteYn, sort);
        return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

}
