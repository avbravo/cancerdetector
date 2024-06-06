package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class DividerView implements Serializable {

    private final String block1 = "<div class=\"flex w-full relative align-items-center justify-content-start my-3 px-4\">\n" +
            "    <div class=\"border-top-1 border-300 top-50 left-0 absolute w-full\"></div>\n" +
            "    <div class=\"px-2 z-1 surface-0 flex align-items-center\">\n" +
            "        <i class=\"pi pi-search text-900 mr-2\"/>\n" +
            "        <span class=\"text-900 font-medium\">Title Placeholder</span>\n" +
            "    </div>\n" +
            "</div>" ;
    
    private final String block2 = "<div class=\"flex w-full relative align-items-center justify-content-center my-3 px-4\">\n" +
            "    <div class=\"border-top-1 border-300 top-50 left-0 absolute w-full\"></div>\n" +
            "    <div class=\"px-2 z-1 surface-0 flex align-items-center\">\n" +
            "        <i class=\"pi pi-search text-900 mr-2\"/>\n" +
            "        <span class=\"text-900 font-medium\">Title Placeholder</span>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block3 = "<div class=\"flex w-full relative align-items-center justify-content-end my-3 px-4\">\n" +
            "    <div class=\"border-top-1 border-300 top-50 left-0 absolute w-full\"></div>\n" +
            "    <div class=\"px-2 z-1 surface-0 flex align-items-center\">\n" +
            "        <i class=\"pi pi-search text-900 mr-2\"/>\n" +
            "        <span class=\"text-900 font-medium\">Title Placeholder</span>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block4 = "<div class=\"flex w-full relative align-items-center justify-content-between my-3 px-4\">\n" +
            "    <div class=\"border-top-1 border-300 top-50 left-0 absolute w-full\"></div>\n" +
            "    <div class=\"px-2 z-1 surface-0 flex align-items-center\">\n" +
            "        <i class=\"pi pi-list text-900 mr-2\"/>\n" +
            "        <span class=\"text-900 font-medium\">Results</span>\n" +
            "    </div>\n" +
            "    <p:commandButton type=\"button\" value=\"Search\" icon=\"pi pi-search ml-2\"\n" +
            "                     styleClass=\"rounded-button pl-2\"/>\n" +
            "</div>" ;

    private final String block5 = "<div class=\"flex\">\n" +
            "    <div class=\"w-5 py-8 text-center flex align-items-center justify-content-center\">\n" +
            "        <p:commandButton type=\"button\" value=\"Login\" icon=\"pi pi-user ml-2\"\n" +
            "                         styleClass=\"rounded-button ui-button-outlined pl-2\"/>\n" +
            "    </div>\n" +
            "    <div class=\"w-2\">\n" +
            "        <div class=\"flex relative align-items-center justify-content-center mx-3 py-3 min-h-full\">\n" +
            "            <div class=\"border-left-1 border-300 top-0 left-50 absolute h-full\"></div>\n" +
            "            <div class=\"py-2 z-1 surface-0\">\n" +
            "                <span class=\"text-900 font-medium\">OR</span>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"w-5 py-8 flex align-items-center justify-content-center\">\n" +
            "        <p:commandButton type=\"button\" value=\"Sign Up\" styleClass=\"rounded-button ui-button-success\"/>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block6 = "<div class=\"flex my-3 px-4 justify-content-center relative\">\n" +
            "    <div class=\"border-top-1 surface-border absolute top-50 w-full\"></div>\n" +
            "    <span class=\"ui-buttonset z-1\">\n" +
            "        <p:commandButton type=\"button\" icon=\"pi pi-star text-600\" styleClass=\"appearance-none border-1 border-round-left surface-border surface-0 hover:surface-200 active:surface-300 cursor-pointer\"/>\n" +
            "        <p:commandButton type=\"button\" icon=\"pi pi-lock text-600\" styleClass=\"appearance-none border-1 border-left-none surface-border surface-0 hover:surface-200 active:surface-300 cursor-pointer\"/>\n" +
            "        <p:commandButton type=\"button\" icon=\"pi pi-pencil text-600\" styleClass=\"appearance-none border-1 border-left-none surface-border surface-0 hover:surface-200 active:surface-300 cursor-pointer\"/>\n" +
            "        <p:commandButton type=\"button\" icon=\"pi pi-trash text-600\" styleClass=\"appearance-none border-1 border-left-none border-round-right surface-border surface-0 hover:surface-200 active:surface-300 cursor-pointer\"/>\n" +
            "    </span>\n" +
            "</div>\n" ;

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

    public String getBlock6() {
        return block6;
    }
}
