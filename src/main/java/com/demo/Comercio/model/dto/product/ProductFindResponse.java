package com.demo.Comercio.model.dto.product;

import com.demo.Comercio.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductFindResponse {

    private Long product_id;
    private BigDecimal brand_id;
    private BigDecimal price;
    private Date start_date;
    private Date end_date;
    private int priority;

    public static ProductFindResponse fromDAO(Product product){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(product, ProductFindResponse.class);
    }

}
