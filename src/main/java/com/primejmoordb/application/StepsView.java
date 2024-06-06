package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class StepsView implements Serializable {

    private final String block1 = "<ul class=\"list-none p-0 m-0 flex flex-column md:flex-row\">\n" +
            "    <li class=\"relative mr-0 md:mr-8 flex-auto\">\n" +
            "        <div class=\"border-1 border-300 border-round p-3 surface-card flex flex-column md:flex-row align-items-center z-1\">\n" +
            "            <i class=\"pi pi-check-circle text-green-500 text-2xl md:text-4xl mb-2 md:mb-0 mr-0 md:mr-3\"/>\n" +
            "            <div>\n" +
            "                <div class=\"text-900 font-medium mb-1\">Seat</div>\n" +
            "                <span class=\"text-600 text-sm hidden md:block\">Tempus iaculis urna id volutpat</span>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"w-full absolute top-50 left-100 surface-300 hidden md:block\"\n" +
            "             style=\"transform: translateY(-50%); height: 2px\"></div>\n" +
            "    </li>\n" +
            "    <li class=\"relative mr-0 md:mr-8 flex-auto\">\n" +
            "        <div class=\"border-2 border-blue-500 border-round p-3 surface-card flex flex-column md:flex-row align-items-center z-1\">\n" +
            "            <i class=\"pi pi-credit-card text-blue-600 text-2xl md:text-4xl mb-2 md:mb-0 mr-0 md:mr-3\"/>\n" +
            "            <div>\n" +
            "                <div class=\"text-blue-600 font-medium mb-1\">Payment</div>\n" +
            "                <span class=\"text-600 text-sm hidden md:block\">Nisi vitae suscipit tellus</span>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"w-full absolute top-50 left-100 surface-300 hidden md:block\"\n" +
            "             style=\"transform: translateY(-50%); height: 2px\"></div>\n" +
            "    </li>\n" +
            "    <li class=\"relative flex-auto\">\n" +
            "        <div class=\"border-1 border-300 border-round p-3 surface-50 flex flex-column md:flex-row align-items-center z-1\">\n" +
            "            <i class=\"pi pi-check-circle text-600 text-2xl md:text-4xl mb-2 md:mb-0 mr-0 md:mr-3\"/>\n" +
            "            <div>\n" +
            "                <div class=\"text-900 font-medium mb-1\">Confirmation</div>\n" +
            "                <span class=\"text-600 text-sm hidden md:block\">Sit amet est placerat in egestas erat</span>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </li>\n" +
            "</ul>" ;
    
    private final String block2 = "<ul class=\"list-none p-0 m-0 surface-0\">\n" +
            "    <li class=\"p-3 mb-2 flex\">\n" +
            "        <div class=\"flex flex-column align-items-center\" style=\"width:2rem\">\n" +
            "            <span class=\"bg-green-500 text-0 flex align-items-center justify-content-center border-circle\"\n" +
            "                  style=\"min-width:2rem; min-height: 2rem\">\n" +
            "                <i class=\"pi pi-check\"/>\n" +
            "            </span>\n" +
            "            <div class=\"h-full surface-300\" style=\"width: 2px; min-height: 4rem\"></div>\n" +
            "        </div>\n" +
            "        <div class=\"ml-3\">\n" +
            "            <div class=\"font-medium text-900 mb-2\">Seat</div>\n" +
            "            <span class=\"line-height-3 text-700\">Tempus iaculis urna id volutpat.</span>\n" +
            "        </div>\n" +
            "    </li>\n" +
            "\n" +
            "    <li class=\"p-3 mb-2 flex\">\n" +
            "        <div class=\"flex flex-column align-items-center\" style=\"width:2rem\">\n" +
            "            <span class=\"surface-0 text-blue-500 border-blue-500 border-2 border-circle flex align-items-center justify-content-center border-circle\"\n" +
            "                  style=\"min-width:2rem; min-height: 2rem\">\n" +
            "                2\n" +
            "            </span>\n" +
            "            <div class=\"h-full bg-blue-500\" style=\"width: 2px; min-height: 4rem\"></div>\n" +
            "        </div>\n" +
            "        <div class=\"ml-3\">\n" +
            "            <div class=\"font-medium text-blue-500 mb-2\">Payment</div>\n" +
            "            <span class=\"line-height-3 text-700\">Tempus iaculis urna id volutpat.</span>\n" +
            "        </div>\n" +
            "    </li>\n" +
            "\n" +
            "    <li class=\"p-3 flex\">\n" +
            "        <div class=\"flex flex-column align-items-center\" style=\"width:2rem\">\n" +
            "            <span class=\"surface-0 text-300 border-2 border-circle flex align-items-center justify-content-center border-circle\"\n" +
            "                  style=\"min-width:2rem; min-height: 2rem\">\n" +
            "                3\n" +
            "            </span>\n" +
            "            <div class=\"h-full surface-300\" style=\"width: 2px; min-height: 4rem\"></div>\n" +
            "        </div>\n" +
            "        <div class=\"ml-3\">\n" +
            "            <div class=\"font-medium text-600 mb-2\">Confirmation</div>\n" +
            "            <span class=\"line-height-3 text-500\">Sit amet est placerat in egestas erat.</span>\n" +
            "        </div>\n" +
            "    </li>\n" +
            "</ul>" ;

    private final String block3 = "<div class=\"flex flex-column lg:flex-row surface-card shadow-2 border-round\">\n" +
            "    <div class=\"flex-grow-1 border-left-2 lg:border-bottom-2 lg:border-left-none border-blue-500\">\n" +
            "        <div class=\"flex align-items-start p-4 border-bottom-1 lg:border-right-1 lg:border-bottom-none surface-border\">\n" +
            "            <i class=\"text-2xl pi pi-id-card text-900 mr-3\"></i>\n" +
            "            <div class=\"flex flex-column\">\n" +
            "                <span class=\"text-900 font-medium text-xl mb-1 line-height-1\">Personal</span>\n" +
            "                <span class=\"text-600 line-height-3\">Fanes ac turpis</span>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"flex-grow-1 border-left-2 lg:border-bottom-2 lg:border-left-none border-blue-500\">\n" +
            "        <div class=\"flex align-items-start p-4 border-bottom-1 lg:border-right-1 lg:border-bottom-none surface-border\">\n" +
            "            <i class=\"text-2xl pi pi-th-large text-900 mr-3\"></i>\n" +
            "            <div class=\"flex flex-column\">\n" +
            "                <span class=\"text-900 font-medium text-xl mb-1 line-height-1\">Seat</span>\n" +
            "                <span class=\"text-600 line-height-3\">Lorem ipsum dolor</span>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"flex-grow-1 border-left-2 lg:border-bottom-2 lg:border-left-none border-transparent\">\n" +
            "        <div class=\"flex align-items-start p-4 border-bottom-1 lg:border-right-1 lg:border-bottom-none surface-border\">\n" +
            "            <i class=\"text-2xl pi pi-credit-card text-900 mr-3\"></i>\n" +
            "            <div class=\"flex flex-column\">\n" +
            "                <span class=\"text-900 font-medium text-xl mb-1 line-height-1\">Payment</span>\n" +
            "                <span class=\"text-600 line-height-3\">Consectetur adipisicing elit</span>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"flex-grow-1 border-left-2 lg:border-bottom-2 lg:border-left-none border-transparent opacity-50\">\n" +
            "        <div class=\"flex align-items-start p-4\">\n" +
            "            <i class=\"text-2xl pi pi-check-circle text-900 mr-3\"></i>\n" +
            "            <div class=\"flex flex-column\">\n" +
            "                <span class=\"text-900 font-medium text-xl mb-1 line-height-1\">Confirmation</span>\n" +
            "                <span class=\"text-600 line-height-3\">Debitis animi nulla</span>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;


    private final String block4 = "<div class=\"flex align-items-center\">\n" +
            "    <div>\n" +
            "        <p:commandButton type=\"button\" icon=\"pi pi-arrow-left\" styleClass=\"ui-button-outlined ui-button-plain rounded-button\" />\n" +
            "    </div>\n" +
            "    <span class=\"font-medium text-600 text-xl mx-3\">1</span>\n" +
            "    <div class=\"flex-grow-1\">\n" +
            "        <p:progressBar id=\"progressBarClient\" value=\"50\"/>\n" +
            "    </div>\n" +
            "    <span class=\"font-medium text-600 text-xl mx-3\">6</span>\n" +
            "    <div>\n" +
            "        <p:commandButton type=\"button\" icon=\"pi pi-arrow-right\" styleClass=\"ui-button-outlined ui-button-plain rounded-button\" />\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block5 = "<div class=\"surface-card p-4 border-round shadow-2\">\n" +
            "    <div class=\"text-900 font-medium text-xl mb-3\">Registration</div>\n" +
            "    <p class=\"text-600 my-0 mb-4 pb-3 border-bottom-1 surface-border\">1 of 5 steps are already complete</p>\n" +
            "    <div class=\"grid mb-3\">\n" +
            "        <div class=\"col-12 lg:col-6\">\n" +
            "            <ul class=\"list-none mx-0 mb-0 mt-4 p-0\">\n" +
            "                <li class=\"flex align-items-center p-3\">\n" +
            "                    <span class=\"inline-flex mr-3 align-items-center justify-content-center bg-green-500 text-white border-circle border-1 surface-border\" style=\"width:30px;height:30px\">\n" +
            "                        <i class=\"pi pi-check\"></i>\n" +
            "                    </span>\n" +
            "                    <span class=\"text-900 line-height-3\">In tellus integer feugiat scelerisque</span>\n" +
            "                </li>\n" +
            "                <li class=\"flex align-items-center surface-100 p-3\">\n" +
            "                    <span class=\"inline-flex mr-3 align-items-center justify-content-center surface-0 text-white border-circle border-1 surface-border\" style=\"width:30px;height:30px\"></span>\n" +
            "                    <span class=\"text-900 line-height-3\">Risus pretium quam vulputate</span>\n" +
            "                </li>\n" +
            "                <li class=\"flex align-items-center surface-100 p-3\">\n" +
            "                    <span class=\"inline-flex mr-3 align-items-center justify-content-center surface-0 text-white border-circle border-1 surface-border\" style=\"width:30px;height:30px\"></span>\n" +
            "                    <span class=\"text-900 line-height-3\">Sem viverra aliquet eget sit amet tellus</span>\n" +
            "                </li>\n" +
            "                <li class=\"flex align-items-center surface-100 p-3\">\n" +
            "                    <span class=\"inline-flex mr-3 align-items-center justify-content-center surface-0 text-white border-circle border-1 surface-border\" style=\"width:30px;height:30px\"></span>\n" +
            "                    <span class=\"text-900 line-height-3\">Blandit volutpat maecenas volutpat blandit</span>\n" +
            "                </li>\n" +
            "                <li class=\"flex align-items-center surface-100 p-3\">\n" +
            "                    <span class=\"inline-flex mr-3 align-items-center justify-content-center surface-0 text-white border-circle border-1 surface-border\" style=\"width:30px;height:30px\"></span>\n" +
            "                    <span class=\"text-900 line-height-3\">Feugiat in ante metus dictum</span>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 lg:col-6\">\n" +
            "            <div class=\"border-2 border-dashed surface-border border-round mt-4\" style=\"min-height: 30rem\">\n" +
            "\n" +
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
}
