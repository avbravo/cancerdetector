package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class DialogView implements Serializable {

    private final String block1 = "<p:commandButton value=\"Display\" type=\"button\" onclick=\"PF('dlg1').show()\"/>\n" +
            "\n" +
            "<p:dialog widgetVar=\"dlg1\" modal=\"true\" width=\"40vw\" responsive=\"true\" closable=\"false\">\n" +
            "    <f:facet name=\"header\">\n" +
            "        <div class=\"flex align-items-center\">\n" +
            "            <span class=\"flex align-items-center justify-content-center bg-cyan-100 text-cyan-800 mr-3 border-circle\"\n" +
            "                  style=\"width:32px;height:32px\">\n" +
            "              <i class=\"pi pi-info text-lg\"/>\n" +
            "            </span>\n" +
            "            <span class=\"font-medium text-2xl text-900\">Modal Title Placeholder</span>\n" +
            "        </div>\n" +
            "    </f:facet>\n" +
            "\n" +
            "    <p class=\"line-height-3 p-0 m-0\">\n" +
            "        Sagittis eu volutpat odio facilisis mauris sit amet. Sed velit dignissim sodales ut eu sem integer.\n" +
            "        Sed risus pretium quam vulputate. At tellus at urna condimentum mattis pellentesque.\n" +
            "    </p>\n" +
            "\n" +
            "    <f:facet name=\"footer\">\n" +
            "        <p:commandButton type=\"button\" value=\"Cancel\" icon=\"pi pi-times\" onclick=\"PF('dlg1').hide()\"\n" +
            "                         styleClass=\"ui-button-flat\"/>\n" +
            "        <p:commandButton type=\"button\" value=\"Save\" icon=\"pi pi-check\" onclick=\"PF('dlg1').hide()\"/>\n" +
            "    </f:facet>\n" +
            "</p:dialog>" ;
    
    private final String block2 = "<p:commandButton value=\"Display\" type=\"button\" onclick=\"PF('dlg2').show()\"/>\n" +
            "\n" +
            "<p:dialog widgetVar=\"dlg2\" modal=\"true\" width=\"40vw\" responsive=\"true\" closable=\"false\" showHeader=\"false\">\n" +
            "    <div class=\"flex flex-column align-items-center my-4\">\n" +
            "        <span class=\"flex align-items-center justify-content-center bg-cyan-100 text-cyan-800 mr-3 border-circle mb-3\"\n" +
            "              style=\"width:64px;height:64px\">\n" +
            "            <i class=\"pi pi-check text-5xl\"/>\n" +
            "        </span>\n" +
            "        <div class=\"font-medium text-2xl text-900\">Modal Title Placeholder</div>\n" +
            "    </div>\n" +
            "\n" +
            "    <p class=\"line-height-3 p-0 m-0\">\n" +
            "        Sagittis eu volutpat odio facilisis mauris sit amet. Sed velit dignissim sodales ut eu sem integer.\n" +
            "        Sed risus pretium quam vulputate. At tellus at urna condimentum mattis pellentesque.\n" +
            "    </p>\n" +
            "\n" +
            "    <f:facet name=\"footer\">\n" +
            "        <div class=\" border-top-1 surface-border pt-3 flex\">\n" +
            "            <p:commandButton type=\"button\" value=\"Cancel\" icon=\"pi pi-times\" onclick=\"PF('dlg2').hide()\"\n" +
            "                             styleClass=\"ui-button-outlined w-6 mr-2\"/>\n" +
            "            <p:commandButton type=\"button\" value=\"Save\" icon=\"pi pi-check\" onclick=\"PF('dlg2').hide()\"\n" +
            "                             styleClass=\"w-6 ml-2\"/>\n" +
            "        </div>\n" +
            "    </f:facet>\n" +
            "</p:dialog>" ;

    private final String block3 = "<p:commandButton value=\"Display\" type=\"button\" onclick=\"PF('dlg3').show()\"/>\n" +
            "<p:dialog widgetVar=\"dlg3\" modal=\"true\" width=\"40vw\" responsive=\"true\" closable=\"false\">\n" +
            "    <f:facet name=\"header\">Title Placeholder</f:facet>\n" +
            "    <div class=\"flex flex-wrap border-top-1 surface-border pt-4\">\n" +
            "        <div class=\"bg-blue-50 flex align-items-center justify-content-center py-3 px-0 w-full md:w-4 border-round\">\n" +
            "            <p:graphicImage name=\"images/blocks/illustration/security.svg\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"w-9\"/>\n" +
            "        </div>\n" +
            "        <p class=\"text-700 line-height-3 m-0 p-5 w-full md:w-8\">\n" +
            "            Sagittis eu volutpat odio facilisis mauris sit amet. Sed velit dignissim sodales ut eu sem integer. Sed risus pretium quam vulputate. At tellus at urna condimentum mattis pellentesque.\n" +
            "        </p>\n" +
            "    </div>\n" +
            "    <f:facet name=\"footer\">\n" +
            "        <div class=\" border-top-1 surface-border pt-3\">\n" +
            "            <p:commandButton type=\"button\" value=\"Cancel\" icon=\"pi pi-times\" onclick=\"PF('dlg3').hide()\" styleClass=\"ui-button-flat\"/>\n" +
            "            <p:commandButton type=\"button\" value=\"Save\" icon=\"pi pi-check\" onclick=\"PF('dlg3').hide()\"/>\n" +
            "        </div>\n" +
            "    </f:facet>\n" +
            "</p:dialog>\n";

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
