package com.treay.swingoj.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.treay.swingoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.treay.swingoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.treay.swingoj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.treay.swingoj.model.entity.User;
import com.treay.swingoj.model.vo.QuestionSubmitVO;

/**
* @author 16799
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-07-26 13:02:58
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 提交题目
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    Long doSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取题目提交分页
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);

    /**
     * 获取题目提交VO
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);
}
