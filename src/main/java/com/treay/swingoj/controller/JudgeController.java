//package com.treay.swingoj.controller;
//
//import com.treay.swingoj.common.BaseResponse;
//import com.treay.swingoj.common.ErrorCode;
//import com.treay.swingoj.common.ResultUtils;
//import com.treay.swingoj.exception.ThrowUtils;
//import com.treay.swingoj.judge.service.JudgeService;
//import com.treay.swingoj.model.entity.QuestionSubmit;
//
//import javax.annotation.Resource;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * 测试沙箱
// *
// * treay
// *
// */
//@RestController
//@RequestMapping("/dojudge")
//@Slf4j
//public class JudgeController {
//
//    @Resource
//    private JudgeService judgeService;
//
//
//
//    @PostMapping("/judge")
//    public BaseResponse<Boolean> doJudge(long id) {
//        QuestionSubmit questionSubmit = judgeService.doJudge(id);
//        ThrowUtils.throwIf(questionSubmit == null, ErrorCode.PARAMS_ERROR);
//        return ResultUtils.success(true);
//    }
//
//}
