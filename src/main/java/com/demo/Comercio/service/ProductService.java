package com.demo.Comercio.service;

import com.demo.Comercio.model.dto.product.ProductFindRequest;
import com.demo.Comercio.model.dto.product.ProductFindResponse;
import com.demo.Comercio.model.entity.Product;
import com.demo.Comercio.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private String formatDate="yyyy-MM-dd'T'HH:mm:ss";

    public ProductFindResponse findProductById(ProductFindRequest product) throws ParseException {

        // Recogemos la lista de productos que entran dentro del filtro
        List<Product> lista = productRepository.findProductByConditions(
                devolverFechaFormateada(product.getFecha_aplicacion()),product.getProduct_id(),product.getBrand_id());

        // Formateamos las fechas, ya que a la hora de devolver las fechas, no esta devolviendo las fechas con 2 horas menos
        lista.forEach(pro->{
            try {
                pro.formatearFechas(pro.getStart_date(),pro.getEnd_date());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });

        // Comparamos la prioridad para que nos devuelva la prioridad más alta
        // Podemos compararlo aqui o en la consulta hacer que nos ordene la lista con PRIORITY DESC y recoger el primero
        Optional<Product> productoFinal = lista.stream()
                .max((obj1, obj2) -> Integer.compare(obj1.getPriority(), obj2.getPriority()));

        return ProductFindResponse.fromDAO(productoFinal.get());

    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Date devolverFechaFormateada(String fechaAplicacion) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatDate);
        return dateFormat.parse(fechaAplicacion);
    }
}
