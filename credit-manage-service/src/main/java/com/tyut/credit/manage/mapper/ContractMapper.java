package com.tyut.credit.manage.mapper;


import com.tyut.credit.bean.NplmLoanContract;
import com.tyut.credit.bean.TestBean;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ContractMapper extends Mapper<NplmLoanContract> {
    //查询所有合同
    List<NplmLoanContract> getAllContract();
    //根据条件查询匹配信息
    List<NplmLoanContract> selectContractByRequirement(NplmLoanContract user);
}
