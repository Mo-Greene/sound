package audio.cloud.sound.dm.entity;

import audio.cloud.sound.dm.vo.BoardVo;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardSeq;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String writer;

    public Board(BoardVo boardVo) {
        this.title = boardVo.getTitle();
        this.content = boardVo.getContent();
        this.writer = boardVo.getWriter();
    }

    public void update(BoardVo boardVo) {
        this.content = boardVo.getContent();
    }
}
