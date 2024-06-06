package com.primejmoordb.application;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;


import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@Named
@ViewScoped
public class PageHeadingView implements Serializable {

    private MenuModel searchModel;

    private MenuModel techModel;
    private MenuModel locationModel;
    private MenuModel contractModel;
    
    private final String block1 = "<div class=\"surface-section px-4 py-5 md:px-6 lg:px-8\">\n" +
            "    <ul class=\"list-none p-0 m-0 flex align-items-center font-medium mb-3\">\n" +
            "        <li>\n" +
            "            <a class=\"text-500 no-underline line-height-3 cursor-pointer\">Application</a>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <i class=\"pi pi-angle-right text-500 line-height-3\"/>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <span class=\"text-900 line-height-3\">Analytics</span>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "    <div class=\"flex align-items-start flex-column lg:justify-content-between lg:flex-row\">\n" +
            "        <div>\n" +
            "            <div class=\"font-medium text-3xl text-900\">Customers</div>\n" +
            "            <div class=\"flex align-items-center text-700 flex-wrap\">\n" +
            "                <div class=\"mr-5 flex align-items-center mt-3\">\n" +
            "                    <i class=\"pi pi-users mr-2\"/>\n" +
            "                    <span>332 Active Users</span>\n" +
            "                </div>\n" +
            "                <div class=\"mr-5 flex align-items-center mt-3\">\n" +
            "                    <i class=\"pi pi-globe mr-2\"/>\n" +
            "                    <span>9402 Sessions</span>\n" +
            "                </div>\n" +
            "                <div class=\"flex align-items-center mt-3\">\n" +
            "                    <i class=\"pi pi-clock mr-2\"/>\n" +
            "                    <span>2.32m Avg. Duration</span>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"mt-3 lg:mt-0\">\n" +
            "            <p:commandButton type=\"button\" value=\"Add\" icon=\"pi pi-user-plus\"\n" +
            "                             styleClass=\"ui-button-outlined mr-2\"/>\n" +
            "            <p:commandButton type=\"button\" value=\"Save\" icon=\"pi pi-check\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;
    
    private final String block2 = "<div class=\"surface-section  px-4 py-5 md:px-6 lg:px-8\">\n" +
            "    <div class=\"flex align-items-start flex-column lg:flex-row lg:justify-content-between\">\n" +
            "        <div class=\"flex align-items-start flex-column md:flex-row\">\n" +
            "            <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1@2x.png\"\n" +
            "                            library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                            styleClass=\"mr-5 mb-3 lg:mb-0\" style=\"width:90px;height:90px\"/>\n" +
            "            <div>\n" +
            "                <span class=\"text-900 font-medium text-3xl\">Kathryn Murphy</span>\n" +
            "                <i class=\"pi pi-star text-2xl ml-4 text-yellow-500\"/>\n" +
            "                <div class=\"flex align-items-center flex-wrap text-sm\">\n" +
            "                    <div class=\"mr-5 mt-3\">\n" +
            "                        <span class=\"font-medium text-500\">FOLLOWERS</span>\n" +
            "                        <div class=\"text-700 mt-2\">333</div>\n" +
            "                    </div>\n" +
            "                    <div class=\"mr-5 mt-3\">\n" +
            "                        <span class=\"font-medium text-500\">PROJECTS</span>\n" +
            "                        <div class=\"text-700 mt-2\">26</div>\n" +
            "                    </div>\n" +
            "                    <div class=\"mr-5 mt-3\">\n" +
            "                        <span class=\"font-medium text-500\">COLLECTIONS</span>\n" +
            "                        <div class=\"text-700 mt-2\">17</div>\n" +
            "                    </div>\n" +
            "                    <div class=\"mt-3\">\n" +
            "                        <span class=\"font-medium text-500\">SHOTS</span>\n" +
            "                        <div class=\"text-700 mt-2\">130</div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"mt-3 lg:mt-0\">\n" +
            "            <p:commandButton type=\"button\" icon=\"pi pi-bookmark\" styleClass=\"rounded-button mr-2\"/>\n" +
            "            <p:commandButton type=\"button\" icon=\"pi pi-heart\"\n" +
            "                             styleClass=\"rounded-button ui-button-success mr-2\"/>\n" +
            "            <p:commandButton type=\"button\" icon=\"pi pi-list\" styleClass=\"rounded-button ui-button-help\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block3 = "<div class=\"surface-section  px-4 py-5 md:px-6 lg:px-8\">\n" +
            "    <div class=\"flex flex-column md:align-items-center md:justify-content-between md:flex-row\">\n" +
            "        <div class=\"font-medium text-3xl text-900\">Customers</div>\n" +
            "        <div class=\"mt-3 md:mt-0\">\n" +
            "            <p:commandButton type=\"button\" value=\"Add\" icon=\"pi pi-user-plus\"\n" +
            "                             styleClass=\"ui-button-outlined mr-2\"/>\n" +
            "            <p:commandButton type=\"button\" value=\"Save\" icon=\"pi pi-check\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block4 = "<div class=\"bg-gray-900 px-4 py-5 md:px-6 lg:px-8\">\n" +
            "    <div class=\"flex flex-column md:align-items-center md:justify-content-between md:flex-row\">\n" +
            "        <div class=\"font-medium text-3xl text-white\">Customers</div>\n" +
            "        <div class=\"mt-3 md:mt-0\">\n" +
            "            <p:commandButton type=\"button\" value=\"Add\" icon=\"pi pi-user-plus\"\n" +
            "                             styleClass=\"ui-button-outlined mr-2\"/>\n" +
            "            <p:commandButton type=\"button\" value=\"Save\" icon=\"pi pi-check\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block5 = "<div class=\"surface-section px-4 py-5 md:px-6 lg:px-8\">\n" +
            "    <ul class=\"list-none p-0 m-0 flex align-items-center font-medium mb-3\">\n" +
            "        <li>\n" +
            "            <a class=\"text-500 no-underline line-height-3 cursor-pointer\">Application</a>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <i class=\"pi pi-angle-right text-500 line-height-3\"></i>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <a class=\"text-500 no-underline line-height-3 cursor-pointer\">Customers</a>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <i class=\"pi pi-angle-right text-500 line-height-3\"></i>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <span class=\"text-900 line-height-3\">VIP Leads</span>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "    <div class=\"flex flex-column md:flex-row md:justify-content-between\">\n" +
            "        <span class=\"text-3xl font-medium text-900\">VIP LEADS</span>\n" +
            "        <div class=\"flex align-items-center mt-3 md:mt-0\">\n" +
            "            <span class=\"ui-input-icon-left\">\n" +
            "                <i class=\"pi pi-search\"/>\n" +
            "                <p:inputText type=\"search\" styleClass=\"mr-3\" placeholder=\"Search\"/>\n" +
            "            </span>\n" +
            "            <p:commandButton type=\"button\" icon=\"pi pi-user-plus\" styleClass=\"ui-button-outlined rounded-button\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block6 = "<div class=\"bg-gray-900 px-4 py-5 md:px-6 lg:px-8\">\n" +
            "    <ul class=\"list-none p-0 m-0 flex align-items-center font-medium mb-3\">\n" +
            "        <li>\n" +
            "            <a class=\"text-500 no-underline line-height-3 cursor-pointer\">Application</a>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <i class=\"pi pi-angle-right text-500 line-height-3\"></i>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <a class=\"text-500 no-underline line-height-3 cursor-pointer\">Customers</a>\n" +
            "        </li>\n" +
            "        <li class=\"px-2\">\n" +
            "            <i class=\"pi pi-angle-right text-500 line-height-3\"></i>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <span class=\"text-white line-height-3\">VIP Leads</span>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "    <div class=\"flex flex-column md:flex-row md:justify-content-between\">\n" +
            "        <span class=\"text-3xl font-medium text-white\">VIP LEADS</span>\n" +
            "        <div class=\"flex align-items-center mt-3 md:mt-0\">\n" +
            "            <span class=\"ui-input-icon-left\">\n" +
            "                <i class=\"pi pi-search\"/>\n" +
            "                <p:inputText type=\"search\" styleClass=\"mr-3 bg-gray-900\" placeholder=\"Search\"/>\n" +
            "            </span>\n" +
            "            \n" +
            "            <p:commandButton type=\"button\" icon=\"pi pi-user-plus\" styleClass=\"ui-button-outlined rounded-button\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block7 = "<div>\n" +
            "    <div style=\"height:200px; background: url(#{resource['primeblocks-app:images/blocks/pageheading/cover.png']}) no-repeat; background-size: cover\"></div>\n" +
            "    <div class=\"px-4 py-5 md:px-6 lg:px-8 surface-section\">\n" +
            "        <div class=\"flex flex-column lg:flex-row lg:align-items-center lg:justify-content-between relative\" style=\"margin-top:-2rem; top:-70px; margin-bottom:-70px\">\n" +
            "            <div>\n" +
            "                <div style=\"width:140px; height: 140px; border-radius: 10px\" class=\"mb-3 surface-card shadow-2 flex align-items-center justify-content-center\">\n" +
            "                    <p:graphicImage name=\"images/blocks/logos/hyper.svg\"\n" +
            "                            library=\"primeblocks-app\" alt=\"Image\" width=\"70\" height=\"70\"/>\n" +
            "                </div>\n" +
            "                <div class=\"text-900 text-3xl font-medium mb-3\">Company Name</div>\n" +
            "                <p class=\"mt-0 mb-3 text-700 text-xl\">Vitae tortor condimentum lacinia quis vel eros.</p>\n" +
            "                <div class=\"text-600 font-medium\">\n" +
            "                    <span>Software | USA | 15523 Followers</span>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"mt-3 lg:mt-0\">\n" +
            "                <p:commandButton type=\"button\" value=\"Follow\" icon=\"pi pi-plus-circle\" styleClass=\"ui-button-outlined mr-2\"/>\n" +
            "                <p:commandButton type=\"button\" value=\"Website\" icon=\"pi pi-link\" styleClass=\"mr-2\"/>\n" +
            "                <p:commandButton type=\"button\" icon=\"pi pi-ellipsis-v\" styleClass=\"ui-button-outlined rounded-button\"/>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block8 = "<div class=\"surface-section px-4 py-5 md:px-6 lg:px-8\">\n" +
            "    <div class=\"text-900 text-3xl font-medium mb-3 flex align-items-center\">Applications <span class=\"text-700 ml-3 text-base font-normal\">7 Active</span></div>\n" +
            "    <div class=\"flex flex-column lg:flex-row lg:align-items-center\">\n" +
            "        <span class=\"ui-input-icon-left \">\n" +
            "            <i class=\"pi pi-search\"/>\n" +
            "            <p:inputText type=\"search\" styleClass=\"p-inputtext p-component p-element\" placeholder=\"Search\"\n" +
            "            style=\"border-radius: 20px\"/>\n" +
            "        </span>\n" +
            "        <div class=\"mt-3 lg:mt-0 flex align-items-start flex-column md:flex-row\">\n" +
            "            <p:commandButton id=\"specialtiesButton\" value=\"Specialties\" styleClass=\"ml-3 surface-100 border-none text-600 hover:surface-200\" iconPos=\"right\" type=\"button\" icon=\"pi pi-angle-down\" style=\"border-radius: 20px; background-color: gray;\"/>\n" +
            "            <p:menu overlay=\"true\" model=\"#{pageHeadingView.techModel}\" trigger=\"specialtiesButton\" my=\"left top\" at=\"left bottom\"/>\n" +
            "\n" +
            "            <p:commandButton id=\"locationButton\" value=\"Locations\" styleClass=\"ml-3 surface-100 border-none text-600 hover:surface-200\" iconPos=\"right\" type=\"button\" icon=\"pi pi-angle-down\" style=\"border-radius: 20px\"/>\n" +
            "            <p:menu overlay=\"true\" model=\"#{pageHeadingView.locationModel}\" trigger=\"locationButton\" my=\"left top\" at=\"left bottom\"/>\n" +
            "\n" +
            "            <p:commandButton id=\"contractButton\" value=\"Contract\" styleClass=\"ml-3 surface-100 border-none text-600 hover:surface-200\" iconPos=\"right\" type=\"button\" icon=\"pi pi-angle-down\" style=\"border-radius: 20px\"/>\n" +
            "            <p:menu overlay=\"true\" model=\"#{pageHeadingView.contractModel}\" trigger=\"contractButton\" my=\"left top\" at=\"left bottom\"/>\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;
    private final String block9 = "<div class=\"surface-ground px-4 py-5 md:px-6 lg:px-8\">\n" +
            "    <div class=\"text-900 text-3xl font-medium mb-3\">Latest Projects</div>\n" +
            "    <div class=\"px-4 py-2 surface-border border-1 border-round-top surface-section\">\n" +
            "        <div class=\"flex flex-wrap align-items-center\">\n" +
            "            <span class=\"inline-flex p-2 surface-100 font-medium text-sm align-items-center mr-3 my-1 white-space-nowrap\" style=\"border-radius: 20px\">CSS <i class=\"ml-2 pi pi-times-circle\"></i></span>\n" +
            "            <span class=\"inline-flex p-2 surface-100 font-medium text-sm align-items-center mr-3 my-1 white-space-nowrap\" style=\"border-radius: 20px\">Javascript <i class=\"ml-2 pi pi-times-circle\"></i></span>\n" +
            "            <span class=\"inline-flex p-2 surface-100 font-medium text-sm align-items-center mr-3 my-1 white-space-nowrap\" style=\"border-radius: 20px\">New York <i class=\"ml-2 pi pi-times-circle\"></i></span>\n" +
            "            <span class=\"inline-flex p-2 surface-100 font-medium text-sm align-items-center my-1 white-space-nowrap\" style=\"border-radius: 20px\">Permanent <i class=\"ml-2 pi pi-times-circle\"></i></span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"px-4 py-2 surface-border border-1 border-top-none border-round-bottom surface-section\">\n" +
            "        <div class=\"flex flex-wrap align-items-center\">\n" +
            "            <p:commandButton value=\"Technologies\" styleClass=\"ui-button-flat ui-button-plain\" icon=\"pi pi-angle-down\" iconPos=\"right\" />\n" +
            "            <p:menu overlay=\"true\" model=\"#{pageHeadingView.techModel}\" trigger=\"@previous\" my=\"left top\" at=\"left bottom\"/>\n" +
            "            <p:commandButton value=\"Locations\" styleClass=\"ui-button-flat ui-button-plain\" icon=\"pi pi-angle-down\" iconPos=\"right\" />\n" +
            "            <p:menu overlay=\"true\" model=\"#{pageHeadingView.locationModel}\" trigger=\"@previous\" my=\"left top\" at=\"left bottom\"/>\n" +
            "            <p:commandButton value=\"Contract\" styleClass=\"ui-button-flat ui-button-plain\" icon=\"pi pi-angle-down\" iconPos=\"right\" />\n" +
            "            <p:menu overlay=\"true\" model=\"#{pageHeadingView.contractModel}\" trigger=\"@previous\" my=\"left top\" at=\"left bottom\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block10 = "<div class=\"surface-section px-4 py-5 md:px-6 lg:px-8\">\n" +
            "    <div class=\"text-900 font-medium text-3xl mb-3\">Information Security Analyst</div>\n" +
            "    <div class=\"flex align-items-center text-700 mb-3\">\n" +
            "        <span class=\"inline-flex align-items-center mr-5\"><i class=\"pi pi-eye mr-2\"></i>3232 Views</span>\n" +
            "        <span class=\"inline-flex align-items-center\"><i class=\"pi pi-comments mr-2\"></i>209 Comments</span>\n" +
            "    </div>\n" +
            "    <ul class=\"list-none p-0 m-0 surface-100 flex overflow-y-hidden overflow-x-auto border-round\">\n" +
            "        <li class=\"relative py-3 pl-6 pr-3 flex flex-column justify-content-center\">\n" +
            "            <div class=\"text-xl font-medium text-900 mb-3\">240</div>\n" +
            "            <span class=\"text-600 white-space-nowrap\">New Applied</span>\n" +
            "        </li>\n" +
            "        <li class=\"relative py-3 pl-6 pr-3 flex flex-column justify-content-center\">\n" +
            "            <div class=\"absolute left-0 top-0 z-1\" style=\"border-left: 20px solid var(--surface-100); border-top: 45px solid transparent; border-bottom: 45px solid transparent; width: 0; height: 0\"></div>\n" +
            "            <div class=\"text-xl font-medium text-900 mb-2\">159</div>\n" +
            "            <span class=\"text-600 white-space-nowrap\">Screening</span>\n" +
            "            <div class=\"absolute top-0\" style=\"left: 1px; border-left: 20px solid var(--surface-300); border-top: 45px solid transparent; border-bottom: 45px solid transparent; width: 0; height: 0\"></div>\n" +
            "        </li>\n" +
            "        <li class=\"relative py-3 pl-6 pr-3 flex flex-column justify-content-center\">\n" +
            "            <div class=\"absolute left-0 top-0 z-1\" style=\"border-left: 20px solid var(--surface-100); border-top: 45px solid transparent; border-bottom: 45px solid transparent; width: 0; height: 0\"></div>\n" +
            "            <div class=\"text-xl font-medium text-900 mb-2\">79</div>\n" +
            "            <span class=\"text-600 white-space-nowrap\">Interview</span>\n" +
            "            <div class=\"absolute top-0\" style=\"left: 1px; border-left: 20px solid var(--surface-300); border-top: 45px solid transparent; border-bottom: 45px solid transparent; width: 0; height: 0\"></div>\n" +
            "        </li>\n" +
            "        <li class=\"relative py-3 pl-6 pr-3 flex flex-column justify-content-center\">\n" +
            "            <div class=\"absolute left-0 top-0 z-1\" style=\"border-left: 20px solid var(--surface-100); border-top: 45px solid transparent; border-bottom:45px solid transparent; width: 0; height: 0\"></div>\n" +
            "            <div class=\"text-xl font-medium text-900 mb-3\">19</div>\n" +
            "            <span class=\"text-600 white-space-nowrap\">Offer</span>\n" +
            "            <div class=\"absolute top-0\" style=\"left: 1px; border-left: 20px solid var(--surface-300); border-top: 45px solid transparent; border-bottom: 45px solid transparent; width: 0; height: 0\"></div>\n" +
            "        </li>\n" +
            "        <li class=\"relative py-3 pl-6 pr-3 flex flex-column justify-content-center\">\n" +
            "            <div class=\"absolute left-0 top-0 z-1\" style=\"border-left: 20px solid var(--surface-100); border-top: 45px solid transparent; border-bottom:45px solid transparent; width: 0; height: 0\"></div>\n" +
            "            <div class=\"text-xl font-medium text-900 mb-3\">5</div>\n" +
            "            <span class=\"text-600 white-space-nowrap\">Hired</span>\n" +
            "            <div class=\"absolute top-0\" style=\"left: 1px; border-left: 20px solid var(--surface-300); border-top: 45px solid transparent; border-bottom: 45px solid transparent; width: 0; height: 0\"></div>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "</div>\n" ;

    private final String block11 = "<div class=\"surface-section px-4 py-5 md:px-6 lg:px-8 flex flex-column lg:flex-row lg:align-items-center lg:justify-content-between\">\n" +
            "    <div class=\"flex align-items-center\">\n" +
            "        <div class=\"text-900 text-3xl font-medium mr-3\">Mercury Mission</div>\n" +
            "        <p:tag styleClass=\"mr-2\" value=\"Journey\" severity=\"warning\" rounded=\"true\" ></p:tag>\n" +
            "        <p:tag styleClass=\"mr-2\" value=\"Space\" severity=\"help\" rounded=\"true\" ></p:tag>\n" +
            "    </div>\n" +
            "    <div class=\"flex align-items-center mt-3 lg:mt-0\">\n" +
            "        <p:avatarGroup styleClass=\"mr-3\">\n" +
            "            <p:avatar shape=\"circle\">\n" +
            "                <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\" alt=\"Image\"/>\n" +
            "            </p:avatar>\n" +
            "            <p:avatar shape=\"circle\">\n" +
            "                <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-2.png\" library=\"primeblocks-app\" alt=\"Image\"/>\n" +
            "            </p:avatar>\n" +
            "            <p:avatar shape=\"circle\">\n" +
            "                <p:graphicImage name=\"images/blocks/avatars/circle/avatar-m-1.png\" library=\"primeblocks-app\" alt=\"Image\"/>\n" +
            "            </p:avatar>\n" +
            "            <p:avatar shape=\"circle\">\n" +
            "                <p:graphicImage name=\"images/blocks/avatars/circle/avatar-m-2.png\" library=\"primeblocks-app\" alt=\"Image\"/>\n" +
            "            </p:avatar>\n" +
            "            <p:avatar shape=\"circle\">\n" +
            "                <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-3.png\" library=\"primeblocks-app\" alt=\"Image\"/>\n" +
            "            </p:avatar>\n" +
            "\n" +
            "        </p:avatarGroup>\n" +
            "        <p:commandButton type=\"button\" value=\"Invite\" icon=\"pi pi-user-plus\" styleClass=\"mr-3 rounded-button\"/>\n" +
            "        <p:commandButton id=\"userButton\" type=\"button\" icon=\"pi pi-ellipsis-v\"\n" +
            "            styleClass=\"ui-button-flat ui-button-plain rounded-button\" />\n" +
            "\n" +
            "        <p:menu overlay=\"true\" model=\"#{pageHeadingView.techModel}\" trigger=\"userButton\" my=\"left top\" at=\"left bottom\"/>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block12 = "<div class=\"surface-section px-4 py-5 md:px-6 lg:px-8 flex flex-wrap\">\n" +
            "    <div class=\"w-full md:w-6\">\n" +
            "        <p:commandButton value=\"Venus Mission\" styleClass=\"ui-button-flat ui-button-plain inline-flex align-items-center text-900 text-3xl font-medium mb-3 cursor-pointer\" icon=\"pi pi-angle-down\" iconPos=\"right\" />\n" +
            "            <p:menu overlay=\"true\" model=\"#{pageHeadingView.techModel}\" trigger=\"@previous\" my=\"left top\" at=\"left bottom\"/>\n" +
            "        <div class=\"flex align-items-center text-600\">\n" +
            "            <span class=\"mr-5\"><i class=\"pi pi-check-circle mr-2\"></i>Verified</span>\n" +
            "            <span><i class=\"pi pi-book mr-2\"></i>60 Cases</span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"w-full md:w-6 flex flex-column md:flex-row md:align-items-center md:justify-content-end mt-4 md:mt-0\">\n" +
            "        <div class=\"flex align-items-start mr-0 md:mr-5\">\n" +
            "            <span class=\"block border-circle flex align-items-center justify-content-center bg-cyan-300 text-cyan-900 mr-3\" style=\"width:56px; height: 56px\">\n" +
            "                <i class=\"pi pi-users text-4xl\"></i>\n" +
            "            </span>\n" +
            "            <div>\n" +
            "                <span class=\"font-medium text-600\">Members</span>\n" +
            "                <p class=\"mt-1 mb-0 text-900 text-2xl font-medium\">123</p>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"flex align-items-start mt-3 md:mt-0\">\n" +
            "            <span class=\"block border-circle flex align-items-center justify-content-center bg-yellow-300 text-yellow-900 mr-3\" style=\"width:56px; height: 56px\">\n" +
            "                <i class=\"pi pi-wallet text-4xl\"></i>\n" +
            "            </span>\n" +
            "            <div>\n" +
            "                <span class=\"font-medium text-600\">Balance</span>\n" +
            "                <p class=\"mt-1 mb-0 text-900 text-2xl font-medium\">$250</p>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    @PostConstruct
    public void init() {
        searchModel = new DefaultMenuModel();
        techModel = new DefaultMenuModel();
        locationModel = new DefaultMenuModel();
        contractModel = new DefaultMenuModel();

        DefaultSubMenu searchSubmenu = DefaultSubMenu.builder()
                .label("Options")
                .build();
                
        DefaultMenuItem searchItem = DefaultMenuItem.builder()
                .value("Reports")
                .icon("pi pi-fw pi-chart-line")
                .build();
        searchSubmenu.getElements().add(searchItem);

        searchItem = DefaultMenuItem.builder()
                .value("Search")
                .icon("pi pi-fw pi-search")
                .build();
        searchSubmenu.getElements().add(searchItem);

        searchModel.getElements().add(searchSubmenu);


        DefaultMenuItem techItem = DefaultMenuItem.builder()
                .value("Javascript")
                .build();
        techModel.getElements().add(techItem);
        techItem = DefaultMenuItem.builder()
                .value("CSS")
                .build();
        techModel.getElements().add(techItem);

        techItem = DefaultMenuItem.builder()
                .value("Testing")
                .build();
        techModel.getElements().add(techItem);

        DefaultMenuItem locationItem = DefaultMenuItem.builder()
                .value("Los Angeles")
                .build();
        locationModel.getElements().add(locationItem);
        locationItem = DefaultMenuItem.builder()
                .value("New York")
                .build();
        locationModel.getElements().add(locationItem);

        locationItem = DefaultMenuItem.builder()
                .value("San Francisco")
                .build();
        locationModel.getElements().add(locationItem);

        DefaultMenuItem contractItem = DefaultMenuItem.builder()
                .value("Permanent")
                .build();
        contractModel.getElements().add(contractItem);

        contractItem = DefaultMenuItem.builder()
                .value("Contractor")
                .build();
        contractModel.getElements().add(contractItem);

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

    public String getBlock11() {
        return block11;
    }

    public String getBlock12() {
        return block12;
    }

    public MenuModel getTechModel() {
        return techModel;
    }

    public MenuModel getLocationModel() {
        return locationModel;
    }

    public MenuModel getContractModel() {
        return contractModel;
    }

    public MenuModel getSearchModel() {
        return searchModel;
    }
}
