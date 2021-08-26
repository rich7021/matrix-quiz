package rifu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rifu.demo.model.OptionAnswerInfo;
import rifu.demo.services.OptionService;

@RestController
@RequestMapping("/option")
public class OptionController {
    private final OptionService optionService;

    @Autowired
    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping("/{id}")
    public OptionAnswerInfo isAnswer(@PathVariable(name = "id") String id) {
        return optionService.isAnswer(id);
    }

}
