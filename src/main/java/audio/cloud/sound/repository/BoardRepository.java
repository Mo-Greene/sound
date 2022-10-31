package audio.cloud.sound.repository;

import audio.cloud.sound.dm.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
