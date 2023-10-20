package com.demo.Comercio.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Data
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="brand_id")
    private BigDecimal brand_id;

    @Column(name="start_date")
    private Date start_date;

    @Column(name="end_date")
    private Date end_date;

    @Column(name="price_list")
    private Long price_list;

    @Column(name="product_id")
    private Long product_id;

    @Column(name="priority")
    private int priority;

    @Column(name="price")
    private BigDecimal price;

    @Column(name="currency")
    private String currency;

    public void formatearFechas(Date start_date, Date end_date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.start_date = dateFormat.parse(String.valueOf(start_date));
        this.end_date = dateFormat.parse(String.valueOf(end_date));
    }
}
