package son.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import son.codegym.entity.Music;
import son.codegym.service.IMusicService;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    IMusicService musicService;

    @ModelAttribute("music")
    public Music initMusic(){
        return new Music();
    }

    @GetMapping("")
    public String displayList(Model model){
        List<Music> musicList = musicService.findAllMusic();
        model.addAttribute("musicList",musicList);
        return "list";
    }

    @GetMapping("create")
    public String showFormCreate(Model model){
        return "/create";
    }

    @PostMapping("create")
    public String save(@ModelAttribute("music") Music music){
        musicService.create(music);
        return "redirect:/music/";
    }

    @GetMapping("edit")
    public String showFormEdit(Model model){
        return "/edit";
    }

    @PostMapping("edit")
    public String update(@ModelAttribute("music") Music music){
        musicService.update(music);
        return "redirect:/music/";
    }
//    @GetMapping("delete/{name}")
//    public String delete(@PathVariable("name") String name){
//        musicService.delete(name);
//        return "redirect:/music/";
//    }

    @GetMapping("delete/{name}")
    public String showFormDelete(@PathVariable("name") String name, Model model){
        Music music = musicService.findMusicByName(name);
        model.addAttribute("music",music);
        return "delete";
    }

    @PostMapping("delete")
    public String delete(@ModelAttribute("music") Music music){
        musicService.delete(music.getNameSong());
        return "redirect:/music/";
    }

    @GetMapping("view/{name}")
    public String view(@PathVariable("name") String name, Model model){
        Music music = musicService.findMusicByName(name);
        model.addAttribute("music",music);
        return "view";
    }
}
