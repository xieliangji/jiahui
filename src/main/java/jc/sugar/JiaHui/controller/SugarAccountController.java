package jc.sugar.JiaHui.controller;

import jc.sugar.JiaHui.dto.SugarAccountDto;
import jc.sugar.JiaHui.entity.SugarResponse;
import jc.sugar.JiaHui.exception.SugarAccountException;
import jc.sugar.JiaHui.service.SugarAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Code 谢良基 2021/6/23
 */
@RestController
@RequestMapping("/sugar-account")
public class SugarAccountController {

    private final SugarAccountService accountService;

    public SugarAccountController(SugarAccountService accountService) {
        this.accountService = accountService;
    }


    @RequestMapping("/signIn")
    @ResponseBody
    public SugarResponse<SugarAccountDto> signIn(@RequestBody SugarAccountDto signInAccount){
        try {
            SugarAccountDto payload = accountService.signIn(signInAccount);
            return SugarResponse.success(payload, "");
        } catch (SugarAccountException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @RequestMapping("/signUp")
    @ResponseBody
    public SugarResponse<SugarAccountDto> signUp(@RequestBody SugarAccountDto signUpAccount){
        try {
            SugarAccountDto payload = accountService.signUp(signUpAccount);
            return SugarResponse.success(payload, "");
        } catch (SugarAccountException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @RequestMapping("/all")
    @ResponseBody
    public SugarResponse<List<SugarAccountDto>> getAllAccounts(){
        try {
            List<SugarAccountDto> payload = accountService.getAccountList();
            return SugarResponse.success(payload, "");
        } catch (SugarAccountException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }
}
