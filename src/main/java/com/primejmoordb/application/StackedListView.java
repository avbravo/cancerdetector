package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class StackedListView implements Serializable {

    private final String block1 = "<div class=\"surface-card shadow-2 border-round p-4\">\n" +
            "    <div class=\"flex justify-content-between align-items-center mb-5\">\n" +
            "        <span class=\"text-xl text-900 font-medium\">Team Members</span>\n" +
            "        <div>\n" +
            "            <p:commandButton id=\"stackedListButton\" type=\"button\" icon=\"pi pi-ellipsis-v\"\n" +
            "                             styleClass=\"ui-button-flat ui-button-plain rounded-button\"/>\n" +
            "            <p:menu overlay=\"true\" trigger=\"stackedListButton\" my=\"left top\" at=\"left bottom\">\n" +
            "                <p:submenu>\n" +
            "                    <p:menuitem value=\"Add New\" icon=\"pi pi-fw pi-plus\"/>\n" +
            "                    <p:menuitem value=\"Remove\" icon=\"pi pi-fw pi-minus\"/>\n" +
            "                </p:submenu>\n" +
            "            </p:menu>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <ul class=\"list-none p-0 m-0\">\n" +
            "        <li class=\"flex flex-column md:flex-row md:align-items-center md:justify-content-between mb-4\">\n" +
            "            <div class=\"flex\">\n" +
            "                <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\"\n" +
            "                                library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-3\" style=\"width: 45px; height: 45px\"/>\n" +
            "                <div class=\"mr-0 md:mr-8\">\n" +
            "                    <span class=\"block text-900 font-medium mb-1\">Janette Hudson</span>\n" +
            "                    <div class=\"text-600\">UI/UX Designer</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"mt-2 md:mt-0 flex flex-nowrap\">\n" +
            "                <p:commandButton type=\"button\" icon=\"pi pi-twitter\"\n" +
            "                                 styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                <p:commandButton type=\"button\" icon=\"pi pi-github\"\n" +
            "                                 styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                <p:commandButton type=\"button\" icon=\"pi pi-facebook\"\n" +
            "                                 styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex flex-column md:flex-row md:align-items-center md:justify-content-between mb-4\">\n" +
            "            <div class=\"flex\">\n" +
            "                <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-2.png\"\n" +
            "                                library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-3\" style=\"width: 45px; height: 45px\"/>\n" +
            "                <div class=\"mr-0 md:mr-8\">\n" +
            "                    <span class=\"block text-900 font-medium mb-1\">Theresa Webb Hudson</span>\n" +
            "                    <div class=\"text-600\">UI/UX Designer</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"mt-2 md:mt-0 flex flex-nowrap\">\n" +
            "                <p:commandButton type=\"button\" icon=\"pi pi-twitter\"\n" +
            "                                 styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                <p:commandButton type=\"button\" icon=\"pi pi-github\"\n" +
            "                                 styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                <p:commandButton type=\"button\" icon=\"pi pi-facebook\"\n" +
            "                                 styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex flex-column md:flex-row md:align-items-center md:justify-content-between mb-4\">\n" +
            "            <div class=\"flex\">\n" +
            "                <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-3.png\"\n" +
            "                                library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-3\" style=\"width: 45px; height: 45px\"/>\n" +
            "                <div class=\"mr-0 md:mr-8\">\n" +
            "                    <span class=\"block text-900 font-medium mb-1\">Arlene McCoy</span>\n" +
            "                    <div class=\"text-600\">UI/UX Designer</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"mt-2 md:mt-0 flex flex-nowrap\">\n" +
            "                <p:commandButton type=\"button\" icon=\"pi pi-twitter\"\n" +
            "                                 styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                <p:commandButton type=\"button\" icon=\"pi pi-github\"\n" +
            "                                 styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                <p:commandButton type=\"button\" icon=\"pi pi-facebook\"\n" +
            "                                 styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex flex-column md:flex-row md:align-items-center md:justify-content-between mb-4\">\n" +
            "            <div class=\"flex\">\n" +
            "                <p:graphicImage name=\"images/blocks/avatars/circle/avatar-m-1.png\"\n" +
            "                                library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-3\" style=\"width: 45px; height: 45px\"/>\n" +
            "                <div class=\"mr-0 md:mr-8\">\n" +
            "                    <span class=\"block text-900 font-medium mb-1\">Jacob Jones</span>\n" +
            "                    <div class=\"text-600\">UI/UX Designer</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"mt-2 md:mt-0 flex flex-nowrap\">\n" +
            "                <p:commandButton type=\"button\" icon=\"pi pi-twitter\"\n" +
            "                                 styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                <p:commandButton type=\"button\" icon=\"pi pi-github\"\n" +
            "                                 styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                <p:commandButton type=\"button\" icon=\"pi pi-facebook\"\n" +
            "                                 styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex flex-column md:flex-row md:align-items-center md:justify-content-between mb-4\">\n" +
            "            <div class=\"flex\">\n" +
            "                <p:graphicImage name=\"images/blocks/avatars/circle/avatar-m-2.png\"\n" +
            "                                library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-3\" style=\"width: 45px; height: 45px\"/>\n" +
            "                <div class=\"mr-0 md:mr-8\">\n" +
            "                    <span class=\"block text-900 font-medium mb-1\">James Cooper</span>\n" +
            "                    <div class=\"text-600\">UI/UX Designer</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"mt-2 md:mt-0 flex flex-nowrap\">\n" +
            "                <p:commandButton type=\"button\" icon=\"pi pi-twitter\"\n" +
            "                                 styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                <p:commandButton type=\"button\" icon=\"pi pi-github\"\n" +
            "                                 styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "                <p:commandButton type=\"button\" icon=\"pi pi-facebook\"\n" +
            "                                 styleClass=\"ui-button-flat ui-button-plain rounded-button mr-1\"/>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "</div>" ;
    
    private final String block2 = "<div class=\"surface-card shadow-2 border-round p-4\">\n" +
            "    <div class=\"flex justify-content-between align-items-center mb-5\">\n" +
            "        <span class=\"text-xl text-900 font-medium\">Best Selling Products</span>\n" +
            "        <div>\n" +
            "            <p:commandButton id=\"stackedListButton2\" type=\"button\" icon=\"pi pi-ellipsis-v\"\n" +
            "                             styleClass=\"ui-button-flat ui-button-plain rounded-button\"/>\n" +
            "            <p:menu overlay=\"true\" trigger=\"stackedListButton2\" my=\"left top\" at=\"left bottom\">\n" +
            "                <p:submenu>\n" +
            "                    <p:menuitem value=\"Add New\" icon=\"pi pi-fw pi-plus\"/>\n" +
            "                    <p:menuitem value=\"Remove\" icon=\"pi pi-fw pi-minus\"/>\n" +
            "                </p:submenu>\n" +
            "            </p:menu>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <ul class=\"list-none p-0 m-0\">\n" +
            "        <li class=\"flex flex-column md:flex-row md:align-items-center md:justify-content-between mb-4\">\n" +
            "            <div class=\"mr-8 md:mr-8\">\n" +
            "                <span class=\"inline-block text-900 font-medium mr-2 mb-1 md:mb-0\">Space T-Shirt</span>\n" +
            "                <span class=\"text-600\">Clothing</span>\n" +
            "            </div>\n" +
            "            <div class=\"mt-2 md:mt-0 ml-0 md:ml-8 flex align-items-center\">\n" +
            "                <div class=\"surface-300 border-round overflow-hidden\" style=\"height:8px; width: 200px\">\n" +
            "                    <div class=\"bg-orange-500 h-full\" style=\"width:50%\"></div>\n" +
            "                </div>\n" +
            "                <span class=\"text-orange-500 ml-3 font-medium\">%50</span>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex flex-column md:flex-row md:align-items-center md:justify-content-between mb-4\">\n" +
            "            <div class=\"mr-8 md:mr-8\">\n" +
            "                <span class=\"inline-block text-900 font-medium mr-2 mb-1 md:mb-0\">Portal Sticker</span>\n" +
            "                <span class=\"text-600\">Accessories</span>\n" +
            "            </div>\n" +
            "            <div class=\"mt-2 md:mt-0 ml-0 md:ml-8 flex align-items-center\">\n" +
            "                <div class=\"surface-300 border-round overflow-hidden\" style=\"height:8px; width: 200px\">\n" +
            "                    <div class=\"bg-cyan-500 h-full\" style=\"width:16%\"></div>\n" +
            "                </div>\n" +
            "                <span class=\"text-cyan-500 ml-3 font-medium\">%16</span>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex flex-column md:flex-row md:align-items-center md:justify-content-between mb-4\">\n" +
            "            <div class=\"mr-8 md:mr-8\">\n" +
            "                <span class=\"inline-block text-900 font-medium mr-2 mb-1 md:mb-0\">Supernova Sticker</span>\n" +
            "                <span class=\"text-600\">Accessories</span>\n" +
            "            </div>\n" +
            "            <div class=\"mt-2 md:mt-0 ml-0 md:ml-8 flex align-items-center\">\n" +
            "                <div class=\"surface-300 border-round overflow-hidden\" style=\"height:8px; width: 200px\">\n" +
            "                    <div class=\"bg-pink-500 h-full\" style=\"width:67%\"></div>\n" +
            "                </div>\n" +
            "                <span class=\"text-pink-500 ml-3 font-medium\">%67</span>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex flex-column md:flex-row md:align-items-center md:justify-content-between mb-4\">\n" +
            "            <div class=\"mr-8 md:mr-8\">\n" +
            "                <span class=\"inline-block text-900 font-medium mr-2 mb-1 md:mb-0\">Wonders Notebook</span>\n" +
            "                <span class=\"text-600\">Office</span>\n" +
            "            </div>\n" +
            "            <div class=\"mt-2 md:mt-0 ml-0 md:ml-8 flex align-items-center\">\n" +
            "                <div class=\"surface-300 border-round overflow-hidden\" style=\"height:8px; width: 200px\">\n" +
            "                    <div class=\"bg-green-500 h-full\" style=\"width:35%\"></div>\n" +
            "                </div>\n" +
            "                <span class=\"text-green-500 ml-3 font-medium\">%35</span>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex flex-column md:flex-row md:align-items-center md:justify-content-between mb-4\">\n" +
            "            <div class=\"mr-8 md:mr-8\">\n" +
            "                <span class=\"inline-block text-900 font-medium mr-2 mb-1 md:mb-0\">Mat Black Case</span>\n" +
            "                <span class=\"text-600\">Accessories</span>\n" +
            "            </div>\n" +
            "            <div class=\"mt-2 md:mt-0 ml-0 md:ml-8 flex align-items-center\">\n" +
            "                <div class=\"surface-300 border-round overflow-hidden\" style=\"height:8px; width: 200px\">\n" +
            "                    <div class=\"bg-purple-500 h-full\" style=\"width:75%\"></div>\n" +
            "                </div>\n" +
            "                <span class=\"text-purple-500 ml-3 font-medium\">%75</span>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex flex-column md:flex-row md:align-items-center md:justify-content-between mb-4\">\n" +
            "            <div class=\"mr-8 md:mr-8\">\n" +
            "                <span class=\"inline-block text-900 font-medium mr-2 mb-1 md:mb-0\">Robots T-Shirt</span>\n" +
            "                <span class=\"text-600\">Clothing</span>\n" +
            "            </div>\n" +
            "            <div class=\"mt-2 md:mt-0 ml-0 md:ml-8 flex align-items-center\">\n" +
            "                <div class=\"surface-300 border-round overflow-hidden\" style=\"height:8px; width: 200px\">\n" +
            "                    <div class=\"bg-teal-500 h-full\" style=\"width:40%\"></div>\n" +
            "                </div>\n" +
            "                <span class=\"text-teal-500 ml-3 font-medium\">%40</span>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "</div>" ;

    private final String block3 = "<div class=\"surface-card shadow-2 border-round p-4\">\n" +
            "    <div class=\"text-xl text-900 font-medium mb-5\">Latest News</div>\n" +
            "    <ul class=\"list-none p-0 m-0\">\n" +
            "        <li class=\"pb-3 border-bottom-1 surface-border\">\n" +
            "            <div class=\"font-medium text-900 mb-2\">Aenean euismod elementum</div>\n" +
            "            <div class=\"line-height-3 text-600\"\n" +
            "                 style=\"max-width: 30rem\">Vitae turpis massa sed elementum tempus egestas sed sed risus.\n" +
            "                In metus vulputate eu scelerisque felis imperdiet proin.\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"py-3 border-bottom-1 surface-border\">\n" +
            "            <div class=\"font-medium text-900 mb-2\">In iaculis nunc sed augue lacus</div>\n" +
            "            <div class=\"line-height-3 text-600\"\n" +
            "                 style=\"max-width: 30rem\">Viverra vitae congue. Nisi scelerisque eu ultrices vitae auctor eu augue ut lectus.\n" +
            "                Elementum eu facilisis sed odio morbi.\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"py-3 border-bottom-1 surface-border\">\n" +
            "            <div class=\"font-medium text-900 mb-2\">Proin sagittis nisl rhoncus</div>\n" +
            "            <div class=\"line-height-3 text-600\"\n" +
            "                 style=\"max-width: 30rem\">In pellentesque massa placerat duis ultricies lacus. Ac feugiat sed lectus vestibulum mattis ullamcorper.\n" +
            "            </div>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "    <div class=\"flex justify-content-between pt-3\">\n" +
            "        <p:commandButton type=\"button\" value=\"Clear All\"\n" +
            "                         styleClass=\"ui-button-outlined ui-button-secondary w-6 mr-2\"/>\n" +
            "        <p:commandButton type=\"button\" value=\"New Entry\"\n" +
            "                         styleClass=\"ui-button-outlined w-6 ml-2\"/>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block4 = "<div class=\"surface-card shadow-2 border-round p-4\">\n" +
            "    <div class=\"flex justify-content-between align-items-center mb-5\">\n" +
            "        <span class=\"text-xl text-900 font-medium\">Recent Invoices</span>\n" +
            "        <div>\n" +
            "            <p:commandButton id=\"toggleButton\" type=\"button\" icon=\"pi pi-ellipsis-v\" styleClass=\"ui-button-flat ui-button-plain rounded-button\"/>\n" +
            "            <p:menu overlay=\"true\" trigger=\"toggleButton\" my=\"left top\" at=\"left bottom\">\n" +
            "                <p:menuitem value=\"Add New\" ajax=\"false\" icon=\"pi pi-fw pi-plus\"/>\n" +
            "                <p:menuitem value=\"Remove\" ajax=\"false\" icon=\"pi pi-fw pi-minus\"/>\n" +
            "            </p:menu>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <ul class=\"list-none p-0 m-0\">\n" +
            "        <li class=\"flex flex-column md:flex-row md:align-items-center md:justify-content-between p-3 border-1 mb-3\" style=\"border-radius: 10px; background-color: rgba(234,179,10,.1); border-color:rgba(234,179,10,.5)\">\n" +
            "            <div>\n" +
            "                <div>\n" +
            "                    <span class=\"inline-flex justify-content-center align-items-center w-2rem h-2rem border-circle border-1\" style=\"border-color:rgba(234,179,10,.5)\">\n" +
            "                        <i class=\"pi pi-file text-yellow-700\"></i>\n" +
            "                    </span>\n" +
            "                    <span class=\"text-yellow-700 font-bold ml-2\">Jenny Wilson</span>\n" +
            "                </div>\n" +
            "                <p class=\"text-yellow-700 mt-2 mb-0\">Due <span class=\"font-medium\">10/09/2021</span></p>\n" +
            "            </div>\n" +
            "            <div class=\"flex align-items-center justify-content-between md:justify-content-end mt-3 md:mt-0\">\n" +
            "                <span class=\"bg-yellow-400 text-yellow-900 font-bold text-sm py-1 px-2\" style=\"border-radius: 10px\">PENDING</span>\n" +
            "                <div class=\"text-right ml-3\">\n" +
            "                    <span class=\"text-yellow-700 font-bold\">120.00</span>\n" +
            "                    <p class=\"mt-1 mb-0 text-yellow-700\">EUR</p>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex flex-column md:flex-row md:align-items-center md:justify-content-between p-3 border-1 mb-3\" style=\"border-radius: 10px; background-color: rgba(33,197,94,.1); border-color:rgba(33,197,94,.5)\">\n" +
            "            <div>\n" +
            "                <div>\n" +
            "                    <span class=\"inline-flex justify-content-center align-items-center w-2rem h-2rem border-circle border-1\" style=\"border-color:rgba(33,197,94,.5)\">\n" +
            "                        <i class=\"pi pi-file text-green-600\"></i>\n" +
            "                    </span>\n" +
            "                    <span class=\"text-green-700 font-bold ml-2\">Dianne Russell</span>\n" +
            "                </div>\n" +
            "                <p class=\"text-green-700 mt-2 mb-0\">Due <span class=\"font-medium\">21/10/2021</span></p>\n" +
            "            </div>\n" +
            "            <div class=\"flex align-items-center justify-content-between md:justify-content-end mt-3 md:mt-0\">\n" +
            "                <span class=\"bg-green-400 text-green-900 font-bold text-sm py-1 px-2\" style=\"border-radius: 10px\">PAID</span>\n" +
            "                <div class=\"text-right ml-3\">\n" +
            "                    <span class=\"text-green-700 font-bold\">82.50</span>\n" +
            "                    <p class=\"mt-1 mb-0 text-green-700\">EUR</p>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex flex-column md:flex-row md:align-items-center md:justify-content-between p-3 border-1 mb-3\" style=\"border-radius: 10px; background-color: rgba(33,197,94,.1); border-color:rgba(33,197,94,.5)\">\n" +
            "            <div>\n" +
            "                <div>\n" +
            "                    <span class=\"inline-flex justify-content-center align-items-center w-2rem h-2rem border-circle border-1\" style=\"border-color:rgba(33,197,94,.5)\">\n" +
            "                        <i class=\"pi pi-file text-green-600\"></i>\n" +
            "                    </span>\n" +
            "                    <span class=\"text-green-700 font-bold ml-2\">Jerome Bell</span>\n" +
            "                </div>\n" +
            "                <p class=\"text-green-700 mt-2 mb-0\">Due <span class=\"font-medium\">20/12/2021</span></p>\n" +
            "            </div>\n" +
            "            <div class=\"flex align-items-center justify-content-between md:justify-content-end mt-3 md:mt-0\">\n" +
            "                <span class=\"bg-green-400 text-green-900 font-bold text-sm py-1 px-2\" style=\"border-radius: 10px\">PAID</span>\n" +
            "                <div class=\"text-right ml-3\">\n" +
            "                    <span class=\"text-green-700 font-bold\">250.00</span>\n" +
            "                    <p class=\"mt-1 mb-0 text-green-700\">EUR</p>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex flex-column md:flex-row md:align-items-center md:justify-content-between p-3 border-1 mb-3\" style=\"border-radius: 10px; background-color: rgba(330,81,60,.1); border-color:rgba(330,81,60,.5)\">\n" +
            "            <div>\n" +
            "                <div>\n" +
            "                    <span class=\"inline-flex justify-content-center align-items-center w-2rem h-2rem border-circle border-1\" style=\"border-color:rgba(330,81,60,.5)\">\n" +
            "                        <i class=\"pi pi-file text-pink-500\"></i>\n" +
            "                    </span>\n" +
            "                    <span class=\"text-pink-500 font-bold ml-2\">Courtney Henry</span>\n" +
            "                </div>\n" +
            "                <p class=\"text-pink-500 mt-2 mb-0\">Due <span class=\"font-medium\">01/05/2021</span></p>\n" +
            "            </div>\n" +
            "            <div class=\"flex align-items-center justify-content-between md:justify-content-end mt-3 md:mt-0\">\n" +
            "                <span class=\"bg-pink-400 text-pink-50 font-bold text-sm py-1 px-2\" style=\"border-radius: 10px\">UNPAID</span>\n" +
            "                <div class=\"text-right ml-3\">\n" +
            "                    <span class=\"text-pink-500 font-bold\">60.00</span>\n" +
            "                    <p class=\"mt-1 mb-0 text-pink-500\">EUR</p>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "</div>\n" ;

    private final String block5 = "<div class=\"surface-card shadow-2 border-round p-4\">\n" +
            "    <div class=\"flex justify-content-between align-items-center mb-5\">\n" +
            "        <span class=\"text-xl text-900 font-medium\">Top Downloads</span>\n" +
            "        <div>\n" +
            "            <p:commandButton id=\"toggleButton\" type=\"button\" icon=\"pi pi-ellipsis-v\" styleClass=\"ui-button-flat ui-button-plain rounded-button\"/>\n" +
            "            <p:menu overlay=\"true\" trigger=\"toggleButton\" my=\"left top\" at=\"left bottom\">\n" +
            "                <p:menuitem value=\"Add New\" ajax=\"false\" icon=\"pi pi-fw pi-plus\"/>\n" +
            "                <p:menuitem value=\"Remove\" ajax=\"false\" icon=\"pi pi-fw pi-minus\"/>\n" +
            "            </p:menu>\n" +
            "        </div>\n" +
            "        \n" +
            "    </div>\n" +
            "    <ul class=\"list-none p-0 m-0\">\n" +
            "        <li class=\"flex flex-column sm:flex-row sm:justify-content-between sm:align-items-center mb-5\">\n" +
            "            <div class=\"flex align-items-center\">\n" +
            "                <span class=\"block mr-3 surface-200 border-radius: 10px inline-flex justify-content-center align-items-center\" style=\"width:58px; height: 58px; border-radius: 10px\">\n" +
            "                    <p:graphicImage name=\"images/blocks/logos/logo-pwd.png\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 30px; height: 30px;\"/>\n" +
            "                </span>\n" +
            "                <div>\n" +
            "                    <div class=\"text-900 font-medium text-xl mb-2\">1Password</div>\n" +
            "                    <div class=\"flex align-items-center\">\n" +
            "                        <i class=\"pi pi-apple text-600 mr-2\"></i>\n" +
            "                        <span class=\"text-600\">App Store</span>\n" +
            "                        <span class=\"inline-flex p-1 bg-green-100 text-green-600 font-medium text-sm border-round ml-3\">$12.24</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"sm:text-right mt-3 md:mt-0\">\n" +
            "                <p:rating value=\"3\" readonly=\"true\"/>\n" +
            "                <div class=\"text-sm text-600 mt-2\">10K Reviews</div>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex flex-column sm:flex-row sm:justify-content-between sm:align-items-center mb-5\">\n" +
            "            <div class=\"flex align-items-center\">\n" +
            "                <span class=\"block mr-3 surface-200 border-radius: 10px inline-flex justify-content-center align-items-center\" style=\"width:58px; height: 58px; border-radius: 10px\">\n" +
            "                    <p:graphicImage name=\"images/blocks/logos/logo-evernote.png\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 30px; height: 30px;\"/>\n" +
            "                </span>\n" +
            "                <div>\n" +
            "                    <div class=\"text-900 font-medium text-xl mb-2\">Evernote</div>\n" +
            "                    <div class=\"flex align-items-center\">\n" +
            "                        <i class=\"pi pi-apple text-600 mr-2\"></i>\n" +
            "                        <span class=\"text-600\">App Store</span>\n" +
            "                        <span class=\"inline-flex p-1 bg-green-100 text-green-600 font-medium text-sm border-round ml-3\">$20.00</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"sm:text-right mt-3 md:mt-0\">\n" +
            "                <p:rating value=\"2\" readonly=\"true\"/>\n" +
            "                <div class=\"text-sm text-600 mt-2\">2K Reviews</div>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex flex-column sm:flex-row sm:justify-content-between sm:align-items-center mb-5\">\n" +
            "            <div class=\"flex align-items-center\">\n" +
            "                <span class=\"block mr-3 surface-200 border-radius: 10px inline-flex justify-content-center align-items-center\" style=\"width:58px; height: 58px; border-radius: 10px\">\n" +
            "                    <p:graphicImage name=\"images/blocks/logos/logo-dropbox.png\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 30px; height: 30px;\"/>\n" +
            "                </span>\n" +
            "                <div>\n" +
            "                    <div class=\"text-900 font-medium text-xl mb-2\">Dropbox</div>\n" +
            "                    <div class=\"flex align-items-center\">\n" +
            "                        <i class=\"pi pi-microsoft text-600 mr-2\"></i>\n" +
            "                        <span class=\"text-600\">Microsoft Store</span>\n" +
            "                        <span class=\"inline-flex p-1 bg-green-100 text-green-600 font-medium text-sm border-round ml-3\">$9.50</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"sm:text-right mt-3 md:mt-0\">\n" +
            "                <p:rating value=\"4\" readonly=\"true\"/>\n" +
            "                <div class=\"text-sm text-600 mt-2\">3K Reviews</div>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex flex-column sm:flex-row sm:justify-content-between sm:align-items-center mb-5\">\n" +
            "            <div class=\"flex align-items-center\">\n" +
            "                <span class=\"block mr-3 surface-200 border-radius: 10px inline-flex justify-content-center align-items-center\" style=\"width:58px; height: 58px; border-radius: 10px\">\n" +
            "                    <p:graphicImage name=\"images/blocks/logos/logo-slack.png\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 30px; height: 30px;\"/>\n" +
            "                </span>\n" +
            "                <div>\n" +
            "                    <div class=\"text-900 font-medium text-xl mb-2\">Slack</div>\n" +
            "                    <div class=\"flex align-items-center\">\n" +
            "                        <i class=\"pi pi-microsoft text-600 mr-2\"></i>\n" +
            "                        <span class=\"text-600\">Microsoft Store</span>\n" +
            "                        <span class=\"inline-flex p-1 bg-purple-100 text-purple-600 font-medium text-sm border-round ml-3\">FREE</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"sm:text-right mt-3 md:mt-0\">\n" +
            "                <p:rating value=\"3\" readonly=\"true\"/>\n" +
            "                <div class=\"text-sm text-600 mt-2\">5K Reviews</div>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex flex-column sm:flex-row sm:justify-content-between sm:align-items-center\">\n" +
            "            <div class=\"flex align-items-center\">\n" +
            "                <span class=\"block mr-3 surface-200 border-radius: 10px inline-flex justify-content-center align-items-center\" style=\"width:58px; height: 58px; border-radius: 10px\">\n" +
            "                    <p:graphicImage name=\"images/blocks/logos/logo-spotify.png\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 30px; height: 30px;\"/>\n" +
            "                </span>\n" +
            "                <div>\n" +
            "                    <div class=\"text-900 font-medium text-xl mb-2\">Spotify</div>\n" +
            "                    <div class=\"flex align-items-center\">\n" +
            "                        <i class=\"pi pi-google text-600 mr-2\"></i>\n" +
            "                        <span class=\"text-600\">Play Store</span>\n" +
            "                        <span class=\"inline-flex p-1 bg-green-100 text-green-600 font-medium text-sm border-round ml-3\">$19.90</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"sm:text-right mt-3 md:mt-0\">\n" +
            "                <p:rating value=\"3\" readonly=\"true\"/>\n" +
            "                <div class=\"text-sm text-600 mt-2\">5K Reviews</div>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "</div>\n" ;

    private final String block6 = "<div class=\"surface-card shadow-2 border-round p-4\">\n" +
            "    <div class=\"flex justify-content-between align-items-center mb-5\">\n" +
            "        <span class=\"text-xl text-900 font-medium\">Browsers</span>\n" +
            "        <div>\n" +
            "            <p:commandButton id=\"toggleButton\" type=\"button\" icon=\"pi pi-ellipsis-v\" styleClass=\"ui-button-flat ui-button-plain rounded-button\"/>\n" +
            "            <p:menu overlay=\"true\" trigger=\"toggleButton\" my=\"left top\" at=\"left bottom\">\n" +
            "                <p:menuitem value=\"Add New\" ajax=\"false\" icon=\"pi pi-fw pi-plus\"/>\n" +
            "                <p:menuitem value=\"Remove\" ajax=\"false\" icon=\"pi pi-fw pi-minus\"/>\n" +
            "            </p:menu>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <ul class=\"list-none p-0 m-0\">\n" +
            "        <li class=\"mb-4 border-bottom-1 surface-border py-3 flex flex-column md:flex-row md:align-items-center md:justify-content-between\">\n" +
            "            <div class=\"inline-flex align-items-center\">\n" +
            "                <p:graphicImage name=\"images/blocks/logos/chrome.svg\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 32px; height: 32px\" styleClass=\"mr-3\"/>\n" +
            "                <span class=\"text-900 font-medium\">Chrome</span>\n" +
            "            </div>\n" +
            "            <div class=\"flex align-items-center mt-3 md:mt-3\">\n" +
            "                <span class=\"text-900 font-medium mr-3 text-xl\">%70</span>\n" +
            "                <p:knob value=\"70\" showLabel=\"false\" foregroundColor=\"orange\" height=\"50\" width=\"50\" disabled=\"true\"/>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"mb-4 border-bottom-1 surface-border py-3 flex flex-column md:flex-row md:align-items-center md:justify-content-between\">\n" +
            "            <div class=\"inline-flex align-items-center\">\n" +
            "                <p:graphicImage name=\"images/blocks/logos/firefox.svg\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 32px; height: 32px\" styleClass=\"mr-3\"/>\n" +
            "                <span class=\"text-900 font-medium\">Firefox</span>\n" +
            "            </div>\n" +
            "            <div class=\"flex align-items-center mt-3 md:mt-3\">\n" +
            "                <span class=\"text-900 font-medium mr-3 text-xl\">%40</span>\n" +
            "                <p:knob value=\"40\" showLabel=\"false\" height=\"50\" width=\"50\"  disabled=\"true\"/>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"mb-4 border-bottom-1 surface-border py-3 flex flex-column md:flex-row md:align-items-center md:justify-content-between\">\n" +
            "            <div class=\"inline-flex align-items-center\">\n" +
            "                <p:graphicImage name=\"images/blocks/logos/safari.svg\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 32px; height: 32px\" styleClass=\"mr-3\"/>\n" +
            "                <span class=\"text-900 font-medium\">Safari</span>\n" +
            "            </div>\n" +
            "            <div class=\"flex align-items-center mt-3 md:mt-3\">\n" +
            "                <span class=\"text-900 font-medium mr-3 text-xl\">%20</span>\n" +
            "                <p:knob value=\"20\" showLabel=\"false\" height=\"50\" width=\"50\"  disabled=\"true\"/>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"mb-4 border-bottom-1 surface-border py-3 flex flex-column md:flex-row md:align-items-center md:justify-content-between\">\n" +
            "            <div class=\"inline-flex align-items-center\">\n" +
            "                <p:graphicImage name=\"images/blocks/logos/opera.svg\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 32px; height: 32px\" styleClass=\"mr-3\"/>\n" +
            "                <span class=\"text-900 font-medium\">Opera</span>\n" +
            "            </div>\n" +
            "            <div class=\"flex align-items-center mt-3 md:mt-3\">\n" +
            "                <span class=\"text-900 font-medium mr-3 text-xl\">%10</span>\n" +
            "                <p:knob value=\"10\" showLabel=\"false\" height=\"50\" width=\"50\"  disabled=\"true\"/>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"mb-4 border-bottom-1 surface-border py-3 flex flex-column md:flex-row md:align-items-center md:justify-content-between\">\n" +
            "            <div class=\"inline-flex align-items-center\">\n" +
            "                <p:graphicImage name=\"images/blocks/logos/edge.svg\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 32px; height: 32px\" styleClass=\"mr-3\"/>\n" +
            "                <span class=\"text-900 font-medium\">Edge</span>\n" +
            "            </div>\n" +
            "            <div class=\"flex align-items-center mt-3 md:mt-3\">\n" +
            "                <span class=\"text-900 font-medium mr-3 text-xl\">%8</span>\n" +
            "                <p:knob value=\"8\" showLabel=\"false\" height=\"50\" width=\"50\"  disabled=\"true\"/>\n" +
            "            </div>\n" +
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

    public String getBlock6() {
        return block6;
    }

}
