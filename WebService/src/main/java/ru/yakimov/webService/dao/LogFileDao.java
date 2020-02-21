/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.webService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yakimov.webService.entiies.LogFile;

public interface LogFileDao extends JpaRepository<LogFile, Long> {
}
