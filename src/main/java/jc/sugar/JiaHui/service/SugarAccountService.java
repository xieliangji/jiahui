package jc.sugar.JiaHui.service;

import jc.sugar.JiaHui.dto.project.SugarAccountDTO;
import jc.sugar.JiaHui.entity.vo.AccountSignInVO;
import jc.sugar.JiaHui.entity.vo.AccountSignUpVO;
import jc.sugar.JiaHui.entity.vo.AccountUpdateVO;
import jc.sugar.JiaHui.exception.SugarAccountException;

import java.util.List;

/**
 * @Code 谢良基 2021/6/23
 */
public interface SugarAccountService {

    SugarAccountDTO signIn(AccountSignInVO signInAccount) throws SugarAccountException;

    SugarAccountDTO signUp(AccountSignUpVO signUpAccount) throws SugarAccountException;

    List<SugarAccountDTO> fetchAllAccounts() throws SugarAccountException;

    SugarAccountDTO update(AccountUpdateVO updateAccount) throws SugarAccountException;
}
