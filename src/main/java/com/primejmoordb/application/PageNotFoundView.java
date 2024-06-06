package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class PageNotFoundView implements Serializable {

    private final String block1 =  "<div class=\"surface-section px-4 py-8 md:px-6 lg:px-8\">\n" +
            "    <div style=\"background: radial-gradient(50% 109137.91% at 50% 50%, rgba(233, 30, 99, 0.1) 0%, rgba(254, 244, 247, 0) 100%);\" class=\"text-center\">\n" +
            "        <span class=\"bg-white text-pink-500 font-bold text-2xl inline-block px-3\">404</span>\n" +
            "    </div>\n" +
            "    <div class=\"mt-6 mb-5 font-bold text-6xl text-900 text-center\">Page Not Found</div>\n" +
            "    <p class=\"text-700 text-3xl mt-0 mb-6 text-center\">Sorry, we couldn't find the page.</p>\n" +
            "    <div class=\"text-center\">\n" +
            "        <p:commandButton type=\"button\" value=\"Go Back\" icon=\"pi pi-arrow-left\" styleClass=\"ui-button-flat mr-2\"/>\n" +
            "        <p:commandButton type=\"button\" value=\"Go to Dashboard\" icon=\"pi pi-home\"/>\n" +
            "    </div>\n" +
            "</div>\n" ;
    
    private final String block2 = "<div class=\"flex surface-section\">\n" +
            "    <div class=\"w-12 sm:w-6 px-4 py-8 md:px-6 lg:px-8\">\n" +
            "        <div class=\"border-left-2 border-pink-500\">\n" +
            "            <span class=\"bg-white text-pink-500 font-bold text-2xl inline-block px-3\">404</span>\n" +
            "        </div>\n" +
            "        <div class=\"mt-6 mb-5 font-bold text-6xl text-900\">Page Not Found</div>\n" +
            "        <p class=\"text-700 text-3xl mt-0 mb-6\">Sorry, we couldn't find the page.</p>\n" +
            "        <div>\n" +
            "            <p:commandButton type=\"button\" value=\"Go Back\" icon=\"pi pi-arrow-left\" styleClass=\"ui-button-flat mr-2\"/>\n" +
            "            <p:commandButton type=\"button\" value=\"Go to Dashboard\" icon=\"pi pi-home\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    \n" +
            "    <div class=\"w-6 hidden sm:block\" style=\"background: url(#{resource['primeblocks-app:images/blocks/feedback/404.png']}) no-repeat; background-size: cover\">\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block3 = "<div class=\"surface-ground px-4 py-8 md:px-6 lg:px-8\">\n" +
            "    <div class=\"shadow-2 border-round surface-card px-4 md:px-6 py-6\">\n" +
            "        <div class=\"border-left-2 border-pink-500\">\n" +
            "            <span class=\"bg-white text-pink-500 font-bold text-2xl inline-block px-3\">404</span>\n" +
            "        </div>\n" +
            "        <div class=\"mt-6 mb-5 font-bold text-6xl text-900\">Page Not Found</div>\n" +
            "        <p class=\"text-700 text-3xl mt-0 mb-6\">Sorry, we couldn't find the page.</p>\n" +
            "\n" +
            "        <ul class=\"list-none px-0 pb-0 pt-4 m-0 border-top-1 surface-border\">\n" +
            "            <li class=\"py-2\">\n" +
            "                <a class=\"cursor-pointer flex align-items-center border-round border-1 border-transparent hover:border-300 p-3 transition-colors transition-duration-150\">\n" +
            "                    <span class=\"inline-flex align-items-center justify-content-center bg-indigo-500 border-round flex-shrink-0\" style=\"height:52px;width:52px;\">\n" +
            "                        <i class=\"pi pi-envelope text-white text-3xl\"></i>\n" +
            "                    </span>\n" +
            "                    <div class=\"ml-3\">\n" +
            "                        <span class=\"text-900 font-medium text-2xl mb-3\">Messages</span>\n" +
            "                        <p class=\"text-600 m-0 line-height-3\">Sed egestas egestas fringilla</p>\n" +
            "                    </div>\n" +
            "                    <i class=\"text-600 pi pi-chevron-right ml-auto\"></i>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li class=\"py-2\">\n" +
            "                <a class=\"cursor-pointer flex align-items-center border-round border-1 border-transparent hover:border-300 p-3 transition-colors transition-duration-150\">\n" +
            "                    <span class=\"inline-flex align-items-center justify-content-center bg-orange-500 border-round flex-shrink-0\" style=\"height:52px;width:52px;\">\n" +
            "                        <i class=\"pi pi-chart-bar text-white text-3xl\"></i>\n" +
            "                    </span>\n" +
            "                    <div class=\"ml-3\">\n" +
            "                        <span class=\"text-900 font-medium text-2xl mb-3\">Dashboard</span>\n" +
            "                        <p class=\"text-600 m-0 line-height-3\">Eu Ornare quam viverra orci sagittis odio</p>\n" +
            "                    </div>\n" +
            "                    <i class=\"text-600 pi pi-chevron-right ml-auto\"></i>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li class=\"pt-2\">\n" +
            "                <a class=\"cursor-pointer flex align-items-center border-round border-1 border-transparent hover:border-300 p-3 transition-colors transition-duration-150\">\n" +
            "                    <span class=\"inline-flex align-items-center justify-content-center bg-cyan-500 border-round flex-shrink-0\" style=\"height:52px;width:52px;\">\n" +
            "                        <i class=\"pi pi-cog text-white text-3xl\"></i>\n" +
            "                    </span>\n" +
            "                    <div class=\"ml-3\">\n" +
            "                        <span class=\"text-900 font-medium text-2xl mb-3\">Settings</span>\n" +
            "                        <p class=\"text-600 m-0 line-height-3\">Tincidunt nunc pulvinar sapien et</p>\n" +
            "                    </div>\n" +
            "                    <i class=\"text-600 pi pi-chevron-right ml-auto\"></i>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "        </ul>\n" +
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
