package com.barosanu;

import com.barosanu.view.ColorTheme;
import com.barosanu.view.FontSize;

public class ModelAccess {

    public ColorTheme getTheme() {
        return theme;
    }

    public void setTheme(ColorTheme theme) {
        this.theme = theme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    private ColorTheme theme = ColorTheme.DEFAULT;
    private FontSize fontSize = FontSize.BIG;
}
