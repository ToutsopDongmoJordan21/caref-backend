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
public enum DocType {

    PROFILE_IMAGE(0),
    CAR_IMAGE(1),
    GARAGE_IMAGE(2),
    OTHER(3);

    private int value;

    DocType(int value) {
        this.value = value;
    }

    public int getValue() { return value; }

    public void setValue(int value) { this.value = value; }

    public static DocType forValue(int value) {
        for (DocType docType : values()) {
            if (docType.getValue() == value) {
                return docType;
            }
        }
        return null;
    }

    public static DocType forString(String value) {
        for (DocType docType : values()) {
            if (docType.toString().equals(value)) {
                return docType;
            }
        }
        return null;
    }
}
