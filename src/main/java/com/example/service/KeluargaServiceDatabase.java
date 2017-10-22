package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.KeluargaMapper;

import com.example.model.KeluargaModel;
import com.example.model.PendudukModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class KeluargaServiceDatabase implements KeluargaService {
	
	@Autowired
	private KeluargaMapper keluargaMapper;
	
	   @Override
	    public KeluargaModel selectKeluarga (String nomor_kk)
	    {
	        //log.info ("select penduduk with nik {}", nik);
	        return keluargaMapper.selectKeluarga(nomor_kk);
	    }
	   
	   @Override
	    public void addKeluarga (KeluargaModel keluarga)
	    {
	        //log.info ("select penduduk with nik {}", nik);
	        keluargaMapper.addKeluarga (keluarga);
	    }
	
}
