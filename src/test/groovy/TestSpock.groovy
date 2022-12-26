import com.querydsl.jpa.impl.JPAQueryFactory
import com.test.TestProjectApplication
import com.test.board.dto.board.BoardRequestDto
import com.test.board.dto.board.BoardResponseDto
import com.test.board.entity.Board
import com.test.board.entity.QBoard
import com.test.board.repository.board.BoardRepository
import com.test.board.service.board.BoardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = TestProjectApplication.class)
class TestSpock extends Specification {

    @Autowired
    BoardRepository repository

    @Autowired
    BoardService boardService

    @Autowired
    private JPAQueryFactory queryFactory;

    def "querydsl 테스트"() {
        when:
        List<Board> board = queryFactory
                            .selectFrom(QBoard.board)
                            .where(QBoard.board.title.eq("테스트"))
                            .fetch()
//        Store store = queryFactory
//                .selectFrom(QStore.store)
//                .where(QStore.store.name.eq("이마트"))
//        fetch();
//        assertEquals(store.getName(), "이마트");
        then:
        board.get(0).title == "테스트"
    }

//    def "게시글 저장하기 테스트"(){
//        given:
//        Board test = new Board("테스트케이스", "확인해볼게요", "이름", 0, "N")
//
//        when:
//        test.increaseHits()
//
//        then:
//        repository.save(new Board("제목입니다", "내용", "작성자", 0, "N"))
//    }

//
    def "게시글 삭제 테스트"(){
        given:
        long num = 2

        when:
        boardService.delete(num)

        then:
        BoardResponseDto test = boardService.findById(num)
        test.getDeleteYn() == "Y"
    }

    def "게시글 수정 테스트"(){
        given:
        long num = 1

        when:
        boardService.update(num, new BoardRequestDto("수정테스트", "성공?", "작성", 'N'))

        then:
        BoardResponseDto test = boardService.findById(num)
        test.getTitle() == "수정테스트"
    }



//    def "spock test"() {
//        given:
//        List<Integer> test = new ArrayList<>()
//
//        when:
//        test.add(1)
//
//        then:
////        test.get(0) == 2
//        test.get(0) == 1
//    }

}
