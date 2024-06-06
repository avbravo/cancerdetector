package com.primejmoordb.application;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class TabsView implements Serializable {

    private int activeTab = 0;

    private int activeTab2 = 0;
    
    private int activeTab3 = 0;
    
    private int activeTab4 = 0;
    
    private int activeTab5 = 0;
    
    private int activeTab6 = 0;

    public void changeTab() {
        String param1 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("value");
        activeTab = Integer.parseInt(param1);
    }

    public void changeTab2() {
        String param1 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("value");
        activeTab2 = Integer.parseInt(param1);
    }

    public void changeTab3() {
        String param1 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("value");
        activeTab3 = Integer.parseInt(param1);
    }
    
    public void changeTab4() {
        String param1 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("value");
        activeTab4 = Integer.parseInt(param1);
    }
    
    public void changeTab5() {
        String param1 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("value");
        activeTab5 = Integer.parseInt(param1);
    }
    
    public void changeTab6() {
        String param1 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("value");
        activeTab6 = Integer.parseInt(param1);
    }

    private final String block1 = "<ul class=\"surface-card p-0 m-0 list-none flex overflow-x-auto select-none\">\n" +
            "    <li>\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center border-bottom-2 hover:border-500 transition-colors transition-duration-150 #{tabsView.activeTab eq 0 ? ' border-blue-500 text-blue-500 hover:border-blue-500 ' : ' text-700 border-transparent '}\"\n" +
            "           onclick=\"rc([{name:'value', value:0}])\">\n" +
            "            <i class=\"pi pi-home mr-2\"/>\n" +
            "            <span class=\"font-medium\">Overview</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li>\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center border-bottom-2 hover:border-500 transition-colors transition-duration-150 #{tabsView.activeTab eq 1 ? ' border-blue-500 text-blue-500 hover:border-blue-500 ' : ' text-700 border-transparent '}\"\n" +
            "           onclick=\"rc([{name:'value', value:1}])\">\n" +
            "            <i class=\"pi pi-users mr-2\"/>\n" +
            "            <span class=\"font-medium\">Members</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li>\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center border-bottom-2 hover:border-500 transition-colors transition-duration-150 #{tabsView.activeTab eq 2 ? ' border-blue-500 text-blue-500 hover:border-blue-500 ' : ' text-700 border-transparent '}\"\n" +
            "           onclick=\"rc([{name:'value', value:2}])\">\n" +
            "            <i class=\"pi pi-shopping-cart mr-2\"/>\n" +
            "            <span class=\"font-medium\">Sales</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li>\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center border-bottom-2 hover:border-500 transition-colors transition-duration-150 #{tabsView.activeTab eq 3 ? ' border-blue-500 text-blue-500 hover:border-blue-500 ' : ' text-700 border-transparent '}\"\n" +
            "           onclick=\"rc([{name:'value', value:3}])\">\n" +
            "            <i class=\"pi pi-user mr-2\"/>\n" +
            "            <span class=\"font-medium\">Profile</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li>\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center border-bottom-2 hover:border-500 transition-colors transition-duration-150 #{tabsView.activeTab eq 4 ? ' border-blue-500 text-blue-500 hover:border-blue-500 ' : ' text-700 border-transparent '}\"\n" +
            "           onclick=\"rc([{name:'value', value:4}])\">\n" +
            "            <i class=\"pi pi-cog mr-2\"/>\n" +
            "            <span class=\"font-medium\">Settings</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "</ul>\n" +
            "<p:remoteCommand name=\"rc\" update=\"@form\" action=\"#{tabsView.changeTab}\"/>" ;
    
    private final String block2 = "<ul class=\"surface-card p-2 m-0 list-none flex overflow-x-auto select-none\">\n" +
            "    <li class=\"mr-2\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center hover:surface-100 border-round transition-colors #{tabsView.activeTab2 eq 0 ? ' bg-primary hover:bg-primary ' : ' text-700 '}\"\n" +
            "           onclick=\"rc2([{name:'value', value:0}])\">\n" +
            "            <i class=\"pi pi-home mr-2\"/>\n" +
            "            <span class=\"font-medium\">Overview</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"mr-2\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center hover:surface-100 border-round transition-colors transition-duration-150 #{tabsView.activeTab2 eq 1 ? ' bg-primary hover:bg-primary ' : ' text-700 '}\"\n" +
            "           onclick=\"rc2([{name:'value', value:1}])\">\n" +
            "            <i class=\"pi pi-users mr-2\"/>\n" +
            "            <span class=\"font-medium\">Members</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"mr-2\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center hover:surface-100 border-round transition-colors transition-duration-150 #{tabsView.activeTab2 eq 2 ? ' bg-primary hover:bg-primary ' : ' text-700 '}\"\n" +
            "           onclick=\"rc2([{name:'value', value:2}])\">\n" +
            "            <i class=\"pi pi-shopping-cart mr-2\"/>\n" +
            "            <span class=\"font-medium\">Sales</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"mr-2\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center hover:surface-100 border-round transition-colors transition-duration-150 #{tabsView.activeTab2 eq 3 ? ' bg-primary hover:bg-primary ' : ' text-700 '}\"\n" +
            "           onclick=\"rc2([{name:'value', value:3}])\">\n" +
            "            <i class=\"pi pi-user mr-2\"/>\n" +
            "            <span class=\"font-medium\">Profile</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li>\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center hover:surface-100 border-round transition-colors transition-duration-150 #{tabsView.activeTab2 eq 4 ? ' bg-primary hover:bg-primary ' : ' text-700 '}\"\n" +
            "           onclick=\"rc2([{name:'value', value:4}])\">\n" +
            "            <i class=\"pi pi-cog mr-2\"/>\n" +
            "            <span class=\"font-medium\">Settings</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "</ul>\n" +
            "<p:remoteCommand name=\"rc2\" update=\"@form\" action=\"#{tabsView.changeTab2}\"/>" ;

    private final String block3 = "<ul class=\"surface-card p-0 m-0 list-none flex overflow-x-auto select-none\">\n" +
            "    <li class=\"px-3\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center border-bottom-2 hover:border-500 transition-colors transition-duration-150 #{tabsView.activeTab3 eq 0 ? ' border-blue-500 text-blue-500 hover:border-blue-500 ' : ' text-700 border-transparent '}\" \n" +
            "            onclick=\"rc3([{name:'value', value:0}])\">\n" +
            "            <i class=\"pi pi-home mr-2\"></i>\n" +
            "            <span class=\"font-medium\">Overview</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"flex align-items-center\">\n" +
            "        <div style=\"width:1px; height: 50%\" class=\"border-right-1 surface-border\"></div>\n" +
            "    </li>\n" +
            "    <li class=\"px-3\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center border-bottom-2 hover:border-500 transition-colors transition-duration-150 #{tabsView.activeTab3 eq 1 ? ' border-blue-500 text-blue-500 hover:border-blue-500 ' : ' text-700 border-transparent '}\" \n" +
            "            onclick=\"rc3([{name:'value', value:1}])\">\n" +
            "            <i class=\"pi pi-users mr-2\"></i>\n" +
            "            <span class=\"font-medium\">Members</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"flex align-items-center\">\n" +
            "        <div style=\"width:1px; height: 50%\" class=\"border-right-1 surface-border\"></div>\n" +
            "    </li>\n" +
            "    <li class=\"px-3\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center border-bottom-2 hover:border-500 transition-colors transition-duration-150 #{tabsView.activeTab3 eq 2 ? ' border-blue-500 text-blue-500 hover:border-blue-500 ' : ' text-700 border-transparent '}\" \n" +
            "            onclick=\"rc3([{name:'value', value:2}])\">\n" +
            "            <i class=\"pi pi-shopping-cart mr-2\"></i>\n" +
            "            <span class=\"font-medium\">Sales</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"flex align-items-center\">\n" +
            "        <div style=\"width:1px; height: 50%\" class=\"border-right-1 surface-border\"></div>\n" +
            "    </li>\n" +
            "    <li class=\"px-3\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center border-bottom-2 hover:border-500 transition-colors transition-duration-150 #{tabsView.activeTab3 eq 3 ? ' border-blue-500 text-blue-500 hover:border-blue-500 ' : ' text-700 border-transparent '}\" \n" +
            "            onclick=\"rc3([{name:'value', value:3}])\">\n" +
            "            <i class=\"pi pi-user mr-2\"></i>\n" +
            "            <span class=\"font-medium\">Profile</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"flex align-items-center\">\n" +
            "        <div style=\"width:1px; height: 50%\" class=\"border-right-1 surface-border\"></div>\n" +
            "    </li>\n" +
            "    <li class=\"px-3\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center border-bottom-2 hover:border-500 transition-colors transition-duration-150 #{tabsView.activeTab3 eq 4 ? ' bg-primary hover:bg-primary ' : ' text-700 border-transparent '}\" \n" +
            "            onclick=\"rc3([{name:'value', value:4}])\">\n" +
            "            <i class=\"pi pi-cog mr-2\"></i>\n" +
            "            <span class=\"font-medium\">Settings</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "</ul>\n" ;

    private final String block4 = "<ul class=\"surface-card p-2 m-0 list-none flex overflow-x-auto select-none\">\n" +
            "    <li class=\"pr-3\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center hover:surface-100 border-round transition-colors transition-duration-150 #{tabsView.activeTab4 eq 0 ? ' bg-primary hover:bg-primary ' : ' text-700 '}\" \n" +
            "            onclick=\"rc4([{name:'value', value:0}])\">\n" +
            "            <i class=\"pi pi-home mr-2\"></i>\n" +
            "            <span class=\"font-medium\">Overview</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"flex align-items-center\">\n" +
            "        <div style=\"width:1px; height: 50%\" class=\"border-right-1 surface-border\"></div>\n" +
            "    </li>\n" +
            "    <li class=\"px-3\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center hover:surface-100 border-round transition-colors transition-duration-150 #{tabsView.activeTab4 eq 1 ? ' bg-primary hover:bg-primary ' : ' text-700 '}\" \n" +
            "            onclick=\"rc4([{name:'value', value:1}])\">\n" +
            "            <i class=\"pi pi-users mr-2\"></i>\n" +
            "            <span class=\"font-medium\">Members</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"flex align-items-center\">\n" +
            "        <div style=\"width:1px; height: 50%\" class=\"border-right-1 surface-border\"></div>\n" +
            "    </li>\n" +
            "    <li class=\"px-3\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center hover:surface-100 border-round transition-colors transition-duration-150 #{tabsView.activeTab4 eq 2 ? ' bg-primary hover:bg-primary ' : ' text-700 '}\" \n" +
            "            onclick=\"rc4([{name:'value', value:2}])\">\n" +
            "            <i class=\"pi pi-shopping-cart mr-2\"></i>\n" +
            "            <span class=\"font-medium\">Sales</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"flex align-items-center\">\n" +
            "        <div style=\"width:1px; height: 50%\" class=\"border-right-1 surface-border\"></div>\n" +
            "    </li>\n" +
            "    <li class=\"px-3\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center hover:surface-100 border-round transition-colors transition-duration-150 #{tabsView.activeTab4 eq 3? ' bg-primary hover:bg-primary ' : ' text-700 '}\" \n" +
            "            onclick=\"rc4([{name:'value', value:3}])\">\n" +
            "            <i class=\"pi pi-user mr-2\"></i>\n" +
            "            <span class=\"font-medium\">Profile</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"flex align-items-center\">\n" +
            "        <div style=\"width:1px; height: 50%\" class=\"border-right-1 surface-border\"></div>\n" +
            "    </li>\n" +
            "    <li class=\"px-3\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center hover:surface-100 border-round transition-colors transition-duration-150 #{tabsView.activeTab4 eq 4 ? ' bg-primary hover:bg-primary ' : ' text-700 '}\" \n" +
            "            onclick=\"rc4([{name:'value', value:4}])\">\n" +
            "            <i class=\"pi pi-cog mr-2\"></i>\n" +
            "            <span class=\"font-medium\">Settings</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "</ul>\n" ;

    private final String block5 = "<ul class=\"surface-card p-0 m-0 list-none flex overflow-x-auto select-none\">\n" +
            "    <li class=\"flex-1\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center justify-content-center border-bottom-2 hover:border-500 transition-colors transition-duration-150 #{tabsView.activeTab5 eq 0 ? ' border-blue-500 text-blue-500 hover:border-blue-500 ' : ' text-700 border-transparent '}\" \n" +
            "            onclick=\"rc5([{name:'value', value:0}])\">\n" +
            "            <i class=\"pi pi-home mr-2\"></i>\n" +
            "            <span class=\"font-medium\">Overview</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"flex-1\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center justify-content-center border-bottom-2 hover:border-500 transition-colors transition-duration-150 #{tabsView.activeTab5 eq 1 ? ' border-blue-500 text-blue-500 hover:border-blue-500 ' : ' text-700 border-transparent '}\" \n" +
            "            onclick=\"rc5([{name:'value', value:1}])\">\n" +
            "            <i class=\"pi pi-users mr-2\"></i>\n" +
            "            <span class=\"font-medium\">Members</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"flex-1\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center justify-content-center border-bottom-2 hover:border-500 transition-colors transition-duration-150 #{tabsView.activeTab5 eq 2 ? ' border-blue-500 text-blue-500 hover:border-blue-500 ' : ' text-700 border-transparent '}\" \n" +
            "            onclick=\"rc5([{name:'value', value:2}])\">\n" +
            "            <i class=\"pi pi-shopping-cart mr-2\"></i>\n" +
            "            <span class=\"font-medium\">Sales</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"flex-1\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center justify-content-center border-bottom-2 hover:border-500 transition-colors transition-duration-150 #{tabsView.activeTab5 eq 3 ? ' border-blue-500 text-blue-500 hover:border-blue-500 ' : ' text-700 border-transparent '}\" \n" +
            "            onclick=\"rc5([{name:'value', value:3}])\">\n" +
            "            <i class=\"pi pi-user mr-2\"></i>\n" +
            "            <span class=\"font-medium\">Profile</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"flex-1\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center justify-content-center border-bottom-2 hover:border-500 transition-colors transition-duration-150 #{tabsView.activeTab5 eq 4 ? ' border-blue-500 text-blue-500 hover:border-blue-500 ' : ' text-700 border-transparent '}\" \n" +
            "            onclick=\"rc5([{name:'value', value:4}])\">\n" +
            "            <i class=\"pi pi-cog mr-2\"></i>\n" +
            "            <span class=\"font-medium\">Settings</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "</ul>\n" ;

    private final String block6 = "<ul class=\"bg-indigo-500 p-2 m-0 list-none flex overflow-x-auto select-none\" style=\"border-radius: 30px\">\n" +
            "    <li class=\"mr-2\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center hover:bg-indigo-400 transition-colors transition-duration-150 #{tabsView.activeTab6 eq 0 ? ' bg-white hover:bg-white text-indigo-900 ' : ' text-white '}\" \n" +
            "            onclick=\"rc6([{name:'value', value:0}])\" style=\"border-radius: 30px\">\n" +
            "            <i class=\"pi pi-home mr-2\"></i>\n" +
            "            <span class=\"font-medium\">Overview</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"mr-2\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center hover:bg-indigo-400 transition-colors transition-duration-150 #{tabsView.activeTab6 eq 1 ? ' bg-white hover:bg-white text-indigo-900 ' : ' text-white '}\" \n" +
            "            onclick=\"rc6([{name:'value', value:1}])\" style=\"border-radius: 30px\">\n" +
            "            <i class=\"pi pi-users mr-2\"></i>\n" +
            "            <span class=\"font-medium\">Members</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"mr-2\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center hover:bg-indigo-400 transition-colors transition-duration-150 #{tabsView.activeTab6 eq 2 ? ' bg-white hover:bg-white text-indigo-900 ' : ' text-white '}\" \n" +
            "            onclick=\"rc6([{name:'value', value:2}])\" style=\"border-radius: 30px\">\n" +
            "            <i class=\"pi pi-shopping-cart mr-2\"></i>\n" +
            "            <span class=\"font-medium\">Sales</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li class=\"mr-2\">\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center hover:bg-indigo-400 transition-colors transition-duration-150 #{tabsView.activeTab6 eq 3 ? ' bg-white hover:bg-white text-indigo-900 ' : ' text-white '}\" \n" +
            "            onclick=\"rc6([{name:'value', value:3}])\" style=\"border-radius: 30px\">\n" +
            "            <i class=\"pi pi-user mr-2\"></i>\n" +
            "            <span class=\"font-medium\">Profile</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "    <li>\n" +
            "        <a class=\"cursor-pointer px-4 py-3 flex align-items-center hover:bg-indigo-400 transition-colors transition-duration-150 #{tabsView.activeTab6 eq 4 ? ' bg-white hover:bg-white text-indigo-900 ' : ' text-white '}\" \n" +
            "            onclick=\"rc6([{name:'value', value:4}])\" style=\"border-radius: 30px\">\n" +
            "            <i class=\"pi pi-cog mr-2\"></i>\n" +
            "            <span class=\"font-medium\">Settings</span>\n" +
            "        </a>\n" +
            "    </li>\n" +
            "</ul>\n" ;

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

    public int getActiveTab() {
        return activeTab;
    }

    public void setActiveTab(int activeTab) {
        this.activeTab = activeTab;
    }

    public int getActiveTab2() {
        return activeTab2;
    }

    public void setActiveTab2(int activeTab2) {
        this.activeTab2 = activeTab2;
    }

    public int getActiveTab3() {
        return activeTab3;
    }

    public void setActiveTab3(int activeTab3) {
        this.activeTab3 = activeTab3;
    }

    public int getActiveTab4() {
        return activeTab4;
    }

    public void setActiveTab4(int activeTab4) {
        this.activeTab4 = activeTab4;
    }

    public int getActiveTab5() {
        return activeTab5;
    }

    public void setActiveTab5(int activeTab5) {
        this.activeTab5 = activeTab5;
    }

    public int getActiveTab6() {
        return activeTab6;
    }

    public void setActiveTab6(int activeTab6) {
        this.activeTab6 = activeTab6;
    }

    

}
