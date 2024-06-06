/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.security;

/**
 *
 * @author avbravo
 */
public interface SecurityGranted {
    
    // <editor-fold defaultstate="collapsed" desc="Boolean ifGranted(String event)">

    /**
     * Valida en base a un event indicado que se pasa desde una pagina xhtml
     * En el login se cargan:
     * - applicativeLogged
     * - applicativeroleLogged
     * - profileLogged
     * Usaremos para validar applicativeprivilege y applicativeroleLogged
     * @param event
     * @return 
     */
//  default List<String> ifGranted(String event){
//      List<String> rolesAllow = new ArrayList<>();
//      try {
//           Applicative applicative =(Applicative)JmoordbCoreContext.get("LoginFaces.applicativeLogged");
//           
//          Applicativerole applicativeroleLogged =(Applicativerole)JmoordbCoreContext.get("LoginFaces.applicativeroleLogged");
//          
//         
//          Boolean found = Boolean.FALSE;
//          for(Applicativeprivilege applicativeprivilege:applicative.getApplicativeprivilege()){
//              if(applicativeprivilege.getActive() 
//                      && applicativeprivilege.getEvent().equals(event)
//                      && applicativeroleLogged.getIdrole().equals(applicativeprivilege.getIdrole())){
//                  rolesAllow.add(applicativeprivilege.)
//                  
//              }
//                      
//          }
//          
//       } catch (Exception e) {
//         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
//        }
//        return result;
//  }
  // </editor-fold>
}
