package com.HCL.Capstone.onlinemusicstore.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.HCL.Capstone.onlinemusicstore.entity.Accessory;
import com.HCL.Capstone.onlinemusicstore.entity.Album;
import com.HCL.Capstone.onlinemusicstore.entity.Instrument;
import com.HCL.Capstone.onlinemusicstore.entity.Music;
import com.HCL.Capstone.onlinemusicstore.entity.Services;
import com.HCL.Capstone.onlinemusicstore.entity.Song;
import com.HCL.Capstone.onlinemusicstore.exceptions.MusicNotFoundException;
import com.HCL.Capstone.onlinemusicstore.exceptions.NoAlbumsInDatabaseException;
import com.HCL.Capstone.onlinemusicstore.exceptions.ProductNotFoundException;
import com.HCL.Capstone.onlinemusicstore.service.AccessoryService;
import com.HCL.Capstone.onlinemusicstore.service.InstrumentService;
import com.HCL.Capstone.onlinemusicstore.service.MusicService;
import com.HCL.Capstone.onlinemusicstore.service.ProductService;
import com.HCL.Capstone.onlinemusicstore.service.ServicesService;


@Controller
public class adminController {
	
	@Autowired private MusicService ms;
	@Autowired private InstrumentService is;
	@Autowired private ServicesService ss;
	@Autowired private AccessoryService as;
	
	@Autowired private ProductService ps;
	
	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/admin")
	public String adminPage(Model model, @RequestParam(required = false) String category) {
	
		if(category == null) {
			List <Music> allMusic = ms.getAllMusic();
			model.addAttribute("searchResults", allMusic);
			model.addAttribute("category", "music");
			return "admin";
		}
		else {
			switch(category) {
			default:
			case "music":
				List <Music> allMusic = ms.getAllMusic();
				model.addAttribute("searchResults", allMusic);
				model.addAttribute("category", "music");
				break;
				
			case "accessory":
				List <Accessory> allAccessories = StreamSupport.stream(as.GetAllAccessories().spliterator(), false).collect(Collectors.toList());
				model.addAttribute("searchResults", allAccessories);
				model.addAttribute("category", "accessory");
				break;
			
			case "service":
				List <Services> allServices = StreamSupport.stream(ss.GetAllServices().spliterator(), false).collect(Collectors.toList());
				model.addAttribute("searchResults", allServices);
				model.addAttribute("category", "service");
				break;
				
			case "instrument":
				List <Instrument> allInstruments = is.getAllInstruments();
				model.addAttribute("searchResults", allInstruments);
				model.addAttribute("category", "instrument");
				break;
				
			}
			return "admin";
			
		}
		
	}
	
	@RequestMapping("/admin/task")
	public String adminTask(@RequestParam String category, @RequestParam Long productId,  Model model) throws MusicNotFoundException, NoAlbumsInDatabaseException {
		switch(category) {
		case "MUSIC":
			Music music = ms.getMusicById(productId);
			if(music.getType().toString().equals("SONG")) {
				Song song = (Song) music;
				List<Album> filteredAlbums = ms.getAllAlbums().stream().filter(a -> a.getName() != song.getAlbum().getName()).collect(Collectors.toList());
				model.addAttribute("allAlbums", filteredAlbums);	
				model.addAttribute("editSong", song);
				model.addAttribute("editCategory", "song");
			}
			else if(music.getType().toString().equals("ALBUM")) {
				Album album = (Album) music;
				model.addAttribute("editAlbum", album);
				model.addAttribute("editCategory", "album");
			}
			List <Music> allMusic = ms.getAllMusic();
			
			//need for page to show proper jps's
			model.addAttribute("searchResults", allMusic);
			model.addAttribute("category", "music");
			
			return "admin";
		case "ACCESSORIES":
			Accessory accessory = as.findAccessoryById(productId);
			List<Accessory> allAccessories = as.getAllAccessories();
			model.addAttribute("editAccessory", accessory);
			model.addAttribute("editCategory", "accessory");
			model.addAttribute("searchResults", allAccessories);
			model.addAttribute("category", "accessory");
			return "admin";
		case "INSTRUMENT": 
			Instrument instrument = is.getInstrumentById(productId);
			List <Instrument> allInstruments = is.getAllInstruments();
			model.addAttribute("editInstrument", instrument);
			model.addAttribute("editCategory", "instrument");
			model.addAttribute("searchResults", allInstruments);
			model.addAttribute("category", "instrument");
			return "admin";
		case "SERVICE":
			Services service = ss.findServiceById(productId);
			List<Services> allServices = ss.getAllServices();
			model.addAttribute("editService", service);
			model.addAttribute("editCategory", "service");
			model.addAttribute("searchResults", allServices);
			model.addAttribute("category", "service");
			return "admin";
		default:
			return "error";
		}
	}
	
	@PostMapping("/admin/delete")
	public String adminPage(Model model, @RequestParam Long id, @RequestParam String editCategory) throws ProductNotFoundException {
		switch(editCategory) {
		default:
		case "music":
			Music music = (Music) ps.getProductById(id);
			ms.deleteMusic(music);
			List<Music> updated = ms.getAllMusic();
			model.addAttribute("searchResults", updated);
			model.addAttribute("editCategory", "none");
			model.addAttribute("category", "music");
			return "admin";
			
		case "accessory":
			Accessory accessory = as.findAccessoryById(id);
			as.DeleteAccessory(accessory);
			List <Accessory> allAccessories = StreamSupport.stream(as.GetAllAccessories().spliterator(), false).collect(Collectors.toList());
			model.addAttribute("searchResults", allAccessories);
			model.addAttribute("category", "accessory");
			return "admin";
		
		case "service":
			Services service = ss.findServiceById(id);
			ss.DeleteServices(service);
			List <Services> allServices = ss.getAllServices();
			model.addAttribute("searchResults", allServices);
			model.addAttribute("editCategory", "none");
			model.addAttribute("category", "service");
			return "admin";
			
		case "instrument":
			Instrument ins = is.getInstrumentById(id);
			is.DeleteInstrument(ins);
			List <Instrument> allInstruments = is.getAllInstruments();
			model.addAttribute("searchResults", allInstruments);
			model.addAttribute("editCategory", "none");
			model.addAttribute("category", "instrument");
			return "admin";
			
		}

	}
	
	@GetMapping("admin/addAlbum") 
	public String adminShowAddAlbum(Model model) {
		model.addAttribute("searchResults", ms.getAllMusic());
		model.addAttribute("music", new Music());
		model.addAttribute("addCategory", "album");
		model.addAttribute("editCategory", "none");
		model.addAttribute("category", "music");
		return "admin";
	}
	
	@PostMapping("admin/addAlbum") 
	public String adminAddMusic(@Valid @ModelAttribute("music") Music music, BindingResult result, Model model, @RequestParam String numSongs) {
		int intNumSongs = 0;
		try {
			intNumSongs = Integer.parseInt(numSongs);
		} catch (NumberFormatException e) {
			model.addAttribute("searchResults", ms.getAllMusic());
			model.addAttribute("addCategory", "album");
			model.addAttribute("category", "music");
			model.addAttribute("numSongsError", "invalid number");
		}
		if(result.hasErrors()) {
			model.addAttribute("addCategory", "album");
		} else {
			Album album = new Album(music.getName(), music.getCategory(), music.getPrice(), music.getPlatform(), 
									music.getType(), music.getArtist(), music.getGenre());
			ms.saveMusic(album);
			model.addAttribute("numSongs", intNumSongs);
			model.addAttribute("addedAlbum", album);
			//need to set addCategory so its value is not null
			model.addAttribute("addCategory", "not null");
			model.addAttribute("music", new Music());
		}
		model.addAttribute("category", "music");
		model.addAttribute("searchResults", ms.getAllMusic());		
		return "admin";
	}
	
	@PostMapping("admin/addSong")
	public String adminAddSong(@RequestParam int numSongs, @Valid @ModelAttribute Music song,
							   BindingResult result, @RequestParam Long albumId, Model model) throws MusicNotFoundException {
		Album addedAlbum = ms.getAlbumById(albumId);
		if(!result.hasErrors()) {
			numSongs--;
			Song songToAdd = new Song(song.getName(), song.getCategory(), song.getPrice(), 
					song.getPlatform(), song.getType(), song.getArtist(), song.getGenre());
			songToAdd.setAlbum(addedAlbum);
			ms.saveMusic(songToAdd);
			model.addAttribute("music", new Music());
		}
		
		model.addAttribute("category", "music");
		model.addAttribute("searchResults", ms.getAllMusic());
		model.addAttribute("addCategory", "not null");
		model.addAttribute("numSongs", numSongs);
		model.addAttribute("addedAlbum", addedAlbum);
		return "admin";
	}
	
	@GetMapping("admin/addAccessory") 
	public String adminShowAddAccessory(Model model) {
		model.addAttribute("category", "accessory");
		model.addAttribute("accessory", new Accessory());
		model.addAttribute("searchResults", as.getAllAccessories());
		model.addAttribute("addCategory", "accessory");
		return "admin";
	}
	
	@PostMapping("admin/addAccessory") 
	public String adminAddAccessory( @Valid @ModelAttribute Accessory accessory, BindingResult result, Model model) {
		if(!result.hasErrors()) {
			Accessory accessoryToAdd = new Accessory(accessory.getName(), accessory.getCategory(), 
										 accessory.getPrice(), accessory.getBrand(), accessory.getDescription());
			as.UpdateAccessory(accessoryToAdd);
		} else {
			
			model.addAttribute("addCategory", "accessory");
		}
		model.addAttribute("category", "accessory");
		model.addAttribute("searchResults", as.getAllAccessories());
		return "admin";
	}
	
	@GetMapping("admin/addService") 
	public String adminShowAddService(Model model) {
		model.addAttribute("category", "service");
		model.addAttribute("service", new Services());
		model.addAttribute("searchResults", ss.getAllServices());
		model.addAttribute("addCategory", "service");
		return "admin";
	}
	
	@PostMapping("admin/addService") 
	public String adminAddService( @Valid @ModelAttribute Services service, BindingResult result, Model model) {
		if(!result.hasErrors()) {
			Services serviceToAdd = new Services(service.getName(), service.getCategory(), 
										 service.getPrice(), service.getDescription());
			ss.UpdateServices(serviceToAdd);
		} else {
			model.addAttribute("addCategory", "service");
		}
		model.addAttribute("category", "service");
		model.addAttribute("searchResults", ss.getAllServices());
		return "admin";
	}
	
	@GetMapping("admin/addInstrument") 
	public String adminShowAddInstrument(Model model) {
		model.addAttribute("category", "instrument");
		model.addAttribute("instrument", new Instrument());
		model.addAttribute("searchResults", is.getAllInstruments());
		model.addAttribute("addCategory", "instrument");
		return "admin";
	}
	
	@PostMapping("admin/addInstrument") 
	public String adminAddInstrument( @Valid @ModelAttribute Instrument instrument, BindingResult result, Model model) {
		if(!result.hasErrors()) {
			Instrument instrumentToAdd = new Instrument(instrument.getName(), instrument.getCategory(), 
										 instrument.getPrice(), instrument.getType(), instrument.getBrand());
			is.UpdateInstrument(instrumentToAdd);
		} else {
			model.addAttribute("addCategory", "instrument");
		}
		model.addAttribute("category", "instrument");
		model.addAttribute("searchResults", is.getAllInstruments());
		return "admin";
	}
	
	@PostMapping("admin/task/song")
	public String adminUpdateSong(@RequestParam String name, @RequestParam Double price, @RequestParam String artist,
								  @RequestParam String genre, @RequestParam Long productId, @RequestParam String albumName,
								  Model model) throws MusicNotFoundException {
		Song song = ms.getSongById(productId);
		Album album = ms.getAlbumByName(albumName);
		song.setName(name);
		song.setPrice(price);
		song.setArtist(artist);
		song.setAlbum(album);
		song.setGenre(genre);
		ms.saveMusic(song);
		model.addAttribute("searchResults", ms.getAllMusic());
		model.addAttribute("category", "music");
		return "admin";
	}
	
	@PostMapping("admin/task/album")
	public String adminUpdateAlbum(@RequestParam String name, @RequestParam Double price, @RequestParam String artist,
								  @RequestParam String genre, @RequestParam Long productId, Model model) throws MusicNotFoundException {
		Album album = ms.getAlbumById(productId);
		album.setName(name);
		album.setPrice(price);
		album.setArtist(artist);
		album.setGenre(genre);
		ms.saveMusic(album);
		model.addAttribute("searchResults", ms.getAllMusic());
		model.addAttribute("category", "music");
		return "admin";
	}
	
	@PostMapping("admin/task/instrument")
	public String adminUpdateInstrument(@RequestParam String name, @RequestParam Double price, @RequestParam String brand,
								  @RequestParam String type, @RequestParam Long productId, Model model) {
		Instrument instrument = is.getInstrumentById(productId);
		instrument.setName(name);
		instrument.setPrice(price);
		instrument.setBrand(brand);
		instrument.setType(type);
		is.UpdateInstrument(instrument);
		model.addAttribute("searchResults", is.getAllInstruments());
		model.addAttribute("category", "instrument");
		return "admin";
	}
	
	@PostMapping("admin/task/service")
	public String adminUpdateService(@RequestParam String name, @RequestParam Double price, @RequestParam String description,
								     @RequestParam Long productId, Model model) {
		Services service = ss.findServiceById(productId);
		service.setName(name);
		service.setPrice(price);
		service.setDescription(description);
		ss.UpdateServices(service);
		model.addAttribute("searchResults", ss.getAllServices());
		model.addAttribute("category", "service");
		return "admin";
	}
	
	@PostMapping("admin/task/accessory")
	public String adminAccessoryService(@RequestParam String name, @RequestParam Double price, @RequestParam String description,
								        @RequestParam String brand, @RequestParam Long productId, Model model) {
		Accessory accessory = as.findAccessoryById(productId);
		accessory.setName(name);
		accessory.setPrice(price);
		accessory.setDescription(description);
		accessory.setBrand(brand);
		as.UpdateAccessory(accessory);
		model.addAttribute("searchResults", as.getAllAccessories());
		model.addAttribute("category", "accessory");
		return "admin";
	}
	

	
	@RequestMapping(value = "/AdminTask", method = RequestMethod.POST)
	public String selectTask(ModelMap model,@RequestParam String entity,@RequestParam String action) {
		
//'entity' and 'action' can be a drop down menu selections in the Admin View page 
		switch(entity) {
		case "Music":
			switch(action) {
			case "add":
				return "addMusic";
			case "update":
				return "updateMusic";
			case "delete":
				return "deleteMusic";
			default:
				System.out.println("no match");
			}
			break;
		case "Album":
			switch(action) {
			case "add":
				return "addAlbum";
			case "update":
				return "updateAlbum";
			case "delete":
				return "deleteAlbum";
			default:
				System.out.println("no match");
		}
			break;
		case "Instrument":
			switch(action) {
			case "add":
				return "addInstrument";
			case "update":
				return "updateInstrument";
			case "delete":
				return "deleteInstrument";
			default:
				System.out.println("no match");
		}
			break;
		case "Services":
			switch(action) {
			case "add":
				return "addServices";
			case "update":
				return "updateServices";
			case "delete":
				return "deleteServices";
			default:
				System.out.println("no match");
		}
			break;
		case "Accessory":
			switch(action) {
			case "add":
				return "addAccessory";
			case "update":
				return "updateAccessory";
			case "delete":
				return "deleteAccessory";
			default:
				System.out.println("no match");
		}
			break;
		default:
			return "error";
		}
		return "error";
		
	}
}
