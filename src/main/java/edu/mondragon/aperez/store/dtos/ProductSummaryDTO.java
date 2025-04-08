package edu.mondragon.aperez.store.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ProductSummaryDTO {
    private Long id;
    private String name;
    
}
