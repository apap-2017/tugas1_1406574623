package com.example.service;

import java.util.List;

import com.example.model.PendudukModel;

public interface PendudukService {
	PendudukModel selectPenduduk (String nik);
	
	void addPenduduk(PendudukModel penduduk);


//    List<PendudukModel> selectAllPenduduk ();
//
//
//    void addPenduduk (PendudukModel penduduk);
//
//
//    void deletePenduduk (String nik);
//    
//    void updatePenduduk (PendudukModel penduduk);

}
