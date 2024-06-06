package com.primejmoordb.application;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class StatsAppView implements Serializable {

    private final String block1 = "<div class=\"grid\">\n" +
            "    <div class=\"col-12 md:col-6 lg:col-3\">\n" +
            "        <div class=\"surface-card shadow-2 p-3 border-round\">\n" +
            "            <div class=\"flex justify-content-between mb-3\">\n" +
            "                <div>\n" +
            "                    <span class=\"block text-500 font-medium mb-3\">Orders</span>\n" +
            "                    <div class=\"text-900 font-medium text-xl\">152</div>\n" +
            "                </div>\n" +
            "                <div class=\"flex align-items-center justify-content-center bg-blue-100 border-round\"\n" +
            "                     style=\"width:2.5rem;height:2.5rem\">\n" +
            "                    <i class=\"pi pi-shopping-cart text-blue-500 text-xl\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <span class=\"text-green-500 font-medium\">24 new </span>\n" +
            "            <span class=\"text-500\">since last visit</span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"col-12 md:col-6 lg:col-3\">\n" +
            "        <div class=\"surface-card shadow-2 p-3 border-round\">\n" +
            "            <div class=\"flex justify-content-between mb-3\">\n" +
            "                <div>\n" +
            "                    <span class=\"block text-500 font-medium mb-3\">Revenue</span>\n" +
            "                    <div class=\"text-900 font-medium text-xl\">$2.100</div>\n" +
            "                </div>\n" +
            "                <div class=\"flex align-items-center justify-content-center bg-orange-100 border-round\"\n" +
            "                     style=\"width:2.5rem;height:2.5rem\">\n" +
            "                    <i class=\"pi pi-map-marker text-orange-500 text-xl\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <span class=\"text-green-500 font-medium\">%52+ </span>\n" +
            "            <span class=\"text-500\">since last week</span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"col-12 md:col-6 lg:col-3\">\n" +
            "        <div class=\"surface-card shadow-2 p-3 border-round\">\n" +
            "            <div class=\"flex justify-content-between mb-3\">\n" +
            "                <div>\n" +
            "                    <span class=\"block text-500 font-medium mb-3\">Customers</span>\n" +
            "                    <div class=\"text-900 font-medium text-xl\">28441</div>\n" +
            "                </div>\n" +
            "                <div class=\"flex align-items-center justify-content-center bg-cyan-100 border-round\"\n" +
            "                     style=\"width:2.5rem;height:2.5rem\">\n" +
            "                    <i class=\"pi pi-inbox text-cyan-500 text-xl\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <span class=\"text-green-500 font-medium\">520  </span>\n" +
            "            <span class=\"text-500\">newly registered</span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"col-12 md:col-6 lg:col-3\">\n" +
            "        <div class=\"surface-card shadow-2 p-3 border-round\">\n" +
            "            <div class=\"flex justify-content-between mb-3\">\n" +
            "                <div>\n" +
            "                    <span class=\"block text-500 font-medium mb-3\">Comments</span>\n" +
            "                    <div class=\"text-900 font-medium text-xl\">152 Unread</div>\n" +
            "                </div>\n" +
            "                <div class=\"flex align-items-center justify-content-center bg-purple-100 border-round\"\n" +
            "                     style=\"width:2.5rem;height:2.5rem\">\n" +
            "                    <i class=\"pi pi-comment text-purple-500 text-xl\"/>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <span class=\"text-green-500 font-medium\">85 </span>\n" +
            "            <span class=\"text-500\">responded</span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;
    
    private final String block2 = "<div class=\"surface-card shadow-2 border-round flex p-3 flex-column md:flex-row\">\n" +
            "    <div class=\"border-bottom-1 md:border-right-1 md:border-bottom-none surface-border flex-auto p-3\">\n" +
            "        <div class=\"flex align-items-center mb-3\">\n" +
            "            <i class=\"pi pi-shopping-cart text-blue-500 text-xl mr-2\"/>\n" +
            "            <span class=\"text-500 font-medium\">Orders</span>\n" +
            "        </div>\n" +
            "        <span class=\"block text-900 font-medium mb-4 text-xl\">152 New</span>\n" +
            "        <div class=\"flex align-items-center\">\n" +
            "            <i class=\"pi pi-arrow-down text-pink-500 text-xl mr-2\"/>\n" +
            "            <span class=\"text-pink-500 font-medium \">-25</span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"border-bottom-1 md:border-right-1 md:border-bottom-none surface-border flex-auto p-3\">\n" +
            "        <div class=\"flex align-items-center mb-3\">\n" +
            "            <i class=\"pi pi-shopping-cart text-orange-500 text-xl mr-2\"/>\n" +
            "            <span class=\"text-500 font-medium\">Revenue</span>\n" +
            "        </div>\n" +
            "        <span class=\"block text-900 font-medium mb-4 text-xl\">$1500</span>\n" +
            "        <div class=\"flex align-items-center\">\n" +
            "            <i class=\"pi pi-arrow-up text-green-500 text-xl mr-2\"/>\n" +
            "            <span class=\"text-green-500 font-medium \">+15</span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"border-bottom-1 md:border-right-1 md:border-bottom-none surface-border flex-auto p-3\">\n" +
            "        <div class=\"flex align-items-center mb-3\">\n" +
            "            <i class=\"pi pi-users text-cyan-500 text-xl mr-2\"/>\n" +
            "            <span class=\"text-500 font-medium\">Customers</span>\n" +
            "        </div>\n" +
            "        <span class=\"block text-900 font-medium mb-4 text-xl\">25100</span>\n" +
            "        <div class=\"flex align-items-center\">\n" +
            "            <i class=\"pi pi-arrow-up text-green-500 text-xl mr-2\"/>\n" +
            "            <span class=\"text-green-500 font-medium \">+%12</span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"flex-auto p-3\">\n" +
            "        <div class=\"flex align-items-center mb-3\">\n" +
            "            <i class=\"pi pi-users text-purple-500 text-xl mr-2\"/>\n" +
            "            <span class=\"text-500 font-medium\">Comments</span>\n" +
            "        </div>\n" +
            "        <span class=\"block text-900 font-medium mb-4 text-xl\">72</span>\n" +
            "        <div class=\"flex align-items-center\">\n" +
            "            <i class=\"pi pi-arrow-up text-green-500 text-xl mr-2\"/>\n" +
            "            <span class=\"text-green-500 font-medium \">+20</span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block3 = "<div class=\"grid\">\n" +
            "    <div class=\"col-12 md:col-6 lg:col-3\">\n" +
            "        <div class=\"surface-card shadow-2 border-round\">\n" +
            "            <div class=\"p-3 flex align-items-start\">\n" +
            "                <p:graphicImage name=\"images/blocks/crypto/btc.png\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-2\" style=\"width:32px; height: 32px\"/>\n" +
            "                <div>\n" +
            "                    <span class=\"text-700\">Bitcoin</span>\n" +
            "                    <div class=\"text-green-500 text-xl mt-2\">+0.53%</div>\n" +
            "                </div>\n" +
            "                <div class=\"p-2 bg-indigo-50 text-indigo-500 border-round ml-auto\">0.0045 BTC</div>\n" +
            "            </div>\n" +
            "            <p:graphicImage name=\"images/blocks/graphs/graph-1.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                            styleClass=\"w-full\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"col-12 md:col-6 lg:col-3\">\n" +
            "        <div class=\"surface-card shadow-2 border-round\">\n" +
            "            <div class=\"p-3 flex align-items-start\">\n" +
            "                <p:graphicImage name=\"images/blocks/crypto/eth.png\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-2\" style=\"width:32px; height: 32px\"/>\n" +
            "                <div>\n" +
            "                    <span class=\"text-700\">Ethereum</span>\n" +
            "                    <div class=\"text-green-500 text-xl mt-2\">+3.52%</div>\n" +
            "                </div>\n" +
            "                <div class=\"p-2 bg-indigo-50 text-indigo-500 border-round ml-auto\">25.0985 ETH</div>\n" +
            "            </div>\n" +
            "            <p:graphicImage name=\"images/blocks/graphs/graph-2.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                            styleClass=\"w-full\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"col-12 md:col-6 lg:col-3\">\n" +
            "        <div class=\"surface-card shadow-2 border-round\">\n" +
            "            <div class=\"p-3 flex align-items-start\">\n" +
            "                <p:graphicImage name=\"images/blocks/crypto/doge.png\" library=\"primeblocks-app\"\n" +
            "                                alt=\"Image\"\n" +
            "                                styleClass=\"mr-2\" style=\"width:32px; height: 32px\"/>\n" +
            "                <div>\n" +
            "                    <span class=\"text-700\">Dogecoin</span>\n" +
            "                    <div class=\"text-pink-500 text-xl mt-2\">-0.32%</div>\n" +
            "                </div>\n" +
            "                <div class=\"p-2 bg-indigo-50 text-indigo-500 border-round ml-auto\">59000 DOGE</div>\n" +
            "            </div>\n" +
            "            <p:graphicImage name=\"images/blocks/graphs/graph-3.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                            styleClass=\"w-full\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"col-12 md:col-6 lg:col-3\">\n" +
            "        <div class=\"surface-card shadow-2 border-round\">\n" +
            "            <div class=\"p-3 flex align-items-start\">\n" +
            "                <p:graphicImage name=\"images/blocks/crypto/xlm.png\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                                styleClass=\"mr-2\" style=\"width:32px; height: 32px\"/>\n" +
            "                <div>\n" +
            "                    <span class=\"text-700\">Stellar</span>\n" +
            "                    <div class=\"text-green-500 text-xl mt-2\">+0.99%</div>\n" +
            "                </div>\n" +
            "                <div class=\"p-2 bg-indigo-50 text-indigo-500 border-round ml-auto\">1400 XLM</div>\n" +
            "            </div>\n" +
            "            <p:graphicImage name=\"images/blocks/graphs/graph-4.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                            styleClass=\"w-full\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;

    private final String block4 = "<div class=\"surface-ground px-4 py-5 md:px-6 lg:px-8\">\n" +
            "    <div class=\"grid\">\n" +
            "        <div class=\"col-12 lg:col-4 p-2\">\n" +
            "            <div class=\"shadow-2 surface-card border-round p-4 h-full\">\n" +
            "                <div class=\"flex align-items-start\">\n" +
            "                    <div class=\"bg-blue-100 border-round inline-flex align-items-center justify-content-center\" style=\"width:52px; height: 52px\">\n" +
            "                        <p:graphicImage name=\"images/blocks/illustration/stats-illustration-1.svg\" library=\"primeblocks-app\" alt=\"Image\" width=\"38\" height=\"38\"/>\n" +
            "                    </div>\n" +
            "                    <div class=\"ml-3 flex-1\">\n" +
            "                        <span class=\"block text-900 mb-1 text-xl font-medium\">Revenue</span>\n" +
            "                        <p class=\"text-600 mt-0 mb-5 text-sm\">Sales Goal</p>\n" +
            "                        <div class=\"flex align-items-center justify-content-between\">\n" +
            "                            <span class=\"text-700\">Achieved</span>\n" +
            "                            <span class=\"font-bold text-700\">12/12</span>\n" +
            "                        </div>\n" +
            "                        <ul class=\"list-none p-0 m-0 flex align-content-center mt-2\">\n" +
            "                            <li style=\"height:7px; border-radius: 3px\" class=\"flex-1 bg-blue-500 mr-2\"></li>\n" +
            "                            <li style=\"height:7px; border-radius: 3px\" class=\"flex-1 bg-blue-500 mr-2\"></li>\n" +
            "                            <li style=\"height:7px; border-radius: 3px\" class=\"flex-1 bg-blue-500 mr-2\"></li>\n" +
            "                            <li style=\"height:7px; border-radius: 3px\" class=\"flex-1 bg-blue-500 mr-2\"></li>\n" +
            "                            <li style=\"height:7px; border-radius: 3px\" class=\"flex-1 bg-blue-500\"></li>\n" +
            "                        </ul>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 lg:col-4 p-2\">\n" +
            "            <div class=\"shadow-2 surface-card border-round p-4 h-full\">\n" +
            "                <div class=\"flex align-items-start\">\n" +
            "                    <div class=\"bg-blue-100 border-round inline-flex align-items-center justify-content-center\" style=\"width:52px; height: 52px\">\n" +
            "                        <p:graphicImage name=\"images/blocks/illustration/stats-illustration-2.svg\" library=\"primeblocks-app\" alt=\"Image\" width=\"38\" height=\"38\"/>\n" +
            "                    </div>\n" +
            "                    <div class=\"ml-3 flex-1\">\n" +
            "                        <span class=\"block text-900 mb-1 text-xl font-medium\">Reviews</span>\n" +
            "                        <p class=\"text-600 mt-0 mb-5 text-sm\">Client Messages</p>\n" +
            "                        <div class=\"flex align-items-center justify-content-between\">\n" +
            "                            <span class=\"text-700\">In Progress</span>\n" +
            "                            <span class=\"font-bold text-700\">4/12</span>\n" +
            "                        </div>\n" +
            "                        <ul class=\"list-none p-0 m-0 flex align-content-center mt-2\">\n" +
            "                            <li style=\"height:7px; border-radius: 3px\" class=\"flex-1 bg-orange-500 mr-2\"></li>\n" +
            "                            <li style=\"height:7px; border-radius: 3px\" class=\"flex-1 bg-orange-500 mr-2\"></li>\n" +
            "                            <li style=\"height:7px; border-radius: 3px\" class=\"flex-1 bg-orange-500 mr-2\"></li>\n" +
            "                            <li style=\"height:7px; border-radius: 3px\" class=\"flex-1 bg-orange-500 mr-2\"></li>\n" +
            "                            <li style=\"height:7px; border-radius: 3px\" class=\"flex-1 bg-orange-500\"></li>\n" +
            "                        </ul>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 lg:col-4 p-2\">\n" +
            "            <div class=\"shadow-2 surface-card border-round p-4 h-full\">\n" +
            "                <div class=\"flex align-items-start\">\n" +
            "                    <div class=\"bg-blue-100 border-round inline-flex align-items-center justify-content-center\" style=\"width:52px; height: 52px\">\n" +
            "                        <p:graphicImage name=\"images/blocks/illustration/stats-illustration-3.svg\" library=\"primeblocks-app\" alt=\"Image\" width=\"38\" height=\"38\"/>\n" +
            "                    </div>\n" +
            "                    <div class=\"ml-3 flex-1\">\n" +
            "                        <span class=\"block text-900 mb-1 text-xl font-medium\">Tasks</span>\n" +
            "                        <p class=\"text-600 mt-0 mb-5 text-sm\">Completed Tasks</p>\n" +
            "                        <div class=\"flex align-items-center justify-content-between\">\n" +
            "                            <span class=\"text-700\">In Progress</span>\n" +
            "                            <span class=\"font-bold text-700\">8/12</span>\n" +
            "                        </div>\n" +
            "                        <ul class=\"list-none p-0 m-0 flex align-content-center mt-2\">\n" +
            "                            <li style=\"height:7px; border-radius: 3px\" class=\"flex-1 bg-purple-500 mr-2\"></li>\n" +
            "                            <li style=\"height:7px; border-radius: 3px\" class=\"flex-1 bg-purple-500 mr-2\"></li>\n" +
            "                            <li style=\"height:7px; border-radius: 3px\" class=\"flex-1 bg-purple-500 mr-2\"></li>\n" +
            "                            <li style=\"height:7px; border-radius: 3px\" class=\"flex-1 bg-purple-500 mr-2\"></li>\n" +
            "                            <li style=\"height:7px; border-radius: 3px\" class=\"flex-1 bg-purple-500\"></li>\n" +
            "                        </ul>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block5 = "<div class=\"surface-ground px-4 py-5 md:px-6 lg:px-8\">\n" +
            "    <div class=\"grid\">\n" +
            "        <div class=\"col-12 lg:col-4 p-2\">\n" +
            "            <div class=\"shadow-2 surface-card border-round p-4 h-full\">\n" +
            "                <div class=\"flex align-items-start mb-5\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle-big/avatar-m-1.png\" library=\"primeblocks-app\" alt=\"Image\" width=\"56\" height=\"56\"/>\n" +
            "                    <div class=\"ml-3\">\n" +
            "                        <span class=\"block text-900 mb-1 text-xl font-medium\">Cameron Williamson</span>\n" +
            "                        <p class=\"text-600 mt-0 mb-0\">Marketing Coordinator</p>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <ul class=\"list-none p-0 m-0\">\n" +
            "                    <li class=\"mb-5\">\n" +
            "                        <div class=\"flex justify-content-between align-items-center\">\n" +
            "                            <span class=\"text-900 inline-flex justify-content-between align-items-center\">\n" +
            "                                <i class=\"pi pi-twitter mr-2\"></i>\n" +
            "                                <span class=\"font-medium text-900\">Twitter</span>\n" +
            "                            </span>\n" +
            "                            <span class=\"text-cyan-500 font-medium\">34.00%</span>\n" +
            "                        </div>\n" +
            "                        <div class=\"surface-300 w-full mt-2\" style=\"height: 7px; border-radius: 4px\">\n" +
            "                            <div class=\"bg-cyan-500 h-full\" style=\"width:34%; border-radius: 4px\"></div>\n" +
            "                        </div>\n" +
            "                    </li>\n" +
            "                    <li class=\"mb-5\">\n" +
            "                        <div class=\"flex justify-content-between align-items-center\">\n" +
            "                            <span class=\"text-900 inline-flex justify-content-between align-items-center\">\n" +
            "                                <i class=\"pi pi-facebook mr-2\"></i>\n" +
            "                                <span class=\"font-medium text-900\">Facebook</span>\n" +
            "                            </span>\n" +
            "                            <span class=\"text-indigo-500 font-medium\">45.86%</span>\n" +
            "                        </div>\n" +
            "                        <div class=\"surface-300 w-full mt-2\" style=\"height: 7px; border-radius: 4px\">\n" +
            "                            <div class=\"bg-indigo-500 h-full\" style=\"width:45%; border-radius: 4px\"></div>\n" +
            "                        </div>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <div class=\"flex justify-content-between align-items-center\">\n" +
            "                            <span class=\"text-900 inline-flex justify-content-between align-items-center\">\n" +
            "                                <i class=\"pi pi-google mr-2\"></i>\n" +
            "                                <span class=\"font-medium text-900\">Google</span>\n" +
            "                            </span>\n" +
            "                            <span class=\"text-orange-500 font-medium\">79.00%</span>\n" +
            "                        </div>\n" +
            "                        <div class=\"surface-300 w-full mt-2\" style=\"height: 7px; border-radius: 4px\">\n" +
            "                            <div class=\"bg-orange-500 h-full\" style=\"width:79%; border-radius: 4px\"></div>\n" +
            "                        </div>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 lg:col-4 p-2\">\n" +
            "            <div class=\"shadow-2 surface-card border-round p-4 h-full\">\n" +
            "                <div class=\"flex align-items-start mb-5\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle-big/avatar-f-2.png\" library=\"primeblocks-app\" alt=\"Image\" width=\"56\" height=\"56\"/>\n" +
            "                    <div class=\"ml-3\">\n" +
            "                        <span class=\"block text-900 mb-1 text-xl font-medium\">Kathryn Murphy</span>\n" +
            "                        <p class=\"text-600 mt-0 mb-0\">Sales Manager</p>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <ul class=\"list-none p-0 m-0\">\n" +
            "                    <li class=\"mb-5\">\n" +
            "                        <div class=\"flex justify-content-between align-items-center\">\n" +
            "                            <span class=\"text-900 inline-flex justify-content-between align-items-center\">\n" +
            "                                <i class=\"pi pi-twitter mr-2\"></i>\n" +
            "                                <span class=\"font-medium text-900\">Twitter</span>\n" +
            "                            </span>\n" +
            "                            <span class=\"text-cyan-500 font-medium\">64.47%</span>\n" +
            "                        </div>\n" +
            "                        <div class=\"surface-300 w-full mt-2\" style=\"height: 7px; border-radius: 4px\">\n" +
            "                            <div class=\"bg-cyan-500 h-full\" style=\"width:64%; border-radius: 4px\"></div>\n" +
            "                        </div>\n" +
            "                    </li>\n" +
            "                    <li class=\"mb-5\">\n" +
            "                        <div class=\"flex justify-content-between align-items-center\">\n" +
            "                            <span class=\"text-900 inline-flex justify-content-between align-items-center\">\n" +
            "                                <i class=\"pi pi-facebook mr-2\"></i>\n" +
            "                                <span class=\"font-medium text-900\">Facebook</span>\n" +
            "                            </span>\n" +
            "                            <span class=\"text-indigo-500 font-medium\">75.67%</span>\n" +
            "                        </div>\n" +
            "                        <div class=\"surface-300 w-full mt-2\" style=\"height: 7px; border-radius: 4px\">\n" +
            "                            <div class=\"bg-indigo-500 h-full\" style=\"width:75%; border-radius: 4px\"></div>\n" +
            "                        </div>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <div class=\"flex justify-content-between align-items-center\">\n" +
            "                            <span class=\"text-900 inline-flex justify-content-between align-items-center\">\n" +
            "                                <i class=\"pi pi-google mr-2\"></i>\n" +
            "                                <span class=\"font-medium text-900\">Google</span>\n" +
            "                            </span>\n" +
            "                            <span class=\"text-orange-500 font-medium\">45.00%</span>\n" +
            "                        </div>\n" +
            "                        <div class=\"surface-300 w-full mt-2\" style=\"height: 7px; border-radius: 4px\">\n" +
            "                            <div class=\"bg-orange-500 h-full\" style=\"width:45%; border-radius: 4px\"></div>\n" +
            "                        </div>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 lg:col-4 p-2\">\n" +
            "            <div class=\"shadow-2 surface-card border-round p-4 h-full\">\n" +
            "                <div class=\"flex align-items-start mb-5\">\n" +
            "                    <p:graphicImage name=\"images/blocks/avatars/circle-big/avatar-m-3.png\" library=\"primeblocks-app\" alt=\"Image\" width=\"56\" height=\"56\"/>\n" +
            "                    <div class=\"ml-3\">\n" +
            "                        <span class=\"block text-900 mb-1 text-xl font-medium\">Darrell Steward</span>\n" +
            "                        <p class=\"text-600 mt-0 mb-0\">Web Designer</p>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <ul class=\"list-none p-0 m-0\">\n" +
            "                    <li class=\"mb-5\">\n" +
            "                        <div class=\"flex justify-content-between align-items-center\">\n" +
            "                            <span class=\"text-900 inline-flex justify-content-between align-items-center\">\n" +
            "                                <i class=\"pi pi-twitter mr-2\"></i>\n" +
            "                                <span class=\"font-medium text-900\">Twitter</span>\n" +
            "                            </span>\n" +
            "                            <span class=\"text-cyan-500 font-medium\">23.55%</span>\n" +
            "                        </div>\n" +
            "                        <div class=\"surface-300 w-full mt-2\" style=\"height: 7px; border-radius: 4px\">\n" +
            "                            <div class=\"bg-cyan-500 h-full\" style=\"width:34%; border-radius: 4px\"></div>\n" +
            "                        </div>\n" +
            "                    </li>\n" +
            "                    <li class=\"mb-5\">\n" +
            "                        <div class=\"flex justify-content-between align-items-center\">\n" +
            "                            <span class=\"text-900 inline-flex justify-content-between align-items-center\">\n" +
            "                                <i class=\"pi pi-facebook mr-2\"></i>\n" +
            "                                <span class=\"font-medium text-900\">Facebook</span>\n" +
            "                            </span>\n" +
            "                            <span class=\"text-indigo-500 font-medium\">78.65%</span>\n" +
            "                        </div>\n" +
            "                        <div class=\"surface-300 w-full mt-2\" style=\"height: 7px; border-radius: 4px\">\n" +
            "                            <div class=\"bg-indigo-500 h-full\" style=\"width:45%; border-radius: 4px\"></div>\n" +
            "                        </div>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <div class=\"flex justify-content-between align-items-center\">\n" +
            "                            <span class=\"text-900 inline-flex justify-content-between align-items-center\">\n" +
            "                                <i class=\"pi pi-google mr-2\"></i>\n" +
            "                                <span class=\"font-medium text-900\">Google</span>\n" +
            "                            </span>\n" +
            "                            <span class=\"text-orange-500 font-medium\">86.54%</span>\n" +
            "                        </div>\n" +
            "                        <div class=\"surface-300 w-full mt-2\" style=\"height: 7px; border-radius: 4px\">\n" +
            "                            <div class=\"bg-orange-500 h-full\" style=\"width:79%; border-radius: 4px\"></div>\n" +
            "                        </div>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block6 = "<div class=\"shadow-2 surface-card border-round p-3\">\n" +
            "    <div class=\"flex align-items-center justify-content-between\">\n" +
            "        <span class=\"text-xl font-medium text-900\">Traffic Distribution</span>\n" +
            "        <div class=\"ml-8\">\n" +
            "            <p:commandButton id=\"toggleButton\" type=\"button\" icon=\"pi pi-ellipsis-v\" styleClass=\"ui-button-flat ui-button-plain rounded-button\"/>\n" +
            "            <p:menu overlay=\"true\" trigger=\"toggleButton\" my=\"left top\" at=\"left bottom\">\n" +
            "                <p:submenu label=\"Options\">\n" +
            "                    <p:menuitem value=\"Add New\" ajax=\"false\" icon=\"pi pi-fw pi-plus\"/>\n" +
            "                    <p:menuitem value=\"Search\" ajax=\"false\" icon=\"pi pi-fw pi-search\"/>\n" +
            "                </p:submenu>\n" +
            "            </p:menu>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"mt-3\">\n" +
            "        <div class=\"grid\">\n" +
            "            <div class=\"col-12 md:col-6\">\n" +
            "                <div class=\"text-center border-1 surface-border border-round p-4\">\n" +
            "                    <i class=\"pi pi-twitter text-5xl text-blue-500\"></i>\n" +
            "                    <div class=\"text-900 text-2xl font-700 my-3 font-bold\">12.40K</div>\n" +
            "                    <span class=\"font-medium text-600\">Twitter</span>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"col-12 md:col-6 text-center\">\n" +
            "                <div class=\"text-center border-1 surface-border border-round p-4\">\n" +
            "                    <i class=\"pi pi-vimeo text-5xl text-blue-500\"></i>\n" +
            "                    <div class=\"text-900 text-2xl font-700 my-3 font-bold\">10.20K</div>\n" +
            "                    <span class=\"font-medium text-600\">Vimeo</span>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"col-12 md:col-6 text-center\">\n" +
            "                <div class=\"text-center border-1 surface-border border-round p-4\">\n" +
            "                    <i class=\"pi pi-facebook text-5xl text-blue-500\"></i>\n" +
            "                    <div class=\"text-900 text-2xl font-700 my-3 font-bold\">5.60K</div>\n" +
            "                    <span class=\"font-medium text-600\">Facebook</span>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"col-12 md:col-6 text-center\">\n" +
            "                <div class=\"text-center border-1 surface-border border-round p-4\">\n" +
            "                    <i class=\"pi pi-discord text-5xl text-indigo-500\"></i>\n" +
            "                    <div class=\"text-900 text-2xl font-700 my-3 font-bold\">23.53K</div>\n" +
            "                    <span class=\"font-medium text-600\">Discord</span>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"col-12 md:col-6 text-center\">\n" +
            "                <div class=\"text-center border-1 surface-border border-round p-4\">\n" +
            "                    <i class=\"pi pi-github text-5xl text-purple-500\"></i>\n" +
            "                    <div class=\"text-900 text-2xl font-700 my-3 font-bold\">16.70K</div>\n" +
            "                    <span class=\"font-medium text-600\">GitHub</span>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"col-12 md:col-6 text-center\">\n" +
            "                <div class=\"text-center border-1 surface-border border-round p-4\">\n" +
            "                    <i class=\"pi pi-google text-5xl text-pink-500\"></i>\n" +
            "                    <div class=\"text-900 text-2xl font-700 my-3 font-bold\">16.50K</div>\n" +
            "                    <span class=\"font-medium text-600\">Google</span>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block7 = "<div class=\"surface-ground px-4 py-5 md:px-6 lg:px-8\">\n" +
            "    <div class=\"grid\">\n" +
            "        <div class=\"col-12 md:col-6 lg:col-3 p-3\">\n" +
            "            <div class=\"p-3 text-center bg-blue-500\" style=\"border-radius: 12px\">\n" +
            "                <span class=\"inline-flex justify-content-center align-items-center bg-blue-600 border-circle mb-3\" style=\"width:49px; height: 49px\">\n" +
            "                    <i class=\"pi pi-inbox text-xl text-white\"></i>\n" +
            "                </span>\n" +
            "                <div class=\"text-2xl font-medium text-white mb-2\">123K</div>\n" +
            "                <span class=\"text-blue-100 font-medium\">Messages</span>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 lg:col-3 p-3\">\n" +
            "            <div class=\"p-3 text-center bg-purple-500\" style=\"border-radius: 12px\">\n" +
            "                <span class=\"inline-flex justify-content-center align-items-center bg-purple-600 border-circle mb-3\" style=\"width:49px; height: 49px\">\n" +
            "                    <i class=\"pi pi-map-marker text-xl text-white\"></i>\n" +
            "                </span>\n" +
            "                <div class=\"text-2xl font-medium text-white mb-2\">23K</div>\n" +
            "                <span class=\"text-purple-100 font-medium\">Check-ins</span>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 lg:col-3 p-3\">\n" +
            "            <div class=\"p-3 text-center bg-indigo-500\" style=\"border-radius: 12px\">\n" +
            "                <span class=\"inline-flex justify-content-center align-items-center bg-indigo-600 border-circle mb-3\" style=\"width:49px; height: 49px\">\n" +
            "                    <i class=\"pi pi-file text-xl text-white\"></i>\n" +
            "                </span>\n" +
            "                <div class=\"text-2xl font-medium text-white mb-2\">23K</div>\n" +
            "                <span class=\"text-indigo-100 font-medium\">Files</span>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 md:col-6 lg:col-3 p-3\">\n" +
            "            <div class=\"p-3 text-center bg-orange-500\" style=\"border-radius: 12px\">\n" +
            "                <span class=\"inline-flex justify-content-center align-items-center bg-orange-600 border-circle mb-3\" style=\"width:49px; height: 49px\">\n" +
            "                    <i class=\"pi pi-users text-xl text-white\"></i>\n" +
            "                </span>\n" +
            "                <div class=\"text-2xl font-medium text-white mb-2\">40K</div>\n" +
            "                <span class=\"text-orange-100 font-medium\">Users</span>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block8 = "<div class=\"surface-ground px-4 py-5 md:px-6 lg:px-8\">\n" +
            "    <div class=\"grid\">\n" +
            "        <div class=\"col-12 lg:col-4 p-3\">\n" +
            "            <div class=\"shadow-2 surface-card p-3\" style=\"border-radius: 12px\">\n" +
            "                <div class=\"flex align-items-center justify-content-between\">\n" +
            "                    <div>\n" +
            "                        <span class=\"text-3xl text-900 font-bold\">40K</span>\n" +
            "                        <p class=\"mt-2 mb-0 text-600 text-2xl\">Users Online</p>\n" +
            "                    </div>\n" +
            "                    <div>\n" +
            "                        <p:graphicImage name=\"images/blocks/illustration/stats-illustration-4.svg\" library=\"primeblocks-app\" alt=\"Image\"/>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 lg:col-4 p-3\">\n" +
            "            <div class=\"shadow-2 surface-card p-3\" style=\"border-radius: 12px\">\n" +
            "                <div class=\"flex align-items-center justify-content-between\">\n" +
            "                    <div>\n" +
            "                        <span class=\"text-3xl text-900 font-bold\">24K</span>\n" +
            "                        <p class=\"mt-2 mb-0 text-600 text-2xl\">Payments Processed</p>\n" +
            "                    </div>\n" +
            "                    <div>\n" +
            "                        <p:graphicImage name=\"images/blocks/illustration/stats-illustration-5.svg\" library=\"primeblocks-app\" alt=\"Image\"/>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"col-12 lg:col-4 p-3\">\n" +
            "            <div class=\"shadow-2 surface-card p-3\" style=\"border-radius: 12px\">\n" +
            "                <div class=\"flex align-items-center justify-content-between\">\n" +
            "                    <div>\n" +
            "                        <span class=\"text-3xl text-900 font-bold\">15K</span>\n" +
            "                        <p class=\"mt-2 mb-0 text-600 text-2xl\">Daily Revenue</p>\n" +
            "                    </div>\n" +
            "                    <div>\n" +
            "                        <p:graphicImage name=\"images/blocks/illustration/stats-illustration-6.svg\" library=\"primeblocks-app\" alt=\"Image\"/>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block9 = "<div class=\"surface-card shadow-2 border-round p-4\">\n" +
            "    <div class=\"flex align-items-center justify-content-between mb-4\">\n" +
            "        <span class=\"text-xl font-medium text-900\">Quarter Goals</span>\n" +
            "        <div class=\"ml-auto\">\n" +
            "            <p:commandButton id=\"toggleButton\" type=\"button\" icon=\"pi pi-ellipsis-v\" styleClass=\"ui-button-flat ui-button-plain rounded-button\"/>\n" +
            "            <p:menu overlay=\"true\" trigger=\"toggleButton\" my=\"left top\" at=\"left bottom\">\n" +
            "                <p:submenu label=\"Options\">\n" +
            "                    <p:menuitem value=\"Add New\" ajax=\"false\" icon=\"pi pi-fw pi-plus\"/>\n" +
            "                    <p:menuitem value=\"Search\" ajax=\"false\" icon=\"pi pi-fw pi-search\"/>\n" +
            "                </p:submenu>\n" +
            "            </p:menu>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"surface-border border-1 border-round p-3 mb-4\">\n" +
            "        <span class=\"text-900 font-medium text-3xl\">85% <span class=\"text-600\">(2125/2500)</span></span>\n" +
            "        <ul class=\"mt-3 list-none p-0 mx-0 flex\">\n" +
            "            <li style=\"height:1rem\" class=\"flex-1 bg-indigo-500 border-round-left\"></li>\n" +
            "            <li style=\"height:1rem\" class=\"flex-1 bg-blue-500\"></li>\n" +
            "            <li style=\"height:1rem\" class=\"flex-1 bg-orange-500\"></li>\n" +
            "            <li style=\"height:1rem\" class=\"flex-1 bg-purple-500\"></li>\n" +
            "            <li style=\"height:1rem\" class=\"flex-1 bg-yellow-500\"></li>\n" +
            "            <li style=\"height:1rem\" class=\"flex-1 bg-cyan-500\"></li>\n" +
            "            <li style=\"height:1rem\" class=\"flex-1 surface-500 border-round-right\"></li>\n" +
            "        </ul>\n" +
            "    </div>\n" +
            "    <ul class=\"mt-4 list-none p-0 mx-0\">\n" +
            "        <li class=\"flex align-items-center pb-3\">\n" +
            "            <span style=\"width:1rem;height:1rem\" class=\"border-round bg-indigo-500 mr-3 flex-shrink-0\"></span>\n" +
            "            <span class=\"text-xl font-medium text-90\">Watch</span>\n" +
            "            <span class=\"text-600 text-xl font-medium ml-auto\">152</span>\n" +
            "        </li>\n" +
            "        <li class=\"flex align-items-center py-3\">\n" +
            "            <span style=\"width:1rem;height:1rem\" class=\"border-round bg-blue-500 mr-3 flex-shrink-0\"></span>\n" +
            "            <span class=\"text-xl font-medium text-90\">Blue Band</span>\n" +
            "            <span class=\"text-600 text-xl font-medium ml-auto\">63</span>\n" +
            "        </li>\n" +
            "        <li class=\"flex align-items-center py-3\">\n" +
            "            <span style=\"width:1rem;height:1rem\" class=\"border-round bg-orange-500 mr-3 flex-shrink-0\"></span>\n" +
            "            <span class=\"text-xl font-medium text-90\">Controller</span>\n" +
            "            <span class=\"text-600 text-xl font-medium ml-auto\">23</span>\n" +
            "        </li>\n" +
            "        <li class=\"flex align-items-center py-3\">\n" +
            "            <span style=\"width:1rem;height:1rem\" class=\"border-round bg-purple-500 mr-3 flex-shrink-0\"></span>\n" +
            "            <span class=\"text-xl font-medium text-90\">Lime Band</span>\n" +
            "            <span class=\"text-600 text-xl font-medium ml-auto\">42</span>\n" +
            "        </li>\n" +
            "        <li class=\"flex align-items-center py-3\">\n" +
            "            <span style=\"width:1rem;height:1rem\" class=\"border-round bg-yellow-500 mr-3 flex-shrink-0\"></span>\n" +
            "            <span class=\"text-xl font-medium text-90\">Phone Case</span>\n" +
            "            <span class=\"text-600 text-xl font-medium ml-auto\">134</span>\n" +
            "        </li>\n" +
            "        <li class=\"flex align-items-center py-3\">\n" +
            "            <span style=\"width:1rem;height:1rem\" class=\"border-round bg-cyan-500 mr-3 flex-shrink-0\"></span>\n" +
            "            <span class=\"text-xl font-medium text-90\">T-Shirt</span>\n" +
            "            <span class=\"text-600 text-xl font-medium ml-auto\">89</span>\n" +
            "        </li>\n" +
            "    </ul>\n" +
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

    public String getBlock8() {
        return block8;
    }
    
    public String getBlock9() {
        return block9;
    }
}
