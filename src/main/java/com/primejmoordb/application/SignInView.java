package com.primejmoordb.application;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


import org.primefaces.util.EscapeUtils;

@Named
@ViewScoped
public class SignInView implements Serializable {

    private List<Feature> featureList;

    private final String block1 = "<div class=\"flex align-items-center justify-content-center\">\n" +
            "    <div class=\"surface-card p-4 shadow-2 border-round w-full lg:w-6\">\n" +
            "        <div class=\"text-center mb-5\">\n" +
            "            <p:graphicImage name=\"images/blocks/logos/hyper.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                            height=\"50\" styleClass=\"mb-3\"/>\n" +
            "            <div class=\"text-900 text-3xl font-medium mb-3\">Welcome Back</div>\n" +
            "            <span class=\"text-600 font-medium line-height-3\">Don't have an account?</span>\n" +
            "            <a class=\"font-medium no-underline ml-2 text-blue-500 cursor-pointer\">Create today!</a>\n" +
            "        </div>\n" +
            "\n" +
            "        <div>\n" +
            "            <label for=\"email1\" class=\"block text-900 font-medium mb-2\">Email</label>\n" +
            "            <p:inputText id=\"email1\" styleClass=\"w-full mb-3\"/>\n" +
            "\n" +
            "            <label for=\"password1\" class=\"block text-900 font-medium mb-2\">Password</label>\n" +
            "            <p:inputText id=\"password1\" type=\"password\" styleClass=\"w-full mb-3\"/>\n" +
            "\n" +
            "            <div class=\"flex align-items-center justify-content-between mb-6\">\n" +
            "                <div class=\"flex align-items-center\">\n" +
            "                    <p:selectBooleanCheckbox id=\"rememberme\" styleClass=\"mr-2\"/>\n" +
            "                    <label for=\"rememberme\">Remember me</label>\n" +
            "                </div>\n" +
            "                <a class=\"font-medium no-underline ml-2 text-blue-500 text-right cursor-pointer\">Forgot your password?</a>\n" +
            "            </div>\n" +
            "\n" +
            "            <p:commandButton type=\"button\" value=\"Sign In\" icon=\"pi pi-user\" styleClass=\"w-full\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>" ;
    
    private final String block2 = "<div class=\"flex\">\n" +
            "    <div class=\"surface-section w-full md:w-6 p-6 md:p-8\">\n" +
            "        <div class=\"mb-5\">\n" +
            "            <p:graphicImage name=\"images/blocks/logos/hyper.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                            height=\"50\" styleClass=\"mb-3\"/>\n" +
            "            <div class=\"text-900 text-3xl font-medium mb-3\">Welcome Back</div>\n" +
            "            <span class=\"text-600 font-medium mr-2\">Don't have an account?</span>\n" +
            "            <a class=\"font-medium no-underline text-blue-500 cursor-pointer\">Create today!</a>\n" +
            "        </div>\n" +
            "        <div>\n" +
            "            <label for=\"email2\" class=\"block text-900 font-medium mb-2\">Email</label>\n" +
            "            <p:inputText id=\"email2\" styleClass=\"w-full mb-3\"/>\n" +
            "\n" +
            "            <label for=\"password2\" class=\"block text-900 font-medium mb-2\">Password</label>\n" +
            "            <p:inputText id=\"password2\" type=\"password\" styleClass=\"w-full mb-3\"/>\n" +
            "\n" +
            "            <div class=\"flex align-items-center justify-content-between mb-6\">\n" +
            "                <div class=\"flex align-items-center\">\n" +
            "                    <p:selectBooleanCheckbox id=\"rememberme2\" styleClass=\"mr-2\"/>\n" +
            "                    <label for=\"rememberme2\">Remember me</label>\n" +
            "                </div>\n" +
            "                <a class=\"font-medium no-underline ml-2 text-blue-500 text-right cursor-pointer\">Forgot your password?</a>\n" +
            "            </div>\n" +
            "\n" +
            "            <p:commandButton type=\"button\" value=\"Sign In\" icon=\"pi pi-user\" styleClass=\"w-full\"/>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"hidden md:block w-6 bg-no-repeat bg-cover\"\n" +
            "         style=\"background: url(#{resource['primeblocks-app:images/blocks/signin/signin.jpg']})\"></div>\n" +
            "</div>" ;

    private final String block3 = "<div style=\"background: url(#{resource['primeblocks-app:images/blocks/signin/signin-2.jpg']}) no-repeat; background-size: cover\" class=\"px-4 py-8 md:px-6 lg:px-8\">\n" +
            "    <div class=\"flex flex-wrap\">\n" +
            "        <div class=\"w-full lg:w-6 p-4 lg:p-7\" style=\"background-color: rgba(255,255,255,.7)\">\n" +
            "            <p:graphicImage name=\"images/blocks/logos/bastion-purple.svg\" library=\"primeblocks-app\" alt=\"Image\"\n" +
            "                            height=\"50\" styleClass=\"mb-6\"/>\n" +
            "            <div class=\"text-xl text-gray-900 font-500 mb-3\">Welcome to Bastion</div>\n" +
            "            <p class=\"text-gray-600 line-height-3 mt-0 mb-6\">Quis vel eros donec ac odio tempor orci dapibus. In hac habitasse platea dictumst quisque.</p>\n" +
            "            <ul class=\"list-none p-0 m-0\">\n" +
            "                <li class=\"flex align-items-start mb-4\">\n" +
            "                    <div>\n" +
            "                        <span class=\"flex align-items-center justify-content-center bg-purple-400\" style=\"width:38px;height:38px;border-radius:10px\">\n" +
            "                            <i class=\"text-xl text-white pi pi-inbox\"></i>\n" +
            "                        </span>\n" +
            "                    </div>\n" +
            "                    <div class=\"ml-3\">\n" +
            "                        <span class=\"font-medium text-gray-900\">Unlimited Inbox</span>\n" +
            "                        <p class=\"mt-2 mb-0 text-gray-600 line-height-3\">Tincidunt nunc pulvinar sapien et. Vitae purus faucibus ornare suspendisse sed nisi lacus sed viverra. </p>\n" +
            "                    </div>\n" +
            "                </li>\n" +
            "                <li class=\"flex align-items-start mb-4\">\n" +
            "                    <div>\n" +
            "                        <span class=\"flex align-items-center justify-content-center bg-purple-400\" style=\"width:38px;height:38px;border-radius:10px\">\n" +
            "                            <i class=\"text-xl text-white pi pi-shield\"></i>\n" +
            "                        </span>\n" +
            "                    </div>\n" +
            "                    <div class=\"ml-3\">\n" +
            "                        <span class=\"font-medium text-gray-900\">Premium Security</span>\n" +
            "                        <p class=\"mt-2 mb-0 text-gray-600 line-height-3\">Scelerisque purus semper eget duis at tellus at urna. Sed risus pretium quam vulputate.</p>\n" +
            "                    </div>\n" +
            "                </li>\n" +
            "                <li class=\"flex align-items-start\">\n" +
            "                    <div>\n" +
            "                        <span class=\"flex align-items-center justify-content-center bg-purple-400\" style=\"width:38px;height:38px;border-radius:10px\">\n" +
            "                            <i class=\"text-xl text-white pi pi-globe\"></i>\n" +
            "                        </span>\n" +
            "                    </div>\n" +
            "                    <div class=\"ml-3\">\n" +
            "                        <span class=\"font-medium text-gray-900\">Cloud Backups Inbox</span>\n" +
            "                        <p class=\"mt-2 mb-0 text-gray-600 line-height-3\">Egestas sed tempus urna et. Auctor elit sed vulputate mi sit amet mauris commodo.</p>\n" +
            "                    </div>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "        </div>\n" +
            "        <div class=\"w-full lg:w-6 p-4 lg:p-7 surface-card\">\n" +
            "            <div class=\"text-900 text-2xl font-medium mb-6\">Login</div>\n" +
            "            <label for=\"email3\" class=\"block text-900 font-medium mb-2\">Email</label>\n" +
            "            <p:inputText id=\"email3\" styleClass=\"w-full mb-4\"/>\n" +
            "            <label for=\"password3\" class=\"block text-900 font-medium mb-2\">Password</label>\n" +
            "            <p:password id=\"password3\" styleClass=\"w-full mb-4\"/>\n" +
            "            <div class=\"flex align-items-center justify-content-between mb-6\">\n" +
            "                <div class=\"flex align-items-center\">\n" +
            "                    <p:selectBooleanCheckbox styleClass=\"mr-2\"/>\n" +
            "                    <label for=\"rememberme3\">Remember me</label>\n" +
            "                </div>\n" +
            "                <a class=\"font-medium no-underline ml-2 text-blue-500 text-right cursor-pointer\">Forgot password?</a>\n" +
            "            </div>\n" +
            "\n" +
            "            <p:commandButton type=\"button\" value=\"Login\" icon=\"pi pi-user\" styleClass=\"w-full\"/>\n" +
            "\n" +
            "            <div class=\"flex w-full relative align-items-center justify-content-center my-6 px-4\">\n" +
            "                <div class=\"border-top-1 border-300 top-50 left-0 absolute w-full\"></div>\n" +
            "                <div class=\"px-2 z-1 surface-0 flex align-items-center justify-content-center\">\n" +
            "                    <span class=\"text-600 font-normal text-sm\">OR</span>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            \n" +
            "            <p:commandButton type=\"button\" value=\"Sign In with GitHub\" icon=\"pi pi-github\" styleClass=\"w-full ui-button-secondary\"/>\n" +
            "\n" +
            "            <div class=\"mt-6 text-center text-600\">\n" +
            "                Don't have an account? <a tabindex=\"0\" class=\"font-medium text-blue-500\">Sign up</a>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block4 = "<div class=\"surface-ground px-4 py-8 md:px-6 lg:px-8\">\n" +
            "    <div class=\"flex flex-wrap shadow-2\">\n" +
            "        <div class=\"w-full lg:w-6 p-4 lg:p-7 bg-blue-50\">\n" +
            "            <div class=\"product-item\">\n" +
            "                <div class=\"product-item-content\">\n" +
            "                    <p:graphicImage name=\"images/blocks/logos/bastion-700.svg\" library=\"primeblocks-app\" alt=\"Image\" height=\"35\" styleClass=\"mb-6\"/>\n" +
            "                    <p:carousel value=\"#{signInView.featureList}\" var=\"feature\" numVisible=\"1\" numScroll=\"1\">\n" +
            "                        <div class=\"text-center mb-8\">\n" +
            "                            <p:graphicImage name=\"images/blocks/illustration/#{feature.image}\" library=\"primeblocks-app\" alt=\"Image\" styleClass=\"mb-6 w-6\"/>\n" +
            "                            <div class=\"mx-auto font-medium text-xl mb-4 text-blue-900\">#{feature.title}</div>\n" +
            "                            <p class=\"m-0 text-blue-700 line-height-3\">#{feature.text}</p>\n" +
            "                        </div>\n" +
            "                    </p:carousel>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"w-full lg:w-6 p-4 lg:p-7 surface-card\">\n" +
            "            <div class=\"flex align-items-center justify-content-between mb-7\">\n" +
            "                <span class=\"text-2xl font-medium text-900\">Login to Bastion</span>\n" +
            "                <a tabindex=\"0\" class=\"font-medium text-blue-500 hover:text-blue-700 cursor-pointer transition-colors transition-duration-150\">Sign up</a>\n" +
            "            </div>\n" +
            "            <div class=\"flex justify-content-between\">\n" +
            "                <p:commandButton type=\"button\" value=\"Sign in With Facebook\" icon=\"pi pi-facebook text-indigo-400\"\n" +
            "                    styleClass=\"mr-2 w-6 font-medium border-1 surface-border surface-100 py-3 px-2 p-component hover:surface-200 active:surface-300 text-900 cursor-pointer transition-colors transition-duration-150 inline-flex align-items-center justify-content-center\">\n" +
            "                </p:commandButton>\n" +
            "                \n" +
            "                <p:commandButton type=\"button\" value=\"Sign in With Google\" icon=\"pi pi-google text-pink-400 mr-2\"\n" +
            "                styleClass=\"mr-2 w-6 font-medium border-1 surface-border surface-100 py-1 px-2 p-component hover:surface-200 active:surface-300 text-900 cursor-pointer transition-colors transition-duration-150 inline-flex align-items-center justify-content-center\">\n" +
            "                </p:commandButton>\n" +
            "            </div>\n" +
            "\n" +
            "            <div class=\"flex w-full relative align-items-center justify-content-center my-6 px-4\">\n" +
            "                <div class=\"border-top-1 border-300 top-50 left-0 absolute w-full\"></div>\n" +
            "                <div class=\"px-2 z-1 surface-0 flex align-items-center justify-content-center\">\n" +
            "                    <span class=\"text-600 font-normal text-sm\">OR</span>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "\n" +
            "            <label for=\"email4\" class=\"block text-900 font-medium mb-2\">Email</label>\n" +
            "            <p:inputText id=\"email4\" styleClass=\"w-full mb-3 p-3\" />\n" +
            "            <label for=\"password4\" class=\"block text-900 font-medium mb-2\">Password</label>\n" +
            "            <p:password id=\"password4\" styleClass=\"w-full mb-3 p-3\"/>\n" +
            "\n" +
            "            <div class=\"flex align-items-center justify-content-between mb-6\">\n" +
            "                <div class=\"flex align-items-center\">\n" +
            "                    <p:selectBooleanCheckbox id=\"rememberme4\" styleClass=\"mr-2\"/>\n" +
            "                    <label for=\"rememberme4\">Remember me</label>\n" +
            "                </div>\n" +
            "                <a class=\"font-medium text-blue-500 hover:text-blue-700 cursor-pointer transition-colors transition-duration-150\">Forgot password?</a>\n" +
            "            </div>\n" +
            "            <p:commandButton type=\"button\" value=\"Sign in\" icon=\"pi pi-google\" styleClass=\"w-full py-3 font-medium\"/> \n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" ;

    private final String block5 = "<div class=\"p-6 shadow-2 text-center lg:w-30rem\" style=\"border-radius: 12px;background-color: rgba(255,255,255,.1);color: rgba(255,255,255,.8)\">\n" +
            "    <div class=\"text-4xl font-medium mb-6\">Welcome</div>\n" +
            "    <p:inputText styleClass=\"appearance-none border-none p-3 w-full outline-none text-xl block mb-4 bg-white-alpha-10 text-white-alpha-60\" value=\"Email\" style=\"border-radius: 30px\"/>\n" +
            "    <p:inputText type=\"password\" styleClass=\"appearance-none border-none p-3 w-full outline-none text-xl mb-4 bg-white-alpha-10 text-white-alpha-60\" value=\"Password\" style=\"border-radius: 30px\" />\n" +
            "    <p:commandButton type=\"button\" value=\"Sign In\" styleClass=\"appearance-none border-none p-2 w-full outline-none text-xl mb-4 font-normal w-12rem bg-white-alpha-30 hover:bg-white-alpha-40 active:bg-white-alpha-20 text-white-alpha-80 cursor-pointer transition-colors transition-duration-150\" style=\"border-radius: 30px\"/>\n" +
            "    <a class=\"cursor-pointer font-medium block text-center\">Forgot Password?</a>\n" +
            "</div>\n" ;

    @PostConstruct
    public void init() {
        featureList = new ArrayList<>();
        featureList.add(new Feature("Unlimited Inbox","live-collaboration.svg","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));
        featureList.add(new Feature("Data Security","security.svg" , "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."));
        featureList.add(new Feature("Cloud Backup Williams", "subscribe.svg", "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."));
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

    public List<Feature> getFeatureList() {
        return featureList;
    }

    public class ResponsiveOption {
        private String breakpoint;
        private int numVisible;
        private int numScroll;

        public ResponsiveOption(String breakpoint, int numVisible) {
            this.breakpoint = breakpoint;
            this.numVisible = numVisible;
        }

        public ResponsiveOption(String breakpoint, int numVisible, int numScroll) {
            this(breakpoint, numVisible);
            this.numScroll = numScroll;
        }

        public String getBreakpoint() {
            return breakpoint;
        }
    
        public void setBreakpoint(String breakpoint) {
            this.breakpoint = breakpoint;
        }
    
        public int getNumVisible() {
            return numVisible;
        }
    
        public void setNumVisible(int numVisible) {
            this.numVisible = numVisible;
        }
    
        public int getNumScroll() {
            return numScroll;
        }
    
        public void setNumScroll(int numScroll) {
            this.numScroll = numScroll;
        }
    
        public void encode(Writer writer) throws IOException {
            writer.write("{");
            writer.write("breakpoint:\"" + EscapeUtils.forJavaScript(breakpoint) + "\"");
            writer.write(",numVisible:" + this.numVisible);
            writer.write(",numScroll:" + this.numScroll);
            writer.write("}");
        }
    }

    public class Feature {

        private String title;
        private String image;
        private String text;

        public Feature(String title, String image, String text) {
            this.title = title;
            this.image = image;
            this.text = text;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
