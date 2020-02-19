package ru.yakimov.webService.services;

import ru.yakimov.webService.entiies.WFType;

import java.util.List;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

public interface IWFTypeService {
    WFType save(WFType type);
    WFType getById(long id);
    List<WFType> getAll();
    void deleteById(long id);
    void delete(WFType wfType);
    long count();
}
