package com.vanesoft.vtrack.demonios.servicios.consultor.EntidadesDemonio;

/**
 * Created by Daniel jose on 11/04/2017.
 */
public class notification {
    String title;
    String text;

    public notification(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
