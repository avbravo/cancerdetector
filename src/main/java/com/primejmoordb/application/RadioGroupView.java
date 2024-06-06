package com.primejmoordb.application;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class RadioGroupView implements Serializable {

    private int animal = 1;

    private int tier1 = 1;

    private int tier2 = 1;

    private int hotel = 1;

    private int option = 1;

    private int payment = 1;

    public void changeAnimal() {
        String param1 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("value");
        animal = Integer.parseInt(param1);
    }

    public void changeTier1() {
        String param1 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("value");
        tier1 = Integer.parseInt(param1);
    }

    public void changeTier2() {
        String param1 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("value");
        tier2 = Integer.parseInt(param1);
    }

    public void changeHotel() {
        String param1 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("value");
        hotel = Integer.parseInt(param1);
    }

    public void changeOption() {
        String param1 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("value");
        option = Integer.parseInt(param1);
    }
    
    public void changePayment() {
        String param1 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("value");
        payment = Integer.parseInt(param1);
    }

    private final String block1 = "<div class=\"w-full\">\n" +
            "    <div class=\"text-900 text-xl mb-3 text-left font-medium\">Choose your favorite animal</div>\n" +
            "    <div class=\"border-1 p-4 mb-3 border-round flex flex-column md:flex-row align-items-start md:align-items-center md:justify-content-between cursor-pointer #{radioGroupView.animal eq 0 ? ' bg-primary border-primary ' : ' surface-card surface-border '}\"\n" +
            "         onclick=\"changeAnimal([{name:'value', value:0}])\">\n" +
            "        <div class=\"flex align-items-start mr-0 md:mr-8\">\n" +
            "            <p:graphicImage name=\"images/blocks/animals/a1.jpg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                            styleClass=\"mr-3\" style=\"width:50px\"/>\n" +
            "            <div>\n" +
            "                <div class=\"font-medium mb-2 #{radioGroupView.animal eq 0 ? ' bg-primary ' : ' text-900 '}\">Owl</div>\n" +
            "                <span class=\"p-1 border-round #{radioGroupView.animal eq 0 ? ' bg-primary-reverse ' : ' surface-100 text-600 '}\">Sharp Talons</span>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"ml-0 md:ml-8 mt-2 md:mt-0 border-1 p-1 px-2 border-round flex align-items-center #{radioGroupView.animal eq 0 ? ' bg-primary-reverse ' : ' surface-100 text-600 surface-border '}\">\n" +
            "            <i class=\"pi pi-users mr-2\"/>\n" +
            "            <span>702</span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"border-1 p-4 mb-3 border-round flex flex-column md:flex-row align-items-start md:align-items-center md:justify-content-between cursor-pointer #{radioGroupView.animal eq 1 ? ' bg-primary border-primary ' : ' surface-card surface-border '}\"\n" +
            "         onclick=\"changeAnimal([{name:'value', value:1}])\">\n" +
            "        <div class=\"flex align-items-start mr-0 md:mr-8\">\n" +
            "            <p:graphicImage name=\"images/blocks/animals/a2.jpg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                            styleClass=\"mr-3\" style=\"width:50px\"/>\n" +
            "            <div>\n" +
            "                <div class=\"font-medium mb-2 #{radioGroupView.animal eq 1 ? ' bg-primary ' : ' text-900 '}\">Fox</div>\n" +
            "                <span class=\"p-1 border-round #{radioGroupView.animal eq 1 ? ' bg-primary-reverse ' : ' surface-100 text-600 '}\">Upturned Snout</span>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"ml-0 md:ml-8 mt-2 md:mt-0 border-1 p-1 px-2 border-round flex align-items-center #{radioGroupView.animal eq 1 ? ' bg-primary-reverse ' : ' surface-100 text-600 surface-border '}\">\n" +
            "            <i class=\"pi pi-users mr-2\"/>\n" +
            "            <span>702</span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"border-1 p-4 border-round flex flex-column md:flex-row align-items-start md:align-items-center md:justify-content-between cursor-pointer #{radioGroupView.animal eq 2 ? ' bg-primary border-primary ' : ' surface-card surface-border '}\"\n" +
            "         onclick=\"changeAnimal([{name:'value', value:2}])\">\n" +
            "        <div class=\"flex align-items-start mr-0 md:mr-8\">\n" +
            "            <p:graphicImage name=\"images/blocks/animals/a3.jpg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                            styleClass=\"mr-3\" style=\"width:50px\"/>\n" +
            "            <div>\n" +
            "                <div class=\"font-medium mb-2 #{radioGroupView.animal eq 2 ? ' bg-primary ' : ' text-900 '}\">Sheep</div>\n" +
            "                <span class=\"p-1 border-round #{radioGroupView.animal eq 2 ? ' bg-primary-reverse ' : ' surface-100 text-600 '}\">Just Sheep</span>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"ml-0 md:ml-8 mt-2 md:mt-0 border-1 p-1 px-2 border-round flex align-items-center #{radioGroupView.animal eq 2 ? ' bg-primary-reverse ' : ' surface-100 text-600 surface-border '}\">\n" +
            "            <i class=\"pi pi-users mr-2\"/>\n" +
            "            <span>529</span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "<p:remoteCommand name=\"changeAnimal\" update=\"@form\" action=\"#{radioGroupView.changeAnimal}\"/>" ;
    
    private final String block2 = "<div class=\"w-full\">\n" +
            "    <div class=\"text-900 text-xl mb-3 text-left font-medium\">Change your account tier1</div>\n" +
            "    <div class=\"surface-border border-1 p-3 border-round-top flex align-items-center cursor-pointer #{radioGroupView.tier1 eq 0 ? ' bg-primary ' : ' surface-card '}\"\n" +
            "         onclick=\"changeTier1([{name:'value', value:0}])\">\n" +
            "        <p:radioButton for=\"customRadio\" itemIndex=\"0\" styleClass=\"mr-3\"/>\n" +
            "        <div class=\"mr-4 md:mr-8\">\n" +
            "            <div class=\"font-medium mb-1 #{radioGroupView.tier1 eq 0 ? ' bg-primary ' : ' text-900 '}\">Basic\n" +
            "            </div>\n" +
            "            <span class=\"text-sm #{radioGroupView.tier1 eq 0 ? ' bg-primary ' : ' text-600 '}\">Quam nulla porttitor massa.</span>\n" +
            "        </div>\n" +
            "        <div class=\"border-round border-1 p-1 ml-auto flex flex-nowrap #{radioGroupView.tier1 eq 0 ? ' bg-primary-reverse ' : ' surface-50 text-600 surface-border '}\">\n" +
            "            <i class=\"pi pi-star\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"surface-border border-1 border-top-none p-3 flex align-items-center cursor-pointer #{radioGroupView.tier1 eq 1 ? ' bg-primary ' : ' surface-card '}\"\n" +
            "         onclick=\"changeTier1([{name:'value', value:1}])\">\n" +
            "        <p:radioButton for=\"customRadio\" itemIndex=\"1\" styleClass=\"mr-3\"/>\n" +
            "        <div class=\"mr-4 md:mr-8\">\n" +
            "            <div class=\"font-medium mb-1 #{radioGroupView.tier1 eq 1 ? ' bg-primary ' : ' text-900 '}\">Premium\n" +
            "            </div>\n" +
            "            <span class=\"text-sm #{radioGroupView.tier1 eq 1 ? ' bg-primary ' : ' text-600 '}\">Quam nulla porttitor massa.</span>\n" +
            "        </div>\n" +
            "        <div class=\"border-round border-1 p-1 ml-auto flex flex-nowrap #{radioGroupView.tier1 eq 1 ? ' bg-primary-reverse ' : ' surface-50 text-600 surface-border '}\">\n" +
            "            <i class=\"pi pi-star mr-2\"/>\n" +
            "            <i class=\"pi pi-star\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"surface-border border-1 border-top-none p-3 border-round-bottom flex align-items-center cursor-pointer #{radioGroupView.tier1 eq 2 ? ' bg-primary ' : ' surface-card '}\"\n" +
            "         onclick=\"changeTier1([{name:'value', value:2}])\">\n" +
            "        <p:radioButton for=\"customRadio\" itemIndex=\"2\" styleClass=\"mr-3\"/>\n" +
            "        <div class=\"mr-4 md:mr-8\">\n" +
            "            <div class=\"font-medium mb-1 #{radioGroupView.tier1 eq 2 ? ' bg-primary ' : ' text-900 '}\">Enterprise\n" +
            "            </div>\n" +
            "            <span class=\"text-sm #{radioGroupView.tier1 eq 2 ? ' bg-primary ' : ' text-600 '}\">Quam nulla porttitor massa.</span>\n" +
            "        </div>\n" +
            "        <div class=\"border-round border-1 p-1 ml-auto flex flex-nowrap #{radioGroupView.tier1 eq 2 ? ' bg-primary-reverse ' : ' surface-50 text-600 surface-border '}\">\n" +
            "            <i class=\"pi pi-star mr-2\"/>\n" +
            "            <i class=\"pi pi-star mr-2\"/>\n" +
            "            <i class=\"pi pi-star\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "<p:selectOneRadio id=\"customRadio\" value=\"#{radioGroupView.tier1}\" layout=\"custom\">\n" +
            "    <p:ajax update=\"@form\"/>\n" +
            "    <f:selectItem itemLabel=\"0\" itemValue=\"0\"/>\n" +
            "    <f:selectItem itemLabel=\"1\" itemValue=\"1\"/>\n" +
            "    <f:selectItem itemLabel=\"2\" itemValue=\"2\"/>\n" +
            "</p:selectOneRadio>\n" +
            "<p:remoteCommand name=\"changeTier1\" update=\"@form\" action=\"#{radioGroupView.changeTier1}\"/>" ;

    private final String block3 = "<div class=\"w-full\">\n" +
            "    <div class=\"text-900 text-xl mb-3 text-left font-medium\">Change your account tier</div>\n" +
            "    <div class=\"surface-border border-1 p-3 border-round-top flex align-items-center cursor-pointer #{radioGroupView.tier2 eq 0 ? ' bg-primary ' : ' surface-card '}\"\n" +
            "         onclick=\"changeTier2([{name:'value', value:0}])\">\n" +
            "        <div class=\"w-4 flex align-items-center pr-4\">\n" +
            "            <p:radioButton for=\"customRadio2\" itemIndex=\"0\" styleClass=\"mr-2\"/>\n" +
            "            <div class=\"font-medium #{radioGroupView.tier2 eq 0 ? ' bg-primary ' : ' text-900 '}\">Basic</div>\n" +
            "        </div>\n" +
            "        <div class=\"w-4 text-center\">\n" +
            "            <span class=\"bg-blue-100 text-blue-700 font-medium px-2 py-1\"\n" +
            "                  style=\"border-radius:12px\">Save 20%</span>\n" +
            "        </div>\n" +
            "        <div class=\"w-4 text-right\">\n" +
            "            <span class=\"font-medium #{radioGroupView.tier2 eq 0 ? ' bg-primary ' : ' text-900 '}\">19$</span>\n" +
            "            <span class=\"#{radioGroupView.tier2 eq 0 ? ' bg-primary ' : ' text-600 '}\"> / Month</span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"surface-border border-1 p-3 border-top-none flex align-items-center cursor-pointer  #{radioGroupView.tier2 eq 1 ? ' bg-primary ' : ' surface-card '}\"\n" +
            "         onclick=\"changeTier2([{name:'value', value:1}])\">\n" +
            "        <div class=\"w-4 flex align-items-center pr-4\">\n" +
            "            <p:radioButton for=\"customRadio2\" itemIndex=\"1\" styleClass=\"mr-2\"/>\n" +
            "            <div class=\"font-medium #{radioGroupView.tier2 eq 1 ? ' bg-primary ' : ' text-900 '}\">Premium</div>\n" +
            "        </div>\n" +
            "        <div class=\"w-4 text-center\">\n" +
            "            <span class=\"bg-blue-100 text-blue-700 font-medium px-2 py-1\"\n" +
            "                  style=\"border-radius:12px\">Save 25%</span>\n" +
            "        </div>\n" +
            "        <div class=\"w-4 text-right\">\n" +
            "            <span class=\"font-medium #{radioGroupView.tier2 eq 1 ? ' bg-primary ' : ' text-900 '}\">29$</span>\n" +
            "            <span class=\"#{radioGroupView.tier2 eq 1 ? ' bg-primary ' : ' text-600 '}\"> / Month</span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"surface-border border-1 border-top-none p-3 border-round-bottom flex align-items-center cursor-pointer  #{radioGroupView.tier2 eq 2 ? ' bg-primary ' : ' surface-card '}\"\n" +
            "         onclick=\"changeTier2([{name:'value', value:2}])\">\n" +
            "        <div class=\"w-4 flex align-items-center pr-4\">\n" +
            "            <p:radioButton for=\"customRadio2\" itemIndex=\"2\" styleClass=\"mr-2\"/>\n" +
            "            <div class=\"font-medium #{radioGroupView.tier2 eq 2 ? ' bg-primary ' : ' text-900 '}\">Enterprise</div>\n" +
            "        </div>\n" +
            "        <div class=\"w-4 text-center\">\n" +
            "            <span class=\"bg-blue-100 text-blue-700 font-medium px-2 py-1\"\n" +
            "                  style=\"border-radius:12px\">Save 50%</span>\n" +
            "        </div>\n" +
            "        <div class=\"w-4 text-right\">\n" +
            "            <span class=\"font-medium #{radioGroupView.tier2 eq 2 ? ' bg-primary ' : ' text-900 '}\">39$</span>\n" +
            "            <span class=\"#{radioGroupView.tier2 eq 2 ? ' bg-primary ' : ' text-600 '}\"> / Month</span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "<p:selectOneRadio id=\"customRadio2\" value=\"#{radioGroupView.tier2}\" layout=\"custom\">\n" +
            "    <p:ajax update=\"@form\"/>\n" +
            "    <f:selectItem itemLabel=\"0\" itemValue=\"0\"/>\n" +
            "    <f:selectItem itemLabel=\"1\" itemValue=\"1\"/>\n" +
            "    <f:selectItem itemLabel=\"2\" itemValue=\"2\"/>\n" +
            "</p:selectOneRadio>\n" +
            "<p:remoteCommand name=\"changeTier2\" update=\"@form\" action=\"#{radioGroupView.changeTier2}\"/>" ;

    private final String block4 = "<div class=\"text-center\">\n" +
            "    <div class=\"text-900 font-medium text-2xl mb-3\">Choose your Adventure</div>\n" +
            "    <div class=\"text-700 line-height-3 mb-4\">Volutpat est velit egestas dui id ornare arcu odio. Amet dictum sit amet justo.</div>\n" +
            "    <div class=\"grid\">\n" +
            "        <div class=\"col-12 lg:col-4\">\n" +
            "            <div class=\"shadow-2 border-round border-2 cursor-pointer surface-card #{radioGroupView.hotel eq 0 ? ' border-blue-500 ' : ' border-transparent '}\"\n" +
            "                 onclick=\"changeHotel([{name:'value', value:0}])\">\n" +
            "                <p:graphicImage name=\"images/blocks/hotels/h1.jpg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"w-full\"/>\n" +
            "                <div class=\"p-3\">\n" +
            "                    <div class=\"text-900 text-xl mb-3 font-medium\">Tranquility Point</div>\n" +
            "                    <p class=\"m-0 mb-3\">Praesent semper feugiat nibh sed pulvinar.</p>\n" +
            "                    <div class=\"text-yellow-500 mb-4\">\n" +
            "                        <i class=\"pi pi-star mr-1\"/>\n" +
            "                        <i class=\"pi pi-star mr-1\"/>\n" +
            "                        <i class=\"pi pi-star mr-1\"/>\n" +
            "                        <i class=\"pi pi-star mr-1\"/>\n" +
            "                        <i class=\"pi pi-star\"/>\n" +
            "                    </div>\n" +
            "                    <p:radioButton for=\"customRadio3\" itemIndex=\"0\" styleClass=\"mr-2\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 lg:col-4\">\n" +
            "            <div class=\"shadow-2 border-round border-2 cursor-pointer surface-card #{radioGroupView.hotel eq 1 ? ' border-blue-500 ' : ' border-transparent '}\"\n" +
            "                 onclick=\"changeHotel([{name:'value', value:1}])\">\n" +
            "                <p:graphicImage name=\"images/blocks/hotels/h2.jpg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"w-full\"/>\n" +
            "                <div class=\"p-3\">\n" +
            "                    <div class=\"text-900 text-xl mb-3 font-medium\">Paradise Hotel</div>\n" +
            "                    <p class=\"m-0 mb-3\">Volutpat est velit egestas dui id ornare arcu odio.</p>\n" +
            "                    <div class=\"text-yellow-500 mb-4\">\n" +
            "                        <i class=\"pi pi-star mr-1\"/>\n" +
            "                        <i class=\"pi pi-star mr-1\"/>\n" +
            "                        <i class=\"pi pi-star mr-1\"/>\n" +
            "                        <i class=\"pi pi-star mr-1\"/>\n" +
            "                        <i class=\"pi pi-star\"/>\n" +
            "                    </div>\n" +
            "                    <p:radioButton for=\"customRadio3\" itemIndex=\"1\" styleClass=\"mr-2\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 lg:col-4\">\n" +
            "            <div class=\"shadow-2 border-round border-2 cursor-pointer surface-card #{radioGroupView.hotel eq 2 ? ' border-blue-500 ' : ' border-transparent '}\"\n" +
            "                 onclick=\"changeHotel([{name:'value', value:2}])\">\n" +
            "                <p:graphicImage name=\"images/blocks/hotels/h3.jpg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"w-full\"/>\n" +
            "                <div class=\"p-3\">\n" +
            "                    <div class=\"text-900 text-xl mb-3 font-medium\">Horizon Hill</div>\n" +
            "                    <p class=\"m-0 mb-3\">Ultrices in iaculis nunc sed augue lacus.</p>\n" +
            "                    <div class=\"text-yellow-500 mb-4\">\n" +
            "                        <i class=\"pi pi-star mr-1\"/>\n" +
            "                        <i class=\"pi pi-star mr-1\"/>\n" +
            "                        <i class=\"pi pi-star mr-1\"/>\n" +
            "                        <i class=\"pi pi-star mr-1\"/>\n" +
            "                        <i class=\"pi pi-star\"/>\n" +
            "                    </div>\n" +
            "                    <p:radioButton for=\"customRadio3\" itemIndex=\"2\" styleClass=\"mr-2\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "<p:selectOneRadio id=\"customRadio3\" value=\"#{radioGroupView.hotel}\" layout=\"custom\">\n" +
            "    <p:ajax update=\"@form\"/>\n" +
            "    <f:selectItem itemLabel=\"0\" itemValue=\"0\"/>\n" +
            "    <f:selectItem itemLabel=\"1\" itemValue=\"1\"/>\n" +
            "    <f:selectItem itemLabel=\"2\" itemValue=\"2\"/>\n" +
            "</p:selectOneRadio>\n" +
            "<p:remoteCommand name=\"changeHotel\" update=\"@form\" action=\"#{radioGroupView.changeHotel}\"/>" ;

    private final String block5 = "<div>\n" +
            "    <div class=\"surface-ground px-4 py-8 md:px-6 lg:px-8\">\n" +
            "        <div class=\"text-900 text-xl font-medium mb-3 text-center\">Subscription Options</div>\n" +
            "        <p class=\"text-700 mt-0 mb-4 text-center\">Volutpat est velit egestas dui id ornare arcu odio. Amet dictum sit amet justo.</p>\n" +
            "        <div class=\"surface-card shadow-2 border-round p-5\">\n" +
            "            <div class=\"grid\">\n" +
            "                <div class=\"col-12 sm:col-6 lg:col-3 p-3 flex align-items-center sm:justify-content-center sm:border-right-1 border-bottom-1 lg:border-bottom-none surface-border cursor-pointer\" \n" +
            "                    onclick=\"changeOption([{name:'value', value:0}])\">\n" +
            "                    <div class=\"flex align-items-center mr-3\">\n" +
            "                        <p:radioButton for=\"customRadio4\" itemIndex=\"0\"/>\n" +
            "                    </div>\n" +
            "                    <div>\n" +
            "                        <span class=\"text-900 text-2xl font-medium\">10 Days</span>\n" +
            "                        <p class=\"text-xl text-500 font-medium mt-2 mb-0\">In tellus integer</p>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"col-12 sm:col-6 lg:col-3 p-3 flex align-items-center sm:justify-content-center lg:border-right-1 border-bottom-1 lg:border-bottom-none surface-border cursor-pointer\"\n" +
            "                    onclick=\"changeOption([{name:'value', value:1}])\">\n" +
            "                    <div class=\"flex align-items-center mr-3\">\n" +
            "                        <p:radioButton for=\"customRadio4\" itemIndex=\"1\"/>\n" +
            "                    </div>\n" +
            "                    <div>\n" +
            "                        <span class=\"text-900 text-2xl font-medium\">30 Days</span>\n" +
            "                        <p class=\"text-xl text-500 font-medium mt-2 mb-0\">Risus pretium</p>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"col-12 sm:col-6 lg:col-3 p-3 flex align-items-center sm:justify-content-center sm:border-right-1 border-bottom-1 sm:border-bottom-none surface-border cursor-pointer\" \n" +
            "                    onclick=\"changeOption([{name:'value', value:2}])\">\n" +
            "                    <div class=\"flex align-items-center mr-3\">\n" +
            "                        <p:radioButton for=\"customRadio4\" itemIndex=\"2\"/>\n" +
            "                    </div>\n" +
            "                    <div>\n" +
            "                        <span class=\"text-900 text-2xl font-medium\">90 Days</span>\n" +
            "                        <p class=\"text-xl text-500 font-medium mt-2 mb-0\">Pharetra pharetra</p>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"col-12 sm:col-6 lg:col-3 p-3 flex align-items-center sm:justify-content-center cursor-pointer\" \n" +
            "                    onclick=\"changeOption([{name:'value', value:3}])\">\n" +
            "                    <div class=\"flex align-items-center mr-3\">\n" +
            "                        <p:radioButton for=\"customRadio4\" itemIndex=\"3\"/>\n" +
            "                    </div>\n" +
            "                    <div>\n" +
            "                        <span class=\"text-900 text-2xl font-medium\">360 Days</span>\n" +
            "                        <p class=\"text-xl text-500 font-medium mt-2 mb-0\">Aliquet lectus</p>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <p:selectOneRadio id=\"customRadio4\" value=\"#{radioGroupView.option}\" layout=\"custom\">\n" +
            "        <p:ajax update=\"@form\"/>\n" +
            "        <f:selectItem itemLabel=\"0\" itemValue=\"0\"/>\n" +
            "        <f:selectItem itemLabel=\"1\" itemValue=\"1\"/>\n" +
            "        <f:selectItem itemLabel=\"2\" itemValue=\"2\"/>\n" +
            "        <f:selectItem itemLabel=\"3\" itemValue=\"3\"/>\n" +
            "    </p:selectOneRadio>\n" +
            "    <p:remoteCommand name=\"changeOption\" update=\"@form\" action=\"#{radioGroupView.changeOption}\"/>\n" +
            "</div>\n" ;

    private final String block6 = "<div class=\"surface-ground px-4 py-8 md:px-6 lg:px-8\">\n" +
            "    <div class=\"text-900 text-xl font-medium mb-3 text-center\">Payment Methods</div>\n" +
            "    <p class=\"text-700 mt-0 mb-4 text-center\">In tellus integer feugiat scelerisque varius morbi.</p>\n" +
            "    <div class=\"grid\">\n" +
            "        <div class=\"col-12 lg:col-6 p-3\">\n" +
            "            <div class=\"shadow-2 surface-card p-4 border-2 cursor-pointer #{radioGroupView.payment eq 0 ? ' border-blue-500 ' : ' border-transparent '}\" \n" +
            "            style=\"border-radius: 10px\" onclick=\"changePayment([{name:'value', value:0}])\">\n" +
            "                <div class=\"flex align-items-center mb-4\">\n" +
            "                    <div class=\"mr-3\">\n" +
            "                        <span class=\"inline-flex justify-content-center align-items-center bg-indigo-100\" style=\"border-radius: 4px; width:45px; height: 45px\">\n" +
            "                            <i class=\"pi pi-credit-card text-2xl text-indigo-600\"></i>\n" +
            "                        </span>\n" +
            "                    </div>\n" +
            "                    <div>\n" +
            "                        <span class=\"text-900 text-xl mb-2 font-medium\">Credit Card</span>\n" +
            "                        <p class=\"m-0 text-600 font-medium text-sm\">Magna fermentum iaculis</p>\n" +
            "                    </div>\n" +
            "                    <p:radioButton for=\"customRadio5\" itemIndex=\"0\" styleClass=\"ml-auto\"/>\n" +
            "                </div>\n" +
            "                <p class=\"text-600 m-0 line-height-3\">Nunc consequat interdum varius sit. Commodo odio aenean sed adipiscing diam donec adipiscing tristique risus.</p>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 lg:col-6 p-3\">\n" +
            "            <div class=\"shadow-2 surface-card p-4 border-2 border-transparent cursor-pointer #{radioGroupView.payment eq 1 ? ' border-blue-500 ' : ' border-transparent '}\"\n" +
            "            style=\"border-radius: 10px\" onclick=\"changePayment([{name:'value', value:1}])\">\n" +
            "                <div class=\"flex align-items-center mb-4\">\n" +
            "                    <div class=\"mr-3\">\n" +
            "                        <span class=\"inline-flex justify-content-center align-items-center bg-blue-100\" style=\"border-radius: 4px; width:45px; height: 45px\">\n" +
            "                            <p:graphicImage name=\"images/blocks/logos/paypal.svg\" library=\"primeblocks-app\" alt=\"Image\" style=\"height:1.5rem\"/>\n" +
            "                        </span>\n" +
            "                    </div>\n" +
            "                    <div>\n" +
            "                        <span class=\"text-900 text-xl mb-2 font-medium\">PayPal</span>\n" +
            "                        <p class=\"m-0 text-600 font-medium text-sm\">Nibh sit amet</p>\n" +
            "                    </div>\n" +
            "                    <p:radioButton for=\"customRadio5\" itemIndex=\"1\" styleClass=\"ml-auto\"/>\n" +
            "                </div>\n" +
            "                <p class=\"text-600 m-0 line-height-3\">Est pellentesque elit ullamcorper dignissim. Tortor condimentum lacinia quis vel eros. Pharetra magna ac placerat vestibulum lectus mauris ultrices.</p>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 lg:col-6 p-3\">\n" +
            "            <div class=\"shadow-2 surface-card p-4 border-2 border-transparent cursor-pointer #{radioGroupView.payment eq 2 ? ' border-blue-500 ' : ' border-transparent '}\" \n" +
            "                style=\"border-radius: 10px\"  onclick=\"changePayment([{name:'value', value:2}])\">\n" +
            "                <div class=\"flex align-items-center mb-4\">\n" +
            "                    <div class=\"mr-3\">\n" +
            "                        <span class=\"inline-flex justify-content-center align-items-center bg-green-100\" style=\"border-radius: 4px; width:45px; height: 45px\">\n" +
            "                            <i class=\"pi pi-credit-card text-2xl text-green-600\"></i>\n" +
            "                        </span>\n" +
            "                    </div>\n" +
            "                    <div>\n" +
            "                        <span class=\"text-900 text-xl mb-2 font-medium\">Wire Transfer</span>\n" +
            "                        <p class=\"m-0 text-600 font-medium text-sm\">Ornare lectus sit</p>\n" +
            "                    </div>\n" +
            "                    <p:radioButton for=\"customRadio5\" itemIndex=\"2\" styleClass=\"ml-auto\"/>\n" +
            "                </div>\n" +
            "                <p class=\"text-600 m-0 line-height-3\">Eget nunc lobortis mattis aliquam. Dictumst vestibulum rhoncus est pellentesque elit ullamcorper dignissim.</p>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 lg:col-6 p-3\">\n" +
            "            <div class=\"shadow-2 surface-card p-4 border-2 border-transparent cursor-pointer #{radioGroupView.payment eq 3 ? ' border-blue-500 ' : ' border-transparent '}\" \n" +
            "                style=\"border-radius: 10px\" onclick=\"changePayment([{name:'value', value:3}])\">\n" +
            "                <div class=\"flex align-items-center mb-4\">\n" +
            "                    <div class=\"mr-3\">\n" +
            "                        <span class=\"inline-flex justify-content-center align-items-center bg-orange-100\" style=\"border-radius: 4px; width:45px; height: 45px\">\n" +
            "                            <p:graphicImage name=\"images/blocks/logos/bitcoin.svg\" library=\"primeblocks-app\" alt=\"Image\" style=\"height:1.5rem\"/>\n" +
            "                        </span>\n" +
            "                    </div>\n" +
            "                    <div>\n" +
            "                        <span class=\"text-900 text-xl mb-2 font-medium\">BitCoin</span>\n" +
            "                        <p class=\"m-0 text-600 font-medium text-sm\">Donec adipiscing tristique</p>\n" +
            "                    </div>\n" +
            "                    <p:radioButton for=\"customRadio5\" itemIndex=\"3\" styleClass=\"ml-auto\"/>\n" +
            "                </div>\n" +
            "                <p class=\"text-600 m-0 line-height-3\">Pharetra magna ac placerat vestibulum lectus mauris ultrices. Nec dui nunc mattis enim ut tellus elementum sagittis vitae.</p>\n" +
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
    
    public String getBlock6() {
        return block6;
    }

    public int getAnimal() {
        return animal;
    }

    public void setAnimal(int animal) {
        this.animal = animal;
    }

    public int getTier1() {
        return tier1;
    }

    public void setTier1(int tier1) {
        this.tier1 = tier1;
    }

    public int getTier2() {
        return tier2;
    }

    public void setTier2(int tier2) {
        this.tier2 = tier2;
    }

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

}
