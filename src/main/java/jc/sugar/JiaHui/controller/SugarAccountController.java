package jc.sugar.JiaHui.controller;

import jc.sugar.JiaHui.dto.project.SugarAccountDTO;
import jc.sugar.JiaHui.entity.SugarResponse;
import jc.sugar.JiaHui.entity.vo.AccountSignInVO;
import jc.sugar.JiaHui.entity.vo.AccountSignUpVO;
import jc.sugar.JiaHui.entity.vo.AccountUpdateVO;
import jc.sugar.JiaHui.exception.SugarAccountException;
import jc.sugar.JiaHui.service.SugarAccountService;
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
    public SugarResponse<SugarAccountDTO> signIn(@RequestBody AccountSignInVO signInAccount){
        try {
            SugarAccountDTO payload = accountService.signIn(signInAccount);
            return SugarResponse.success(payload, "");
        } catch (SugarAccountException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @RequestMapping("/signUp")
    @ResponseBody
    public SugarResponse<SugarAccountDTO> signUp(@RequestBody AccountSignUpVO signUpAccount){
        try {
            SugarAccountDTO payload = accountService.signUp(signUpAccount);
            return SugarResponse.success(payload, "");
        } catch (SugarAccountException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }



    @RequestMapping("/all")
    @ResponseBody
    public SugarResponse<List<SugarAccountDTO>> fetchAllAccounts(){
        try {
            List<SugarAccountDTO> payload = accountService.fetchAllAccounts();
            return SugarResponse.success(payload, "");
        } catch (SugarAccountException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @RequestMapping("/update")
    @ResponseBody
    public SugarResponse<SugarAccountDTO> updateAccount(AccountUpdateVO updateAccount){
        try {
            SugarAccountDTO payload = accountService.update(updateAccount);
            return SugarResponse.success(payload, "");
        } catch (SugarAccountException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }
}
