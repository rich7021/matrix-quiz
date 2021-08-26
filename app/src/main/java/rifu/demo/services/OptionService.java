package rifu.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rifu.demo.dao.OptionRepository;
import rifu.demo.entities.QuizOption;
import rifu.demo.exception.ResourceNotFoundException;
import rifu.demo.model.OptionAnswerInfo;

import java.util.Optional;

@Service
public class OptionService {
    private final OptionRepository optionRepository;

    @Autowired
    public OptionService(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    public OptionAnswerInfo isAnswer(String id) {
        Optional<QuizOption> opt = optionRepository.findById(id);
        QuizOption option = opt.orElseThrow(ResourceNotFoundException::new);
        OptionAnswerInfo info = OptionAnswerInfo.optionToAnswerInfo(option);
        return info;
    }
}
