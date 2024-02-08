package com.nawerno.promyshia.service;

import com.nawerno.promyshia.entity.Promo;
import com.nawerno.promyshia.repository.read.PromoReadRepository;
import com.nawerno.promyshia.repository.write.PromoWriteRepository;
import com.nawerno.promyshia.entity.Promo;
import com.nawerno.promyshia.entity.User;
import com.nawerno.promyshia.repository.read.PromoReadRepository;
import com.nawerno.promyshia.repository.read.UserReadRepository;
import com.nawerno.promyshia.repository.write.PromoWriteRepository;
import com.nawerno.promyshia.repository.write.UserWriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PromoServiceImpl implements PromoService{

    private final PromoReadRepository promoReadRepository;
    private final PromoWriteRepository promoWriteRepository;

    @Override
    public Promo getById(int id){
        return promoReadRepository.getById(id);
    }

    @Override
    public void create(Promo promo){
        var newId = promoWriteRepository.create(promo);
        promo.setId(newId);
    }

    @Override
    public List<Promo> getAll(){
        return promoReadRepository.getAll();
    }

}
