/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.security.readwebxml;

import com.jmoordb.core.util.ConsoleUtil;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author avbravo
 */
public class ReadWebXML extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadWebXML() {
        super();
// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
// TODO Auto-generated method stub

        try {
            ServletContext servletContext = getServletContext();
            String PROJECT_STAGE= servletContext.getInitParameter("jakarta.faces.PROJECT_STAGE");
            ConsoleUtil.info("=================== ReadWebXML=========================");
          ConsoleUtil.info("[jakarta.faces.PROJECT_STAGE ]"+PROJECT_STAGE);

ConsoleUtil.info("============================================");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
