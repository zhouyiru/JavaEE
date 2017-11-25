package com.service.impl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.dao.BankDao;
import com.dao.impl.BankDaoImpl;
import com.service.BankService;

public class BankServiceImpl implements BankService {
   
	private BankDao bankDaoImpl;
	private TransactionTemplate transactionTemplate;//ÊÂÎñÄ£°å
	@Transactional
	
	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public BankDao getBankDaoImpl() {
		return bankDaoImpl;
	}

	public void setBankDaoImpl(BankDao bankDaoImpl) {
		this.bankDaoImpl = bankDaoImpl;
	}

	@Override
	public void Transfer(final int count, final int useridOut, final int useridIn) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				
				bankDaoImpl.outMoney(count, useridOut);
				bankDaoImpl.inMoney(count, useridIn);
				System.out.println(useridOut+" count "+"to "+useridIn);
				
			}
		
		});
	}

}
