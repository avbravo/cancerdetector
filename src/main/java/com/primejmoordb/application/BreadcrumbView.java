package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class BreadcrumbView implements Serializable {

    private final String block1 = "<ul class=\"list-none p-3 m-0 surface-card flex align-items-center font-medium overflow-x-auto\">\n" +
            "    <li class=\"pr-3\">\n" +
            "        <a class=\"cursor-pointer\">\n" +
            "            <i class=\"pi pi-home text-blue-500\"/>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"px-2\">\n" +
            "        <i class=\"pi pi-angle-right text-500\"/>\n" +
            "    </li>\n" +
            "    <li class=\"px-2\">\n" +
            "        <a class=\"cursor-pointer text-blue-500 white-space-nowrap\">Level 3</a>\n" +
            "    </li>\n" +
            "    <li class=\"px-2\">\n" +
            "        <i class=\"pi pi-angle-right text-500\"/>\n" +
            "    </li>\n" +
            "    <li class=\"px-2\">\n" +
            "        <a class=\"cursor-pointer text-blue-500 white-space-nowrap\">Level 2</a>\n" +
            "    </li>\n" +
            "    <li class=\"px-2\">\n" +
            "        <i class=\"pi pi-angle-right text-500\"/>\n" +
            "    </li>\n" +
            "    <li class=\"px-2\">\n" +
            "        <a class=\"cursor-pointer text-900 white-space-nowrap\">Level 1</a>\n" +
            "    </li>\n" +
            "</ul>" ;

    private final String block2 = "<ul class=\"list-none p-0 m-0 surface-card flex font-medium overflow-y-hidden overflow-x-auto\">\n" +
            "    <li class=\"relative p-3\">\n" +
            "        <a class=\"cursor-pointer\">\n" +
            "            <i class=\"pi pi-home text-blue-500\"/>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"relative p-3\">\n" +
            "        <div class=\"absolute left-0 top-0 z-1\"\n" +
            "             style=\"border-left: 20px solid var(--surface-card); border-top: 26px solid transparent; border-bottom: 26px solid transparent; width: 0; height: 0\"></div>\n" +
            "        <a class=\"cursor-pointer text-blue-500 pl-4 white-space-nowrap\">Level 3</a>\n" +
            "        <div class=\"absolute top-0\"\n" +
            "             style=\"left: 1px; border-left: 20px solid var(--surface-border); border-top: 26px solid transparent; border-bottom: 26px solid transparent; width: 0; height: 0\"></div>\n" +
            "    </li>\n" +
            "    <li class=\"relative p-3\">\n" +
            "        <div class=\"absolute left-0 top-0 z-1\"\n" +
            "             style=\"border-left: 20px solid var(--surface-card); border-top: 26px solid transparent; border-bottom: 26px solid transparent; width: 0; height: 0\"></div>\n" +
            "        <a class=\"cursor-pointer text-blue-500 pl-4 white-space-nowrap\">Level 2</a>\n" +
            "        <div class=\"absolute top-0\"\n" +
            "             style=\"left: 1px; border-left: 20px solid var(--surface-border); border-top: 26px solid transparent; border-bottom: 26px solid transparent; width: 0; height: 0\"></div>\n" +
            "    </li>\n" +
            "    <li class=\"relative p-3\">\n" +
            "        <div class=\"absolute left-0 top-0 z-1\"\n" +
            "             style=\"border-left: 20px solid var(--surface-card); border-top: 26px solid transparent; border-bottom: 26px solid transparent; width: 0; height: 0\"></div>\n" +
            "        <a class=\"cursor-pointer text-900 pl-4 white-space-nowrap\">Level 1</a>\n" +
            "        <div class=\"absolute top-0\"\n" +
            "             style=\"left: 1px; border-left: 20px solid var(--surface-border); border-top: 26px solid transparent; border-bottom: 26px solid transparent; width: 0; height: 0\"></div>\n" +
            "    </li>\n" +
            "</ul>" ;

    private final String block3 = "<ul class=\"list-none p-0 m-0 flex font-medium overflow-y-hidden overflow-x-auto border-round shadow-2\">\n" +
            "    <li class=\"relative p-3 bg-indigo-500\">\n" +
            "        <a class=\"cursor-pointer\">\n" +
            "            <i class=\"pi pi-home text-white\"></i>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"relative p-3 bg-indigo-500\">\n" +
            "        <div class=\"absolute left-0 top-0 z-1\" style=\"border-left: 20px solid var(--indigo-500); border-top: 26px solid transparent; border-bottom: 26px solid transparent; width: 0; height: 0\"></div>\n" +
            "        <a class=\"cursor-pointer text-white pl-4 white-space-nowrap\">Level 3</a>\n" +
            "        <div class=\"absolute top-0\" style=\"left: 1px; border-left: 20px solid var(--indigo-100); border-top: 26px solid transparent; border-bottom: 26px solid transparent; width: 0; height: 0\"></div>\n" +
            "    </li>\n" +
            "    <li class=\"relative p-3 bg-indigo-500\">\n" +
            "        <div class=\"absolute left-0 top-0 z-1\" style=\"border-left: 20px solid var(--indigo-500); border-top: 26px solid transparent; border-bottom: 26px solid transparent; width: 0; height: 0\"></div>\n" +
            "        <a class=\"cursor-pointer text-white pl-4 white-space-nowrap\">Level 2</a>\n" +
            "        <div class=\"absolute top-0\" style=\"left: 1px; border-left: 20px solid var(--indigo-100); border-top: 26px solid transparent; border-bottom: 26px solid transparent; width: 0; height: 0\"></div>\n" +
            "    </li>\n" +
            "    <li class=\"relative p-3 bg-indigo-700\">\n" +
            "        <div class=\"absolute left-0 top-0 z-1\" style=\"border-left: 20px solid var(--indigo-500); border-top: 26px solid transparent; border-bottom: 26px solid transparent; width: 0; height: 0\"></div>\n" +
            "        <a class=\"cursor-pointer text-indigo-100 font-bold pl-4 white-space-nowrap\">Level 1</a>\n" +
            "        <div class=\"absolute top-0\" style=\"left: 1px; border-left: 20px solid var(--indigo-100); border-top: 26px solid transparent; border-bottom: 26px solid transparent; width: 0; height: 0\"></div>\n" +
            "    </li>\n" +
            "</ul>\n" ;

    private final String block4 = "<ul class=\"list-none p-0 m-0 flex font-medium overflow-x-auto\">\n" +
            "    <li class=\"bg-cyan-500 z-5\">\n" +
            "        <a class=\"cursor-pointer bg-cyan-500 flex align-items-center justify-content-center px-5 py-3 shadow-2 h-full\" style=\"border-top-right-radius: 30px; border-bottom-right-radius: 30px\">\n" +
            "            <i class=\"pi pi-home text-white\"></i>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"bg-cyan-500 z-4\">\n" +
            "        <a class=\"cursor-pointer bg-cyan-500 flex align-items-center justify-content-center px-5 py-3 text-white white-space-nowrap shadow-2 h-full\" style=\"border-top-right-radius: 30px; border-bottom-right-radius: 30px\">\n" +
            "            Level 3\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"surface-card z-3\">\n" +
            "        <a class=\"cursor-pointer bg-cyan-500 flex align-items-center justify-content-center px-5 py-3 text-white white-space-nowrap shadow-2 h-full\" style=\"border-top-right-radius: 30px; border-bottom-right-radius: 30px\">\n" +
            "            Level 2\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li>\n" +
            "        <a class=\"cursor-pointer text-cyan-700 flex align-items-center justify-content-center px-5 py-3 surface-card white-space-nowrap h-full\" style=\"border-top-right-radius: 30px; border-bottom-right-radius: 30px\">\n" +
            "            Level 1\n" +
            "        </a>\n" +
            "    </li>\n" +
            "</ul>\n" ;

    private final String block5 = "<ul class=\"list-none p-3 m-0 surface-card flex align-items-center font-medium overflow-x-auto\">\n" +
            "    <li class=\"pr-3\">\n" +
            "        <a class=\"cursor-pointer\">\n" +
            "            <i class=\"pi pi-home text-blue-500\"></i>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"px-2\">\n" +
            "        <span class=\"text-400\">/</span>\n" +
            "    </li>\n" +
            "    <li class=\"px-2\">\n" +
            "        <a class=\"cursor-pointer text-blue-500 white-space-nowrap\">Level 3</a>\n" +
            "    </li>\n" +
            "    <li class=\"px-2\">\n" +
            "        <span class=\"text-400\">/</span>\n" +
            "    </li>\n" +
            "    <li class=\"px-2\">\n" +
            "        <a class=\"cursor-pointer text-blue-500 white-space-nowrap\">Level 2</a>\n" +
            "    </li>\n" +
            "    <li class=\"px-2\">\n" +
            "        <span class=\"text-400\">/</span>\n" +
            "    </li>\n" +
            "    <li class=\"px-2\">\n" +
            "        <a class=\"cursor-pointer text-900 white-space-nowrap\">Level 1</a>\n" +
            "    </li>\n" +
            "</ul>\n" ;

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
