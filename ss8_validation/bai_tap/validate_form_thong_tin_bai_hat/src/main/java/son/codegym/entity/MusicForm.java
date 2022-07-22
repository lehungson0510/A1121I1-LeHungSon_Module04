package son.codegym.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicForm {

    @NotBlank(message = "{notEmpty}")
    @Size(max = 800, message = "{size300}")
    @Pattern(regexp = "^\\w*$", message = "{regexr1}")
    private String nameSong;
    @Size(max = 300, message = "{size300}")
    @NotBlank(message = "{notEmpty}")
//    @Pattern(regexp = "^[^@;,.=\\-+]*$", message = "Không được chứa các kí tự @;,.=-+")
    @Pattern(regexp = "^\\w*$", message = "{regexr1}")
    private String singer;
    @Size(max = 1000 , message = "{size1000}")
    @NotBlank(message = "{notEmpty}")
    @Pattern(regexp = "^[\\w,]*$", message = "Không được chứa các kí tự đặc biệt ngoại trừ dấu phẩy")
    private String typeOfMusic;
    private MultipartFile path;

    public MusicForm() {
    }

    public MusicForm(String nameSong, String singer, String typeOfMusic, MultipartFile path) {
        this.nameSong = nameSong;
        this.singer = singer;
        this.typeOfMusic = typeOfMusic;
        this.path = path;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTypeOfMusic() {
        return typeOfMusic;
    }

    public void setTypeOfMusic(String typeOfMusic) {
        this.typeOfMusic = typeOfMusic;
    }

    public MultipartFile getPath() {
        return path;
    }

    public void setPath(MultipartFile path) {
        this.path = path;
    }
}
