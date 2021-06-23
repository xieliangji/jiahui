package jc.sugar.JiaHui.service.impl;

import jc.sugar.JiaHui.dao.SugarAccountDao;
import jc.sugar.JiaHui.dto.SugarAccountDto;
import jc.sugar.JiaHui.entity.SugarAccount;
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
    public SugarAccountDto signIn(SugarAccountDto signInAccount) throws SugarAccountException {
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

            SugarAccountDto accountDto = new SugarAccountDto();
            accountDto.setId(existAccount.getId());
            accountDto.setUsername(existAccount.getUsername());
            accountDto.setEmail(existAccount.getEmail());
            accountDto.setCreateTime(existAccount.getCreateTime());
            accountDto.setUpdateTime(existAccount.getUpdateTime());

            return accountDto;
        } catch (Exception e) {
            throw new SugarAccountException(e);
        }
    }

    @Override
    public SugarAccountDto signUp(SugarAccountDto signUpAccount) throws SugarAccountException {
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
        } catch (Exception e) {
            throw new SugarAccountException(e);
        }

        try {
            accountDao.saveAccount(account);
            signUpAccount.setId(account.getId());
        } catch (Exception e) {
            throw new SugarAccountException(e);
        }
        return signUpAccount;
    }

    @Override
    public List<SugarAccountDto> getAccountList() throws SugarAccountException {
        try {
            List<SugarAccount> accounts = accountDao.findAllAccount();

            List<SugarAccountDto> accountDtos = accounts.stream().map(account -> {
                SugarAccountDto accountDto = new SugarAccountDto();
                accountDto.setId(account.getId());
                accountDto.setUsername(account.getUsername());
                accountDto.setEmail(account.getEmail());
                return accountDto;
            }).collect(Collectors.toList());
            return accountDtos;
        } catch (Exception e) {
            throw new SugarAccountException(e);
        }
    }

    private String signUpValidate(SugarAccountDto signUpAccount) {
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


    private String signInValidate(SugarAccountDto signInAccount) throws SugarAccountException{
        if(StringUtils.isEmpty(signInAccount.getEmail())){
            return "用户登录邮箱不能为空";
        }
        if(StringUtils.isEmpty(signInAccount.getPassword())){
            return "用户登录密码不能为空";
        }

        return "";
    }
}
