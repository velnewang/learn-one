package win.velne.learnone.shorturl.controller;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;

import win.velne.learnone.shorturl.entity.ErrorInfo;

@RestControllerAdvice(basePackageClasses = ShorturlController.class)
public class ShorturlControllerAdvise {

    @ExceptionHandler(Throwable.class)
    public ErrorInfo exception(Throwable e) {
        System.out.println("== Throwable ==");
//        e.printStackTrace();
        return new ErrorInfo("Expect Throw", "ShorturlThrowable.");
    }

}
