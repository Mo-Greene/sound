package audio.cloud.sound.service;

import audio.cloud.sound.dm.dto.BoardDto;
import audio.cloud.sound.dm.entity.Board;
import audio.cloud.sound.dm.vo.BoardVo;
import audio.cloud.sound.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시글 posting
    @Transactional
    public ResponseEntity<?> postArticle(BoardVo boardVo) {
        Board board = new Board(boardVo);
        return ResponseEntity.status(HttpStatus.CREATED).body(boardRepository.save(board));
    }

    // 게시글 전체 조회
    public List<BoardDto> index() {
        List<Board> board = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();
        for (Board boards : board) {
            BoardDto boardDto = new BoardDto(
                    boards.getBoardSeq(),
                    boards.getTitle(),
                    boards.getContent(),
                    boards.getWriter()
            );
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }

    // 게시글 상세조회
    public BoardDto findByArticle(Long boardSeq) {
        Board board = boardRepository.findById(boardSeq).orElseThrow(
                () -> new IllegalArgumentException("not exist article")
        );
        return new BoardDto(board);
    }

    // 게시글 update
    @Transactional
    public void updateArticle(Long boardSeq, BoardVo boardVo) {
        Board board = boardRepository.findById(boardSeq).orElseThrow(
                () -> new RuntimeException("not exist article")
        );
        board.update(boardVo);
        boardRepository.save(board);
    }

}
