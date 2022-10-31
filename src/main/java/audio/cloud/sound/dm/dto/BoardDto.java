package audio.cloud.sound.dm.dto;

import audio.cloud.sound.dm.entity.Board;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BoardDto {

    private Long boardSeq;
    private String title;
    private String content;
    private String writer;

    public BoardDto(Board board) {
        this.boardSeq = board.getBoardSeq();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getWriter();
    }
}
