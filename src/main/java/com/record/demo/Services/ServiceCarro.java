package com.record.demo.Services;

import com.record.demo.Repository.CarroRepository;
import com.record.demo.model.carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceCarro implements InterCarro{

    @Autowired
    CarroRepository CAR_REPO;

    @Override
    public LinkedList<carro> listcarro() {
        LinkedList<carro> lk=new LinkedList<>();
        for (carro e:CAR_REPO.findAll()) {
            lk.add(e);
        }
        return lk;
    }

    @Override
    public void InsertCarro(carro car) {
        try{
            CAR_REPO.save(car);
        }catch (Exception e){
            throw new RuntimeException("Hubo un error al ingresar los datos del carro.", e);
        }
    }

    @Override
    public void UpdateCarro_id(int id) {
        try{
            Optional<carro>carroOptional = CAR_REPO.findById(id);
            if(carroOptional.isPresent()){
                carro carroPut=carroOptional.get();
                CAR_REPO.save(CAR_REPO.save(carroPut));
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            e.getMessage();
        }
    }

    @Override
    public void DeleteCarro_id(int id) {

    }
}
