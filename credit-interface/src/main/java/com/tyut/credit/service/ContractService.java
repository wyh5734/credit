package com.tyut.credit.service;


import com.tyut.credit.bean.NplmLoanContract;
import com.tyut.credit.bean.TestBean;

import java.util.List;

public interface ContractService{

    List<NplmLoanContract> getAllContract();
    //根据前台传入的条件查询数据
    List<NplmLoanContract> selectContractByRequirement(NplmLoanContract user);

}
