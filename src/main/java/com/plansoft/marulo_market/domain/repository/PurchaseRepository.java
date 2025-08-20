package com.plansoft.marulo_market.domain.repository;

import com.plansoft.marulo_market.domain.Purchase;

import java.util.List;
import java.util.Optional;

//Se definen la especificacion y es más claro que es lo que tiene que hacer todas alas
// implementaciones que trabajan con purchases repositories
public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClientId(String clientId);
    Purchase save(Purchase purchase);
}