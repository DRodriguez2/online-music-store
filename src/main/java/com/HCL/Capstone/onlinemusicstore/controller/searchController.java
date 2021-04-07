package com.HCL.Capstone.onlinemusicstore.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HCL.Capstone.onlinemusicstore.entity.*;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;
import com.HCL.Capstone.onlinemusicstore.service.*;

import java.util.List;

@Controller
public class searchController {
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
	
	@RequestMapping(value = "/Search", method = RequestMethod.POST)
	public String searchInventory(ModelMap model,@RequestParam String search) {
		
		List <Object> results = new ArrayList<Object>(); 
		
		/*looking for search id: Name, artist, maker, genre 
		 * Different entities:Intruments, services, music, album
		 * 
		 * Instruments: name, maker
		 * Services: name
		 * music: name, artist
		 * album: name, artist, genre
		 * Accessories: name, maker*/

		Iterable<Instrument> instrumentResults = new ArrayList<>();
			instrumentResults = instrumentService.GetAllInstruments();
		Iterable<Services> serviceResults = new ArrayList<>();
			serviceResults = servicesService.GetAllServices();
		Iterable<Music> musicResults = new ArrayList<>();
			musicResults = musicService.GetAllMusic();
		Iterable<Album> albumResults = new ArrayList<>();
			albumResults = albumService.GetAllAlbums();
		Iterable<Accessory> accessoryResults = new ArrayList<>();
			accessoryResults = accessoryService.GetAllAccessories();

//Search instruments	
		for(Product i: instrumentResults) {
			if(i.getName() == search) {
				results.add(i);
			}
			if (i.getMaker() == search) {
				results.add(i);
			}
		}
//Search Services
		for(Services i: serviceResults) {
			if(i.getName() == search) {
				results.add(i);
			}
		}
//Search Music
		for(Music i: musicResults) {
			if(i.getName() == search) {
				results.add(i);
			}
			if (i.getArtist() == search) {
				results.add(i);
			}
		}
//Search Albums
		for(Album i: albumResults) {
			if(i.getName() == search) {
				results.add(i);
			}
			if (i.getArtist() == search) {
				results.add(i);
			}
			if (i.getGenre() == search) {
				results.add(i);
			}
		}
//Search Accessories
		for(Accessory i: accessoryResults) {
			if(i.getName() == search) {
				results.add(i);
			}
			if (i.getBrand() == search) {
				results.add(i);
			}
		}
		

		model.addAttribute("searchResults", results);
		
		return "searchResults";
	}
	
	
	@RequestMapping(value = "/AdvSearch", method = RequestMethod.POST)
	public String advanceSearchInventory(ModelMap model,@RequestParam String type,@RequestParam String search,
			@RequestParam Double priceLow, @RequestParam Double priceHigh) {
		
		List <Object> results = new ArrayList<Object>();
		
		/*looking for search id: Name, artist, maker, genre 
		 * Different entities:Intruments, services, music, album
		 * 
		 * Instruments: name, maker
		 * Services: name
		 * music: name, artist
		 * album: name, artist, genre
		 * Accessories: name, maker*/

		Iterable<Instrument> instrumentResults = new ArrayList<>();
			instrumentResults = instrumentService.GetAllInstruments();
		Iterable<Services> serviceResults = new ArrayList<>();
			serviceResults = servicesService.GetAllServices();
		Iterable<Music> musicResults = new ArrayList<>();
			musicResults = musicService.GetAllMusic();
		Iterable<Album> albumResults = new ArrayList<>();
			albumResults = albumService.GetAllAlbums();
		Iterable<Accessory> accessoryResults = new ArrayList<>();
			accessoryResults = accessoryService.GetAllAccessories();

//Search instruments	
		for(Instrument i: instrumentResults) {
			if(i.getName() == search && i.getPrice() > priceLow && i.getPrice() < priceHigh) {
				results.add(i);
			}
			if (i.getMaker() == search && i.getPrice() > priceLow && i.getPrice() < priceHigh) {
				results.add(i);
			}
		}
//Search Services
		for(Services i: serviceResults) {
			if(i.getName() == search && i.getPrice() > priceLow && i.getPrice() < priceHigh) {
				results.add(i);
			}
		}
//Search Music
		for(Music i: musicResults) {
			if(i.getName() == search && i.getPrice() > priceLow && i.getPrice() < priceHigh) {
				results.add(i);
			}
			if (i.getArtist() == search && i.getPrice() > priceLow && i.getPrice() < priceHigh) {
				results.add(i);
			}
		}
//Search Albums
		for(Album i: albumResults) {
			if(i.getName() == search && i.getPrice() > priceLow && i.getPrice() < priceHigh) {
				results.add(i);
			}
			if (i.getArtist() == search && i.getPrice() > priceLow && i.getPrice() < priceHigh) {
				results.add(i);
			}
			if (i.getGenre() == search && i.getPrice() > priceLow && i.getPrice() < priceHigh) {
				results.add(i);
			}
		}
//Search Accessories
		for(Accessory i: accessoryResults) {
			if(i.getName() == search && i.getPrice() > priceLow && i.getPrice() < priceHigh) {
				results.add(i);
			}
			if (i.getMaker() == search && i.getPrice() > priceLow && i.getPrice() < priceHigh) {
				results.add(i);
			}
		}
		
		

		model.addAttribute("searchResults", results);
	
		return "searchResults";
	}
}
