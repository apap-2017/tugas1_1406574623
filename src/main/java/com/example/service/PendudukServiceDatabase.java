package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PendudukMapper;
import com.example.model.PendudukModel;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service


public class PendudukServiceDatabase implements PendudukService {
	
	 @Autowired
	 PendudukMapper pendudukMapper;


	   @Override
	    public PendudukModel selectPenduduk (String nik)
	    {
	        //log.info ("select penduduk with nik {}", nik);
	        return pendudukMapper.selectPenduduk (nik);
	    }
	   
	
	    public void addPenduduk (PendudukModel penduduk)
	    {
	        //log.info ("select penduduk with nik {}", nik);
	        pendudukMapper.addPenduduk (penduduk);
	    }


//	    @Override
//	    public List<PendudukModel> selectAllPenduduk ()
//	    {
//	        log.info ("select all penduduk");
//	        return pendudukMapper.selectAllPenduduk ();
//	    }
//
//
//	    @Override
//	    public void addPenduduk (PendudukModel penduduk)
//	    {
//	        pendudukMapper.addPenduduk (penduduk);
//	    }
//s
//
//	    @Override
//	    public void deletePenduduk (String nik)
//	    {
//	    		log.info ("penduduk " + nik + " deleted");
//	    		PendudukModel penduduk = pendudukMapper.selectPenduduk(nik);
//	    		pendudukMapper.deletePenduduk(penduduk);
//	    }
//	    
//	    @Override
//	    public void updatePenduduk (PendudukModel penduduk)
//	    {
//	    		log.info ("penduduk " + penduduk + " updated");
//	    		pendudukMapper.updatePenduduk(penduduk);
//	    }

}
