package com.yupi.sdutOJ.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.sdutOJ.model.dto.question.QuestionQueryRequest;
import com.yupi.sdutOJ.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.sdutOJ.model.entity.Question;
import com.yupi.sdutOJ.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.sdutOJ.model.entity.User;
import com.yupi.sdutOJ.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author 轩
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-04-26 19:49:46
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    long doQuestionSubmit(QuestionSubmitAddRequest questionId, User loginUser);

    int doQuestionSubmitInner(long userId, long questionId);
    QuestionVO getQuestionVO(Question question, HttpServletRequest request);
    QueryWrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest);
    /**
     * 分页获取帖子封装
     *
     * @param questionPage
     * @param request
     * @return
     */
    Page<QuestionVO> getQuestionVOPage(Page<Question> questionPage, HttpServletRequest request);
}
