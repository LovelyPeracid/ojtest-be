package com.yupi.sdutOJ.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.yupi.sdutOJ.common.ErrorCode;
import com.yupi.sdutOJ.exception.BusinessException;
import com.yupi.sdutOJ.mapper.QuestionSubmitMapper;
import com.yupi.sdutOJ.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.sdutOJ.model.entity.Question;
import com.yupi.sdutOJ.model.entity.QuestionSubmit;

import com.yupi.sdutOJ.model.entity.User;
import com.yupi.sdutOJ.service.QuestionService;
import com.yupi.sdutOJ.service.QuestionSubmitService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 轩
* @description 针对表【question_submit(题目提交)】的数据库操作Service实现
* @createDate 2024-04-26 19:55:03
*/
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit>
    implements QuestionSubmitService {

    @Autowired
    private QuestionService questionService;

    @Override
    public long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser) {
        Long questionId = questionSubmitAddRequest.getQuestionId();
        Question byId = questionService.getById(questionSubmitAddRequest.getQuestionId());
        if(byId==null){
            throw  new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        QuestionSubmitService questionSubmitService = (QuestionSubmitService) AopContext.currentProxy();
        long userId=loginUser.getId();
//       synchronized (String.valueOf(userId).intern()){
//           return questionSubmitService.doQuestionSubmitInner(userId,questionId);
//       }
        QuestionSubmit questionSubmit = new QuestionSubmit();
        questionSubmit.setUserId(userId);
        questionSubmit.setQuestionId(questionId);
        questionSubmit.setCode(questionSubmitAddRequest.getCode());
        questionSubmit.setLanguage(questionSubmitAddRequest.getLanguage());

        questionSubmit.setStatus(0);
        questionSubmit.setJudgeInfo("{}");
        boolean result = this.save(questionSubmit);
        if(!result){
            throw  new BusinessException(ErrorCode.SYSTEM_ERROR,"数据插入失败");
        }
        return questionSubmit.getId();
        //return 0;
    }

    @Override
    public int doQuestionSubmitInner(long userId, long questionId) {
        return 0;
    }
}




