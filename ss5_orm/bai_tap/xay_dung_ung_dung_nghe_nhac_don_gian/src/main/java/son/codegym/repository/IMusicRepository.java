package son.codegym.repository;

import son.codegym.entity.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAllMusic();

    void create(Music music);

    void update(Music music);

    void delete(String name);

    Music findMusicByName(String nameSong);
}
