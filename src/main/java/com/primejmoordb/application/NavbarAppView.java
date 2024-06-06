package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class NavbarAppView implements Serializable {

    private final String block1 = "<div class=\"surface-overlay py-3 px-6 shadow-2 flex align-items-center justify-content-between relative lg:static\"\n" +
            "     style=\"min-height: 80px\">\n" +
            "    <p:graphicImage name=\"images/blocks/logos/bastion-700.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                    styleClass=\"mr-0 lg:mr-6\" height=\"40\"/>\n" +
            "    <a class=\"cursor-pointer block lg:hidden text-700\"\n" +
            "       data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true}\">\n" +
            "        <i class=\"pi pi-bars text-4xl\"/>\n" +
            "    </a>\n" +
            "    <div class=\"align-items-center flex-grow-1 justify-content-between hidden lg:flex absolute lg:static w-full surface-overlay left-0 top-100 z-1 shadow-2 lg:shadow-none\">\n" +
            "        <ul class=\"list-none p-0 m-0 flex lg:align-items-center select-none flex-column lg:flex-row\">\n" +
            "            <li>\n" +
            "                <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-home mr-2\"/>\n" +
            "                    <span>Home</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li class=\"lg:relative\">\n" +
            "                <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150\"\n" +
            "                   data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'scalein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                    <i class=\"pi pi-users mr-2\"/>\n" +
            "                    <span>Customers</span>\n" +
            "                    <i class=\"pi pi-angle-down ml-auto lg:ml-3\"/>\n" +
            "                </a>\n" +
            "                <ul class=\"list-none py-3 px-6 m-0 lg:px-0 lg:py-0 border-round shadow-0 lg:shadow-2 lg:border-1 border-50 lg:absolute surface-overlay hidden origin-top w-full lg:w-15rem cursor-pointer\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-user-plus mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Add New</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"relative\">\n" +
            "                        <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\"\n" +
            "                           data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'scalein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                            <i class=\"pi pi-search mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Search</span>\n" +
            "                            <i class=\"pi pi-angle-down ml-auto lg:-rotate-90\"/>\n" +
            "                        </a>\n" +
            "                        <ul class=\"list-none py-3 pl-3 m-0 lg:px-0 lg:py-0 border-round shadow-0 lg:shadow-2 lg:border-1 border-50 lg:absolute surface-overlay hidden origin-top w-full lg:w-15rem cursor-pointer left-100 top-0\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-shopping-cart mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Purchases</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li class=\"relative\">\n" +
            "                                <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-comments mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Messages</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-calendar mr-2\"/>\n" +
            "                    <span>Calendar</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                    <span>Stats</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "        <ul class=\"list-none p-0 m-0 flex lg:align-items-center select-none flex-column lg:flex-row border-top-1 surface-border lg:border-top-none\">\n" +
            "            <li>\n" +
            "                <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"/>\n" +
            "                    <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <p:badge severity=\"danger\">\n" +
            "                        <i class=\"pi pi-bell text-base lg:text-2xl\"/>\n" +
            "                    </p:badge>\n" +
            "                    <span class=\"block lg:hidden font-medium ml-2 lg:ml-0\">Notifications</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li class=\"border-top-1 surface-border lg:border-top-none\">\n" +
            "                <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\"\n" +
            "                                    library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                    styleClass=\"mr-3 lg:mr-0\" style=\"width: 32px; height: 32px\"/>\n" +
            "                    <div class=\"block lg:hidden\">\n" +
            "                        <div class=\"text-900 font-medium\">Josephine Lillard</div>\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                    </div>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "    </div>\n" +
            "</div>" ;
    
    private final String block2 = "<div class=\"bg-gray-900 py-3 px-6 shadow-2 flex align-items-center justify-content-between relative lg:static border-bottom-1 border-gray-800\"\n" +
            "     style=\"min-height: 84px\">\n" +
            "    <p:graphicImage name=\"images/blocks/logos/bastion-300.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                    styleClass=\"mr-0 lg:mr-6\" height=\"40\"/>\n" +
            "    <a class=\"cursor-pointer block lg:hidden text-gray-400\"\n" +
            "       data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true }\">\n" +
            "        <i class=\"pi pi-bars text-4xl\"/>\n" +
            "    </a>\n" +
            "    <div class=\"align-items-center flex-grow-1 justify-content-between hidden lg:flex absolute lg:static w-full bg-gray-900 left-0 top-100 z-1 shadow-2 lg:shadow-none border-1 lg:border-none border-gray-800\">\n" +
            "        <ul class=\"list-none p-0 m-0 flex lg:align-items-center select-none flex-column lg:flex-row\">\n" +
            "            <li>\n" +
            "                <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-home mr-2\"/>\n" +
            "                    <span>Home</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\"\n" +
            "                   data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'scalein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                    <i class=\"pi pi-users mr-2\"/>\n" +
            "                    <span>Customers</span>\n" +
            "                    <i class=\"pi pi-angle-down ml-auto lg:ml-3\"/>\n" +
            "                </a>\n" +
            "                <ul class=\"list-none py-3 px-6 m-0 lg:px-0 lg:py-0 border-round shadow-0 lg:shadow-2 lg:absolute bg-gray-900 hidden origin-top w-full lg:w-15rem cursor-pointer lg:border-1 border-gray-800\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex p-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-user-plus mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Add New</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"relative\">\n" +
            "                        <a class=\"flex p-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 transition-colors transition-duration-150\"\n" +
            "                           data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'scalein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                            <i class=\"pi pi-search mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Search</span>\n" +
            "                            <i class=\"pi pi-angle-down ml-auto lg:-rotate-90\"/>\n" +
            "                        </a>\n" +
            "                        <ul class=\"list-none py-3 pl-3 m-0 lg:px-0 lg:py-0 border-round shadow-0 lg:shadow-2 lg:absolute bg-gray-900 hidden origin-top w-full lg:w-15rem cursor-pointer left-100 top-0 lg:border-1 border-gray-800\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex p-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-shopping-cart mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Purchases</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li class=\"relative\">\n" +
            "                                <a class=\"flex p-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-comments mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Messages</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-calendar mr-2\"/>\n" +
            "                    <span>Calendar</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                    <span>Stats</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "        <ul class=\"list-none p-0 m-0 flex lg:align-items-center select-none flex-column lg:flex-row\">\n" +
            "            <li class=\"flex-order-2 lg:flex-order-0\">\n" +
            "                <a class=\"flex px-6 p-3 lg:px-3 lg:py-2\">\n" +
            "                    <span class=\"ui-input-icon-left w-full\">\n" +
            "                        <i class=\"pi pi-search text-gray-400\"/>\n" +
            "                      <p:inputText placeholder=\"Search\"\n" +
            "                                   styleClass=\"bg-gray-800 text-gray-400 border-gray-800 w-full\"/>\n" +
            "                    </span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li class=\"border-top-1 border-gray-800 lg:border-top-none\">\n" +
            "                <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\"\n" +
            "                                    library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                    styleClass=\"mr-3 lg:mr-0\" style=\"width: 32px; height: 32px\"/>\n" +
            "                    <div class=\"block lg:hidden\">\n" +
            "                        <div class=\"text-white font-medium\">Josephine Lillard</div>\n" +
            "                        <span class=\"text-gray-400 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                    </div>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block3 = "<div class=\"bg-indigo-500 py-3 px-6 shadow-2 flex align-items-center justify-content-between relative lg:static\"\n" +
            "     style=\"min-height: 84px\">\n" +
            "    <p:graphicImage name=\"images/blocks/logos/bastion-300.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                    styleClass=\"mr-0 lg:mr-6\" height=\"40\"/>\n" +
            "    <a class=\"cursor-pointer block lg:hidden text-indigo-100\"\n" +
            "       data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true }\">\n" +
            "        <i class=\"pi pi-bars text-4xl\"/>\n" +
            "    </a>\n" +
            "    <div class=\"align-items-center flex-grow-1 justify-content-between hidden lg:flex absolute lg:static w-full bg-indigo-500 left-0 top-100 z-1 shadow-2 lg:shadow-none\">\n" +
            "        <ul class=\"list-none p-0 m-0 flex lg:align-items-center select-none flex-column lg:flex-row\">\n" +
            "            <li>\n" +
            "                <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-home mr-2\"/>\n" +
            "                    <span>Home</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\"\n" +
            "                   data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'scalein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                    <i class=\"pi pi-users mr-2\"/>\n" +
            "                    <span>Customers</span>\n" +
            "                    <i class=\"pi pi-angle-down ml-auto lg:ml-3\"/>\n" +
            "                </a>\n" +
            "                <ul class=\"list-none py-3 px-6 m-0 lg:px-0 lg:py-0 border-round shadow-0 lg:shadow-2 lg:absolute lg:border-1 border-50 surface-overlay hidden origin-top w-full lg:w-15rem cursor-pointer\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-user-plus mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Add New</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"relative\">\n" +
            "                        <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\"\n" +
            "                           data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'scalein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                            <i class=\"pi pi-search mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Search</span>\n" +
            "                            <i class=\"pi pi-angle-down ml-auto lg:-rotate-90\"/>\n" +
            "                        </a>\n" +
            "                        <ul class=\"list-none py-3 pl-3 m-0 lg:px-0 lg:py-0 border-round shadow-0 lg:shadow-2 lg:absolute lg:border-1 border-50 surface-overlay hidden origin-top w-full lg:w-15rem cursor-pointer left-100 top-0\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-shopping-cart mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Purchases</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li class=\"relative\">\n" +
            "                                <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-comments mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Messages</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-calendar mr-2\"/>\n" +
            "                    <span>Calendar</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                    <span>Stats</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "        <ul class=\"list-none p-0 m-0 flex lg:align-items-center select-none flex-column lg:flex-row\">\n" +
            "            <li class=\"flex-order-2 lg:flex-order-0\">\n" +
            "                <a class=\"flex px-6 p-3 lg:px-3 lg:py-2\">\n" +
            "                    <span class=\"ui-input-icon-left w-full\">\n" +
            "                        <i class=\"pi pi-search text-indigo-100\"/>\n" +
            "                      <p:inputText styleClass=\"bg-indigo-400 text-indigo-100 border-indigo-400 w-full\"/>\n" +
            "                    </span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li class=\"border-top-1 border-indigo-400 lg:border-top-none\">\n" +
            "                <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\"\n" +
            "                                    library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                    styleClass=\"mr-3 lg:mr-0\" style=\"width: 32px; height: 32px\"/>\n" +
            "                    <div class=\"block lg:hidden\">\n" +
            "                        <div class=\"text-white font-medium\">Josephine Lillard</div>\n" +
            "                        <span class=\"text-indigo-100 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                    </div>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block4 = "<div class=\"surface-overlay px-6 shadow-2 flex justify-content-between relative lg:static\"\n" +
            "     style=\"min-height: 84px\">\n" +
            "    <p:graphicImage name=\"images/blocks/logos/bastion-700.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                    styleClass=\"mr-0 lg:mr-6 align-self-center\" height=\"40\"/>\n" +
            "    <a class=\"cursor-pointer block lg:hidden align-self-center text-700\"\n" +
            "       data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true }\">\n" +
            "        <i class=\"pi pi-bars text-4xl\"/>\n" +
            "    </a>\n" +
            "    <div class=\"flex-grow-1 justify-content-between hidden lg:flex absolute lg:static w-full surface-overlay left-0 top-100 z-1 shadow-2 lg:shadow-none\">\n" +
            "        <ul class=\"list-none p-0 m-0 flex select-none flex-column lg:flex-row\">\n" +
            "            <li>\n" +
            "                <a class=\"flex px-6 p-3 h-full lg:px-3 lg:py-2 align-items-center text-600 border-left-2 lg:border-bottom-2 lg:border-left-none border-transparent hover:border-blue-500 font-medium cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-home mr-2\"/>\n" +
            "                    <span>Home</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex px-6 p-3 h-full lg:px-3 lg:py-2 align-items-center text-600 border-left-2 lg:border-bottom-2 lg:border-left-none border-transparent hover:border-blue-500 font-medium cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-users mr-2\"/>\n" +
            "                    <span>Customers</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex px-6 p-3 h-full lg:px-3 lg:py-2 align-items-center text-600 border-left-2 lg:border-bottom-2 lg:border-left-none border-transparent hover:border-blue-500 font-medium cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-calendar mr-2\"/>\n" +
            "                    <span>Calendar</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex px-6 p-3 h-full lg:px-3 lg:py-2 align-items-center text-600 border-left-2 lg:border-bottom-2 lg:border-left-none border-transparent hover:border-blue-500 font-medium cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                    <span>Stats</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "        <ul class=\"list-none p-0 m-0 flex select-none flex-column lg:flex-row border-top-1 surface-border lg:border-top-none\">\n" +
            "            <li>\n" +
            "                <a class=\"flex px-6 p-3 h-full lg:px-3 lg:py-2 align-items-center text-600 border-left-2 lg:border-bottom-2 lg:border-left-none border-transparent hover:border-blue-500 font-medium cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"/>\n" +
            "                    <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex px-6 p-3 h-full lg:px-3 lg:py-2 align-items-center text-600 border-left-2 lg:border-bottom-2 lg:border-left-none border-transparent hover:border-blue-500 font-medium cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-bell text-base lg:text-2xl mr-2 lg:mr-0\"/>\n" +
            "                    <span class=\"block lg:hidden font-medium\">Notifications</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li class=\"border-top-1 surface-border lg:border-top-none\">\n" +
            "                <a class=\"flex px-6 p-3 h-full lg:px-3 lg:py-2 align-items-center text-600 border-left-2 lg:border-bottom-2 lg:border-left-none border-transparent hover:border-blue-500 font-medium cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\"\n" +
            "                                    library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                    styleClass=\"mr-3 lg:mr-0\" style=\"width: 32px; height: 32px\"/>\n" +
            "                    <div class=\"block lg:hidden\">\n" +
            "                        <div class=\"text-900 font-medium\">Josephine Lillard</div>\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                    </div>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block5 = "<div class=\"bg-indigo-600 shadow-2 flex relative lg:static\" style=\"min-height: 84px\">\n" +
            "    <div class=\"flex align-items-center justify-content-center px-5 bg-indigo-500\">\n" +
            "        <p:graphicImage name=\"images/blocks/logos/bastion.svg\" library=\"primeblocks-app\" alt=\"Image\" height=\"40\"/>\n" +
            "    </div>\n" +
            "    <div class=\"flex flex-1 px-3\">\n" +
            "        <span class=\"flex align-items-center\">\n" +
            "            <i class=\"pi pi-search text-indigo-100\"></i>\n" +
            "        </span>\n" +
            "        <p:inputText styleClass=\"appearance-none border-none flex-auto bg-transparent outline-none p-component text-indigo-300 pl-3\"/>\n" +
            "    </div>\n" +
            "    <a class=\"cursor-pointer flex align-items-center justify-content-center lg:hidden text-white pr-5\" \n" +
            "        data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true }\">\n" +
            "        <i class=\"pi pi-bars text-4xl\"></i>\n" +
            "    </a>\n" +
            "    <div class=\"lg:flex hidden absolute lg:static left-0 top-100 z-1 shadow-2 lg:shadow-none lg:pr-5 w-full lg:w-auto bg-indigo-600\">\n" +
            "        <ul class=\"list-none p-0 m-0 flex select-none flex-column lg:flex-row border-top-1 border-indigo-500 lg:border-top-none\">\n" +
            "            <li>\n" +
            "                <a class=\"h-full flex px-6 py-3 lg:px-3 lg:py-0 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-700 font-medium cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
            "                    <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"h-full flex px-6 py-3 lg:px-3 lg:py-0 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-700 font-medium cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <p:badge severity=\"danger\">\n" +
            "                        <i class=\"pi pi-bell text-base lg:text-2xl mr-2 lg:mr-0\"/>\n" +
            "                    </p:badge>\n" +
            "                    <span class=\"block lg:hidden font-medium\">Notifications</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li class=\"border-top-1 border-indigo-500 lg:border-top-none\">\n" +
            "                <a class=\"h-full flex px-6 py-3 lg:px-3 lg:py-0 align-items-center hover:bg-indigo-700 font-medium cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-4.png\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 28px; height: 28px\" styleClass=\"mr-3 lg:mr-0\"/>\n" +
            "                    <div class=\"block lg:hidden\">\n" +
            "                        <div class=\"text-indigo-50 font-medium\">Josephine Lillard</div>\n" +
            "                        <span class=\"text-indigo-100 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                    </div>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block6 = "<div class=\"bg-gray-900 shadow-2 flex relative lg:static\" style=\"min-height: 84px\">\n" +
            "    <div class=\"flex align-items-center justify-content-center px-5 bg-gray-800\">\n" +
            "        <p:graphicImage name=\"images/blocks/logos/bastion.svg\" library=\"primeblocks-app\" alt=\"Image\" height=\"40\"/>\n" +
            "    </div>\n" +
            "    <div class=\"flex flex-1 px-3\">\n" +
            "        <span class=\"flex align-items-center\">\n" +
            "            <i class=\"pi pi-search text-gray-500\"></i>\n" +
            "        </span>\n" +
            "        <p:inputText styleClass=\"appearance-none border-none flex-auto bg-transparent outline-none p-component text-indigo-300 pl-3\" placeholder=\"Search for anything\"/>\n" +
            "    </div>\n" +
            "    <a class=\"cursor-pointer flex align-items-center justify-content-center lg:hidden text-white pr-5\" \n" +
            "        data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true }\">\n" +
            "        <i class=\"pi pi-bars text-4xl\"></i>\n" +
            "    </a>\n" +
            "    <div class=\"lg:flex hidden absolute lg:static left-0 top-100 z-1 shadow-2 lg:shadow-none lg:pr-5 w-full lg:w-auto bg-gray-900\">\n" +
            "        <ul class=\"list-none p-0 m-0 flex select-none flex-column lg:flex-row border-top-1 border-gray-800 lg:border-top-none\">\n" +
            "            <li>\n" +
            "                <a class=\"h-full flex px-6 py-3 lg:px-3 lg:py-0 align-items-center text-gray-500 hover:text-gray-400 hover:bg-gray-800 font-medium cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
            "                    <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"h-full flex px-6 py-3 lg:px-3 lg:py-0 align-items-center text-gray-500 hover:text-gray-400 hover:bg-gray-800 font-medium cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <p:badge severity=\"danger\">\n" +
            "                        <i class=\"pi pi-bell text-base lg:text-2xl mr-2 lg:mr-0\" />\n" +
            "                    </p:badge>\n" +
            "                    <span class=\"block lg:hidden font-medium\">Notifications</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li class=\"border-top-1 border-gray-800 lg:border-top-none\">\n" +
            "                <a class=\"h-full flex px-6 py-3 lg:px-3 lg:py-0 align-items-center hover:bg-gray-800 font-medium cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-m-3.png\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 28px; height: 28px\" styleClass=\"mr-3 lg:mr-0\"/>\n" +
            "                    <div class=\"block lg:hidden\">\n" +
            "                        <div class=\"text-gray-500 font-medium\">Josephine Lillard</div>\n" +
            "                        <span class=\"text-gray-600 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                    </div>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block7 = "<div class=\"surface-overlay relative\">\n" +
            "    <div class=\"py-3 lg:py-2 px-6 flex align-items-center justify-content-between lg:static\">\n" +
            "        <p:graphicImage name=\"images/blocks/logos/bastion-700.svg\" library=\"primeblocks-app\" styleClass=\"mr-0 lg:mr-6\" alt=\"Image\" height=\"40\"/>\n" +
            "        <div class=\"flex align-items-center\">\n" +
            "            <a class=\"cursor-pointer block lg:hidden text-700 mr-5\" \n" +
            "                data-pb-styleclass=\"{ selector: '#navbar-sub-7', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true }\">\n" +
            "                <i class=\"pi pi-ellipsis-v text-2xl\"></i>\n" +
            "            </a>\n" +
            "            <a class=\"cursor-pointer block lg:hidden text-700\" \n" +
            "                data-pb-styleclass=\"{ selector: '#navbar-7', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true }\">\n" +
            "                <i class=\"pi pi-bars text-4xl\"></i>\n" +
            "            </a>\n" +
            "        </div>\n" +
            "        <div id=\"navbar-sub-7\" class=\"hidden lg:block absolute lg:static lg:w-auto w-full surface-overlay left-0 top-100 z-1 shadow-2 lg:shadow-none\">\n" +
            "            <ul class=\"list-none p-0 m-0 flex lg:align-items-center select-none flex-column lg:flex-row border-top-1 surface-border lg:border-top-none\">\n" +
            "                <li>\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <p:badge severity=\"danger\">\n" +
            "                            <i class=\"pi pi-bell text-base lg:text-2xl mr-2 lg:mr-0\" />\n" +
            "                        </p:badge>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Notifications</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"border-top-1 surface-border lg:border-top-none\">\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 align-items-center hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\" styleClass=\"mr-3 lg:mr-0\" alt=\"Image\" style=\"width: 28px; height: 28px\"/>\n" +
            "                        <div class=\"block lg:hidden\">\n" +
            "                            <div class=\"text-900 font-medium\">Josephine Lillard</div>\n" +
            "                            <span class=\"text-600 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                        </div>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div id=\"navbar-7\" class=\"py-2 px-6 shadow-2 hidden lg:block absolute lg:static lg:w-auto w-full surface-overlay left-0 top-100 z-1 shadow-2\">\n" +
            "        <ul class=\"list-none p-0 m-0 flex lg:align-items-center flex-column lg:flex-row select-none\">\n" +
            "            <li>\n" +
            "                <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-home mr-2\"></i>\n" +
            "                    <span>Home</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li class=\"lg:relative\">\n" +
            "                <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150\"\n" +
            "                        data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden',enterActiveClass: 'scalein', leaveToClass: 'hidden',leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                    <i class=\"pi pi-users mr-2\"></i>\n" +
            "                    <span>Customers</span>\n" +
            "                    <i class=\"pi pi-angle-down ml-auto lg:ml-3\"></i>\n" +
            "                </a>\n" +
            "                <ul class=\"list-none py-0 pl-3 m-0 lg:px-0 lg:py-0 border-round shadow-0 lg:shadow-2 lg:border-1 border-50 lg:absolute surface-overlay hidden origin-top w-full lg:w-15rem cursor-pointer\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-user-plus mr-2\"></i>\n" +
            "                            <span class=\"font-medium\">Add New</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"relative\">\n" +
            "                        <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\" \n" +
            "                            data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden',enterActiveClass: 'scalein', leaveToClass: 'hidden',leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                            <i class=\"pi pi-search mr-2\"></i>\n" +
            "                            <span class=\"font-medium\">Search</span>\n" +
            "                            <i class=\"pi pi-angle-down ml-auto lg:-rotate-90\"></i>\n" +
            "                        </a>\n" +
            "                        <ul class=\"list-none py-0 pl-3 m-0 lg:px-0 lg:py-0 border-round shadow-0 lg:shadow-2 lg:border-1 border-50 lg:absolute surface-overlay hidden origin-top w-full lg:w-15rem cursor-pointer left-100 top-0\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-shopping-cart mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Purchases</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li class=\"relative\">\n" +
            "                                <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-comments mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Messages</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-calendar mr-2\"></i>\n" +
            "                    <span>Calendar</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                    <span>Stats</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block8 = "<div class=\"bg-gray-900 relative px-6\">\n" +
            "    <div class=\"py-3 lg:py-2 flex align-items-center justify-content-between lg:static border-bottom-none lg:border-bottom-1 border-gray-800\" style=\"min-height: 81px\">\n" +
            "        <p:graphicImage name=\"images/blocks/logos/bastion-300.svg\" library=\"primeblocks-app\" styleClass=\"mr-0 lg:mr-6\" alt=\"Image\" height=\"40\"/>\n" +
            "        <div class=\"flex align-items-center\">\n" +
            "            <a class=\"cursor-pointer block lg:hidden text-gray-400 mr-5\" \n" +
            "                data-pb-styleclass=\"{ selector: '#navbar-sub-8', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true }\">\n" +
            "                <i class=\"pi pi-ellipsis-v text-2xl\"></i>\n" +
            "            </a>\n" +
            "            <a class=\"cursor-pointer block lg:hidden text-gray-400\" \n" +
            "                data-pb-styleclass=\"{ selector: '#navbar-8', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true }\">\n" +
            "                <i class=\"pi pi-bars text-4xl\"></i>\n" +
            "            </a>\n" +
            "        </div>\n" +
            "        <div id=\"navbar-sub-8\" class=\"hidden lg:block absolute lg:static lg:w-auto w-full bg-gray-900 left-0 top-100 z-1 shadow-2 lg:shadow-none\">\n" +
            "            <ul class=\"list-none p-0 m-0 flex lg:align-items-center select-none flex-column lg:flex-row border-top-1 border-gray-800  lg:border-top-none\">\n" +
            "                <li>\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <p:badge severity=\"danger\">\n" +
            "                            <i class=\"pi pi-bell text-base lg:text-2xl mr-2 lg:mr-0\" />\n" +
            "                        </p:badge>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Notifications</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"border-top-1 border-gray-800 lg:border-top-none\">\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 align-items-center hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\" styleClass=\"mr-3 lg:mr-0\" alt=\"Image\" style=\"width: 28px; height: 28px\"/>\n" +
            "                        <div class=\"block lg:hidden\">\n" +
            "                            <div class=\"text-gray-400 font-medium\">Josephine Lillard</div>\n" +
            "                            <span class=\"text-gray-500 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                        </div>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div id=\"navbar-8\" class=\"py-2 px-6 lg:px-0 shadow-2 hidden lg:block absolute lg:static lg:w-auto w-full bg-gray-900 left-0 top-100 z-1 shadow-2\">\n" +
            "        <ul class=\"list-none p-0 m-0 flex lg:align-items-center flex-column lg:flex-row select-none\">\n" +
            "            <li>\n" +
            "                <a class=\"flex p-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-home mr-2\"></i>\n" +
            "                    <span>Home</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li class=\"lg:relative\">\n" +
            "                <a class=\"flex p-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\"\n" +
            "                    data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden',enterActiveClass: 'scalein', leaveToClass: 'hidden',leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                    <i class=\"pi pi-users mr-2\"></i>\n" +
            "                    <span>Customers</span>\n" +
            "                    <i class=\"pi pi-angle-down ml-auto lg:ml-3\"></i>\n" +
            "                </a>\n" +
            "                <ul class=\"list-none py-0 pl-3 m-0 lg:px-0 lg:py-0 border-round shadow-0 lg:shadow-2 lg:absolute bg-gray-900 hidden origin-top w-full lg:w-15rem cursor-pointer\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex p-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-user-plus mr-2\"></i>\n" +
            "                            <span class=\"font-medium\">Add New</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"relative\">\n" +
            "                        <a class=\"flex p-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 transition-colors transition-duration-150\" \n" +
            "                            data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden',enterActiveClass: 'scalein', leaveToClass: 'hidden',leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                            <i class=\"pi pi-search mr-2\"></i>\n" +
            "                            <span class=\"font-medium\">Search</span>\n" +
            "                            <i class=\"pi pi-angle-down ml-auto lg:-rotate-90\"></i>\n" +
            "                        </a>\n" +
            "                        <ul class=\"list-none py-0 pl-3 m-0 lg:px-0 lg:py-0 border-round shadow-0 lg:shadow-2 lg:absolute bg-gray-900 hidden origin-top w-full lg:w-15rem cursor-pointer left-100 top-0\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex p-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-shopping-cart mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Purchases</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li class=\"relative\">\n" +
            "                                <a class=\"flex p-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-comments mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Messages</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex p-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-calendar mr-2\"></i>\n" +
            "                    <span>Calendar</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex p-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                    <span>Stats</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "    </div>\n" +
            "</div>\n" ;
    
    private final String block9 = "<div class=\"relative\">\n" +
    "    <div class=\"bg-gray-900 px-6 py-3 lg:py-2 flex align-items-center justify-content-between lg:static border-bottom-none\" style=\"min-height: 81px\">\n" +
    "        <p:graphicImage name=\"images/blocks/logos/bastion-300.svg\" library=\"primeblocks-app\" styleClass=\"mr-0 lg:mr-6\" alt=\"Image\" height=\"40\"/>\n" +
    "        <a class=\"cursor-pointer block lg:hidden text-gray-400\" \n" +
    "            data-pb-styleclass=\"{ selector: '#navbar-sub-9', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true }\">\n" +
    "            <i class=\"pi pi-ellipsis-v text-2xl\"></i>\n" +
    "        </a>\n" +
    "        <div id=\"navbar-sub-9\" class=\"hidden lg:block absolute lg:static lg:w-auto w-full bg-gray-900 left-0 top-100 z-1 shadow-2 lg:shadow-none\">\n" +
    "            <ul class=\"list-none p-0 m-0 flex lg:align-items-center select-none flex-column lg:flex-row border-top-1 border-gray-800  lg:border-top-none\">\n" +
    "                <li>\n" +
    "                    <a class=\"flex px-6 p-3 lg:px-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
    "                        <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
    "                        <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
    "                    </a>\n" +
    "                </li>\n" +
    "                <li>\n" +
    "                    <a class=\"flex px-6 p-3 lg:px-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
    "                        <p:badge severity=\"danger\">\n" +
    "                            <i class=\"pi pi-bell text-base lg:text-2xl mr-2 lg:mr-0\" />\n" +
    "                        </p:badge>\n" +
    "                        <span class=\"block lg:hidden font-medium\">Notifications</span>\n" +
    "                    </a>\n" +
    "                </li>\n" +
    "                <li class=\"border-top-1 border-gray-800 lg:border-top-none\">\n" +
    "                    <a class=\"flex px-6 p-3 lg:px-3 align-items-center hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
    "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\" styleClass=\"mr-3 lg:mr-0\" alt=\"Image\" style=\"width: 28px; height: 28px\"/>\n" +
    "                        <div class=\"block lg:hidden\">\n" +
    "                            <div class=\"text-gray-400 font-medium\">Josephine Lillard</div>\n" +
    "                            <span class=\"text-gray-500 font-medium text-sm\">Marketing Specialist</span>\n" +
    "                        </div>\n" +
    "                    </a>\n" +
    "                </li>\n" +
    "            </ul>\n" +
    "        </div>\n" +
    "    </div>\n" +
    "    <div class=\"flex\" style=\"min-height: 66px\">\n" +
    "        <div class=\"cursor-pointer flex bg-indigo-700 px-6 py-2 align-items-center hover:bg-indigo-600 transition-colors transition-duration-150 relative\"\n" +
    "            data-pb-styleclass=\"{ selector: '#dashboards', enterClass: 'hidden', enterActiveClass: 'scalein', leaveToClass: 'hidden',leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
    "            <span class=\"border-round bg-orange-400 text-gray-900 inline-flex align-items-center justify-content-center flex-shrink-0 mr-3\" style=\"width:40px;height:40px\">AD</span>\n" +
    "            <div class=\"hidden lg:block select-none\">\n" +
    "                <span class=\"text-indigo-100 block mb-1 text-lg font-medium white-space-nowrap\">Analytics Dashboard</span>\n" +
    "                <p class=\"m-0 text-indigo-200\">5 New Actions</p>\n" +
    "            </div>\n" +
    "            <i class=\"pi pi-chevron-down text-indigo-200 ml-3 lg:ml-5\"></i>\n" +
    "            <div id=\"dashboards\" class=\"hidden absolute left-0 top-100 shadow-2 bg-indigo-700 border-round-bottom w-full origin-top\">\n" +
    "                <ul class=\"list-none m-0 px-0 lg:px-6 py-3\">\n" +
    "                    <li>\n" +
    "                        <a class=\"flex p-3 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 transition-colors transition-duration-150 border-round select-none\">\n" +
    "                            <i class=\"pi pi-shopping-cart mr-2\"></i>\n" +
    "                            <span class=\"font-medium\">Sales</span>\n" +
    "                        </a>\n" +
    "                    </li>\n" +
    "                    <li>\n" +
    "                        <a class=\"flex p-3 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 transition-colors transition-duration-150 border-round select-none\">\n" +
    "                            <i class=\"pi pi-users mr-2\"></i>\n" +
    "                            <span class=\"font-medium\">Users</span>\n" +
    "                        </a>\n" +
    "                    </li>\n" +
    "                </ul>\n" +
    "            </div>\n" +
    "        </div>\n" +
    "        <div class=\"bg-indigo-500 flex-1 flex align-items-center\">\n" +
    "            <a class=\"cursor-pointer block xl:hidden text-indigo-100 ml-auto mr-6\" \n" +
    "                data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true }\">\n" +
    "                <i class=\"pi pi-bars text-4xl\"></i>\n" +
    "            </a>\n" +
    "            <div class=\"xl:block hidden absolute xl:static bg-indigo-500 w-full left-0 top-100 z-1 shadow-2\">\n" +
    "                <ul class=\"list-none py-2 px-6 m-0 flex xl:align-items-center flex-column xl:flex-row select-none\">\n" +
    "                    <li>\n" +
    "                        <a class=\"flex p-3  align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
    "                            <i class=\"pi pi-home mr-2\"></i>\n" +
    "                            <span>Home</span>\n" +
    "                        </a>\n" +
    "                    </li>\n" +
    "                    <li class=\"xl:relative\">\n" +
    "                        <a class=\"flex p-3 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\"\n" +
    "                            data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden',enterActiveClass: 'scalein', leaveToClass: 'hidden',leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
    "                            <i class=\"pi pi-users mr-2\"></i>\n" +
    "                            <span>Customers</span>\n" +
    "                            <i class=\"pi pi-angle-down ml-auto xl:ml-3\"></i>\n" +
    "                        </a>\n" +
    "                        <ul class=\"list-none py-0 pl-3 m-0 xl:px-0 xl:py-0 border-round shadow-0 xl:shadow-2 xl:absolute bg-indigo-500 hidden origin-top w-full xl:w-15rem cursor-pointer\">\n" +
    "                            <li>\n" +
    "                                <a class=\"flex p-3 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 transition-colors transition-duration-150\">\n" +
    "                                    <i class=\"pi pi-user-plus mr-2\"></i>\n" +
    "                                    <span class=\"font-medium\">Add New</span>\n" +
    "                                </a>\n" +
    "                            </li>\n" +
    "                            <li class=\"relative\">\n" +
    "                                <a class=\"flex p-3 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 transition-colors transition-duration-150\" \n" +
    "                                    data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden',enterActiveClass: 'scalein', leaveToClass: 'hidden',leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
    "                                    <i class=\"pi pi-search mr-2\"></i>\n" +
    "                                    <span class=\"font-medium\">Search</span>\n" +
    "                                    <i class=\"pi pi-angle-down ml-auto xl:-rotate-90\"></i>\n" +
    "                                </a>\n" +
    "                                <ul class=\"list-none py-0 pl-3 m-0 xl:px-0 xl:py-0 border-round shadow-0 xl:shadow-2 xl:absolute bg-indigo-500 hidden origin-top w-full xl:w-15rem cursor-pointer left-100 top-0\">\n" +
    "                                    <li>\n" +
    "                                        <a class=\"flex p-3 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 transition-colors transition-duration-150\">\n" +
    "                                            <i class=\"pi pi-shopping-cart mr-2\"></i>\n" +
    "                                            <span class=\"font-medium\">Purchases</span>\n" +
    "                                        </a>\n" +
    "                                    </li>\n" +
    "                                    <li class=\"relative\">\n" +
    "                                        <a class=\"flex p-3 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 transition-colors transition-duration-150\">\n" +
    "                                            <i class=\"pi pi-comments mr-2\"></i>\n" +
    "                                            <span class=\"font-medium\">Messages</span>\n" +
    "                                        </a>\n" +
    "                                    </li>\n" +
    "                                </ul>\n" +
    "                            </li>\n" +
    "                        </ul>\n" +
    "                    </li>\n" +
    "                    <li>\n" +
    "                        <a class=\"flex p-3 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
    "                            <i class=\"pi pi-calendar mr-2\"></i>\n" +
    "                            <span>Calendar</span>\n" +
    "                        </a>\n" +
    "                    </li>\n" +
    "                    <li>\n" +
    "                        <a class=\"flex p-3  align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
    "                            <i class=\"pi pi-chart-line mr-2\"></i>\n" +
    "                            <span>Stats</span>\n" +
    "                        </a>\n" +
    "                    </li>\n" +
    "                    <li class=\"border-top-1 xl:border-left-1 my-3 xl:my-0 xl:border-top-none border-indigo-400 xl:ml-auto pl-3\">\n" +
    "                        <span class=\"p-input-icon-left\">\n" +
    "                            <i class=\"pi pi-search text-indigo-200\"></i>\n" +
    "                            \n" +
    "                            <p:inputText styleClass=\"appearance-none border-none shadow-none flex-auto bg-transparent outline-none p-component text-indigo-300 pl-3\"/>\n" +
    "                        </span>\n" +
    "                    </li>\n" +
    "                </ul>\n" +
    "            </div>\n" +
    "        </div>\n" +
    "    </div>\n" +
    "</div>\n" ;

    private String block10 = "<div class=\"bg-indigo-500 px-6 shadow-2 flex relative lg:static\" style=\"min-height: 75px\">\n" +
    "    <div class=\"cursor-pointer flex p-3 align-items-center hover:bg-indigo-600 transition-colors transition-duration-150 relative select-none\"\n" +
    "        data-pb-styleclass=\"{ selector: '#profile-10', enterClass: 'hidden', enterActiveClass: 'scalein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
    "        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-6.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"lg:mr-3\" style=\"width: 40px; height: 40px\"/>\n" +
    "        <div class=\"hidden lg:block\">\n" +
    "            <span class=\"text-indigo-100 block mb-1 text-lg font-medium white-space-nowrap\">Kristin Watson</span>\n" +
    "            <p class=\"m-0 text-indigo-200\">Manager</p>\n" +
    "        </div>\n" +
    "        <i class=\"pi pi-chevron-down text-indigo-200 ml-3 hidden lg:block\"></i>\n" +
    "        <div id=\"profile-10\" class=\"hidden absolute left-0 top-100 shadow-2 bg-indigo-600 border-round-bottom w-15rem lg:w-full origin-top\">\n" +
    "            <ul class=\"list-none m-0 p-3\">\n" +
    "                <li>\n" +
    "                    <a class=\"flex p-3 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 transition-colors transition-duration-150 border-round\">\n" +
    "                        <i class=\"pi pi-user mr-2\"></i>\n" +
    "                        <span class=\"font-medium\">Profile</span>\n" +
    "                    </a>\n" +
    "                </li>\n" +
    "                <li>\n" +
    "                    <a class=\"flex p-3 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 transition-colors transition-duration-150 border-round\">\n" +
    "                        <i class=\"pi pi-cog mr-2\"></i>\n" +
    "                        <span class=\"font-medium\">Settings</span>\n" +
    "                    </a>\n" +
    "                </li>\n" +
    "                <li>\n" +
    "                    <a class=\"flex p-3 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 transition-colors transition-duration-150 border-round\">\n" +
    "                        <i class=\"pi pi-sign-out mr-2\"></i>\n" +
    "                        <span class=\"font-medium\">Sign Out</span>\n" +
    "                    </a>\n" +
    "                </li>\n" +
    "            </ul>\n" +
    "        </div>\n" +
    "    </div>\n" +
    "    <div class=\"flex-auto flex pl-5 overflow-auto\">\n" +
    "        <ul class=\"flex list-none p-0 m-0\">\n" +
    "            <li class=\"h-full\">\n" +
    "                <a class=\"cursor-pointer h-full inline-flex align-items-center justify-content-center px-5 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 transition-colors transition-duration-150\">\n" +
    "                    <i class=\"pi pi-home text-2xl\"></i>\n" +
    "                </a>\n" +
    "            </li>\n" +
    "            <li class=\"h-full\">\n" +
    "                <a class=\"cursor-pointer h-full inline-flex align-items-center justify-content-center px-5 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 transition-colors transition-duration-150\">\n" +
    "                    <i class=\"pi pi-users text-2xl\"></i>\n" +
    "                </a>\n" +
    "            </li>\n" +
    "            <li class=\"h-full\">\n" +
    "                <a class=\"cursor-pointer h-full inline-flex align-items-center justify-content-center px-5 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 transition-colors transition-duration-150\">\n" +
    "                    <i class=\"pi pi-calendar text-2xl\"></i>\n" +
    "                </a>\n" +
    "            </li>\n" +
    "            <li class=\"h-full\">\n" +
    "                <a class=\"cursor-pointer h-full inline-flex align-items-center justify-content-center px-5 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 transition-colors transition-duration-150\">\n" +
    "                    <i class=\"pi pi-folder text-2xl\"></i>\n" +
    "                </a>\n" +
    "            </li>\n" +
    "            <li class=\"h-full\">\n" +
    "                <a class=\"cursor-pointer h-full inline-flex align-items-center justify-content-center px-5 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 transition-colors transition-duration-150\">\n" +
    "                    <i class=\"pi pi-chart-line text-2xl\"></i>\n" +
    "                </a>\n" +
    "            </li>\n" +
    "        </ul>\n" +
    "    </div>\n" +
    "    <div class=\"flex ml-5\">\n" +
    "        <a class=\"cursor-pointer inline-flex align-items-center justify-content-center lg:hidden text-white\" \n" +
    "            data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true }\">\n" +
    "            <i class=\"pi pi-bars text-2xl\"></i>\n" +
    "        </a>\n" +
    "        <div class=\"lg:block hidden absolute lg:static left-0 top-100 z-1 shadow-2 lg:shadow-none w-full lg:w-auto bg-indigo-500\">\n" +
    "            <ul class=\"h-full list-none p-0 m-0 flex select-none flex-column lg:flex-row\">\n" +
    "                <li>\n" +
    "                    <a class=\"h-full flex px-6 py-3 lg:px-3 lg:py-0 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium cursor-pointer transition-colors transition-duration-150\">\n" +
    "                        <i class=\"pi pi-search lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
    "                        <span class=\"block lg:hidden font-medium\">Search</span>\n" +
    "                    </a>\n" +
    "                </li>\n" +
    "                <li>\n" +
    "                    <a class=\"h-full flex px-6 py-3 lg:px-3 lg:py-0 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium cursor-pointer transition-colors transition-duration-150\">\n" +
    "                        <i class=\"pi pi-inbox lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
    "                        <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
    "                    </a>\n" +
    "                </li>\n" +
    "                <li>\n" +
    "                    <a class=\"h-full flex px-6 py-3 lg:px-3 lg:py-0 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium cursor-pointer transition-colors transition-duration-150\">\n" +
    "                        <p:badge severity=\"danger\">\n" +
    "                            <i class=\"pi pi-bell lg:text-2xl mr-2 lg:mr-0\"/>\n" +
    "                        </p:badge>\n" +
    "                        <span class=\"block lg:hidden font-medium\">Notifications</span>\n" +
    "                    </a>\n" +
    "                </li>\n" +
    "            </ul>\n" +
    "        </div>\n" +
    "    </div>\n" +
    "</div>\n" ;        

    private final String block11 = "<div class=\"surface-overlay shadow-2 flex relative lg:static justify-content-between\" style=\"min-height: 42px\">\n" +
    "    <a class=\"cursor-pointer inline-flex align-items-center px-3 lg:hidden text-700\" \n" +
    "        data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true}\">\n" +
    "        <i class=\"pi pi-bars text-2xl\"></i>\n" +
    "    </a>\n" +
    "    <div class=\"hidden lg:flex absolute lg:static w-full surface-overlay left-0 top-100 z-1 shadow-2 lg:shadow-none\">\n" +
    "        <ul class=\"flex list-none p-0 m-0 flex-column lg:flex-row\">\n" +
    "            <li class=\"h-full\">\n" +
    "                <a class=\"cursor-pointer h-full inline-flex align-items-center text-600 border-left-2 lg:border-left-none lg:border-bottom-2 border-blue-500 transition-colors transition-duration-150 py-3 lg:py-0 px-3\">\n" +
    "                    <span class=\"pi pi-home mr-2\"></span>\n" +
    "                    <span class=\"font-medium\">Home</span>\n" +
    "                </a>\n" +
    "            </li>\n" +
    "            <li class=\"h-full\">\n" +
    "                <a class=\"cursor-pointer h-full inline-flex align-items-center text-600 border-left-2 lg:border-left-none lg:border-bottom-2 border-transparent hover:border-500 transition-colors transition-duration-150 py-3 lg:py-0 px-3\">\n" +
    "                    <span class=\"pi pi-users mr-2\"></span>\n" +
    "                    <span class=\"font-medium\">Customers</span>\n" +
    "                </a>\n" +
    "            </li>\n" +
    "            <li class=\"h-full\">\n" +
    "                <a class=\"cursor-pointer h-full inline-flex align-items-center text-600 border-left-2 lg:border-left-none lg:border-bottom-2 border-transparent hover:border-500 transition-colors transition-duration-150 py-3 lg:py-0 px-3\">\n" +
    "                    <span class=\"pi pi-calendar mr-2\"></span>\n" +
    "                    <span class=\"font-medium\">Calendar</span>\n" +
    "                </a>\n" +
    "            </li>\n" +
    "            <li class=\"h-full\">\n" +
    "                <a class=\"cursor-pointer h-full inline-flex align-items-center text-600 border-left-2 lg:border-left-none lg:border-bottom-2 border-transparent hover:border-500 transition-colors transition-duration-150 py-3 lg:py-0 px-3\">\n" +
    "                    <span class=\"pi pi-home mr-2\"></span>\n" +
    "                    <span class=\"font-medium\">Stats</span>\n" +
    "                </a>\n" +
    "            </li>\n" +
    "        </ul>\n" +
    "    </div>\n" +
    "\n" +
    "    <a class=\"cursor-pointer inline-flex align-items-center px-3 lg:hidden text-700\" \n" +
    "        data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true}\">\n" +
    "        <i class=\"pi pi-ellipsis-v text-xl\"></i>\n" +
    "    </a>\n" +
    "    <div class=\"hidden lg:flex lg:justify-content-end absolute lg:static w-full surface-overlay left-0 top-100 z-1 shadow-2 lg:shadow-none\">\n" +
    "        <ul class=\"flex list-none p-0 m-0 flex-column lg:flex-row\">\n" +
    "            <li class=\"h-full\">\n" +
    "                <a class=\"cursor-pointer h-full inline-flex align-items-center text-600 py-3 lg:py-0 px-3 border-left-2 lg:border-left-none lg:border-bottom-2 border-transparent hover:border-500 transition-colors transition-duration-150\">\n" +
    "                    <span class=\"pi pi-book mr-2 lg:mr-0\"></span>\n" +
    "                    <span class=\"font-medium inline lg:hidden\">Documentation</span>\n" +
    "                </a>\n" +
    "            </li>\n" +
    "            <li class=\"h-full\">\n" +
    "                <a class=\"cursor-pointer h-full inline-flex align-items-center text-600 py-3 lg:py-0 px-3 border-left-2 lg:border-left-none lg:border-bottom-2 border-transparent hover:border-500 transition-colors transition-duration-150\">\n" +
    "                    <span class=\"pi pi-inbox mr-2 lg:mr-0\"></span>\n" +
    "                    <span class=\"font-medium inline lg:hidden\">Inbox</span>\n" +
    "                </a>\n" +
    "            </li>\n" +
    "            <li class=\"h-full\">\n" +
    "                <a  class=\"cursor-pointer h-full inline-flex align-items-center text-600 py-3 lg:py-0 px-3 border-left-2 lg:border-left-none lg:border-bottom-2 border-transparent hover:border-500 transition-colors transition-duration-150\">\n" +
    "                    <span class=\"pi pi-bell mr-2 lg:mr-0\"></span>\n" +
    "                    <span class=\"font-medium inline lg:hidden\">Notifications</span>\n" +
    "                </a>\n" +
    "            </li>\n" +
    "            <li class=\"h-full relative\">\n" +
    "                <a class=\"cursor-pointer h-full inline-flex align-items-center text-600 py-3 lg:py-0 px-3 border-left-2 lg:border-left-none lg:border-bottom-2 border-transparent hover:border-500 transition-colors transition-duration-150\"\n" +
    "                    data-pb-styleclass=\"{ selector: '#profile-11', enterClass: 'hidden', enterActiveClass: 'scalein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true}\">\n" +
    "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"lg:mr-0\" style=\"width: 28px; height: 28px\"/>\n" +
    "                    <span class=\"mx-2 font-medium text-900\">Jane Sanders</span>\n" +
    "                    <i class=\"pi pi-angle-down\"></i>\n" +
    "                </a>\n" +
    "                <div id=\"profile-11\" class=\"hidden static lg:absolute w-full surface-overlay left-0 top-100 z-1 shadow-none lg:shadow-2 origin-top border-round pl-3 lg:pl-0\">\n" +
    "                    <ul class=\"list-none p-0 m-0\">\n" +
    "                        <li>\n" +
    "                            <a class=\"cursor-pointer h-full inline-flex align-items-center text-600 border-left-2 border-transparent hover:border-500 transition-colors transition-duration-150 p-3\">\n" +
    "                                <span class=\"pi pi-user mr-2\"></span>\n" +
    "                                <span class=\"font-medium\">Profile</span>\n" +
    "                            </a>\n" +
    "                        </li>\n" +
    "                        <li>\n" +
    "                            <a class=\"cursor-pointer h-full inline-flex align-items-center text-600 border-left-2 border-transparent hover:border-500 transition-colors transition-duration-150 p-3\">\n" +
    "                                <span class=\"pi pi-cog mr-2\"></span>\n" +
    "                                <span class=\"font-medium\">Settings</span>\n" +
    "                            </a>\n" +
    "                        </li>\n" +
    "                        <li>\n" +
    "                            <a class=\"cursor-pointer h-full inline-flex align-items-center text-600 border-left-2 border-transparent hover:border-500 transition-colors transition-duration-150 p-3\">\n" +
    "                                <span class=\"pi pi-sign-out mr-2\"></span>\n" +
    "                                <span class=\"font-medium\">Sign Out</span>\n" +
    "                            </a>\n" +
    "                        </li>\n" +
    "                    </ul>\n" +
    "                </div>\n" +
    "            </li>        \n" +
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

    public String getBlock11() {
        return block11;
    }

}
