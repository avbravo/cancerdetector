package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class PanelView implements Serializable {

    private final String block1 = "<div class=\"surface-card p-4 shadow-2 border-round\">\n" +
            "    <div class=\"border-2 border-dashed surface-border border-round\" style=\"min-height: 20rem\"></div>\n" +
            "</div>" ;
    
    private final String block2 = "<div class=\"surface-card p-4 shadow-2 border-round\">\n" +
            "    <div class=\"border-2 border-dashed surface-border border-round mb-3 p-4\"></div>\n" +
            "    <div class=\"border-2 border-dashed surface-border border-round p-4\" style=\"min-height: 20rem\"></div>\n" +
            "</div>" ;

    private final String block3 = "<div class=\"surface-card p-4 shadow-2 border-round\">\n" +
            "    <div class=\"border-2 border-dashed surface-border border-round p-4\" style=\"min-height: 20rem\"></div>\n" +
            "    <div class=\"border-2 border-dashed surface-border border-round mt-3 p-4\"></div>\n" +
            "</div>" ;

    private final String block4 = "<div class=\"surface-card p-4 shadow-2 border-round\">\n" +
            "    <div class=\"border-2 border-dashed surface-border border-round mb-3 p-4\"></div>\n" +
            "    <div class=\"border-2 border-dashed surface-border border-round p-4\" style=\"min-height: 20rem\"></div>\n" +
            "    <div class=\"border-2 border-dashed surface-border border-round mt-3 p-4\"></div>\n" +
            "</div>" ;

    public String getBlock1() {
        return block1;
    }

    public String getBlock2() {
        return block2;
    }

    public String getBlock3() {
        return block3;
    }

    public String getBlock4() {
        return block4;
    }
}
