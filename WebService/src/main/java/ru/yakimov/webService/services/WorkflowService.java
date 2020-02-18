package ru.yakimov.webService.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yakimov.webService.dao.WorkflowRepository;
import ru.yakimov.webService.entiies.Workflow;

import java.util.List;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

@Service
@Transactional
public class WorkflowService {

    private WorkflowRepository workflowRepository;

    public WorkflowService(WorkflowRepository workflowRepository) {
        this.workflowRepository = workflowRepository;
    }

    public Workflow getById(Long id){
        return workflowRepository.getOne(id);
    }

    public List<Workflow> getAll(){
        return workflowRepository.findAll();
    }

    public Workflow save(Workflow workflow){
        return workflowRepository.save(workflow);
    }

    public void deleteById(Long id){
        workflowRepository.deleteById(id);
    }

    public void delete(Workflow workflow){
        workflowRepository.delete(workflow);
    }

    public long count(){
        return workflowRepository.count();
    }



}
