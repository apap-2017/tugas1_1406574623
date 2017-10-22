package com.example.service;

import com.example.model.KeluargaModel;
import com.example.model.PendudukModel;

public interface KeluargaService {
	KeluargaModel selectKeluarga (String nkk);
	
	void addKeluarga(KeluargaModel keluarga);
}
