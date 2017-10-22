package com.example.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.KeluargaModel;
import com.example.model.PendudukModel;
import com.example.service.KeluargaService;



@Controller
public class KeluargaController {
	
	@Autowired
	KeluargaService keluargaDAO;

	@RequestMapping("/keluarga")
	public String viewKeluarga (Model model,
			@RequestParam(value="nkk", required= true )String nkk)
	{
		KeluargaModel keluarga = keluargaDAO.selectKeluarga(nkk);
		
		if(keluarga != null) {
			model.addAttribute("keluarga", keluarga);
			return "viewkeluarga";
		}
		else {
			return "keluarga-notfound";
		}
		
		
	}
	
	@RequestMapping("/keluarga/tambah")
	public String tambahKeluarga() 
	{
		return "tambahkeluarga";
		
	}
	
	@RequestMapping("/keluarga/tambah/submit")
	public String submitPenduduk (Model model,
			@RequestParam(value="alamat", required= true )String alamat,
			@RequestParam(value="RT", required= true )String RT,
			@RequestParam(value="RW", required= true )String RW,
			@RequestParam(value="jenis_kelamin", required= true )int jenis_kelamin,
			@RequestParam(value="golongan_darah", required= true )String golongan_darah,
			@RequestParam(value="agama", required= true )String agama,
			@RequestParam(value="status_perkawinan", required= true )String status_perkawinan,
			@RequestParam(value="pekerjaan", required= true )String pekerjaan,
			@RequestParam(value="is_wni", required= true )int is_wni,
			@RequestParam(value="is_wafat", required= true )int is_wafat,
			@RequestParam(value="id_keluarga", required= true )int id_keluarga) 
	{
		
		//KeluargaModel keluarga = new KeluargaModel(0,"0123456789123456", alamat, RT, RW, null, 0, null, null, null, null);
		//keluargaDAO.addKeluarga(keluarga);
		
		return "tambahkeluarga-sukses";
	}
}
