package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class StackedLayoutView implements Serializable {

    private final String block1 = "<div class=\"min-h-screen flex flex-column surface-ground\">\n" +
            "    <div class=\"surface-overlay py-3 px-6 flex align-items-center justify-content-between relative lg:static\"\n" +
            "         style=\"min-height: 80px\">\n" +
            "        <p:graphicImage name=\"images/blocks/logos/bastion-700.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                        styleClass=\"mr-0 lg:mr-6\" height=\"40\"/>\n" +
            "        <a class=\"cursor-pointer block lg:hidden text-700\"\n" +
            "           data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true }\">\n" +
            "            <i class=\"pi pi-bars text-4xl\"/>\n" +
            "        </a>\n" +
            "        <div class=\"align-items-center flex-grow-1 justify-content-between hidden lg:flex absolute lg:static w-full surface-overlay left-0 top-100 z-1 shadow-2 lg:shadow-none\">\n" +
            "            <ul class=\"list-none p-0 m-0 flex lg:align-items-center select-none flex-column lg:flex-row\">\n" +
            "                <li>\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-home mr-2\"/>\n" +
            "                        <span>Home</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"lg:relative\">\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150\"\n" +
            "                       data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'scalein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                        <i class=\"pi pi-users mr-2\"/>\n" +
            "                        <span>Customers</span>\n" +
            "                        <i class=\"pi pi-angle-down ml-auto lg:ml-3\"/>\n" +
            "                    </a>\n" +
            "                    <ul class=\"list-none py-3 px-6 m-0 lg:px-0 lg:py-0 border-round shadow-0 lg:shadow-2 lg:border-1 border-50 lg:absolute surface-overlay hidden origin-top w-full lg:w-15rem cursor-pointer\">\n" +
            "                        <li>\n" +
            "                            <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\">\n" +
            "                                <i class=\"pi pi-user-plus mr-2\"/>\n" +
            "                                <span class=\"font-medium\">Add New</span>\n" +
            "                            </a>\n" +
            "                        </li>\n" +
            "                        <li class=\"relative\">\n" +
            "                            <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\"\n" +
            "                               data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'scalein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                                <i class=\"pi pi-search mr-2\"/>\n" +
            "                                <span class=\"font-medium\">Search</span>\n" +
            "                                <i class=\"pi pi-angle-down ml-auto lg:-rotate-90\"/>\n" +
            "                            </a>\n" +
            "                            <ul class=\"list-none py-3 pl-3 m-0 lg:px-0 lg:py-0 border-round shadow-0 lg:shadow-2 lg:border-1 border-50 lg:absolute surface-overlay hidden origin-top w-full lg:w-15rem cursor-pointer left-100 top-0\">\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\">\n" +
            "                                        <i class=\"pi pi-shopping-cart mr-2\"/>\n" +
            "                                        <span class=\"font-medium\">Purchases</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                                <li class=\"relative\">\n" +
            "                                    <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\">\n" +
            "                                        <i class=\"pi pi-comments mr-2\"/>\n" +
            "                                        <span class=\"font-medium\">Messages</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                            </ul>\n" +
            "                        </li>\n" +
            "                    </ul>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-calendar mr-2\"/>\n" +
            "                        <span>Calendar</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                        <span>Stats</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "            <ul class=\"list-none p-0 m-0 flex lg:align-items-center select-none flex-column lg:flex-row border-top-1 surface-border lg:border-top-none\">\n" +
            "                <li>\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"/>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <p:badge severity=\"danger\">\n" +
            "                            <i class=\"pi pi-bell text-base lg:text-2xl\"/>\n" +
            "                        </p:badge>\n" +
            "                        <span class=\"block lg:hidden font-medium ml-2 lg:ml-0\">Notifications</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"border-top-1 surface-border lg:border-top-none\">\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\"\n" +
            "                                        library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                        styleClass=\"mr-3 lg:mr-0\" style=\"width: 32px; height: 32px\"/>\n" +
            "                        <div class=\"block lg:hidden\">\n" +
            "                            <div class=\"text-900 font-medium\">Josephine Lillard</div>\n" +
            "                            <span class=\"text-600 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                        </div>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <ul class=\"list-none py-3 px-5 m-0 surface-section flex align-items-center font-medium overflow-x-auto border-top-1 border-bottom-1 surface-border\">\n" +
            "        <li class=\"pr-3\">\n" +
            "            <a class=\"cursor-pointer\">\n" +
            "                <i class=\"pi pi-home text-blue-500\"/>\n" +
            "            </a>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <i class=\"pi pi-angle-right text-500\"/>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <a class=\"cursor-pointer text-blue-500 white-space-nowrap\">Level 3</a>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <i class=\"pi pi-angle-right text-500\"/>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <a class=\"cursor-pointer text-blue-500 white-space-nowrap\">Level 2</a>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <i class=\"pi pi-angle-right text-500\"/>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <a class=\"cursor-pointer text-900 white-space-nowrap\">Level 1</a>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "    <div class=\"p-5 flex flex-column flex-auto\">\n" +
            "        <div class=\"border-2 border-dashed surface-border border-round surface-section flex-auto\">\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;
    
    private final String block2 = "<div class=\"min-h-screen flex flex-column surface-ground\">\n" +
            "    <div class=\"bg-gray-900 py-3 px-6 shadow-2 flex align-items-center justify-content-between relative lg:static border-bottom-1 border-gray-800\"\n" +
            "         style=\"min-height: 84px\">\n" +
            "        <p:graphicImage name=\"images/blocks/logos/bastion-300.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                        styleClass=\"mr-0 lg:mr-6\" height=\"40\"/>\n" +
            "        <a class=\"cursor-pointer block lg:hidden text-gray-400\"\n" +
            "           data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true }\">\n" +
            "            <i class=\"pi pi-bars text-4xl\"/>\n" +
            "        </a>\n" +
            "        <div class=\"align-items-center flex-grow-1 justify-content-between hidden lg:flex absolute lg:static w-full bg-gray-900 left-0 top-100 z-1 shadow-2 lg:shadow-none border-1 lg:border-none border-gray-800\">\n" +
            "            <ul class=\"list-none p-0 m-0 flex lg:align-items-center select-none flex-column lg:flex-row\">\n" +
            "                <li>\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-home mr-2\"/>\n" +
            "                        <span>Home</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\"\n" +
            "                       data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'scalein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                        <i class=\"pi pi-users mr-2\"/>\n" +
            "                        <span>Customers</span>\n" +
            "                        <i class=\"pi pi-angle-down ml-auto lg:ml-3\"/>\n" +
            "                    </a>\n" +
            "                    <ul class=\"list-none py-3 px-6 m-0 lg:px-0 lg:py-0 border-round shadow-0 lg:shadow-2 lg:absolute bg-gray-900 hidden origin-top w-full lg:w-15rem cursor-pointer lg:border-1 border-gray-800\">\n" +
            "                        <li>\n" +
            "                            <a class=\"flex p-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 transition-colors transition-duration-150\">\n" +
            "                                <i class=\"pi pi-user-plus mr-2\"/>\n" +
            "                                <span class=\"font-medium\">Add New</span>\n" +
            "                            </a>\n" +
            "                        </li>\n" +
            "                        <li class=\"relative\">\n" +
            "                            <a class=\"flex p-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 transition-colors transition-duration-150\"\n" +
            "                               data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'scalein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                                <i class=\"pi pi-search mr-2\"/>\n" +
            "                                <span class=\"font-medium\">Search</span>\n" +
            "                                <i class=\"pi pi-angle-down ml-auto lg:-rotate-90\"/>\n" +
            "                            </a>\n" +
            "                            <ul class=\"list-none py-3 pl-3 m-0 lg:px-0 lg:py-0 border-round shadow-0 lg:shadow-2 lg:absolute bg-gray-900 hidden origin-top w-full lg:w-15rem cursor-pointer left-100 top-0 lg:border-1 border-gray-800\">\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex p-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 transition-colors transition-duration-150\">\n" +
            "                                        <i class=\"pi pi-shopping-cart mr-2\"/>\n" +
            "                                        <span class=\"font-medium\">Purchases</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                                <li class=\"relative\">\n" +
            "                                    <a class=\"flex p-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 transition-colors transition-duration-150\">\n" +
            "                                        <i class=\"pi pi-comments mr-2\"/>\n" +
            "                                        <span class=\"font-medium\">Messages</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                            </ul>\n" +
            "                        </li>\n" +
            "                    </ul>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-calendar mr-2\"/>\n" +
            "                        <span>Calendar</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                        <span>Stats</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "            <ul class=\"list-none p-0 m-0 flex lg:align-items-center select-none flex-column lg:flex-row\">\n" +
            "                <li class=\"flex-order-2 lg:flex-order-0\">\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 lg:py-2\">\n" +
            "                        <span class=\"ui-input-icon-left w-full\">\n" +
            "                            <i class=\"pi pi-search text-gray-400\"/>\n" +
            "                            <p:inputText placeholder=\"Search\"\n" +
            "                                         styleClass=\"bg-gray-800 text-gray-400 border-gray-800 w-full\"/>\n" +
            "                        </span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"border-top-1 border-gray-800 lg:border-top-none\">\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\"\n" +
            "                                        library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                        styleClass=\"mr-3 lg:mr-0\" style=\"width: 32px; height: 32px\"/>\n" +
            "                        <div class=\"block lg:hidden\">\n" +
            "                            <div class=\"text-white font-medium\">Josephine Lillard</div>\n" +
            "                            <span class=\"text-gray-400 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                        </div>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <ul class=\"list-none py-3 px-5 m-0 surface-section flex align-items-center font-medium overflow-x-auto border-top-1 border-bottom-1 surface-border\">\n" +
            "        <li class=\"pr-3\">\n" +
            "            <a class=\"cursor-pointer\">\n" +
            "                <i class=\"pi pi-home text-blue-500\"/>\n" +
            "            </a>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <i class=\"pi pi-angle-right text-500\"/>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <a class=\"cursor-pointer text-blue-500 white-space-nowrap\">Level 3</a>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <i class=\"pi pi-angle-right text-500\"/>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <a class=\"cursor-pointer text-blue-500 white-space-nowrap\">Level 2</a>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <i class=\"pi pi-angle-right text-500\"/>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <a class=\"cursor-pointer text-900 white-space-nowrap\">Level 1</a>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "    <div class=\"p-5 flex flex-column flex-auto\">\n" +
            "        <div class=\"border-2 border-dashed surface-border border-round surface-section flex-auto\">\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block3 = "<div class=\"min-h-screen flex flex-column\">\n" +
            "    <div class=\"bg-indigo-500 py-3 px-5 flex align-items-center justify-content-between relative lg:static\"\n" +
            "         style=\"min-height: 80px\">\n" +
            "        <p:graphicImage name=\"images/blocks/logos/hyper-300.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                        styleClass=\"mr-0 lg:mr-6\" height=\"40\"/>\n" +
            "        <a class=\"cursor-pointer block lg:hidden text-indigo-50\"\n" +
            "           data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true }\">\n" +
            "            <i class=\"pi pi-bars text-4xl\"/>\n" +
            "        </a>\n" +
            "        <div class=\"align-items-center flex-grow-1 justify-content-between hidden lg:flex absolute lg:static w-full bg-indigo-500 left-0 top-100 z-1 shadow-2 lg:shadow-none\">\n" +
            "            <ul class=\"list-none p-0 m-0 flex lg:align-items-center select-none flex-column lg:flex-row\">\n" +
            "                <li>\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-home mr-2\"/>\n" +
            "                        <span>Home</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\"\n" +
            "                       data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'scalein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                        <i class=\"pi pi-users mr-2\"/>\n" +
            "                        <span>Customers</span>\n" +
            "                        <i class=\"pi pi-angle-down ml-auto lg:ml-3\"/>\n" +
            "                    </a>\n" +
            "                    <ul class=\"list-none py-3 px-6 m-0 lg:px-0 lg:py-0 border-round shadow-0 lg:border-1 border-50 lg:shadow-2 lg:absolute surface-overlay hidden origin-top w-full lg:w-15rem cursor-pointer\">\n" +
            "                        <li>\n" +
            "                            <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\">\n" +
            "                                <i class=\"pi pi-user-plus mr-2\"/>\n" +
            "                                <span class=\"font-medium\">Add New</span>\n" +
            "                            </a>\n" +
            "                        </li>\n" +
            "                        <li class=\"relative\">\n" +
            "                            <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\"\n" +
            "                               data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'scalein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                                <i class=\"pi pi-search mr-2\"/>\n" +
            "                                <span class=\"font-medium\">Search</span>\n" +
            "                                <i class=\"pi pi-angle-down ml-auto lg:-rotate-90\"/>\n" +
            "                            </a>\n" +
            "                            <ul class=\"list-none py-3 pl-3 m-0 lg:px-0 lg:py-0 border-round shadow-0 lg:border-1 border-50 lg:shadow-2 lg:absolute surface-overlay hidden origin-top w-full lg:w-15rem cursor-pointer left-100 top-0\">\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\">\n" +
            "                                        <i class=\"pi pi-shopping-cart mr-2\"/>\n" +
            "                                        <span class=\"font-medium\">Purchases</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                                <li class=\"relative\">\n" +
            "                                    <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\">\n" +
            "                                        <i class=\"pi pi-comments mr-2\"/>\n" +
            "                                        <span class=\"font-medium\">Messages</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                            </ul>\n" +
            "                        </li>\n" +
            "                    </ul>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-calendar mr-2\"/>\n" +
            "                        <span>Calendar</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                        <span>Stats</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "            <ul class=\"list-none p-0 m-0 flex lg:align-items-center select-none flex-column lg:flex-row border-top-1 border-indigo-400 lg:border-top-none\">\n" +
            "                <li>\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"/>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-bell text-base lg:text-2xl mr-2 lg:mr-0\"/>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Notifications</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"border-top-1 border-indigo-400 lg:border-top-none\">\n" +
            "                    <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\"\n" +
            "                                        library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                        styleClass=\"mr-3 lg:mr-0\" style=\"width: 32px; height: 32px\"/>\n" +
            "                        <div class=\"block lg:hidden\">\n" +
            "                            <div class=\"text-indigo-50 font-medium\">Josephine Lillard</div>\n" +
            "                            <span class=\"text-indigo-100 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                        </div>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <ul class=\"list-none py-3 px-5 m-0 surface-section flex align-items-center font-medium overflow-x-auto border-top-1 border-bottom-1 surface-border shadow-2 lg:shadow-none\">\n" +
            "        <li class=\"pr-3\">\n" +
            "            <a class=\"cursor-pointer\">\n" +
            "                <i class=\"pi pi-home text-blue-500\"/>\n" +
            "            </a>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <i class=\"pi pi-angle-right text-500\"/>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <a class=\"cursor-pointer text-blue-500 white-space-nowrap\">Level 3</a>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <i class=\"pi pi-angle-right text-500\"/>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <a class=\"cursor-pointer text-blue-500 white-space-nowrap\">Level 2</a>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <i class=\"pi pi-angle-right text-500\"/>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <a class=\"cursor-pointer text-900 white-space-nowrap\">Level 1</a>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "    <div class=\"p-5 flex flex-column flex-auto\">\n" +
            "        <div class=\"border-2 border-dashed surface-border border-round surface-section flex-auto\">\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block4 = "<div class=\"min-h-screen flex flex-column\">\n" +
            "    <div class=\"bg-indigo-500\" style=\"height:250px\">\n" +
            "        <div class=\"py-3 px-5 flex align-items-center justify-content-between relative lg:static\" style=\"min-height: 80px\">\n" +
            "            <p:graphicImage name=\"images/blocks/logos/hyper-300.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                        styleClass=\"mr-0 lg:mr-6\" height=\"40\"/>\n" +
            "            <a class=\"cursor-pointer block lg:hidden text-indigo-50\" \n" +
            "                data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true}\">\n" +
            "                <i class=\"pi pi-bars text-4xl\"></i>\n" +
            "            </a>\n" +
            "            <div class=\"align-items-center flex-grow-1 justify-content-between hidden lg:flex absolute lg:static w-full bg-indigo-500 left-0 top-100 z-1\">\n" +
            "                <ul class=\"list-none p-0 m-0 flex lg:align-items-center select-none flex-column lg:flex-row\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-home mr-2\"></i>\n" +
            "                            <span>Home</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\"\n" +
            "                            data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'scalein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true}\">\n" +
            "                            <i class=\"pi pi-users mr-2\"></i>\n" +
            "                            <span>Customers</span>\n" +
            "                            <i class=\"pi pi-angle-down ml-auto lg:ml-3\"></i>\n" +
            "                        </a>\n" +
            "                        <ul class=\"list-none py-3 px-6 m-0 lg:px-0 lg:py-0 border-round shadow-0 lg:border-1 border-50 lg:shadow-2 lg:absolute surface-overlay hidden origin-top w-full lg:w-15rem cursor-pointer\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-user-plus mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Add New</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li class=\"relative\">\n" +
            "                                <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\" \n" +
            "                                data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'scalein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true}\">\n" +
            "                                    <i class=\"pi pi-search mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Search</span>\n" +
            "                                    <i class=\"pi pi-angle-down ml-auto lg:-rotate-90\"></i>\n" +
            "                                </a>\n" +
            "                                <ul class=\"list-none py-3 pl-3 m-0 lg:px-0 lg:py-0 border-round shadow-0 lg:border-1 border-50 lg:shadow-2 lg:absolute surface-overlay hidden origin-top w-full lg:w-15rem cursor-pointer left-100 top-0\">\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\">\n" +
            "                                            <i class=\"pi pi-shopping-cart mr-2\"></i>\n" +
            "                                            <span class=\"font-medium\">Purchases</span>\n" +
            "                                        </a>\n" +
            "                                    </li>\n" +
            "                                    <li class=\"relative\">\n" +
            "                                        <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 transition-colors transition-duration-150\">\n" +
            "                                            <i class=\"pi pi-comments mr-2\"></i>\n" +
            "                                            <span class=\"font-medium\">Messages</span>\n" +
            "                                        </a>\n" +
            "                                    </li>\n" +
            "                                </ul>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-calendar mr-2\"></i>\n" +
            "                            <span>Calendar</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                            <span>Stats</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "                <ul class=\"list-none p-0 m-0 flex lg:align-items-center select-none flex-column lg:flex-row border-top-1 border-indigo-400 lg:border-top-none\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
            "                            <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-bell text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
            "                            <span class=\"block lg:hidden font-medium\">Notifications</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"border-top-1 border-indigo-400 lg:border-top-none\">\n" +
            "                        <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center hover:bg-indigo-600 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                            <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-3 lg:mr-0\" height=\"40\" style=\"width: 32px; height: 32px\"/>\n" +
            "                            <div class=\"block lg:hidden\">\n" +
            "                                <div class=\"text-indigo-50 font-medium\">Josephine Lillard</div>\n" +
            "                                <span class=\"text-indigo-100 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                            </div>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <ul class=\"list-none py-3 px-5 m-0 flex align-items-center font-medium overflow-x-auto border-top-1 border-indigo-600\">\n" +
            "            <li class=\"pr-3\">\n" +
            "                <a class=\"cursor-pointer\">\n" +
            "                    <i class=\"pi pi-home text-indigo-200\"></i>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li class=\"px-2\">\n" +
            "                <i class=\"pi pi-angle-right text-indigo-200\"></i>\n" +
            "            </li>\n" +
            "            <li class=\"px-2\">\n" +
            "                <a class=\"cursor-pointer text-indigo-200 white-space-nowrap\">Level 3</a>\n" +
            "            </li>\n" +
            "            <li class=\"px-2\">\n" +
            "                <i class=\"pi pi-angle-right text-indigo-100\"></i>\n" +
            "            </li>\n" +
            "            <li class=\"px-2\">\n" +
            "                <a class=\"cursor-pointer text-indigo-200 white-space-nowrap\">Level 2</a>\n" +
            "            </li>\n" +
            "            <li class=\"px-2\">\n" +
            "                <i class=\"pi pi-angle-right text-indigo-200\"></i>\n" +
            "            </li>\n" +
            "            <li class=\"px-2\">\n" +
            "                <a class=\"cursor-pointer text-indigo-100 white-space-nowrap\">Level 1</a>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "    </div>\n" +
            "    <div class=\"p-5 flex flex-column flex-auto\" style=\"margin-top: -8rem\">\n" +
            "        <div class=\"border-2 border-dashed surface-border border-round surface-section flex-auto\">\n" +
            "            \n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block5 = "<div class=\"min-h-screen flex flex-column\">\n" +
            "    <div class=\"bg-gray-900\" style=\"height:250px\">\n" +
            "        <div class=\"py-3 px-5 flex align-items-center justify-content-between relative lg:static\" style=\"min-height: 80px\">\n" +
            "            <p:graphicImage name=\"images/blocks/logos/hyper-300.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                        styleClass=\"mr-0 lg:mr-6\" height=\"40\"/>\n" +
            "            <a class=\"cursor-pointer block lg:hidden text-gray-400\" \n" +
            "                data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true}\">\n" +
            "                <i class=\"pi pi-bars text-4xl\"></i>\n" +
            "            </a>\n" +
            "            <div class=\"align-items-center flex-grow-1 justify-content-between hidden lg:flex absolute lg:static w-full bg-gray-900 left-0 top-100 z-1\">\n" +
            "                <ul class=\"list-none p-0 m-0 flex lg:align-items-center select-none flex-column lg:flex-row\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-home mr-2\"></i>\n" +
            "                            <span>Home</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\"\n" +
            "                            data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'scalein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true}\">\n" +
            "                            <i class=\"pi pi-users mr-2\"></i>\n" +
            "                            <span>Customers</span>\n" +
            "                            <i class=\"pi pi-angle-down ml-auto lg:ml-3\"></i>\n" +
            "                        </a>\n" +
            "                        <ul class=\"list-none py-3 px-6 m-0 lg:px-0 lg:py-0 border-round shadow-0 lg:shadow-2 lg:absolute bg-gray-900 hidden origin-top w-full lg:w-15rem cursor-pointer lg:border-1 border-gray-800\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex p-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-user-plus mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Add New</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li class=\"relative\">\n" +
            "                                <a class=\"flex p-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 transition-colors transition-duration-150\" \n" +
            "                                    data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'scalein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true}\">\n" +
            "                                    <i class=\"pi pi-search mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Search</span>\n" +
            "                                    <i class=\"pi pi-angle-down ml-auto lg:-rotate-90\"></i>\n" +
            "                                </a>\n" +
            "                                <ul class=\"list-none py-3 pl-3 m-0 lg:px-0 lg:py-0 border-round shadow-0 lg:shadow-2 lg:absolute bg-gray-900 hidden origin-top w-full lg:w-15rem cursor-pointer left-100 top-0 lg:border-1 border-gray-800\">\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex p-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 transition-colors transition-duration-150\">\n" +
            "                                            <i class=\"pi pi-shopping-cart mr-2\"></i>\n" +
            "                                            <span class=\"font-medium\">Purchases</span>\n" +
            "                                        </a>\n" +
            "                                    </li>\n" +
            "                                    <li class=\"relative\">\n" +
            "                                        <a class=\"flex p-3 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 transition-colors transition-duration-150\">\n" +
            "                                            <i class=\"pi pi-comments mr-2\"></i>\n" +
            "                                            <span class=\"font-medium\">Messages</span>\n" +
            "                                        </a>\n" +
            "                                    </li>\n" +
            "                                </ul>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-calendar mr-2\"></i>\n" +
            "                            <span>Calendar</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                            <span>Stats</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "                <ul class=\"list-none p-0 m-0 flex lg:align-items-center select-none flex-column lg:flex-row border-top-1 border-gray-800 lg:border-top-none\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
            "                            <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center text-gray-400 hover:text-white hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-bell text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
            "                            <span class=\"block lg:hidden font-medium\">Notifications</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"border-top-1 border-gray-800 lg:border-top-none\">\n" +
            "                        <a class=\"flex px-6 p-3 lg:px-3 lg:py-2 align-items-center hover:bg-gray-800 font-medium border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                            <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-3 lg:mr-0\" height=\"40\" style=\"width: 32px; height: 32px\"/>\n" +
            "                            <div class=\"block lg:hidden\">\n" +
            "                                <div class=\"text-white font-medium\">Josephine Lillard</div>\n" +
            "                                <span class=\"text-gray-400 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                            </div>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <ul class=\"list-none py-3 px-5 m-0 flex align-items-center font-medium overflow-x-auto border-top-1 border-gray-800\">\n" +
            "            <li class=\"pr-3\">\n" +
            "                <a class=\"cursor-pointer\">\n" +
            "                    <i class=\"pi pi-home text-gray-400\"></i>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li class=\"px-2\">\n" +
            "                <i class=\"pi pi-angle-right text-gray-400\"></i>\n" +
            "            </li>\n" +
            "            <li class=\"px-2\">\n" +
            "                <a class=\"cursor-pointer text-gray-400 white-space-nowrap\">Level 3</a>\n" +
            "            </li>\n" +
            "            <li class=\"px-2\">\n" +
            "                <i class=\"pi pi-angle-right text-gray-400\"></i>\n" +
            "            </li>\n" +
            "            <li class=\"px-2\">\n" +
            "                <a class=\"cursor-pointer text-gray-400 white-space-nowrap\">Level 2</a>\n" +
            "            </li>\n" +
            "            <li class=\"px-2\">\n" +
            "                <i class=\"pi pi-angle-right text-gray-400\"></i>\n" +
            "            </li>\n" +
            "            <li class=\"px-2\">\n" +
            "                <a class=\"cursor-pointer text-indigo-300 white-space-nowrap\">Level 1</a>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "    </div>\n" +
            "    <div class=\"p-5 flex flex-column flex-auto\" style=\"margin-top: -8rem\">\n" +
            "        <div class=\"border-2 border-dashed surface-border border-round surface-section flex-auto\">\n" +
            "            \n" +
            "        </div>\n" +
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
}
