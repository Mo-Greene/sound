package audio.cloud.sound.dm.vo;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BoardVo {
    private String title;
    private String content;
    private String writer;
}
