package com.tyut.credit.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.tyut.credit.bean.NplmLoanContract;
import com.tyut.credit.bean.TestBean;
import com.tyut.credit.manage.mapper.ContractMapper;
import com.tyut.credit.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractMapper contractMapper;


    @Override
    public List<NplmLoanContract> getAllContract() {
        return contractMapper.getAllContract();
    }

    @Override
    public List<NplmLoanContract> selectContractByRequirement(NplmLoanContract user) {
        return contractMapper.selectContractByRequirement(user);
    }
}
