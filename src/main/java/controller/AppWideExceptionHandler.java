package controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常类的统一处理
 * 注: 可以编写多个@ExceptionHandler()方法
 *
 * @author YC
 * @create 2018/4/19 15:22.
 */
//@ControllerAdvice
//public class AppWideExceptionHandler {
//
//    @ExceptionHandler(DuplicateSpittleException.class)
//    public String duplicateSpittleHandler() {
//        return "error";
//    }
//
//    @ExceptionHandler(SpittleNotFoundException.class)
//    public String duplicateSpittleHandler1() {
//        return "error";
//    }
//}
