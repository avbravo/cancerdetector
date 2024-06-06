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
public class GridListView implements Serializable {

    private MenuModel model;

    private final String block1 = "<div class=\"surface-ground\">\n" +
            "    <div class=\"grid\">\n" +
            "        <div class=\"col-12 md:col-6 xl:col-4 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex border-bottom-1 surface-border pb-4\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-3\" style=\"width: 70px;height: 70px\"/>\n" +
            "                    <div class=\"flex flex-column align-items-start\">\n" +
            "                        <span class=\"text-lg text-900 font-medium mb-1\">Lindsay Connor</span>\n" +
            "                        <span class=\"text-600 font-medium mb-2\">Test Engineer</span>\n" +
            "                        <span class=\"bg-blue-50 text-blue-400 border-round inline-flex py-1 px-2 text-sm\">Editor</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"flex justify-content-between pt-4\">\n" +
            "                    <p:commandButton type=\"button\" value=\"View\" icon=\"pi pi-search\" styleClass=\"ui-button-outlined ui-button-secondary w-6 mr-2\"/>\n" +
            "                    <p:commandButton type=\"button\" value=\"Follow\" icon=\"pi pi-user-plus\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-4 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex border-bottom-1 surface-border pb-4\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-m-1.png\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-3\" style=\"width: 70px;height: 70px\"/>\n" +
            "                    <div class=\"flex flex-column align-items-start\">\n" +
            "                        <span class=\"text-lg text-900 font-medium mb-1\">James McAvoy</span>\n" +
            "                        <span class=\"text-600 font-medium mb-2\">Project Manager</span>\n" +
            "                        <span class=\"bg-purple-50 text-purple-400 border-round inline-flex py-1 px-2 text-sm\">Contributor</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"flex justify-content-between pt-4\">\n" +
            "                    <p:commandButton type=\"button\" value=\"View\" icon=\"pi pi-search\" styleClass=\"ui-button-outlined ui-button-secondary w-6 mr-2\"/>\n" +
            "                    <p:commandButton type=\"button\" value=\"Follow\" icon=\"pi pi-user-plus\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-4 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex border-bottom-1 surface-border pb-4\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-2.png\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-3\" style=\"width: 70px;height: 70px\"/>\n" +
            "                    <div class=\"flex flex-column align-items-start\">\n" +
            "                        <span class=\"text-lg text-900 font-medium mb-1\">Aisha Jones</span>\n" +
            "                        <span class=\"text-600 font-medium mb-2\">Designer</span>\n" +
            "                        <span class=\"bg-blue-50 text-blue-400 border-round inline-flex py-1 px-2 text-sm\">Editor</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"flex justify-content-between pt-4\">\n" +
            "                    <p:commandButton type=\"button\" value=\"View\" icon=\"pi pi-search\" styleClass=\"ui-button-outlined ui-button-secondary w-6 mr-2\"/>\n" +
            "                    <p:commandButton type=\"button\" value=\"Follow\" icon=\"pi pi-user-plus\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-4 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex border-bottom-1 surface-border pb-4\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-m-2.png\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-3\" style=\"width: 70px;height: 70px\"/>\n" +
            "                    <div class=\"flex flex-column align-items-start\">\n" +
            "                        <span class=\"text-lg text-900 font-medium mb-1\">Roberto Fox</span>\n" +
            "                        <span class=\"text-600 font-medium mb-2\">QA Engineer</span>\n" +
            "                        <span class=\"bg-orange-50 text-orange-400 border-round inline-flex py-1 px-2 text-sm\">Author</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"flex justify-content-between pt-4\">\n" +
            "                    <p:commandButton type=\"button\" value=\"View\" icon=\"pi pi-search\" styleClass=\"ui-button-outlined ui-button-secondary w-6 mr-2\"/>\n" +
            "                    <p:commandButton type=\"button\" value=\"Follow\" icon=\"pi pi-user-plus\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-4 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex border-bottom-1 surface-border pb-4\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-4.png\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-3\" style=\"width: 70px;height: 70px\"/>\n" +
            "                    <div class=\"flex flex-column align-items-start\">\n" +
            "                        <span class=\"text-lg text-900 font-medium mb-1\">Jenny Wilson</span>\n" +
            "                        <span class=\"text-600 font-medium mb-2\">Scrum Master</span>\n" +
            "                        <span class=\"bg-purple-50 text-purple-400 border-round inline-flex py-1 px-2 text-sm\">Contributor</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"flex justify-content-between pt-4\">\n" +
            "                    <p:commandButton type=\"button\" value=\"View\" icon=\"pi pi-search\" styleClass=\"ui-button-outlined ui-button-secondary w-6 mr-2\"/>\n" +
            "                    <p:commandButton type=\"button\" value=\"Follow\" icon=\"pi pi-user-plus\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-4 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex border-bottom-1 surface-border pb-4\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-5.png\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-3\" style=\"width: 70px;height: 70px\"/>\n" +
            "                    <div class=\"flex flex-column align-items-start\">\n" +
            "                        <span class=\"text-lg text-900 font-medium mb-1\">Claire Flores</span>\n" +
            "                        <span class=\"text-600 font-medium mb-2\">Developer</span>\n" +
            "                        <span class=\"bg-teal-50 text-teal-400 border-round inline-flex py-1 px-2 text-sm\">Subscriber</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"flex justify-content-between pt-4\">\n" +
            "                    <p:commandButton type=\"button\" value=\"View\" icon=\"pi pi-search\" styleClass=\"ui-button-outlined ui-button-secondary w-6 mr-2\"/>\n" +
            "                    <p:commandButton type=\"button\" value=\"Follow\" icon=\"pi pi-user-plus\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block2 = "<div class=\"surface-ground px-4 py-8 md:px-6 lg:px-8\">\n" +
            "    <div class=\"grid\">\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex flex-column align-items-center mb-3\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-1.png\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mb-3\" style=\"width: 70px;height: 70px\"/>\n" +
            "                    <span class=\"font-medium text-900 text-xl mb-3\">Jane Fox</span>\n" +
            "                    <span class=\"text-600 font-medium mb-2\">Project Manager</span>\n" +
            "                    <span class=\"text-600 surface-200 p-2 border-round\">Subscriber</span>\n" +
            "                </div>\n" +
            "                <div class=\"pt-3 border-top-1 surface-border flex\">\n" +
            "                    <p:commandButton type=\"button\"  icon=\"pi pi-user-plus\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\" style=\"border-radius: 30px\"/>\n" +
            "                    <p:commandButton type=\"button\"  icon=\"pi pi-send\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\" style=\"border-radius: 30px\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex flex-column align-items-center mb-3\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-m-1.png\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mb-3\" style=\"width: 70px;height: 70px\"/>\n" +
            "                    <span class=\"font-medium text-900 text-xl mb-3\">Robert Wilkins</span>\n" +
            "                    <span class=\"text-600 font-medium mb-2\">Developer</span>\n" +
            "                    <span class=\"text-600 surface-200 p-2 border-round\">Editor</span>\n" +
            "                </div>\n" +
            "                <div class=\"pt-3 border-top-1 surface-border flex\">\n" +
            "                    <p:commandButton type=\"button\"  icon=\"pi pi-user-plus\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\" style=\"border-radius: 30px\"/>\n" +
            "                    <p:commandButton type=\"button\"  icon=\"pi pi-send\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\" style=\"border-radius: 30px\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex flex-column align-items-center mb-3\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-2.png\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mb-3\" style=\"width: 70px;height: 70px\"/>\n" +
            "                    <span class=\"font-medium text-900 text-xl mb-3\">Jenny Wilson</span>\n" +
            "                    <span class=\"text-600 font-medium mb-2\">Marketing</span>\n" +
            "                    <span class=\"text-600 surface-200 p-2 border-round\">Subscriber</span>\n" +
            "                </div>\n" +
            "                <div class=\"pt-3 border-top-1 surface-border flex\">\n" +
            "                    <p:commandButton type=\"button\"  icon=\"pi pi-user-plus\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\" style=\"border-radius: 30px\"/>\n" +
            "                    <p:commandButton type=\"button\"  icon=\"pi pi-send\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\" style=\"border-radius: 30px\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex flex-column align-items-center mb-3\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-m-2.png\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mb-3\" style=\"width: 70px;height: 70px\"/>\n" +
            "                    <span class=\"font-medium text-900 text-xl mb-3\">Alberto Flores</span>\n" +
            "                    <span class=\"text-600 font-medium mb-2\">Accounting</span>\n" +
            "                    <span class=\"text-600 surface-200 p-2 border-round\">Moderator</span>\n" +
            "                </div>\n" +
            "                <div class=\"pt-3 border-top-1 surface-border flex\">\n" +
            "                    <p:commandButton type=\"button\"  icon=\"pi pi-user-plus\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\" style=\"border-radius: 30px\"/>\n" +
            "                    <p:commandButton type=\"button\"  icon=\"pi pi-send\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\" style=\"border-radius: 30px\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex flex-column align-items-center mb-3\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-3.png\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mb-3\" style=\"width: 70px;height: 70px\"/>\n" +
            "                    <span class=\"font-medium text-900 text-xl mb-3\">Regina Miles</span>\n" +
            "                    <span class=\"text-600 font-medium mb-2\">Developer</span>\n" +
            "                    <span class=\"text-600 surface-200 p-2 border-round\">Contributor</span>\n" +
            "                </div>\n" +
            "                <div class=\"pt-3 border-top-1 surface-border flex\">\n" +
            "                    <p:commandButton type=\"button\"  icon=\"pi pi-user-plus\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\" style=\"border-radius: 30px\"/>\n" +
            "                    <p:commandButton type=\"button\"  icon=\"pi pi-send\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\" style=\"border-radius: 30px\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex flex-column align-items-center mb-3\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-m-3.png\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mb-3\" style=\"width: 70px;height: 70px\"/>\n" +
            "                    <span class=\"font-medium text-900 text-xl mb-3\">Gary Richards</span>\n" +
            "                    <span class=\"text-600 font-medium mb-2\">Designer</span>\n" +
            "                    <span class=\"text-600 surface-200 p-2 border-round\">Subscriber</span>\n" +
            "                </div>\n" +
            "                <div class=\"pt-3 border-top-1 surface-border flex\">\n" +
            "                    <p:commandButton type=\"button\"  icon=\"pi pi-user-plus\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\" style=\"border-radius: 30px\"/>\n" +
            "                    <p:commandButton type=\"button\"  icon=\"pi pi-send\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\" style=\"border-radius: 30px\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex flex-column align-items-center mb-3\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-4.png\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mb-3\" style=\"width: 70px;height: 70px\"/>\n" +
            "                    <span class=\"font-medium text-900 text-xl mb-3\">Nelly Cooper</span>\n" +
            "                    <span class=\"text-600 font-medium mb-2\">Sales Specialist</span>\n" +
            "                    <span class=\"text-600 surface-200 p-2 border-round\">Editor</span>\n" +
            "                </div>\n" +
            "                <div class=\"pt-3 border-top-1 surface-border flex\">\n" +
            "                    <p:commandButton type=\"button\"  icon=\"pi pi-user-plus\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\" style=\"border-radius: 30px\"/>\n" +
            "                    <p:commandButton type=\"button\"  icon=\"pi pi-send\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\" style=\"border-radius: 30px\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex flex-column align-items-center mb-3\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-m-4.png\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mb-3\" style=\"width: 70px;height: 70px\"/>\n" +
            "                    <span class=\"font-medium text-900 text-xl mb-3\">Cody Roberts</span>\n" +
            "                    <span class=\"text-600 font-medium mb-2\">Designer</span>\n" +
            "                    <span class=\"text-600 surface-200 p-2 border-round\">Author</span>\n" +
            "                </div>\n" +
            "                <div class=\"pt-3 border-top-1 surface-border flex\">\n" +
            "                    <p:commandButton type=\"button\"  icon=\"pi pi-user-plus\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\" style=\"border-radius: 30px\"/>\n" +
            "                    <p:commandButton type=\"button\"  icon=\"pi pi-send\" styleClass=\"ui-button-outlined ui-button-secondary w-6 ml-2\" style=\"border-radius: 30px\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block3 = "<div class=\"surface-ground px-4 py-8 md:px-6 lg:px-8\">\n" +
            "    <div class=\"grid\">\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex flex-column align-items-center border-bottom-1 surface-border pb-3\">\n" +
            "                    <p:graphicImage name=\"images/blocks/products/bracelet.jpg\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mb-3 w-9\"/>\n" +
            "                    <span class=\"text-lg text-900 font-medium mb-2\">Bamboo Watch</span>\n" +
            "                    <span class=\"text-600 font-medium mb-3\">Duis Aute Irure</span>\n" +
            "                    <span class=\"text-2xl text-800 block mb-3 font-semibold\">$9.66</span>\n" +
            "                    <p:rating value=\"5\" readonly=\"true\"/>\n" +
            "                </div>\n" +
            "                <div class=\"flex pt-3 justify-content-between align-items-center\">\n" +
            "                    <p:commandButton type=\"button\" value=\"Buy Now\" icon=\"pi pi-shopping-cart\" styleClass=\"ui-button-flat\"/>\n" +
            "                    <p:commandButton type=\"button\" icon=\"pi pi-heart\" styleClass=\"ui-button-flat ui-button-secondary\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex flex-column align-items-center border-bottom-1 surface-border pb-3\">\n" +
            "                    <p:graphicImage name=\"images/blocks/products/galaxy-earrings.jpg\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mb-3 w-9\"/>\n" +
            "                    <span class=\"text-lg text-900 font-medium mb-2\">Black Watch</span>\n" +
            "                    <span class=\"text-600 font-medium mb-3\">Ullam libero</span>\n" +
            "                    <span class=\"text-2xl text-800 block mb-3 font-semibold\">$12.45</span>\n" +
            "                    <p:rating value=\"3\" readonly=\"true\"/>\n" +
            "                </div>\n" +
            "                <div class=\"flex pt-3 justify-content-between align-items-center\">\n" +
            "                    <p:commandButton type=\"button\" value=\"Buy Now\" icon=\"pi pi-shopping-cart\" styleClass=\"ui-button-flat\"/>\n" +
            "                    <p:commandButton type=\"button\" icon=\"pi pi-heart\" styleClass=\"ui-button-flat ui-button-secondary\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex flex-column align-items-center border-bottom-1 surface-border pb-3\">\n" +
            "                    <p:graphicImage name=\"images/blocks/products/shoes.jpg\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mb-3 w-9\"/>\n" +
            "                    <span class=\"text-lg text-900 font-medium mb-2\">Shoes</span>\n" +
            "                    <span class=\"text-600 font-medium mb-3\">Eveniet magnam</span>\n" +
            "                    <span class=\"text-2xl text-800 block mb-3 font-semibold\">$21.50</span>\n" +
            "                    <p:rating value=\"3\" readonly=\"true\"/>\n" +
            "                </div>\n" +
            "                <div class=\"flex pt-3 justify-content-between align-items-center\">\n" +
            "                    <p:commandButton type=\"button\" value=\"Buy Now\" icon=\"pi pi-shopping-cart\" styleClass=\"ui-button-flat\"/>\n" +
            "                    <p:commandButton type=\"button\" icon=\"pi pi-heart\" styleClass=\"ui-button-flat ui-button-secondary\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex flex-column align-items-center border-bottom-1 surface-border pb-3\">\n" +
            "                    <p:graphicImage name=\"images/blocks/products/yoga-mat.jpg\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mb-3 w-9\"/>\n" +
            "                    <span class=\"text-lg text-900 font-medium mb-2\">Yoga-Mat</span>\n" +
            "                    <span class=\"text-600 font-medium mb-3\">Quis minus soluta</span>\n" +
            "                    <span class=\"text-2xl text-800 block mb-3 font-semibold\">$15.00</span>\n" +
            "                    <p:rating value=\"3\" readonly=\"true\"/>\n" +
            "                </div>\n" +
            "                <div class=\"flex pt-3 justify-content-between align-items-center\">\n" +
            "                    <p:commandButton type=\"button\" value=\"Buy Now\" icon=\"pi pi-shopping-cart\" styleClass=\"ui-button-flat\"/>\n" +
            "                    <p:commandButton type=\"button\" icon=\"pi pi-heart\" styleClass=\"ui-button-flat ui-button-secondary\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex flex-column align-items-center border-bottom-1 surface-border pb-3\">\n" +
            "                    <p:graphicImage name=\"images/blocks/products/headphones.jpg\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mb-3 w-9\"/>\n" +
            "                    <span class=\"text-lg text-900 font-medium mb-2\">Headphones</span>\n" +
            "                    <span class=\"text-600 font-medium mb-3\">Sunt facere tempora</span>\n" +
            "                    <span class=\"text-2xl text-800 block mb-3 font-semibold\">$44.50</span>\n" +
            "                    <p:rating value=\"3\" readonly=\"true\"/>\n" +
            "                </div>\n" +
            "                <div class=\"flex pt-3 justify-content-between align-items-center\">\n" +
            "                    <p:commandButton type=\"button\" value=\"Buy Now\" icon=\"pi pi-shopping-cart\" styleClass=\"ui-button-flat\"/>\n" +
            "                    <p:commandButton type=\"button\" icon=\"pi pi-heart\" styleClass=\"ui-button-flat ui-button-secondary\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex flex-column align-items-center border-bottom-1 surface-border pb-3\">\n" +
            "                    <p:graphicImage name=\"images/blocks/products/pink-purse.jpg\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mb-3 w-9\"/>\n" +
            "                    <span class=\"text-lg text-900 font-medium mb-2\">Lime Band</span>\n" +
            "                    <span class=\"text-600 font-medium mb-3\">Lorem Ipsum Dolor</span>\n" +
            "                    <span class=\"text-2xl text-800 block mb-3 font-semibold\">$5.90</span>\n" +
            "                    <p:rating value=\"3\" readonly=\"true\"/>\n" +
            "                </div>\n" +
            "                <div class=\"flex pt-3 justify-content-between align-items-center\">\n" +
            "                    <p:commandButton type=\"button\" value=\"Buy Now\" icon=\"pi pi-shopping-cart\" styleClass=\"ui-button-flat\"/>\n" +
            "                    <p:commandButton type=\"button\" icon=\"pi pi-heart\" styleClass=\"ui-button-flat ui-button-secondary\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex flex-column align-items-center border-bottom-1 surface-border pb-3\">\n" +
            "                    <p:graphicImage name=\"images/blocks/products/purple-gemstone-necklace.jpg\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mb-3 w-9\"/>\n" +
            "                    <span class=\"text-lg text-900 font-medium mb-2\">Necklace</span>\n" +
            "                    <span class=\"text-600 font-medium mb-3\">Sit amet consectetur</span>\n" +
            "                    <span class=\"text-2xl text-800 block mb-3 font-semibold\">$21.90</span>\n" +
            "                    <p:rating value=\"3\" readonly=\"true\"/>\n" +
            "                </div>\n" +
            "                <div class=\"flex pt-3 justify-content-between align-items-center\">\n" +
            "                    <p:commandButton type=\"button\" value=\"Buy Now\" icon=\"pi pi-shopping-cart\" styleClass=\"ui-button-flat\"/>\n" +
            "                    <p:commandButton type=\"button\" icon=\"pi pi-heart\" styleClass=\"ui-button-flat ui-button-secondary\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-4\">\n" +
            "                <div class=\"flex flex-column align-items-center border-bottom-1 surface-border pb-3\">\n" +
            "                    <p:graphicImage name=\"images/blocks/products/purple-t-shirt.jpg\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mb-3 w-9\"/>\n" +
            "                    <span class=\"text-lg text-900 font-medium mb-2\">T-Shirt</span>\n" +
            "                    <span class=\"text-600 font-medium mb-3\">Adipisicing elit</span>\n" +
            "                    <span class=\"text-2xl text-800 block mb-3 font-semibold\">$18.50</span>\n" +
            "                    <p:rating value=\"3\" readonly=\"true\"/>\n" +
            "                </div>\n" +
            "                <div class=\"flex pt-3 justify-content-between align-items-center\">\n" +
            "                    <p:commandButton type=\"button\" value=\"Buy Now\" icon=\"pi pi-shopping-cart\" styleClass=\"ui-button-flat\"/>\n" +
            "                    <p:commandButton type=\"button\" icon=\"pi pi-heart\" styleClass=\"ui-button-flat ui-button-secondary\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;


    private final String block4 =  "<div class=\"surface-ground px-4 py-8 md:px-6 lg:px-8\">\n" +
            "    <div class=\"grid\">\n" +
            "        <div class=\"col-12 lg:col-4 p-3\">\n" +
            "            <div class=\"p-3 border-round shadow-2 flex align-items-center surface-card\">\n" +
            "                <div style=\"width:48px;height:48px;border-radius:10px\" class=\"bg-teal-100 inline-flex align-items-center justify-content-center mr-3\">\n" +
            "                    <i class=\"pi pi-shield text-teal-600 text-3xl\"></i>\n" +
            "                </div>\n" +
            "                <div>\n" +
            "                    <span class=\"text-900 text-xl font-medium mb-2\">Security</span>\n" +
            "                    <p class=\"mt-1 mb-0 text-600 font-medium text-sm\">Proin libero nunc</p>\n" +
            "                </div>\n" +
            "                <div class=\"ml-auto\">\n" +
            "                    <p:commandButton id=\"menuButton1\" type=\"button\"  icon=\"pi pi-ellipsis-v\" styleClass=\"ui-button-flat ui-button-secondary w-6 ml-2\"/>\n" +
            "                    <p:menu overlay=\"true\" model=\"#{gridListView.model}\" trigger=\"menuButton1\" my=\"left top\" at=\"left bottom\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 lg:col-4 p-3\">\n" +
            "            <div class=\"p-3 border-round shadow-2 flex align-items-center surface-card\">\n" +
            "                <div style=\"width:48px;height:48px;border-radius:10px\" class=\"bg-pink-100 inline-flex align-items-center justify-content-center mr-3\">\n" +
            "                    <i class=\"pi pi-users text-pink-600 text-3xl\"></i>\n" +
            "                </div>\n" +
            "                <div>\n" +
            "                    <span class=\"text-900 text-xl font-medium mb-2\">Staff</span>\n" +
            "                    <p class=\"mt-1 mb-0 text-600 font-medium text-sm\">Lorem ipsum dolor</p>\n" +
            "                </div>\n" +
            "                <div class=\"ml-auto\">\n" +
            "                    <p:commandButton id=\"menuButton2\" type=\"button\"  icon=\"pi pi-ellipsis-v\" styleClass=\"ui-button-flat ui-button-secondary w-6 ml-2\"/>\n" +
            "                    <p:menu overlay=\"true\" model=\"#{gridListView.model}\" trigger=\"menuButton2\" my=\"left top\" at=\"left bottom\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 lg:col-4 p-3\">\n" +
            "            <div class=\"p-3 border-round shadow-2 flex align-items-center surface-card\">\n" +
            "                <div style=\"width:48px;height:48px;border-radius:10px\" class=\"bg-orange-100 inline-flex align-items-center justify-content-center mr-3\">\n" +
            "                    <i class=\"pi pi-wallet text-orange-600 text-3xl\"></i>\n" +
            "                </div>\n" +
            "                <div>\n" +
            "                    <span class=\"text-900 text-xl font-medium mb-2\">Finance</span>\n" +
            "                    <p class=\"mt-1 mb-0 text-600 font-medium text-sm\">Vestibulum lorem</p>\n" +
            "                </div>\n" +
            "                <div class=\"ml-auto\">\n" +
            "                    <p:commandButton id=\"menuButton3\" type=\"button\"  icon=\"pi pi-ellipsis-v\" styleClass=\"ui-button-flat ui-button-secondary w-6 ml-2\"/>\n" +
            "                    <p:menu overlay=\"true\" model=\"#{gridListView.model}\" trigger=\"menuButton3\" my=\"left top\" at=\"left bottom\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block5 = "<div class=\"surface-ground px-4 py-8 md:px-6 lg:px-8\">\n" +
            "    <div class=\"grid\">\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-3\" style=\"border-radius: 6px\">\n" +
            "                <p:graphicImage name=\"images/blocks/nature/nature-1.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mb-3 w-full\"/>\n" +
            "                <div class=\"flex justify-content-between align-items-start\">\n" +
            "                    <div>\n" +
            "                        <div class=\"text-xl font-medium text-900 mb-2\">sed-risus</div>\n" +
            "                        <p class=\"mt-0 mb-3 text-600\">PNG image - 971 KB</p>\n" +
            "                    </div>\n" +
            "                    <p:commandButton type=\"button\" icon=\"pi pi-download\" styleClass=\"ui-button-flat pl-2 mt-2 md:mt-0\"/>\n" +
            "                </div>\n" +
            "                <ul class=\"list-none m-0 p-0\">\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center border-bottom-1 surface-border\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Created</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">Yesterday 11:30</span>\n" +
            "                    </li>\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center border-bottom-1 surface-border\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Dimensions</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">2732x1690</span>\n" +
            "                    </li>\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Resolution</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">144x144</span>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-3\" style=\"border-radius: 6px\">\n" +
            "                <p:graphicImage name=\"images/blocks/nature/nature-2.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mb-3 w-full\"/>\n" +
            "                <div class=\"flex justify-content-between align-items-start\">\n" +
            "                    <div>\n" +
            "                        <div class=\"text-xl font-medium text-900 mb-2\">morbit-blandit</div>\n" +
            "                        <p class=\"mt-0 mb-3 text-600\">PNG image - 350 KB</p>\n" +
            "                    </div>\n" +
            "                    <p:commandButton type=\"button\" icon=\"pi pi-download\" styleClass=\"ui-button-flat pl-2 mt-2 md:mt-0\"/>\n" +
            "                </div>\n" +
            "                <ul class=\"list-none m-0 p-0\">\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center border-bottom-1 surface-border\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Created</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">Today 09:30</span>\n" +
            "                    </li>\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center border-bottom-1 surface-border\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Dimensions</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">1920x1080</span>\n" +
            "                    </li>\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Resolution</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">144x144</span>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-3\" style=\"border-radius: 6px\">\n" +
            "                <p:graphicImage name=\"images/blocks/nature/nature-3.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mb-3 w-full\"/>\n" +
            "                <div class=\"flex justify-content-between align-items-start\">\n" +
            "                    <div>\n" +
            "                        <div class=\"text-xl font-medium text-900 mb-2\">neque-aliquam</div>\n" +
            "                        <p class=\"mt-0 mb-3 text-600\">PNG image - 458 KB</p>\n" +
            "                    </div>\n" +
            "                    <p:commandButton type=\"button\" icon=\"pi pi-download\" styleClass=\"ui-button-flat pl-2 mt-2 md:mt-0\"/>\n" +
            "                </div>\n" +
            "                <ul class=\"list-none m-0 p-0\">\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center border-bottom-1 surface-border\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Created</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">Yesterday 11:30</span>\n" +
            "                    </li>\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center border-bottom-1 surface-border\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Dimensions</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">1280x720</span>\n" +
            "                    </li>\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Resolution</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">144x144</span>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-3\" style=\"border-radius: 6px\">\n" +
            "                <p:graphicImage name=\"images/blocks/nature/nature-4.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mb-3 w-full\"/>\n" +
            "                <div class=\"flex justify-content-between align-items-start\">\n" +
            "                    <div>\n" +
            "                        <div class=\"text-xl font-medium text-900 mb-2\">solestie-ac-final</div>\n" +
            "                        <p class=\"mt-0 mb-3 text-600\">PNG image - 102 KB</p>\n" +
            "                    </div>\n" +
            "                    <p:commandButton type=\"button\" icon=\"pi pi-download\" styleClass=\"ui-button-flat pl-2 mt-2 md:mt-0\"/>\n" +
            "                </div>\n" +
            "                <ul class=\"list-none m-0 p-0\">\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center border-bottom-1 surface-border\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Created</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">Today 15:30</span>\n" +
            "                    </li>\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center border-bottom-1 surface-border\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Dimensions</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">1920x1080</span>\n" +
            "                    </li>\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Resolution</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">144x144</span>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-3\" style=\"border-radius: 6px\">\n" +
            "                <p:graphicImage name=\"images/blocks/nature/nature-5.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mb-3 w-full\"/>\n" +
            "                <div class=\"flex justify-content-between align-items-start\">\n" +
            "                    <div>\n" +
            "                        <div class=\"text-xl font-medium text-900 mb-2\">neqeu-viverra</div>\n" +
            "                        <p class=\"mt-0 mb-3 text-600\">PNG image - 432 KB</p>\n" +
            "                    </div>\n" +
            "                    <p:commandButton type=\"button\" icon=\"pi pi-download\" styleClass=\"ui-button-flat pl-2 mt-2 md:mt-0\"/>\n" +
            "                </div>\n" +
            "                <ul class=\"list-none m-0 p-0\">\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center border-bottom-1 surface-border\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Created</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">Today 14:30</span>\n" +
            "                    </li>\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center border-bottom-1 surface-border\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Dimensions</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">2732x-1690</span>\n" +
            "                    </li>\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Resolution</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">144x144</span>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-3\" style=\"border-radius: 6px\">\n" +
            "                <p:graphicImage name=\"images/blocks/nature/nature-6.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mb-3 w-full\"/>\n" +
            "                <div class=\"flex justify-content-between align-items-start\">\n" +
            "                    <div>\n" +
            "                        <div class=\"text-xl font-medium text-900 mb-2\">enim-nec-dui</div>\n" +
            "                        <p class=\"mt-0 mb-3 text-600\">PNG image - 330 KB</p>\n" +
            "                    </div>\n" +
            "                    <p:commandButton type=\"button\" icon=\"pi pi-download\" styleClass=\"ui-button-flat pl-2 mt-2 md:mt-0\"/>\n" +
            "                </div>\n" +
            "                <ul class=\"list-none m-0 p-0\">\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center border-bottom-1 surface-border\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Created</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">Today 10:30</span>\n" +
            "                    </li>\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center border-bottom-1 surface-border\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Dimensions</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">1920x1080</span>\n" +
            "                    </li>\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Resolution</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">144x144</span>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-3\" style=\"border-radius: 6px\">\n" +
            "                <p:graphicImage name=\"images/blocks/nature/nature-7.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mb-3 w-full\"/>\n" +
            "                <div class=\"flex justify-content-between align-items-start\">\n" +
            "                    <div>\n" +
            "                        <div class=\"text-xl font-medium text-900 mb-2\">cursus-sit</div>\n" +
            "                        <p class=\"mt-0 mb-3 text-600\">PNG image - 1001 KB</p>\n" +
            "                    </div>\n" +
            "                    <p:commandButton type=\"button\" icon=\"pi pi-download\" styleClass=\"ui-button-flat pl-2 mt-2 md:mt-0\"/>\n" +
            "                </div>\n" +
            "                <ul class=\"list-none m-0 p-0\">\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center border-bottom-1 surface-border\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Created</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">Yesterday 20:30</span>\n" +
            "                    </li>\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center border-bottom-1 surface-border\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Dimensions</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">1280x720</span>\n" +
            "                    </li>\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Resolution</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">144x144</span>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 xl:col-3 p-3\">\n" +
            "            <div class=\"surface-card shadow-2 border-rounded p-3\" style=\"border-radius: 6px\">\n" +
            "                <p:graphicImage name=\"images/blocks/nature/nature-8.png\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mb-3 w-full\"/>\n" +
            "                <div class=\"flex justify-content-between align-items-start\">\n" +
            "                    <div>\n" +
            "                        <div class=\"text-xl font-medium text-900 mb-2\">odio-ut-enim</div>\n" +
            "                        <p class=\"mt-0 mb-3 text-600\">PNG image - 660 KB</p>\n" +
            "                    </div>\n" +
            "                    <p:commandButton type=\"button\" icon=\"pi pi-download\" styleClass=\"ui-button-flat pl-2 mt-2 md:mt-0\"/>\n" +
            "                </div>\n" +
            "                <ul class=\"list-none m-0 p-0\">\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center border-bottom-1 surface-border\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Created</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">Today 11:30</span>\n" +
            "                    </li>\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center border-bottom-1 surface-border\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Dimensions</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">1920x1080</span>\n" +
            "                    </li>\n" +
            "                    <li class=\"px-0 py-2 flex justify-content-between align-items-center\">\n" +
            "                        <span class=\"text-600 font-medium text-sm\">Resolution</span>\n" +
            "                        <span class=\"text-900 font-medium text-sm\">144x144</span>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block6 = "<div class=\"surface-ground px-4 py-8 md:px-6 lg:px-8\">\n" +
            "    <div class=\"grid\">\n" +
            "        <div class=\"col-12 lg:col-4 p-3\">\n" +
            "            <div class=\"shadow-2 border-round surface-card mb-3 h-full flex-column justify-content-between flex\">\n" +
            "                <div class=\"p-4\">\n" +
            "                    <div class=\"flex align-items-center\">\n" +
            "                        <span class=\"inline-flex border-circle align-items-center justify-content-center bg-green-100 mr-3\" style=\"width:38px;height:38px\">\n" +
            "                            <i class=\"pi pi-globe text-xl text-green-600\"></i>\n" +
            "                        </span>\n" +
            "                        <span class=\"text-900 font-medium text-2xl\">Card Title</span>\n" +
            "                    </div>\n" +
            "                    <div class=\"text-900 my-3 text-xl font-medium\">Quam adipiscing vitae proin sagittis.</div>\n" +
            "                    <p class=\"mt-0 mb-3 text-700 line-height-3\">Eget sit amet tellus cras adipiscing enim. At quis risus sed vulputate odio. Proin libero nunc consequat interdum varius sit amet.</p>\n" +
            "                </div>\n" +
            "                <div class=\"px-4 py-3 surface-100 text-right\">\n" +
            "                    <p:commandButton type=\"button\" icon=\"pi pi-arrow-right\" value=\"More\" styleClass=\"rounded-button ui-button-success\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 lg:col-4 p-3\">\n" +
            "            <div class=\"shadow-2 border-round surface-card mb-3 h-full flex-column justify-content-between flex\">\n" +
            "                <div class=\"p-4\">\n" +
            "                    <div class=\"flex align-items-center\">\n" +
            "                        <span class=\"inline-flex border-circle align-items-center justify-content-center bg-yellow-100 mr-3\" style=\"width:38px;height:38px\">\n" +
            "                            <i class=\"pi pi-globe text-xl text-yellow-600\"></i>\n" +
            "                        </span>\n" +
            "                        <span class=\"text-900 font-medium text-2xl\">Card Title</span>\n" +
            "                    </div>\n" +
            "                    <div class=\"text-900 my-3 text-xl font-medium\">Proin libero nunci</div>\n" +
            "                    <p class=\"mt-0 mb-3 text-700 line-height-3\">Molestie ac feugiat sed lectus vestibulum mattis ullamcorper. Vulputate odio ut enim blandit volutpat maecenas. Convallis tellus id interdum velit.</p>\n" +
            "                </div>\n" +
            "                <div class=\"px-4 py-3 surface-100 text-right\">\n" +
            "                    <p:commandButton type=\"button\" icon=\"pi pi-download\" value=\"Load\" styleClass=\"rounded-button ui-button-warning\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 lg:col-4 p-3\">\n" +
            "            <div class=\"shadow-2 border-round surface-card mb-3 h-full flex-column justify-content-between flex\">\n" +
            "                <div class=\"p-4\">\n" +
            "                    <div class=\"flex align-items-center\">\n" +
            "                        <span class=\"inline-flex border-circle align-items-center justify-content-center bg-purple-100 mr-3\" style=\"width:38px;height:38px\">\n" +
            "                            <i class=\"pi pi-globe text-xl text-purple-600\"></i>\n" +
            "                        </span>\n" +
            "                        <span class=\"text-900 font-medium text-2xl\">Card Title</span>\n" +
            "                    </div>\n" +
            "                    <div class=\"text-900 my-3 text-xl font-medium\"> At obcaecati quos ipsam laboriosam.</div>\n" +
            "                    <p class=\"mt-0 mb-3 text-700 line-height-3\">Rhoncus urna neque viverra justo nec ultrices dui sapien eget. Id neque aliquam vestibulum morbi blandit cursus risus at ipsum.</p>\n" +
            "                </div>\n" +
            "                <div class=\"px-4 py-3 surface-100 text-right\">\n" +
            "                    <p:commandButton type=\"button\" icon=\"pi pi-bookmark\" value=\"Save\" styleClass=\"rounded-button ui-button-help\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block7 = "<div class=\"shadow-2 border-round surface-card p-4\">\n" +
            "    <div class=\"flex align-items-center justify-content-between mb-4\">\n" +
            "        <span class=\"text-xl font-medium text-900\">Files</span>\n" +
            "        <p:commandButton type=\"button\" icon=\"pi pi-refresh\" styleClass=\"ui-button-outlined pl-2 mt-2 md:mt-0\"/>\n" +
            "    </div>\n" +
            "    <div class=\"grid\">\n" +
            "        <div class=\"col-12 sm:col-6 lg:col-3 xl:col-2 p-3\">\n" +
            "            <div class=\"text-center\">\n" +
            "                <div class=\"border-1 border-200 surface-50 flex align-items-center justify-content-center border-round mb-3 mx-auto\" style=\"width:90px; height:90px\">\n" +
            "                    <p:graphicImage name=\"images/blocks/file/word.svg\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 48;height: 48\"/>\n" +
            "                </div>\n" +
            "                <span class=\"text-900 font-medium\">resume.docx</span>\n" +
            "                <div class=\"text-600 text-sm mt-2\">520KB</div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 sm:col-6 lg:col-3 xl:col-2 p-3\">\n" +
            "            <div class=\"text-center\">\n" +
            "                <div class=\"border-1 border-200 surface-50 flex align-items-center justify-content-center border-round mb-3 mx-auto\" style=\"width:90px; height:90px\">\n" +
            "                    <p:graphicImage name=\"images/blocks/file/excel.svg\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 48;height: 48\"/>\n" +
            "                </div>\n" +
            "                <span class=\"text-900 font-medium\">customers.xlsx</span>\n" +
            "                <div class=\"text-600 text-sm mt-2\">120KB</div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 sm:col-6 lg:col-3 xl:col-2 p-3\">\n" +
            "            <div class=\"text-center\">\n" +
            "                <div class=\"border-1 border-200 surface-50 flex align-items-center justify-content-center border-round mb-3 mx-auto\" style=\"width:90px; height:90px\">\n" +
            "                    <p:graphicImage name=\"images/blocks/file/excel.svg\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 48;height: 48\"/>\n" +
            "                </div>\n" +
            "                <span class=\"text-900 font-medium\">stats.xlsx</span>\n" +
            "                <div class=\"text-600 text-sm mt-2\">500KB</div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 sm:col-6 lg:col-3 xl:col-2 p-3\">\n" +
            "            <div class=\"text-center\">\n" +
            "                <div class=\"border-1 border-200 surface-50 flex align-items-center justify-content-center border-round mb-3 mx-auto\" style=\"width:90px; height:90px\">\n" +
            "                    <p:graphicImage name=\"images/blocks/file/ps.svg\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 48;height: 48\"/>\n" +
            "                </div>\n" +
            "                <span class=\"text-900 font-medium\">mock.ps</span>\n" +
            "                <div class=\"text-600 text-sm mt-2\">220KB</div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 sm:col-6 lg:col-3 xl:col-2 p-3\">\n" +
            "            <div class=\"text-center\">\n" +
            "                <div class=\"border-1 border-200 surface-50 flex align-items-center justify-content-center border-round mb-3 mx-auto\" style=\"width:90px; height:90px\">\n" +
            "                    <p:graphicImage name=\"images/blocks/file/atom.svg\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 48;height: 48\"/>\n" +
            "                </div>\n" +
            "                <span class=\"text-900 font-medium\">template.js</span>\n" +
            "                <div class=\"text-600 text-sm mt-2\">10KB</div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 sm:col-6 lg:col-3 xl:col-2 p-3\">\n" +
            "            <div class=\"text-center\">\n" +
            "                <div class=\"border-1 border-200 surface-50 flex align-items-center justify-content-center border-round mb-3 mx-auto\" style=\"width:90px; height:90px\">\n" +
            "                    <p:graphicImage name=\"images/blocks/file/code.svg\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 48;height: 48\"/>\n" +
            "                </div>\n" +
            "                <span class=\"text-900 font-medium\">main.css</span>\n" +
            "                <div class=\"text-600 text-sm mt-2\">10KB</div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 sm:col-6 lg:col-3 xl:col-2 p-3\">\n" +
            "            <div class=\"text-center\">\n" +
            "                <div class=\"border-1 border-200 surface-50 flex align-items-center justify-content-center border-round mb-3 mx-auto\" style=\"width:90px; height:90px\">\n" +
            "                    <p:graphicImage name=\"images/blocks/file/ai.svg\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 48;height: 48\"/>\n" +
            "                </div>\n" +
            "                <span class=\"text-900 font-medium\">poc.ai</span>\n" +
            "                <div class=\"text-600 text-sm mt-2\">4.2MB</div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 sm:col-6 lg:col-3 xl:col-2 p-3\">\n" +
            "            <div class=\"text-center\">\n" +
            "                <div class=\"border-1 border-200 surface-50 flex align-items-center justify-content-center border-round mb-3 mx-auto\" style=\"width:90px; height:90px\">\n" +
            "                    <p:graphicImage name=\"images/blocks/file/word.svg\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 48;height: 48\"/>\n" +
            "                </div>\n" +
            "                <span class=\"text-900 font-medium\">sales.docx</span>\n" +
            "                <div class=\"text-600 text-sm mt-2\">420KB</div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 sm:col-6 lg:col-3 xl:col-2 p-3\">\n" +
            "            <div class=\"text-center\">\n" +
            "                <div class=\"border-1 border-200 surface-50 flex align-items-center justify-content-center border-round mb-3 mx-auto\" style=\"width:90px; height:90px\">\n" +
            "                    <p:graphicImage name=\"images/blocks/file/word.svg\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 48;height: 48\"/>\n" +
            "                </div>\n" +
            "                <span class=\"text-900 font-medium\">mynotes.one</span>\n" +
            "                <div class=\"text-600 text-sm mt-2\">60KB</div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 sm:col-6 lg:col-3 xl:col-2 p-3\">\n" +
            "            <div class=\"text-center\">\n" +
            "                <div class=\"border-1 border-200 surface-50 flex align-items-center justify-content-center border-round mb-3 mx-auto\" style=\"width:90px; height:90px\">\n" +
            "                    <p:graphicImage name=\"images/blocks/file/code.svg\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 48;height: 48\"/>\n" +
            "                </div>\n" +
            "                <span class=\"text-900 font-medium\">layout.css</span>\n" +
            "                <div class=\"text-600 text-sm mt-2\">25KB</div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 sm:col-6 lg:col-3 xl:col-2 p-3\">\n" +
            "            <div class=\"text-center\">\n" +
            "                <div class=\"border-1 border-200 surface-50 flex align-items-center justify-content-center border-round mb-3 mx-auto\" style=\"width:90px; height:90px\">\n" +
            "                    <p:graphicImage name=\"images/blocks/file/word.svg\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 48;height: 48\"/>\n" +
            "                </div>\n" +
            "                <span class=\"text-900 font-medium\">reports.docx</span>\n" +
            "                <div class=\"text-600 text-sm mt-2\">120KB</div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 sm:col-6 lg:col-3 xl:col-2 p-3\">\n" +
            "            <div class=\"text-center\">\n" +
            "                <div class=\"border-1 border-200 surface-50 flex align-items-center justify-content-center border-round mb-3 mx-auto\" style=\"width:90px; height:90px\">\n" +
            "                    <p:graphicImage name=\"images/blocks/file/ps.svg\" library=\"primeblocks-app\" alt=\"Image\" style=\"width: 48;height: 48\"/>\n" +
            "                </div>\n" +
            "                <span class=\"text-900 font-medium\">design.psd</span>\n" +
            "                <div class=\"text-600 text-sm mt-2\">1.2MB</div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();

        DefaultSubMenu firstSubmenu = DefaultSubMenu.builder()
                .label("Options")
                .build();
                
        DefaultMenuItem item = DefaultMenuItem.builder()
                .value("Reports")
                .icon("pi pi-fw pi-chart-line")
                .build();
        firstSubmenu.getElements().add(item);

        item = DefaultMenuItem.builder()
                .value("Search")
                .icon("pi pi-fw pi-search")
                .build();
        firstSubmenu.getElements().add(item);

        model.getElements().add(firstSubmenu);
    } 

    public MenuModel getModel() {
        return model;
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
    
}
