package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class VerticalNavView implements Serializable {

    private final String block1 = "<div class=\"surface-card shadow-2 border-round w-full lg:w-auto select-none\" style=\"min-width: 16rem\">\n" +
            "    <ul class=\"list-none p-2 m-0\">\n" +
            "        <li>\n" +
            "            <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                <i class=\"pi pi-home mr-2 text-700\"/>\n" +
            "                <span class=\"font-medium text-700\">Dashboard</span>\n" +
            "            </a>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                <i class=\"pi pi-bookmark mr-2 text-700\"/>\n" +
            "                <span class=\"font-medium text-700\">Bookmarks</span>\n" +
            "                <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-blue-100 text-blue-900 border-circle\"\n" +
            "                      style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "            </a>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                <i class=\"pi pi-users mr-2 text-700\"/>\n" +
            "                <span class=\"font-medium text-700\">Team</span>\n" +
            "            </a>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                <i class=\"pi pi-comments mr-2 text-700\"/>\n" +
            "                <span class=\"font-medium text-700\">Messages</span>\n" +
            "            </a>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                <i class=\"pi pi-calendar mr-2 text-700\"/>\n" +
            "                <span class=\"font-medium text-700\">Calendar</span>\n" +
            "                <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-purple-100 text-purple-900 border-circle\"\n" +
            "                      style=\"min-width: 1.5rem; height: 1.5rem\">2</span>\n" +
            "            </a>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "</div>" ;
    
    private final String block2 = "<div class=\"surface-card shadow-2 border-round w-full lg:w-auto select-none\" style=\"min-width: 16rem\">\n" +
            "    <ul class=\"list-none p-2 m-0\">\n" +
            "        <li>\n" +
            "            <div class=\"p-3 text-500 font-medium\">HOME</div>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                <i class=\"pi pi-home mr-2 text-700\"/>\n" +
            "                <span class=\"font-medium text-700\">Dashboard</span>\n" +
            "            </a>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                <i class=\"pi pi-bookmark mr-2 text-700\"/>\n" +
            "                <span class=\"font-medium text-700\">Bookmarks</span>\n" +
            "                <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-blue-100 text-blue-900 border-circle\"\n" +
            "                      style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "            </a>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                <i class=\"pi pi-users mr-2 text-700\"/>\n" +
            "                <span class=\"font-medium text-700\">Team</span>\n" +
            "            </a>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                <i class=\"pi pi-comments mr-2 text-700\"/>\n" +
            "                <span class=\"font-medium text-700\">Messages</span>\n" +
            "            </a>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                <i class=\"pi pi-calendar mr-2 text-700\"/>\n" +
            "                <span class=\"font-medium text-700\">Calendar</span>\n" +
            "                <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-purple-100 text-purple-900 border-circle\"\n" +
            "                      style=\"min-width: 1.5rem; height: 1.5rem\">2</span>\n" +
            "            </a>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "    <ul class=\"list-none p-2 m-0 border-top-1 surface-border\">\n" +
            "        <li>\n" +
            "            <div class=\"p-3 text-500 font-medium\">ORGANIZATION</div>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                <i class=\"pi pi-home mr-2 text-700\"/>\n" +
            "                <span class=\"font-medium text-700\">Overview</span>\n" +
            "            </a>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                <i class=\"pi pi-bookmark mr-2 text-700\"/>\n" +
            "                <span class=\"font-medium text-700\">Security</span>\n" +
            "                <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-cyan-100 text-cyan-900 border-circle\"\n" +
            "                      style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "            </a>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                <i class=\"pi pi-users mr-2 text-700\"/>\n" +
            "                <span class=\"font-medium text-700\">Domains</span>\n" +
            "            </a>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                <i class=\"pi pi-calendar mr-2 text-700\"/>\n" +
            "                <span class=\"font-medium text-700\">Reports</span>\n" +
            "                <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-orange-100 text-orange-900 border-circle\"\n" +
            "                      style=\"min-width: 1.5rem; height: 1.5rem\">2</span>\n" +
            "            </a>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "</div>" ;

    private final String block3 = "<div class=\"bg-indigo-500 shadow-2 border-round w-full lg:w-auto select-none\" style=\"min-width: 16rem\">\n" +
            "    <ul class=\"list-none p-2 m-0\">\n" +
            "        <li>\n" +
            "            <div class=\"p-3 flex align-items-center justify-content-between text-indigo-300 cursor-pointer\"\n" +
            "                 data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                <span class=\"font-medium\">HOME</span>\n" +
            "                <i class=\"pi pi-chevron-down\"/>\n" +
            "            </div>\n" +
            "            <ul class=\"list-none p-0 m-0 overflow-hidden\">\n" +
            "                <li>\n" +
            "                    <a class=\"flex align-items-center cursor-pointer p-3 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-home mr-2\"/>\n" +
            "                        <span class=\"font-medium\">Dashboard</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex align-items-center cursor-pointer p-3 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-bookmark mr-2\"/>\n" +
            "                        <span class=\"font-medium\">Bookmarks</span>\n" +
            "                        <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-blue-100 text-blue-900 border-circle\"\n" +
            "                              style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex align-items-center cursor-pointer p-3 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-users mr-2\"/>\n" +
            "                        <span class=\"font-medium\">Team</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex align-items-center cursor-pointer p-3 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-comments mr-2\"/>\n" +
            "                        <span class=\"font-medium\">Messages</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex align-items-center cursor-pointer p-3 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-calendar mr-2\"/>\n" +
            "                        <span class=\"font-medium\">Calendar</span>\n" +
            "                        <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-purple-100 text-purple-900 border-circle\"\n" +
            "                              style=\"min-width: 1.5rem; height: 1.5rem\">2</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "    <ul class=\"list-none p-2 m-0 border-top-1 border-indigo-400\">\n" +
            "        <li>\n" +
            "            <div class=\"p-3 flex align-items-center justify-content-between text-indigo-300 cursor-pointer\"\n" +
            "                 data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                <span class=\"font-medium\">ORGANIZATION</span>\n" +
            "                <i class=\"pi pi-chevron-down\"/>\n" +
            "            </div>\n" +
            "            <ul class=\"list-none p-0 m-0 overflow-hidden\">\n" +
            "                <li>\n" +
            "                    <a class=\"flex align-items-center cursor-pointer p-3 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-home mr-2\"/>\n" +
            "                        <span class=\"font-medium\">Overview</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex align-items-center cursor-pointer p-3 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-bookmark mr-2\"/>\n" +
            "                        <span class=\"font-medium\">Security</span>\n" +
            "                        <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-cyan-100 text-cyan-900 border-circle\"\n" +
            "                              style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex align-items-center cursor-pointer p-3 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-users mr-2\"/>\n" +
            "                        <span class=\"font-medium\">Domains</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex align-items-center cursor-pointer p-3 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-calendar mr-2\"/>\n" +
            "                        <span class=\"font-medium\">Reports</span>\n" +
            "                        <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-orange-100 text-orange-900 border-circle\"\n" +
            "                              style=\"min-width: 1.5rem; height: 1.5rem\">2</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "</div>" ;

    private final String block4 = "<div class=\"bg-gray-900 shadow-2 border-round select-none\">\n" +
            "    <ul class=\"list-none p-2 m-0\">\n" +
            "        <li>\n" +
            "            <div class=\"p-3 flex align-items-center justify-content-between text-gray-600 cursor-pointer\" \n" +
            "                data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                <span class=\"font-medium\">HOME</span>\n" +
            "                <i class=\"pi pi-chevron-down\"></i>\n" +
            "            </div>\n" +
            "            <ul class=\"list-none p-0 m-0 overflow-hidden\">\n" +
            "                <li>\n" +
            "                    <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:text-white hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-home mr-2\"></i>\n" +
            "                        <span class=\"font-medium\">Dashboard</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:text-white hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-bookmark mr-2\"></i>\n" +
            "                        <span class=\"font-medium\">Bookmarks</span>\n" +
            "                        <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-blue-100 text-blue-900 border-circle\" style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:text-white hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-users mr-2\"></i>\n" +
            "                        <span class=\"font-medium\">Team</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:text-white hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-comments mr-2\"></i>\n" +
            "                        <span class=\"font-medium\">Messages</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:text-white hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-calendar mr-2\"></i>\n" +
            "                        <span class=\"font-medium\">Calendar</span>\n" +
            "                        <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-purple-100 text-purple-900 border-circle\" style=\"min-width: 1.5rem; height: 1.5rem\">2</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "    <ul class=\"list-none p-2 m-0 border-top-1 border-gray-800\">\n" +
            "        <li>\n" +
            "            <div class=\"p-3 flex align-items-center justify-content-between text-gray-600 cursor-pointer\" \n" +
            "                data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                <span class=\"font-medium\">ORGANIZATION</span>\n" +
            "                <i class=\"pi pi-chevron-down\"></i>\n" +
            "            </div>\n" +
            "            <ul class=\"list-none p-0 m-0 overflow-hidden\">\n" +
            "                <li>\n" +
            "                    <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:text-white hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-home mr-2\"></i>\n" +
            "                        <span class=\"font-medium\">Overview</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:text-white hover:bg-gray-800 border-round transition-colors transition-duration-150\"\n" +
            "                        data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                        <i class=\"pi pi-chart-bar mr-2\"></i>\n" +
            "                        <span class=\"font-medium\">Reports</span>\n" +
            "                        <i class=\"pi pi-chevron-down ml-auto text-gray-600\"></i>\n" +
            "                    </a>\n" +
            "                    <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                        <li>\n" +
            "                            <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:text-white hover:bg-gray-800 border-round transition-colors transition-duration-150\"\n" +
            "                                data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                                <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                                <span class=\"font-medium\">Revenue</span>\n" +
            "                                <i class=\"pi pi-chevron-down ml-auto text-gray-600\"></i>\n" +
            "                            </a>\n" +
            "                            <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:text-white hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                                        <i class=\"pi pi-table mr-2\"></i>\n" +
            "                                        <span class=\"font-medium\">View</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:text-white hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                                        <i class=\"pi pi-search mr-2\"></i>\n" +
            "                                        <span class=\"font-medium\">Search</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                            </ul>\n" +
            "                        </li>\n" +
            "                        <li>\n" +
            "                            <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:text-white hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                                <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                                <span class=\"font-medium\">Expenses</span>\n" +
            "                            </a>\n" +
            "                        </li>\n" +
            "                    </ul>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:text-white hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-bookmark mr-2\"></i>\n" +
            "                        <span class=\"font-medium\">Security</span>\n" +
            "                        <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-cyan-100 text-cyan-900 border-circle\" style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:text-white hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-users mr-2\"></i>\n" +
            "                        <span class=\"font-medium\">Domains</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "</div>\n" ;

    private final String block5 = "<div class=\"surface-card border-round shadow-2 select-none\">\n" +
            "    <ul class=\"list-none p-2 m-0\">\n" +
            "        <li>\n" +
            "            <a class=\"flex p-2 align-items-center cursor-pointer\" \n" +
            "                data-pb-styleclass=\"{ selector: '#pb_profile_submenu', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                <span class=\"mr-3 inline-flex\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-2.png\" library=\"primeblocks-app\" alt=\"Image\" width=\"42\" height=\"42\"/>\n" +
            "                </span>\n" +
            "                <div>\n" +
            "                    <span class=\"font-medium text-900 mb-2\">Amanda Davis</span>\n" +
            "                    <p class=\"mt-1 mb-0 text-600\">Administrator</p>\n" +
            "                </div>\n" +
            "                <i class=\"pi pi-chevron-down text-700 ml-auto\"></i>\n" +
            "            </a>\n" +
            "            <div class=\"border-top-1 surface-border my-3\" style=\"height:1px\"></div>\n" +
            "            <ul id=\"pb_profile_submenu\" class=\"list-none p-0 m-0 overflow-hidden\">\n" +
            "                <li class=\"mb-2\">\n" +
            "                    <a class=\"flex p-2 align-items-start hover:surface-50 border-transparent border-1 hover:border-100 border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-home text-500 mr-3 text-xl\"></i>\n" +
            "                        <span>\n" +
            "                            <span class=\"block text-700 font-medium\">Dashboard</span>\n" +
            "                            <p class=\"mt-1 mb-0 text-600 text-sm\">Control everything with ease</p>\n" +
            "                        </span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"mb-2\">\n" +
            "                    <a class=\"flex p-2 align-items-start hover:surface-50 border-transparent border-1 hover:border-100 border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-users text-500 mr-3 text-xl\"></i>\n" +
            "                        <span>\n" +
            "                            <span class=\"block text-700 font-medium\">Users</span>\n" +
            "                            <p class=\"mt-1 mb-0 text-600 text-sm\">Manage permissions</p>\n" +
            "                        </span>\n" +
            "                        <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-blue-100 text-blue-900 border-circle\" style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"mb-2\">\n" +
            "                    <a class=\"flex p-2 align-items-start hover:surface-50 border-transparent border-1 hover:border-100 border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-sliders-h text-500 mr-3 text-xl\"></i>\n" +
            "                        <span>\n" +
            "                            <span class=\"block text-700 font-medium\">Tools</span>\n" +
            "                            <p class=\"mt-1 mb-0 text-600 text-sm\">Import, Export and Site Health</p>\n" +
            "                        </span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"mb-2\">\n" +
            "                    <a class=\"flex p-2 align-items-start hover:surface-50 border-transparent border-1 hover:border-100 border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-th-large text-500 mr-3 text-xl\"></i>\n" +
            "                        <span>\n" +
            "                            <span class=\"block text-700 font-medium\">Integrations</span>\n" +
            "                            <p class=\"mt-1 mb-0 text-600 text-sm\">Slack, Discord and Wordpress</p>\n" +
            "                        </span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"mb-2\">\n" +
            "                    <a class=\"flex p-2 align-items-start hover:surface-50 border-transparent border-1 hover:border-100 border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-cog text-500 mr-3 text-xl\"></i>\n" +
            "                        <span>\n" +
            "                            <span class=\"block text-700 font-medium\">Settings</span>\n" +
            "                            <p class=\"mt-1 mb-0 text-600 text-sm\">Options, Privacy and Permalinks</p>\n" +
            "                        </span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </li>\n" +
            "        <li class=\"mb-2\">\n" +
            "            <a class=\"block p-2 font-medium text-700 hover:surface-50 border-transparent border-1 hover:border-100 border-round cursor-pointer transition-colors transition-duration-150\">Installed Plugins</a>\n" +
            "        </li>\n" +
            "        <li class=\"mb-2\">\n" +
            "            <a class=\"block p-2 font-medium text-700 flex align-items-center justify-content-between hover:surface-50 border-transparent border-1 hover:border-100 border-round cursor-pointer transition-colors transition-duration-150\">\n" +
            "                <span>Updates</span>\n" +
            "                <i class=\"bg-blue-500 border-circle\" style=\"width:7px;height:7px\"></i>\n" +
            "            </a>\n" +
            "        </li>\n" +
            "        <li class=\"mb-2\">\n" +
            "            <a class=\"block p-2 font-medium text-700 hover:surface-50 border-transparent border-1 hover:border-100 border-round cursor-pointer transition-colors transition-duration-150\">Reset Server</a>\n" +
            "        </li>\n" +
            "        <li class=\"mb-2\">\n" +
            "            <a class=\"block p-2 font-medium text-700 hover:surface-50 border-transparent border-1 hover:border-100 border-round cursor-pointer transition-colors transition-duration-150\">Log Out</a>\n" +
            "        </li>\n" +
            "    </ul>\n" +
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
