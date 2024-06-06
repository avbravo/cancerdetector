/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.commons.emails;
// <editor-fold defaultstate="collapsed" desc="import">

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbCoreContext;

import com.avbravo.jmoordbutils.email.EmailRecipients;
import com.sft.model.Applicative;
import com.sft.model.Emailconfiguration;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Stateless;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
// </editor-fold>

/**
 *
 * @author avbravo
 */
@Stateless
public class EmailSenderListener {

    // <editor-fold defaultstate="collapsed" desc="field">
    private Applicative applicative = new Applicative();

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="@Inject)">
    @Inject
    JmoordbResourcesFiles rf;
    @Inject
    EmailServices emailServices;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" init()">

    @PostConstruct
    public void init() {
        try {
            applicative = (Applicative) JmoordbCoreContext.get("LoginFaces.applicative");
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void listenerEvent(@Observes EmailSenderEvent emailSenderevt)">
    public void listenerEvent(@Observes EmailSenderEvent emailSenderevt) {
        try {
            

            EmailSender emailSender = emailSenderevt.getEmailSender();

            List<Emailconfiguration> emailconfigurationList = applicative.getEmailconfiguration();

            if (emailconfigurationList == null || emailconfigurationList.isEmpty()) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.nohayregistrosemailconfiguration"));
                return;
            }

            Optional<Emailconfiguration> emailconfigurationOptional = emailconfigurationList.stream().filter(x -> x.getActive().equals(Boolean.TRUE)).findFirst();

            if (!emailconfigurationOptional.isPresent()) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.nohayregistrosemailconfigurationactivos"));
                return;
            }

            if (emailSender == null) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.emailsendernull"));
                return;
            }

            /**
             * Agrega el de configuracion como retimente
             */
//                     
//            var newEmail = emailconfigurationOptional.get().getEmail();
//
//
//            List<String> list = new ArrayList<>();
//            for (String s : emailSender.getEmailList()) {
//
//                list.add(s);
//            }
//
//            list.add(newEmail);
//
//            emailSender.setEmailList(list);


            EmailRecipients emailRecipients = FacesUtil.divideDestinatary(emailSender.getEmailList());

            if (emailSender.getPathFile() == null || emailSender.getPathFile().equals("")) {

                Future<String> completableFutureCC = emailServices.sendEmailCccBccAsync(
                        emailRecipients.getTo(),
                        emailRecipients.getCc(),
                        emailRecipients.getBcc(),
                        emailSender.getHeader(),
                        emailSender.getMessages()
                );

            } else {

                Future<String> completableFutureCC = emailServices.sendEmailCccBccWithFileAsync(
                        emailRecipients.getTo(),
                        emailRecipients.getCc(),
                        emailRecipients.getBcc(),
                        emailSender.getHeader(),
                        emailSender.getMessages(),
                        emailSender.getPathFile(),
                        emailSender.getNameFile()
                );

            }

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());

        }

    }
    // </editor-fold>

}
