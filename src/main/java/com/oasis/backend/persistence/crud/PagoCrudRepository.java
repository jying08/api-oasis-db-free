package com.oasis.backend.persistence.crud;

import com.oasis.backend.persistence.entity.Pago;
import org.springframework.data.repository.CrudRepository;

public interface PagoCrudRepository extends CrudRepository<Pago,Integer> {
}
