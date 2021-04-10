package com.HCL.Capstone.onlinemusicstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HCL.Capstone.onlinemusicstore.entity.*;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;
import com.HCL.Capstone.onlinemusicstore.exceptions.ProductNotFoundException;
import com.HCL.Capstone.onlinemusicstore.repository.*;


@Service
public class InstrumentService {
	
	@Autowired
	 private InstrumentRepository instrumentRepository;
	


	public Instrument getInstrumentById(Long id) {
		Optional<Instrument> ins = instrumentRepository.findById(id);
		if(ins.isPresent()) return ins.get();
		//typically I throw a custom exception here
		else return null;
	}
	
    public List<Instrument> getAllInstruments()
    {
        return instrumentRepository.findAll();
    }
	
    public Iterable<Instrument> GetAllInstruments()
    {
        return instrumentRepository.findAll();
    }
    
    public List<Instrument> findAllByNameContainsIgnoreCase(String input) throws ProductNotFoundException {
		Optional<List<Instrument>> products = instrumentRepository.findAllByNameContainsIgnoreCase(input);
		if(products.isPresent()) return products.get();
		else throw new ProductNotFoundException();
	}
    
    public List<Instrument> findAllByBrandContainsIgnoreCase(String input) throws ProductNotFoundException {
		Optional<List<Instrument>> products = instrumentRepository.findAllByBrandContainsIgnoreCase(input);
		if(products.isPresent()) return products.get();
		else throw new ProductNotFoundException();
    }

    public List<Instrument> findAllByCategory(Category input) throws ProductNotFoundException {
		Optional<List<Instrument>> products = instrumentRepository.findAllByCategory(input);
		if(products.isPresent()) return products.get();
		else throw new ProductNotFoundException();
    }

    public Instrument GetInstrumentByName(String name) throws ProductNotFoundException {
    	Instrument item = instrumentRepository.findByName(name);
		if(item != null) return item;
		else throw new ProductNotFoundException();
    }
    
    public void DeleteInstrument(Instrument InstrumenttoUpdate) {
    	instrumentRepository.delete(InstrumenttoUpdate);
    }
    
    public void UpdateInstrument(Instrument InstrumenttoUpdate) {
    	instrumentRepository.save(InstrumenttoUpdate);
    }


}