package com.HCL.Capstone.onlinemusicstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.HCL.Capstone.onlinemusicstore.entity.Album;
import com.HCL.Capstone.onlinemusicstore.entity.Music;
import com.HCL.Capstone.onlinemusicstore.entity.Song;
import com.HCL.Capstone.onlinemusicstore.exceptions.NoAlbumsInDatabaseException;
import com.HCL.Capstone.onlinemusicstore.exceptions.NoSongsInDatabaseException;
import com.HCL.Capstone.onlinemusicstore.service.MusicService;

@Controller
public class MusicController {
	
	@Autowired private MusicService ms;

	@GetMapping("/music/all") 
	public ModelAndView getAllMusic() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		List<Music> all = ms.getAllMusic();
		mv.addObject("musicList", all);
		return mv;
	}
	
	@GetMapping("/music/songs") 
	public ModelAndView getAllSongs() throws NoSongsInDatabaseException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewNameGoesHere");
		List<Song> all = ms.getAllSongs();
		mv.addObject("songList", all);
		return mv;
	}
	
	@GetMapping("/music/albums") 
	public ModelAndView getAllAlbums() throws NoAlbumsInDatabaseException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewNameGoesHere");
		List<Album> all = ms.getAllAlbums();
		mv.addObject("albumList", all);
		return mv;
	}
}
