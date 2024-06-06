package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class SectionHeadingView implements Serializable {

    private final String block1 = "<div class=\"surface-section\">\n" +
            "    <div class=\"flex md:align-items-center md:justify-content-between flex-column md:flex-row pb-4 border-bottom-1 surface-border\">\n" +
            "        <div class=\"flex align-items-center\">\n" +
            "            <i class=\"pi pi-inbox text-2xl mr-3 text-500\"/>\n" +
            "            <span class=\"text-3xl font-medium text-900\">Messages</span>\n" +
            "        </div>\n" +
            "        <div class=\"mt-3 md:mt-0\">\n" +
            "            <p:commandButton type=\"button\" value=\"Settings\" styleClass=\"ui-button-outlined mr-3\"\n" +
            "                             icon=\"pi pi-cog\"/>\n" +
            "            <p:commandButton type=\"button\" value=\"Compose\" icon=\"pi pi-plus\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;
    
    private final String block2 = "<div class=\"surface-section\">\n" +
            "    <div class=\"flex md:align-items-center md:justify-content-between flex-column md:flex-row pb-4 border-bottom-1 surface-border\">\n" +
            "        <div class=\"mb-3 lg:mb-0\">\n" +
            "            <div class=\"text-3xl font-medium text-900 mb-3\">Messages</div>\n" +
            "            <div class=\"text-500 mr-0 md:mr-3\">Vivamus id nisl interdum, blandit augue sit amet, eleifend mi.</div>\n" +
            "        </div>\n" +
            "        <span class=\"ui-input-icon-left w-full md:w-auto\">\n" +
            "            <i class=\"pi pi-search\"/>\n" +
            "            <p:inputText placeholder=\"Search\" styleClass=\"w-full md:w-auto\"/>\n" +
            "        </span>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block3 = "<div class=\"surface-section\">\n" +
            "    <div class=\"text-3xl font-medium text-900 mb-4\">Application</div>\n" +
            "    <p:tabMenu activeIndex=\"#{param.i}\">\n" +
            "        <p:menuitem value=\"Overview\" icon=\"pi pi-home\">\n" +
            "            <f:param name=\"i\" value=\"0\" ajax=\"false\" />\n" +
            "        </p:menuitem>\n" +
            "        <p:menuitem value=\"Members\" icon=\"pi pi-users\">\n" +
            "            <f:param name=\"i\" value=\"1\" ajax=\"false\"/>\n" +
            "        </p:menuitem>\n" +
            "        <p:menuitem value=\"Sales\" icon=\"pi pi-shopping-cart\">\n" +
            "            <f:param name=\"i\" value=\"2\" ajax=\"false\"/>\n" +
            "        </p:menuitem>\n" +
            "        <p:menuitem value=\"Profile\" icon=\"pi pi-user\">\n" +
            "            <f:param name=\"i\" value=\"3\" ajax=\"false\"/>\n" +
            "        </p:menuitem>\n" +
            "        <p:menuitem value=\"Settings\" icon=\"pi pi-cog\">\n" +
            "            <f:param name=\"i\" value=\"4\" ajax=\"false\"/>\n" +
            "        </p:menuitem>\n" +
            "    </p:tabMenu>\n" +
            "</div>" ;

    private final String block4 = "<div class=\"surface-section\">\n" +
            "    <div class=\"flex lg:align-items-center flex-column lg:flex-row\">\n" +
            "        <div class=\"text-3xl font-medium text-900 mr-0 lg:mr-4 mb-4 lg:mb-0\">Application</div>\n" +
            "        <p:tabMenu activeIndex=\"#{param.j}\" styleClass=\"flex-grow-1\">\n" +
            "            <p:menuitem value=\"Overview\" icon=\"pi pi-home\">\n" +
            "                <f:param name=\"j\" value=\"0\" ajax=\"false\"/>\n" +
            "            </p:menuitem>\n" +
            "            <p:menuitem value=\"Members\" icon=\"pi pi-users\">\n" +
            "                <f:param name=\"j\" value=\"1\" ajax=\"false\"/>\n" +
            "            </p:menuitem>\n" +
            "            <p:menuitem value=\"Sales\" icon=\"pi pi-shopping-cart\">\n" +
            "                <f:param name=\"j\" value=\"2\" ajax=\"false\"/>\n" +
            "            </p:menuitem>\n" +
            "            <p:menuitem value=\"Profile\" icon=\"pi pi-user\">\n" +
            "                <f:param name=\"j\" value=\"3\" ajax=\"false\"/>\n" +
            "            </p:menuitem>\n" +
            "            <p:menuitem value=\"Settings\" icon=\"pi pi-cog\">\n" +
            "                <f:param name=\"j\" value=\"4\" ajax=\"false\"/>\n" +
            "            </p:menuitem>\n" +
            "        </p:tabMenu>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block5 = "<div class=\"surface-section\">\n" +
            "    <div class=\"border-bottom-1 surface-border\">\n" +
            "        <span class=\"block text-3xl font-medium text-900 mb-4\">Messages</span>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block6 = "<div class=\"surface-section\">\n" +
            "    <div class=\"border-bottom-1 surface-border\">\n" +
            "        <div class=\"text-3xl font-medium text-900 mb-4 flex align-items-center\">Messages <span class=\"text-base font-normal ml-3 text-600\">79 Unread</span></div>\n" +
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
