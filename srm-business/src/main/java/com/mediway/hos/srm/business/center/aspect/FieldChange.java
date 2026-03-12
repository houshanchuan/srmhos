package com.mediway.hos.srm.business.center.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldChange {
    private String fieldName;
    private String oldValue;
    private String newValue;
}
