package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class CardHeadingView implements Serializable {

    private final String block1 = "<div class=\"surface-card p-4 shadow-2 border-round\">\n" +
            "    <div class=\"text-3xl font-medium text-900 mb-3\">Card Title</div>\n" +
            "    <div class=\"font-medium text-500 mb-3\">Vivamus id nisl interdum, blandit augue sit amet, eleifend mi.</div>\n" +
            "    <div style=\"height: 150px\" class=\"border-2 border-dashed surface-border\"></div>\n" +
            "</div>" ;
    
    private final String block2 = "<div class=\"surface-card p-4 shadow-2 border-round\">\n" +
            "    <div class=\"mb-3 flex align-items-center justify-content-between\">\n" +
            "        <div class=\"flex align-items-center\">\n" +
            "            <span class=\"text-xl font-medium text-900\">Card Title</span>\n" +
            "        </div>\n" +
            "        <div>\n" +
            "            <p:commandButton id=\"cardHeadingButton\" type=\"button\" icon=\"pi pi-ellipsis-v\"\n" +
            "                             styleClass=\"ui-button-flat ui-button-plain rounded-button\"/>\n" +
            "            <p:menu overlay=\"true\" trigger=\"cardHeadingButton\" my=\"left top\" at=\"left bottom\">\n" +
            "                <p:submenu label=\"Options\">\n" +
            "                    <p:menuitem value=\"Add User\" icon=\"pi pi-fw pi-user-plus\"/>\n" +
            "                    <p:menuitem value=\"Remove User\" icon=\"pi pi-fw pi-user-minus\"/>\n" +
            "                </p:submenu>\n" +
            "            </p:menu>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div style=\"height: 150px\" class=\"border-2 border-dashed surface-border\"></div>\n" +
            "</div>" ;

    private final String block3 = "<div class=\"surface-card p-4 shadow-2 border-round\">\n" +
            "    <div class=\"mb-3 flex align-items-center justify-content-between\">\n" +
            "        <div class=\"flex align-items-center\">\n" +
            "            <i class=\"pi pi-map-marker text-500 mr-2 text-xl\"/>\n" +
            "            <span class=\"text-xl font-medium text-900\">Card Title</span>\n" +
            "        </div>\n" +
            "        <div>\n" +
            "            <p:commandButton id=\"cardHeadingButton2\" type=\"button\" icon=\"pi pi-ellipsis-v\"\n" +
            "                             styleClass=\"ui-button-flat ui-button-plain rounded-button\"/>\n" +
            "            <p:menu overlay=\"true\" trigger=\"cardHeadingButton2\" my=\"left top\" at=\"left bottom\">\n" +
            "                <p:submenu label=\"Options\">\n" +
            "                    <p:menuitem value=\"Add User\" icon=\"pi pi-fw pi-user-plus\"/>\n" +
            "                    <p:menuitem value=\"Remove User\" icon=\"pi pi-fw pi-user-minus\"/>\n" +
            "                </p:submenu>\n" +
            "            </p:menu>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"font-medium text-500 mb-3\">Vivamus id nisl interdum, blandit augue sit amet, eleifend mi.</div>\n" +
            "    <div style=\"height: 150px\" class=\"border-2 border-dashed surface-border\"></div>\n" +
            "</div>" ;

    private final String block4 = "<div class=\"surface-card p-4 shadow-2 border-round\">\n" +
            "    <div class=\"mb-3 flex flex-column md:flex-row align-items-end md:align-items-center md:justify-content-between\">\n" +
            "        <div class=\"flex align-items-start\">\n" +
            "            <p:graphicImage name=\"images/blocks/logos/hyper.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                            height=\"40\" styleClass=\"mr-3\"/>\n" +
            "            <div>\n" +
            "                <div class=\"text-xl font-medium text-900 mb-2\">Card Title</div>\n" +
            "                <div class=\"font-medium text-500 mb-3 text-sm\">Vivamus id nisl interdum, blandit augue sit amet, eleifend mi.</div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"flex\">\n" +
            "            <p:commandButton type=\"button\" icon=\"pi pi-heart\"\n" +
            "                             styleClass=\"mr-2 ui-button-outlined rounded-button\"/>\n" +
            "            <p:commandButton type=\"button\" icon=\"pi pi-share-alt\"\n" +
            "                             styleClass=\"ui-button-outlined rounded-button\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div style=\"height: 150px\" class=\"border-2 border-dashed surface-border\"></div>\n" +
            "</div>" ;

    private final String block5 = "<div class=\"surface-card p-4 shadow-2 border-round\">\n" +
            "    <div class=\"mb-3 flex align-items-center justify-content-between\">\n" +
            "        <span class=\"text-xl font-medium text-900\">Title</span>\n" +
            "        <p:commandButton type=\"button\" value=\"New\" icon=\"pi pi-plus\"/>\n" +
            "    </div>\n" +
            "    <div style=\"height: 150px\" class=\"border-2 border-dashed surface-border\"></div>\n" +
            "</div>\n" ;
    
    private final String block6 = "<div class=\"surface-card p-4 shadow-2 border-round\">\n" +
            "    <div class=\"mb-3 flex flex-column md:flex-row md:align-items-center md:justify-content-between\">\n" +
            "        <span class=\"text-xl font-medium text-900\">Title</span>\n" +
            "        <div class=\"flex align-items-center justify-content-between mt-3 md:mt-0\">\n" +
            "            <div class=\"mr-3 flex align-items-center\">\n" +
            "                <p:avatarGroup styleClass=\"mr-1\">\n" +
            "                    <p:avatar shape=\"circle\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\"/>\n" +
            "                    </p:avatar>\n" +
            "                    <p:avatar shape=\"circle\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-2.png\" library=\"primeblocks-app\"/>\n" +
            "                    </p:avatar>\n" +
            "                    <p:avatar shape=\"circle\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-m-1.png\" library=\"primeblocks-app\"/>\n" +
            "                    </p:avatar>\n" +
            "                    <p:avatar shape=\"circle\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-m-2.png\" library=\"primeblocks-app\"/>\n" +
            "                    </p:avatar>\n" +
            "                    <p:avatar shape=\"circle\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-3.png\" library=\"primeblocks-app\"/>\n" +
            "                    </p:avatar>\n" +
            "                </p:avatarGroup>\n" +
            "                <span class=\"text-600\">+2</span>\n" +
            "            </div>\n" +
            "            <p:commandButton type=\"button\" value=\"View All\" icon=\"pi pi-search\" styleClass=\"ui-button-outlined\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div style=\"height: 150px\" class=\"border-2 border-dashed surface-border\"></div>\n" +
            "</div>\n" ;

    private final String block7 = "<div class=\"surface-card p-4 shadow-2 border-round\">\n" +
            "    <div class=\"mb-3 flex flex-column align-items-start md:flex-row md:align-items-center md:justify-content-between\">\n" +
            "        <div class=\"mb-3 md:mb-0\">\n" +
            "            <div class=\"text-3xl font-medium text-900 mb-3\">Card Title</div>\n" +
            "            <div class=\"font-medium text-500 mb-3\">Vivamus id nisl interdum, blandit augue sit amet, eleifend mi.</div>\n" +
            "        </div>\n" +
            "        <p:commandButton type=\"button\" value=\"New\" icon=\"pi pi-plus\"/>\n" +
            "    </div>\n" +
            "    <div style=\"height: 150px\" class=\"border-2 border-dashed surface-border\"></div>\n" +
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
    
    public String getBlock7() {
        return block7;
    }
}
