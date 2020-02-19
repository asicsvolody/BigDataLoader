package ru.yakimov.webService.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yakimov.webService.dao.WorkflowDao;
import ru.yakimov.webService.entiies.Workflow;

import java.util.List;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

@Service
@Transactional
public class WorkflowService implements IWorkflowService {

    private WorkflowDao workflowDao;

    public WorkflowService(WorkflowDao workflowDao) {
        this.workflowDao = workflowDao;
    }

    @Override
    public Workflow getById(Long id){
        return workflowDao.getOne(id);
    }

    @Override
    public List<Workflow> getAll(){
        return workflowDao.findAll();
    }

    @Override
    public Workflow save(Workflow workflow){
        return workflowDao.save(workflow);
    }

    @Override
    public void deleteById(Long id){
        workflowDao.deleteById(id);
    }

    @Override
    public void delete(Workflow workflow){
        workflowDao.delete(workflow);
    }

    @Override
    public long count(){
        return workflowDao.count();
    }



}
