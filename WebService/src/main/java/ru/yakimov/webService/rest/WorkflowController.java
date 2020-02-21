package ru.yakimov.webService.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.yakimov.webService.entiies.*;
import ru.yakimov.webService.services.IWFTypeService;
import ru.yakimov.webService.services.IWorkflowService;
import ru.yakimov.webService.services.WorkflowService;

import javax.validation.Valid;
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
    private IWFTypeService wfTypeService;

    public WorkflowController(WorkflowService workflowService, IWFTypeService wfTypeService) {
        this.workflowService = workflowService;
        this.wfTypeService = wfTypeService;
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

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model uiModel) {
        Workflow workflow = workflowService.getById(id);
        List<WFType> types = wfTypeService.getAll();
        uiModel.addAttribute("workflow", workflow);
        uiModel.addAttribute("listTypes", types);

        return "update";
    }

    @GetMapping(value = "/new")
    public String newWorkflow( Model uiModel) {
        Workflow workflow = new Workflow();
        WFConfig wfConfig = new WFConfig();
        wfConfig.addPartitionColumn(new PartitionColumn());
        wfConfig.addDirectoryFrom(new DirectoryFrom());
        TableConf tableConf = new TableConf();
        tableConf.addPrimaryKay(new TablePrimaryKay());
        wfConfig.setTableConf(tableConf);
        uiModel.addAttribute("workflow", workflow);
        List<WFType> types = wfTypeService.getAll();
        uiModel.addAttribute("listTypes", types);
        return "update";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        workflowService.delete(workflowService.getById(id));
        return "redirect:/workflows";
    }

    @PostMapping
    public String saveWorkflow(@Valid Workflow workflow) {
        workflow = workflowService.save(workflow);
        return "redirect:/workflows/" + workflow.getId();
    }
}
