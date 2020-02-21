package ru.yakimov.webService.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.yakimov.webService.entiies.Workflow;
import ru.yakimov.webService.services.IWorkflowService;
import ru.yakimov.webService.services.WorkflowService;

import java.util.List;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

@Controller
@RequestMapping(value = "/workflows")
public class WorkflowController {

    private final Logger logger = LoggerFactory.getLogger(WorkflowController.class);

    private IWorkflowService workflowService;

    public WorkflowController(WorkflowService workflowService) {
        this.workflowService = workflowService;
    }

    @GetMapping
    public String list(Model uiModel){
        logger.info("Listing workflows");
        List<Workflow> workflows = workflowService.getAll();
        uiModel.addAttribute("workflowlist", workflows);
        logger.info("No. of singers: " + workflows.size());
        return "workflows";
    }

    @GetMapping(value = "/{id}")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        Workflow workflow = workflowService.getById(id);
        uiModel.addAttribute("workflow", workflow);
        return "show";
    }
}
