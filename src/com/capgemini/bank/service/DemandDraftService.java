package com.capgemini.bank.service;
import ExceptionClass.DemandDraftException;
import com.capgemini.bank.bean.DemandDraft;
import com.capgemini.bank.dao.DemandDraftDAO;
//import com.capgemini.bank.dao.DemandDraftDao;
import com.capgemini.bank.dao.IDemandDraftDAO;
//import com.capgemini.bank.
import java.util.*;

public class DemandDraftService implements IDemandDraftService {

    private  DemandDraftDAO demandDraftDAO;

    public DemandDraftService() {
        demandDraftDAO = new DemandDraftDAO();
    }


    @Override
    public int addDemandDraftDetails(DemandDraft demandDraft) throws DemandDraftException {
        // Validate demand draft details
        validateDemandDraftDetails(demandDraft);

        // Calculate commission
        double commission = calculateCommission(demandDraft.getDDAmount());
        demandDraft.setDDCommission((int) commission);

        // Add demand draft to database
        int transactionId = demandDraftDAO.addDemandDraftDetails(demandDraft);

        return transactionId;
    }
    @Override
    public DemandDraft getDemandDraftDetails(int transactionId)  {
        return demandDraftDAO.getDemandDraftDetails(transactionId);
    }


    private void validateDemandDraftDetails(DemandDraft demandDraft) throws ExceptionClass.DemandDraftException {
        // Validate customer name
        if(demandDraft.getCustomerName() == null || demandDraft.getCustomerName().trim().isEmpty()) {
            throw new ExceptionClass.DemandDraftException("Customer name cannot be empty");
        }

        // Validate phone number
        if(demandDraft.getPhoneNumber() == null || !demandDraft.getPhoneNumber().matches("\\d{10}")) {
            throw new ExceptionClass.DemandDraftException("Invalid phone number");
        }

        // Validate in favor of
        if(demandDraft.getInFavorOf() == null || demandDraft.getInFavorOf().trim().isEmpty()) {
            throw new ExceptionClass.DemandDraftException("In favor of cannot be empty");
        }

        // Validate demand draft amount
        if(demandDraft.getDDAmount() <= 0) {
            throw new ExceptionClass.DemandDraftException("Demand draft amount should be greater than 0");
        }
    }

    private double calculateCommission(double ddAmount) {
        if(ddAmount <= 5000) {
            return 10;
        } else if(ddAmount <= 10000) {
            return 41;
        } else if(ddAmount <= 100000) {
            return 51;
        } else if(ddAmount <= 500000) {
            return 306;
        } else {
            return 0;
        }
    }




}
