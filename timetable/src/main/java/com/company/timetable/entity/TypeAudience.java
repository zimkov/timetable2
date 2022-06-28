package com.company.timetable.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum TypeAudience implements EnumClass<String> {

    LABORATORY("laboratory"),
    LECTURE("lecture");

    private String id;

    TypeAudience(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static TypeAudience fromId(String id) {
        for (TypeAudience at : TypeAudience.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}