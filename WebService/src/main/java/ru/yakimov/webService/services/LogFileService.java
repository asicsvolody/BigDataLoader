package ru.yakimov.webService.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yakimov.webService.dao.LogFileDao;
import ru.yakimov.webService.entiies.LogFile;

import java.util.List;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

@Service
public class LogFileService implements ILotFileService {

    private LogFileDao logFileDao;

    public LogFileService(LogFileDao logFileDao) {
        this.logFileDao = logFileDao;
    }

    @Override
    public LogFile getById(Long id) {
        return logFileDao.getOne(id);
    }

    @Override
    public List<LogFile> getAll() {
        return logFileDao.findAll();
    }

    @Override
    public LogFile save(LogFile logFile) {
        return logFileDao.save(logFile);
    }

    @Override
    public void deleteById(Long id) {
        logFileDao.deleteById(id);
    }

    @Override
    public void delete(LogFile logFile) {
        logFileDao.delete(logFile);

    }

    @Override
    public long count() {
        return logFileDao.count();
    }
}
