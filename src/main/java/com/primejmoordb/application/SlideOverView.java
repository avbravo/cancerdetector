package com.primejmoordb.application;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@Named
@ViewScoped
public class SlideOverView implements Serializable {

    private int userIndex = 3;

    private Map<Integer, User> users;

    private final String block1 = "<p:commandButton type=\"button\" value=\"Display\" icon=\"pi pi-arrow-right\"\n" +
            "                 pt:data-pb-styleclass=\"{ selector: '@next', toggleClass: '-translate-x-100', hideOnOutsideClick: true }\"/>\n" +
            "<div class=\"surface-overlay flex flex-column p-4 h-full absolute top-0 left-0 shadow-2\n" +
            "    -translate-x-100 transition-transform transition-duration-150 transition-ease-in-out w-18rem\">\n" +
            "    <div class=\"flex align-items-center justify-content-between mb-4\">\n" +
            "        <span class=\"text-900 text-xl font-medium\">Title Placeholder</span>\n" +
            "        <p:commandButton type=\"button\" icon=\"pi pi-times\"\n" +
            "                         styleClass=\"rounded-button ui-button-flat ui-button-plain\"\n" +
            "                         pt:data-pb-styleclass=\"{ selector: '@grandparent', toggleClass: '-translate-x-100' }\"/>\n" +
            "    </div>\n" +
            "    <div class=\"border-2 border-dashed surface-border flex-auto overflow-y-auto p-3\"></div>\n" +
            "</div>" ;
    
    private final String block2 = "<p:commandButton type=\"button\" value=\"Display\" icon=\"pi pi-arrow-left\"\n" +
            "                 pt:data-pb-styleclass=\"{ selector: '@next', toggleClass: 'translate-x-100', hideOnOutsideClick: true }\"/>\n" +
            "<div class=\"surface-overlay flex flex-column p-4 h-full absolute top-0 right-0 shadow-2\n" +
            "    translate-x-100 transition-transform transition-duration-150 transition-ease-in-out w-18rem\">\n" +
            "    <div class=\"flex align-items-center justify-content-between mb-4\">\n" +
            "        <span class=\"text-900 text-xl font-medium\">Title Placeholder</span>\n" +
            "        <p:commandButton type=\"button\" icon=\"pi pi-times\"\n" +
            "                         styleClass=\"rounded-button ui-button-flat ui-button-plain\"\n" +
            "                         pt:data-pb-styleclass=\"{ selector: '@grandparent', toggleClass: 'translate-x-100' }\"/>\n" +
            "    </div>\n" +
            "    <div class=\"border-2 border-dashed surface-border flex-auto overflow-y-auto p-3\"></div>\n" +
            "</div>" ;

    private final String block3 = "<p:commandButton type=\"button\" value=\"Display\" icon=\"pi pi-arrow-left\"\n" +
            "                 pt:data-pb-styleclass=\"{ selector: '@next', toggleClass: 'translate-x-100', hideOnOutsideClick: true }\"/>\n" +
            "<div class=\"surface-overlay flex flex-column p-4 h-full absolute top-0 right-0 shadow-2\n" +
            "    translate-x-100 transition-transform transition-duration-150 transition-ease-in-out w-full lg:w-6\">\n" +
            "    <div class=\"flex align-items-center justify-content-between mb-4\">\n" +
            "        <span class=\"text-900 text-xl font-medium\">Title Placeholder</span>\n" +
            "        <p:commandButton type=\"button\" icon=\"pi pi-times\"\n" +
            "                         styleClass=\"rounded-button ui-button-flat ui-button-plain\"\n" +
            "                         pt:data-pb-styleclass=\"{ selector: '@grandparent', toggleClass: 'translate-x-100' }\"/>\n" +
            "    </div>\n" +
            "    <div class=\"border-2 border-dashed surface-border flex-auto overflow-y-auto p-3\"></div>\n" +
            "</div>" ;

    private final String block4 = "<p:commandButton type=\"button\" value=\"Display\" icon=\"pi pi-arrow-left\"\n" +
            "                 pt:data-pb-styleclass=\"{ selector: '@next', toggleClass: 'translate-x-100', hideOnOutsideClick: true }\"/>\n" +
            "<div id=\"_contrastheader\" class=\"surface-overlay flex flex-column h-full absolute top-0 right-0 shadow-2\n" +
            "    translate-x-100 transition-transform transition-duration-150 transition-ease-in-out w-18rem\">\n" +
            "    <div class=\"flex align-items-start bg-gray-800 justify-content-between p-3\">\n" +
            "        <div>\n" +
            "            <div class=\"text-white text-xl font-medium mb-1\">Title Placeholder</div>\n" +
            "            <p class=\"m-0 p-0 line-height-3 text-gray-400 text-sm\">Vitae turpis massa sed tempus egestas sed sed risus.</p>\n" +
            "        </div>\n" +
            "        <div>\n" +
            "            <p:commandButton type=\"button\" icon=\"pi pi-times\"\n" +
            "                             styleClass=\"rounded-button ui-button-flat ui-button-plain ui-button-warning\"\n" +
            "                             pt:data-pb-styleclass=\"{ selector: '#_contrastheader', toggleClass: 'translate-x-100' }\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"m-4 border-2 border-round border-dashed surface-border flex-auto overflow-y-auto\"></div>\n" +
            "</div>" ;

    private final String block5 = "<div>\n" +
            "    <p:commandButton type=\"button\" value=\"Display\" icon=\"pi pi-arrow-left\"\n" +
            "        pt:data-pb-styleclass=\"{ selector: '@next', toggleClass: 'translate-x-100', hideOnOutsideClick: true }\" />\n" +
            "    <div class=\"surface-overlay flex flex-column p-4 h-full absolute top-0 right-0 shadow-2\n" +
            "    translate-x-100 transition-transform transition-duration-150 transition-ease-in-out w-18rem\">\n" +
            "        <div class=\"flex align-items-center justify-content-between mb-4\">\n" +
            "            <span class=\"text-900 text-xl font-medium\">Title Placeholder</span>\n" +
            "            <p:commandButton type=\"button\" icon=\"pi pi-times\" styleClass=\"rounded-button ui-button-flat ui-button-plain\"\n" +
            "                pt:data-pb-styleclass=\"{ selector: '@grandparent', toggleClass: 'translate-x-100' }\" />\n" +
            "        </div>\n" +
            "        <div class=\"border-2 border-dashed surface-border flex-auto overflow-y-auto p-3\"></div>\n" +
            "        <div class=\"pt-3 border-top-1 surface-border mt-3 flex\">\n" +
            "            <p:commandButton value=\"Cancel\" icon=\"pi pi-times\" styleClass=\"ui-button-flat mr-2 flex-auto\"\n" +
            "            pt:data-pb-styleclass=\"{ selector: '@grandparent', leaveToClass: 'hidden',leaveActiveClass: 'fadeoutright', toggleClass: 'translate-x-100'}\"/>\n" +
            "            <p:commandButton value=\"Save\" icon=\"pi pi-check\" styleClass=\"ml-2 flex-auto\"\n" +
            "            pt:data-pb-styleclass=\"{ selector: '@grandparent', leaveToClass: 'hidden',leaveActiveClass: 'fadeoutright', toggleClass: 'translate-x-100'}\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block6 = "<p:commandButton type=\"button\" value=\"Display\" icon=\"pi pi-arrow-left\"\n" +
            "    pt:data-pb-styleclass=\"{ selector: '@next', toggleClass: 'translate-x-100', hideOnOutsideClick: true }\" />\n" +
            "\n" +
            "<div id=\"slideover-6\" class=\"surface-overlay flex flex-column p-4 h-full absolute top-0 right-0 shadow-2\n" +
            "translate-x-100 transition-transform transition-duration-150 transition-ease-in-out\" style=\"width:280px\">\n" +
            "    <div class=\"flex flex-column h-full\">\n" +
            "        <div class=\"flex align-items-center justify-content-between p-4\">\n" +
            "            <div>\n" +
            "                <div class=\"text-900 text-xl font-medium mb-1\">Contacts</div>\n" +
            "                <p class=\"text-600 m-0\">9 People</p>\n" +
            "            </div>\n" +
            "            <p:commandButton type=\"button\" icon=\"pi pi-times\" styleClass=\"rounded-button ui-button-flat ui-button-plain\"\n" +
            "                pt:data-pb-styleclass=\"{ selector: '#slideover-6', toggleClass: 'translate-x-100' }\" />\n" +
            "        </div>\n" +
            "        <div class=\"flex-auto overflow-y-auto\">\n" +
            "            <ul class=\"list-none p-0 m-0\">\n" +
            "                <li class=\"surface-100 font-medium text-xl px-4 py-1 mb-2\">A</li>\n" +
            "                <li class=\"mb-2\">\n" +
            "                    <a class=\"flex align-items-center py-2 px-4 cursor-pointer hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-m-1.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:50px;height:50px\"/>\n" +
            "                        <div>\n" +
            "                            <span class=\"text-900 font-medium mb-2\">Aaron Flore</span>\n" +
            "                            <p class=\"m-0 text-600 text-sm\">Prime Coffee</p>\n" +
            "                        </div>\n" +
            "                        <i class=\"ml-auto pi pi-chevron-right text-700\"></i>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"mb-2\">\n" +
            "                    <a class=\"flex align-items-center py-2 px-4 cursor-pointer hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:50px;height:50px\"/>\n" +
            "                        <div>\n" +
            "                            <span class=\"text-900 font-medium mb-2\">Annette Black</span>\n" +
            "                            <p class=\"m-0 text-600 text-sm\">Bank of Prime</p>\n" +
            "                        </div>\n" +
            "                        <i class=\"ml-auto pi pi-chevron-right text-700\"></i>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"mb-2\">\n" +
            "                    <a class=\"flex align-items-center py-2 px-4 cursor-pointer hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-m-2.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:50px;height:50px\"/>\n" +
            "                        <div>\n" +
            "                            <span class=\"text-900 font-medium mb-2\">Abha Watson</span>\n" +
            "                            <p class=\"m-0 text-600 text-sm\">PrimeCard</p>\n" +
            "                        </div>\n" +
            "                        <i class=\"ml-auto pi pi-chevron-right text-700\"></i>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"surface-100 font-medium text-xl px-4 py-1 mb-2\">B</li>\n" +
            "                <li class=\"mb-2\">\n" +
            "                    <a class=\"flex align-items-center py-2 px-4 cursor-pointer hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-2.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:50px;height:50px\"/>\n" +
            "                        <div>\n" +
            "                            <span class=\"text-900 font-medium mb-2\">Balcaz Cooper</span>\n" +
            "                            <p class=\"m-0 text-600 text-sm\">Prime Coffee</p>\n" +
            "                        </div>\n" +
            "                        <i class=\"ml-auto pi pi-chevron-right text-700\"></i>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"mb-2\">\n" +
            "                    <a class=\"flex align-items-center py-2 px-4 cursor-pointer hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-3.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:50px;height:50px\"/>\n" +
            "                        <div>\n" +
            "                            <span class=\"text-900 font-medium mb-2\">Beatrix McKinney</span>\n" +
            "                            <p class=\"m-0 text-600 text-sm\">Bank of Prime</p>\n" +
            "                        </div>\n" +
            "                        <i class=\"ml-auto pi pi-chevron-right text-700\"></i>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"mb-2\">\n" +
            "                    <a class=\"flex align-items-center py-2 px-4 cursor-pointer hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-m-3.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:50px;height:50px\"/>\n" +
            "                        <div>\n" +
            "                            <span class=\"text-900 font-medium mb-2\">Belva Wilson</span>\n" +
            "                            <p class=\"m-0 text-600 text-sm\">Franki Inc</p>\n" +
            "                        </div>\n" +
            "                        <i class=\"ml-auto pi pi-chevron-right text-700\"></i>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"mb-2\">\n" +
            "                    <a class=\"flex align-items-center py-2 px-4 cursor-pointer hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-m-4.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:50px;height:50px\"/>\n" +
            "                        <div>\n" +
            "                            <span class=\"text-900 font-medium mb-2\">Barnes Fox</span>\n" +
            "                            <p class=\"m-0 text-600 text-sm\">Prime Electric</p>\n" +
            "                        </div>\n" +
            "                        <i class=\"ml-auto pi pi-chevron-right text-700\"></i>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"surface-100 font-medium text-xl px-4 py-1 mb-2\">C</li>\n" +
            "                <li class=\"mb-2\">\n" +
            "                    <a class=\"flex align-items-center py-2 px-4 cursor-pointer hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-m-5.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:50px;height:50px\"/>\n" +
            "                        <div>\n" +
            "                            <span class=\"text-900 font-medium mb-2\">Canyon Flores</span>\n" +
            "                            <p class=\"m-0 text-600 text-sm\">Ipsum Inc</p>\n" +
            "                        </div>\n" +
            "                        <i class=\"ml-auto pi pi-chevron-right text-700\"></i>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"mb-2\">\n" +
            "                    <a class=\"flex align-items-center py-2 px-4 cursor-pointer hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-4.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:50px;height:50px\"/>\n" +
            "                        <div>\n" +
            "                            <span class=\"text-900 font-medium mb-2\">Carmen Cooper</span>\n" +
            "                            <p class=\"m-0 text-600 text-sm\">Lorem LLC</p>\n" +
            "                        </div>\n" +
            "                        <i class=\"ml-auto pi pi-chevron-right text-700\"></i>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block7 = "<p:commandButton type=\"button\" value=\"Display\" icon=\"pi pi-arrow-left\" \n" +
            "    pt:data-pb-styleclass=\"{ selector: '@next', toggleClass: 'translate-x-100', hideOnOutsideClick: true }\" />\n" +
            "\n" +
            "<div id=\"slideover-7\" class=\"surface-overlay flex flex-column h-full absolute top-0 right-0 shadow-2\n" +
            "    translate-x-100 transition-transform transition-duration-150 transition-ease-in-out w-20rem\">\n" +
            "    <div class=\"flex flex-column p-4 h-full\">\n" +
            "        <div class=\"flex align-items-center justify-content-between mb-4\">\n" +
            "            <span class=\"text-900 text-xl font-medium\">Profile</span>\n" +
            "            <p:commandButton type=\"button\" icon=\"pi pi-times\" styleClass=\"rounded-button ui-button-flat ui-button-plain\"\n" +
            "                pt:data-pb-styleclass=\"{ selector: '#slideover-7', toggleClass: 'translate-x-100' }\" />\n" +
            "        </div>\n" +
            "        <div class=\"flex-auto overflow-y-auto\">\n" +
            "            <div class=\"text-center mb-4\">\n" +
            "                <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-3.png\" library=\"primeblocks-app\" alt=\"Image\" style=\"width:70px;height:70px\"/>\n" +
            "                <div class=\"text-900 mt-3 mb-2 text-xl font-medium\">Isabel Rio</div>\n" +
            "                <span class=\"text-700\">Sales Manager</span>\n" +
            "            </div>\n" +
            "            <div class=\"flex align-items-center justify-content-between mb-5\">\n" +
            "                <a class=\"cursor-pointer flex-shrink-0 border-round inline-flex justify-content-center align-items-center surface-100 hover:surface-200 transition-colors transition-duration-150 border-circle\" style=\"width:38px;height:38px\">\n" +
            "                    <i class=\"pi pi-comment text-xl text-600\"></i>\n" +
            "                </a>\n" +
            "                <a class=\"cursor-pointer flex-shrink-0 border-round inline-flex justify-content-center align-items-center surface-100 hover:surface-200 transition-colors transition-duration-150 border-circle\" style=\"width:38px;height:38px\">\n" +
            "                    <i class=\"pi pi-phone text-xl text-600\"></i>\n" +
            "                </a>\n" +
            "                <a  class=\"cursor-pointer flex-shrink-0 border-round inline-flex justify-content-center align-items-center surface-100 hover:surface-200 transition-colors transition-duration-150 border-circle\" style=\"width:38px;height:38px\">\n" +
            "                    <i class=\"pi pi-video text-xl text-600\"></i>\n" +
            "                </a>\n" +
            "            </div>\n" +
            "            <ul class=\"list-none p-0 m-0\">\n" +
            "                <li class=\"surface-100 text-sm text-700 font-medium p-2 border-round mb-1\">NAME</li>\n" +
            "                <li class=\"text-900 p-2\">Isabel Rio</li>\n" +
            "                <li class=\"surface-100 text-sm text-700 font-medium p-2 border-round mt-4 mb-1\">MEMBER SINCE</li>\n" +
            "                <li class=\"text-900 p-2\">23/10/2021</li>\n" +
            "                <li class=\"surface-100 text-sm text-700 font-medium p-2 border-round mt-4 mb-1\">LOCAL TIME</li>\n" +
            "                <li class=\"text-900 p-2\">16:40</li>\n" +
            "                <li class=\"surface-100 text-sm text-700 font-medium p-2 border-round mt-4 mb-1\">RECENT ORDERS</li>\n" +
            "                <li>\n" +
            "                    <ul class=\"list-none p-0 m-0\">\n" +
            "                        <li class=\"py-2 border-bottom-1 surface-border\">\n" +
            "                            <a  class=\"cursor-pointer flex align-items-center justify-content-between hover:surface-200 transition-colors transition-duration-150 border-round p-2\">\n" +
            "                                <p:graphicImage name=\"images/blocks/products/sport-shoe.png\" library=\"primeblocks-app\" alt=\"Image\" style=\"width:39px;height:39px\" styleClass=\"mr-3 flex-shrink-0\"/>\n" +
            "                                <div>\n" +
            "                                    <span class=\"block text-900 mb-1\">Sports Shoes</span>\n" +
            "                                    <p class=\"m-0 text-600 font-medium text-sm\">SRT30321</p>\n" +
            "                                </div>\n" +
            "                                <i class=\"ml-auto pi pi-chevron-right text-600 text-sm\"></i>\n" +
            "                            </a>\n" +
            "                        </li>\n" +
            "                        <li class=\"py-2 border-bottom-1 surface-border\">\n" +
            "                            <a  class=\"cursor-pointer flex align-items-center justify-content-between hover:surface-200 transition-colors transition-duration-150 border-round p-2\">\n" +
            "                                <p:graphicImage name=\"images/blocks/products/dslr-camera.png\" library=\"primeblocks-app\" alt=\"Image\" style=\"width:39px;height:39px\" styleClass=\"mr-3 flex-shrink-0\"/>\n" +
            "                                <div>\n" +
            "                                    <span class=\"block text-900 mb-1\">DSRL Camera</span>\n" +
            "                                    <p class=\"m-0 text-600 font-medium text-sm\">OBS90211</p>\n" +
            "                                </div>\n" +
            "                                <i class=\"ml-auto pi pi-chevron-right text-600 text-sm\"></i>\n" +
            "                            </a>\n" +
            "                        </li>\n" +
            "                        <li class=\"py-2\">\n" +
            "                            <a class=\"cursor-pointer flex align-items-center justify-content-between hover:surface-200 transition-colors transition-duration-150 border-round p-2\">\n" +
            "                                <p:graphicImage name=\"images/blocks/products/wireless-headphone.png\" library=\"primeblocks-app\" alt=\"Image\" style=\"width:39px;height:39px\" styleClass=\"mr-3 flex-shrink-0\"/>\n" +
            "                                <div>\n" +
            "                                    <span class=\"block text-900 mb-1\">Headphone</span>\n" +
            "                                    <p class=\"m-0 text-600 font-medium text-sm\">APE302123</p>\n" +
            "                                </div>\n" +
            "                                <i class=\"ml-auto pi pi-chevron-right text-600 text-sm\"></i>\n" +
            "                            </a>\n" +
            "                        </li>\n" +
            "                    </ul>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block8 = "<p:commandButton type=\"button\" value=\"Display\" icon=\"pi pi-arrow-right\"\n" +
            "           pt:data-pb-styleclass=\"{ selector: '@next', toggleClass: '-translate-x-100', hideOnOutsideClick: true }\"/>\n" +
            "<div id=\"slideover-8\" class=\"surface-overlay flex flex-column h-full absolute top-0 left-0 shadow-2\n" +
            "-translate-x-100 transition-transform transition-duration-150 transition-ease-in-out w-18rem\">\n" +
            "    <div class=\"flex flex-column h-full\">\n" +
            "        <div class=\"flex align-items-center justify-content-between mb-4 p-4\">\n" +
            "            <span class=\"text-900 text-xl font-medium\">Purchase Ticket</span>\n" +
            "            <p:commandButton type=\"button\" icon=\"pi pi-times\" styleClass=\"rounded-button ui-button-flat ui-button-plain\"\n" +
            "                            pt:data-pb-styleclass=\"{ selector: '#slideover-8', toggleClass: '-translate-x-100' }\"/>\n" +
            "        </div>\n" +
            "        <div class=\"flex-auto overflow-y-auto\">\n" +
            "            <ul class=\"list-none p-0 m-0\">\n" +
            "                <li class=\"flex align-items-center border-top-1 surface-border p-3\">\n" +
            "                    <span class=\"border-circle bg-green-500 text-white text-2xl inline-flex align-items-center justify-content-center mr-3 border-1 border-transparent\" style=\"width:35px;height:35px\">\n" +
            "                        <i class=\"pi pi-check\"></i>\n" +
            "                    </span>\n" +
            "                    <span class=\"text-700 font-medium\">Personal Information</span>\n" +
            "                </li>\n" +
            "                <li class=\"flex align-items-center border-top-1 surface-border p-3\">\n" +
            "                    <span class=\"border-circle bg-green-500 text-white text-2xl inline-flex align-items-center justify-content-center mr-3 border-1 border-transparent\" style=\"width:35px;height:35px\">\n" +
            "                        <i class=\"pi pi-check\"></i>\n" +
            "                    </span>\n" +
            "                    <span class=\"text-700 font-medium\">Destination</span>\n" +
            "                </li>\n" +
            "                <li class=\"flex align-items-center border-top-1 surface-border p-3\">\n" +
            "                    <span class=\"border-circle bg-green-500 text-white text-2xl inline-flex align-items-center justify-content-center mr-3 border-1 border-transparent\" style=\"width:35px;height:35px\">\n" +
            "                        <i class=\"pi pi-check\"></i>\n" +
            "                    </span>\n" +
            "                    <span class=\"text-700 font-medium\">Date</span>\n" +
            "                </li>\n" +
            "                <li class=\"border-top-1 surface-border p-3\">\n" +
            "                    <div class=\"flex align-items-center mb-3\">\n" +
            "                        <span class=\"border-circle surface-900 text-0 text-2xl inline-flex align-items-center justify-content-center mr-3 border-1 border-transparent\" style=\"width:35px;height:35px\">\n" +
            "                            <i class=\"pi pi-table\"></i>\n" +
            "                        </span>\n" +
            "                        <span class=\"text-900 font-medium font-bold\">Seat</span>\n" +
            "                    </div>\n" +
            "                    <ul class=\"list-none p-0 m-0\">\n" +
            "                        <li class=\"flex align-items-center p-2\">\n" +
            "                            <i class=\"pi pi-check text-green-500\"></i>\n" +
            "                            <span class=\"text-600 ml-3\">Choose Tier</span>\n" +
            "                        </li>\n" +
            "                        <li class=\"flex align-items-center p-2\">\n" +
            "                            <span class=\"text-900 ml-5 font-bold\">Select Seat</span>\n" +
            "                            <i class=\"pi pi-arrow-right text-900 ml-auto\"></i>\n" +
            "                        </li>\n" +
            "                    </ul>\n" +
            "                </li>\n" +
            "                <li class=\"flex align-items-center border-top-1 surface-border p-3\">\n" +
            "                    <span class=\"border-circle text-white text-2xl inline-flex align-items-center justify-content-center mr-3 border-1 surface-border\" style=\"width:35px;height:35px\">\n" +
            "                        <i class=\"pi pi-credit-card text-700\"></i>\n" +
            "                    </span>\n" +
            "                    <span class=\"text-700 font-medium\">Payment</span>\n" +
            "                </li>\n" +
            "                <li class=\"flex align-items-center border-top-1 surface-border p-3\">\n" +
            "                    <span class=\"border-circle text-2xl inline-flex align-items-center justify-content-center mr-3 border-1 surface-border\" style=\"width:35px;height:35px\">\n" +
            "                        <i class=\"pi pi-thumbs-up text-700\"></i>\n" +
            "                    </span>\n" +
            "                    <span class=\"text-700 font-medium\">Confirmation</span>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n";

    private final String block9 = "<p:commandButton type=\"button\" value=\"Display\" icon=\"pi pi-arrow-left\"\n" +
            "    data-pb-styleclass=\"{ selector: '#slideover-9', toggleClass: 'translate-x-100', hideOnOutsideClick: true }\" />\n" +
            "    <div id=\"slideover-9\" class=\"surface-overlay flex flex-column h-full absolute top-0 right-0 shadow-2 w-30rem\n" +
            "    translate-x-100 transition-transform transition-duration-150 transition-ease-in-out w-30rem\">\n" +
            "    <div class=\"flex flex-column p-4 h-full\">\n" +
            "        <div class=\"flex align-items-center justify-content-between mb-4\">\n" +
            "            <h:panelGroup id=\"userPanel\">\n" +
            "                <span class=\"flex align-items-center\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-#{slideOverView.users[slideOverView.userIndex].picture}\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:42px;height:42px\"/>\n" +
            "                    <span class=\"text-900 text-xl font-medium\">#{slideOverView.users[slideOverView.userIndex].name}</span>\n" +
            "                </span>\n" +
            "            </h:panelGroup>\n" +
            "            <p:commandButton type=\"button\" icon=\"pi pi-times\" styleClass=\"rounded-button ui-button-flat ui-button-plain\"\n" +
            "                    data-pb-styleclass=\"{ selector: '#slideover-9', toggleClass: 'translate-x-100' }\"/>\n" +
            "        </div>\n" +
            "        <div class=\"flex border-1 border-round surface-border flex-auto\">\n" +
            "            <div style=\"width:70px\" class=\"flex border-right-1 surface-border flex-shrink-0 h-full\">\n" +
            "                <ul class=\"flex flex-column list-none p-0 m-0 w-full\" data-pb-tabList=\"chatList\">\n" +
            "                    <ui:repeat value=\"#{slideOverView.users}\" var=\"user\">\n" +
            "                        <li>\n" +
            "                            <a class=\"cursor-pointer flex align-items-center justify-content-center border-right-2 border-transparent p-2 hover:border-300 transition-colors transition-duration-150 #{user.key eq 2 ? ' border-blue-500 surface-200 ' : ''}\"\n" +
            "                            data-pb-tab=\"{toggleClass: ' border-blue-500 surface-200 ', selector: '.userType#{user.key}', selectorToggleClass: ' hidden '}\"\n" +
            "                            onclick=\"changeUser([{name:'value', value:#{user.key}}])\">\n" +
            "                                <p:graphicImage name=\"images/blocks/avatars/circle/avatar-#{slideOverView.users[user.key].picture}\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"flex-shrink-0\" style=\"width:42px;height:42px\"/>\n" +
            "                            </a>\n" +
            "                        </li>\n" +
            "                    </ui:repeat>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "            <div class=\"flex flex-auto flex-column surface-ground overflow-hidden\">\n" +
            "                <ul class=\"flex-auto list-none p-0 m-0 userType2\">\n" +
            "                    <li class=\"flex justify-content-end p-3\">\n" +
            "                        <div>\n" +
            "                            <p class=\"shadow-2 bg-blue-600 text-white p-3 line-height-3 border-round mt-0 mb-2\" style=\"max-width: 275px\">Neque vitae tempus quam pellentesque nec nam aliquam sem. \n" +
            "                                Etiam tempor orci eu lobortis elementum.</p>\n" +
            "                            <div class=\"text-right text-500 text-sm\">14:43</div>\n" +
            "                        </div>\n" +
            "                    </li>\n" +
            "                    <li class=\"flex justify-content-start p-3\">\n" +
            "                        <div>\n" +
            "                            <p class=\"shadow-2 surface-card text-900 p-3 line-height-3 border-round mt-0 mb-2\" style=\"max-width: 275px\">Ultricies mi eget mauris pharetra et ultrices neque. Et odio pellentesque diam volutpat.</p>\n" +
            "                            <div class=\"text-right text-500 text-sm\">14:45</div>\n" +
            "                        </div>\n" +
            "                    </li>\n" +
            "                    <li class=\"flex justify-content-end p-3\">\n" +
            "                        <div>\n" +
            "                            <p class=\"shadow-2 bg-blue-600 text-white p-3 line-height-3 border-round mt-0 mb-2\" style=\"max-width: 275px\">Neque vitae tempus quam pellentesque nec nam aliquam sem. \n" +
            "                                Etiam tempor orci eu lobortis elementum.</p>\n" +
            "                            <p class=\"shadow-2 bg-blue-600 text-white p-3 line-height-3 border-round mt-0 mb-2\" style=\"max-width: 275px\">Imperdiet dui accumsan sit.</p>\n" +
            "                            <div class=\"text-right text-500 text-sm\">14:50</div>\n" +
            "                        </div>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "                <ul class=\"flex-auto list-none p-0 m-0 hidden userType1 userType3 userType4 userType5 userType6\">\n" +
            "                    <li class=\"flex p-3\">\n" +
            "                        <p class=\"flex align-items-center shadow-2 border-round bg-yellow-100 text-yellow-900 m-0 p-3 w-full\">\n" +
            "                            <i class=\"pi pi-lock mr-3\"></i>\n" +
            "                            <span class=\"line-height-3\">Messages are end-to-end encrypted. No one expect you and receiver can read them. None of messages are saved to our servers.</span>\n" +
            "                        </p>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "                <div class=\"p-4 border-top-1 surface-border p-input-filled\">\n" +
            "                    <span class=\"ui-input-icon-right block\">\n" +
            "                        <i class=\"pi pi-send\"></i>\n" +
            "                        <p:inputText placeholder=\"Message\" styleClass=\"p-3 w-full\"/>\n" +
            "                    </span>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "<p:remoteCommand name=\"changeUser\" update=\"userPanel\" action=\"#{slideOverView.changeUser}\"/>\n";

    private String block10 = "<p:commandButton type=\"button\" value=\"Display\" icon=\"pi pi-arrow-left\"\n" +
            "    pt:data-pb-styleclass=\"{ selector: '#slideover-10', toggleClass: 'translate-x-100', hideOnOutsideClick: true }\" />\n" +
            "\n" +
            "<div id=\"slideover-10\" class=\"surface-overlay flex flex-column h-full absolute top-0 right-0 shadow-2\n" +
            "    translate-x-100 transition-transform transition-duration-150 transition-ease-in-out w-24rem\">\n" +
            "    <div class=\"flex flex-column p-4 h-full\">\n" +
            "        <div class=\"flex align-items-center justify-content-between mb-4\">\n" +
            "            <span class=\"text-900 text-xl font-medium\">Orders</span>\n" +
            "            <p:commandButton type=\"button\" icon=\"pi pi-times\" styleClass=\"rounded-button ui-button-flat ui-button-plain\"\n" +
            "                    pt:data-pb-styleclass=\"{ selector: '#slideover-10', toggleClass: 'translate-x-100' }\"/>\n" +
            "        </div>\n" +
            "\n" +
            "        <p:tabView>\n" +
            "            <p:tab title=\"Processed\">\n" +
            "                <ul class=\"list-none p-0 m-0\">\n" +
            "                    <li class=\"border-bottom-1 surface-border py-2\">\n" +
            "                        <a class=\"flex align-items-center p-2 cursor-pointer border-round hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                            <p:graphicImage name=\"images/blocks/products/speaker.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:42px;height:42px\"/>\n" +
            "                            <div>\n" +
            "                                <span class=\"block text-900 mb-1\">Bluetooth Speaker</span>\n" +
            "                                <p class=\"m-0 text-600 font-medium text-sm\">#99812</p>\n" +
            "                            </div>\n" +
            "                            <i class=\"ml-auto pi pi-chevron-right text-600 text-sm\"></i>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"border-bottom-1 surface-border py-2\">\n" +
            "                        <a class=\"flex align-items-center p-2 cursor-pointer border-round hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                            <p:graphicImage name=\"images/blocks/products/gaming.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:42px;height:42px\"/>\n" +
            "                            <div>\n" +
            "                                <span class=\"block text-900 mb-1\">Gaming Device</span>\n" +
            "                                <p class=\"m-0 text-600 font-medium text-sm\">#60210</p>\n" +
            "                            </div>\n" +
            "                            <i class=\"ml-auto pi pi-chevron-right text-600 text-sm\"></i>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"border-bottom-1 surface-border py-2\">\n" +
            "                        <a class=\"flex align-items-center p-2 cursor-pointer border-round hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                            <p:graphicImage name=\"images/blocks/products/skateboard.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:42px;height:42px\"/>\n" +
            "                            <div>\n" +
            "                                <span class=\"block text-900 mb-1\">Skateboard</span>\n" +
            "                                <p class=\"m-0 text-600 font-medium text-sm\">#40197</p>\n" +
            "                            </div>\n" +
            "                            <i class=\"ml-auto pi pi-chevron-right text-600 text-sm\"></i>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"border-bottom-1 surface-border py-2\">\n" +
            "                        <a class=\"flex align-items-center p-2 cursor-pointer border-round hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                            <p:graphicImage name=\"images/blocks/products/wax.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:42px;height:42px\"/>\n" +
            "                            <div>\n" +
            "                                <span class=\"block text-900 mb-1\">Strong Wax</span>\n" +
            "                                <p class=\"m-0 text-600 font-medium text-sm\">#47082</p>\n" +
            "                            </div>\n" +
            "                            <i class=\"ml-auto pi pi-chevron-right text-600 text-sm\"></i>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"border-bottom-1 surface-border py-2\">\n" +
            "                        <a class=\"flex align-items-center p-2 cursor-pointer border-round hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                            <p:graphicImage name=\"images/blocks/products/juice.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:42px;height:42px\"/>\n" +
            "                            <div>\n" +
            "                                <span class=\"block text-900 mb-1\">Berry Juice</span>\n" +
            "                                <p class=\"m-0 text-600 font-medium text-sm\">#59901</p>\n" +
            "                            </div>\n" +
            "                            <i class=\"ml-auto pi pi-chevron-right text-600 text-sm\"></i>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"py-2\">\n" +
            "                        <a class=\"flex align-items-center p-2 cursor-pointer border-round hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                            <p:graphicImage name=\"images/blocks/products/sport-shoe.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:42px;height:42px\"/>\n" +
            "                            <div>\n" +
            "                                <span class=\"block text-900 mb-1\">Sports Shoe</span>\n" +
            "                                <p class=\"m-0 text-600 font-medium text-sm\">#47122</p>\n" +
            "                            </div>\n" +
            "                            <i class=\"ml-auto pi pi-chevron-right text-600 text-sm\"></i>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </p:tab>\n" +
            "\n" +
            "            <p:tab title=\"Pending\">\n" +
            "                <ul class=\"list-none p-0 m-0\">\n" +
            "                    <li class=\"border-bottom-1 surface-border py-2\">\n" +
            "                        <a class=\"flex align-items-center p-2 cursor-pointer border-round hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                            <p:graphicImage name=\"images/blocks/products/running-shoe.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:42px;height:42px\"/>\n" +
            "                            <div>\n" +
            "                                <span class=\"block text-900 mb-1\">Running Shoes</span>\n" +
            "                                <p class=\"m-0 text-600 font-medium text-sm\">#99210</p>\n" +
            "                            </div>\n" +
            "                            <i class=\"ml-auto pi pi-chevron-right text-600 text-sm\"></i>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"border-bottom-1 surface-border py-2\">\n" +
            "                        <a class=\"flex align-items-center p-2 cursor-pointer border-round hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                            <p:graphicImage name=\"images/blocks/products/instant-camera.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:42px;height:42px\"/>\n" +
            "                            <div>\n" +
            "                                <span class=\"block text-900 mb-1\">Instant Camera</span>\n" +
            "                                <p class=\"m-0 text-600 font-medium text-sm\">#55018</p>\n" +
            "                            </div>\n" +
            "                            <i class=\"ml-auto pi pi-chevron-right text-600 text-sm\"></i>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"border-bottom-1 surface-border py-2\">\n" +
            "                        <a class=\"flex align-items-center p-2 cursor-pointer border-round hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                            <p:graphicImage name=\"images/blocks/products/sunglasses.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:42px;height:42px\"/>\n" +
            "                            <div>\n" +
            "                                <span class=\"block text-900 mb-1\">Sunglasses</span>\n" +
            "                                <p class=\"m-0 text-600 font-medium text-sm\">#18880</p>\n" +
            "                            </div>\n" +
            "                            <i class=\"ml-auto pi pi-chevron-right text-600 text-sm\"></i>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"border-bottom-1 surface-border py-2\">\n" +
            "                        <a class=\"flex align-items-center p-2 cursor-pointer border-round hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                            <p:graphicImage name=\"images/blocks/products/dslr-camera.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:42px;height:42px\"/>\n" +
            "                            <div>\n" +
            "                                <span class=\"block text-900 mb-1\">DSLR Camera</span>\n" +
            "                                <p class=\"m-0 text-600 font-medium text-sm\">#9402</p>\n" +
            "                            </div>\n" +
            "                            <i class=\"ml-auto pi pi-chevron-right text-600 text-sm\"></i>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </p:tab>\n" +
            "            <p:tab title=\"Completed\">\n" +
            "                <ul class=\"list-none p-0 m-0\">\n" +
            "                    <li class=\"border-bottom-1 surface-border py-2\">\n" +
            "                        <a class=\"flex align-items-center p-2 cursor-pointer border-round hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                            <p:graphicImage name=\"images/blocks/products/cupcake.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:42px;height:42px\"/>\n" +
            "                            <div>\n" +
            "                                <span class=\"block text-900 mb-1\">Bluetooth Speaker</span>\n" +
            "                                <p class=\"m-0 text-600 font-medium text-sm\">#49991</p>\n" +
            "                            </div>\n" +
            "                            <i class=\"ml-auto pi pi-chevron-right text-600 text-sm\"></i>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"border-bottom-1 surface-border py-2\">\n" +
            "                        <a class=\"flex align-items-center p-2 cursor-pointer border-round hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                            <p:graphicImage name=\"images/blocks/products/wireless-headphone.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:42px;height:42px\"/>\n" +
            "                            <div>\n" +
            "                                <span class=\"block text-900 mb-1\">Gaming Device</span>\n" +
            "                                <p class=\"m-0 text-600 font-medium text-sm\">#9921</p>\n" +
            "                            </div>\n" +
            "                            <i class=\"ml-auto pi pi-chevron-right text-600 text-sm\"></i>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"border-bottom-1 surface-border py-2\">\n" +
            "                        <a class=\"flex align-items-center p-2 cursor-pointer border-round hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                            <p:graphicImage name=\"images/blocks/products/perfume.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:42px;height:42px\"/>\n" +
            "                            <div>\n" +
            "                                <span class=\"block text-900 mb-1\">Perfume</span>\n" +
            "                                <p class=\"m-0 text-600 font-medium text-sm\">#7502</p>\n" +
            "                            </div>\n" +
            "                            <i class=\"ml-auto pi pi-chevron-right text-600 text-sm\"></i>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"border-bottom-1 surface-border py-2\">\n" +
            "                        <a class=\"flex align-items-center p-2 cursor-pointer border-round hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                            <p:graphicImage name=\"images/blocks/products/model-car.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:42px;height:42px\"/>\n" +
            "                            <div>\n" +
            "                                <span class=\"block text-900 mb-1\">Model Car</span>\n" +
            "                                <p class=\"m-0 text-600 font-medium text-sm\">#47082</p>\n" +
            "                            </div>\n" +
            "                            <i class=\"ml-auto pi pi-chevron-right text-600 text-sm\"></i>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"border-bottom-1 surface-border py-2\">\n" +
            "                        <a class=\"flex align-items-center p-2 cursor-pointer border-round hover:surface-200 transition-colors transition-duration-150\">\n" +
            "                            <p:graphicImage name=\"images/blocks/products/spoons.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mr-3 flex-shrink-0\" style=\"width:42px;height:42px\"/>\n" +
            "                            <div>\n" +
            "                                <span class=\"block text-900 mb-1\">Spoon Set</span>\n" +
            "                                <p class=\"m-0 text-600 font-medium text-sm\">#10002</p>\n" +
            "                            </div>\n" +
            "                            <i class=\"ml-auto pi pi-chevron-right text-600 text-sm\"></i>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </p:tab>\n" +
            "        </p:tabView>\n" +
            "    </div>\n" +
            "</div>\n" ;
        
    @PostConstruct
    public void init() {
        users = new HashMap();
        users.put(1, new User("f-1.png","Jane Watson"));
        users.put(2, new User("m-1.png","David Wilford"));
        users.put(3, new User("f-2.png","Annette Black"));
        users.put(4, new User("f-3.png","Leslie Alexander"));
        users.put(5, new User("f-4.png","Savannah Nguyen"));
        users.put(6, new User("m-2.png","Alberto Flores"));
    }

    public int getUserIndex() {
        return userIndex;
    }

    public void setUserIndex(int userIndex) {
        this.userIndex = userIndex;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Integer, User> users) {
        this.users = users;
    }

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

    public String getBlock7() {
        return block7;
    }
    
    public String getBlock8() {
        return block8;
    }

    public String getBlock9() {
        return block9;
    }

    public String getBlock10() {
        return block10;
    }

    public class User {
        private String picture;
        
        private String name;

        public User(String picture, String name) {
            this.picture = picture;
            this.name = name;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

     
    public void changeUser() {
        String param1 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("value");
        userIndex = Integer.parseInt(param1);
    }

}
