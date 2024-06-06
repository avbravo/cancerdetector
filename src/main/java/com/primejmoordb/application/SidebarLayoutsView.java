package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class SidebarLayoutsView implements Serializable {

    private final String block1 = "<div class=\"min-h-screen flex relative lg:static surface-ground\">\n" +
            "    <div id=\"app-sidebar-2\"\n" +
            "         class=\"surface-section h-screen hidden lg:block flex-shrink-0 absolute lg:static left-0 top-0 z-1 border-right-1 surface-border select-none\"\n" +
            "         style=\"width:280px\">\n" +
            "        <div class=\"flex flex-column h-full\">\n" +
            "            <div class=\"flex align-items-center px-5 flex-shrink-0\" style=\"height:60px\">\n" +
            "                <p:graphicImage name=\"images/blocks/logos/hyper-700.svg\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" height=\"30\"/>\n" +
            "            </div>\n" +
            "            <div class=\"overflow-y-auto\">\n" +
            "                <ul class=\"list-none p-3 m-0\">\n" +
            "                    <li>\n" +
            "                        <div class=\"p-3 flex align-items-center justify-content-between text-600 cursor-pointer\"\n" +
            "                             data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                            <span class=\"font-medium\">FAVORITES</span>\n" +
            "                            <i class=\"pi pi-chevron-down\"/>\n" +
            "                        </div>\n" +
            "                        <ul class=\"list-none p-0 m-0 overflow-hidden\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-100 transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-home mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Dashboard</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-100 transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-bookmark mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Bookmarks</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-100 transition-duration-150 transition-colors\"\n" +
            "                                   data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                                    <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Reports</span>\n" +
            "                                    <i class=\"pi pi-chevron-down ml-auto mr-1\"/>\n" +
            "                                </a>\n" +
            "                                <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-100 transition-duration-150 transition-colors\"\n" +
            "                                           data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                                            <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                                            <span class=\"font-medium\">Revenue</span>\n" +
            "                                            <i class=\"pi pi-chevron-down ml-auto mr-1\"/>\n" +
            "                                        </a>\n" +
            "                                        <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                                            <li>\n" +
            "                                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-100 transition-duration-150 transition-colors\">\n" +
            "                                                    <i class=\"pi pi-table mr-2\"/>\n" +
            "                                                    <span class=\"font-medium\">View</span>\n" +
            "                                                </a>\n" +
            "                                            </li>\n" +
            "                                            <li>\n" +
            "                                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-100 transition-duration-150 transition-colors\">\n" +
            "                                                    <i class=\"pi pi-search mr-2\"/>\n" +
            "                                                    <span class=\"font-medium\">Search</span>\n" +
            "                                                </a>\n" +
            "                                            </li>\n" +
            "                                        </ul>\n" +
            "                                    </li>\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-100 transition-duration-150 transition-colors\">\n" +
            "                                            <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                                            <span class=\"font-medium\">Expenses</span>\n" +
            "                                        </a>\n" +
            "                                    </li>\n" +
            "                                </ul>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-100 transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-users mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Team</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-100 transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-comments mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Messages</span>\n" +
            "                                    <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-blue-500 text-0 border-circle\"\n" +
            "                                          style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-100 transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-calendar mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Calendar</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-100 transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-cog mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Settings</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "                <ul class=\"list-none p-3 m-0\">\n" +
            "                    <li>\n" +
            "                        <div class=\"p-3 flex align-items-center justify-content-between text-600 cursor-pointer\"\n" +
            "                             data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                            <span class=\"font-medium\">APPLICATION</span>\n" +
            "                            <i class=\"pi pi-chevron-down\"/>\n" +
            "                        </div>\n" +
            "                        <ul class=\"list-none p-0 m-0 overflow-hidden\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-100 transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-folder mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Projects</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-100 transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-chart-bar mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Performance</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-100 transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-cog mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Settings</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "            <div class=\"mt-auto\">\n" +
            "                <hr class=\"mb-3 mx-3 border-top-1 surface-border\"/>\n" +
            "                <a class=\"m-3 flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-100 transition-duration-150 transition-colors\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\"\n" +
            "                                    library=\"primeblocks-app\"\n" +
            "                                    alt=\"Image\" styleClass=\"mr-2\" style=\"width: 28px; height: 28px\"/>\n" +
            "                    <span class=\"font-medium\">Amy Elsner</span>\n" +
            "                </a>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"min-h-screen flex flex-column relative flex-auto\">\n" +
            "        <div class=\"flex justify-content-between align-items-center px-5 surface-0 border-bottom-1 surface-border relative lg:static\"\n" +
            "             style=\"height:60px\">\n" +
            "            <div class=\"flex\">\n" +
            "                <a class=\"cursor-pointer block lg:hidden text-700 mr-3\"\n" +
            "                   data-pb-styleclass=\"{ selector: '#app-sidebar-2', enterClass: 'hidden', enterActiveClass: 'fadeinleft', leaveToClass: 'hidden', leaveActiveClass: 'fadeoutleft', hideOnOutsideClick: true }\">\n" +
            "                    <i class=\"pi pi-bars text-4xl\"/>\n" +
            "                </a>\n" +
            "                <span class=\"ui-input-icon-left\">\n" +
            "                    <i class=\"pi pi-search\"/>\n" +
            "                    <p:inputText type=\"search\" styleClass=\"border-none\" placeholder=\"Search\"/>\n" +
            "                </span>\n" +
            "            </div>\n" +
            "            <a class=\"cursor-pointer block lg:hidden text-700\"\n" +
            "               data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'fadein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                <i class=\"pi pi-ellipsis-v text-2xl\"/>\n" +
            "            </a>\n" +
            "            <ul class=\"list-none p-0 m-0 hidden lg:flex lg:align-items-center select-none lg:flex-row\n" +
            "                surface-section border-1 lg:border-none surface-border right-0 top-100 z-1 shadow-2 lg:shadow-none absolute lg:static\">\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"/>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <p:badge severity=\"danger\">\n" +
            "                            <i class=\"pi pi-bell text-base lg:text-2xl\"/>\n" +
            "                        </p:badge>\n" +
            "                        <span class=\"block lg:hidden font-medium ml-2 lg:ml-0\">Notifications</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"border-top-1 surface-border lg:border-top-none\">\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\"\n" +
            "                                        library=\"primeblocks-app\"\n" +
            "                                        alt=\"Image\" styleClass=\"mr-3 lg:mr-0\"\n" +
            "                                        style=\"width: 32px; height: 32px\"/>\n" +
            "                        <div class=\"block lg:hidden\">\n" +
            "                            <div class=\"text-900 font-medium\">Josephine Lillard</div>\n" +
            "                            <span class=\"text-600 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                        </div>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "        <div class=\"p-5 flex flex-column flex-auto\">\n" +
            "            <div class=\"border-2 border-dashed surface-border border-round surface-section flex-auto\">\n" +
            "\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block2 = "<div class=\"min-h-screen flex relative lg:static surface-ground\">\n" +
            "    <div id=\"app-sidebar-1\"\n" +
            "         class=\"bg-bluegray-800 h-screen hidden lg:block flex-shrink-0 absolute lg:static left-0 top-0 z-1 select-none\"\n" +
            "         style=\"width:280px\">\n" +
            "        <div class=\"flex flex-column h-full\">\n" +
            "            <div class=\"flex align-items-center px-5 bg-bluegray-900 flex-shrink-0\" style=\"height:60px\">\n" +
            "                <p:graphicImage name=\"images/blocks/logos/hyper-300.svg\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" height=\"30\"/>\n" +
            "            </div>\n" +
            "            <div class=\"overflow-y-auto mt-3\">\n" +
            "                <ul class=\"list-none p-3 m-0\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-bluegray-900 border-round text-bluegray-100 hover:text-bluegray-50\n" +
            "                            transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-home mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Dashboard</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-bluegray-900 border-round text-bluegray-100 hover:text-bluegray-50\n" +
            "                            transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-bookmark mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Bookmarks</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-bluegray-900 border-round text-bluegray-100 hover:text-bluegray-50\n" +
            "                            transition-duration-150 transition-colors\"\n" +
            "                           data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                            <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Reports</span>\n" +
            "                            <i class=\"pi pi-chevron-down ml-auto mr-1\"/>\n" +
            "                        </a>\n" +
            "                        <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-bluegray-900 border-round text-bluegray-100 hover:text-bluegray-50\n" +
            "                                transition-duration-150 transition-colors\"\n" +
            "                                   data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                                    <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Revenue</span>\n" +
            "                                    <i class=\"pi pi-chevron-down ml-auto mr-1\"/>\n" +
            "                                </a>\n" +
            "                                <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-bluegray-900 border-round text-bluegray-100 hover:text-bluegray-50\n" +
            "                                        transition-duration-150 transition-colors\">\n" +
            "                                            <i class=\"pi pi-table mr-2\"/>\n" +
            "                                            <span class=\"font-medium\">View</span>\n" +
            "                                        </a>\n" +
            "                                    </li>\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-bluegray-900 border-round text-bluegray-100 hover:text-bluegray-50\n" +
            "                                        transition-duration-150 transition-colors\">\n" +
            "                                            <i class=\"pi pi-search mr-2\"/>\n" +
            "                                            <span class=\"font-medium\">Search</span>\n" +
            "                                        </a>\n" +
            "                                    </li>\n" +
            "                                </ul>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-bluegray-900 border-round text-bluegray-100 hover:text-bluegray-50\n" +
            "                                transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Expenses</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-bluegray-900 border-round text-bluegray-100 hover:text-bluegray-50\n" +
            "                            transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-users mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Team</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-bluegray-900 border-round text-bluegray-100 hover:text-bluegray-50\n" +
            "                            transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-comments mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Messages</span>\n" +
            "                            <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-yellow-500 text-bluegray-900 border-circle\"\n" +
            "                                  style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-bluegray-900 border-round text-bluegray-100 hover:text-bluegray-50\n" +
            "                            transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-calendar mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Calendar</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-bluegray-900 border-round text-bluegray-100 hover:text-bluegray-50\n" +
            "                            transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-cog mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Settings</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "            <div class=\"mt-auto\">\n" +
            "                <hr class=\"mb-3 mx-3 border-top-1 border-bluegray-600\"/>\n" +
            "                <ul class=\"list-none p-2 m-0 hidden\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-bluegray-900 border-round text-bluegray-100 hover:text-bluegray-50\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-user mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Profile</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-bluegray-900 border-round text-bluegray-100 hover:text-bluegray-50\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-cog mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Settings</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-bluegray-900 border-round text-bluegray-100 hover:text-bluegray-50\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-sign-out mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Sign Out</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "                <a class=\"m-3 px-3 py-2 flex align-items-center hover:bg-bluegray-900 border-round cursor-pointer text-bluegray-100 hover:text-bluegray-50\n" +
            "                    transition-duration-150 transition-colors\"\n" +
            "                   data-pb-styleclass=\"{ selector: '@prev', enterClass: 'hidden', enterActiveClass: 'fadein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout' }\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\"\n" +
            "                                    library=\"primeblocks-app\"\n" +
            "                                    alt=\"Image\" styleClass=\"mr-2\" style=\"width: 28px; height: 28px\"/>\n" +
            "                    <span class=\"font-medium\">Amy Elsner</span>\n" +
            "                    <i class=\"pi pi-chevron-up ml-auto\"/>\n" +
            "                </a>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"min-h-screen flex flex-column relative flex-auto\">\n" +
            "        <div class=\"flex justify-content-between align-items-center px-5 surface-section shadow-2 relative lg:static border-bottom-1 surface-border\"\n" +
            "             style=\"height:60px\">\n" +
            "            <div class=\"flex\">\n" +
            "                <a class=\"cursor-pointer block lg:hidden text-700 mr-3\"\n" +
            "                   data-pb-styleclass=\"{ selector: '#app-sidebar-1', enterClass: 'hidden', enterActiveClass: 'fadeinleft', leaveToClass: 'hidden', leaveActiveClass: 'fadeoutleft', hideOnOutsideClick: true }\">\n" +
            "                    <i class=\"pi pi-bars text-4xl\"/>\n" +
            "                </a>\n" +
            "                <span class=\"ui-input-icon-left\">\n" +
            "                    <i class=\"pi pi-search\"/>\n" +
            "                    <p:inputText type=\"search\" styleClass=\"border-none\" placeholder=\"Search\"/>\n" +
            "                </span>\n" +
            "            </div>\n" +
            "            <a class=\"cursor-pointer block lg:hidden text-700\"\n" +
            "               data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'fadein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                <i class=\"pi pi-ellipsis-v text-2xl\"/>\n" +
            "            </a>\n" +
            "            <ul class=\"list-none p-0 m-0 hidden lg:flex lg:align-items-center select-none lg:flex-row\n" +
            "                surface-section border-1 lg:border-none surface-border right-0 top-100 z-1 shadow-2 lg:shadow-none absolute lg:static\">\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"/>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <p:badge severity=\"danger\">\n" +
            "                            <i class=\"pi pi-bell text-base lg:text-2xl\"/>\n" +
            "                        </p:badge>\n" +
            "                        <span class=\"block lg:hidden font-medium ml-2 lg:ml-0\">Notifications</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"border-top-1 surface-border lg:border-top-none\">\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\"\n" +
            "                                        library=\"primeblocks-app\"\n" +
            "                                        alt=\"Image\" styleClass=\"mr-3 lg:mr-0\"\n" +
            "                                        style=\"width: 32px; height: 32px\"/>\n" +
            "                        <div class=\"block lg:hidden\">\n" +
            "                            <div class=\"text-900 font-medium\">Josephine Lillard</div>\n" +
            "                            <span class=\"text-600 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                        </div>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "        <div class=\"p-5 flex flex-column flex-auto\">\n" +
            "            <div class=\"border-2 border-dashed surface-border border-round surface-section flex-auto\">\n" +
            "\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block3 = "<div class=\"min-h-screen flex relative lg:static surface-ground\">\n" +
            "    <div id=\"app-sidebar-3\"\n" +
            "         class=\"bg-gray-900 h-screen hidden lg:block flex-shrink-0 absolute lg:static left-0 top-0 z-1 border-right-1 border-gray-800 select-none\"\n" +
            "         style=\"width:280px\">\n" +
            "        <div class=\"flex flex-column h-full\">\n" +
            "            <div class=\"flex align-items-center px-5 flex-shrink-0\" style=\"height:60px\">\n" +
            "                <p:graphicImage name=\"images/blocks/logos/hyper-300.svg\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" height=\"30\"/>\n" +
            "            </div>\n" +
            "            <div class=\"overflow-y-auto\">\n" +
            "                <ul class=\"list-none p-3 m-0\">\n" +
            "                    <li>\n" +
            "                        <span class=\"block p-3 text-gray-600\">FAVORITES</span>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 border-round hover:bg-gray-800 text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-home mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Dashboard</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 border-round hover:bg-gray-800 text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-bookmark mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Bookmarks</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 border-round hover:bg-gray-800 text-gray-300 hover:text-white transition-duration-150 transition-colors\"\n" +
            "                           data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                            <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Reports</span>\n" +
            "                            <i class=\"pi pi-chevron-down ml-auto mr-1\"/>\n" +
            "                        </a>\n" +
            "                        <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round hover:bg-gray-800 text-gray-300 hover:text-white transition-duration-150 transition-colors\"\n" +
            "                                   data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                                    <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Revenue</span>\n" +
            "                                    <i class=\"pi pi-chevron-down ml-auto mr-1\"/>\n" +
            "                                </a>\n" +
            "                                <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex align-items-center cursor-pointer p-3 border-round hover:bg-gray-800 text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                                            <i class=\"pi pi-table mr-2\"/>\n" +
            "                                            <span class=\"font-medium\">View</span>\n" +
            "                                        </a>\n" +
            "                                    </li>\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex align-items-center cursor-pointer p-3 border-round hover:bg-gray-800 text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                                            <i class=\"pi pi-search mr-2\"/>\n" +
            "                                            <span class=\"font-medium\">Search</span>\n" +
            "                                        </a>\n" +
            "                                    </li>\n" +
            "                                </ul>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round hover:bg-gray-800 text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Expenses</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 border-round hover:bg-gray-800 text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-users mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Team</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 border-round hover:bg-gray-800 text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-comments mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Messages</span>\n" +
            "                            <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-blue-500 text-0 border-circle\"\n" +
            "                                  style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 border-round hover:bg-gray-800 text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-calendar mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Calendar</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 border-round hover:bg-gray-800 text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-cog mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Settings</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "                <ul class=\"list-none p-3 m-0\">\n" +
            "                    <li>\n" +
            "                        <span class=\"block p-3 text-600\">APPLICATION</span>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 border-round hover:bg-gray-800 text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-folder mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Projects</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 border-round hover:bg-gray-800 text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-chart-bar mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Reports</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 border-round hover:bg-gray-800 text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-cog mr-2\"/>\n" +
            "                            <span class=\"font-medium\">Settings</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "            <div class=\"mt-auto\">\n" +
            "                <hr class=\"mb-3 mx-3 border-top-1 border-gray-800\"/>\n" +
            "                <a class=\"m-3 flex align-items-center cursor-pointer p-3 border-round hover:bg-gray-800 text-gray-300 hover:text-white transition-duration-150 transition-colorss\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\"\n" +
            "                                    library=\"primeblocks-app\"\n" +
            "                                    alt=\"Image\" styleClass=\"mr-2\" style=\"width: 28px; height: 28px\"/>\n" +
            "                    <span class=\"font-medium\">Amy Elsner</span>\n" +
            "                </a>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"min-h-screen flex flex-column relative flex-auto\">\n" +
            "        <div class=\"flex justify-content-between align-items-center px-5 surface-0 border-bottom-1 surface-border relative lg:static\"\n" +
            "             style=\"height:60px\">\n" +
            "            <div class=\"flex\">\n" +
            "                <a class=\"cursor-pointer block lg:hidden text-700 mr-3\"\n" +
            "                   data-pb-styleclass=\"{ selector: '#app-sidebar-3', enterClass: 'hidden', enterActiveClass: 'fadeinleft', leaveToClass: 'hidden', leaveActiveClass: 'fadeoutleft', hideOnOutsideClick: true }\">\n" +
            "                    <i class=\"pi pi-bars text-4xl\"/>\n" +
            "                </a>\n" +
            "                <span class=\"ui-input-icon-left\">\n" +
            "                    <i class=\"pi pi-search\"/>\n" +
            "                    <p:inputText type=\"search\" styleClass=\"border-none\" placeholder=\"Search\"/>\n" +
            "                </span>\n" +
            "            </div>\n" +
            "            <a class=\"cursor-pointer block lg:hidden text-700\"\n" +
            "               data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'fadein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                <i class=\"pi pi-ellipsis-v text-2xl\"/>\n" +
            "            </a>\n" +
            "            <ul class=\"list-none p-0 m-0 hidden lg:flex lg:align-items-center select-none lg:flex-row\n" +
            "                surface-section border-1 lg:border-none surface-border right-0 top-100 z-1 shadow-2 lg:shadow-none absolute lg:static\">\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"/>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <p:badge severity=\"danger\">\n" +
            "                            <i class=\"pi pi-bell text-base lg:text-2xl\"/>\n" +
            "                        </p:badge>\n" +
            "                        <span class=\"block lg:hidden font-medium ml-2 lg:ml-0\">Notifications</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"border-top-1 surface-border lg:border-top-none\">\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\"\n" +
            "                                        library=\"primeblocks-app\"\n" +
            "                                        alt=\"Image\" styleClass=\"mr-3 lg:mr-0\"\n" +
            "                                        style=\"width: 32px; height: 32px\"/>\n" +
            "                        <div class=\"block lg:hidden\">\n" +
            "                            <div class=\"text-900 font-medium\">Josephine Lillard</div>\n" +
            "                            <span class=\"text-600 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                        </div>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "        <div class=\"p-5 flex flex-column flex-auto\">\n" +
            "            <div class=\"border-2 border-dashed surface-border border-round surface-section flex-auto\">\n" +
            "\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block4 = "<div class=\"min-h-screen flex relative lg:static surface-ground\">\n" +
            "    <div id=\"app-sidebar-4\"\n" +
            "         class=\"bg-gray-900 h-screen hidden lg:block flex-shrink-0 absolute lg:static left-0 top-0 z-1 border-right-1 border-gray-800 w-18rem lg:w-5rem select-none\">\n" +
            "        <div class=\"flex flex-column h-full\">\n" +
            "            <div class=\"flex align-items-center justify-content-center flex-shrink-0 bg-indigo-500\"\n" +
            "                 style=\"height:60px\">\n" +
            "                <p:graphicImage name=\"images/blocks/logos/hyper-light.svg\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" height=\"30\"/>\n" +
            "            </div>\n" +
            "            <div class=\"mt-3 select-none\">\n" +
            "                <ul class=\"list-none p-3 lg:py-3 lg:px-2 m-0\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 lg:justify-content-center hover:bg-gray-800 border-round text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-home mr-2 lg:mr-0 text-base lg:text-xl\"/>\n" +
            "                            <span class=\"font-medium inline lg:hidden\">Dashboard</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 lg:justify-content-center hover:bg-gray-800 border-round text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-bookmark mr-2 lg:mr-0 text-base lg:text-xl\"/>\n" +
            "                            <span class=\"font-medium inline lg:hidden\">Bookmarks</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 lg:justify-content-center hover:bg-gray-800 border-round text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-users mr-2 lg:mr-0 text-base lg:text-xl\"/>\n" +
            "                            <span class=\"font-medium inline lg:hidden\">Team</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"lg:relative\">\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 lg:justify-content-center hover:bg-gray-800 border-round text-gray-300 hover:text-white transition-duration-150 transition-colors\"\n" +
            "                           data-pb-styleclass=\"{ selector: '@next', toggleClass: 'hidden', hideOnOutsideClick: true }\">\n" +
            "                            <p:badge value=\"3\">\n" +
            "                                <i class=\"pi pi-chart-line text-base lg:text-xl\"/>\n" +
            "                            </p:badge>\n" +
            "                            <span class=\"font-medium inline lg:hidden ml-2 lg:ml-0\">Reports</span>\n" +
            "                            <i class=\"pi pi-chevron-down ml-auto lg:hidden\"/>\n" +
            "                        </a>\n" +
            "                        <ul class=\"list-none pl-3 pr-0 py-0 lg:p-3 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out static lg:absolute left-100 top-0 z-1 bg-gray-900 lg:border-1 border-gray-800 border-round-right shadow-none lg:shadow-2 w-full lg:w-15rem\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-gray-800 border-round text-gray-300 hover:text-white transition-duration-150 transition-colors\"\n" +
            "                                   data-pb-styleclass=\"{ selector: '@next', toggleClass: 'hidden' }\">\n" +
            "                                    <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Revenue</span>\n" +
            "                                    <i class=\"pi pi-chevron-down ml-auto\"/>\n" +
            "                                </a>\n" +
            "                                <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-gray-800 border-round text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                                            <i class=\"pi pi-table mr-2\"/>\n" +
            "                                            <span class=\"font-medium\">View</span>\n" +
            "                                        </a>\n" +
            "                                    </li>\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-gray-800 border-round text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                                            <i class=\"pi pi-search mr-2\"/>\n" +
            "                                            <span class=\"font-medium\">Search</span>\n" +
            "                                        </a>\n" +
            "                                    </li>\n" +
            "                                </ul>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-gray-800 border-round text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Expenses</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 lg:justify-content-center hover:bg-gray-800 border-round text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-calendar mr-2 lg:mr-0 text-base lg:text-xl\"/>\n" +
            "                            <span class=\"font-medium inline lg:hidden\">Calendar</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 lg:justify-content-center hover:bg-gray-800 border-round text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-cog mr-2 lg:mr-0 text-base lg:text-xl\"/>\n" +
            "                            <span class=\"font-medium inline lg:hidden\">Settings</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "            <div class=\"mt-auto\">\n" +
            "                <hr class=\"mb-3 mx-2 border-top-1 border-gray-800\"/>\n" +
            "                <a class=\"my-3 mx-2 flex align-items-center cursor-pointer p-3 lg:justify-content-center hover:bg-gray-800 border-round text-300 hover:text-0\n" +
            "                    transition-duration-150 transition-colors\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\"\n" +
            "                                    library=\"primeblocks-app\"\n" +
            "                                    alt=\"Image\" styleClass=\"mr-2 lg:mr-0\"\n" +
            "                                    style=\"width: 32px; height: 32px;\"/>\n" +
            "                    <span class=\"font-medium inline lg:hidden\">Amy Elsner</span>\n" +
            "                </a>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"min-h-screen flex flex-column relative flex-auto\">\n" +
            "        <div class=\"flex justify-content-between align-items-center px-5 surface-section relative lg:static border-bottom-1 surface-border\"\n" +
            "             style=\"height:60px\">\n" +
            "            <div class=\"flex\">\n" +
            "                <a class=\"cursor-pointer block lg:hidden text-700 mr-3\"\n" +
            "                   data-pb-styleclass=\"{ selector: '#app-sidebar-4', enterClass: 'hidden', enterActiveClass: 'fadeinleft', leaveToClass: 'hidden', leaveActiveClass: 'fadeoutleft', hideOnOutsideClick: true }\">\n" +
            "                    <i class=\"pi pi-bars text-4xl\"/>\n" +
            "                </a>\n" +
            "                <span class=\"ui-input-icon-left\">\n" +
            "                    <i class=\"pi pi-search\"/>\n" +
            "                    <p:inputText type=\"search\" styleClass=\"border-none\" placeholder=\"Search\"/>\n" +
            "                </span>\n" +
            "            </div>\n" +
            "            <a class=\"cursor-pointer block lg:hidden text-700\"\n" +
            "               data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'fadein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                <i class=\"pi pi-ellipsis-v text-2xl\"/>\n" +
            "            </a>\n" +
            "            <ul class=\"list-none p-0 m-0 hidden lg:flex lg:align-items-center select-none lg:flex-row\n" +
            "                surface-section border-1 lg:border-none surface-border right-0 top-100 z-1 shadow-2 lg:shadow-none absolute lg:static\">\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"/>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <p:badge severity=\"danger\">\n" +
            "                            <i class=\"pi pi-bell text-base lg:text-2xl\"/>\n" +
            "                        </p:badge>\n" +
            "                        <span class=\"block lg:hidden font-medium ml-2 lg:ml-0\">Notifications</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"border-top-1 surface-border lg:border-top-none\">\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\"\n" +
            "                                        library=\"primeblocks-app\"\n" +
            "                                        alt=\"Image\" styleClass=\"mr-3 lg:mr-0\"\n" +
            "                                        style=\"width: 32px; height: 32px;\"/>\n" +
            "                        <div class=\"block lg:hidden\">\n" +
            "                            <div class=\"text-900 font-medium\">Josephine Lillard</div>\n" +
            "                            <span class=\"text-600 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                        </div>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "        <div class=\"p-5 flex flex-column flex-auto\">\n" +
            "            <div class=\"border-2 border-dashed surface-border border-round surface-section flex-auto\">\n" +
            "\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block5 = "<div class=\"min-h-screen flex relative lg:static surface-ground\">\n" +
            "    <div id=\"app-sidebar-5\"\n" +
            "         class=\"bg-gray-900 h-screen hidden lg:block flex-shrink-0 absolute lg:static left-0 top-0 z-1 border-right-1 border-gray-800 w-18rem lg:w-7rem select-none\">\n" +
            "        <div class=\"flex flex-column h-full\">\n" +
            "            <div class=\"flex align-items-center justify-content-center flex-shrink-0 bg-orange-500\"\n" +
            "                 style=\"height:60px\">\n" +
            "                <p:graphicImage name=\"images/blocks/logos/hyper-light.svg\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" height=\"30\"/>\n" +
            "            </div>\n" +
            "            <div class=\"mt-3\">\n" +
            "                <ul class=\"list-none p-3 m-0\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex flex-row lg:flex-column align-items-center cursor-pointer p-3 lg:justify-content-center hover:bg-gray-800 border-round text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-home mr-2 lg:mr-0 mb-0 lg:mb-2 text-base lg:text-lg\"/>\n" +
            "                            <span class=\"font-medium inline text-base lg:text-xs lg:block\">Home</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex flex-row lg:flex-column align-items-center cursor-pointer p-3 lg:justify-content-center hover:bg-gray-800 border-round text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-search mr-2 lg:mr-0 mb-0 lg:mb-2 text-base lg:text-lg\"/>\n" +
            "                            <span class=\"font-medium inline text-base lg:text-xs lg:block\">Search</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex flex-row lg:flex-column align-items-center cursor-pointer p-3 lg:justify-content-center hover:bg-gray-800 border-round text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-users mr-2 lg:mr-0 mb-0 lg:mb-2 text-base lg:text-lg\"/>\n" +
            "                            <span class=\"font-medium inline text-base lg:text-xs lg:block\">Team</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"relative\">\n" +
            "                        <a class=\"flex flex-row lg:flex-column align-items-center cursor-pointer p-3 lg:justify-content-center hover:bg-gray-800 border-round text-gray-300 hover:text-white transition-duration-150 transition-colors\"\n" +
            "                           data-pb-styleclass=\"{ selector: '@next', toggleClass: 'hidden', hideOnOutsideClick: true }\">\n" +
            "                            <p:badge severity=\"danger\" value=\"3\">\n" +
            "                                <i class=\"pi pi-chart-line mb-0 lg:mb-2 text-base lg:text-lg\"/>\n" +
            "                            </p:badge>\n" +
            "                            <span class=\"font-medium inline text-base lg:text-xs lg:block ml-2 lg:ml-0\">Reports</span>\n" +
            "                            <i class=\"pi pi-chevron-down ml-auto lg:hidden\"/>\n" +
            "                        </a>\n" +
            "                        <ul class=\"list-none pl-3 pr-0 py-0 lg:p-3 m-0 lg:ml-3 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out static border-round-right lg:absolute left-100 top-0 z-1 bg-gray-900 lg:border-1 border-gray-800 shadow-none lg:shadow-2 w-full lg:w-15rem\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-gray-800 border-round text-gray-300 hover:text-white transition-duration-150 transition-colors\"\n" +
            "                                   data-pb-styleclass=\"{ selector: '@next', toggleClass: 'hidden' }\">\n" +
            "                                    <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Revenue</span>\n" +
            "                                    <i class=\"pi pi-chevron-down ml-auto\"/>\n" +
            "                                </a>\n" +
            "                                <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-gray-800 border-round text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                                            <i class=\"pi pi-table mr-2\"/>\n" +
            "                                            <span class=\"font-medium\">View</span>\n" +
            "                                        </a>\n" +
            "                                    </li>\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-gray-800 border-round text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                                            <i class=\"pi pi-search mr-2\"/>\n" +
            "                                            <span class=\"font-medium\">Search</span>\n" +
            "                                        </a>\n" +
            "                                    </li>\n" +
            "                                </ul>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-gray-800 border-round text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-chart-line mr-2\"/>\n" +
            "                                    <span class=\"font-medium\">Expenses</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex flex-row lg:flex-column align-items-center cursor-pointer p-3 lg:justify-content-center hover:bg-gray-800 border-round text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-calendar mr-2 lg:mr-0 mb-0 lg:mb-2 text-base lg:text-lg\"/>\n" +
            "                            <span class=\"font-medium inline text-base lg:text-xs lg:block\">Events</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex flex-row lg:flex-column align-items-center cursor-pointer p-3 lg:justify-content-center hover:bg-gray-800 border-round text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-cog mr-2 lg:mr-0 mb-0 lg:mb-2 text-base lg:text-lg\"/>\n" +
            "                            <span class=\"font-medium inline text-base lg:text-xs lg:block\">Options</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "            <div class=\"mt-auto\">\n" +
            "                <hr class=\"mb-3 mx-3 border-top-1 border-gray-800\"/>\n" +
            "                <a class=\"m-3 flex flex-row lg:flex-column align-items-center cursor-pointer p-3 lg:justify-content-center hover:bg-gray-800 border-round text-gray-300 hover:text-white transition-duration-150 transition-colors\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\"\n" +
            "                                    library=\"primeblocks-app\"\n" +
            "                                    alt=\"Image\" styleClass=\"mr-2 lg:mr-0\"\n" +
            "                                    style=\"width: 32px; height: 32px\"/>\n" +
            "                    <span class=\"font-medium inline lg:hidden\">Amy Elsner</span>\n" +
            "                </a>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"min-h-screen flex flex-column relative flex-auto\">\n" +
            "        <div class=\"flex justify-content-between align-items-center px-5 surface-section relative lg:static border-bottom-1 surface-border\"\n" +
            "             style=\"height:60px\">\n" +
            "            <div class=\"flex\">\n" +
            "                <a class=\"cursor-pointer block lg:hidden text-700 mr-3\"\n" +
            "                   data-pb-styleclass=\"{ selector: '#app-sidebar-5', enterClass: 'hidden', enterActiveClass: 'fadeinleft', leaveToClass: 'hidden', leaveActiveClass: 'fadeoutleft', hideOnOutsideClick: true }\">\n" +
            "                    <i class=\"pi pi-bars text-4xl\"/>\n" +
            "                </a>\n" +
            "                <span class=\"ui-input-icon-left\">\n" +
            "                    <i class=\"pi pi-search\"/>\n" +
            "                    <p:inputText type=\"search\" styleClass=\"border-none\" placeholder=\"Search\"/>\n" +
            "                </span>\n" +
            "            </div>\n" +
            "            <a class=\"cursor-pointer block lg:hidden text-700\"\n" +
            "               data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'fadein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                <i class=\"pi pi-ellipsis-v text-2xl\"/>\n" +
            "            </a>\n" +
            "            <ul class=\"list-none p-0 m-0 hidden lg:flex lg:align-items-center select-none lg:flex-row\n" +
            "                surface-section border-1 lg:border-none surface-border right-0 top-100 z-1 shadow-2 lg:shadow-none absolute lg:static\">\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"/>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <p:badge severity=\"danger\">\n" +
            "                            <i class=\"pi pi-bell text-base lg:text-2xl\"/>\n" +
            "                        </p:badge>\n" +
            "                        <span class=\"block lg:hidden font-medium ml-2 lg:ml-0\">Notifications</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"border-top-1 surface-border lg:border-top-none\">\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\"\n" +
            "                                        library=\"primeblocks-app\"\n" +
            "                                        alt=\"Image\" styleClass=\"mr-3 lg:mr-0\"\n" +
            "                                        style=\"width: 32px; height: 32px\"/>\n" +
            "                        <div class=\"block lg:hidden\">\n" +
            "                            <div class=\"text-900 font-medium\">Josephine Lillard</div>\n" +
            "                            <span class=\"text-600 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                        </div>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "        <div class=\"p-5 flex flex-column flex-auto\">\n" +
            "            <div class=\"border-2 border-dashed surface-border border-round surface-section flex-auto\">\n" +
            "\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block6 = "<div class=\"min-h-screen flex relative lg:static surface-ground\">\n" +
            "    <div id=\"app-sidebar-6\" class=\"h-screen hidden lg:block flex-shrink-0 absolute lg:static left-0 top-0 z-1 select-none w-12rem bg-indigo-800 animation-duration-300 animation-ease-in-out\">\n" +
            "        <div class=\"flex flex-column h-full\">\n" +
            "            <div class=\"flex align-items-center justify-content-center flex-shrink-0\" style=\"height:60px\">\n" +
            "                <p:graphicImage name=\"images/blocks/logos/bastion.svg\" library=\"primeblocks-app\" \n" +
            "                alt=\"Image\" height=\"30\"/>\n" +
            "            </div>\n" +
            "            <div class=\"my-3 p-3\">\n" +
            "                <span class=\"p-input-icon-left relative inline-block\">\n" +
            "                    <i class=\"pi pi-search text-indigo-50 absolute top-50 -mt-2 ml-2\"></i>\n" +
            "                    <p:inputText styleClass=\"appearance-none border-none bg-indigo-700 text-indigo-50 w-full pl-5\"/>\n" +
            "                </span>\n" +
            "            </div>\n" +
            "            <div class=\"overflow-y-auto\">\n" +
            "                <ul class=\"list-none p-3 m-0 flex flex-wrap\">\n" +
            "                    <li class=\"w-6 text-center\">\n" +
            "                        <a class=\"cursor-pointer inline-flex align-items-center justify-content-center border-2 border-indigo-500 hover:bg-indigo-700 active:bg-indigo-400 text-indigo-200 hover:text-indigo-100 transition-colors transition-duration-150\" style=\"width:60px;height:60px;border-radius:10px\">\n" +
            "                            <i class=\"pi pi-home text-2xl\"></i>\n" +
            "                        </a>\n" +
            "                        <div class=\"mt-2 text-indigo-200 font-medium text-sm\">Home</div>\n" +
            "                    </li>\n" +
            "                    <li class=\"w-6 text-center\">\n" +
            "                        <a class=\"cursor-pointer inline-flex align-items-center justify-content-center border-2 border-indigo-500 hover:bg-indigo-700 active:bg-indigo-400 text-indigo-200 hover:text-indigo-100 transition-colors transition-duration-150\" style=\"width:60px;height:60px;border-radius:10px\">\n" +
            "                            <i class=\"pi pi-star text-2xl\"></i>\n" +
            "                        </a>\n" +
            "                        <div class=\"mt-2 text-indigo-200 font-medium text-sm\">Favorites</div>\n" +
            "                    </li>\n" +
            "                    <li class=\"w-6 text-center mt-3\">\n" +
            "                        <a class=\"cursor-pointer inline-flex align-items-center justify-content-center border-2 border-indigo-500 hover:bg-indigo-700 active:bg-indigo-400 text-indigo-200 hover:text-indigo-100 transition-colors transition-duration-150\" style=\"width:60px;height:60px;border-radius:10px\">\n" +
            "                            <i class=\"pi pi-users text-2xl\"></i>\n" +
            "                        </a>\n" +
            "                        <div class=\"mt-2 text-indigo-200 font-medium text-sm\">Users</div>\n" +
            "                    </li>\n" +
            "                    <li class=\"w-6 text-center mt-3\">\n" +
            "                        <a class=\"cursor-pointer inline-flex align-items-center justify-content-center border-2 border-indigo-500 hover:bg-indigo-700 active:bg-indigo-400 text-indigo-200 hover:text-indigo-100 transition-colors transition-duration-150\" style=\"width:60px;height:60px;border-radius:10px\">\n" +
            "                            <i class=\"pi pi-comments text-2xl\"></i>\n" +
            "                        </a>\n" +
            "                        <div class=\"mt-2 text-indigo-200 font-medium text-sm\">Chart</div>\n" +
            "                    </li>\n" +
            "                    <li class=\"w-6 text-center mt-3\">\n" +
            "                        <a class=\"cursor-pointer inline-flex align-items-center justify-content-center border-2 border-indigo-500 hover:bg-indigo-700 active:bg-indigo-400 text-indigo-200 hover:text-indigo-100 transition-colors transition-duration-150\" style=\"width:60px;height:60px;border-radius:10px\">\n" +
            "                            <i class=\"pi pi-calendar text-2xl\"></i>\n" +
            "                        </a>\n" +
            "                        <div class=\"mt-2 text-indigo-200 font-medium text-sm\">Calendar</div>\n" +
            "                    </li>\n" +
            "                    <li class=\"w-6 text-center mt-3\">\n" +
            "                        <a class=\"cursor-pointer inline-flex align-items-center justify-content-center border-2 border-indigo-500 hover:bg-indigo-700 active:bg-indigo-400 text-indigo-200 hover:text-indigo-100 transition-colors transition-duration-150\" style=\"width:60px;height:60px;border-radius:10px\">\n" +
            "                            <i class=\"pi pi-cog text-2xl\"></i>\n" +
            "                        </a>\n" +
            "                        <div class=\"mt-2 text-indigo-200 font-medium text-sm\">Settings</div>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "            <div class=\"mt-auto border-top-1 border-indigo-700 p-3 flex justify-content-between\">\n" +
            "                <a class=\"cursor-pointer inline-flex align-items-center justify-content-center border-2 border-indigo-500 hover:bg-indigo-700 active:bg-indigo-400 text-indigo-200 hover:text-indigo-100 transition-colors transition-duration-150\" style=\"width:40px;height:40px;border-radius:10px\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-6.png\" library=\"primeblocks-app\" alt=\"Image\" \n" +
            "                        style=\"width: 24px; height: 24px\"/>\n" +
            "                </a>\n" +
            "                <a class=\"cursor-pointer inline-flex align-items-center justify-content-center border-2 border-indigo-500 hover:bg-indigo-700 active:bg-indigo-400 text-indigo-200 hover:text-indigo-100 transition-colors transition-duration-150\" style=\"width:40px;height:40px;border-radius:10px\">\n" +
            "                    <i class=\"pi pi-slack text-xl\"></i>\n" +
            "                </a>\n" +
            "                <a class=\"cursor-pointer inline-flex align-items-center justify-content-center border-2 border-indigo-500 hover:bg-indigo-700 active:bg-indigo-400 text-indigo-200 hover:text-indigo-100 transition-colors transition-duration-150\" style=\"width:40px;height:40px;border-radius:10px\">\n" +
            "                    <i class=\"pi pi-github text-xl\"></i>\n" +
            "                </a>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"min-h-screen flex flex-column relative flex-auto\">\n" +
            "        <div class=\"flex justify-content-between align-items-center px-5 surface-section shadow-2 relative lg:static border-bottom-1 surface-border\" style=\"height:60px\">\n" +
            "            <div class=\"flex\">\n" +
            "                <a class=\"cursor-pointer block lg:hidden text-700 mr-3\" \n" +
            "                    data-pb-styleclass=\"{ selector: '#app-sidebar-6', enterClass: 'hidden', enterActiveClass: 'fadeinleft', leaveToClass: 'hidden', leaveActiveClass: 'fadeoutleft', hideOnOutsideClick: true }\">\n" +
            "                    <i class=\"pi pi-bars text-4xl\"></i>\n" +
            "                </a>\n" +
            "            </div>\n" +
            "            <a class=\"cursor-pointer block lg:hidden text-700\" \n" +
            "                data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'fadein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                <i class=\"pi pi-ellipsis-v text-2xl\"></i>\n" +
            "            </a>\n" +
            "            <ul class=\"list-none p-0 m-0 hidden lg:flex lg:align-items-center select-none lg:flex-row \n" +
            "                surface-section border-1 lg:border-none surface-border right-0 top-100 z-1 shadow-2 lg:shadow-none absolute lg:static\">\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <i class=\"pi pi-bell text-base lg:text-2xl mr-2 lg:mr-0\" severity=\"danger\"></i>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Notifications</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"border-top-1 surface-border lg:border-top-none\">\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-6.png\" library=\"primeblocks-app\" alt=\"Image\" \n" +
            "                        style=\"width: 32px; height: 32px\" styleClass=\"mr-3 lg:mr-0\"/>\n" +
            "                        <div class=\"block lg:hidden\">\n" +
            "                            <div class=\"text-900 font-medium\">Josephine Lillard</div>\n" +
            "                            <span class=\"text-600 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                        </div>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "        <div class=\"p-5 flex flex-column flex-auto\">\n" +
            "            <div class=\"border-2 border-dashed surface-border border-round surface-section flex-auto\">\n" +
            "\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block7 = "<div class=\"min-h-screen flex relative lg:static\" style=\"background-image: linear-gradient(120deg, #e0c3fc 0%, #8ec5fc 100%);\">\n" +
            "    <div id=\"app-sidebar-7\" class=\"h-screen hidden lg:block flex-shrink-0 absolute lg:static left-0 top-0 z-1 border-right-1 select-none animation-duration-300 animation-ease-in-out bg-white-alpha-50 border-white-alpha-30\" style=\"width:280px;backdrop-filter: blur(10px);\">\n" +
            "        <div class=\"flex flex-column h-full\">\n" +
            "            <div class=\"flex align-items-center px-5 flex-shrink-0\" style=\"height:60px\">\n" +
            "                <p:graphicImage name=\"images/blocks/logos/hyper-700.svg\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" height=\"30\"/>\n" +
            "            </div>\n" +
            "            <div class=\"overflow-y-auto\">\n" +
            "                <ul class=\"list-none p-3 m-0\">\n" +
            "                    <li>\n" +
            "                        <div class=\"p-3 flex align-items-center justify-content-between text-gray-600 cursor-pointer\" \n" +
            "                        data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup'}\">\n" +
            "                            <span class=\"font-medium\">FAVORITES</span>\n" +
            "                            <i class=\"pi pi-chevron-down\"></i>\n" +
            "                        </div>\n" +
            "                        <ul class=\"list-none p-0 m-0 overflow-hidden\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-800 hover:bg-purple-50 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                    <i class=\"pi pi-home mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Dashboard</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-800 hover:bg-purple-50 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                    <i class=\"pi pi-bookmark mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Bookmarks</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-800 hover:bg-purple-50 transition-duration-150 transition-colors\"\n" +
            "                                    data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup'}\"\n" +
            "                                    style=\"border-radius: 30px\">\n" +
            "                                    <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Reports</span>\n" +
            "                                    <i class=\"pi pi-chevron-down ml-auto\"></i>\n" +
            "                                </a>\n" +
            "                                <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex align-items-center cursor-pointer p-3 text-gray-800 hover:bg-purple-50 transition-duration-150 transition-colors\"\n" +
            "                                            data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup'}\"\n" +
            "                                            style=\"border-radius: 30px\">\n" +
            "                                            <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                                            <span class=\"font-medium\">Revenue</span>\n" +
            "                                            <i class=\"pi pi-chevron-down ml-auto\"></i>\n" +
            "                                        </a>\n" +
            "                                        <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                                            <li>\n" +
            "                                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-800 hover:bg-purple-50 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                                    <i class=\"pi pi-table mr-2\"></i>\n" +
            "                                                    <span class=\"font-medium\">View</span>\n" +
            "                                                </a>\n" +
            "                                            </li>\n" +
            "                                            <li>\n" +
            "                                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-800 hover:bg-purple-50 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                                    <i class=\"pi pi-search mr-2\"></i>\n" +
            "                                                    <span class=\"font-medium\">Search</span>\n" +
            "                                                </a>\n" +
            "                                            </li>\n" +
            "                                        </ul>\n" +
            "                                    </li>\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex align-items-center cursor-pointer p-3 text-gray-800 hover:bg-purple-50 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                            <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                                            <span class=\"font-medium\">Expenses</span>\n" +
            "                                        </a>\n" +
            "                                    </li>\n" +
            "                                </ul>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-800 hover:bg-purple-50 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                    <i class=\"pi pi-users mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Team</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-800 hover:bg-purple-50 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                    <i class=\"pi pi-comments mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Messages</span>\n" +
            "                                    <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-blue-500 text-0 border-circle\" style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-800 hover:bg-purple-50 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                    <i class=\"pi pi-calendar mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Calendar</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-800 hover:bg-purple-50 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                    <i class=\"pi pi-cog mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Settings</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "                <ul class=\"list-none p-3 m-0\">\n" +
            "                    <li>\n" +
            "                        <div class=\"p-3 flex align-items-center justify-content-between text-gray-700 cursor-pointer\" \n" +
            "                        data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup'}\">\n" +
            "                            <span class=\"font-medium\">APPLICATION</span>\n" +
            "                            <i class=\"pi pi-chevron-down\"></i>\n" +
            "                        </div>\n" +
            "                        <ul class=\"list-none p-0 m-0 overflow-hidden\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-800 hover:bg-purple-50 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                    <i class=\"pi pi-folder mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Projects</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-800 hover:bg-purple-50 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                    <i class=\"pi pi-chart-bar mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Performance</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-800 hover:bg-purple-50 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                    <i class=\"pi pi-cog mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Settings</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "            <div class=\"mt-auto border-top-1 border-white-alpha-40\">\n" +
            "                <ul class=\"list-none p-2 m-0 hidden origin-bottom animation-duration-150 overflow-hidden animation-ease-in-out\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-purple-50 text-gray-800 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                            <i class=\"pi pi-user mr-2\"></i>\n" +
            "                            <span class=\"font-medium\">Profile</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-purple-50 text-gray-800 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                            <i class=\"pi pi-cog mr-2\"></i>\n" +
            "                            <span class=\"font-medium\">Settings</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-purple-50 text-gray-800 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                            <i class=\"pi pi-sign-out mr-2\"></i>\n" +
            "                            <span class=\"font-medium\">Sign Out</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "                <a class=\"m-3 px-3 py-2 flex align-items-center hover:bg-purple-50 text-gray-800 cursor-pointer text-gray-800\n" +
            "                    transition-duration-150 transition-colors\"\n" +
            "                        data-pb-styleclass=\"{ selector: '@prev', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup'}\"\n" +
            "                        style=\"border-radius: 30px\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" style=\"width: 28px; height: 28px\" styleClass=\"mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Amy Elsner</span>\n" +
            "                    <i class=\"pi pi-chevron-up ml-auto\"></i>\n" +
            "                </a>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"min-h-screen flex flex-column relative flex-auto\">\n" +
            "        <div class=\"flex justify-content-between align-items-center px-5 border-bottom-1 relative lg:static bg-white-alpha-50 border-white-alpha-40\" style=\"height:60px\">\n" +
            "            <div class=\"flex\">\n" +
            "                <a class=\"cursor-pointer block lg:hidden text-gray-800 mr-3\" \n" +
            "                data-pb-styleclass=\"{ selector: '#app-sidebar-7', enterClass: 'hidden', enterActiveClass: 'fadeinleft', leaveToClass: 'hidden', leaveActiveClass: 'fadeoutleft', hideOnOutsideClick: true}\">\n" +
            "                    <i class=\"pi pi-bars text-4xl\"></i>\n" +
            "                </a>\n" +
            "            </div>\n" +
            "            <a class=\"cursor-pointer block lg:hidden text-gray-800\" \n" +
            "            data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'fadein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true}\">\n" +
            "                <i class=\"pi pi-ellipsis-v text-2xl\"></i>\n" +
            "            </a>\n" +
            "            <ul class=\"list-none p-0 m-0 hidden lg:flex lg:align-items-center select-none lg:flex-row right-0 top-100 z-1 shadow-2 lg:shadow-none absolute lg:static px-3 py-3 lg:py-0 mr-3 lg:mr-0\" style=\"backdrop-filter: blur(10px)\">\n" +
            "                <li class=\"mr-0 lg:mr-3\">\n" +
            "                    <a class=\"flex p-3 lg:p-2 align-items-center text-gray-800 hover:bg-purple-50 font-medium cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                        <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"mr-0 lg:mr-3\">\n" +
            "                    <a class=\"flex p-3 lg:p-2  align-items-center text-gray-800 hover:bg-purple-50 font-medium cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                        <i class=\"pi pi-bell text-base lg:text-2xl mr-2 lg:mr-0\" severity=\"danger\"></i>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Notifications</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"border-top-1 lg:border-top-none lg:mt-0 mt-2 lg:pt-0 pt-2 border-white-alpha-40\">\n" +
            "                    <a class=\"flex p-3 lg:p-2  align-items-center hover:bg-purple-50 font-medium cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" style=\"width: 32px; height: 32px\" styleClass=\"mr-3 lg:mr-0\"/>\n" +
            "                        <div class=\"block lg:hidden\">\n" +
            "                            <div class=\"text-gray-900 font-medium\">Josephine Lillard</div>\n" +
            "                            <span class=\"text-gray-700 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                        </div>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "        <div class=\"p-5 flex flex-column flex-auto\">\n" +
            "            <div class=\"border-2 border-dashed border-round flex-auto bg-white-alpha-50 border-white-alpha-40\">\n" +
            "                \n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block8 = "<div class=\"min-h-screen flex relative lg:static\" style=\"background-image: linear-gradient(60deg, #29323c 0%, #485563 100%);\">\n" +
            "    <div id=\"app-sidebar-8\" class=\"h-screen hidden lg:block flex-shrink-0 absolute lg:static left-0 top-0 z-1 border-right-1 select-none animation-duration-300 animation-ease-in-out border-white-alpha-10\" style=\"width:280px; background-image: linear-gradient(60deg, #29323c 0%, #2f3844 100%);\">\n" +
            "        <div class=\"flex flex-column h-full\">\n" +
            "            <div class=\"flex align-items-center px-5 flex-shrink-0\" style=\"height:60px\">\n" +
            "                <p:graphicImage name=\"images/blocks/logos/hyper-300.svg\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" height=\"30\"/>\n" +
            "            </div>\n" +
            "            <div class=\"overflow-y-auto\">\n" +
            "                <ul class=\"list-none p-3 m-0\">\n" +
            "                    <li>\n" +
            "                        <div class=\"p-3 flex align-items-center justify-content-between text-gray-500 cursor-pointer\" \n" +
            "                        data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup'}\">\n" +
            "                            <span class=\"font-medium\">FAVORITES</span>\n" +
            "                            <i class=\"pi pi-chevron-down\"></i>\n" +
            "                        </div>\n" +
            "                        <ul class=\"list-none p-0 m-0 overflow-hidden\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-bluegray-700 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                    <i class=\"pi pi-home mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Dashboard</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-bluegray-700 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                    <i class=\"pi pi-bookmark mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Bookmarks</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-bluegray-700 transition-duration-150 transition-colors\"\n" +
            "                                    data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup'}\"\n" +
            "                                    style=\"border-radius: 30px\">\n" +
            "                                    <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Reports</span>\n" +
            "                                    <i class=\"pi pi-chevron-down ml-auto\"></i>\n" +
            "                                </a>\n" +
            "                                <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-bluegray-700 transition-duration-150 transition-colors\"\n" +
            "                                            data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup'}\"\n" +
            "                                            style=\"border-radius: 30px\">\n" +
            "                                            <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                                            <span class=\"font-medium\">Revenue</span>\n" +
            "                                            <i class=\"pi pi-chevron-down ml-auto\"></i>\n" +
            "                                        </a>\n" +
            "                                        <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                                            <li>\n" +
            "                                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-bluegray-700 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                                    <i class=\"pi pi-table mr-2\"></i>\n" +
            "                                                    <span class=\"font-medium\">View</span>\n" +
            "                                                </a>\n" +
            "                                            </li>\n" +
            "                                            <li>\n" +
            "                                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-bluegray-700 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                                    <i class=\"pi pi-search mr-2\"></i>\n" +
            "                                                    <span class=\"font-medium\">Search</span>\n" +
            "                                                </a>\n" +
            "                                            </li>\n" +
            "                                        </ul>\n" +
            "                                    </li>\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-bluegray-700 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                            <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                                            <span class=\"font-medium\">Expenses</span>\n" +
            "                                        </a>\n" +
            "                                    </li>\n" +
            "                                </ul>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-bluegray-700 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                    <i class=\"pi pi-users mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Team</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-bluegray-700 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                    <i class=\"pi pi-comments mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Messages</span>\n" +
            "                                    <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-blue-500 text-0 border-circle\" style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-bluegray-700 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                    <i class=\"pi pi-calendar mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Calendar</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-bluegray-700 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                    <i class=\"pi pi-cog mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Settings</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "                <ul class=\"list-none p-3 m-0\">\n" +
            "                    <li>\n" +
            "                        <div class=\"p-3 flex align-items-center justify-content-between text-gray-500 cursor-pointer\" \n" +
            "                            data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup'}\">\n" +
            "                            <span class=\"font-medium\">APPLICATION</span>\n" +
            "                            <i class=\"pi pi-chevron-down\"></i>\n" +
            "                        </div>\n" +
            "                        <ul class=\"list-none p-0 m-0 overflow-hidden\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-bluegray-700 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                    <i class=\"pi pi-folder mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Projects</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-bluegray-700 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                    <i class=\"pi pi-chart-bar mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Performance</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-gray-300 hover:bg-bluegray-700 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                                    <i class=\"pi pi-cog mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Settings</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "            <div class=\"mt-auto border-top-1 border-white-alpha-10\">\n" +
            "                <ul class=\"list-none p-2 m-0 hidden origin-bottom animation-duration-150 overflow-hidden animation-ease-in-out\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-bluegray-700 text-gray-300 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                            <i class=\"pi pi-user mr-2\"></i>\n" +
            "                            <span class=\"font-medium\">Profile</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-bluegray-700 text-gray-300 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                            <i class=\"pi pi-cog mr-2\"></i>\n" +
            "                            <span class=\"font-medium\">Settings</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex align-items-center cursor-pointer p-3 hover:bg-bluegray-700 text-gray-300 transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                            <i class=\"pi pi-sign-out mr-2\"></i>\n" +
            "                            <span class=\"font-medium\">Sign Out</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "                <a class=\"m-3 px-3 py-2 flex align-items-center hover:bg-bluegray-700 text-gray-300 cursor-pointer text-gray-300\n" +
            "                    transition-duration-150 transition-colors\"\n" +
            "                    data-pb-styleclass=\"{ selector: '@prev', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup'}\"\n" +
            "                    style=\"border-radius: 30px\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" styleClass=\"mr-2\" style=\"width: 28px; height: 28px\"/>\n" +
            "                    <span class=\"font-medium\">Amy Elsner</span>\n" +
            "                    <i class=\"pi pi-chevron-up ml-auto\"></i>\n" +
            "                </a>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"min-h-screen flex flex-column relative flex-auto\">\n" +
            "        <div class=\"flex justify-content-between align-items-center px-5 border-bottom-1 relative lg:static border-white-alpha-10\" style=\"height:60px\">\n" +
            "            <div class=\"flex\">\n" +
            "                <a class=\"cursor-pointer block lg:hidden text-gray-300 mr-3\" \n" +
            "                    data-pb-styleclass=\"{ selector: '#app-sidebar-8', enterClass: 'hidden', enterActiveClass: 'fadeinleft', leaveToClass: 'hidden', leaveActiveClass: 'fadeoutleft', hideOnOutsideClick: true}\">\n" +
            "                    <i class=\"pi pi-bars text-4xl\"></i>\n" +
            "                </a>\n" +
            "            </div>\n" +
            "            <a class=\"cursor-pointer block lg:hidden text-gray-300\" \n" +
            "                data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'fadein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true}\">\n" +
            "                <i class=\"pi pi-ellipsis-v text-2xl\"></i>\n" +
            "            </a>\n" +
            "            <ul class=\"list-none p-0 m-0 hidden lg:flex lg:align-items-center select-none lg:flex-row right-0 top-100 z-1 shadow-2 lg:shadow-none absolute lg:static px-3 py-3 lg:py-0 mr-3 lg:mr-0\" style=\"background-image: linear-gradient(60deg, #29323c 0%, #485563 100%); border-radius: 30px\">\n" +
            "                <li class=\"mr-0 lg:mr-3\">\n" +
            "                    <a class=\"flex p-3 lg:p-2 align-items-center text-gray-300 hover:bg-bluegray-700 font-medium cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                        <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"mr-0 lg:mr-3\">\n" +
            "                    <a class=\"flex p-3 lg:p-2  align-items-center text-gray-300 hover:bg-bluegray-700 font-medium cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                        <i class=\"pi pi-bell text-base lg:text-2xl mr-2 lg:mr-0\" severity=\"danger\"></i>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Notifications</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"border-top-1 lg:border-top-none lg:mt-0 mt-2 lg:pt-0 pt-2 border-white-alpha-10\">\n" +
            "                    <a class=\"flex p-3 lg:p-2  align-items-center hover:bg-bluegray-700 font-medium cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\" style=\"border-radius: 30px\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" styleClass=\"mr-3 lg:mr-0\" style=\"width: 32px; height: 32px\"/>\n" +
            "                        <div class=\"block lg:hidden\">\n" +
            "                            <div class=\"text-gray-300 font-medium\">Josephine Lillard</div>\n" +
            "                            <span class=\"text-gray-500 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                        </div>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "        <div class=\"p-5 flex flex-column flex-auto\">\n" +
            "            <div class=\"border-2 border-dashed border-round flex-auto border-white-alpha-10\">\n" +
            "                \n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block9 = "<div class=\"min-h-screen flex relative lg:static surface-ground\">\n" +
            "    <div id=\"app-sidebar-9\" class=\"h-screen surface-section hidden lg:block flex-shrink-0 absolute lg:static left-0 top-0 z-1 border-right-1 surface-border w-18rem lg:w-7rem select-none\">\n" +
            "        <div class=\"flex flex-column h-full\">\n" +
            "            <div class=\"flex align-items-center justify-content-center flex-shrink-0\" style=\"height:60px\">\n" +
            "                <p:graphicImage name=\"images/blocks/logos/hyper-cyan.svg\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" height=\"30\"/>\n" +
            "            </div>\n" +
            "            <div class=\"mt-3\">\n" +
            "                <ul class=\"list-none p-0 m-0\">\n" +
            "                    <li>\n" +
            "                        <a class=\"flex flex-row lg:flex-column align-items-center cursor-pointer p-3 lg:justify-content-center text-cyan-600 border-left-2 border-cyan-600 hover:border-300 transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-home mr-2 lg:mr-0 mb-0 lg:mb-2 text-base lg:text-2xl\"></i>\n" +
            "                            <span class=\"font-medium inline text-base lg:text-xs lg:block\">Home</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex flex-row lg:flex-column align-items-center cursor-pointer p-3 lg:justify-content-center text-600 border-left-2 border-transparent hover:border-300 transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-search mr-2 lg:mr-0 mb-0 lg:mb-2 text-base lg:text-2xl\"></i>\n" +
            "                            <span class=\"font-medium inline text-base lg:text-xs lg:block\">Search</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex flex-row lg:flex-column align-items-center cursor-pointer p-3 lg:justify-content-center text-600 border-left-2 border-transparent hover:border-300 transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-users mr-2 lg:mr-0 mb-0 lg:mb-2 text-base lg:text-2xl\"></i>\n" +
            "                            <span class=\"font-medium inline text-base lg:text-xs lg:block\">Team</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"relative\">\n" +
            "                        <a class=\"flex flex-row lg:flex-column align-items-center cursor-pointer p-3 lg:justify-content-center text-600 border-left-2 border-transparent hover:border-300 transition-duration-150 transition-colors\" \n" +
            "                            data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true}\">\n" +
            "                            <i class=\"pi pi-chart-line mr-2 lg:mr-0 mb-0 lg:mb-2 text-base lg:text-2xl\" pBadge=\"3\" severity=\"danger\"></i>\n" +
            "                            <span class=\"font-medium inline text-base lg:text-xs lg:block\">Reports</span>\n" +
            "                            <i class=\"pi pi-chevron-down ml-auto lg:hidden\"></i>\n" +
            "                        </a>\n" +
            "                        <ul class=\"list-none pl-3 pr-0 py-0 lg:p-3 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out static border-round-right lg:absolute left-100 top-0 z-1 surface-overlay shadow-none lg:shadow-2 w-full lg:w-15rem\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 hover:text-900 border-round text-600 hover:text-700 transition-duration-150 transition-colors\"\n" +
            "                                    data-pb-styleclass=\"{ selector: '@next', toggleClass: 'hidden'}\">\n" +
            "                                    <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Revenue</span>\n" +
            "                                    <i class=\"pi pi-chevron-down ml-auto\"></i>\n" +
            "                                </a>\n" +
            "                                <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 hover:text-900 border-round text-600 hover:text-700 transition-duration-150 transition-colors\">\n" +
            "                                            <i class=\"pi pi-table mr-2\"></i>\n" +
            "                                            <span class=\"font-medium\">View</span>\n" +
            "                                        </a>\n" +
            "                                    </li>\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 hover:text-900 border-round text-600 hover:text-700 transition-duration-150 transition-colors\">\n" +
            "                                            <i class=\"pi pi-search mr-2\"></i>\n" +
            "                                            <span class=\"font-medium\">Search</span>\n" +
            "                                        </a>\n" +
            "                                    </li>\n" +
            "                                </ul>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 hover:text-900 border-round text-600 hover:text-700 transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Expenses</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex flex-row lg:flex-column align-items-center cursor-pointer p-3 lg:justify-content-center text-600 border-left-2 border-transparent hover:border-300 transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-calendar mr-2 lg:mr-0 mb-0 lg:mb-2 text-base lg:text-2xl\"></i>\n" +
            "                            <span class=\"font-medium inline text-base lg:text-xs lg:block\">Events</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a class=\"flex flex-row lg:flex-column align-items-center cursor-pointer p-3 lg:justify-content-center text-600 border-left-2 border-transparent hover:border-300 transition-duration-150 transition-colors\">\n" +
            "                            <i class=\"pi pi-cog mr-2 lg:mr-0 mb-0 lg:mb-2 text-base lg:text-2xl\"></i>\n" +
            "                            <span class=\"font-medium inline text-base lg:text-xs lg:block\">Options</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "            <div class=\"mt-auto\">\n" +
            "                <hr class=\"mb-3 mx-3 border-top-1 border-none surface-border\" />\n" +
            "                <a class=\"m-3 flex flex-row lg:flex-column align-items-center cursor-pointer p-3 lg:justify-content-center hover:surface-200 border-round text-600 transition-duration-150 transition-colors\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" styleClass=\"mr-2 lg:mr-0\" style=\"width: 32px; height: 32px\"/>\n" +
            "                    <span class=\"font-medium inline lg:hidden\">Amy Elsner</span>\n" +
            "                </a>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"min-h-screen flex flex-column relative flex-auto\">\n" +
            "        <div class=\"flex justify-content-between align-items-center px-5 surface-section relative lg:static border-bottom-1 surface-border\" style=\"height:60px\">\n" +
            "            <div class=\"flex\">\n" +
            "                <a class=\"cursor-pointer block lg:hidden text-700 mr-3\"\n" +
            "                    data-pb-styleclass=\"{ selector: '#app-sidebar-9', enterClass: 'hidden', enterActiveClass:'fadeinleft', leaveToClass: 'hidden',leaveActiveClass: 'fadeoutleft', hideOnOutsideClick: true}\">\n" +
            "                    <i class=\"pi pi-bars text-4xl\"></i>\n" +
            "                </a>\n" +
            "                <span class=\"p-input-icon-left\">\n" +
            "                    <i class=\"pi pi-search\"></i>\n" +
            "                    <p:inputText id=\"city\" placeholder=\"Search\" styleClass=\"border-none w-10rem sm:w-20rem\"/>\n" +
            "                </span>\n" +
            "            </div>\n" +
            "            <a class=\"cursor-pointer block lg:hidden text-700\" \n" +
            "                data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass:'fadein', leaveToClass: 'hidden',leaveActiveClass: 'fadeout', hideOnOutsideClick: true}\">\n" +
            "                <i class=\"pi pi-ellipsis-v text-2xl\"></i>\n" +
            "            </a>\n" +
            "            <ul class=\"list-none p-0 m-0 hidden lg:flex lg:align-items-center select-none lg:flex-row \n" +
            "                surface-section border-1 lg:border-none surface-border right-0 top-100 z-1 shadow-2 lg:shadow-none absolute lg:static\">\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <p:badge severity=\"danger\">\n" +
            "                            <i class=\"pi pi-bell text-base lg:text-2xl mr-2 lg:mr-0\" />\n" +
            "                        </p:badge>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Notifications</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"border-top-1 surface-border lg:border-top-none\">\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" styleClass=\"mr-2 lg:mr-0\" style=\"width: 32px; height: 32px\"/>\n" +
            "                        <div class=\"block lg:hidden\">\n" +
            "                            <div class=\"text-900 font-medium\">Amy Elsner</div>\n" +
            "                            <span class=\"text-600 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                        </div>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "        <div class=\"p-5 flex flex-column flex-auto\">\n" +
            "            <div class=\"border-2 border-dashed surface-border border-round surface-section flex-auto\">\n" +
            "                \n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;
    
    private final String block10 = "<div class=\"min-h-screen flex relative lg:static surface-ground\">\n" +
            "    <div id=\"app-sidebar-10\" class=\"h-screen hidden lg:block flex-shrink-0 absolute lg:static left-0 top-0 z-1 select-none surface-ground border-right-1 lg:border-right-none surface-border\" style=\"width:280px\">\n" +
            "        <div class=\"flex flex-column h-full\">\n" +
            "            <div class=\"flex align-items-center px-5 flex-shrink-0\" style=\"height:60px\">\n" +
            "                <p:graphicImage name=\"images/blocks/logos/hyper-700.svg\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" height=\"30\"/>\n" +
            "            </div>\n" +
            "            <div class=\"overflow-y-auto\">\n" +
            "                <div class=\"p-3\">\n" +
            "                    <span class=\"p-input-icon-left relative\">\n" +
            "                        <i class=\"pi pi-search absolute top-50 -mt-2 ml-2\"></i>\n" +
            "                        <p:inputText type=\"search\" styleClass=\"border-1 surface-border pl-5 w-full\"  placeholder=\"Search\" style=\"border-radius: 30px\"/>\n" +
            "                    </span>\n" +
            "                </div>\n" +
            "                <ul class=\"list-none p-3 m-0\">\n" +
            "                    <li>\n" +
            "                        <div class=\"p-3 flex align-items-center justify-content-between text-600r\">\n" +
            "                            <span class=\"font-bold text-800\">FAVORITES</span>\n" +
            "                        </div>\n" +
            "                        <ul class=\"list-none p-0 m-0 overflow-hidden\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-blue-500 hover:surface-200 transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-home mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Dashboard</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-200 transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-bookmark mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Bookmarks</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-200 transition-duration-150 transition-colors\"\n" +
            "                                    data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                                    <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Reports</span>\n" +
            "                                    <i class=\"pi pi-chevron-down ml-auto\"></i>\n" +
            "                                </a>\n" +
            "                                <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-200 transition-duration-150 transition-colors\"\n" +
            "                                            data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup' }\">\n" +
            "                                            <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                                            <span class=\"font-medium\">Revenue</span>\n" +
            "                                            <i class=\"pi pi-chevron-down ml-auto\"></i>\n" +
            "                                        </a>\n" +
            "                                        <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                                            <li>\n" +
            "                                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-200 transition-duration-150 transition-colors\">\n" +
            "                                                    <i class=\"pi pi-table mr-2\"></i>\n" +
            "                                                    <span class=\"font-medium\">View</span>\n" +
            "                                                </a>\n" +
            "                                            </li>\n" +
            "                                            <li>\n" +
            "                                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-200 transition-duration-150 transition-colors\">\n" +
            "                                                    <i class=\"pi pi-search mr-2\"></i>\n" +
            "                                                    <span class=\"font-medium\">Search</span>\n" +
            "                                                </a>\n" +
            "                                            </li>\n" +
            "                                        </ul>\n" +
            "                                    </li>\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-100 transition-duration-150 transition-colors\">\n" +
            "                                            <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                                            <span class=\"font-medium\">Expenses</span>\n" +
            "                                        </a>\n" +
            "                                    </li>\n" +
            "                                </ul>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-200 transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-users mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Team</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-200 transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-comments mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Messages</span>\n" +
            "                                    <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-blue-500 text-0 border-circle\" style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-200 transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-calendar mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Calendar</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-200 transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-cog mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Settings</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "                <ul class=\"list-none p-3 m-0\">\n" +
            "                    <li>\n" +
            "                        <div class=\"p-3 flex align-items-center justify-content-between text-600\">\n" +
            "                            <span class=\"font-bold text-800\">APPLICATION</span>\n" +
            "                        </div>\n" +
            "                        <ul class=\"list-none p-0 m-0 overflow-hidden\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-200 transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-folder mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Projects</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-200 transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-chart-bar mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Performance</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-200 transition-duration-150 transition-colors\">\n" +
            "                                    <i class=\"pi pi-cog mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Settings</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "            <div class=\"mt-auto\">\n" +
            "                <a class=\"m-3 flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-200 transition-duration-150 transition-colors\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" styleClass=\"mr-2\" style=\"width: 28px; height: 28px\"/>\n" +
            "                    <span class=\"font-medium\">Amy Elsner</span>\n" +
            "                </a>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"min-h-screen flex flex-column relative flex-auto\">\n" +
            "        <div class=\"flex align-items-center justify-content-between lg:justify-content-start px-5 relative lg:static\" style=\"height:60px\">\n" +
            "            <a class=\"cursor-pointer block lg:hidden text-700 mr-3\" \n" +
            "                data-pb-styleclass=\"{ selector: '#app-sidebar-10', enterClass: 'hidden', enterActiveClass: 'fadeinleft', leaveToClass: 'hidden', leaveActiveClass: 'fadeoutleft', hideOnOutsideClick: true }\">\n" +
            "                <i class=\"pi pi-bars text-4xl\"></i>\n" +
            "            </a>\n" +
            "            <a class=\"cursor-pointer block lg:hidden text-700\" \n" +
            "                data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'fadein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                <i class=\"pi pi-ellipsis-v text-2xl\"></i>\n" +
            "            </a>\n" +
            "            <ul class=\"list-none p-0 mt-0 mb-0 ml-0 mr-3 lg:mr-0 hidden lg:flex lg:align-items-center select-none lg:flex-row border-round\n" +
            "                border-1 lg:border-none surface-border right-0 top-100 z-1 shadow-2 lg:shadow-none absolute lg:static surface-ground lg:w-full\">\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-200 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-200 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <p:badge severity=\"danger\">\n" +
            "                            <i class=\"pi pi-bell text-base lg:text-2xl mr-2 lg:mr-0\" />\n" +
            "                        </p:badge>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Notifications</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-200 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <i class=\"pi pi-cog text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Settings</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-200 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <i class=\"pi pi-user text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Profile</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"border-top-1 surface-border lg:border-top-none ml-auto\">\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center hover:surface-200 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" styleClass=\"mr-3 lg:mr-0\" style=\"width: 32px; height: 32px\"/>\n" +
            "                        <div class=\"block lg:hidden\">\n" +
            "                            <div class=\"text-900 font-medium\">Amy Elsner</div>\n" +
            "                            <span class=\"text-600 font-medium text-sm\">Developer</span>\n" +
            "                        </div>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "        <div class=\"p-5 flex flex-column flex-auto\">\n" +
            "            <div class=\"border-2 border-dashed surface-border border-round surface-section flex-auto\">\n" +
            "                \n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block11 = "<div class=\"min-h-screen flex relative lg:static surface-ground\">\n" +
            "    <div id=\"app-sidebar-11\" class=\"surface-section h-screen hidden lg:block flex-shrink-0 absolute lg:static left-0 top-0 z-1 border-right-1 surface-border select-none\" style=\"width:280px\">\n" +
            "        <div class=\"flex flex-column h-full\">\n" +
            "            <div class=\"flex align-items-center px-5 flex-shrink-0\" style=\"height:60px\">\n" +
            "                <p:graphicImage name=\"images/blocks/logos/hyper-700.svg\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" height=\"30\"/>\n" +
            "            </div>\n" +
            "            <div class=\"overflow-y-auto\">\n" +
            "                <ul class=\"list-none p-3 m-0\">\n" +
            "                    <li>\n" +
            "                        <div class=\"p-3 flex align-items-center justify-content-between text-600 cursor-pointer border-2 border-transparent border-rounded\" \n" +
            "                            data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup'}\">\n" +
            "                            <span class=\"font-medium\">FAVORITES</span>\n" +
            "                            <i class=\"pi pi-chevron-down\"></i>\n" +
            "                        </div>\n" +
            "                        <ul class=\"list-none p-0 m-0 overflow-hidden\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-700 border-2 border-transparent hover:border-300 transition-duration-150 transition-colors text-indigo-500\" style=\"border-radius: 12px\">\n" +
            "                                    <i class=\"pi pi-home mr-2\"></i>\n" +
            "                                    <span class=\"font-medium\">Dashboard</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-700 border-2 border-transparent hover:border-300 transition-duration-150 transition-colors\" style=\"border-radius: 12px\">\n" +
            "                                    <i class=\"pi pi-bookmark mr-2 text-blue-500\"></i>\n" +
            "                                    <span class=\"font-medium\">Bookmarks</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-700 border-2 border-transparent hover:border-300 transition-duration-150 transition-colors\" style=\"border-radius: 12px\"\n" +
            "                                    data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup'}\">\n" +
            "                                    <i class=\"pi pi-chart-line mr-2 text-purple-500\"></i>\n" +
            "                                    <span class=\"font-medium\">Reports</span>\n" +
            "                                    <i class=\"pi pi-chevron-down ml-auto\"></i>\n" +
            "                                </a>\n" +
            "                                <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex align-items-center cursor-pointer p-3 text-700 border-2 border-transparent hover:border-300 transition-duration-150 transition-colors\" style=\"border-radius: 12px\"\n" +
            "                                            data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup'}\">\n" +
            "                                            <i class=\"pi pi-chart-line mr-2 text-purple-500\"></i>\n" +
            "                                            <span class=\"font-medium\">Revenue</span>\n" +
            "                                            <i class=\"pi pi-chevron-down ml-auto\"></i>\n" +
            "                                        </a>\n" +
            "                                        <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                                            <li>\n" +
            "                                                <a class=\"flex align-items-center cursor-pointer p-3 text-700 border-2 border-transparent hover:border-300 transition-duration-150 transition-colors\" style=\"border-radius: 12px\">\n" +
            "                                                    <i class=\"pi pi-table text-purple-500 mr-2\"></i>\n" +
            "                                                    <span class=\"font-medium\">View</span>\n" +
            "                                                </a>\n" +
            "                                            </li>\n" +
            "                                            <li>\n" +
            "                                                <a class=\"flex align-items-center cursor-pointer p-3 text-700 border-2 border-transparent hover:border-300 transition-duration-150 transition-colors\" style=\"border-radius: 12px\">\n" +
            "                                                    <i class=\"pi pi-search mr-2 text-purple-500\"></i>\n" +
            "                                                    <span class=\"font-medium\">Search</span>\n" +
            "                                                </a>\n" +
            "                                            </li>\n" +
            "                                        </ul>\n" +
            "                                    </li>\n" +
            "                                    <li>\n" +
            "                                        <a class=\"flex align-items-center cursor-pointer p-3 text-700 border-2 border-transparent hover:border-300 transition-duration-150 transition-colors\" style=\"border-radius: 12px\">\n" +
            "                                            <i class=\"pi pi-chart-line mr-2 text-purple-500\"></i>\n" +
            "                                            <span class=\"font-medium\">Expenses</span>\n" +
            "                                        </a>\n" +
            "                                    </li>\n" +
            "                                </ul>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-700 border-2 border-transparent hover:border-300 transition-duration-150 transition-colors\" style=\"border-radius: 12px\">\n" +
            "                                    <i class=\"pi pi-users mr-2 text-green-500\"></i>\n" +
            "                                    <span class=\"font-medium\">Team</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-700 border-2 border-transparent hover:border-300 transition-duration-150 transition-colors\" style=\"border-radius: 12px\">\n" +
            "                                    <i class=\"pi pi-comments mr-2 text-cyan-500 \"></i>\n" +
            "                                    <span class=\"font-medium\">Messages</span>\n" +
            "                                    <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-indigo-500 text-0 border-circle\" style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-700 border-2 border-transparent hover:border-300 transition-duration-150 transition-colors\" style=\"border-radius: 12px\">\n" +
            "                                    <i class=\"pi pi-calendar mr-2 text-teal-500 \"></i>\n" +
            "                                    <span class=\"font-medium\">Calendar</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 text-700 border-2 border-transparent hover:border-300 transition-duration-150 transition-colors\" style=\"border-radius: 12px\">\n" +
            "                                    <i class=\"pi pi-cog mr-2 text-pink-500 \"></i>\n" +
            "                                    <span class=\"font-medium\">Settings</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "                <ul class=\"list-none p-3 m-0\">\n" +
            "                    <li>\n" +
            "                        <div class=\"p-3 flex align-items-center justify-content-between text-600 cursor-pointer\" \n" +
            "                            data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup'}\">\n" +
            "                            <span class=\"font-medium\">APPLICATIONS</span>\n" +
            "                            <i class=\"pi pi-chevron-down\"></i>\n" +
            "                        </div>\n" +
            "                        <ul class=\"list-none p-0 m-0 overflow-hidden\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-2 border-transparent hover:border-300 text-700 transition-duration-150 transition-colors\" style=\"border-radius: 12px\">\n" +
            "                                    <i class=\"pi pi-discord mr-2 text-cyan-500\"></i>\n" +
            "                                    <span class=\"font-medium\">Discord</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-2 border-transparent hover:border-300 text-700 transition-duration-150 transition-colors\" style=\"border-radius: 12px\">\n" +
            "                                    <i class=\"pi pi-slack mr-2 text-purple-500\"></i>\n" +
            "                                    <span class=\"font-medium\">Slack</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 border-2 border-transparent hover:border-300 text-700 transition-duration-150 transition-colors\" style=\"border-radius: 12px\">\n" +
            "                                    <i class=\"pi pi-github mr-2 text-blue-500\"></i>\n" +
            "                                    <span class=\"font-medium\">GitHub</span>\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "            <div class=\"mt-auto\">\n" +
            "                <hr class=\"mb-3 mx-3 border-top-1 border-none surface-border\" />\n" +
            "                <a class=\"m-3 flex align-items-center cursor-pointer p-3 text-700 border-2 border-transparent hover:border-300 transition-duration-150 transition-colors\" style=\"border-radius: 12px\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" style=\"width: 28px; height: 28px\" styleClass=\"mr-2\"/>\n" +
            "                    <span class=\"font-medium\">Amy Elsner</span>\n" +
            "                </a>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"min-h-screen flex flex-column relative flex-auto\">\n" +
            "        <div class=\"flex justify-content-between align-items-center px-5 surface-0 border-bottom-1 surface-border relative lg:static\" style=\"height:60px\">\n" +
            "            <a class=\"cursor-pointer block lg:hidden text-700 mr-3\" \n" +
            "                data-pb-styleclass=\"{ selector: '#app-sidebar-11', enterClass: 'hidden', enterActiveClass: 'fadeinleft', leaveToClass: 'hidden', leaveActiveClass: 'fadeoutleft', hideOnOutsideClick: true}\">\n" +
            "                <i class=\"pi pi-bars text-4xl\"></i>\n" +
            "            </a>\n" +
            "            <a class=\"cursor-pointer block lg:hidden text-700\" \n" +
            "                data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'fadein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true}\">\n" +
            "                <i class=\"pi pi-ellipsis-v text-2xl\"></i>\n" +
            "            </a>\n" +
            "            <ul class=\"list-none p-0 m-0 hidden lg:flex lg:align-items-center select-none lg:flex-row w-auto lg:w-full\n" +
            "                surface-section border-1 lg:border-none surface-border right-0 top-100 z-1 shadow-2 lg:shadow-none absolute lg:static\">\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <p:badge severity=\"danger\">\n" +
            "                            <i class=\"pi pi-bell text-base lg:text-2xl mr-2 lg:mr-0\" />\n" +
            "                        </p:badge>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Notifications</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-200 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <i class=\"pi pi-cog text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Settings</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-200 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <i class=\"pi pi-user text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Profile</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-200 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <i class=\"pi pi-star text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Favorites</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li>\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center text-600 hover:text-900 hover:surface-200 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <i class=\"pi pi-pencil text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Edit</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"border-top-1 surface-border lg:border-top-none ml-auto\">\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" style=\"width: 32px; height: 32px\" styleClass=\"mr-3 lg:mr-0\"/>\n" +
            "                        <div class=\"block lg:hidden\">\n" +
            "                            <div class=\"text-900 font-medium\">Josephine Lillard</div>\n" +
            "                            <span class=\"text-600 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                        </div>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "        <div class=\"p-5 flex flex-column flex-auto\">\n" +
            "            <div class=\"border-2 border-dashed surface-border border-round surface-section flex-auto\">\n" +
            "                \n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block12 = "<div class=\"min-h-screen flex flex-column relative lg:static surface-ground\">\n" +
            "    <div class=\"surface-overlay py-3 px-6 flex align-items-center justify-content-between\">\n" +
            "        <a class=\"cursor-pointer block lg:hidden text-700\" \n" +
            "        data-pb-styleclass=\"{ selector: '#app-sidebar-12', enterClass: 'hidden', enterActiveClass: 'fadeinleft', leaveToClass: 'hidden', leaveActiveClass: 'fadeoutleft', hideOnOutsideClick: true}\">\n" +
            "            <i class=\"pi pi-bars text-4xl\"></i>\n" +
            "        </a>\n" +
            "        <p:graphicImage name=\"images/blocks/logos/hyper-700.svg\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" height=\"40\" styleClass=\"mr-0 lg:mr-6\"/>\n" +
            "        <a class=\"cursor-pointer block lg:hidden text-700\" \n" +
            "            data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true}\">\n" +
            "            <i class=\"pi pi-ellipsis-v text-2xl\"></i>\n" +
            "        </a>\n" +
            "        <ul class=\"list-none p-3 lg:p-0 m-0 lg:align-items-center select-none flex-column lg:flex-row absolute hidden lg:flex lg:static surface-overlay right-0 top-100 z-1 shadow-2 lg:shadow-none\">\n" +
            "            <li class=\"lg:mr-1\">\n" +
            "                <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150 lg:border-circle\">\n" +
            "                    <i class=\"pi pi-inbox text-base lg:text-2xl mr-2 lg:mr-0\"></i>\n" +
            "                    <span class=\"block lg:hidden font-medium\">Inbox</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li class=\"lg:mr-1\">\n" +
            "                <a class=\"flex p-3 align-items-center text-600 hover:text-900 hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150 lg:border-circle\">\n" +
            "                    <p:badge severity=\"danger\">\n" +
            "                        <i class=\"pi pi-bell text-base lg:text-2xl mr-2 lg:mr-0\" />\n" +
            "                    </p:badge>\n" +
            "                    <span class=\"block lg:hidden font-medium\">Notifications</span>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "            <li class=\"border-top-1 surface-border lg:border-top-none lg:mt-0 mt-2 lg:pt-0 pt-2\">\n" +
            "                <a class=\"flex p-3 align-items-center hover:surface-100 font-medium border-round cursor-pointer transition-colors transition-duration-150 lg:border-circle\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\" style=\"width: 25px; height: 25px\" styleClass=\"mr-3 lg:mr-0\"/>\n" +
            "                    <div class=\"block lg:hidden\">\n" +
            "                        <div class=\"text-900 font-medium\">Josephine Lillard</div>\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                    </div>\n" +
            "                </a>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "    </div>\n" +
            "    <ul class=\"list-none py-3 px-5 m-0 surface-section flex align-items-center font-medium overflow-x-auto border-top-1 border-bottom-1 surface-border\">\n" +
            "        <li class=\"pr-3\">\n" +
            "            <a class=\"cursor-pointer\">\n" +
            "                <i class=\"pi pi-home text-600\"></i>\n" +
            "            </a>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <i class=\"pi pi-angle-right text-600\"></i>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <a class=\"cursor-pointer text-600 white-space-nowrap\">Favorites</a>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <i class=\"pi pi-angle-right text-600\"></i>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <a class=\"cursor-pointer text-purple-500 white-space-nowrap\">Dashboard</a>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "    <div class=\"flex relative lg:static p-5 flex-auto\">\n" +
            "        <div id=\"app-sidebar-12\" class=\"surface-card hidden lg:block flex-shrink-0 absolute lg:static left-0 top-0 z-1 select-none shadow-2\" style=\"width:280px;border-radius: 12px\">\n" +
            "            <div class=\"flex flex-column h-full\">\n" +
            "                <div class=\"overflow-y-auto\">\n" +
            "                    <div class=\"p-3\">\n" +
            "                        <span class=\"p-input-icon-left relative\">\n" +
            "                            <i class=\"pi pi-search absolute top-50 -mt-2 ml-2\"></i>\n" +
            "                            <p:inputText type=\"search\" styleClass=\"border-1 surface-border w-full pl-5\" placeholder=\"Search\" style=\"border-radius: 30px\"/>\n" +
            "                        </span>\n" +
            "                    </div>\n" +
            "\n" +
            "                    <ul class=\"list-none px-3 pb-3 pt-0 m-0\">\n" +
            "                        <li>\n" +
            "                            <div class=\"p-3 flex align-items-center justify-content-between text-600\">\n" +
            "                                <span class=\"font-medium text-sm text-900\">FAVORITES</span>\n" +
            "                            </div>\n" +
            "                            <ul class=\"list-none p-0 m-0 overflow-hidden\">\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 bg-purple-50 transition-duration-150 transition-colors text-purple-500 border-purple-500 border-right-2\">\n" +
            "                                        <i class=\"pi pi-home mr-2\"></i>\n" +
            "                                        <span class=\"font-medium\">Dashboard</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 transition-duration-150 transition-colors border-right-2 border-transparent\">\n" +
            "                                        <i class=\"pi pi-bookmark mr-2\"></i>\n" +
            "                                        <span class=\"font-medium\">Bookmarks</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 transition-duration-150 transition-colors border-right-2 border-transparent\"\n" +
            "                                        data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup'}\">\n" +
            "                                        <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                                        <span class=\"font-medium\">Reports</span>\n" +
            "                                        <i class=\"pi pi-chevron-down ml-auto\"></i>\n" +
            "                                    </a>\n" +
            "                                    <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                                        <li>\n" +
            "                                            <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 transition-duration-150 transition-colors border-right-2 border-transparent\"\n" +
            "                                                data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'slidedown', leaveToClass: 'hidden', leaveActiveClass: 'slideup'}\">\n" +
            "                                                <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                                                <span class=\"font-medium\">Revenue</span>\n" +
            "                                                <i class=\"pi pi-chevron-down ml-auto\"></i>\n" +
            "                                            </a>\n" +
            "                                            <ul class=\"list-none py-0 pl-3 pr-0 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out\">\n" +
            "                                                <li>\n" +
            "                                                    <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 transition-duration-150 transition-colors border-right-2 border-transparent\">\n" +
            "                                                        <i class=\"pi pi-table mr-2\"></i>\n" +
            "                                                        <span class=\"font-medium\">View</span>\n" +
            "                                                    </a>\n" +
            "                                                </li>\n" +
            "                                                <li>\n" +
            "                                                    <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 transition-duration-150 transition-colors border-right-2 border-transparent\">\n" +
            "                                                        <i class=\"pi pi-search mr-2\"></i>\n" +
            "                                                        <span class=\"font-medium\">Search</span>\n" +
            "                                                    </a>\n" +
            "                                                </li>\n" +
            "                                            </ul>\n" +
            "                                        </li>\n" +
            "                                        <li>\n" +
            "                                            <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 transition-duration-150 transition-colors border-right-2 border-transparent\">\n" +
            "                                                <i class=\"pi pi-chart-line mr-2\"></i>\n" +
            "                                                <span class=\"font-medium\">Expenses</span>\n" +
            "                                            </a>\n" +
            "                                        </li>\n" +
            "                                    </ul>\n" +
            "                                </li>\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 transition-duration-150 transition-colors border-right-2 border-transparent\">\n" +
            "                                        <i class=\"pi pi-users mr-2\"></i>\n" +
            "                                        <span class=\"font-medium\">Team</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 transition-duration-150 transition-colors border-right-2 border-transparent\">\n" +
            "                                        <i class=\"pi pi-comments mr-2\"></i>\n" +
            "                                        <span class=\"font-medium\">Messages</span>\n" +
            "                                        <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-purple-500 text-0 border-circle\" style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                            </ul>\n" +
            "                        </li>\n" +
            "                    </ul>\n" +
            "                    <ul class=\"list-none p-3 m-0\">\n" +
            "                        <li>\n" +
            "                            <div class=\"p-3 flex align-items-center justify-content-between text-600\">\n" +
            "                                <span class=\"font-medium text-sm text-900\">APPLICATION</span>\n" +
            "                            </div>\n" +
            "                            <ul class=\"list-none p-0 m-0 overflow-hidden\">\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 transition-duration-150 transition-colors border-right-2 border-transparent\">\n" +
            "                                        <i class=\"pi pi-folder mr-2\"></i>\n" +
            "                                        <span class=\"font-medium\">Projects</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 transition-duration-150 transition-colors border-right-2 border-transparent\">\n" +
            "                                        <i class=\"pi pi-chart-bar mr-2\"></i>\n" +
            "                                        <span class=\"font-medium\">Performance</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 text-700 hover:surface-100 transition-duration-150 transition-colors border-right-2 border-transparent\">\n" +
            "                                        <i class=\"pi pi-cog mr-2\"></i>\n" +
            "                                        <span class=\"font-medium\">Settings</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                            </ul>\n" +
            "                        </li>\n" +
            "                    </ul>\n" +
            "                </div>\n" +
            "                <div class=\"mt-auto border-top-1 surface-border p-3 flex justify-content-between\">\n" +
            "                    <a class=\"cursor-pointer inline-flex align-items-center justify-content-center border-2 surface-border hover:surface-100 text-600 transition-colors transition-duration-150 border-circle\" style=\"width:40px;height:40px\">\n" +
            "                        <i class=\"pi pi-file text-xl\"></i>\n" +
            "                    </a>\n" +
            "                    <a class=\"cursor-pointer inline-flex align-items-center justify-content-center border-2 surface-border hover:surface-100 text-600 transition-colors transition-duration-150 border-circle\" style=\"width:40px;height:40px\">\n" +
            "                        <i class=\"pi pi-star text-xl\"></i>\n" +
            "                    </a>\n" +
            "                    <a class=\"cursor-pointer inline-flex align-items-center justify-content-center border-2 surface-border hover:surface-100 text-600 transition-colors transition-duration-150 border-circle\" style=\"width:40px;height:40px\">\n" +
            "                        <i class=\"pi pi-cog text-xl\"></i>\n" +
            "                    </a>\n" +
            "                    <a class=\"cursor-pointer inline-flex align-items-center justify-content-center bg-pink-500 text-white border-2 border-pink-600 hover:bg-pink-600 text-600 transition-colors transition-duration-150 border-circle\" style=\"width:40px;height:40px\">\n" +
            "                        <i class=\"pi pi-sign-out text-xl\"></i>\n" +
            "                    </a>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"flex flex-column flex-auto\">\n" +
            "            <div class=\"border-2 border-dashed surface-border border-round surface-section flex-auto lg:ml-5\">\n" +
            "                \n" +
            "            </div>\n" +
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

    public String getBlock12() {
        return block12;
    }

}
