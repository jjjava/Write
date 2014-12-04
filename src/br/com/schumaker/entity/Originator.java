package br.com.schumaker.entity;

/**
 * @author Hudson Schumaker
 * @version 1.0.0
 * @since 11/09/2014
 * Usando Memento
 */
public class Originator {

    private TextStateCare estateText;

    public void set(TextStateCare estateText) {
        this.estateText = estateText;
    }

    public TextStateCare get() {
        return estateText;
    }

    public Text saveToMemento() {
        return new Text(estateText);
    }

    public void restoreFromMemento(Text texto) {
        estateText = texto.getStateText();
    }

    public static class Text {

        private final TextStateCare stateText;

        public Text(TextStateCare stateText) {
            this.stateText = stateText;
        }

        public TextStateCare getStateText() {
            return stateText;
        }
    }
}
