package com.yupi.sdutOJ.service;

import com.yupi.sdutOJ.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.sdutOJ.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.sdutOJ.model.entity.User;

/**
* @author 轩
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-04-26 19:49:46
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    long doQuestionSubmit(QuestionSubmitAddRequest questionId, User loginUser);

    int doQuestionSubmitInner(long userId, long questionId);
}
