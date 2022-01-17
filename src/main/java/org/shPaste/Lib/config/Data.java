package org.shPaste.Lib.config;

import java.awt.event.KeyEvent;
import java.io.Serializable;

public class Data implements Serializable {
    private String name;
    private String text;

    private int modifier;

    private boolean ctrl;
    private boolean shift;
    private boolean alt;

    private String KeyText;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getModifier() {
        modifier = KeyEvent.CTRL_MASK + KeyEvent.SHIFT_MASK + KeyEvent.ALT_MASK;

        return modifier;
    }

    public String getKeyText() {
        return KeyText;
    }

    public void setKeyText(String keyText) {
        KeyText = keyText;
    }

    public void setCtrl(boolean ctrl){
        this.ctrl = ctrl;
    }

    public void setShift(boolean shift){
        this.shift = shift;
    }

    public void setAlt(boolean alt){
        this.alt = alt;
    }
}
