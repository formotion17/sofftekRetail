package com.demo.Comercio.model.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductFindRequest {

    private String fecha_aplicacion;
    private Long product_id;
    private BigDecimal brand_id;
}
