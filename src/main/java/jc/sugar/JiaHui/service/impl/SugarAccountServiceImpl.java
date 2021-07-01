package jc.sugar.JiaHui.service.impl;

import jc.sugar.JiaHui.dao.SugarAccountDao;
import jc.sugar.JiaHui.entity.SugarAccount;
import jc.sugar.JiaHui.entity.dto.SugarAccountDTO;
import jc.sugar.JiaHui.entity.vo.AccountSignInVO;
import jc.sugar.JiaHui.entity.vo.AccountSignUpVO;
import jc.sugar.JiaHui.entity.vo.AccountUpdateVO;
import jc.sugar.JiaHui.exception.SugarAccountException;
import jc.sugar.JiaHui.service.SugarAccountService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Code 谢良基 2021/6/23
 */
@Service
public class SugarAccountServiceImpl implements SugarAccountService {

    private final SugarAccountDao accountDao;

    public SugarAccountServiceImpl(SugarAccountDao accountDao){
        this.accountDao = accountDao;
    }

    @Override
    public SugarAccountDTO signIn(AccountSignInVO signInAccount) throws SugarAccountException {
        String validateResult = signInValidate(signInAccount);
        if(!StringUtils.isEmpty(validateResult)){
            throw new SugarAccountException(validateResult);
        }

        SugarAccount account = new SugarAccount();
        account.setEmail(signInAccount.getEmail());

        try {
            SugarAccount existAccount = accountDao.findAccountByEmail(account);
            if(existAccount == null){
                throw new SugarAccountException("邮箱未注册");
            }

            String existPassword = existAccount.getPassword();
            String existSalt = existAccount.getSalt();
            if(!existPassword.equals(DigestUtils.md5Hex(signInAccount.getPassword() + existSalt))){
                throw new SugarAccountException("密码不正确");
            }

            SugarAccountDTO accountDTO = new SugarAccountDTO();
            accountDTO.setId(existAccount.getId());
            accountDTO.setUsername(existAccount.getUsername());
            accountDTO.setEmail(existAccount.getEmail());
            accountDTO.setCreateTime(existAccount.getCreateTime());
            accountDTO.setUpdateTime(existAccount.getUpdateTime());

            return accountDTO;
        } catch (Exception e) {
            throw new SugarAccountException(e);
        }
    }

    @Override
    public SugarAccountDTO signUp(AccountSignUpVO signUpAccount) throws SugarAccountException {
        String validateResult = signUpValidate(signUpAccount);
        if(!StringUtils.isEmpty(validateResult)){
            throw new SugarAccountException(validateResult);
        }

        SugarAccount account = new SugarAccount();
        account.setUsername(signUpAccount.getUsername());
        account.setEmail(signUpAccount.getEmail());
        account.setSalt(DigestUtils.md5Hex(signUpAccount.getEmail()));
        account.setPassword(DigestUtils.md5Hex(signUpAccount.getPassword() + account.getSalt()));

        try {
            SugarAccount existAccount = accountDao.findAccountByEmail(account);
            if(existAccount != null){
                throw new SugarAccountException("该邮箱已被注册");
            }

            accountDao.saveAccount(account);
        } catch (Exception e) {
            throw new SugarAccountException(e);
        }

        SugarAccountDTO accountDTO = new SugarAccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setUsername(account.getUsername());
        accountDTO.setEmail(account.getEmail());
        accountDTO.setCreateTime(account.getCreateTime());
        return accountDTO;
    }

    @Override
    public List<SugarAccountDTO> fetchAllAccounts() throws SugarAccountException {
        try {
            List<SugarAccount> accounts = accountDao.fetchAllAccounts();

            List<SugarAccountDTO> accountDTOList = accounts.stream().map(account -> {
                SugarAccountDTO accountDTO = new SugarAccountDTO();
                accountDTO.setId(account.getId());
                accountDTO.setUsername(account.getUsername());
                accountDTO.setEmail(account.getEmail());
                accountDTO.setCreateTime(account.getCreateTime());
                accountDTO.setUpdateTime(account.getUpdateTime());
                return accountDTO;
            }).collect(Collectors.toList());

            return accountDTOList;
        } catch (Exception e) {
            throw new SugarAccountException(e);
        }
    }

    @Override
    public SugarAccountDTO update(AccountUpdateVO updateAccount) throws SugarAccountException {
        String validateResult = updateValidate(updateAccount);
        if(!StringUtils.isEmpty(validateResult)){
            throw new SugarAccountException(validateResult);
        }

        try {
            SugarAccount account = new SugarAccount();
            account.setId(updateAccount.getId());
            account.setUsername(updateAccount.getUsername());

            accountDao.updateAccount(account);
            SugarAccount updatedAccount = accountDao.fetchAccountById(account);
            SugarAccountDTO accountDTO = new SugarAccountDTO();
            accountDTO.setId(updatedAccount.getId());
            accountDTO.setUsername(updatedAccount.getUsername());
            accountDTO.setEmail(updatedAccount.getUsername());
            accountDTO.setCreateTime(updatedAccount.getCreateTime());
            accountDTO.setUpdateTime(updatedAccount.getUpdateTime());
            return accountDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarAccountException(e);
        }
    }

    private String signUpValidate(AccountSignUpVO signUpAccount) {
        if(StringUtils.isEmpty(signUpAccount.getUsername())){
            return "用户名不能为空";
        }
        if(StringUtils.isEmpty(signUpAccount.getEmail())){
            return "用户登录邮箱不能为空";
        }
        if(StringUtils.isEmpty(signUpAccount.getPassword())){
            return "用户登录密码不能为空";
        }
        if(StringUtils.isEmpty(signUpAccount.getRepeatPassword())){
            return "用户确认密码不能为空";
        }
        if(!signUpAccount.getPassword().equals(signUpAccount.getRepeatPassword())){
            return "用户密码、确认密码不一致";
        }

        return "";
    }


    private String signInValidate(AccountSignInVO signInAccount) {
        if(StringUtils.isEmpty(signInAccount.getEmail())){
            return "用户登录邮箱不能为空";
        }
        if(StringUtils.isEmpty(signInAccount.getPassword())){
            return "用户登录密码不能为空";
        }
        return "";
    }


    private String updateValidate(AccountUpdateVO updateAccount) {
        if(updateAccount.getId() == null){
            return "未指定更新用户ID";
        }
        if(StringUtils.isEmpty(updateAccount.getUsername())){
            return "用户名不能为空";
        }
        return "";
    }
}
