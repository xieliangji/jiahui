package jc.sugar.JiaHui.dao;

import jc.sugar.JiaHui.entity.SugarAccount;

import java.util.List;

/**
 * 2021/5/25 11:47
 * Code by 谢良基
 */
public interface SugarAccountDao {

    SugarAccount findAccountByEmail(SugarAccount account) throws Exception;

    Integer saveAccount(SugarAccount account) throws Exception;

    List<SugarAccount> fetchAllAccounts() throws Exception;

    Integer updateAccount(SugarAccount account) throws Exception;

    SugarAccount fetchAccountById(SugarAccount account) throws Exception;
}
