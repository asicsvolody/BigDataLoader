package ru.yakimov.webService.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yakimov.webService.dao.WFTypeDao;
import ru.yakimov.webService.entiies.WFType;

import java.util.List;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

@Service
@Transactional
public class WFTypeService implements IWFTypeService{
    private WFTypeDao wfTypeDao;

    public WFTypeService(WFTypeDao wfTypeDao) {
        this.wfTypeDao = wfTypeDao;
    }

    @Override
    public WFType save(WFType type){
        return this.wfTypeDao.save(type);
    }

    @Override
    public WFType getById(long id) {
        return wfTypeDao.getOne(id);
    }

    @Override
    public List<WFType> getAll() {
        return wfTypeDao.findAll();
    }

    @Override
    public void deleteById(long id) {
        wfTypeDao.deleteById(id);
    }

    @Override
    public void delete(WFType wfType) {
        wfTypeDao.delete(wfType);
    }

    @Override
    public long count() {
        return wfTypeDao.count();
    }
}
