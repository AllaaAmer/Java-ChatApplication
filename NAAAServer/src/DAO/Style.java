/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import javafx.scene.paint.Color;

/**
 *
 * @author Nour
 */
public class Style implements Serializable{
        private int size;
        private String fontFamily;
        private String fontWeight;
        private Color color;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getFontFamily() {
            return fontFamily;
        }

        public void setFontFamily(String fontFamily) {
            this.fontFamily = fontFamily;
        }

        public String getFontWeight() {
            return fontWeight;
        }

        public void setFontWeight(String fontWeight) {
            this.fontWeight = fontWeight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
        public Style() {
        }
}
