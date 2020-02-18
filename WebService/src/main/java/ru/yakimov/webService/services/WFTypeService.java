package ru.yakimov.webService.services;

import org.springframework.stereotype.Service;
import ru.yakimov.webService.dao.WFTypeRepository;
import ru.yakimov.webService.entiies.WFType;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

@Service
public class WFTypeService {
    private WFTypeRepository repository;

    public WFTypeService(WFTypeRepository repository) {
        this.repository = repository;
    }

    public WFType save(WFType type){
        return this.repository.save(type);
    }
}
