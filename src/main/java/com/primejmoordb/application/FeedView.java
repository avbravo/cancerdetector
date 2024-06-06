package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class FeedView implements Serializable {

    private final String block1 = "<div>\n" +
            "    <div class=\"mb-5 flex\">\n" +
            "        <div class=\"flex flex-column align-items-center\" style=\"width:2rem\">\n" +
            "            <span class=\"bg-blue-500 text-0 flex align-items-center justify-content-center border-circle\"\n" +
            "                  style=\"min-width:2.5rem; min-height: 2.5rem\">\n" +
            "                <i class=\"pi pi-image\"/>\n" +
            "            </span>\n" +
            "            <div class=\"h-full bg-blue-500\" style=\"width: 2px; min-height: 4rem\"></div>\n" +
            "        </div>\n" +
            "        <div class=\"ml-5 surface-card shadow-2 border-round p-3 flex-auto\">\n" +
            "            <div class=\"mb-3\">\n" +
            "                <span class=\"text-900 font-medium inline-block mr-3\">Jacob Jones</span>\n" +
            "                <span class=\"text-500 text-sm\">1 minute ago</span>\n" +
            "            </div>\n" +
            "            <div class=\"line-height-3 text-700 mb-3\">\n" +
            "                Eu tincidunt tortor aliquam nulla facilisi cras fermentum.\n" +
            "                Sollicitudin nibh sit amet commodo nulla. Mauris in aliquam sem fringilla ut morbi.\n" +
            "            </div>\n" +
            "            <div class=\"text-500 flex align-items-center\">\n" +
            "                <i class=\"pi pi-heart mr-1\"/>\n" +
            "                <span class=\"mr-3\">0</span>\n" +
            "\n" +
            "                <i class=\"pi pi-comment mr-1\"/>\n" +
            "                <span class=\"mr-3\">1</span>\n" +
            "\n" +
            "                <i class=\"pi pi-eye mr-1\"/>\n" +
            "                <span>24</span>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"mb-5 flex\">\n" +
            "        <div class=\"flex flex-column align-items-center\" style=\"width:2rem\">\n" +
            "            <span class=\"bg-orange-500 text-0 flex align-items-center justify-content-center border-circle\"\n" +
            "                  style=\"min-width:2.5rem; min-height: 2.5rem\">\n" +
            "                <i class=\"pi pi-image\"/>\n" +
            "            </span>\n" +
            "            <div class=\"h-full bg-orange-500\" style=\"width: 2px; min-height: 4rem\"></div>\n" +
            "        </div>\n" +
            "        <div class=\"ml-5 surface-card shadow-2 border-round p-3 flex-auto\">\n" +
            "            <div class=\"mb-3\">\n" +
            "                <span class=\"text-900 font-medium inline-block mr-3\">Theresa Webb</span>\n" +
            "                <span class=\"text-500 text-sm\">2 hours ago</span>\n" +
            "            </div>\n" +
            "            <div class=\"line-height-3 text-700 mb-3\">\n" +
            "                Purus sit amet volutpat consequat mauris. Pretium lectus quam id leo in vitae.\n" +
            "                Posuere sollicitudin aliquam ultrices sagittis orci a scelerisque purus semper.\n" +
            "            </div>\n" +
            "            <div class=\"text-500 flex align-items-center\">\n" +
            "                <i class=\"pi pi-heart mr-1\"/>\n" +
            "                <span class=\"mr-3\">26</span>\n" +
            "\n" +
            "                <i class=\"pi pi-comment mr-1\"/>\n" +
            "                <span class=\"mr-3\">6</span>\n" +
            "\n" +
            "                <i class=\"pi pi-eye mr-1\"/>\n" +
            "                <span>673</span>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"mb-5 flex\">\n" +
            "        <div class=\"flex flex-column align-items-center\" style=\"width:2rem\">\n" +
            "            <span class=\"bg-purple-500 text-0 flex align-items-center justify-content-center border-circle\"\n" +
            "                  style=\"min-width:2.5rem; min-height: 2.5rem\">\n" +
            "                <i class=\"pi pi-image\"/>\n" +
            "            </span>\n" +
            "            <div class=\"h-full bg-purple-500\" style=\"width: 2px; min-height: 4rem\"></div>\n" +
            "        </div>\n" +
            "        <div class=\"ml-5 surface-card shadow-2 border-round p-3 flex-auto\">\n" +
            "            <div class=\"mb-3\">\n" +
            "                <span class=\"text-900 font-medium inline-block mr-3\">Walter Black</span>\n" +
            "                <span class=\"text-500 text-sm\">4 hours ago</span>\n" +
            "            </div>\n" +
            "            <div class=\"line-height-3 text-700 mb-3\">\n" +
            "                Euismod in pellentesque massa placerat duis ultricies lacus.\n" +
            "                Vitae sapien pellentesque habitant morbi tristique senectus et netus et.\n" +
            "            </div>\n" +
            "            <div class=\"text-500 flex align-items-center\">\n" +
            "                <i class=\"pi pi-heart mr-1\"/>\n" +
            "                <span class=\"mr-3\">62</span>\n" +
            "\n" +
            "                <i class=\"pi pi-comment mr-1\"/>\n" +
            "                <span class=\"mr-3\">36</span>\n" +
            "\n" +
            "                <i class=\"pi pi-eye mr-1\"/>\n" +
            "                <span>21</span>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;
    
    private final String block2 = "<div class=\"surface-card shadow-2 border-round p-4\">\n" +
            "    <div class=\"flex align-items-center justify-content-between mb-4\">\n" +
            "        <div class=\"text-900 font-medium text-xl\">Notifications</div>\n" +
            "        <div>\n" +
            "            <p:commandButton id=\"feedButton\" type=\"button\" icon=\"pi pi-ellipsis-v\"\n" +
            "                             styleClass=\"ui-button-flat ui-button-plain rounded-button\"/>\n" +
            "            <p:menu overlay=\"true\" trigger=\"feedButton\" my=\"left top\" at=\"left bottom\">\n" +
            "                <p:submenu label=\"Options\">\n" +
            "                    <p:menuitem value=\"Refresh\" icon=\"pi pi-fw pi-refresh\"/>\n" +
            "                    <p:menuitem value=\"Search\" icon=\"pi pi-fw pi-search\"/>\n" +
            "                </p:submenu>\n" +
            "            </p:menu>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "\n" +
            "    <span class=\"block text-600 font-medium mb-3\">TODAY</span>\n" +
            "    <ul class=\"p-0 mx-0 mt-0 mb-4 list-none\">\n" +
            "        <li class=\"flex align-items-center py-2 border-bottom-1 surface-border\">\n" +
            "            <div class=\"w-3rem h-3rem flex align-items-center justify-content-center bg-blue-100 border-circle mr-3 flex-shrink-0\">\n" +
            "                <i class=\"pi pi-dollar text-xl text-blue-500\"/>\n" +
            "            </div>\n" +
            "            <span class=\"text-900 line-height-3\">Richard Jones\n" +
            "                <span class=\"text-700\">has purchased a blue t-shirt for <span\n" +
            "                        class=\"text-blue-500\">79$</span></span>\n" +
            "            </span>\n" +
            "        </li>\n" +
            "        <li class=\"flex align-items-center py-2\">\n" +
            "            <div class=\"w-3rem h-3rem flex align-items-center justify-content-center bg-orange-100 border-circle mr-3 flex-shrink-0\">\n" +
            "                <i class=\"pi pi-download text-xl text-orange-500\"/>\n" +
            "            </div>\n" +
            "            <span class=\"text-700 line-height-3\">Your request for withdrawal of <span\n" +
            "                    class=\"text-blue-500 font-medium\">2500$</span> has been initiated.</span>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "\n" +
            "    <span class=\"block text-600 font-medium mb-3\">YESTERDAY</span>\n" +
            "    <ul class=\"p-0 m-0 list-none\">\n" +
            "        <li class=\"flex align-items-center py-2 border-bottom-1 surface-border\">\n" +
            "            <div class=\"w-3rem h-3rem flex align-items-center justify-content-center bg-blue-100 border-circle mr-3 flex-shrink-0\">\n" +
            "                <i class=\"pi pi-dollar text-xl text-blue-500\"/>\n" +
            "            </div>\n" +
            "            <span class=\"text-900 line-height-3\">Keyser Wick\n" +
            "                <span class=\"text-700\">has purchased a black jacket for <span\n" +
            "                        class=\"text-blue-500\">59$</span></span>\n" +
            "            </span>\n" +
            "        </li>\n" +
            "        <li class=\"flex align-items-center py-2 border-bottom-1 surface-border\">\n" +
            "            <div class=\"w-3rem h-3rem flex align-items-center justify-content-center bg-pink-100 border-circle mr-3 flex-shrink-0\">\n" +
            "                <i class=\"pi pi-question text-xl text-pink-500\"/>\n" +
            "            </div>\n" +
            "            <span class=\"text-900 line-height-3\">Jane Davis\n" +
            "                <span class=\"text-700\">has posted a new questions about your product.</span>\n" +
            "            </span>\n" +
            "        </li>\n" +
            "        <li class=\"flex align-items-center py-2\">\n" +
            "            <div class=\"w-3rem h-3rem flex align-items-center justify-content-center bg-green-100 border-circle mr-3 flex-shrink-0\">\n" +
            "                <i class=\"pi pi-arrow-up text-xl text-green-500\"/>\n" +
            "            </div>\n" +
            "            <span class=\"text-900 line-height-3\">Claire Smith\n" +
            "                <span class=\"text-700\">has upvoted your store along with a comment.</span>\n" +
            "            </span>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "</div>" ;

    private final String block3 = "<div class=\"surface-card shadow-2 border-round p-4\">\n" +
            "    <div class=\"flex align-items-center justify-content-between mb-3\">\n" +
            "        <div class=\"text-900 font-medium text-xl\">Team Activity</div>\n" +
            "        <div>\n" +
            "            <p:commandButton id=\"feedButton2\" type=\"button\" icon=\"pi pi-ellipsis-v\"\n" +
            "                             styleClass=\"ui-button-flat ui-button-plain rounded-button\"/>\n" +
            "            <p:menu overlay=\"true\" trigger=\"feedButton2\" my=\"left top\" at=\"left bottom\">\n" +
            "                <p:submenu label=\"Options\">\n" +
            "                    <p:menuitem value=\"Refresh\" icon=\"pi pi-fw pi-refresh\"/>\n" +
            "                    <p:menuitem value=\"Search\" icon=\"pi pi-fw pi-search\"/>\n" +
            "                </p:submenu>\n" +
            "            </p:menu>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <ul class=\"list-none p-0 m-0\">\n" +
            "        <li class=\"py-3 border-bottom-1 surface-border flex md:align-items-start md:justify-content-between flex-column md:flex-row\">\n" +
            "            <div class=\"flex align-items-start mr-0 lg:mr-5\">\n" +
            "                <p:graphicImage name=\"images/blocks/avatars/circle-big/avatar-f-1.png\"\n" +
            "                                library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-3 w-3rem h-3rem\"/>\n" +
            "                <div>\n" +
            "                    <span class=\"text-900 font-medium block mb-2\">Jane Cooper</span>\n" +
            "                    <div class=\"text-700 mb-2\">responded to an issue.</div>\n" +
            "                    <a class=\"text-blue-500 cursor-pointer\">\n" +
            "                        <i class=\"pi pi-github text-sm mr-2\"/>\n" +
            "                        <span>Issue #1185</span>\n" +
            "                    </a>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <span class=\"block text-500 font-medium ml-7 md:ml-5 mt-2 md:mt-0\">14 mins ago</span>\n" +
            "        </li>\n" +
            "        <li class=\"py-3 border-bottom-1 surface-border flex md:align-items-start md:justify-content-between flex-column md:flex-row\">\n" +
            "            <div class=\"flex align-items-start mr-0 lg:mr-5\">\n" +
            "                <p:graphicImage name=\"images/blocks/avatars/circle-big/avatar-m-1.png\"\n" +
            "                                library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-3 w-3rem h-3rem\"/>\n" +
            "                <div>\n" +
            "                    <span class=\"text-900 font-medium block mb-2\">Robert Fox</span>\n" +
            "                    <div class=\"text-700\">changed team size from <span class=\"text-900\">5</span> to <span\n" +
            "                            class=\"text-900\">6</span>.\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <span class=\"block text-500 font-medium ml-7 md:ml-5 mt-2 md:mt-0\">20 mins ago</span>\n" +
            "        </li>\n" +
            "        <li class=\"py-3 border-bottom-1 surface-border flex md:align-items-start md:justify-content-between flex-column md:flex-row\">\n" +
            "            <div class=\"flex align-items-start mr-0 lg:mr-5\">\n" +
            "                <p:graphicImage name=\"images/blocks/avatars/circle-big/avatar-f-2.png\"\n" +
            "                                library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-3 w-3rem h-3rem\"/>\n" +
            "                <div>\n" +
            "                    <span class=\"text-900 font-medium block mb-2\">Kristin Watson Cooper</span>\n" +
            "                    <div class=\"text-700 mb-2\">created a Q4 presentation to an issue.</div>\n" +
            "                    <a class=\"text-blue-500 cursor-pointer\">\n" +
            "                        <i class=\"pi pi-file-pdf text-sm mr-2\"/>\n" +
            "                        <span>q4_presentation.pdf</span>\n" +
            "                    </a>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <span class=\"block text-500 font-medium ml-7 md:ml-5 mt-2 md:mt-0\">38 mins ago</span>\n" +
            "        </li>\n" +
            "        <li class=\"py-3 border-bottom-1 surface-border flex md:align-items-start md:justify-content-between flex-column md:flex-row\">\n" +
            "            <div class=\"flex align-items-start mr-0 lg:mr-5\">\n" +
            "                <p:graphicImage name=\"images/blocks/avatars/circle-big/avatar-f-3.png\"\n" +
            "                                library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-3 w-3rem h-3rem\"/>\n" +
            "                <div>\n" +
            "                    <span class=\"text-900 font-medium block mb-2\">Annette Black</span>\n" +
            "                    <div class=\"text-700\">added <span class=\"text-900\">Nico Greenberg</span> to <span\n" +
            "                            class=\"text-blue-500\">Watchlist Tier-1</span>.\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <span class=\"block text-500 font-medium ml-7 md:ml-5 mt-2 md:mt-0\">1 day ago</span>\n" +
            "        </li>\n" +
            "        <li class=\"py-3 flex md:align-items-start md:justify-content-between flex-column md:flex-row\">\n" +
            "            <div class=\"flex align-items-start mr-0 lg:mr-5\">\n" +
            "                <p:graphicImage name=\"images/blocks/avatars/circle-big/avatar-m-2.png\"\n" +
            "                                library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-3 w-3rem h-3rem\"/>\n" +
            "                <div>\n" +
            "                    <span class=\"text-900 font-medium block mb-2\">Floyd Miles</span>\n" +
            "                    <div class=\"text-700\">has refunded a blue t-shirt for <span\n" +
            "                            class=\"text-blue-500\">79$</span>.\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <span class=\"block text-500 font-medium ml-7 md:ml-5 mt-2 md:mt-0\">4 days ago</span>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "</div>" ;

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
