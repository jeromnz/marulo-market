package com.plansoft.marulo_market.domain.repository;

import com.plansoft.marulo_market.domain.Product;
import java.util.List;
import java.util.Optional;

//Reglas que va a tener el dominio al momento de que cualquier repo quiera utilizar o acceder a productos dentro de una BD.
//Esto permite no acoplar la solucion a una BD concreta, si no hablar en terminos de dominio
public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
