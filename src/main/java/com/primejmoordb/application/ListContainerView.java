package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ListContainerView implements Serializable {

    private final String block1 = "<ul class=\"list-none p-0 m-0\">\n" +
            "    <li class=\"pb-4 border-bottom-1 border-300\">\n" +
            "        <div class=\"border-2 border-dashed border-300 border-round surface-0 p-4\"></div>\n" +
            "    </li>\n" +
            "    <li class=\"py-4 border-bottom-1 border-300\">\n" +
            "        <div class=\"border-2 border-dashed border-300 border-round surface-0 p-4\"></div>\n" +
            "    </li>\n" +
            "    <li class=\"pt-4\">\n" +
            "        <div class=\"border-2 border-dashed border-300 border-round surface-0 p-4\"></div>\n" +
            "    </li>\n" +
            "</ul>" ;
    
    private final String block2 = "<div class=\"surface-0 p-4 shadow-2 border-round\">\n" +
            "    <ul class=\"list-none p-0 m-0\">\n" +
            "        <li class=\"pb-4 border-bottom-1 border-300\">\n" +
            "            <div class=\"border-2 border-dashed border-300 border-round surface-0 p-4\"></div>\n" +
            "        </li>\n" +
            "        <li class=\"py-4 border-bottom-1 border-300\">\n" +
            "            <div class=\"border-2 border-dashed border-300 border-round surface-0 p-4\"></div>\n" +
            "        </li>\n" +
            "        <li class=\"pt-4\">\n" +
            "            <div class=\"border-2 border-dashed border-300 border-round surface-0 p-4\"></div>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "</div>" ;

    private final String block3 = "<ul class=\"list-none p-0 m-0\">\n" +
            "    <li class=\"surface-0 p-4 mb-3 shadow-2 border-round\">\n" +
            "        <div class=\"border-2 border-dashed border-300 border-round surface-0 p-4\"></div>\n" +
            "    </li>\n" +
            "    <li class=\"surface-0 p-4 mb-3 shadow-2 border-round\">\n" +
            "        <div class=\"border-2 border-dashed border-300 border-round surface-0 p-4\"></div>\n" +
            "    </li>\n" +
            "    <li class=\"surface-0 p-4 shadow-2 border-round\">\n" +
            "        <div class=\"border-2 border-dashed border-300 border-round surface-0 p-4\"></div>\n" +
            "    </li>\n" +
            "</ul>" ;

    public String getBlock1() {
        return block1;
    }

    public String getBlock2() {
        return block2;
    }

    public String getBlock3() {
        return block3;
    }
}
