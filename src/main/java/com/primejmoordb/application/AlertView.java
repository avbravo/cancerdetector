package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class AlertView implements Serializable {

    private final String block1 = "<div class=\"flex align-items-start p-4 bg-green-100 border-round border-1 border-green-300\">\n" +
            "    <i class=\"pi pi-check-circle text-green-900 text-2xl mr-3\"/>\n" +
            "    <div class=\"mr-3\">\n" +
            "        <div class=\"text-green-900 font-medium text-xl mb-2 line-height-1\">Success</div>\n" +
            "        <p class=\"m-0 p-0 text-green-700 line-height-3\">Quis commodo odio aenean sed adipiscing diam. Bibendum enim facilisis gravida neque convallis a cras semper.</p>\n" +
            "    </div>\n" +
            "    <div class=\"ml-auto\">\n" +
            "        <a class=\"inline-flex align-items-center justify-content-center ml-auto border-circle hover:bg-green-50 no-underline cursor-pointer transition-colors transition-duration-150\"\n" +
            "           style=\"width:1.5rem;height:1.5rem\">\n" +
            "            <i class=\"pi pi-times text-green-900\"/>\n" +
            "        </a>\n" +
            "    </div>\n" +
            "</div>";

    private final String block2 = "<div class=\"flex align-items-start p-4 bg-yellow-100 border-round border-1 border-yellow-300\">\n" +
            "    <i class=\"pi pi-check-circle text-yellow-900 text-2xl mr-3\"/>\n" +
            "    <div class=\"mr-3\">\n" +
            "        <div class=\"text-yellow-900 font-medium text-xl mb-2 line-height-1\">Attention</div>\n" +
            "        <p class=\"m-0 p-0 text-yellow-700 mb-3 line-height-3\">Quis commodo odio aenean sed adipiscing diam. Bibendum enim facilisis gravida neque convallis a cras semper.</p>\n" +
            "        <a class=\"font-medium text-yellow-900 mr-4 no-underline cursor-pointer\">Accept</a>\n" +
            "        <a class=\"font-medium text-yellow-900 no-underline cursor-pointer\">Decline</a>\n" +
            "    </div>\n" +
            "    <div class=\"ml-auto\">\n" +
            "        <a class=\"inline-flex align-items-center justify-content-center ml-auto border-circle hover:bg-yellow-50 no-underline cursor-pointer transition-colors transition-duration-150\"\n" +
            "           style=\"width:1.5rem;height:1.5rem\">\n" +
            "            <i class=\"pi pi-times text-yellow-900\"/>\n" +
            "        </a>\n" +
            "    </div>\n" +
            "</div>";

    private final String block3 = "<div class=\"flex lg:align-items-start flex-column lg:flex-row p-4 bg-blue-100 border-round border-1 border-blue-300\">\n" +
            "    <div class=\"flex align-items-start\">\n" +
            "        <i class=\"pi pi-check-circle text-blue-900 text-2xl mr-3\"/>\n" +
            "        <div class=\"mr-3 flex lg:align-items-start flex-column lg:flex-row\">\n" +
            "            <div class=\"text-blue-900 font-medium mr-0 lg:mr-2 mb-2 lg:mb-0 line-height-3\">Information</div>\n" +
            "            <p class=\"m-0 p-0 text-blue-700 line-height-3\">Quis commodo odio aenean sed adipiscing diam. Bibendum enim facilisis gravida neque convallis a cras semper.</p>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <a class=\"flex align-items-center ml-auto no-underline text-blue-900 font-medium mt-3 lg:mt-0 cursor-pointer\">\n" +
            "        <span class=\"white-space-nowrap\">Learn More</span>\n" +
            "        <i class=\"pi pi-arrow-right text-blue-900 ml-2\"/>\n" +
            "    </a>\n" +
            "</div>";

    private final String block4 = "<div class=\"flex align-items-start p-4 bg-pink-100 border-round border-1 border-pink-300\">\n" +
            "    <i class=\"pi pi-times-circle text-pink-900 text-2xl mr-3\"></i>\n" +
            "    <div class=\"mr-3\">\n" +
            "        <div class=\"text-pink-900 font-medium text-xl mb-3 line-height-1\">Validation Errors</div>\n" +
            "        <ul class=\"m-0 p-0 text-pink-700 ml-3\">\n" +
            "            <li class=\"p-1\">Quis commodo odio aenean sed adipiscing diam.</li>\n" +
            "            <li class=\"p-1\">Risus pretium quam vulputate dignissim suspendisse.</li>\n" +
            "            <li class=\"p-1\">Bibendum enim facilisis gravida neque convallis a cras semper.</li>\n" +
            "        </ul>\n" +
            "    </div>\n" +
            "    <div class=\"ml-auto\">\n" +
            "        <a class=\"inline-flex align-items-center justify-content-center ml-auto border-circle hover:bg-pink-50 no-underline cursor-pointer transition-colors transition-duration-150\" style=\"width:1.5rem;height:1.5rem\">\n" +
            "            <i class=\"pi pi-times text-pink-900\"></i>\n" +
            "        </a>\n" +
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
}
