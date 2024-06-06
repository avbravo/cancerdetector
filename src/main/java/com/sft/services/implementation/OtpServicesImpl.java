/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbCoreDateUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import com.sft.model.Otp;
import com.sft.services.OtpServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.sft.restclient.OtpRestClient;
import java.util.Date;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class OtpServicesImpl implements OtpServices {
    // <editor-fold defaultstate="collapsed" desc="@Inject">

    @Inject
    JmoordbResourcesFiles rf;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    OtpRestClient otpRestClient;
// </editor-fold>

    @Override
    public List<Otp> findAll() {
        return otpRestClient.findAll();
    }

    @Override
    public Optional<Otp> findByIdotp(Long idotp) {
        try {
            Otp otp = otpRestClient.findByIdotp(idotp);
            if (otp == null || otp.getIdotp() == null) {

            } else {
                return Optional.of(otp);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<Otp> findByOtp(String otp) {
          List<Otp> result= new ArrayList<>();
        try {
          result = otpRestClient.findByOtp(otp);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    @Override
    public List<Otp> findByEmail(String email) {
          List<Otp> result= new ArrayList<>();
        try {
          result = otpRestClient.findByEmail(email);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    @Override
    public List<Otp> findByIduser(Long iduser) {
          List<Otp> result= new ArrayList<>();
        try {
          result = otpRestClient.findByIduser(iduser);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

   

    

    // <editor-fold defaultstate="collapsed" desc="Optional<Otp> save(Otp otp)">
    @Override
    public Optional<Otp> save(Otp otp) {

        try {
            Response response = otpRestClient.save(otp);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

            Otp result = (Otp) (response.readEntity(Otp.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean update(Otp otp)">
    @Override
    public Boolean update(Otp otp) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = otpRestClient.update(otp).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean delete(Long idotp)">
    @Override
    public Boolean delete(Long idotp) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = otpRestClient.delete(idotp).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Otp> lookup(Bson filter, Document sort, Integer page, Integer size)">
    @Override
    public List<Otp> lookup(Bson filter, Document sort, Integer page, Integer size) {
        List<Otp> otpList = new ArrayList<>();
        try {
            otpList = otpRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return otpList;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size)">

    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
        Long result = 0L;
        try {
            result = otpRestClient.count(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
   
 // <editor-fold defaultstate="collapsed" desc="String showDate(Date date)">
    @Override
    public String showDate(Date date) {
        String h = "";
        try {
            h = JmoordbCoreDateUtil.dateFormatToString(date, "dd/MM/yyyy");
        
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return h;
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String showHour(Date date)">

    @Override
    public String showHour(Date date) {
        String h = "";
        try {
            h = JmoordbCoreDateUtil.hourFromDateToString(date);
     } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return h;
    }
// </editor-fold> 
}
