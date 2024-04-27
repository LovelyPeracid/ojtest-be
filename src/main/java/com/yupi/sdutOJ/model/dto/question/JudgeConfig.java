package com.yupi.sdutOJ.model.dto.question;

import lombok.Data;

/**
 * @author LovelyPeracid
 */
@Data
public class JudgeConfig {
     private Long timeLimit;
     private Long memoryLimit;
     private Long  stackLimit;
}
