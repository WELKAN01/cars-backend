package com.record.demo.Services;

import com.record.demo.model.carro;

import java.util.LinkedList;
import java.util.List;

public interface InterCarro {
    LinkedList<carro> listcarro();
    void InsertCarro(carro car);
    void UpdateCarro_id(int id);

    void DeleteCarro_id(int id);
}
