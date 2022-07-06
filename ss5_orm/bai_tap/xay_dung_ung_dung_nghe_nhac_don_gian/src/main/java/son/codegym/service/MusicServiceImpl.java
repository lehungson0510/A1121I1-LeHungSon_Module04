package son.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import son.codegym.entity.Music;
import son.codegym.repository.IMusicRepository;

import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService {

    @Autowired
    IMusicRepository musicRepository;

    @Override
    public List<Music> findAllMusic() {
        return musicRepository.findAllMusic();
    }

    @Override
    public void create(Music music) {
        musicRepository.create(music);
    }

    @Override
    public void update(Music music) {
        musicRepository.update(music);
    }

    @Override
    public void delete(String name) {
        musicRepository.delete(name);
    }

    @Override
    public Music findMusicByName(String nameSong) {
        return musicRepository.findMusicByName(nameSong);
    }
}
