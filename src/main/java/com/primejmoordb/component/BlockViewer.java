package com.primejmoordb.component;

import jakarta.faces.component.FacesComponent;
import jakarta.faces.component.UINamingContainer;
import java.io.Serializable;

@FacesComponent(value="BlockViewer")
public class BlockViewer extends UINamingContainer implements Serializable {

    @Override
//    public String getFamily() { return "javax.faces.NamingContainer"; }
    public String getFamily() { return "jakarta.faces.NamingContainer"; }

    private enum PropertyKeys {
        CODEMODE
    }

    public void change2PreviewMode() {
        setCodeMode(false);
    }

    public void change2CodeMode() {
        setCodeMode(true);
    }

    public void setCodeMode(boolean expanded) {
        getStateHelper().put(PropertyKeys.CODEMODE, expanded);
    }

    public boolean isCodeMode() {
        return (boolean) getStateHelper().eval(PropertyKeys.CODEMODE, false);
    }

}
