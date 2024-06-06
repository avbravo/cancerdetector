package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class SidebarNavView implements Serializable {

    private final String block1 = "<div class=\"surface-section h-screen border-right-1 surface-border flex flex-column w-18rem select-none\">\n" +
            "    <div class=\"p-3 flex align-items-center justify-content-center\">\n" +
            "        <p:graphicImage name=\"images/blocks/logos/hyper-700.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                        height=\"40\"/>\n" +
            "    </div>\n" +
            "    <div class=\"overflow-y-auto\">\n" +
            "        <ul class=\"list-none p-2 m-0\">\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-home mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Dashboard</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-comments mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Messages</span>\n" +
            "                    <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-blue-100 text-blue-900 border-circle\"\n" +
            "                          style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\"\n" +
            "                   data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                    <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Reports</span>\n" +
            "                    <i class=\"pi pi-chevron-down ml-auto mr-1\"/>\n" +
            "                </a>\n" +
            "                <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\"\n" +
            "                           data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                            <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Revenue</span>\n" +
            "                            <i class=\"pi pi-chevron-down ml-auto mr-1\"/>\n" +
            "                        </a>\n" +
            "                        <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-table mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">View</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-search mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Search</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Expenses</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-chart-bar mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Analytics</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-dollar mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Sales</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-users mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Customers</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-cog mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Settings</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "    </div>\n" +
            "</div>" ;
    
    private final String block2 = "<div class=\"surface-section h-screen border-right-1 surface-border flex flex-column w-18rem select-none\">\n" +
            "    <div class=\"p-3 flex align-items-center justify-content-center\">\n" +
            "        <p:graphicImage name=\"images/blocks/logos/hyper-700.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                        height=\"40\"/>\n" +
            "    </div>\n" +
            "    <div class=\"overflow-y-auto\">\n" +
            "        <ul class=\"list-none p-2 m-0\">\n" +
            "            <li>\n" +
            "                <div class=\"p-3 text-500 font-medium\">HOME</div>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-home mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Dashboard</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-comments mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Messages</span>\n" +
            "                    <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-blue-100 text-blue-900 border-circle\"\n" +
            "                          style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\"\n" +
            "                   data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                    <i class=\"pi pi-calendar mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Calendar</span>\n" +
            "                    <div class=\"ml-auto\">\n" +
            "                        <span class=\"inline-flex align-items-center justify-content-center bg-purple-100 text-purple-900 border-circle\"\n" +
            "                              style=\"min-width: 1.5rem; height: 1.5rem\">2</span>\n" +
            "                        <i class=\"pi pi-chevron-down ml-2\"/>\n" +
            "                    </div>\n" +
            "                </a>\n" +
            "                <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-calendar mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Work</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-calendar mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Personal</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "        <ul class=\"list-none p-2 m-0 border-top-1 surface-border\">\n" +
            "            <li>\n" +
            "                <div class=\"p-3 text-500 font-medium\">ORGANIZATION</div>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-home mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Overview</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-lock mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Security</span>\n" +
            "                    <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-cyan-100 text-cyan-900 border-circle\"\n" +
            "                          style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\"\n" +
            "                   data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                    <i class=\"pi pi-file mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Reports</span>\n" +
            "                    <div class=\"ml-auto\">\n" +
            "                        <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-orange-100 text-orange-900 border-circle\"\n" +
            "                              style=\"min-width: 1.5rem; height: 1.5rem\">2</span>\n" +
            "                        <i class=\"pi pi-chevron-down ml-2\"/>\n" +
            "                    </div>\n" +
            "                </a>\n" +
            "                <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\"\n" +
            "                           data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                            <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Analytics</span>\n" +
            "                            <i class=\"pi pi-chevron-down ml-auto\"/>\n" +
            "                        </a>\n" +
            "                        <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-refresh mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Traffic</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-dollar mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Conversions</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-chart-bar mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Sales</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "        <ul class=\"list-none p-2 m-0 border-top-1 surface-border\">\n" +
            "            <li>\n" +
            "                <div class=\"p-3 text-500 font-medium\">CUSTOMERS</div>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-home mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Overview</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-users mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Users</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-inbox mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Inbox</span>\n" +
            "                    <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-purple-100 text-purple-900 border-circle\"\n" +
            "                          style=\"min-width: 1.5rem; height: 1.5rem\">8</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-search mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Search</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "    </div>\n" +
            "    <div class=\"p-2 mt-auto border-top-1 surface-border\">\n" +
            "        <ul class=\"list-none p-2 m-0 hidden\">\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-user mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Profile</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-cog mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Settings</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-sign-out mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Sign Out</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "        <a class=\"p-3 flex align-items-center cursor-pointer text-700 hover:surface-100 border-round transition-colors transition-duration-150\"\n" +
            "           data-pb-styleclass=\"{ selector: '@prev', enterClass: 'hidden', enterActiveClass: 'fadein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout' }\">\n" +
            "            <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\"\n" +
            "                            alt=\"Image\"\n" +
            "                            styleClass=\"mr-2\" style=\"width: 28px; height: 28px\"/>\n" +
            "            <span class=\"font-medium\">Amy Elsner</span>\n" +
            "            <i class=\"pi pi-chevron-up ml-auto\"/>\n" +
            "        </a>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block3 = "<div class=\"bg-gray-900 h-screen border-right-1 surface-border flex flex-column w-18rem select-none\">\n" +
            "    <div class=\"p-3 flex align-items-center justify-content-center\">\n" +
            "        <p:graphicImage name=\"images/blocks/logos/hyper-300.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                        height=\"40\"/>\n" +
            "    </div>\n" +
            "    <div class=\"overflow-y-auto\">\n" +
            "        <ul class=\"list-none p-2 m-0\">\n" +
            "            <li>\n" +
            "                <div class=\"p-3 text-gray-600 font-medium\">HOME</div>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-home mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Dashboard</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-comments mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Messages</span>\n" +
            "                    <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-blue-100 text-blue-900 border-circle\"\n" +
            "                          style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-gray-800 border-round transition-colors transition-duration-150\"\n" +
            "                   data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                    <i class=\"pi pi-calendar mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Calendar</span>\n" +
            "                    <i class=\"pi pi-chevron-down ml-auto\"/>\n" +
            "                </a>\n" +
            "                <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-calendar mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Work</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-calendar mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Personal</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "        <ul class=\"list-none p-2 m-0 border-top-1 border-gray-800\">\n" +
            "            <li>\n" +
            "                <div class=\"p-3 text-gray-600  font-medium\">ORGANIZATION</div>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-home mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Overview</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-lock mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Security</span>\n" +
            "                    <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-cyan-100 text-cyan-900 border-circle\"\n" +
            "                          style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-gray-800 border-round transition-colors transition-duration-150\"\n" +
            "                   data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                    <i class=\"pi pi-file mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Reports</span>\n" +
            "                    <i class=\"pi pi-chevron-down ml-auto\"/>\n" +
            "                </a>\n" +
            "                <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-gray-800 border-round transition-colors transition-duration-150\"\n" +
            "                           data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                            <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Analytics</span>\n" +
            "                            <i class=\"pi pi-chevron-down ml-auto\"/>\n" +
            "                        </a>\n" +
            "                        <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-refresh mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Traffic</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-dollar mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Conversions</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-chart-bar mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Sales</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "        <ul class=\"list-none p-2 m-0 border-top-1 border-gray-800\">\n" +
            "            <li>\n" +
            "                <div class=\"p-3 text-gray-600  font-medium\">CUSTOMERS</div>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-home mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Overview</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-users mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Users</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-inbox mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Inbox</span>\n" +
            "                    <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-purple-100 text-purple-900 border-circle\"\n" +
            "                          style=\"min-width: 1.5rem; height: 1.5rem\">8</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-search mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Search</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "    </div>\n" +
            "    <div class=\"p-2 mt-auto border-top-1 border-gray-800\">\n" +
            "        <a class=\"p-3 flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-gray-800 border-round transition-colors transition-duration-150\">\n" +
            "            <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\"\n" +
            "                            alt=\"Image\"\n" +
            "                            styleClass=\"mr-2\" style=\"width: 28px; height: 28px\"/>\n" +
            "            <span class=\"font-medium\">Amy Elsner</span>\n" +
            "        </a>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block4 = "<div class=\"bg-indigo-500 h-screen flex flex-column w-18rem select-none\">\n" +
            "    <div class=\"p-3 flex align-items-center justify-content-center\">\n" +
            "        <p:graphicImage name=\"images/blocks/logos/hyper-300.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                        height=\"40\"/>\n" +
            "    </div>\n" +
            "    <div class=\"overflow-y-auto\">\n" +
            "        <ul class=\"list-none p-2 m-0\">\n" +
            "            <li>\n" +
            "                <div class=\"p-3 flex align-items-center justify-content-between text-indigo-300 cursor-pointer\"\n" +
            "                     data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                    <span class=\"font-medium\">HOME</span>\n" +
            "                    <i class=\"pi pi-chevron-down\"/>\n" +
            "                </div>\n" +
            "                <ul class=\"list-none p-0 m-0 overflow-hidden\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-home mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Dashboard</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-comments mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Messages</span>\n" +
            "                            <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-orange-100 text-orange-900 border-circle\"\n" +
            "                                  style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\"\n" +
            "                           data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                            <i class=\"pi pi-calendar mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Calendar</span>\n" +
            "                            <i class=\"pi pi-chevron-down ml-auto\"/>\n" +
            "                        </a>\n" +
            "                        <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-calendar mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Work</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-calendar mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Personal</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "        <div class=\"p-2 border-top-1 border-indigo-400\">\n" +
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
            "                        <i class=\"pi pi-lock mr-2\"/>\n" +
            "                        <span class=\"font-medium\">Security</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex align-items-center cursor-pointer p-3 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\"\n" +
            "                       data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                        <i class=\"pi pi-file mr-2\"/>\n" +
            "                        <span class=\"font-medium\">Reports</span>\n" +
            "                        <i class=\"pi pi-chevron-down ml-auto\"/>\n" +
            "                    </a>\n" +
            "                    <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                        <li>\n" +
            "                            <a class=\"flex align-items-center cursor-pointer p-3 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\"\n" +
            "                               data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                                <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                                <span class=\"font-medium\">Analytics</span>\n" +
            "                                <i class=\"pi pi-chevron-down ml-auto\"/>\n" +
            "                            </a>\n" +
            "                            <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\">\n" +
            "                                        <i class=\"pi pi-refresh mr-2\"/>\n" +
            "                                        <span class=\"font-medium\">Traffic</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\">\n" +
            "                                        <i class=\"pi pi-dollar mr-2\"/>\n" +
            "                                        <span class=\"font-medium\">Conversions</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                            </ul>\n" +
            "                        </li>\n" +
            "                        <li>\n" +
            "                            <a class=\"flex align-items-center cursor-pointer p-3 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\">\n" +
            "                                <i class=\"pi pi-chart-bar mr-2\"/>\n" +
            "                                <span class=\"font-medium\">Sales</span>\n" +
            "                            </a>\n" +
            "                        </li>\n" +
            "                    </ul>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "        <div class=\"p-2 border-top-1 border-indigo-400\">\n" +
            "            <div class=\"p-3 flex align-items-center justify-content-between text-indigo-300 cursor-pointer\"\n" +
            "                 data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                <span class=\"font-medium\">CUSTOMERS</span>\n" +
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
            "                        <i class=\"pi pi-users mr-2\"/>\n" +
            "                        <span class=\"font-medium\">Users</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex align-items-center cursor-pointer p-3 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-inbox mr-2\"/>\n" +
            "                        <span class=\"font-medium\">Inbox</span>\n" +
            "                        <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-purple-50 text-purple-900 border-circle\"\n" +
            "                              style=\"min-width: 1.5rem; height: 1.5rem\">8</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex align-items-center cursor-pointer p-3 text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\">\n" +
            "                        <i class=\"pi pi-search mr-2\"/>\n" +
            "                        <span class=\"font-medium\">Search</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"p-2 mt-auto border-top-1 border-indigo-400\">\n" +
            "        <a class=\"p-3 flex align-items-center cursor-pointer text-indigo-100 hover:text-indigo-50 hover:bg-indigo-600 border-round transition-colors transition-duration-150\">\n" +
            "            <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\"\n" +
            "                            alt=\"Image\"\n" +
            "                            styleClass=\"mr-2\" style=\"width: 28px; height: 28px\"/>\n" +
            "            <span class=\"font-medium\">Amy Elsner</span>\n" +
            "        </a>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block5 = "<div class=\"surface-section h-screen border-right-1 surface-border flex flex-column w-18rem select-none absolute left-0 top-0\">\n" +
            "    <div class=\"p-3 flex align-items-center justify-content-center\">\n" +
            "        <p:graphicImage name=\"images/blocks/logos/hyper-700.svg\" library=\"primeblocks-app\" alt=\"Image\" height=\"40\"/>\n" +
            "    </div>\n" +
            "    <div class=\"overflow-y-auto\">\n" +
            "        <ul class=\"list-none p-2 m-0\">\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-blue-500 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-home mr-2\"></i>\n" +
            "                    <span class=\"font-medium\">Dashboard</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-comments mr-2\"></i>\n" +
            "                    <span class=\"font-medium\">Messages</span>\n" +
            "                    <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-blue-100 text-blue-900 border-circle\" style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\"\n" +
            "                    data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                    <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                    <span class=\"font-medium\">Reports</span>\n" +
            "                    <i class=\"pi pi-chevron-down ml-auto mr-1\"></i>\n" +
            "                </a>\n" +
            "                <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                    <li class=\"border-left-2 surface-border\">\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\"\n" +
            "                            data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                            <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                            <span class=\"font-medium\">Revenue</span>\n" +
            "                            <i class=\"pi pi-chevron-down ml-auto mr-1\"></i>\n" +
            "                        </a>\n" +
            "                        <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                            <li class=\"border-left-2 surface-border\">\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-table mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">View</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li class=\"border-left-2 surface-border\">\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                                    <i class=\"pi pi-search mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Search</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                    <li class=\"border-left-2 surface-border\">\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                            <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                            <span class=\"font-medium\">Expenses</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-chart-bar mr-2\"></i>\n" +
            "                    <span class=\"font-medium\">Analytics</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-dollar mr-2\"></i>\n" +
            "                    <span class=\"font-medium\">Sales</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-users mr-2\"></i>\n" +
            "                    <span class=\"font-medium\">Customers</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li>\n" +
            "                <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                    <i class=\"pi pi-cog mr-2\"></i>\n" +
            "                    <span class=\"font-medium\">Settings</span>\n" +
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

    public String getBlock4() {
        return block4;
    }

    public String getBlock5() {
        return block5;
    }
}
