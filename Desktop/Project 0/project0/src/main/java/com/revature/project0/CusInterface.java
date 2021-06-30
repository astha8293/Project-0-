package com.revature.project0;

public interface CusInterface {
	
	void createNewAcc();
	int viewbal(int acc_no);
	void transactionWithdrawl(int amount, int acc_no);
	void transactionDeposit(int amount, int acc_no,int params);
	//void sendReq();
	//void recievedReq();
	//void login(int id, String password);
	void accDetails(int acc_no);
}
