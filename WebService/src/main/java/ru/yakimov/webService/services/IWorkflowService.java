
package ru.yakimov.webService.services;

import ru.yakimov.webService.entiies.Workflow;
import java.util.List;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

public interface IWorkflowService {
    Workflow getById(Long id);
    List<Workflow> getAll();
    Workflow save(Workflow workflow);
    void deleteById(Long id);
    void delete(Workflow workflow);
    long count();

}
