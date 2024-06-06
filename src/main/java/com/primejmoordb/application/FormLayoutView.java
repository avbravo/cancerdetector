package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class FormLayoutView implements Serializable {

    private final String block1 = "<div class=\"surface-section\">\n" +
            "    <div class=\"grid\">\n" +
            "        <div class=\"col-12 lg:col-2\">\n" +
            "            <div class=\"text-900 font-medium text-xl mb-3\">Profile</div>\n" +
            "            <p class=\"m-0 p-0 text-600 line-height-3 mr-3\">Odio euismod lacinia at quis risus sed vulputate odio.</p>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 lg:col-10\">\n" +
            "            <div class=\"grid formgrid ui-fluid\">\n" +
            "                <div class=\"field mb-4 col-12\">\n" +
            "                    <label for=\"nickname1\" class=\"font-medium\">Nickname</label>\n" +
            "                    <p:inputText id=\"nickname1\"/>\n" +
            "                </div>\n" +
            "                <div class=\"field mb-4 col-12\">\n" +
            "                    <label class=\"font-medium\">Avatar</label>\n" +
            "                    <div class=\"flex align-items-center\">\n" +
            "                        <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-4.png\"\n" +
            "                                        library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                        styleClass=\"mr-4\"/>\n" +
            "                        <p:fileUpload mode=\"simple\" skinSimple=\"true\" label=\"Upload Image\" auto=\"true\"\n" +
            "                                      process=\"@this\"/>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"field mb-4 col-12\">\n" +
            "                    <label for=\"bio1\" class=\"font-medium\">Bio</label>\n" +
            "                    <p:inputTextarea id=\"bio1\" rows=\"5\" autoResize=\"true\"/>\n" +
            "                </div>\n" +
            "                <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                    <label for=\"email1\" class=\"font-medium\">Email</label>\n" +
            "                    <p:inputText id=\"email1\"/>\n" +
            "                </div>\n" +
            "                <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                    <label class=\"font-medium\">Country</label>\n" +
            "                    <p:selectOneMenu filter=\"true\" filterMatchMode=\"startsWith\">\n" +
            "                        <f:selectItem itemLabel=\"Select a Country\" itemValue=\"\"/>\n" +
            "                        <f:selectItem itemLabel=\"Australia\" itemValue=\"Australia\"/>\n" +
            "                        <f:selectItem itemLabel=\"Brazil\" itemValue=\"Brazil\"/>\n" +
            "                        <f:selectItem itemLabel=\"China\" itemValue=\"China\"/>\n" +
            "                        <f:selectItem itemLabel=\"Egypt\" itemValue=\"Egypt\"/>\n" +
            "                        <f:selectItem itemLabel=\"France\" itemValue=\"France\"/>\n" +
            "                        <f:selectItem itemLabel=\"Germany\" itemValue=\"Germany\"/>\n" +
            "                        <f:selectItem itemLabel=\"India\" itemValue=\"India\"/>\n" +
            "                        <f:selectItem itemLabel=\"Japan\" itemValue=\"Japan\"/>\n" +
            "                        <f:selectItem itemLabel=\"Spain\" itemValue=\"Spain\"/>\n" +
            "                        <f:selectItem itemLabel=\"United States\" itemValue=\"United States\"/>\n" +
            "                    </p:selectOneMenu>\n" +
            "                </div>\n" +
            "                <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                    <label for=\"city1\" class=\"font-medium\">City</label>\n" +
            "                    <p:inputText id=\"city1\"/>\n" +
            "                </div>\n" +
            "                <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                    <label for=\"state1\" class=\"font-medium\">State</label>\n" +
            "                    <p:inputText id=\"state1\"/>\n" +
            "                </div>\n" +
            "                <div class=\"field mb-4 col-12\">\n" +
            "                    <label for=\"website1\" class=\"font-medium\">Website</label>\n" +
            "                    <div class=\"ui-inputgroup\">\n" +
            "                        <span class=\"ui-inputgroup-addon\">www</span>\n" +
            "                        <p:inputText id=\"website1\"/>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"field mb-4 col-12\">\n" +
            "                    <label class=\"font-medium\">Privacy</label>\n" +
            "                    <div class=\"flex align-items-center\">\n" +
            "                        <p:selectBooleanCheckbox/>\n" +
            "                        <span class=\"ml-2\">Share my data with contacts</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"col-12\">\n" +
            "                    <p:commandButton type=\"button\" value=\"Save Changes\" styleClass=\"w-auto mt-3\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;
    
    private final String block2 = "<div>\n" +
            "    <div class=\"text-900 font-medium text-xl mb-3\">Profile</div>\n" +
            "    <p class=\"m-0 mb-4 p-0 text-600 line-height-3 mr-3\">Odio euismod lacinia at quis risus sed vulputate odio. Non nisi est sit amet.\n" +
            "        Egestas integer eget aliquet nibh praesent tristique magna.</p>\n" +
            "    <div class=\"surface-card p-4 shadow-2 border-round\">\n" +
            "        <div class=\"grid formgrid ui-fluid\">\n" +
            "            <div class=\"field mb-4 col-12\">\n" +
            "                <label for=\"nickname2\" class=\"font-medium\">Nickname</label>\n" +
            "                <p:inputText id=\"nickname2\"/>\n" +
            "            </div>\n" +
            "            <div class=\"surface-border border-top-1 opacity-50 mb-3 col-12\"></div>\n" +
            "            <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                <label for=\"bio2\" class=\"font-medium\">Bio</label>\n" +
            "                <p:inputTextarea id=\"bio2\" rows=\"5\" autoResize=\"true\"/>\n" +
            "            </div>\n" +
            "            <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                <label class=\"font-medium\">Avatar</label>\n" +
            "                <div class=\"flex align-items-center\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle/avatar-f-4.png\"\n" +
            "                                    library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                    styleClass=\"mr-4\"/>\n" +
            "                    <p:fileUpload mode=\"simple\" skinSimple=\"true\" label=\"Upload Image\" auto=\"true\"\n" +
            "                                  process=\"@this\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"surface-border border-top-1 opacity-50 mb-3 col-12\"></div>\n" +
            "            <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                <label for=\"email2\" class=\"font-medium\">Email</label>\n" +
            "                <p:inputText id=\"email2\"/>\n" +
            "            </div>\n" +
            "            <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                <label class=\"font-medium\">Country</label>\n" +
            "                <p:selectOneMenu filter=\"true\" filterMatchMode=\"startsWith\">\n" +
            "                    <f:selectItem itemLabel=\"Select a Country\" itemValue=\"\"/>\n" +
            "                    <f:selectItem itemLabel=\"Australia\" itemValue=\"Australia\"/>\n" +
            "                    <f:selectItem itemLabel=\"Brazil\" itemValue=\"Brazil\"/>\n" +
            "                    <f:selectItem itemLabel=\"China\" itemValue=\"China\"/>\n" +
            "                    <f:selectItem itemLabel=\"Egypt\" itemValue=\"Egypt\"/>\n" +
            "                    <f:selectItem itemLabel=\"France\" itemValue=\"France\"/>\n" +
            "                    <f:selectItem itemLabel=\"Germany\" itemValue=\"Germany\"/>\n" +
            "                    <f:selectItem itemLabel=\"India\" itemValue=\"India\"/>\n" +
            "                    <f:selectItem itemLabel=\"Japan\" itemValue=\"Japan\"/>\n" +
            "                    <f:selectItem itemLabel=\"Spain\" itemValue=\"Spain\"/>\n" +
            "                    <f:selectItem itemLabel=\"United States\" itemValue=\"United States\"/>\n" +
            "                </p:selectOneMenu>\n" +
            "            </div>\n" +
            "            <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                <label for=\"city2\" class=\"font-medium\">City</label>\n" +
            "                <p:inputText id=\"city2\"/>\n" +
            "            </div>\n" +
            "            <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                <label for=\"state2\" class=\"font-medium\">State</label>\n" +
            "                <p:inputText id=\"state2\"/>\n" +
            "            </div>\n" +
            "            <div class=\"surface-border border-top-1 opacity-50 mb-3 col-12\"></div>\n" +
            "            <div class=\"field mb-4 col-12\">\n" +
            "                <label for=\"website2\" class=\"font-medium\">Website</label>\n" +
            "                <div class=\"ui-inputgroup\">\n" +
            "                    <span class=\"ui-inputgroup-addon\">www</span>\n" +
            "                    <p:inputText id=\"website2\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"surface-border border-top-1 opacity-50 mb-3 col-12\"></div>\n" +
            "            <div class=\"field mb-4 col-12\">\n" +
            "                <label class=\"font-medium\">Privacy</label>\n" +
            "                <div class=\"flex align-items-center\">\n" +
            "                    <p:toggleSwitch/>\n" +
            "                    <span class=\"ml-2\">Share my data with contacts</span>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"surface-border border-top-1 opacity-50 mb-3 col-12\"></div>\n" +
            "            <div class=\"col-12\">\n" +
            "                <p:commandButton type=\"button\" value=\"Save Changes\" styleClass=\"w-auto mt-3\"/>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block3 = "<div class=\"surface-ground px-4 py-8 md:px-6 lg:px-8\">\n" +
            "    <div class=\"text-900 font-medium text-xl mb-3\">Create Invoice</div>\n" +
            "    <div class=\"surface-card p-4 shadow-2 border-round ui-fluid\">\n" +
            "        <div class=\"grid formgrid ui-fluid\">\n" +
            "            <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                <label for=\"company_name\" class=\"font-medium text-900\">Company Name</label>\n" +
            "                <p:inputText id=\"company_name\"/>\n" +
            "            </div>\n" +
            "            <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                <label for=\"invoice_id\" class=\"font-medium text-900\">Invoice Id</label>\n" +
            "                <p:inputText id=\"invoice_id\"/>\n" +
            "            </div>\n" +
            "            <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                <label for=\"customer_name\" class=\"font-medium text-900\">Customer Name</label>\n" +
            "                <p:inputText id=\"customer_name\"/>\n" +
            "            </div>\n" +
            "            <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                <label for=\"customer_email\" class=\"font-medium text-900\">Customer Email</label>\n" +
            "                <p:inputText id=\"customer_email\"/>\n" +
            "            </div>\n" +
            "            <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                <label for=\"invoice_date\" class=\"font-medium text-900\">Invoice Date</label>\n" +
            "                <p:calendar id=\"invoice_date\" showOn=\"button\"/>\n" +
            "            </div>\n" +
            "            <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                <label for=\"due_date\" class=\"font-medium text-900\">Due Date</label>\n" +
            "                <p:calendar id=\"due_date\" showOn=\"button\"/>\n" +
            "            </div>\n" +
            "            <div class=\"surface-border border-top-1 opacity-50 mb-4 col-12\"></div>\n" +
            "            <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                <label for=\"item\" class=\"font-medium text-900\">Item</label>\n" +
            "                <p:inputText id=\"item\"/>\n" +
            "            </div>\n" +
            "            <div class=\"field mb-4 col-6 md:col-3\">\n" +
            "                <label for=\"quantity\" class=\"font-medium text-900\">Quantity</label>\n" +
            "                <p:inputText id=\"quantity\"/>\n" +
            "            </div>\n" +
            "            <div class=\"field mb-4 col-6 md:col-3\">\n" +
            "                <label for=\"price\" class=\"font-medium text-900\">Price</label>\n" +
            "                <div class=\"flex align-content-center\">\n" +
            "                    <p:inputNumber id=\"price\" symbol=\" USD\" symbolPosition=\"s\" decimalSeparator=\",\" thousandSeparator=\".\" styleClass=\"flex-1\"/>\n" +
            "                    <p:commandButton type=\"button\" icon=\"pi pi-trash\" styleClass=\"ui-button-danger ui-button-flat ml-2\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"field mb-4 col-12 md:col-6\">\n" +
            "                <p:commandButton type=\"button\" value=\"Add Item\" icon=\"pi pi-plus\" styleClass=\"ui-button-secondary ui-button-outlined w-auto\"/>\n" +
            "            </div>\n" +
            "            <div class=\"field mb-4 col-12 md:col-6 text-right\">\n" +
            "                <span class=\"text-xl text-600 font-medium mr-2\">Total</span>\n" +
            "                <span class=\"text-xl text-900 font-medium\">$59</span>\n" +
            "            </div>\n" +
            "            <div class=\"field mb-4 col-12 flex align-items-center\">\n" +
            "                <p:selectBooleanCheckbox/>\n" +
            "                <span class=\"ml-2 text-900\">Taxable (VAT 18%)</span>\n" +
            "            </div>\n" +
            "            <div class=\"surface-border border-top-1 opacity-50 mb-4 col-12\"></div>\n" +
            "            <div class=\"field mb-4 col-12\">\n" +
            "                <label for=\"notes\" class=\"font-medium text-900\">Notes</label>\n" +
            "                <p:inputTextarea rows=\"5\" cols=\"33\"/>\n" +
            "            </div>\n" +
            "            <div class=\"surface-border border-top-1 opacity-50 mb-4 col-12\"></div>\n" +
            "        </div>\n" +
            "        <p:commandButton type=\"button\" value=\"Create Invoice\" icon=\"pi pi-file\" styleClass=\"w-auto\"/>\n" +
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

}
