package br.com.dio.ui.custom.input;

import br.com.dio.model.Space;
import br.com.dio.services.EventEnum;
import br.com.dio.services.EventListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;


import static br.com.dio.services.EventEnum.CLEAR_SPACE;
import static java.awt.Font.PLAIN;

public class NumberText extends JTextField implements EventListener {

    private final Space space;


    public NumberText(Space space) {
        this.space = space;
        var dimension = new Dimension(50, 50);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setVisible(true);
        this.setFont(new Font("Arial", PLAIN, 20));
        this.setHorizontalAlignment(CENTER);
        this.setDocument(new NumberTextLimit());
        this.setEnabled(!space.isFixed());
        if (space.isFixed()) {
            this.setText(space.getActual().toString());
        }
        this.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                chageSpace();
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                chageSpace();
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                chageSpace();
            }

            private void chageSpace(){
                if (getText().isEmpty()) {
                    space.clearSpace();
                    return;
                }

                space.setActual(Integer.parseInt(getText()));
            }

        });
    }

    public void update(final EventEnum eventType) {
        if (eventType.equals(CLEAR_SPACE) && (this.isEnabled())){
            this.setText("");
        }
    }

}
