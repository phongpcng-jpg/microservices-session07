package ra.productservice.service;

import ra.productservice.dto.ProductRequest;
import ra.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse create(ProductRequest request);
    List<ProductResponse> findAll();
    ProductResponse findById(Long id);
    ProductResponse update(Long id, ProductRequest request);
    void delete(Long id);
}
