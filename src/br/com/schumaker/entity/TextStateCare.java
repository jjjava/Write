package br.com.schumaker.entity;

import java.awt.Font;

/**
 * @author Hudson Schumaker
 * @version 1.1.1
 * @since 11/09/2014 Usando Memento
 */
public class TextStateCare {

    private String text;
    private Font font;

    public TextStateCare() {
    }

    public TextStateCare(String text) {
        this.text = text;
    }

    public TextStateCare(String text, Font font) {
        this.text = text;
        this.font = font;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }
}
