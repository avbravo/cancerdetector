package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class DescriptionlistView implements Serializable {

    private final String block1 = "<div class=\"surface-section\">\n" +
            "    <div class=\"font-medium text-3xl text-900 mb-3\">Movie Information</div>\n" +
            "    <div class=\"text-500 mb-5\">Morbi tristique blandit turpis. In viverra ligula id nulla hendrerit rutrum.</div>\n" +
            "    <ul class=\"list-none p-0 m-0\">\n" +
            "        <li class=\"flex align-items-center py-3 px-2 border-top-1 surface-border flex-wrap\">\n" +
            "            <div class=\"text-500 w-6 md:w-2 font-medium\">Title</div>\n" +
            "            <div class=\"text-900 w-full md:w-8 md:flex-order-0 flex-order-1\">Heat</div>\n" +
            "            <div class=\"w-6 md:w-2 flex justify-content-end\">\n" +
            "                <p:commandButton type=\"button\" value=\"Edit\" icon=\"pi pi-pencil\"\n" +
            "                                 styleClass=\"ui-button-flat\"/>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex align-items-center py-3 px-2 border-top-1 surface-border flex-wrap\">\n" +
            "            <div class=\"text-500 w-6 md:w-2 font-medium\">Genre</div>\n" +
            "            <div class=\"text-900 w-full md:w-8 md:flex-order-0 flex-order-1\">\n" +
            "                <p:chip label=\"Crime\" styleClass=\"mr-2\"/>\n" +
            "                <p:chip label=\"Drama\" styleClass=\"mr-2\"/>\n" +
            "                <p:chip label=\"Thriller\"/>\n" +
            "            </div>\n" +
            "            <div class=\"w-6 md:w-2 flex justify-content-end\">\n" +
            "                <p:commandButton type=\"button\" value=\"Edit\" icon=\"pi pi-pencil\"\n" +
            "                                 styleClass=\"ui-button-flat\"/>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex align-items-center py-3 px-2 border-top-1 surface-border flex-wrap\">\n" +
            "            <div class=\"text-500 w-6 md:w-2 font-medium\">Director</div>\n" +
            "            <div class=\"text-900 w-full md:w-8 md:flex-order-0 flex-order-1\">Michael Mann</div>\n" +
            "            <div class=\"w-6 md:w-2 flex justify-content-end\">\n" +
            "                <p:commandButton type=\"button\" value=\"Edit\" icon=\"pi pi-pencil\"\n" +
            "                                 styleClass=\"ui-button-flat\"/>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex align-items-center py-3 px-2 border-top-1 surface-border flex-wrap\">\n" +
            "            <div class=\"text-500 w-6 md:w-2 font-medium\">Actors</div>\n" +
            "            <div class=\"text-900 w-full md:w-8 md:flex-order-0 flex-order-1\">Robert De Niro, Al Pacino</div>\n" +
            "            <div class=\"w-6 md:w-2 flex justify-content-end\">\n" +
            "                <p:commandButton type=\"button\" value=\"Edit\" icon=\"pi pi-pencil\"\n" +
            "                                 styleClass=\"ui-button-flat\"/>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex align-items-center py-3 px-2 border-top-1 border-bottom-1 surface-border flex-wrap\">\n" +
            "            <div class=\"text-500 w-6 md:w-2 font-medium\">Plot</div>\n" +
            "            <div class=\"text-900 w-full md:w-8 md:flex-order-0 flex-order-1 line-height-3\">\n" +
            "                A group of professional bank robbers start to feel the heat from police\n" +
            "                when they unknowingly leave a clue at their latest heist.\n" +
            "            </div>\n" +
            "            <div class=\"w-6 md:w-2 flex justify-content-end\">\n" +
            "                <p:commandButton type=\"button\" value=\"Edit\" icon=\"pi pi-pencil\"\n" +
            "                                 styleClass=\"ui-button-flat\"/>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "</div>" ;
    
    private final String block2 = "<div class=\"surface-card p-4 shadow-2 border-round\">\n" +
            "    <div class=\"font-medium text-3xl text-900 mb-3\">Movie Information</div>\n" +
            "    <div class=\"text-500 mb-5\">Morbi tristique blandit turpis. In viverra ligula id nulla hendrerit rutrum.</div>\n" +
            "    <ul class=\"list-none p-0 m-0\">\n" +
            "        <li class=\"flex align-items-center py-3 px-2 border-top-1 surface-border flex-wrap\">\n" +
            "            <div class=\"text-500 w-6 md:w-2 font-medium\">Title</div>\n" +
            "            <div class=\"text-900 w-full md:w-8 md:flex-order-0 flex-order-1\">Heat</div>\n" +
            "            <div class=\"w-6 md:w-2 flex justify-content-end\">\n" +
            "                <p:commandButton type=\"button\" value=\"Edit\" icon=\"pi pi-pencil\"\n" +
            "                                 styleClass=\"ui-button-flat\"/>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex align-items-center py-3 px-2 border-top-1 surface-border flex-wrap\">\n" +
            "            <div class=\"text-500 w-6 md:w-2 font-medium\">Genre</div>\n" +
            "            <div class=\"text-900 w-full md:w-8 md:flex-order-0 flex-order-1\">\n" +
            "                <p:chip label=\"Crime\" styleClass=\"mr-2\"/>\n" +
            "                <p:chip label=\"Drama\" styleClass=\"mr-2\"/>\n" +
            "                <p:chip label=\"Thriller\"/>\n" +
            "            </div>\n" +
            "            <div class=\"w-6 md:w-2 flex justify-content-end\">\n" +
            "                <p:commandButton type=\"button\" value=\"Edit\" icon=\"pi pi-pencil\"\n" +
            "                                 styleClass=\"ui-button-flat\"/>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex align-items-center py-3 px-2 border-top-1 surface-border flex-wrap\">\n" +
            "            <div class=\"text-500 w-6 md:w-2 font-medium\">Director</div>\n" +
            "            <div class=\"text-900 w-full md:w-8 md:flex-order-0 flex-order-1\">Michael Mann</div>\n" +
            "            <div class=\"w-6 md:w-2 flex justify-content-end\">\n" +
            "                <p:commandButton type=\"button\" value=\"Edit\" icon=\"pi pi-pencil\"\n" +
            "                                 styleClass=\"ui-button-flat\"/>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex align-items-center py-3 px-2 border-top-1 surface-border flex-wrap\">\n" +
            "            <div class=\"text-500 w-6 md:w-2 font-medium\">Actors</div>\n" +
            "            <div class=\"text-900 w-full md:w-8 md:flex-order-0 flex-order-1\">Robert De Niro, Al Pacino</div>\n" +
            "            <div class=\"w-6 md:w-2 flex justify-content-end\">\n" +
            "                <p:commandButton type=\"button\" value=\"Edit\" icon=\"pi pi-pencil\"\n" +
            "                                 styleClass=\"ui-button-flat\"/>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex align-items-center py-3 px-2 border-top-1 border-bottom-1 surface-border flex-wrap\">\n" +
            "            <div class=\"text-500 w-6 md:w-2 font-medium\">Plot</div>\n" +
            "            <div class=\"text-900 w-full md:w-8 md:flex-order-0 flex-order-1 line-height-3\">\n" +
            "                A group of professional bank robbers start to feel the heat from police\n" +
            "                when they unknowingly leave a clue at their latest heist.\n" +
            "            </div>\n" +
            "            <div class=\"w-6 md:w-2 flex justify-content-end\">\n" +
            "                <p:commandButton type=\"button\" value=\"Edit\" icon=\"pi pi-pencil\"\n" +
            "                                 styleClass=\"ui-button-flat\"/>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "</div>" ;

    private final String block3 = "<div class=\"surface-card p-4 shadow-2 border-round\">\n" +
            "    <div class=\"font-medium text-3xl text-900 mb-3\">Applicant Profile</div>\n" +
            "    <div class=\"text-500 mb-5\">Egestas sed tempus urna et pharetra pharetra massa massa ultricies.</div>\n" +
            "    <ul class=\"list-none p-0 m-0 border-top-1 surface-border\">\n" +
            "        <li class=\"flex align-items-center py-3 px-2 flex-wrap surface-50\">\n" +
            "            <div class=\"text-500 w-full md:w-2 font-medium\">Name</div>\n" +
            "            <div class=\"text-900 w-full md:w-10\">Elliot Alderson</div>\n" +
            "        </li>\n" +
            "        <li class=\"flex align-items-center py-3 px-2 flex-wrap\">\n" +
            "            <div class=\"text-500 w-full md:w-2 font-medium\">Bio</div>\n" +
            "            <div class=\"text-900 w-full md:w-10 line-height-3\">Faucibus pulvinar elementum integer enim neque volutpat ac tincidunt vitae. Commodo odio aenean sed adipiscing diam donec adipiscing tristique. Eget felis eget nunc lobortis mattis aliquam faucibus purus in.</div>\n" +
            "        </li>\n" +
            "        <li class=\"flex align-items-center py-3 px-2 flex-wrap surface-50\">\n" +
            "            <div class=\"text-500 w-full md:w-2 font-medium\">Salary Expectation</div>\n" +
            "            <div class=\"text-900 w-full md:w-10\">$150,000</div>\n" +
            "        </li>\n" +
            "        <li class=\"flex align-items-center py-3 px-2 flex-wrap\">\n" +
            "            <div class=\"text-500 w-full md:w-2 font-medium\">Skills</div>\n" +
            "            <div class=\"text-900 w-full md:w-10\">\n" +
            "                <p:tag styleClass=\"mr-2\" value=\"Algorithms\" rounded=\"true\"/>\n" +
            "                <p:tag styleClass=\"mr-2\" severity=\"success\" value=\"Javascript\" rounded=\"true\"/>\n" +
            "                <p:tag styleClass=\"mr-2\" severity=\"danger\" value=\"Python\" rounded=\"true\"/>\n" +
            "                <p:tag severity=\"warning\" value=\"SQL\" rounded=\"true\"/>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "        <li class=\"flex align-items-center py-3 px-2 flex-wrap surface-50\">\n" +
            "            <div class=\"text-500 w-full md:w-2 font-medium\">Repositories</div>\n" +
            "            <div class=\"text-900 w-full md:w-10\">\n" +
            "                <div class=\"grid mt-0 mr-0\">\n" +
            "                    <div class=\"col-12 md:col-6\">\n" +
            "                        <div class=\"p-3 border-1 surface-border border-round surface-card\">\n" +
            "                            <div class=\"text-900 mb-2\">\n" +
            "                                <i class=\"pi pi-github mr-2\"/>\n" +
            "                                <span class=\"font-medium\">PrimeFaces</span>\n" +
            "                            </div>\n" +
            "                            <div class=\"text-700\">Ultimate UI Component Suite for JavaServer Faces</div>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                    <div class=\"col-12 md:col-6\">\n" +
            "                        <div class=\"p-3 border-1 surface-border border-round surface-card\">\n" +
            "                            <div class=\"text-900 mb-2\">\n" +
            "                                <i class=\"pi pi-github mr-2\"/>\n" +
            "                                <span class=\"font-medium\">PrimeNG</span>\n" +
            "                            </div>\n" +
            "                            <div class=\"text-700\">The Most Complete Angular UI Component Library</div>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                    <div class=\"col-12 md:col-6\">\n" +
            "                        <div class=\"p-3 border-1 surface-border border-round surface-card\">\n" +
            "                            <div class=\"text-900 mb-2\">\n" +
            "                                <i class=\"pi pi-github mr-2\"/>\n" +
            "                                <span class=\"font-medium\">PrimeReact</span>\n" +
            "                            </div>\n" +
            "                            <div class=\"text-700\">Advanced UI Components for ReactJS</div>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                    <div class=\"col-12 md:col-6\">\n" +
            "                        <div class=\"p-3 border-1 surface-border border-round surface-card\">\n" +
            "                            <div class=\"text-900 mb-2\">\n" +
            "                                <i class=\"pi pi-github mr-2\"/>\n" +
            "                                <span class=\"font-medium\">PrimeVue</span>\n" +
            "                            </div>\n" +
            "                            <div class=\"text-700\">The Most Powerful Vue UI Component Library</div>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </li>\n" +
            "    </ul>\n" +
            "</div>" ;

    private final String block4 = "<div class=\"surface-card p-4 shadow-2 border-round\">\n" +
            "    <div class=\"font-medium text-3xl text-900 mb-3\">Applicant Profile</div>\n" +
            "    <div class=\"text-500 mb-5\">Egestas sed tempus urna et pharetra pharetra massa massa ultricies.</div>\n" +
            "    <div class=\"grid grid-nogutter border-top-1 surface-border pt-2\">\n" +
            "        <div class=\"col-12 md:col-6 p-3\">\n" +
            "            <div class=\"text-500 font-medium mb-2\">Name</div>\n" +
            "            <div class=\"text-900\">Elliot Alderson</div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 p-3\">\n" +
            "            <div class=\"text-500 font-medium mb-2\">Email</div>\n" +
            "            <div class=\"text-900\">elliot.alderson@email.com</div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 p-3\">\n" +
            "            <div class=\"text-500 font-medium mb-2\">Applied Position</div>\n" +
            "            <div class=\"text-900\">Front-End Developer</div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 p-3\">\n" +
            "            <div class=\"text-500 font-medium mb-2\">Salary Expectation</div>\n" +
            "            <div class=\"text-900\">$150,000</div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 p-3\">\n" +
            "            <div class=\"text-500 font-medium mb-2\">Bio</div>\n" +
            "            <div class=\"text-900 line-height-3\">Faucibus pulvinar elementum integer enim neque volutpat ac tincidunt vitae. Commodo odio aenean sed adipiscing diam donec adipiscing tristique. Eget felis eget nunc lobortis mattis aliquam faucibus purus in.</div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 p-3\">\n" +
            "            <div class=\"text-500 font-medium mb-3\">Files</div>\n" +
            "            <div class=\"flex md:align-items-center md:justify-content-between border-top-1 surface-border p-3 flex-column md:flex-row\">\n" +
            "                <div class=\"flex align-items-center\">\n" +
            "                    <span class=\"block pi pi-file mr-2\"/>\n" +
            "                    <span class=\"text-900\">resume_en.pdf</span>\n" +
            "                </div>\n" +
            "                <p:commandButton type=\"button\" icon=\"pi pi-download ml-2\" value=\"Download\"\n" +
            "                                 styleClass=\"ui-button-outlined pl-2 mt-2 md:mt-0\"/>\n" +
            "            </div>\n" +
            "            <div class=\"flex md:align-items-center md:justify-content-between border-top-1 border-bottom-1 surface-border p-3 flex-column md:flex-row\">\n" +
            "                <div class=\"flex align-items-center\">\n" +
            "                    <span class=\"block pi pi-file mr-2\"/>\n" +
            "                    <span class=\"text-900\">cover_letter_en.pdf</span>\n" +
            "                </div>\n" +
            "                <p:commandButton type=\"button\" icon=\"pi pi-download ml-2\" value=\"Download\"\n" +
            "                                 styleClass=\"ui-button-outlined pl-2 mt-2 md:mt-0\"/>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
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

    public String getBlock4() {
        return block4;
    }
}
