package com.treay.swingoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.treay.swingoj.model.dto.question.QuestionSumbitQueryRequest;
import com.treay.swingoj.model.entity.QuestionSumbit;
import com.treay.swingoj.model.vo.QuestionSumbitVO;

import javax.servlet.http.HttpServletRequest;

/**
 * 题目服务
 *
 * treay
 * @from <a href="https://www.code-nav.cn">编程导航学习圈</a>
 */
public interface QuestionSumbitService extends IService<QuestionSumbit> {

    /**
     * 校验数据
     *
     * @param question
     * @param add 对创建的数据进行校验
     */
    void validQuestionSumbit(QuestionSumbit question, boolean add);

    /**
     * 获取查询条件
     *
     * @param questionQueryRequest
     * @return
     */
    QueryWrapper<QuestionSumbit> getQueryWrapper(QuestionSumbitQueryRequest questionQueryRequest);
    
    /**
     * 获取题目封装
     *
     * @param question
     * @param request
     * @return
     */
    QuestionSumbitVO getQuestionSumbitVO(QuestionSumbit question, HttpServletRequest request);

    /**
     * 分页获取题目封装
     *
     * @param questionPage
     * @param request
     * @return
     */
    Page<QuestionSumbitVO> getQuestionSumbitVOPage(Page<QuestionSumbit> questionPage, HttpServletRequest request);
}
