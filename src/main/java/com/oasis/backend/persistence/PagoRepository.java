package com.oasis.backend.persistence;

import com.oasis.backend.domain.Pay;
import com.oasis.backend.domain.repository.PayRepository;
import com.oasis.backend.persistence.crud.PagoCrudRepository;
import com.oasis.backend.persistence.entity.Pago;
import com.oasis.backend.persistence.mapper.PayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PagoRepository implements PayRepository {

    @Autowired
    private PagoCrudRepository pagoCrudRepository;

    @Autowired
    private PayMapper mapper;


    @Override
    public List<Pay> getAllPays() {
        List<Pago> pagos= (List<Pago>) pagoCrudRepository.findAll();
        return mapper.toPayList(pagos);
    }

    @Override
    public Optional<Pay> getPayById(int payId) {
        return pagoCrudRepository.findById(payId).map(pago -> mapper.toPay(pago));
    }

    @Override
    public Pay savePay(Pay pay) {
        Pago pago= mapper.toPago(pay);
        return mapper.toPay(pagoCrudRepository.save(pago));
    }

    @Override
    public void deletePay(int payId) {
        pagoCrudRepository.deleteById(payId);
    }
}
