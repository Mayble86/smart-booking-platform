package com.olegf.spingapp.smartbookingplatform.web.dto.service;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ServiceResponse {
    private Long id;
    private String name;
    private String description;
    private int price;
}
