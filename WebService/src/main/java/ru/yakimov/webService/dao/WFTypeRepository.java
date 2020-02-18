package ru.yakimov.webService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yakimov.webService.entiies.WFType;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

public interface WFTypeRepository extends JpaRepository<WFType, Long> {
}
