package com.HCL.Capstone.onlinemusicstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HCL.Capstone.onlinemusicstore.entity.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {

}
