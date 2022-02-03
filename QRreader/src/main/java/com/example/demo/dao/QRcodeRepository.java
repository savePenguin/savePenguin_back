package com.example.demo.dao;



import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.QRcode;


//public interface QRcodeRepository extends CrudRepository <QRcode,Integer> {
public interface QRcodeRepository extends JpaRepository <QRcode,Integer> {
	
	//이름을 가지고 QR code 찾api
	//같은 이름을 가진 사람들이 여러명일 수 있기 때문에 list로.
	ArrayList<QRcode> findByUsrname(String usrname);
	
	//@Query(value = "select * from QRCODE where usrname = ?1 and qrname = ?2 and int id =?3", nativeQuery = true)
	//ArrayList<QRcodeMapping> findByUsrnameAndQrnameAndId(String usrname, String qrname, int id);
		
	

}

