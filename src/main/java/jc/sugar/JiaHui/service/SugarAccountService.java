package jc.sugar.JiaHui.service;

import jc.sugar.JiaHui.dto.SugarAccountDto;
import jc.sugar.JiaHui.exception.SugarAccountException;

import java.util.List;

/**
 * @Code 谢良基 2021/6/23
 */
public interface SugarAccountService {


    SugarAccountDto signIn(SugarAccountDto signInAccount) throws SugarAccountException;

    SugarAccountDto signUp(SugarAccountDto signUpAccount) throws SugarAccountException;

    List<SugarAccountDto> getAccountList() throws SugarAccountException;
}
