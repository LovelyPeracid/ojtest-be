package com.yupi.sdutOJ.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.sdutOJ.common.BaseResponse;
import com.yupi.sdutOJ.common.ErrorCode;
import com.yupi.sdutOJ.common.ResultUtils;
import com.yupi.sdutOJ.exception.BusinessException;
import com.yupi.sdutOJ.model.dto.question.QuestionAddRequest;
import com.yupi.sdutOJ.model.dto.questionsubmit.QuestionSubmitAddRequest;

import com.yupi.sdutOJ.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.yupi.sdutOJ.model.entity.Question;
import com.yupi.sdutOJ.model.entity.QuestionSubmit;
import com.yupi.sdutOJ.model.entity.User;
import com.yupi.sdutOJ.service.QuestionSubmitService;

import com.yupi.sdutOJ.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;

/**
 * 帖子点赞接口
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@RestController
@RequestMapping("/question_thumb")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 点赞 / 取消点赞
     *
     * @param
     * @param request
     * @return resultNum 本次点赞变化数
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
            HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser(request);
        long questionId = questionSubmitAddRequest.getQuestionId();
        long result = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(result);
    }
    @GetMapping("/")
    public BaseResponse<Page<QuestionSubmit>>  getQuestionSubmit(@RequestParam QuestionSubmitQueryRequest questionSubmitQueryRequest){
        //QuestionSubmit byId = questionSubmitService.getById();
        //if(byId.getUserId()!=)
        //questionSubmitService
        int current = questionSubmitQueryRequest.getCurrent();
        int pageSize = questionSubmitQueryRequest.getPageSize();
//        questionSubmitService.page(new Page<>(current,pageSize);
               // questionSubmitService.getQ)

        return  ResultUtils.success();
    }


}
