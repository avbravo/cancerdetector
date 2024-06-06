package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class SettingScreenView implements Serializable {

    private final String block1 = "<div class=\"min-h-screen flex relative lg:static surface-ground\">\n" +
            "    <div id=\"app-sidebar\"\n" +
            "         class=\"h-full lg:h-auto hidden lg:block flex-shrink-0 absolute lg:static left-0 top-0 z-1 border-right-1 surface-border w-full md:w-auto\">\n" +
            "        <div class=\"flex h-full\">\n" +
            "            <div class=\"flex flex-column h-full bg-indigo-500 flex-shrink-0 select-none\">\n" +
            "                <div class=\"flex align-items-center justify-content-center flex-shrink-0 bg-indigo-600\"\n" +
            "                     style=\"height:60px\">\n" +
            "                    <p:graphicImage name=\"images/blocks/logos/hyper-light.svg\" library=\"primeblocks-app\"\n" +
            "                                    alt=\"Image\" height=\"30\"/>\n" +
            "                </div>\n" +
            "                <div class=\"overflow-y-auto mt-3\">\n" +
            "                    <ul class=\"list-none py-3 px-2 m-0\" data-pb-tablist=\"setting\">\n" +
            "                        <li class=\"mb-2\">\n" +
            "                            <a class=\"flex align-items-center cursor-pointer p-3 lg:justify-content-center hover:bg-indigo-400 border-round text-indigo-100 hover:text-indigo-50 transition-duration-150 transition-colors bg-indigo-700\"\n" +
            "                               data-pb-tab=\"{toggleClass: 'bg-indigo-700', selector: '#tab1', selectorToggleClass: 'hidden'}\">\n" +
            "                                <i class=\"pi pi-home text-lg\"/>\n" +
            "                            </a>\n" +
            "                        </li>\n" +
            "                        <li class=\"mb-2\">\n" +
            "                            <a class=\"flex align-items-center cursor-pointer p-3 lg:justify-content-center hover:bg-indigo-400 border-round text-indigo-100 hover:text-indigo-50 transition-duration-150 transition-colors\"\n" +
            "                               data-pb-tab=\"{toggleClass: 'bg-indigo-700', selector: '#tab2', selectorToggleClass: 'hidden'}\">\n" +
            "                                <i class=\"pi pi-bookmark text-lg\"/>\n" +
            "                            </a>\n" +
            "                        </li>\n" +
            "                        <li class=\"mb-2\">\n" +
            "                            <a class=\"flex align-items-center cursor-pointer p-3 lg:justify-content-center hover:bg-indigo-400 border-round text-indigo-100 hover:text-indigo-50 transition-duration-150 transition-colors\"\n" +
            "                               data-pb-tab=\"{toggleClass: 'bg-indigo-700', selector: '#tab3', selectorToggleClass: 'hidden'}\">\n" +
            "                                <i class=\"pi pi-users text-lg\"/>\n" +
            "                            </a>\n" +
            "                        </li>\n" +
            "                        <li class=\"mb-2\">\n" +
            "                            <a class=\"flex align-items-center cursor-pointer p-3 lg:justify-content-center hover:bg-indigo-400 border-round text-indigo-100 hover:text-indigo-50 transition-duration-150 transition-colors\"\n" +
            "                               data-pb-tab=\"{toggleClass: 'bg-indigo-700', selector: '#tab4', selectorToggleClass: 'hidden'}\">\n" +
            "                                <i class=\"pi pi-comments text-lg\"/>\n" +
            "                            </a>\n" +
            "                        </li>\n" +
            "                        <li class=\"mb-2\">\n" +
            "                            <a class=\"flex align-items-center cursor-pointer p-3 lg:justify-content-center hover:bg-indigo-400 border-round text-indigo-100 hover:text-indigo-50 transition-duration-150 transition-colors\"\n" +
            "                               data-pb-tab=\"{toggleClass: 'bg-indigo-700', selector: '#tab5', selectorToggleClass: 'hidden'}\">\n" +
            "                                <i class=\"pi pi-calendar text-lg\"/>\n" +
            "                            </a>\n" +
            "                        </li>\n" +
            "                        <li class=\"mb-2\">\n" +
            "                            <a class=\"flex align-items-center cursor-pointer p-3 lg:justify-content-center hover:bg-indigo-400 border-round text-indigo-100 hover:text-indigo-50 transition-duration-150 transition-colors\"\n" +
            "                               data-pb-tab=\"{toggleClass: 'bg-indigo-700', selector: '#tab6', selectorToggleClass: 'hidden'}\">\n" +
            "                                <i class=\"pi pi-cog text-lg\"/>\n" +
            "                            </a>\n" +
            "                        </li>\n" +
            "                    </ul>\n" +
            "                </div>\n" +
            "                <div class=\"mt-auto\">\n" +
            "                    <hr class=\"mb-3 mx-3 border-top-1 border-bottom-none border-indigo-300\"/>\n" +
            "                    <a class=\"m-3 flex align-items-center cursor-pointer py-1 px-0 justify-content-center hover:bg-indigo-400 border-round text-300 hover:text-0\n" +
            "                        transition-duration-150 transition-colors\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\"\n" +
            "                                        library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                        style=\"width: 24px; height: 24px\"/>\n" +
            "                    </a>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"flex flex-column surface-0 p-4 overflow-y-auto flex-shrink-0 flex-grow-1 md:flex-grow-0\"\n" +
            "                 style=\"width:250px\">\n" +
            "                <div class=\"justify-content-end mb-3 flex lg:hidden\">\n" +
            "                    <p:commandButton type=\"button\" icon=\"pi pi-times\"\n" +
            "                                     styleClass=\"rounded-button ui-button-flat ui-button-plain\"\n" +
            "                                     pt:data-pb-styleclass=\"{ selector: '#app-sidebar', leaveToClass: 'hidden', leaveActiveClass: 'fadeoutleft' }\"/>\n" +
            "                </div>\n" +
            "                <div class=\"surface-0 flex-auto\">\n" +
            "                    <div id=\"tab1\">\n" +
            "                        <div class=\"w-full lg:w-auto select-none\">\n" +
            "                            <ul class=\"list-none py-2 px-0 m-0\">\n" +
            "                                <li>\n" +
            "                                    <div class=\"p-3 text-500 font-medium\">HOME</div>\n" +
            "                                </li>\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                                        <i class=\"pi pi-home mr-2 text-700\"/>\n" +
            "                                        <span class=\"font-medium text-700\">Dashboard</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                                        <i class=\"pi pi-bookmark mr-2 text-700\"/>\n" +
            "                                        <span class=\"font-medium text-700\">Bookmarks</span>\n" +
            "                                        <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-blue-100 text-blue-900 border-circle\"\n" +
            "                                              style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                                        <i class=\"pi pi-users mr-2 text-700\"/>\n" +
            "                                        <span class=\"font-medium text-700\">Team</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                                        <i class=\"pi pi-comments mr-2 text-700\"/>\n" +
            "                                        <span class=\"font-medium text-700\">Messages</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                                        <i class=\"pi pi-calendar mr-2 text-700\"/>\n" +
            "                                        <span class=\"font-medium text-700\">Calendar</span>\n" +
            "                                        <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-purple-100 text-purple-900 border-circle\"\n" +
            "                                              style=\"min-width: 1.5rem; height: 1.5rem\">2</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                                        <i class=\"pi pi-user mr-2 text-blue-500\"/>\n" +
            "                                        <span class=\"font-medium text-blue-500 font-bold\">Profile</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                            </ul>\n" +
            "                            <ul class=\"list-none py-2 px-0 m-0 border-top-1 surface-border\">\n" +
            "                                <li>\n" +
            "                                    <div class=\"p-3 text-500 font-medium\">ORGANIZATION</div>\n" +
            "                                </li>\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                                        <i class=\"pi pi-home mr-2 text-700\"/>\n" +
            "                                        <span class=\"font-medium text-700\">Overview</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                                        <i class=\"pi pi-bookmark mr-2 text-700\"/>\n" +
            "                                        <span class=\"font-medium text-700\">Security</span>\n" +
            "                                        <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-cyan-100 text-cyan-900 border-circle\"\n" +
            "                                              style=\"min-width: 1.5rem; height: 1.5rem\">3</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                                        <i class=\"pi pi-users mr-2 text-700\"/>\n" +
            "                                        <span class=\"font-medium text-700\">Domains</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                                <li>\n" +
            "                                    <a class=\"flex align-items-center cursor-pointer p-3 hover:surface-100 border-round transition-colors transition-duration-150\">\n" +
            "                                        <i class=\"pi pi-calendar mr-2 text-700\"/>\n" +
            "                                        <span class=\"font-medium text-700\">Reports</span>\n" +
            "                                        <span class=\"inline-flex align-items-center justify-content-center ml-auto bg-orange-100 text-orange-900 border-circle\"\n" +
            "                                              style=\"min-width: 1.5rem; height: 1.5rem\">2</span>\n" +
            "                                    </a>\n" +
            "                                </li>\n" +
            "                            </ul>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                    <div id=\"tab2\" class=\"p-3 font-medium text-xl text-900 hidden\">Bookmarks\n" +
            "                    </div>\n" +
            "                    <div id=\"tab3\" class=\"p-3 font-medium text-xl text-900 hidden\">Team\n" +
            "                    </div>\n" +
            "                    <div id=\"tab4\" class=\"p-3 font-medium text-xl text-900 hidden\">Messages\n" +
            "                    </div>\n" +
            "                    <div id=\"tab5\" class=\"p-3 font-medium text-xl text-900 hidden\">Calendar\n" +
            "                    </div>\n" +
            "                    <div id=\"tab6\" class=\"p-3 font-medium text-xl text-900 hidden\">Settings\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"min-h-screen flex flex-column relative flex-auto\">\n" +
            "        <div class=\"flex justify-content-between align-items-center px-5 surface-section border-bottom-1 surface-border relative lg:static\"\n" +
            "             style=\"height:60px\">\n" +
            "            <div class=\"flex\">\n" +
            "                <a class=\"cursor-pointer block lg:hidden text-700 mr-3\"\n" +
            "                   data-pb-styleclass=\"{ selector: '#app-sidebar', enterClass: 'hidden', enterActiveClass: 'fadeinleft', leaveToClass: 'hidden', leaveActiveClass: 'fadeoutleft' }\">\n" +
            "                    <i class=\"pi pi-bars text-4xl\"/>\n" +
            "                </a>\n" +
            "                <span class=\"p-input-icon-left\">\n" +
            "                    <i class=\"pi pi-search\"/>\n" +
            "                    <p:inputText type=\"search\" styleClass=\"border-none\" placeholder=\"Search\"/>\n" +
            "                </span>\n" +
            "            </div>\n" +
            "            <a class=\"cursor-pointer block lg:hidden text-700\"\n" +
            "               data-pb-styleclass=\"{ selector: '@next', enterClass: 'hidden', enterActiveClass: 'fadein', leaveToClass: 'hidden', leaveActiveClass: 'fadeout', hideOnOutsideClick: true }\">\n" +
            "                <i class=\"pi pi-ellipsis-v text-2xl\"/>\n" +
            "            </a>\n" +
            "            <ul class=\"list-none p-0 m-0  hidden lg:flex lg:align-items-center select-none lg:flex-row\n" +
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
            "        <div class=\"p-5 flex flex-column flex-auto\">\n" +
            "            <div>\n" +
            "                <div class=\"text-900 font-medium text-xl mb-3\">Profile</div>\n" +
            "                <p class=\"m-0 mb-4 p-0 text-600 line-height-3 mr-3\">Odio euismod lacinia at quis risus sed vulputate odio. Non nisi est sit amet.\n" +
            "                    Egestas integer eget aliquet nibh praesent tristique magna.</p>\n" +
            "                <div class=\"surface-card p-4 shadow-2 border-round\">\n" +
            "                    <div class=\"grid formgrid ui-fluid\">\n" +
            "                        <div class=\"field mb-4 col-12\">\n" +
            "                            <label for=\"nickname\" class=\"font-medium\">Nickname</label>\n" +
            "                            <p:inputText id=\"nickname\"/>\n" +
            "                        </div>\n" +
            "                        <div class=\"surface-100 mb-3 col-12\" style=\"height:2px\"></div>\n" +
            "                        <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                            <label for=\"bio\" class=\"font-medium\">Bio</label>\n" +
            "                            <p:inputTextarea id=\"bio\" rows=\"5\" autoResize=\"true\"/>\n" +
            "                        </div>\n" +
            "                        <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                            <label class=\"font-medium\">Avatar</label>\n" +
            "                            <div class=\"flex align-items-center\">\n" +
            "                                <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-4.png\"\n" +
            "                                                library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                                styleClass=\"mr-4\"/>\n" +
            "                                <p:fileUpload mode=\"simple\" skinSimple=\"true\" label=\"Upload Image\"\n" +
            "                                              auto=\"true\"\n" +
            "                                              process=\"@this\"/>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "                        <div class=\"surface-100 mb-3 col-12\" style=\"height:2px\"></div>\n" +
            "                        <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                            <label for=\"email\" class=\"font-medium\">Email</label>\n" +
            "                            <p:inputText id=\"email\"/>\n" +
            "                        </div>\n" +
            "                        <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                            <label for=\"bio\" class=\"font-medium\">Country</label>\n" +
            "                            <p:selectOneMenu filter=\"true\" filterMatchMode=\"startsWith\">\n" +
            "                                <f:selectItem itemLabel=\"Select a Country\" itemValue=\"\"/>\n" +
            "                                <f:selectItem itemLabel=\"Australia\" itemValue=\"Australia\"/>\n" +
            "                                <f:selectItem itemLabel=\"Brazil\" itemValue=\"Brazil\"/>\n" +
            "                                <f:selectItem itemLabel=\"China\" itemValue=\"China\"/>\n" +
            "                                <f:selectItem itemLabel=\"Egypt\" itemValue=\"Egypt\"/>\n" +
            "                                <f:selectItem itemLabel=\"France\" itemValue=\"France\"/>\n" +
            "                                <f:selectItem itemLabel=\"Germany\" itemValue=\"Germany\"/>\n" +
            "                                <f:selectItem itemLabel=\"India\" itemValue=\"India\"/>\n" +
            "                                <f:selectItem itemLabel=\"Japan\" itemValue=\"Japan\"/>\n" +
            "                                <f:selectItem itemLabel=\"Spain\" itemValue=\"Spain\"/>\n" +
            "                                <f:selectItem itemLabel=\"United States\" itemValue=\"United States\"/>\n" +
            "                            </p:selectOneMenu>\n" +
            "                        </div>\n" +
            "                        <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                            <label for=\"city\" class=\"font-medium\">City</label>\n" +
            "                            <p:inputText id=\"city\"/>\n" +
            "                        </div>\n" +
            "                        <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                            <label for=\"state\" class=\"font-medium\">State</label>\n" +
            "                            <p:inputText id=\"state\"/>\n" +
            "                        </div>\n" +
            "                        <div class=\"surface-100 mb-3 col-12\" style=\"height:2px\"></div>\n" +
            "                        <div class=\"field mb-4 col-12\">\n" +
            "                            <label for=\"website\" class=\"font-medium\">Website</label>\n" +
            "                            <div class=\"ui-inputgroup\">\n" +
            "                                <span class=\"ui-inputgroup-addon\">www</span>\n" +
            "                                <p:inputText id=\"website\"/>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "                        <div class=\"surface-100 mb-3 col-12\" style=\"height:2px\"></div>\n" +
            "                        <div class=\"field mb-4 col-12\">\n" +
            "                            <label class=\"font-medium\">Privacy</label>\n" +
            "                            <div class=\"flex align-items-center\">\n" +
            "                                <p:toggleSwitch/>\n" +
            "                                <span class=\"ml-2\">Share my data with contacts</span>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "                        <div class=\"surface-100 mb-3 col-12\" style=\"height:2px\"></div>\n" +
            "                        <div class=\"col-12\">\n" +
            "                            <p:commandButton type=\"button\" value=\"Save Changes\" styleClass=\"w-auto mt-3\"/>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;

    public String getBlock1() {
        return block1;
    }
}
