package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ContainerView implements Serializable {

    private final String block1 = "<div class=\"p-4\">\n" +
            "    <div class=\"border-2 border-dashed surface-border border-round surface-card\"\n" +
            "         style=\"min-height: 20rem\"></div>\n" +
            "</div>" ;
    
    private final String block2 = "<div class=\"px-4 py-8 md:px-6 lg:px-8\">\n" +
            "    <div class=\"border-2 border-dashed surface-border border-round surface-card\"\n" +
            "         style=\"min-height: 20rem\"></div>\n" +
            "</div>" ;

    private final String block3 = "<div class=\"p-4 md:p-6 lg:p-8\">\n" +
            "    <div class=\"border-2 border-dashed surface-border border-round surface-card\"\n" +
            "         style=\"min-height: 20rem\"></div>\n" +
            "</div>" ;

    private final String block4 = "<div class=\"p-0\">\n" +
            "    <div class=\"border-2 border-dashed surface-border border-round surface-card\"\n" +
            "         style=\"min-height: 20rem\"></div>\n" +
            "</div>" ;

    private final String block5 = "<div class=\"px-0 py-4 md:px-4\">\n" +
            "    <div class=\"border-2 border-dashed surface-border border-round surface-card\"\n" +
            "         style=\"min-height: 20rem\"></div>\n" +
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

    public String getBlock5() {
        return block5;
    }
}
