/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.sft.model.Otp;
import jakarta.ws.rs.QueryParam;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public interface OtpServices {

    public Optional<Otp> findByIdotp(Long idotp);

    public List<Otp> findByOtp(String otp);
    
    public List<Otp> findByIduser(Long iduser);
    public List<Otp> findByEmail(String email);
    
    
    

    public List<Otp> findAll();

    public Optional<Otp> save(Otp otp);
    
     public Boolean update( Otp otp) ;
     
     public Boolean delete( Long idotp);


    

    public List<Otp> lookup(Bson filter, Document sort, Integer page, Integer size);

    public Long count(Bson filter, Document sort, Integer page, Integer size);
    
          public String showHour(Date date) ;
           public String showDate(Date date);
}
