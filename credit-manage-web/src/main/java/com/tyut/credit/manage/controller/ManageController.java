package com.tyut.credit.manage.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.dubbo.config.annotation.Reference;
import com.tyut.credit.bean.NplmLoanContract;
import com.tyut.credit.bean.TestBean;
import com.tyut.credit.service.ContractService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class ManageController {
    @Reference
    private ContractService contractService;

    @RequestMapping("smp")
    public String index(){
        return "smp";
    }

    //放款列表控制器
    @RequestMapping("creditListPage")
    public String getCreditListPage(){
        return "creditListPage";
    }
    //合同列表控制器
    @RequestMapping("contractListPage")
    public String getContractListPage(Integer contractNo,String userName,String idNumber,HttpServletRequest request){

        if(contractNo!=null||userName!=null||idNumber!=null){
            System.out.println(userName+"..."+contractNo+"..."+idNumber);
            NplmLoanContract user = new NplmLoanContract();
            user.setLoanContractNum(contractNo);
            user.setRepayAccountName(userName);
            user.setRepayAcctIdenNum(idNumber);
            List<NplmLoanContract> contractListByRequirement=contractService.selectContractByRequirement(user);
            /*for (NplmLoanContract nplmLoanContract : contractListByRequirement) {
                System.out.println(nplmLoanContract.getRepayAccountName());
            }*/
            request.removeAttribute("contractList");
            request.setAttribute("contractList",contractListByRequirement);
        }else{
            List<NplmLoanContract> contractList = contractService.getAllContract();
            request.setAttribute("contractList",contractList);
        }

        return "contractListPage";
    }

    /*//根据条件查询结果
    @RequestMapping("/searchInfo")
    @ResponseBody
    public List<NplmLoanContract> searchInfo( Integer contractNo,String userName,String idNumber,HttpServletRequest request){
        System.out.println(userName+"..."+contractNo+"..."+idNumber);
        NplmLoanContract user = new NplmLoanContract();
        user.setLoanContractNum(contractNo);
        user.setRepayAccountName(userName);
        user.setRepayAcctIdenNum(idNumber);
        List<NplmLoanContract> contractListByRequirement=contractService.selectContractByRequirement(user);

        for (NplmLoanContract nplmLoanContract : contractListByRequirement) {
            System.out.println(nplmLoanContract.getRepayAccountName());
        }
        request.setAttribute("contractList",contractListByRequirement);
        return contractListByRequirement;
    }*/
}
