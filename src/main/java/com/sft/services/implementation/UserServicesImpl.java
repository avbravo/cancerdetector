/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import com.sft.model.User;
import com.sft.services.UserServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.sft.restclient.UserRestClient;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class UserServicesImpl implements UserServices {
    // <editor-fold defaultstate="collapsed" desc="@Inject">

    @Inject
    JmoordbResourcesFiles rf;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    UserRestClient userRestClient;
// </editor-fold>

    @Override
    public List<User> findAll() {
        return userRestClient.findAll();
    }

    @Override
    public Optional<User> findByIduser(Long iduser) {
        try {
            User user = userRestClient.findByIduser(iduser);
            if (user == null || user.getIduser() == null) {

            } else {
                return Optional.of(user);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        try {
            User user = userRestClient.findByUsername(username);
            if (user == null || user.getIduser() == null) {

            } else {
                return Optional.of(user);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try {
            User user = userRestClient.findByEmail(email);
            if (user == null || user.getIduser() == null) {

            } else {
                return Optional.of(user);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();

    }

    @Override
    public Optional<User> findByIdentificationcard(String identificationcard) {
        try {
            User user = userRestClient.findByIdentificationcard(identificationcard);
            if (user == null || user.getIduser() == null) {

            } else {

                return Optional.of(user);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
      
        return Optional.empty();

    }

    // <editor-fold defaultstate="collapsed" desc="Optional<User> save(User user)">
    @Override
    public Optional<User> save(User user) {

        try {

            Response response = userRestClient.save(user);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

            User result = (User) (response.readEntity(User.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean update(User user)">
    @Override
    public Boolean update(User user) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = userRestClient.update(user).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean delete(Long iduser)">
    @Override
    public Boolean delete(Long iduser) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = userRestClient.delete(iduser).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<User> lookup(Bson filter, Document sort, Integer page, Integer size)">
    @Override
    public List<User> lookup(Bson filter, Document sort, Integer page, Integer size) {
        List<User> userList = new ArrayList<>();
        try {
            userList = userRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return userList;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size)">

    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
        Long result = 0L;
        try {
            result = userRestClient.count(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<User> likeByName(String name)">
    @Override
    public List<User> likeByName(String name) {
        return userRestClient.likeByName(name);
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean validEmail(String email)">
    @Override
    public Boolean validEmail(String email) {
        Boolean result = Boolean.FALSE;
        try {
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            result = matcher.find();

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean validPassword(String password)">
    @Override
    public Boolean validPassword(String password) {
        Boolean result = Boolean.FALSE;
        try {
            Pattern pattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@.#$%*_?!]).{9,50})", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(password);
            result = matcher.find();

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BBoolean validUser(User userSelected, String passwordRepetido)">
    @Override
    public Boolean validUser(User userSelected, String passwordRepetido) {
        Boolean result = Boolean.FALSE;
        try {
            if (userSelected.getUsername() == null || userSelected.getUsername().equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.username"));
                return result;
            }
            if (userSelected.getName() == null || userSelected.getName().equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.name"));
                return result;
            }
            if (userSelected.getName() == null || userSelected.getName().equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.name"));
                return result;
            }
            if (userSelected.getIdentificationcard() == null || userSelected.getIdentificationcard().equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.identificationcard"));
                return result;
            }
            if (userSelected.getCentralView() == null || userSelected.getCentralView().getCentral().equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.centralview"));
                return result;
            }
            if (userSelected.getPassword() == null || userSelected.getPassword().equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.ingresepassword"));
                return result;
            }
            if (passwordRepetido == null || passwordRepetido.equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.ingresepasswordrepetido" + ""));
                return result;
            }
            if (!userSelected.getPassword().equals(passwordRepetido)) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("formato.passwordnoigual"));
                return result;
            }
            if (!validPassword(userSelected.getPassword())) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("formato.passwordnocumple"));
                return result;
            }
            if (!validPassword(passwordRepetido)) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("formato.passwordrepetidonocumple"));
                return result;
            }

            if (!validEmail(userSelected.getEmail())) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("formato.emailnovalido"));
                return result;
            }
            result = Boolean.TRUE;

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
}
