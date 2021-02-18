package com.project.caref.files.entities.enumeration;

/**
 * Copyright (c) 2020, KTACENT, All Right Reserved.
 * https://www.linkedin.com/in/alex-kouasseu/
 * <p>
 * When : 07/11/2020 -- 13:14
 * By : @author alexk
 * Project : lp-user-service
 * Package : com.lukapharma.api.files.entities.enumeration
 */
public enum EntityFileType {

    CAR(0),
    USER(1),
    GARAGE(2);

    private int value;

    EntityFileType(int value) {
        this.value = value;
    }

    public int getValue() { return value; }

    public void setValue(int value) { this.value = value; }

    public static EntityFileType forValue(int value) {
        for (EntityFileType docType : values()) {
            if (docType.getValue() == value) {
                return docType;
            }
        }
        return null;
    }

    public static EntityFileType forString(String value) {
        for (EntityFileType docType : values()) {
            if (docType.toString().equals(value)) {
                return docType;
            }
        }
        return null;
    }
}
