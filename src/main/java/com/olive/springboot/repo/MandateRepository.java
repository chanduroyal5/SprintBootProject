package com.olive.springboot.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olive.springboot.entity.Mandates;

@Repository
public interface MandateRepository extends JpaRepository<Mandates, Long>{
	
    List<Mandates> findByPayerMobileAndCreatedDateBetween(String payerMobile, Date startDate, Date endDate);
    List<Mandates> findByPayerMobileAndCreatedDateBetweenAndPurposeCode(String payerMobile, Date startDate, Date endDate, String purposeCode);
    List<Mandates> findByPayerMobileAndCreatedDateBetweenAndPurposeCodeIn(String payerMobile, Date startDate, Date endDate, String [] purposeCode);

}
