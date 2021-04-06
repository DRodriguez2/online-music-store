package com.HCL.Capstone.onlinemusicstore.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.MusicStore.entities.*;
import com.example.MusicStore.repository.*;
import com.example.MusicStore.service.*;

import java.util.List;

@Controller
public class adminController {
	
	@Autowired
	private MusicService musicService;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private InstrumentService instrumentService;
	@Autowired
	private ServicesService servicesService;
	@Autowired
	private AccessoryService accessoryService;
	
	@RequestMapping(value = "/Delete", method = RequestMethod.POST)
	public String deleteTask(ModelMap model,@RequestParam String type,@RequestParam String name) {
		
//'type' can be a drop down menu selection 
		switch(type) {
			case "Music":
				Music song = musicService.GetMusicByName(name);
				musicService.DeleteMusic(song);
				break;
			case "Album":
				Album album = albumService.GetAlbumByName(name);
				albumService.DeleteAlbum(album);
				break;
			case "Instrument":
				Instrument instrument = instrumentService.GetInstrumentByName(name);
				instrumentService.DeleteInstrument(instrument);
				break;
			case "Services":
				Services service = servicesService.GetServiceByName(name);
				servicesService.DeleteServices(service);
				break;
			case "Accessories":
				Accessory accessory = accessoryService.GetAccessoryByName(name);
				accessoryService.DeleteAccessory(accessory);
				break;
			default:
				System.out.println("no match");
		}
		return "taskresult";

	}
	
	
	@RequestMapping(value = "/UpdateTask", method = RequestMethod.POST)
	public String updateTask(ModelMap model,@RequestParam String type,@RequestParam String name, @RequestParam String maker, 
			@RequestParam String artist, @RequestParam String genre,@RequestParam Integer price) {
		
		switch(type) {
		case "Music":
			Music song = musicService.GetMusicByName(name);
				song.setArtist(artist);
				song.setPrice(price);
			musicService.UpdateMusic(song);
			break;
		case "Album":
			Album album = albumService.GetAlbumByName(name);
				album.setArtist(artist);
				album.setGenre(genre);
				album.setPrice(price);
			albumService.UpdateAlbum(album);
			break;
		case "Instrument":
			Instrument item = instrumentService.GetInstrumentByName(name);
				item.setMaker(maker);
				item.setPrice(price);
			instrumentService.UpdateInstrument(item);
			break;
		case "Services":
			Services service = servicesService.GetServiceByName(name);
				service.setPrice(price);
			servicesService.UpdateServices(service);
			break;
		case "Accessories":
			Accessory object = accessoryService.GetAccessoryByName(name);
				object.setMaker(maker);
				object.setPrice(price);
			accessoryService.UpdateAccessory(object);
			break;
		default:
			System.out.println("no match");
	}
		return "taskresult";
		
		
	}
	
	
	
	@RequestMapping(value = "/Add", method = RequestMethod.POST)
	public String addTask(ModelMap model, @RequestParam String type, @RequestParam String name, 
			@RequestParam String maker, @RequestParam String artist, @RequestParam String genre,@RequestParam Integer price) {
		
		//'type' can be a drop down menu selection 
				switch(type) {
					case "Music":
						Music song = new Music();
							song.setName(name);
							song.setArtist(artist);
							song.setPrice(price);
						musicService.UpdateMusic(song);
						break;
					case "Album":
						Album album = new Album();
							album.setName(name);
							album.setArtist(artist);
							album.setGenre(genre);
							album.setPrice(price);
						albumService.UpdateAlbum(album);
						break;
					case "Instrument":
						Instrument item = new Instrument();
							item.setName(name);
							item.setMaker(maker);
							item.setPrice(price);
						instrumentService.UpdateInstrument(item);
						break;
					case "Services":
						Services service = new Services();
							service.setName(name);
							service.setPrice(price);
						servicesService.UpdateServices(service);
						break;
					case "Accessories":
						Accessory object = new Accessory();
							object.setName(name);
							object.setMaker(maker);
							object.setPrice(price);
						accessoryService.UpdateAccessory(object);
						break;
					default:
						System.out.println("no match");
				}
				return "taskresult";
	}
}
