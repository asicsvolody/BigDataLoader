package ru.yakimov.webService.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.yakimov.webService.services.WorkflowService;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

@Controller
@RequestMapping(value = "/workflows")
public class WorkflowController {

    private WorkflowService workflowService;

    public WorkflowController(WorkflowService workflowService) {
        this.workflowService = workflowService;
    }

    @RequestMapping
    public String list(Model uiModel){
        uiModel.addAttribute("workflowlist", workflowService.getAll());
        return "list";

    }
}
