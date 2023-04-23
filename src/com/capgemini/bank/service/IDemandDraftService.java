package com.capgemini.bank.service;
import ExceptionClass.DemandDraftException;
import com.capgemini.bank.dao.IDemandDraftDAO;
import com.capgemini.bank.bean.DemandDraft;


public interface IDemandDraftService {

    int addDemandDraftDetails(DemandDraft demandDraft) throws DemandDraftException;

    DemandDraft getDemandDraftDetails(int transactionId);

}

