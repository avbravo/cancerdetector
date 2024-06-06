package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ActionPanelView implements Serializable {

    private final String block1 = "<div class=\"surface-card border-round shadow-2 p-4\">\n" +
            "    <div class=\"text-900 font-medium mb-3 text-xl\">Title Placeholder</div>\n" +
            "    <p class=\"mt-0 mb-4 p-0 line-height-3\">Nunc mi ipsum faucibus vitae aliquet nec. Lacus sed viverra tellus in hac habitasse platea dictumst.</p>\n" +
            "    <p:commandButton type=\"button\" value=\"Save Changes\"/>\n" +
            "</div>";

    private final String block2 = "<div class=\"surface-card border-round shadow-2 p-4 flex flex-column lg:flex-row align-items-start\">\n" +
            "    <div>\n" +
            "        <div class=\"text-900 font-medium mb-3 text-xl\">Title Placeholder</div>\n" +
            "        <p class=\"mt-0 mb-4 lg:mb-0 p-0 line-height-3\">Nunc mi ipsum faucibus vitae aliquet nec. Lacus sed viverra tellus in hac habitasse platea dictumst.</p>\n" +
            "    </div>\n" +
            "    <p:commandButton type=\"button\" value=\"Save\" icon=\"pi pi-check ml-2\" styleClass=\"ml-0 lg:ml-5 pl-2\"/>\n" +
            "</div>";

    private final String block3 = "<div class=\"surface-card border-round shadow-2 p-4\">\n" +
            "    <div class=\"text-900 font-medium mb-3 text-xl\">Title Placeholder</div>\n" +
            "    <p class=\"mt-0 mb-4 p-0 line-height-3\">Nunc mi ipsum faucibus vitae aliquet nec. Lacus sed viverra tellus in hac habitasse platea dictumst.</p>\n" +
            "    <div class=\"flex mb-4 flex-column lg:flex-row\">\n" +
            "        <div class=\"surface-50 p-3 flex-auto\">\n" +
            "            <div class=\"text-600 mb-3\">Guests</div>\n" +
            "            <span class=\"text-blue-600 font-medium text-xl\">4</span>\n" +
            "        </div>\n" +
            "        <div class=\"surface-50 p-3 flex-auto mx-0 my-3 lg:my-0 lg:mx-3\">\n" +
            "            <div class=\"text-600 mb-3\">Date</div>\n" +
            "            <span class=\"text-blue-600 font-medium text-xl\">24/05/2021</span>\n" +
            "        </div>\n" +
            "        <div class=\"surface-50 p-3 flex-auto\">\n" +
            "            <div class=\"text-600 mb-3\">Time</div>\n" +
            "            <span class=\"text-blue-600 font-medium text-xl\">14:30</span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <p:commandButton type=\"button\" value=\"Save Changes\"/>\n" +
            "</div>";

    private final String block4 = "<div class=\"surface-card border-round shadow-2 p-4\">\n" +
            "    <div class=\"text-900 font-medium mb-3 text-xl\">Change Phone</div>\n" +
            "    <p class=\"mt-0 mb-4 p-0 line-height-3\">Nunc mi ipsum faucibus vitae aliquet nec.</p>\n" +
            "    <div class=\"flex\">\n" +
            "        <p:inputText styleClass=\"flex-auto mr-3\"/>\n" +
            "        <p:commandButton type=\"button\" value=\"Update\"/>\n" +
            "    </div>\n" +
            "</div>";

    private final String block5 = "<div class=\"surface-card border-round shadow-2 p-4 text-center\">\n" +
            "    <p:graphicImage name=\"images/blocks/illustration/subscribe.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                    styleClass=\"mx-auto block mb-4\"/>\n" +
            "    <div class=\"text-900 font-medium mb-3 text-xl\">Title Placeholder</div>\n" +
            "    <p class=\"mt-0 mb-4 p-0 line-height-3\">Nunc mi ipsum faucibus vitae aliquet nec. Lacus sed viverra tellus in hac habitasse platea dictumst.</p>\n" +
            "    <p:commandButton type=\"button\" value=\"Learn More\" icon=\"pi pi-arrow-right mr-2\"\n" +
            "                     styleClass=\"rounded-button pr-2\" iconPos=\"right\"/>\n" +
            "</div>";

    private final String block6 = "<div class=\"surface-card border-round flex shadow-2\">\n" +
            "    <div class=\"bg-blue-50 flex align-items-center justify-content-center py-3 px-5\">\n" +
            "        <p:graphicImage name=\"images/blocks/illustration/live-collaboration.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                    styleClass=\"mx-auto block mb-4 w-full\"/>\n" +
            "    </div>\n" +
            "    <div class=\"py-3 px-5 flex flex-column align-items-start\">\n" +
            "        <div class=\"text-900 font-medium mb-3 text-xl\">Title Placeholder</div>\n" +
            "        <p class=\"mt-0 mb-4 p-0 line-height-3\">Nunc mi ipsum faucibus vitae aliquet nec.</p>\n" +
            "        <p:commandButton type=\"button\" value=\"Proceed\" styleClass=\"mt-auto\" iconPos=\"right\"/>\n" +
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
}
