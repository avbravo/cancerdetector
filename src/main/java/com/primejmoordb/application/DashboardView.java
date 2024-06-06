package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class DashboardView implements Serializable {

    private final String block1 = "<div class=\"min-h-screen flex relative lg:static surface-ground\">\n" +
            "    <div id=\"app-sidebar\"\n" +
            "         class=\"surface-section h-full lg:h-auto hidden lg:block flex-shrink-0 absolute lg:static left-0 top-0 z-1 border-right-1 surface-border select-none\"\n" +
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
            "                                    alt=\"Image\" style=\"width: 28px; height: 28px\" styleClass=\"mr-2\"/>\n" +
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
            "                   data-pb-styleclass=\"{ selector: '#app-sidebar', enterClass: 'hidden', enterActiveClass: 'fadeinleft', leaveToClass: 'hidden', leaveActiveClass: 'fadeoutleft', hideOnOutsideClick: true }\">\n" +
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
            "                                        alt=\"Image\" style=\"width: 32px; height: 32px\"\n" +
            "                                        styleClass=\"mr-3 lg:mr-0\"/>\n" +
            "                        <div class=\"block lg:hidden\">\n" +
            "                            <div class=\"text-900 font-medium\">Josephine Lillard</div>\n" +
            "                            <span class=\"text-600 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                        </div>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "        <div class=\"flex flex-column flex-auto\">\n" +
            "            <div class=\"surface-section p-5\">\n" +
            "                <div class=\"flex align-items-start flex-column lg:flex-row lg:justify-content-between\">\n" +
            "                    <div class=\"flex align-items-start flex-column md:flex-row\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1@2x.png\"\n" +
            "                                        library=\"primeblocks-app\"\n" +
            "                                        alt=\"Image\" style=\"width:90px;height:90px\"\n" +
            "                                        styleClass=\"mr-5 mb-3 lg:mb-0\"/>\n" +
            "                        <div>\n" +
            "                            <span class=\"text-900 font-medium text-3xl\">Kathryn Murphy</span>\n" +
            "                            <i class=\"pi pi-star text-2xl ml-4 text-yellow-500\"/>\n" +
            "                            <div class=\"flex align-items-center flex-wrap text-sm\">\n" +
            "                                <div class=\"mr-5 mt-3\">\n" +
            "                                    <span class=\"font-medium text-500\">FOLLOWERS</span>\n" +
            "                                    <div class=\"text-700 mt-2\">333</div>\n" +
            "                                </div>\n" +
            "                                <div class=\"mr-5 mt-3\">\n" +
            "                                    <span class=\"font-medium text-500\">PROJECTS</span>\n" +
            "                                    <div class=\"text-700 mt-2\">26</div>\n" +
            "                                </div>\n" +
            "                                <div class=\"mr-5 mt-3\">\n" +
            "                                    <span class=\"font-medium text-500\">COLLECTIONS</span>\n" +
            "                                    <div class=\"text-700 mt-2\">17</div>\n" +
            "                                </div>\n" +
            "                                <div class=\"mt-3\">\n" +
            "                                    <span class=\"font-medium text-500\">SHOTS</span>\n" +
            "                                    <div class=\"text-700 mt-2\">130</div>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                    <div class=\"mt-3 lg:mt-0\">\n" +
            "                        <p:commandButton type=\"button\" icon=\"pi pi-bookmark\"\n" +
            "                                         styleClass=\"rounded-button mr-2\"/>\n" +
            "                        <p:commandButton type=\"button\" icon=\"pi pi-heart\"\n" +
            "                                         styleClass=\"rounded-button ui-button-success mr-2\"/>\n" +
            "                        <p:commandButton type=\"button\" icon=\"pi pi-list\"\n" +
            "                                         styleClass=\"rounded-button ui-button-help mr-2\"/>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"p-5\">\n" +
            "                <div class=\"grid\">\n" +
            "                    <div class=\"col-12 lg:col-6 xl:col-3\">\n" +
            "                        <div class=\"surface-card shadow-2 p-3 border-1 border-50 border-round\">\n" +
            "                            <div class=\"flex justify-content-between mb-3\">\n" +
            "                                <div>\n" +
            "                                    <span class=\"block text-500 font-medium mb-3\">Orders</span>\n" +
            "                                    <div class=\"text-900 font-medium text-xl\">152</div>\n" +
            "                                </div>\n" +
            "                                <div class=\"flex align-items-center justify-content-center bg-blue-100 border-round\"\n" +
            "                                     style=\"width:2.5rem;height:2.5rem\">\n" +
            "                                    <i class=\"pi pi-shopping-cart text-blue-500 text-xl\"/>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                            <span class=\"text-green-500 font-medium\">24 new </span>\n" +
            "                            <span class=\"text-500\">since last visit</span>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                    <div class=\"col-12 lg:col-6 xl:col-3\">\n" +
            "                        <div class=\"surface-card shadow-2 p-3 border-1 border-50 border-round\">\n" +
            "                            <div class=\"flex justify-content-between mb-3\">\n" +
            "                                <div>\n" +
            "                                    <span class=\"block text-500 font-medium mb-3\">Revenue</span>\n" +
            "                                    <div class=\"text-900 font-medium text-xl\">$2.100</div>\n" +
            "                                </div>\n" +
            "                                <div class=\"flex align-items-center justify-content-center bg-orange-100 border-round\"\n" +
            "                                     style=\"width:2.5rem;height:2.5rem\">\n" +
            "                                    <i class=\"pi pi-map-marker text-orange-500 text-xl\"/>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                            <span class=\"text-green-500 font-medium\">%52+ </span>\n" +
            "                            <span class=\"text-500\">since last week</span>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                    <div class=\"col-12 lg:col-6 xl:col-3\">\n" +
            "                        <div class=\"surface-card shadow-2 p-3 border-1 border-50 border-round\">\n" +
            "                            <div class=\"flex justify-content-between mb-3\">\n" +
            "                                <div>\n" +
            "                                    <span class=\"block text-500 font-medium mb-3\">Customers</span>\n" +
            "                                    <div class=\"text-900 font-medium text-xl\">28441</div>\n" +
            "                                </div>\n" +
            "                                <div class=\"flex align-items-center justify-content-center bg-cyan-100 border-round\"\n" +
            "                                     style=\"width:2.5rem;height:2.5rem\">\n" +
            "                                    <i class=\"pi pi-inbox text-cyan-500 text-xl\"/>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                            <span class=\"text-green-500 font-medium\">520  </span>\n" +
            "                            <span class=\"text-500\">newly registered</span>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                    <div class=\"col-12 lg:col-6 xl:col-3\">\n" +
            "                        <div class=\"surface-card shadow-2 p-3 border-1 border-50 border-round\">\n" +
            "                            <div class=\"flex justify-content-between mb-3\">\n" +
            "                                <div>\n" +
            "                                    <span class=\"block text-500 font-medium mb-3\">Comments</span>\n" +
            "                                    <div class=\"text-900 font-medium text-xl\">152 Unread</div>\n" +
            "                                </div>\n" +
            "                                <div class=\"flex align-items-center justify-content-center bg-purple-100 border-round\"\n" +
            "                                     style=\"width:2.5rem;height:2.5rem\">\n" +
            "                                    <i class=\"pi pi-comment text-purple-500 text-xl\"/>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                            <span class=\"text-green-500 font-medium\">85 </span>\n" +
            "                            <span class=\"text-500\">responded</span>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                    <div class=\"col-12 xl:col-6\">\n" +
            "                        <div class=\"surface-card shadow-2 border-round p-4\">\n" +
            "                            <div class=\"text-xl text-900 font-medium mb-5\">Latest News</div>\n" +
            "                            <ul class=\"list-none p-0 m-0\">\n" +
            "                                <li class=\"pb-3 border-bottom-1 surface-border\">\n" +
            "                                    <div class=\"font-medium text-900 mb-2\">Aenean euismod elementum</div>\n" +
            "                                    <div class=\"line-height-3 text-600\"\n" +
            "                                         style=\"max-width: 30rem\">Vitae turpis massa sed elementum tempus egestas sed sed risus.\n" +
            "                                        In metus vulputate eu scelerisque felis imperdiet proin.\n" +
            "                                    </div>\n" +
            "                                </li>\n" +
            "                                <li class=\"py-3 border-bottom-1 surface-border\">\n" +
            "                                    <div class=\"font-medium text-900 mb-2\">In iaculis nunc sed augue lacus</div>\n" +
            "                                    <div class=\"line-height-3 text-600\"\n" +
            "                                         style=\"max-width: 30rem\">Viverra vitae congue. Nisi scelerisque eu ultrices vitae auctor eu augue ut lectus.\n" +
            "                                        Elementum eu facilisis sed odio morbi.\n" +
            "                                    </div>\n" +
            "                                </li>\n" +
            "                                <li class=\"py-3 border-bottom-1 surface-border\">\n" +
            "                                    <div class=\"font-medium text-900 mb-2\">Proin sagittis nisl rhoncus</div>\n" +
            "                                    <div class=\"line-height-3 text-600\"\n" +
            "                                         style=\"max-width: 30rem\">In pellentesque massa placerat duis ultricies lacus. Ac feugiat sed lectus vestibulum mattis ullamcorper.\n" +
            "                                    </div>\n" +
            "                                </li>\n" +
            "                            </ul>\n" +
            "                            <div class=\"flex justify-content-between pt-3\">\n" +
            "                                <p:commandButton type=\"button\" value=\"Clear All\"\n" +
            "                                                 styleClass=\"ui-button-outlined ui-button-secondary w-6 mr-2\"/>\n" +
            "                                <p:commandButton type=\"button\" value=\"New Entry\"\n" +
            "                                                 styleClass=\"ui-button-outlined w-6 ml-2\"/>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                    <div class=\"col-12 xl:col-6\">\n" +
            "                        <div class=\"surface-card shadow-2 border-round p-4\">\n" +
            "                            <div class=\"flex justify-content-between align-items-center mb-5\">\n" +
            "                                <span class=\"text-xl text-900 font-medium\">Team Members</span>\n" +
            "                                <div>\n" +
            "                                    <p:commandButton id=\"dashboardButton\" type=\"button\"\n" +
            "                                                     icon=\"pi pi-ellipsis-v\"\n" +
            "                                                     styleClass=\"ui-button-flat ui-button-plain rounded-button\"/>\n" +
            "                                    <p:menu overlay=\"true\" trigger=\"dashboardButton\" my=\"left top\"\n" +
            "                                            at=\"left bottom\">\n" +
            "                                        <p:submenu label=\"Options\">\n" +
            "                                            <p:menuitem value=\"Add New\" icon=\"pi pi-fw pi-plus\"/>\n" +
            "                                            <p:menuitem value=\"Remove\" icon=\"pi pi-fw pi-minus\"/>\n" +
            "                                        </p:submenu>\n" +
            "                                    </p:menu>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                            <ul class=\"list-none p-0 m-0\">\n" +
            "                                <li class=\"flex flex-column md:flex-row md:align-items-center md:justify-content-between mb-4\">\n" +
            "                                    <div class=\"flex\">\n" +
            "                                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\"\n" +
            "                                                        library=\"primeblocks-app\"\n" +
            "                                                        alt=\"Image\" style=\"width: 45px; height: 45px\"\n" +
            "                                                        styleClass=\"mr-3\"/>\n" +
            "                                        <div>\n" +
            "                                            <span class=\"block text-900 font-medium mb-1\">Janette Hudson</span>\n" +
            "                                            <div class=\"text-600\">UI/UX Designer</div>\n" +
            "                                        </div>\n" +
            "                                    </div>\n" +
            "                                    <div class=\"mt-2 md:mt-0 flex flex-nowrap\">\n" +
            "                                        <p:commandButton type=\"button\" icon=\"pi pi-twitter\"\n" +
            "                                                         styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                                        <p:commandButton type=\"button\" icon=\"pi pi-github\"\n" +
            "                                                         styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                                        <p:commandButton type=\"button\" icon=\"pi pi-facebook\"\n" +
            "                                                         styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                                    </div>\n" +
            "                                </li>\n" +
            "                                <li class=\"flex flex-column md:flex-row md:align-items-center md:justify-content-between mb-4\">\n" +
            "                                    <div class=\"flex\">\n" +
            "                                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-2.png\"\n" +
            "                                                        library=\"primeblocks-app\"\n" +
            "                                                        alt=\"Image\" style=\"width: 45px; height: 45px\"\n" +
            "                                                        styleClass=\"mr-3\"/>\n" +
            "                                        <div>\n" +
            "                                            <span class=\"block text-900 font-medium mb-1\">Theresa Webb Hudson</span>\n" +
            "                                            <div class=\"text-600\">UI/UX Designer</div>\n" +
            "                                        </div>\n" +
            "                                    </div>\n" +
            "                                    <div class=\"mt-2 md:mt-0 flex flex-nowrap\">\n" +
            "                                        <p:commandButton type=\"button\" icon=\"pi pi-twitter\"\n" +
            "                                                         styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                                        <p:commandButton type=\"button\" icon=\"pi pi-github\"\n" +
            "                                                         styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                                        <p:commandButton type=\"button\" icon=\"pi pi-facebook\"\n" +
            "                                                         styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                                    </div>\n" +
            "                                </li>\n" +
            "                                <li class=\"flex flex-column md:flex-row md:align-items-center md:justify-content-between mb-4\">\n" +
            "                                    <div class=\"flex\">\n" +
            "                                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-3.png\"\n" +
            "                                                        library=\"primeblocks-app\"\n" +
            "                                                        alt=\"Image\" style=\"width: 45px; height: 45px\"\n" +
            "                                                        styleClass=\"mr-3\"/>\n" +
            "                                        <div>\n" +
            "                                            <span class=\"block text-900 font-medium mb-1\">Arlene McCoy</span>\n" +
            "                                            <div class=\"text-600\">UI/UX Designer</div>\n" +
            "                                        </div>\n" +
            "                                    </div>\n" +
            "                                    <div class=\"mt-2 md:mt-0 flex flex-nowrap\">\n" +
            "                                        <p:commandButton type=\"button\" icon=\"pi pi-twitter\"\n" +
            "                                                         styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                                        <p:commandButton type=\"button\" icon=\"pi pi-github\"\n" +
            "                                                         styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                                        <p:commandButton type=\"button\" icon=\"pi pi-facebook\"\n" +
            "                                                         styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                                    </div>\n" +
            "                                </li>\n" +
            "                                <li class=\"flex flex-column md:flex-row md:align-items-center md:justify-content-between mb-4\">\n" +
            "                                    <div class=\"flex\">\n" +
            "                                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-m-1.png\"\n" +
            "                                                        library=\"primeblocks-app\"\n" +
            "                                                        alt=\"Image\" style=\"width: 45px; height: 45px\"\n" +
            "                                                        styleClass=\"mr-3\"/>\n" +
            "                                        <div>\n" +
            "                                            <span class=\"block text-900 font-medium mb-1\">Jacob Jones</span>\n" +
            "                                            <div class=\"text-600\">UI/UX Designer</div>\n" +
            "                                        </div>\n" +
            "                                    </div>\n" +
            "                                    <div class=\"mt-2 md:mt-0 flex flex-nowrap\">\n" +
            "                                        <p:commandButton type=\"button\" icon=\"pi pi-twitter\"\n" +
            "                                                         styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                                        <p:commandButton type=\"button\" icon=\"pi pi-github\"\n" +
            "                                                         styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                                        <p:commandButton type=\"button\" icon=\"pi pi-facebook\"\n" +
            "                                                         styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                                    </div>\n" +
            "                                </li>\n" +
            "                                <li class=\"flex flex-column md:flex-row md:align-items-center md:justify-content-between mb-4\">\n" +
            "                                    <div class=\"flex\">\n" +
            "                                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-m-2.png\"\n" +
            "                                                        library=\"primeblocks-app\"\n" +
            "                                                        alt=\"Image\" style=\"width: 45px; height: 45px\"\n" +
            "                                                        styleClass=\"mr-3\"/>\n" +
            "                                        <div>\n" +
            "                                            <span class=\"block text-900 font-medium mb-1\">James Cooper</span>\n" +
            "                                            <div class=\"text-600\">UI/UX Designer</div>\n" +
            "                                        </div>\n" +
            "                                    </div>\n" +
            "                                    <div class=\"mt-2 md:mt-0 flex flex-nowrap\">\n" +
            "                                        <p:commandButton type=\"button\" icon=\"pi pi-twitter\"\n" +
            "                                                         styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                                        <p:commandButton type=\"button\" icon=\"pi pi-github\"\n" +
            "                                                         styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                                        <p:commandButton type=\"button\" icon=\"pi pi-facebook\"\n" +
            "                                                         styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                                    </div>\n" +
            "                                </li>\n" +
            "                            </ul>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                    <div class=\"col-12\">\n" +
            "                        <div class=\"border-round p-4\">\n" +
            "                            <div class=\"text-xl text-900 font-medium mb-5\">Timeline</div>\n" +
            "                            <div class=\"mb-5 flex\">\n" +
            "                                <div class=\"flex flex-column align-items-center\" style=\"width:2rem\">\n" +
            "                                    <span class=\"bg-blue-500 text-0 flex align-items-center justify-content-center border-circle\"\n" +
            "                                          style=\"min-width:2.5rem; min-height: 2.5rem\">\n" +
            "                                        <i class=\"pi pi-image\"/>\n" +
            "                                    </span>\n" +
            "                                    <div class=\"h-full bg-blue-500\"\n" +
            "                                         style=\"width: 2px; min-height: 4rem\"></div>\n" +
            "                                </div>\n" +
            "                                <div class=\"ml-5 surface-card shadow-2 border-round p-3 flex-auto\">\n" +
            "                                    <div class=\"mb-3\">\n" +
            "                                        <span class=\"text-900 font-medium inline-block mr-3\">Jacob Jones</span>\n" +
            "                                        <span class=\"text-500 text-sm\">1 minute ago</span>\n" +
            "                                    </div>\n" +
            "                                    <div class=\"line-height-3 text-700 mb-3\">\n" +
            "                                        Eu tincidunt tortor aliquam nulla facilisi cras fermentum.\n" +
            "                                        Sollicitudin nibh sit amet commodo nulla. Mauris in aliquam sem fringilla ut morbi.\n" +
            "                                    </div>\n" +
            "                                    <div class=\"text-500 flex align-items-center\">\n" +
            "                                        <i class=\"pi pi-heart mr-1\"/>\n" +
            "                                        <span class=\"mr-3\">0</span>\n" +
            "\n" +
            "                                        <i class=\"pi pi-comment mr-1\"/>\n" +
            "                                        <span class=\"mr-3\">1</span>\n" +
            "\n" +
            "                                        <i class=\"pi pi-eye mr-1\"/>\n" +
            "                                        <span>24</span>\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                            <div class=\"mb-5 flex\">\n" +
            "                                <div class=\"flex flex-column align-items-center\" style=\"width:2rem\">\n" +
            "                                    <span class=\"bg-orange-500 text-0 flex align-items-center justify-content-center border-circle\"\n" +
            "                                          style=\"min-width:2.5rem; min-height: 2.5rem\">\n" +
            "                                        <i class=\"pi pi-image\"/>\n" +
            "                                    </span>\n" +
            "                                    <div class=\"h-full bg-orange-500\"\n" +
            "                                         style=\"width: 2px; min-height: 4rem\"></div>\n" +
            "                                </div>\n" +
            "                                <div class=\"ml-5 surface-card shadow-2 border-round p-3 flex-auto\">\n" +
            "                                    <div class=\"mb-3\">\n" +
            "                                        <span class=\"text-900 font-medium inline-block mr-3\">Theresa Webb</span>\n" +
            "                                        <span class=\"text-500 text-sm\">2 hours ago</span>\n" +
            "                                    </div>\n" +
            "                                    <div class=\"line-height-3 text-700 mb-3\">\n" +
            "                                        Purus sit amet volutpat consequat mauris. Pretium lectus quam id leo in vitae.\n" +
            "                                        Posuere sollicitudin aliquam ultrices sagittis orci a scelerisque purus semper.\n" +
            "                                    </div>\n" +
            "                                    <div class=\"text-500 flex align-items-center\">\n" +
            "                                        <i class=\"pi pi-heart mr-1\"/>\n" +
            "                                        <span class=\"mr-3\">26</span>\n" +
            "\n" +
            "                                        <i class=\"pi pi-comment mr-1\"/>\n" +
            "                                        <span class=\"mr-3\">6</span>\n" +
            "\n" +
            "                                        <i class=\"pi pi-eye mr-1\"/>\n" +
            "                                        <span>673</span>\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                            <div class=\"mb-5 flex\">\n" +
            "                                <div class=\"flex flex-column align-items-center\" style=\"width:2rem\">\n" +
            "                                    <span class=\"bg-purple-500 text-0 flex align-items-center justify-content-center border-circle\"\n" +
            "                                          style=\"min-width:2.5rem; min-height: 2.5rem\">\n" +
            "                                        <i class=\"pi pi-image\"/>\n" +
            "                                    </span>\n" +
            "                                    <div class=\"h-full bg-purple-500\"\n" +
            "                                         style=\"width: 2px; min-height: 4rem\"></div>\n" +
            "                                </div>\n" +
            "                                <div class=\"ml-5 surface-card shadow-2 border-round p-3 flex-auto\">\n" +
            "                                    <div class=\"mb-3\">\n" +
            "                                        <span class=\"text-900 font-medium inline-block mr-3\">Walter Black</span>\n" +
            "                                        <span class=\"text-500 text-sm\">4 hours ago</span>\n" +
            "                                    </div>\n" +
            "                                    <div class=\"line-height-3 text-700 mb-3\">\n" +
            "                                        Euismod in pellentesque massa placerat duis ultricies lacus.\n" +
            "                                        Vitae sapien pellentesque habitant morbi tristique senectus et netus et.\n" +
            "                                    </div>\n" +
            "                                    <div class=\"text-500 flex align-items-center\">\n" +
            "                                        <i class=\"pi pi-heart mr-1\"/>\n" +
            "                                        <span class=\"mr-3\">62</span>\n" +
            "\n" +
            "                                        <i class=\"pi pi-comment mr-1\"/>\n" +
            "                                        <span class=\"mr-3\">36</span>\n" +
            "\n" +
            "                                        <i class=\"pi pi-eye mr-1\"/>\n" +
            "                                        <span>21</span>\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;
    
    private final String block2 = "<div class=\"min-h-screen flex flex-column\">\n" +
            "    <div class=\"bg-indigo-500 py-3 px-5 flex align-items-center justify-content-between relative lg:static\"\n" +
            "         style=\"min-height: 80px\">\n" +
            "        <p:graphicImage name=\"images/blocks/logos/hyper-300.svg\" library=\"primeblocks-app\"\n" +
            "                        alt=\"Image\" height=\"40\" styleClass=\"mr-0 lg:mr-6\"/>\n" +
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
            "                                        library=\"primeblocks-app\"\n" +
            "                                        alt=\"Image\" styleClass=\"mr-3 lg:mr-0\"\n" +
            "                                        style=\"width: 32px; height: 32px\"/>\n" +
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
            "        <div class=\"grid\">\n" +
            "            <div class=\"col-12\">\n" +
            "                <div class=\"surface-card shadow-2 border-round flex p-3 flex-column md:flex-row\">\n" +
            "                    <div class=\"border-bottom-1 md:border-right-1 md:border-bottom-none surface-border flex-auto p-3\">\n" +
            "                        <div class=\"flex align-items-center mb-3\">\n" +
            "                            <i class=\"pi pi-shopping-cart text-blue-500 text-xl mr-2\"/>\n" +
            "                            <span class=\"text-500 font-medium\">Orders</span>\n" +
            "                        </div>\n" +
            "                        <span class=\"block text-900 font-medium mb-4 text-xl\">152 New</span>\n" +
            "                        <div class=\"flex align-items-center\">\n" +
            "                            <i class=\"pi pi-arrow-down text-pink-500 text-xl mr-2\"/>\n" +
            "                            <span class=\"text-pink-500 font-medium \">-25</span>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                    <div class=\"border-bottom-1 md:border-right-1 md:border-bottom-none surface-border flex-auto p-3\">\n" +
            "                        <div class=\"flex align-items-center mb-3\">\n" +
            "                            <i class=\"pi pi-shopping-cart text-orange-500 text-xl mr-2\"/>\n" +
            "                            <span class=\"text-500 font-medium\">Revenue</span>\n" +
            "                        </div>\n" +
            "                        <span class=\"block text-900 font-medium mb-4 text-xl\">$1500</span>\n" +
            "                        <div class=\"flex align-items-center\">\n" +
            "                            <i class=\"pi pi-arrow-up text-green-500 text-xl mr-2\"/>\n" +
            "                            <span class=\"text-green-500 font-medium \">+15</span>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                    <div class=\"border-bottom-1 md:border-right-1 md:border-bottom-none surface-border flex-auto p-3\">\n" +
            "                        <div class=\"flex align-items-center mb-3\">\n" +
            "                            <i class=\"pi pi-users text-cyan-500 text-xl mr-2\"/>\n" +
            "                            <span class=\"text-500 font-medium\">Customers</span>\n" +
            "                        </div>\n" +
            "                        <span class=\"block text-900 font-medium mb-4 text-xl\">25100</span>\n" +
            "                        <div class=\"flex align-items-center\">\n" +
            "                            <i class=\"pi pi-arrow-up text-green-500 text-xl mr-2\"/>\n" +
            "                            <span class=\"text-green-500 font-medium \">+%12</span>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                    <div class=\"flex-auto p-3\">\n" +
            "                        <div class=\"flex align-items-center mb-3\">\n" +
            "                            <i class=\"pi pi-users text-purple-500 text-xl mr-2\"/>\n" +
            "                            <span class=\"text-500 font-medium\">Comments</span>\n" +
            "                        </div>\n" +
            "                        <span class=\"block text-900 font-medium mb-4 text-xl\">72</span>\n" +
            "                        <div class=\"flex align-items-center\">\n" +
            "                            <i class=\"pi pi-arrow-up text-green-500 text-xl mr-2\"/>\n" +
            "                            <span class=\"text-green-500 font-medium \">+20</span>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"col-12 lg:col-6\">\n" +
            "                <div class=\"surface-card shadow-2 border-round p-4 h-full\">\n" +
            "                    <div class=\"flex align-items-center justify-content-between mb-3\">\n" +
            "                        <div class=\"text-900 font-medium text-xl\">Team Activity</div>\n" +
            "                        <div>\n" +
            "                            <p:commandButton id=\"dashboardButton2\" type=\"button\"\n" +
            "                                             icon=\"pi pi-ellipsis-v\"\n" +
            "                                             styleClass=\"ui-button-flat ui-button-plain rounded-button\"/>\n" +
            "                            <p:menu overlay=\"true\" trigger=\"dashboardButton2\" my=\"left top\"\n" +
            "                                    at=\"left bottom\">\n" +
            "                                <p:submenu label=\"Options\">\n" +
            "                                    <p:menuitem value=\"Add New\" icon=\"pi pi-fw pi-plus\"/>\n" +
            "                                    <p:menuitem value=\"Remove\" icon=\"pi pi-fw pi-minus\"/>\n" +
            "                                </p:submenu>\n" +
            "                            </p:menu>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                    <ul class=\"list-none p-0 m-0\">\n" +
            "                        <li class=\"py-3 border-bottom-1 surface-border flex md:align-items-start md:justify-content-between flex-column md:flex-row\">\n" +
            "                            <div class=\"flex align-items-start mr-0 lg:mr-5\">\n" +
            "                                <p:graphicImage name=\"images/blocks/avatars/circle-big/avatar-f-1.png\"\n" +
            "                                                library=\"primeblocks-app\"\n" +
            "                                                alt=\"Image\" styleClass=\"mr-3 w-3rem h-3rem\"/>\n" +
            "                                <div>\n" +
            "                                    <span class=\"text-900 font-medium block mb-2\">Jane Cooper</span>\n" +
            "                                    <div class=\"text-700 mb-2\">responded to an issue.</div>\n" +
            "                                    <a class=\"text-blue-500 cursor-pointer\">\n" +
            "                                        <i class=\"pi pi-github text-sm mr-2\"/>\n" +
            "                                        <span>Issue #1185</span>\n" +
            "                                    </a>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                            <span class=\"block text-500 font-medium ml-7 md:ml-5 mt-2 md:mt-0\">14 mins ago</span>\n" +
            "                        </li>\n" +
            "                        <li class=\"py-3 border-bottom-1 surface-border flex md:align-items-start md:justify-content-between flex-column md:flex-row\">\n" +
            "                            <div class=\"flex align-items-start mr-0 lg:mr-5\">\n" +
            "                                <p:graphicImage name=\"images/blocks/avatars/circle-big/avatar-m-1.png\"\n" +
            "                                                library=\"primeblocks-app\"\n" +
            "                                                alt=\"Image\" styleClass=\"mr-3 w-3rem h-3rem\"/>\n" +
            "                                <div>\n" +
            "                                    <span class=\"text-900 font-medium block mb-2\">Robert Fox</span>\n" +
            "                                    <div class=\"text-700\">changed team size from <span\n" +
            "                                            class=\"text-900\">5</span> to <span class=\"text-900\">6</span>.\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                            <span class=\"block text-500 font-medium ml-7 md:ml-5 mt-2 md:mt-0\">20 mins ago</span>\n" +
            "                        </li>\n" +
            "                        <li class=\"py-3 border-bottom-1 surface-border flex md:align-items-start md:justify-content-between flex-column md:flex-row\">\n" +
            "                            <div class=\"flex align-items-start mr-0 lg:mr-5\">\n" +
            "                                <p:graphicImage name=\"images/blocks/avatars/circle-big/avatar-f-2.png\"\n" +
            "                                                library=\"primeblocks-app\"\n" +
            "                                                alt=\"Image\" styleClass=\"mr-3 w-3rem h-3rem\"/>\n" +
            "                                <div>\n" +
            "                                    <span class=\"text-900 font-medium block mb-2\">Kristin Watson Cooper</span>\n" +
            "                                    <div class=\"text-700 mb-2\">created a Q4 presentation to an issue.</div>\n" +
            "                                    <a class=\"text-blue-500 cursor-pointer\">\n" +
            "                                        <i class=\"pi pi-file-pdf text-sm mr-2\"/>\n" +
            "                                        <span>q4_presentation.pdf</span>\n" +
            "                                    </a>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                            <span class=\"block text-500 font-medium ml-7 md:ml-5 mt-2 md:mt-0\">38 mins ago</span>\n" +
            "                        </li>\n" +
            "                        <li class=\"py-3 border-bottom-1 surface-border flex md:align-items-start md:justify-content-between flex-column md:flex-row\">\n" +
            "                            <div class=\"flex align-items-start mr-0 lg:mr-5\">\n" +
            "                                <p:graphicImage name=\"images/blocks/avatars/circle-big/avatar-f-3.png\"\n" +
            "                                                library=\"primeblocks-app\"\n" +
            "                                                alt=\"Image\" styleClass=\"mr-3 w-3rem h-3rem\"/>\n" +
            "                                <div>\n" +
            "                                    <span class=\"text-900 font-medium block mb-2\">Annette Black</span>\n" +
            "                                    <div class=\"text-700\">added <span\n" +
            "                                            class=\"text-900\">Nico Greenberg</span> to <span\n" +
            "                                            class=\"text-blue-500\">Watchlist Tier-1</span>.\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                            <span class=\"block text-500 font-medium ml-7 md:ml-5 mt-2 md:mt-0\">1 day ago</span>\n" +
            "                        </li>\n" +
            "                        <li class=\"py-3 flex md:align-items-start md:justify-content-between flex-column md:flex-row\">\n" +
            "                            <div class=\"flex align-items-start mr-0 lg:mr-5\">\n" +
            "                                <p:graphicImage name=\"images/blocks/avatars/circle-big/avatar-m-2.png\"\n" +
            "                                                library=\"primeblocks-app\"\n" +
            "                                                alt=\"Image\" styleClass=\"mr-3 w-3rem h-3rem\"/>\n" +
            "                                <div>\n" +
            "                                    <span class=\"text-900 font-medium block mb-2\">Floyd Miles</span>\n" +
            "                                    <div class=\"text-700\">has refunded a blue t-shirt for <span\n" +
            "                                            class=\"text-blue-500\">79$</span>.\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                            <span class=\"block text-500 font-medium ml-7 md:ml-5 mt-2 md:mt-0\">4 days ago</span>\n" +
            "                        </li>\n" +
            "                    </ul>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"col-12 lg:col-6\">\n" +
            "                <div class=\"surface-card shadow-2 border-round p-4 h-full\">\n" +
            "                    <div class=\"flex align-items-center justify-content-between mb-4\">\n" +
            "                        <div class=\"text-900 font-medium text-xl\">Notifications</div>\n" +
            "                        <div>\n" +
            "                            <p:commandButton id=\"dashboardButton3\" type=\"button\"\n" +
            "                                             icon=\"pi pi-ellipsis-v\"\n" +
            "                                             styleClass=\"ui-button-flat ui-button-plain rounded-button\"/>\n" +
            "                            <p:menu overlay=\"true\" trigger=\"dashboardButton3\" my=\"left top\"\n" +
            "                                    at=\"left bottom\">\n" +
            "                                <p:submenu label=\"Options\">\n" +
            "                                    <p:menuitem value=\"Add New\" icon=\"pi pi-fw pi-plus\"/>\n" +
            "                                    <p:menuitem value=\"Remove\" icon=\"pi pi-fw pi-minus\"/>\n" +
            "                                </p:submenu>\n" +
            "                            </p:menu>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "\n" +
            "                    <span class=\"block text-600 font-medium mb-3\">TODAY</span>\n" +
            "                    <ul class=\"p-0 mx-0 mt-0 mb-4 list-none\">\n" +
            "                        <li class=\"flex align-items-center py-2 border-bottom-1 surface-border\">\n" +
            "                            <div class=\"w-3rem h-3rem flex align-items-center justify-content-center bg-blue-100 border-circle mr-3 flex-shrink-0\">\n" +
            "                                <i class=\"pi pi-dollar text-xl text-blue-500\"/>\n" +
            "                            </div>\n" +
            "                            <span class=\"text-900 line-height-3\">Richard Jones\n" +
            "                                <span class=\"text-700\">has purchased a blue t-shirt for <span\n" +
            "                                        class=\"text-blue-500\">79$</span></span>\n" +
            "                            </span>\n" +
            "                        </li>\n" +
            "                        <li class=\"flex align-items-center py-2\">\n" +
            "                            <div class=\"w-3rem h-3rem flex align-items-center justify-content-center bg-orange-100 border-circle mr-3 flex-shrink-0\">\n" +
            "                                <i class=\"pi pi-download text-xl text-orange-500\"/>\n" +
            "                            </div>\n" +
            "                            <span class=\"text-700 line-height-3\">Your request for withdrawal of <span\n" +
            "                                    class=\"text-blue-500 font-medium\">2500$</span> has been initiated.</span>\n" +
            "                        </li>\n" +
            "                    </ul>\n" +
            "\n" +
            "                    <span class=\"block text-600 font-medium mb-3\">YESTERDAY</span>\n" +
            "                    <ul class=\"p-0 m-0 list-none\">\n" +
            "                        <li class=\"flex align-items-center py-2 border-bottom-1 surface-border\">\n" +
            "                            <div class=\"w-3rem h-3rem flex align-items-center justify-content-center bg-blue-100 border-circle mr-3 flex-shrink-0\">\n" +
            "                                <i class=\"pi pi-dollar text-xl text-blue-500\"/>\n" +
            "                            </div>\n" +
            "                            <span class=\"text-900 line-height-3\">Keyser Wick\n" +
            "                                <span class=\"text-700\">has purchased a black jacket for <span\n" +
            "                                        class=\"text-blue-500\">59$</span></span>\n" +
            "                            </span>\n" +
            "                        </li>\n" +
            "                        <li class=\"flex align-items-center py-2 border-bottom-1 surface-border\">\n" +
            "                            <div class=\"w-3rem h-3rem flex align-items-center justify-content-center bg-pink-100 border-circle mr-3 flex-shrink-0\">\n" +
            "                                <i class=\"pi pi-question text-xl text-pink-500\"/>\n" +
            "                            </div>\n" +
            "                            <span class=\"text-900 line-height-3\">Jane Davis\n" +
            "                                <span class=\"text-700\">has posted a new questions about your product.</span>\n" +
            "                            </span>\n" +
            "                        </li>\n" +
            "                        <li class=\"flex align-items-center py-2\">\n" +
            "                            <div class=\"w-3rem h-3rem flex align-items-center justify-content-center bg-green-100 border-circle mr-3 flex-shrink-0\">\n" +
            "                                <i class=\"pi pi-arrow-up text-xl text-green-500\"/>\n" +
            "                            </div>\n" +
            "                            <span class=\"text-900 line-height-3\">Claire Smith\n" +
            "                                <span class=\"text-700\">has upvoted your store along with a comment.</span>\n" +
            "                            </span>\n" +
            "                        </li>\n" +
            "                    </ul>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"col-12 lg:col-4\">\n" +
            "                <div class=\"surface-card border-round shadow-2 p-4 text-center\">\n" +
            "                    <p:graphicImage name=\"images/blocks/illustration/windows.svg\"\n" +
            "                                    library=\"primeblocks-app\"\n" +
            "                                    alt=\"Image\" styleClass=\"mx-auto block mb-4\"/>\n" +
            "                    <div class=\"text-900 font-medium mb-3 text-xl\">Title Placeholder</div>\n" +
            "                    <p class=\"mt-0 mb-4 p-0 line-height-3\">Nunc mi ipsum faucibus vitae aliquet nec. Lacus sed viverra tellus in hac habitasse platea dictumst.</p>\n" +
            "                    <p:commandButton type=\"button\" value=\"Learn More\" icon=\"pi pi-arrow-right\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"col-12 lg:col-4\">\n" +
            "                <div class=\"surface-card border-round shadow-2 p-4 text-center\">\n" +
            "                    <p:graphicImage name=\"images/blocks/illustration/security.svg\"\n" +
            "                                    library=\"primeblocks-app\"\n" +
            "                                    alt=\"Image\" styleClass=\"mx-auto block mb-4\"/>\n" +
            "                    <div class=\"text-900 font-medium mb-3 text-xl\">Title Placeholder</div>\n" +
            "                    <p class=\"mt-0 mb-4 p-0 line-height-3\">Nunc mi ipsum faucibus vitae aliquet nec. Lacus sed viverra tellus in hac habitasse platea dictumst.</p>\n" +
            "                    <p:commandButton type=\"button\" value=\"Learn More\" icon=\"pi pi-arrow-right\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"col-12 lg:col-4\">\n" +
            "                <div class=\"surface-card border-round shadow-2 p-4 text-center\">\n" +
            "                    <p:graphicImage name=\"images/blocks/illustration/live-collaboration.svg\"\n" +
            "                                    library=\"primeblocks-app\"\n" +
            "                                    alt=\"Image\" styleClass=\"mx-auto block mb-4\"/>\n" +
            "                    <div class=\"text-900 font-medium mb-3 text-xl\">Title Placeholder</div>\n" +
            "                    <p class=\"mt-0 mb-4 p-0 line-height-3\">Nunc mi ipsum faucibus vitae aliquet nec. Lacus sed viverra tellus in hac habitasse platea dictumst.</p>\n" +
            "                    <p:commandButton type=\"button\" value=\"Learn More\" icon=\"pi pi-arrow-right\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"col-12 lg:col-6\">\n" +
            "                <div class=\"surface-card shadow-2 border-round p-4\">\n" +
            "                    <div class=\"flex align-items-center justify-content-between mb-3\">\n" +
            "                        <div class=\"text-900 font-medium text-xl\">Sales</div>\n" +
            "                        <div>\n" +
            "                            <p:commandButton id=\"dashboardButton4\" type=\"button\"\n" +
            "                                             icon=\"pi pi-ellipsis-v\"\n" +
            "                                             styleClass=\"ui-button-flat ui-button-plain rounded-button\"/>\n" +
            "                            <p:menu overlay=\"true\" trigger=\"dashboardButton4\" my=\"left top\"\n" +
            "                                    at=\"left bottom\">\n" +
            "                                <p:submenu label=\"Options\">\n" +
            "                                    <p:menuitem value=\"Add New\" icon=\"pi pi-fw pi-plus\"/>\n" +
            "                                    <p:menuitem value=\"Remove\" icon=\"pi pi-fw pi-minus\"/>\n" +
            "                                </p:submenu>\n" +
            "                            </p:menu>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                    <p:graphicImage name=\"images/blocks/chart/chart-line.svg\" library=\"primeblocks-app\"\n" +
            "                                    alt=\"Image\" styleClass=\"w-full\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"col-12 lg:col-6\">\n" +
            "                <div class=\"surface-card shadow-2 border-round p-4\">\n" +
            "                    <div class=\"flex align-items-center justify-content-between mb-3\">\n" +
            "                        <div class=\"text-900 font-medium text-xl\">Customers</div>\n" +
            "                        <div>\n" +
            "                            <p:commandButton id=\"dashboardButton5\" type=\"button\"\n" +
            "                                             icon=\"pi pi-ellipsis-v\"\n" +
            "                                             styleClass=\"ui-button-flat ui-button-plain rounded-button\"/>\n" +
            "                            <p:menu overlay=\"true\" trigger=\"dashboardButton5\" my=\"left top\"\n" +
            "                                    at=\"left bottom\">\n" +
            "                                <p:submenu label=\"Options\">\n" +
            "                                    <p:menuitem value=\"Add New\" icon=\"pi pi-fw pi-plus\"/>\n" +
            "                                    <p:menuitem value=\"Remove\" icon=\"pi pi-fw pi-minus\"/>\n" +
            "                                </p:submenu>\n" +
            "                            </p:menu>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                    <p:graphicImage name=\"images/blocks/chart/chart-bar.svg\" library=\"primeblocks-app\"\n" +
            "                                    alt=\"Image\" styleClass=\"w-full\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block3 = "<div class=\"min-h-screen flex relative lg:static surface-ground\">\n" +
            "    <div id=\"app-sidebar-9\" class=\"h-full lg:h-auto surface-section hidden lg:block flex-shrink-0 absolute lg:static left-0 top-0 z-1 border-right-1 surface-border w-18rem lg:w-7rem select-none\">\n" +
            "        <div class=\"flex flex-column h-full\">\n" +
            "            <div class=\"flex align-items-center justify-content-center flex-shrink-0\" style=\"height:60px\">\n" +
            "                <p:graphicImage name=\"images/blocks/logos/hyper-cyan.svg\" library=\"primeblocks-app\" alt=\"Image\" height=\"30\"/>\n" +
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
            "                        <a class=\"flex flex-row lg:flex-column align-items-center cursor-pointer p-3 lg:justify-content-center text-600 border-left-2 border-transparent hover:border-300 transition-duration-150 transition-colors\"\n" +
            "                            data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', leaveToClass: 'hidden', hideOnOutsideClick: true }\" >\n" +
            "                            <p:badge severity=\"danger\">\n" +
            "                                <i class=\"pi pi-chart-line mr-2 lg:mr-0 mb-0 lg:mb-2 text-base lg:text-2xl\"/>\n" +
            "                            </p:badge>\n" +
            "                            <span class=\"font-medium inline text-base lg:text-xs lg:block\">Reports</span>\n" +
            "                            <i class=\"pi pi-chevron-down ml-auto lg:hidden\"></i>\n" +
            "                        </a>\n" +
            "                        <ul class=\"list-none pl-3 pr-0 py-0 lg:p-3 m-0 hidden overflow-y-hidden transition-all transition-duration-400 transition-ease-in-out static border-round-right lg:absolute left-100 top-0 z-1 surface-overlay shadow-none lg:shadow-2 w-full lg:w-15rem\">\n" +
            "                            <li>\n" +
            "                                <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 hover:text-900 border-round text-600 hover:text-700 transition-duration-150 transition-colors\"\n" +
            "                                    data-pb-styleclass=\"{ selector: '@next', toggleClass: 'hidden'}\" >\n" +
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
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\" styleClass=\"mr-2 lg:mr-0\" alt=\"Image\" style=\"width: 32px; height: 32px\"/>\n" +
            "                    <span class=\"font-medium inline lg:hidden\">Amy Elsner</span>\n" +
            "                </a>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"min-h-screen flex flex-column relative flex-auto\">\n" +
            "        <div class=\"flex justify-content-between align-items-center px-5 surface-section relative lg:static border-bottom-1 surface-border\" style=\"height:60px\">\n" +
            "            <div class=\"flex\">\n" +
            "                <a class=\"cursor-pointer block lg:hidden text-700 mr-3\" \n" +
            "                    data-pb-styleclass=\"{ selector: '#app-sidebar-9', enterClass: 'hidden', enterActiveClass: 'fadeinleft', leaveToClass: 'hidden', leaveActiveClass: 'fadeoutleft', hideOnOutsideClick: true }\">\n" +
            "                    <i class=\"pi pi-bars text-4xl\"></i>\n" +
            "                </a>\n" +
            "                <span class=\"ui-input-icon-left\">\n" +
            "                    <i class=\"pi pi-search\"></i>\n" +
            "                    <p:inputText type=\"search\" styleClass=\"border-none w-10rem sm:w-20rem\" placeholder=\"Search\"/>\n" +
            "                </span>\n" +
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
            "                        <p:badge severity=\"danger\">\n" +
            "                            <i class=\"pi pi-bell text-base lg:text-2xl mr-2 lg:mr-0\"/>\n" +
            "                        </p:badge>\n" +
            "                        <span class=\"block lg:hidden font-medium\">Notifications</span>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "                <li class=\"border-top-1 surface-border lg:border-top-none\">\n" +
            "                    <a class=\"flex p-3 lg:px-3 lg:py-2 align-items-center hover:surface-100 font-medium border-round cursor-pointer\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\" styleClass=\"mr-3 lg:mr-0\" alt=\"Image\" style=\"width: 32px; height: 32px\"/>\n" +
            "                        <div class=\"block lg:hidden\">\n" +
            "                            <div class=\"text-900 font-medium\">Amy Elsner</div>\n" +
            "                            <span class=\"text-600 font-medium text-sm\">Marketing Specialist</span>\n" +
            "                        </div>\n" +
            "                    </a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "        <div class=\"p-5 flex flex-column flex-auto\">\n" +
            "            <div class=\"grid\">\n" +
            "                <div class=\"col-12\">\n" +
            "                    <div class=\"grid\">\n" +
            "                        <div class=\"col-12 md:col-6 lg:col-3 p-3\">\n" +
            "                            <div class=\"p-3 text-center bg-blue-500\" style=\"border-radius: 12px\">\n" +
            "                                <span class=\"inline-flex justify-content-center align-items-center bg-blue-600 border-circle mb-3\" style=\"width:49px; height: 49px\">\n" +
            "                                    <i class=\"pi pi-inbox text-xl text-white\"></i>\n" +
            "                                </span>\n" +
            "                                <div class=\"text-2xl font-medium text-white mb-2\">123K</div>\n" +
            "                                <span class=\"text-blue-100 font-medium\">Messages</span>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "                        <div class=\"col-12 md:col-6 lg:col-3 p-3\">\n" +
            "                            <div class=\"p-3 text-center bg-purple-500\" style=\"border-radius: 12px\">\n" +
            "                                <span class=\"inline-flex justify-content-center align-items-center bg-purple-600 border-circle mb-3\" style=\"width:49px; height: 49px\">\n" +
            "                                    <i class=\"pi pi-map-marker text-xl text-white\"></i>\n" +
            "                                </span>\n" +
            "                                <div class=\"text-2xl font-medium text-white mb-2\">23K</div>\n" +
            "                                <span class=\"text-purple-100 font-medium\">Check-ins</span>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "                        <div class=\"col-12 md:col-6 lg:col-3 p-3\">\n" +
            "                            <div class=\"p-3 text-center bg-indigo-500\" style=\"border-radius: 12px\">\n" +
            "                                <span class=\"inline-flex justify-content-center align-items-center bg-indigo-600 border-circle mb-3\" style=\"width:49px; height: 49px\">\n" +
            "                                    <i class=\"pi pi-file text-xl text-white\"></i>\n" +
            "                                </span>\n" +
            "                                <div class=\"text-2xl font-medium text-white mb-2\">23K</div>\n" +
            "                                <span class=\"text-indigo-100 font-medium\">Files</span>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "                        <div class=\"col-12 md:col-6 lg:col-3 p-3\">\n" +
            "                            <div class=\"p-3 text-center bg-orange-500\" style=\"border-radius: 12px\">\n" +
            "                                <span class=\"inline-flex justify-content-center align-items-center bg-orange-600 border-circle mb-3\" style=\"width:49px; height: 49px\">\n" +
            "                                    <i class=\"pi pi-users text-xl text-white\"></i>\n" +
            "                                </span>\n" +
            "                                <div class=\"text-2xl font-medium text-white mb-2\">40K</div>\n" +
            "                                <span class=\"text-orange-100 font-medium\">Users</span>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"col-12 lg:col-6\">\n" +
            "                    <div class=\"shadow-2 surface-card border-round p-3\">\n" +
            "                        <div class=\"flex align-items-center justify-content-between\">\n" +
            "                            <span class=\"text-xl font-medium text-900\">Traffic Distribution</span>\n" +
            "                        </div>\n" +
            "                        <div class=\"mt-3\">\n" +
            "                            <div class=\"grid\">\n" +
            "                                <div class=\"col-12 md:col-6\">\n" +
            "                                    <div class=\"text-center border-1 surface-border border-round p-4\">\n" +
            "                                        <i class=\"pi pi-twitter text-5xl text-blue-500\"></i>\n" +
            "                                        <div class=\"text-900 text-2xl font-700 my-3 font-bold\">12.40K</div>\n" +
            "                                        <span class=\"font-medium text-600\">Twitter</span>\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                                <div class=\"col-12 md:col-6 text-center\">\n" +
            "                                    <div class=\"text-center border-1 surface-border border-round p-4\">\n" +
            "                                        <i class=\"pi pi-vimeo text-5xl text-blue-500\"></i>\n" +
            "                                        <div class=\"text-900 text-2xl font-700 my-3 font-bold\">10.20K</div>\n" +
            "                                        <span class=\"font-medium text-600\">Vimeo</span>\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                                <div class=\"col-12 md:col-6 text-center\">\n" +
            "                                    <div class=\"text-center border-1 surface-border border-round p-4\">\n" +
            "                                        <i class=\"pi pi-facebook text-5xl text-blue-500\"></i>\n" +
            "                                        <div class=\"text-900 text-2xl font-700 my-3 font-bold\">5.60K</div>\n" +
            "                                        <span class=\"font-medium text-600\">Facebook</span>\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                                <div class=\"col-12 md:col-6 text-center\">\n" +
            "                                    <div class=\"text-center border-1 surface-border border-round p-4\">\n" +
            "                                        <i class=\"pi pi-discord text-5xl text-indigo-500\"></i>\n" +
            "                                        <div class=\"text-900 text-2xl font-700 my-3 font-bold\">23.53K</div>\n" +
            "                                        <span class=\"font-medium text-600\">Discord</span>\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                                <div class=\"col-12 md:col-6 text-center\">\n" +
            "                                    <div class=\"text-center border-1 surface-border border-round p-4\">\n" +
            "                                        <i class=\"pi pi-github text-5xl text-purple-500\"></i>\n" +
            "                                        <div class=\"text-900 text-2xl font-700 my-3 font-bold\">16.70K</div>\n" +
            "                                        <span class=\"font-medium text-600\">GitHub</span>\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                                <div class=\"col-12 md:col-6 text-center\">\n" +
            "                                    <div class=\"text-center border-1 surface-border border-round p-4\">\n" +
            "                                        <i class=\"pi pi-google text-5xl text-pink-500\"></i>\n" +
            "                                        <div class=\"text-900 text-2xl font-700 my-3 font-bold\">16.50K</div>\n" +
            "                                        <span class=\"font-medium text-600\">Google</span>\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"col-12 lg:col-6\">\n" +
            "                    <div class=\"surface-card shadow-2 border-round p-4\">\n" +
            "                        <div class=\"flex align-items-center justify-content-between mb-4\">\n" +
            "                            <span class=\"text-xl font-medium text-900\">Quarter Goals</span>\n" +
            "                        </div>\n" +
            "                        <div class=\"surface-border border-1 border-round p-3 mb-4\">\n" +
            "                            <span class=\"text-900 font-medium text-3xl\">85% <span class=\"text-600\">(2125/2500)</span></span>\n" +
            "                            <ul class=\"mt-3 list-none p-0 mx-0 flex\">\n" +
            "                                <li style=\"height:1rem\" class=\"flex-1 bg-indigo-500 border-round-left\"></li>\n" +
            "                                <li style=\"height:1rem\" class=\"flex-1 bg-blue-500\"></li>\n" +
            "                                <li style=\"height:1rem\" class=\"flex-1 bg-orange-500\"></li>\n" +
            "                                <li style=\"height:1rem\" class=\"flex-1 bg-purple-500\"></li>\n" +
            "                                <li style=\"height:1rem\" class=\"flex-1 bg-yellow-500\"></li>\n" +
            "                                <li style=\"height:1rem\" class=\"flex-1 bg-cyan-500\"></li>\n" +
            "                                <li style=\"height:1rem\" class=\"flex-1 surface-500 border-round-right\"></li>\n" +
            "                            </ul>\n" +
            "                        </div>\n" +
            "                        <ul class=\"mt-4 list-none p-0 mx-0\">\n" +
            "                            <li class=\"flex align-items-center pb-3\">\n" +
            "                                <span style=\"width:1rem;height:1rem\" class=\"border-round bg-indigo-500 mr-3 flex-shrink-0\"></span>\n" +
            "                                <span class=\"text-xl font-medium text-90\">Watch</span>\n" +
            "                                <span class=\"text-600 text-xl font-medium ml-auto\">152</span>\n" +
            "                            </li>\n" +
            "                            <li class=\"flex align-items-center py-3\">\n" +
            "                                <span style=\"width:1rem;height:1rem\" class=\"border-round bg-blue-500 mr-3 flex-shrink-0\"></span>\n" +
            "                                <span class=\"text-xl font-medium text-90\">Blue Band</span>\n" +
            "                                <span class=\"text-600 text-xl font-medium ml-auto\">63</span>\n" +
            "                            </li>\n" +
            "                            <li class=\"flex align-items-center py-3\">\n" +
            "                                <span style=\"width:1rem;height:1rem\" class=\"border-round bg-orange-500 mr-3 flex-shrink-0\"></span>\n" +
            "                                <span class=\"text-xl font-medium text-90\">Controller</span>\n" +
            "                                <span class=\"text-600 text-xl font-medium ml-auto\">23</span>\n" +
            "                            </li>\n" +
            "                            <li class=\"flex align-items-center py-3\">\n" +
            "                                <span style=\"width:1rem;height:1rem\" class=\"border-round bg-purple-500 mr-3 flex-shrink-0\"></span>\n" +
            "                                <span class=\"text-xl font-medium text-90\">Lime Band</span>\n" +
            "                                <span class=\"text-600 text-xl font-medium ml-auto\">42</span>\n" +
            "                            </li>\n" +
            "                            <li class=\"flex align-items-center py-3\">\n" +
            "                                <span style=\"width:1rem;height:1rem\" class=\"border-round bg-yellow-500 mr-3 flex-shrink-0\"></span>\n" +
            "                                <span class=\"text-xl font-medium text-90\">Phone Case</span>\n" +
            "                                <span class=\"text-600 text-xl font-medium ml-auto\">134</span>\n" +
            "                            </li>\n" +
            "                            <li class=\"flex align-items-center py-3\">\n" +
            "                                <span style=\"width:1rem;height:1rem\" class=\"border-round bg-cyan-500 mr-3 flex-shrink-0\"></span>\n" +
            "                                <span class=\"text-xl font-medium text-90\">T-Shirt</span>\n" +
            "                                <span class=\"text-600 text-xl font-medium ml-auto\">89</span>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"col-12\">\n" +
            "                    <div class=\"surface-ground\">\n" +
            "                        <div class=\"grid\">\n" +
            "                            <div class=\"col-12 lg:col-4 p-2\">\n" +
            "                                <div class=\"shadow-2 surface-card border-round p-4 h-full\">\n" +
            "                                    <div class=\"flex align-items-start mb-5\">\n" +
            "                                        <p:graphicImage name=\"images/blocks/avatars/circle-big/avatar-m-1.png\" library=\"primeblocks-app\" width=\"56\" height=\"56\"/>\n" +
            "                                        <div class=\"ml-3\">\n" +
            "                                            <span class=\"block text-900 mb-1 text-xl font-medium\">Cameron Williamson</span>\n" +
            "                                            <p class=\"text-600 mt-0 mb-0\">Marketing Coordinator</p>\n" +
            "                                        </div>\n" +
            "                                    </div>\n" +
            "                                    <ul class=\"list-none p-0 m-0\">\n" +
            "                                        <li class=\"mb-5\">\n" +
            "                                            <div class=\"flex justify-content-between align-items-center\">\n" +
            "                                                <span class=\"text-900 inline-flex justify-content-between align-items-center\">\n" +
            "                                                    <i class=\"pi pi-twitter mr-2\"></i>\n" +
            "                                                    <span class=\"font-medium text-900\">Twitter</span>\n" +
            "                                                </span>\n" +
            "                                                <span class=\"text-cyan-500 font-medium\">34.00%</span>\n" +
            "                                            </div>\n" +
            "                                            <div class=\"surface-300 w-full mt-2\" style=\"height: 7px; border-radius: 4px\">\n" +
            "                                                <div class=\"bg-cyan-500 h-full\" style=\"width:34%; border-radius: 4px\"></div>\n" +
            "                                            </div>\n" +
            "                                        </li>\n" +
            "                                        <li class=\"mb-5\">\n" +
            "                                            <div class=\"flex justify-content-between align-items-center\">\n" +
            "                                                <span class=\"text-900 inline-flex justify-content-between align-items-center\">\n" +
            "                                                    <i class=\"pi pi-facebook mr-2\"></i>\n" +
            "                                                    <span class=\"font-medium text-900\">Facebook</span>\n" +
            "                                                </span>\n" +
            "                                                <span class=\"text-indigo-500 font-medium\">45.86%</span>\n" +
            "                                            </div>\n" +
            "                                            <div class=\"surface-300 w-full mt-2\" style=\"height: 7px; border-radius: 4px\">\n" +
            "                                                <div class=\"bg-indigo-500 h-full\" style=\"width:45%; border-radius: 4px\"></div>\n" +
            "                                            </div>\n" +
            "                                        </li>\n" +
            "                                        <li>\n" +
            "                                            <div class=\"flex justify-content-between align-items-center\">\n" +
            "                                                <span class=\"text-900 inline-flex justify-content-between align-items-center\">\n" +
            "                                                    <i class=\"pi pi-google mr-2\"></i>\n" +
            "                                                    <span class=\"font-medium text-900\">Google</span>\n" +
            "                                                </span>\n" +
            "                                                <span class=\"text-orange-500 font-medium\">79.00%</span>\n" +
            "                                            </div>\n" +
            "                                            <div class=\"surface-300 w-full mt-2\" style=\"height: 7px; border-radius: 4px\">\n" +
            "                                                <div class=\"bg-orange-500 h-full\" style=\"width:79%; border-radius: 4px\"></div>\n" +
            "                                            </div>\n" +
            "                                        </li>\n" +
            "                                    </ul>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                            <div class=\"col-12 lg:col-4 p-2\">\n" +
            "                                <div class=\"shadow-2 surface-card border-round p-4 h-full\">\n" +
            "                                    <div class=\"flex align-items-start mb-5\">\n" +
            "                                        <p:graphicImage name=\"images/blocks/avatars/circle-big/avatar-f-2.png\" library=\"primeblocks-app\" width=\"56\" height=\"56\"/>\n" +
            "                                        <div class=\"ml-3\">\n" +
            "                                            <span class=\"block text-900 mb-1 text-xl font-medium\">Kathryn Murphy</span>\n" +
            "                                            <p class=\"text-600 mt-0 mb-0\">Sales Manager</p>\n" +
            "                                        </div>\n" +
            "                                    </div>\n" +
            "                                    <ul class=\"list-none p-0 m-0\">\n" +
            "                                        <li class=\"mb-5\">\n" +
            "                                            <div class=\"flex justify-content-between align-items-center\">\n" +
            "                                                <span class=\"text-900 inline-flex justify-content-between align-items-center\">\n" +
            "                                                    <i class=\"pi pi-twitter mr-2\"></i>\n" +
            "                                                    <span class=\"font-medium text-900\">Twitter</span>\n" +
            "                                                </span>\n" +
            "                                                <span class=\"text-cyan-500 font-medium\">64.47%</span>\n" +
            "                                            </div>\n" +
            "                                            <div class=\"surface-300 w-full mt-2\" style=\"height: 7px; border-radius: 4px\">\n" +
            "                                                <div class=\"bg-cyan-500 h-full\" style=\"width:64%; border-radius: 4px\"></div>\n" +
            "                                            </div>\n" +
            "                                        </li>\n" +
            "                                        <li class=\"mb-5\">\n" +
            "                                            <div class=\"flex justify-content-between align-items-center\">\n" +
            "                                                <span class=\"text-900 inline-flex justify-content-between align-items-center\">\n" +
            "                                                    <i class=\"pi pi-facebook mr-2\"></i>\n" +
            "                                                    <span class=\"font-medium text-900\">Facebook</span>\n" +
            "                                                </span>\n" +
            "                                                <span class=\"text-indigo-500 font-medium\">75.67%</span>\n" +
            "                                            </div>\n" +
            "                                            <div class=\"surface-300 w-full mt-2\" style=\"height: 7px; border-radius: 4px\">\n" +
            "                                                <div class=\"bg-indigo-500 h-full\" style=\"width:75%; border-radius: 4px\"></div>\n" +
            "                                            </div>\n" +
            "                                        </li>\n" +
            "                                        <li>\n" +
            "                                            <div class=\"flex justify-content-between align-items-center\">\n" +
            "                                                <span class=\"text-900 inline-flex justify-content-between align-items-center\">\n" +
            "                                                    <i class=\"pi pi-google mr-2\"></i>\n" +
            "                                                    <span class=\"font-medium text-900\">Google</span>\n" +
            "                                                </span>\n" +
            "                                                <span class=\"text-orange-500 font-medium\">45.00%</span>\n" +
            "                                            </div>\n" +
            "                                            <div class=\"surface-300 w-full mt-2\" style=\"height: 7px; border-radius: 4px\">\n" +
            "                                                <div class=\"bg-orange-500 h-full\" style=\"width:45%; border-radius: 4px\"></div>\n" +
            "                                            </div>\n" +
            "                                        </li>\n" +
            "                                    </ul>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                            <div class=\"col-12 lg:col-4 p-2\">\n" +
            "                                <div class=\"shadow-2 surface-card border-round p-4 h-full\">\n" +
            "                                    <div class=\"flex align-items-start mb-5\">\n" +
            "                                        <p:graphicImage name=\"images/blocks/avatars/circle-big/avatar-m-3.png\" library=\"primeblocks-app\" width=\"56\" height=\"56\"/>\n" +
            "                                        <div class=\"ml-3\">\n" +
            "                                            <span class=\"block text-900 mb-1 text-xl font-medium\">Darrell Steward</span>\n" +
            "                                            <p class=\"text-600 mt-0 mb-0\">Web Designer</p>\n" +
            "                                        </div>\n" +
            "                                    </div>\n" +
            "                                    <ul class=\"list-none p-0 m-0\">\n" +
            "                                        <li class=\"mb-5\">\n" +
            "                                            <div class=\"flex justify-content-between align-items-center\">\n" +
            "                                                <span class=\"text-900 inline-flex justify-content-between align-items-center\">\n" +
            "                                                    <i class=\"pi pi-twitter mr-2\"></i>\n" +
            "                                                    <span class=\"font-medium text-900\">Twitter</span>\n" +
            "                                                </span>\n" +
            "                                                <span class=\"text-cyan-500 font-medium\">23.55%</span>\n" +
            "                                            </div>\n" +
            "                                            <div class=\"surface-300 w-full mt-2\" style=\"height: 7px; border-radius: 4px\">\n" +
            "                                                <div class=\"bg-cyan-500 h-full\" style=\"width:34%; border-radius: 4px\"></div>\n" +
            "                                            </div>\n" +
            "                                        </li>\n" +
            "                                        <li class=\"mb-5\">\n" +
            "                                            <div class=\"flex justify-content-between align-items-center\">\n" +
            "                                                <span class=\"text-900 inline-flex justify-content-between align-items-center\">\n" +
            "                                                    <i class=\"pi pi-facebook mr-2\"></i>\n" +
            "                                                    <span class=\"font-medium text-900\">Facebook</span>\n" +
            "                                                </span>\n" +
            "                                                <span class=\"text-indigo-500 font-medium\">78.65%</span>\n" +
            "                                            </div>\n" +
            "                                            <div class=\"surface-300 w-full mt-2\" style=\"height: 7px; border-radius: 4px\">\n" +
            "                                                <div class=\"bg-indigo-500 h-full\" style=\"width:45%; border-radius: 4px\"></div>\n" +
            "                                            </div>\n" +
            "                                        </li>\n" +
            "                                        <li>\n" +
            "                                            <div class=\"flex justify-content-between align-items-center\">\n" +
            "                                                <span class=\"text-900 inline-flex justify-content-between align-items-center\">\n" +
            "                                                    <i class=\"pi pi-google mr-2\"></i>\n" +
            "                                                    <span class=\"font-medium text-900\">Google</span>\n" +
            "                                                </span>\n" +
            "                                                <span class=\"text-orange-500 font-medium\">86.54%</span>\n" +
            "                                            </div>\n" +
            "                                            <div class=\"surface-300 w-full mt-2\" style=\"height: 7px; border-radius: 4px\">\n" +
            "                                                <div class=\"bg-orange-500 h-full\" style=\"width:79%; border-radius: 4px\"></div>\n" +
            "                                            </div>\n" +
            "                                        </li>\n" +
            "                                    </ul>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
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
}
