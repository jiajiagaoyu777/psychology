package com.whlg.psychology.service.impl;

import com.whlg.psychology.mapper.PatientDetailMapper;
import com.whlg.psychology.mapper.QuestionMapper;
import com.whlg.psychology.service.IPatientService;
import com.whlg.psychology.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired(required = false)
    private QuestionMapper questionMapper;


}
