package com.HCL.Capstone.onlinemusicstore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.HCL.Capstone.onlinemusicstore.entity.Album;
import com.HCL.Capstone.onlinemusicstore.entity.Music;
import com.HCL.Capstone.onlinemusicstore.entity.Song;
import com.HCL.Capstone.onlinemusicstore.exceptions.MusicNotFoundException;
import com.HCL.Capstone.onlinemusicstore.exceptions.NoAlbumsInDatabaseException;
import com.HCL.Capstone.onlinemusicstore.exceptions.NoSongsInDatabaseException;
import com.HCL.Capstone.onlinemusicstore.service.MusicService;

@Controller
@RequestMapping("/music")
public class MusicController {
	
	@Autowired private MusicService ms;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@GetMapping()
	public String defaultView() {
		return "music";
	}

	@GetMapping("/all") 
	public ModelAndView getAllMusic() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("music");
		List<Music> all = ms.getAllMusic();
		mv.addObject("searchResults", all);
		return mv;
	}
	
	@GetMapping("/genres") 
	public ModelAndView getAllGenres() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("music");
		List<String> all = ms.getAllGenres();
		mv.addObject("genreList", all);
		return mv;
	}
	
	//*****************************All song endpoints********************************
	@GetMapping("/songs/all") 
	public ModelAndView getAllSongs() throws NoSongsInDatabaseException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("music");
		List<Song> all = ms.getAllSongs();
		mv.addObject("searchResults", all);
		return mv;
	}
	
	@GetMapping("/songs/{input}")
	public ModelAndView getSongsBasedOnUserInput(@PathVariable String input) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("music");
		logger.info("User Input: " + input);
		List<Song> all;
		try {
			all = ms.getAllSongsByNameContaining(input);
		} catch (MusicNotFoundException e) {
			all = null;
		}
		mv.addObject("searchResults", all);
		return mv;
	}
	
	@GetMapping("/songs/genre/{input}")
	public ModelAndView getSongsBasedOnGenre(@PathVariable String input) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("music");
		logger.info("User Input: " + input);
		List<Song> all;
		try {
			all = ms.getAllSongsByGenre(input);
		} catch (MusicNotFoundException e) {
			all = null;
		}
		mv.addObject("searchResults", all);
		return mv;
	}
	
	@GetMapping("/songs/artist/{input}")
	public ModelAndView getSongsBasedOnArtist(@PathVariable String input) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("music");
		logger.info("User Input: " + input);
		List<Song> all;
		try {
			all = ms.getAllSongsByArtist(input);
		} catch (MusicNotFoundException e) {
			all = null;
		}
		mv.addObject("searchResults", all);
		return mv;
	}
	
	
	//*****************************All album endpoints********************************
	@GetMapping("/albums") 
	public ModelAndView getAllAlbums() throws NoAlbumsInDatabaseException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("music");
		List<Album> all = ms.getAllAlbums();
		mv.addObject("searchResults", all);
		return mv;
	}
	
	@GetMapping("/albums/{input}")
	public ModelAndView getAlbumsBasedOnUserInput(@RequestParam String input) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("music");
		List<Album> all;
		try {
			all = ms.getAllAlbumByNameContaining(input);
		} catch (MusicNotFoundException e) {
			all = null;
		}
		mv.addObject("searchResults", all);
		return mv;
	}
	
	@GetMapping("/albums/genre/{input}")
	public ModelAndView getAlbumsBasedOnGenre(@RequestParam String input) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("music");
		List<Album> all;
		try {
			all = ms.getAllAlbumsByGenre(input);
		} catch (MusicNotFoundException e) {
			all = null;
		}
		mv.addObject("searchResults", all);
		return mv;
	}
	
	@GetMapping("/albums/artist/{input}")
	public ModelAndView getAlbumsBasedOnArtist(@RequestParam String input) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("music");
		List<Album> all;
		try {
			all = ms.getAllAlbumByNameContaining(input);
		} catch (MusicNotFoundException e) {
			all = null;
		}
		mv.addObject("searchResults", all);
		return mv;
	}

	
}
