package com.example.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.PendudukModel;
import com.example.service.PendudukService;


@Controller
public class PendudukController {
	
	@Autowired
	PendudukService pendudukDAO;
	
	@RequestMapping("/")
	    public String index(){
		System.out.println("test");
	        return "index";
	    }
	
	@RequestMapping("/penduduk")
		public String viewPenduduk (Model model,
				@RequestParam(value="nik", required= true )String nik)
		{
			PendudukModel penduduk = pendudukDAO.selectPenduduk(nik);
			
			if(penduduk != null) {
				model.addAttribute("penduduk", penduduk);
				return "viewpenduduk";
			}
			else {
				return "penduduk-notfound";
			}
			
			
		}
	
	@RequestMapping("/penduduk/tambah")
	public String tambahPenduduk() 
	{
		return "tambahpenduduk";
		
	}
	
	@RequestMapping("/penduduk/tambah/submit")
	public String submitPenduduk (Model model,
			@RequestParam(value="nama", required= true )String nama,
			@RequestParam(value="tempat_lahir", required= true )String tempat_lahir,
			@RequestParam(value="tanggal_lahir", required= true )Date tanggal_lahir,
			@RequestParam(value="jenis_kelamin", required= true )int jenis_kelamin,
			@RequestParam(value="golongan_darah", required= true )String golongan_darah,
			@RequestParam(value="agama", required= true )String agama,
			@RequestParam(value="status_perkawinan", required= true )String status_perkawinan,
			@RequestParam(value="pekerjaan", required= true )String pekerjaan,
			@RequestParam(value="is_wni", required= true )int is_wni,
			@RequestParam(value="is_wafat", required= true )int is_wafat,
			@RequestParam(value="id_keluarga", required= true )int id_keluarga) 
	{
		
		PendudukModel penduduk = new PendudukModel(0,"0123456789123456",nama, tempat_lahir, tanggal_lahir, jenis_kelamin, is_wni, id_keluarga, agama, pekerjaan, status_perkawinan, null, golongan_darah, is_wafat, null, null, null, null);
		
		pendudukDAO.addPenduduk(penduduk);
		
		return "tambahpenduduk-sukses";
	}
	
	@RequestMapping(value = "/penduduk/mati/{nik}")
	 public String updateKematian(Model model, @PathVariable(value = "nik", required = false) String nik) {
	  PendudukModel penduduk = pendudukDAO.selectPenduduk(nik);
	  penduduk.setIs_wafat(1);
	  pendudukDAO.updatePendudukWafat(nik);
	  
	  model.addAttribute("penduduk",penduduk);
	  return "sukses-updatewafat";
	 }
	
	
	
}
