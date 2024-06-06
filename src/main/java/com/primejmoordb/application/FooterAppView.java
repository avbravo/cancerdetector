package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class FooterAppView implements Serializable {

    private final String block1 = "<div class=\"surface-section py-6 flex flex-column sm:flex-row sm:align-items-center justify-content-between\">\n" +
            "    <div>\n" +
            "        <p:graphicImage name=\"images/blocks/logos/bastion-700.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                        height=\"40\"/>\n" +
            "        <div class=\"mt-2 line-height-3\">&#169; 2021 Bastion, Inc. All rights reserved</div>\n" +
            "    </div>\n" +
            "    <div class=\"mt-3 sm:mt-0\">\n" +
            "        <a class=\"cursor-pointer text-500 transition-colors transition-duration-150 hover:text-700\">\n" +
            "            <i class=\"pi pi-twitter text-xl\"/>\n" +
            "        </a>\n" +
            "        <a class=\"cursor-pointer text-500 ml-3 transition-colors transition-duration-150 hover:text-700\">\n" +
            "            <i class=\"pi pi-facebook text-xl\"/>\n" +
            "        </a>\n" +
            "        <a class=\"cursor-pointer text-500 ml-3 transition-colors transition-duration-150 hover:text-700\">\n" +
            "            <i class=\"pi pi-github text-xl\"/>\n" +
            "        </a>\n" +
            "    </div>\n" +
            "</div>" ;
    
    private final String block2 = "<div class=\"surface-section py-6 flex flex-column sm:flex-row align-items-center justify-content-between\">\n" +
            "    <div class=\"flex flex-nowap font-medium\">\n" +
            "        <a class=\"cursor-pointer block text-700 py-2 px-3 transition-colors transition-duration-150 hover:surface-300 border-round hover:text-900\">HOME</a>\n" +
            "        <a class=\"cursor-pointer block text-700 py-2 px-3 transition-colors transition-duration-150 hover:surface-300 border-round hover:text-900\">ABOUT</a>\n" +
            "        <a class=\"cursor-pointer block text-700 py-2 px-3 transition-colors transition-duration-150 hover:surface-300 border-round hover:text-900\">CONTACT</a>\n" +
            "    </div>\n" +
            "    <div class=\"mt-3 sm:mt-0\">\n" +
            "        <p:graphicImage name=\"images/blocks/logos/bastion-700.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                        height=\"40\"/>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block3 = "<div class=\"surface-section px-4 py-6 md:px-6 lg:px-8 text-center\">\n" +
            "    <p:graphicImage name=\"images/blocks/logos/bastion-purple.svg\" library=\"primeblocks-app\" alt=\"Image\" height=\"50\"/>\n" +
            "    <div class=\"font-medium text-900 mt-4 mb-3\">&#169; 2023 Bastion, Inc</div>\n" +
            "    <p class=\"text-600 line-height-3 mt-0 mb-4\">Cursus metus aliquam eleifend mi. Malesuada pellentesque elit eget gravida. Nunc eget lorem dolor sed viverra ipsum nunc aliquet bibendum. Massa tincidunt dui ut ornare lectus sit amet est placerat.</p>\n" +
            "    <div class=\"flex align-items-center justify-content-center\">\n" +
            "        <a class=\"cursor-pointer text-700 mr-5\">\n" +
            "            <i class=\"pi pi-twitter\"></i>\n" +
            "        </a>\n" +
            "        <a class=\"cursor-pointer text-700 mr-5\">\n" +
            "            <i class=\"pi pi-facebook\"></i>\n" +
            "        </a>\n" +
            "        <a class=\"cursor-pointer text-700\">\n" +
            "            <i class=\"pi pi-github\"></i>\n" +
            "        </a>\n" +
            "    </div>\n" +
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
}
