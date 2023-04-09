package com.whlg.psychology.mapper;

import com.whlg.psychology.entity.PatientDetail;
import com.whlg.psychology.entity.Question;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class QuestionMapperTest {

    //注入mapper层对象
    @Autowired(required=false)//表示忽略当前要注入的bean，如果有直接注入，没有跳过，不会报错。
    private QuestionMapper questionMapper;//这里报错不用管，老师说是IDEA的问题，实际上已经注入进来

    @Test
    void insertQuestion() {
        Question question=new Question();
        question.setQuestion_content("我是第一个问题");
        question.setOptions("try");

        int count = questionMapper.insertQuestion(question);
        System.out.println("新增"+count+"行数据成功");
    }
}