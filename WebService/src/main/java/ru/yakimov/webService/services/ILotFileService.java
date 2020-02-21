package ru.yakimov.webService.services;

import ru.yakimov.webService.entiies.LogFile;

import java.util.List;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

public interface ILotFileService {

    LogFile getById(Long id);
    List<LogFile> getAll();
    LogFile save(LogFile logFile);
    void deleteById(Long id);
    void delete(LogFile logFile);
    long count();

}
