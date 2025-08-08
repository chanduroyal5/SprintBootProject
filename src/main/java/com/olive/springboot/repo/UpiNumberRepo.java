package com.olive.springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olive.springboot.entity.UpiNumberDetails;

@Repository
public interface UpiNumberRepo extends JpaRepository<UpiNumberDetails, Long> {

	UpiNumberDetails findByUpiNumberAndVpa(String upi,String vpa);
	UpiNumberDetails findByUpiNumberAndCustomerid(String upi,String customerid);
	List<UpiNumberDetails> findByCustomeridAndVpaAndStatus(String customerid, String vpa,String status);
	List<UpiNumberDetails> findAllByCustomerid(String customerid);
	List<UpiNumberDetails> findAllByVpa(String vpa);
	List<UpiNumberDetails> findByUpiNumber(String upi);
}