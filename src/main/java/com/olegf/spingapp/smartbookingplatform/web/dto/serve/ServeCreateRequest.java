package com.olegf.spingapp.smartbookingplatform.web.dto.serve;

import lombok.Data;

@Data
public class ServeCreateRequest {
    private String name;
    private String description;
    private int price;
}
