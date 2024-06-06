package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class DetailScreenView implements Serializable {

    private final String block1 = "<div class=\"surface-ground\">\n" +
            "    <div class=\"surface-overlay py-3 px-6 border-bottom-1 surface-border flex align-items-center justify-content-between relative lg:static\"\n" +
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
            "    <div class=\"surface-section px-6 pt-5\">\n" +
            "        <div class=\"text-3xl font-medium text-900 mb-4\">Application</div>\n" +
            "        <p:tabMenu activeIndex=\"#{param.i}\">\n" +
            "            <p:menuitem value=\"Overview\" icon=\"pi pi-home\">\n" +
            "                <f:param name=\"i\" value=\"0\" ajax=\"false\"/>\n" +
            "            </p:menuitem>\n" +
            "            <p:menuitem value=\"Members\" icon=\"pi pi-users\">\n" +
            "                <f:param name=\"i\" value=\"1\" ajax=\"false\"/>\n" +
            "            </p:menuitem>\n" +
            "            <p:menuitem value=\"Jobs\" icon=\"pi pi-search\">\n" +
            "                <f:param name=\"i\" value=\"2\" ajax=\"false\"/>\n" +
            "            </p:menuitem>\n" +
            "            <p:menuitem value=\"Profile\" icon=\"pi pi-user\">\n" +
            "                <f:param name=\"i\" value=\"3\" ajax=\"false\"/>\n" +
            "            </p:menuitem>\n" +
            "            <p:menuitem value=\"Settings\" icon=\"pi pi-cog\">\n" +
            "                <f:param name=\"i\" value=\"4\" ajax=\"false\"/>\n" +
            "            </p:menuitem>\n" +
            "        </p:tabMenu>\n" +
            "    </div>\n" +
            "    <div class=\"surface-section px-6 py-5\">\n" +
            "        <div class=\"flex align-items-start flex-column lg:flex-row lg:justify-content-between\">\n" +
            "            <div class=\"flex align-items-start flex-column md:flex-row\">\n" +
            "                <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1@2x.png\"\n" +
            "                                library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-5 mb-3 lg:mb-0\" style=\"width:90px;height:90px\"/>\n" +
            "                <div>\n" +
            "                    <span class=\"text-900 font-medium text-3xl\">Kathryn Murphy</span>\n" +
            "                    <i class=\"pi pi-star text-2xl ml-4 text-yellow-500\"/>\n" +
            "                    <div class=\"flex align-items-center flex-wrap text-sm\">\n" +
            "                        <div class=\"mr-5 mt-3\">\n" +
            "                            <span class=\"font-medium text-500\">FOLLOWERS</span>\n" +
            "                            <div class=\"text-700 mt-2\">333</div>\n" +
            "                        </div>\n" +
            "                        <div class=\"mr-5 mt-3\">\n" +
            "                            <span class=\"font-medium text-500\">PROJECTS</span>\n" +
            "                            <div class=\"text-700 mt-2\">26</div>\n" +
            "                        </div>\n" +
            "                        <div class=\"mr-5 mt-3\">\n" +
            "                            <span class=\"font-medium text-500\">COLLECTIONS</span>\n" +
            "                            <div class=\"text-700 mt-2\">17</div>\n" +
            "                        </div>\n" +
            "                        <div class=\"mt-3\">\n" +
            "                            <span class=\"font-medium text-500\">SHOTS</span>\n" +
            "                            <div class=\"text-700 mt-2\">130</div>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"mt-3 lg:mt-0\">\n" +
            "                <p:commandButton type=\"button\" icon=\"pi pi-bookmark\" styleClass=\"rounded-button mr-2\"/>\n" +
            "                <p:commandButton type=\"button\" icon=\"pi pi-heart\"\n" +
            "                                 styleClass=\"rounded-button ui-button-success mr-2\"/>\n" +
            "                <p:commandButton type=\"button\" icon=\"pi pi-list\"\n" +
            "                                 styleClass=\"rounded-button ui-button-help\"/>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"px-6 py-5\">\n" +
            "        <div class=\"surface-card p-4 shadow-2 border-round\">\n" +
            "            <div class=\"font-medium text-3xl text-900 mb-3\">Applicant Profile</div>\n" +
            "            <div class=\"text-500 mb-5\">Egestas sed tempus urna et pharetra pharetra massa massa ultricies.</div>\n" +
            "            <ul class=\"list-none p-0 m-0 border-top-1 border-300\">\n" +
            "                <li class=\"flex align-items-center py-3 px-2 flex-wrap surface-50\">\n" +
            "                    <div class=\"text-500 w-full md:w-2 font-medium\">Name</div>\n" +
            "                    <div class=\"text-900 w-full md:w-10\">Elliot Alderson</div>\n" +
            "                </li>\n" +
            "                <li class=\"flex align-items-center py-3 px-2 flex-wrap\">\n" +
            "                    <div class=\"text-500 w-full md:w-2 font-medium\">Bio</div>\n" +
            "                    <div class=\"text-900 w-full md:w-10 line-height-3\">Faucibus pulvinar elementum integer enim neque volutpat ac tincidunt vitae. Commodo odio aenean sed adipiscing diam donec adipiscing tristique. Eget felis eget nunc lobortis mattis aliquam faucibus purus in.</div>\n" +
            "                </li>\n" +
            "                <li class=\"flex align-items-center py-3 px-2 flex-wrap surface-50\">\n" +
            "                    <div class=\"text-500 w-full md:w-2 font-medium\">Salary Expectation</div>\n" +
            "                    <div class=\"text-900 w-full md:w-10\">$150,000</div>\n" +
            "                </li>\n" +
            "                <li class=\"flex align-items-center py-3 px-2 flex-wrap\">\n" +
            "                    <div class=\"text-500 w-full md:w-2 font-medium\">Skills</div>\n" +
            "                    <div class=\"text-900 w-full md:w-10\">\n" +
            "                        <p:tag styleClass=\"mr-2\" value=\"Algorithms\" rounded=\"true\"/>\n" +
            "                        <p:tag styleClass=\"mr-2\" severity=\"success\" value=\"Javascript\" rounded=\"true\"/>\n" +
            "                        <p:tag styleClass=\"mr-2\" severity=\"danger\" value=\"Python\" rounded=\"true\"/>\n" +
            "                        <p:tag severity=\"warning\" value=\"SQL\" rounded=\"true\"/>\n" +
            "                    </div>\n" +
            "                </li>\n" +
            "                <li class=\"flex align-items-center py-3 px-2 flex-wrap surface-50\">\n" +
            "                    <div class=\"text-500 w-full md:w-2 font-medium\">Repositories</div>\n" +
            "                    <div class=\"text-900 w-full md:w-10\">\n" +
            "                        <div class=\"grid mt-0 mr-0\">\n" +
            "                            <div class=\"col-12 md:col-6\">\n" +
            "                                <div class=\"p-3 border-1 border-300 border-round surface-0\">\n" +
            "                                    <div class=\"text-900 mb-2\">\n" +
            "                                        <i class=\"pi pi-github mr-2\"/>\n" +
            "                                        <span class=\"font-medium\">PrimeVue</span>\n" +
            "                                    </div>\n" +
            "                                    <div class=\"text-700\">The Most Powerful Vue UI Component Library</div>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                            <div class=\"col-12 md:col-6\">\n" +
            "                                <div class=\"p-3 border-1 border-300 border-round surface-0\">\n" +
            "                                    <div class=\"text-900 mb-2\">\n" +
            "                                        <i class=\"pi pi-github mr-2\"/>\n" +
            "                                        <span class=\"font-medium\">PrimeFaces</span>\n" +
            "                                    </div>\n" +
            "                                    <div class=\"text-700\">Ultimate UI Component Suite for JavaServer Faces</div>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                            <div class=\"col-12 md:col-6\">\n" +
            "                                <div class=\"p-3 border-1 border-300 border-round surface-0\">\n" +
            "                                    <div class=\"text-900 mb-2\">\n" +
            "                                        <i class=\"pi pi-github mr-2\"/>\n" +
            "                                        <span class=\"font-medium\">PrimeNG</span>\n" +
            "                                    </div>\n" +
            "                                    <div class=\"text-700\">The Most Complete Angular UI Component Library</div>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                            <div class=\"col-12 md:col-6\">\n" +
            "                                <div class=\"p-3 border-1 border-300 border-round surface-0\">\n" +
            "                                    <div class=\"text-900 mb-2\">\n" +
            "                                        <i class=\"pi pi-github mr-2\"/>\n" +
            "                                        <span class=\"font-medium\">PrimeReact</span>\n" +
            "                                    </div>\n" +
            "                                    <div class=\"text-700\">Advanced UI Components for ReactJS</div>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"py-5 px-6\">\n" +
            "        <div class=\"font-medium text-3xl text-900 mb-3\">Application Flow</div>\n" +
            "        <ul class=\"list-none p-0 m-0 flex flex-column md:flex-row\">\n" +
            "            <li class=\"relative mr-0 md:mr-8 flex-auto\">\n" +
            "                <div class=\"border-1 surface-border surface-card border-round p-3 flex flex-column md:flex-row align-items-center z-1\">\n" +
            "                    <i class=\"pi pi-check-circle text-green-500 text-2xl md:text-4xl mb-2 md:mb-0 mr-0 md:mr-3\"/>\n" +
            "                    <div>\n" +
            "                        <div class=\"text-900 font-medium mb-1\">Applied</div>\n" +
            "                        <span class=\"text-600 text-sm hidden md:block\">Tempus iaculis urna id volutpat</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"w-full absolute top-50 left-100 surface-300 hidden md:block\"\n" +
            "                     style=\"transform: translateY(-50%); height: 2px\"></div>\n" +
            "            </li>\n" +
            "            <li class=\"relative mr-0 md:mr-8 flex-auto\">\n" +
            "                <div class=\"border-2 border-blue-500 surface-card border-round p-3 flex flex-column md:flex-row align-items-center z-1\">\n" +
            "                    <i class=\"pi pi-users text-blue-600 text-2xl md:text-4xl mb-2 md:mb-0 mr-0 md:mr-3\"/>\n" +
            "                    <div>\n" +
            "                        <div class=\"text-blue-600 font-medium mb-1\">Interview</div>\n" +
            "                        <span class=\"text-600 text-sm hidden md:block\">Nisi vitae suscipit tellus</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"w-full absolute top-50 left-100 surface-300 hidden md:block\"\n" +
            "                     style=\"transform: translateY(-50%); height: 2px\"></div>\n" +
            "            </li>\n" +
            "            <li class=\"relative flex-auto\">\n" +
            "                <div class=\"border-1 surface-border surface-card border-round p-3 flex flex-column md:flex-row align-items-center z-1\">\n" +
            "                    <i class=\"pi pi-check-circle text-600 text-2xl md:text-4xl mb-2 md:mb-0 mr-0 md:mr-3\"/>\n" +
            "                    <div>\n" +
            "                        <div class=\"text-900 font-medium mb-1\">Confirmation</div>\n" +
            "                        <span class=\"text-600 text-sm hidden md:block\">Sit amet est placerat in egestas erat</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "    </div>\n" +
            "    <div class=\"surface-section py-6 px-6 border-top-1 surface-border\">\n" +
            "        <div class=\"flex flex flex-column lg:flex-row lg:align-items-center justify-content-between\">\n" +
            "            <div class=\"flex align-items-center\">\n" +
            "                <p:graphicImage name=\"images/blocks/footer/footer-1.png\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\"\n" +
            "                                styleClass=\"mr-3\" width=\"50\" height=\"50\"/>\n" +
            "                <div class=\"text-700 font-bold text-5xl\">Bastion</div>\n" +
            "            </div>\n" +
            "            <div class=\"flex flex-column lg:flex-row lg:align-items-center lg:my-0 my-4\">\n" +
            "                <a class=\"text-700 cursor-pointer mb-2 lg:mb-0\">Brand Policy</a>\n" +
            "                <a class=\"text-700 cursor-pointer mb-2 lg:mb-0 ml-0 lg:ml-4\">Privacy Policy</a>\n" +
            "                <a class=\"text-700 cursor-pointer mb-2 lg:mb-0 ml-0 lg:ml-4\">Terms of Service</a>\n" +
            "            </div>\n" +
            "            <div class=\"flex align-items-center lg:justify-content-between\">\n" +
            "                <a class=\"cursor-pointer text-500\">\n" +
            "                    <i class=\"pi pi-twitter text-xl\"/>\n" +
            "                </a>\n" +
            "                <a class=\"cursor-pointer text-500 ml-2\">\n" +
            "                    <i class=\"pi pi-facebook text-xl\"/>\n" +
            "                </a>\n" +
            "                <a class=\"cursor-pointer text-500 ml-2\">\n" +
            "                    <i class=\"pi pi-github text-xl\"/>\n" +
            "                </a>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;

    public String getBlock1() {
        return block1;
    }
}
