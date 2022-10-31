package audio.cloud.sound.controller;

import audio.cloud.sound.dm.dto.BoardDto;
import audio.cloud.sound.dm.vo.BoardVo;
import audio.cloud.sound.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 게시글 생성
    @PostMapping("/create")
    public ResponseEntity postArticle(@RequestBody BoardVo boardVo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(boardService.postArticle(boardVo));
    }

    // 게시글 전체조회
    @GetMapping("")
    public ResponseEntity index() {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.index());
    }

    // 게시글 상세조회
    @GetMapping("/{id}")
    public BoardDto findByArticle(@PathVariable(name = "id") Long boardSeq) {
        return boardService.findByArticle(boardSeq);
    }

    // 게시글 수정
    @PutMapping("/update/{id}")
    public void updateArticle(@PathVariable(name = "id") Long boardSeq, @RequestBody BoardVo boardVo) {
        boardService.updateArticle(boardSeq, boardVo);
    }

}
