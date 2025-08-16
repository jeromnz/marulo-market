package com.plansoft.marulo_market.persistence;

import com.plansoft.marulo_market.domain.Product;
import com.plansoft.marulo_market.domain.repository.ProductRepository;
import com.plansoft.marulo_market.persistence.crud.ProductoCrudRepository;
import com.plansoft.marulo_market.persistence.entity.Producto;
import com.plansoft.marulo_market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Estereotipo de Spring Framework. Se indica que la clase se encarga de inteactuar con la base de datos. Se especifica el tipo de componente
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);//¿Que es Castear
    }

    @Override
    public Optional<List<Product>> getByCategory (int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    //NO ENTENDÍ
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int id) {

        System.out.println();
        return productoCrudRepository.findById(id).map(producto -> mapper.toProduct(producto));

    }

    //TODO: REVISAR COMO ESTA IMPLEMENTADO EL MAPPER
    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        producto.setIdProducto(null);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int id) {
        productoCrudRepository.deleteById(id);
    }
}
