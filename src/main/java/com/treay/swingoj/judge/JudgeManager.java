package com.treay.swingoj.judge;

import com.treay.swingoj.judge.strategy.DefaultJudgeStrategy;
import com.treay.swingoj.judge.strategy.JavaLanguageJudgeStrategy;
import com.treay.swingoj.judge.strategy.JudgeContext;
import com.treay.swingoj.judge.strategy.JudgeStrategy;
import com.treay.swingoj.model.codesandbox.JudgeInfo;
import com.treay.swingoj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * @auther Treay_kz
 * @Date 2024/7/27 20:57
 */
@Service
public class JudgeManager {

    /**
     * 根据judgeContext进行选择不同判题策略
     * @param judgeContext
     * @return
     */
    public JudgeInfo doJudge(JudgeContext judgeContext){
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
//        if ("java".equals(language)){
//            judgeStrategy = new JavaLanguageJudgeStrategy();
//        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
