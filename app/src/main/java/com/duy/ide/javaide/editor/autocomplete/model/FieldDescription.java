package com.duy.ide.javaide.editor.autocomplete.model;

import android.support.annotation.NonNull;

import com.duy.ide.editor.view.IEditAreaView;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by Duy on 20-Jul-17.
 */

public class FieldDescription extends JavaSuggestItemImpl implements Member {
    private String name, type;
    private int modifiers;
    private String value;

    public FieldDescription(String name, String type, int modifiers) {
        this.name = name;
        this.type = type;
        this.modifiers = modifiers;
    }

    public FieldDescription(Field field) {
        this.name = field.getName();
        this.type = field.getType().getName();
        this.modifiers = field.getModifiers();
        if (Modifier.isStatic(modifiers)) {
            try {
                value = field.get(null).toString();
            } catch (Exception ignored) {
            }
        }
    }
    @Override
    public void onSelectThis(@NonNull IEditAreaView iEditAreaView) {

    }
    @Override
    public char getTypeHeader() {
        return 'f'; //field
    }



    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return value;
    }

    @Override
    public String getReturnType() {
        return type;
    }

    @Override
    public int getSuggestionPriority() {
        return JavaSuggestItemImpl.FIELD_DESC;
    }

    @Override
    public int getModifiers() {
        return modifiers;
    }

    @Override
    public String toString() {
        return name;
    }
}
