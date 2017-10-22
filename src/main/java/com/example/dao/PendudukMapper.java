package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.One;

import com.example.model.KecamatanModel;
import com.example.model.KeluargaModel;
import com.example.model.KelurahanModel;
import com.example.model.KotaModel;
import com.example.model.PendudukModel;

@Mapper
public interface PendudukMapper {
	
	//select penduduk
	@Select("select * from penduduk where nik=#{nik}")
	@Results(value= { @Result(property="id",column="id"),
			@Result(property="nik", column="nik"),
			@Result(property="nama", column="nama"),
			@Result(property="tempat_lahir", column="tempat_lahir"),
			@Result(property="tanggal_lahir", column="tanggal_lahir"),
			@Result(property="jenis_kelamin", column="jenis_kelamin"),
			@Result(property="is_wni", column="is_wni"),
			@Result(property="id_keluarga", column="id_keluarga"),
			@Result(property="agama", column="agama"),
			@Result(property="pekerjaan", column="pekerjaan"),
			@Result(property="status_perkawinan", column="status_perkawinan"),
			@Result(property="status_dalam_keluarga", column="status_dalam_keluarga"),
			@Result(property="golongan_darah", column="golongan_darah"),
			@Result(property="is_wafat", column="is_wafat"),
			@Result(property="keluarga", column="id_keluarga", javaType= KeluargaModel.class, one = @One(select = "selectKeluarga"))})
	PendudukModel selectPenduduk(@Param("nik") String nik);	
	
	//select keluarga
	@Select("select id, alamat, RT, RW, id_kelurahan from keluarga where id=#{id_keluarga}")
	@Results(value= {@Result(property="id", column="id"),
			@Result(property="alamat", column="alamat"),
			@Result(property="RT", column="RT"),
			@Result(property="RW", column="RW"),
			@Result(property="kelurahan", column="id_kelurahan", javaType = KelurahanModel.class, one = @One(select = "selectKelurahan"))
			})
	KeluargaModel selectKeluarga(@Param("id") String id);
	
	//select kelurahan
	@Select("select id, id_kecamatan, nama_kelurahan from kelurahan where id=#{id_kelurahan}")
	@Results(value= {@Result(property="id", column="id"),
			@Result(property="nama_kelurahan", column="nama_kelurahan"),
			@Result(property="kecamatan", column="id_kecamatan", javaType= KecamatanModel.class, one = @One(select = "selectKecamatan"))})
	KelurahanModel selectKelurahan(@Param("id") String id);
	
	//select kecamatan
		@Select("select id, id_kota, nama_kecamatan from kecamatan where id=#{id_kecamatan}")
		@Results(value= {@Result(property="id", column="id"),
				@Result(property="nama_kecamatan", column="nama_kecamatan"),
				@Result(property="kota", column="id_kota", javaType= KotaModel.class, one = @One(select = "selectKota"))})
		KecamatanModel selectKecamatan(@Param("id") String id);
	
	//select kota
		@Select("select id, nama_kota from kota where id=#{id_kota}")
		@Results(value= {@Result(property="id", column="id"),
				@Result(property="nama_kota", column="nama_kota")})
		KotaModel selectKota(@Param("id") String id);
		
	//tambah penduduk
		@Insert("insert into penduduk(nik, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, is_wni, id_keluarga, agama, pekerjaan, status_perkawinan, status_dalam_keluarga, golongan_darah, is_wafat)"
				+ "values(#{nik}, #{nama}, #{tempat_lahir}, #{tanggal_lahir}, #{jenis_kelamin}, #{is_wni}, #{id_keluarga}, #{agama}, #{pekerjaan}, #{status_perkawinan}, #{status_dalam_keluarga}, #{golongan_darah}. #{is_wafat}")
		void addPenduduk(@Param("penduduk") PendudukModel penduduk);
	
		//nonaktifkan
		@Update("UPDATE PENDUDUK SET is_wafat = 1 WHERE nik = #{nik}")
		 void updatePendudukWafat(String nik);
}
