package com.capgemini.bank.ui;
import java.time.*;
import java.sql.*;
import java.util.*;

import ExceptionClass.DemandDraftException;
import com.capgemini.bank.bean.DemandDraft;
import com.capgemini.bank.service.DemandDraftService;
import com.capgemini.bank.service.IDemandDraftService;




public class Client {

    public static void main(String arga[]) throws DemandDraftException {
        Scanner sc = new Scanner(System.in);
        IDemandDraftService service = new DemandDraftService();
        int transactionId  =10001;
        LocalDate date = LocalDate.now();

        int choice = 0;
        do {
            System.out.println("\n1. Enter Demand Draft Details");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nEnter the name of the customer: ");
                    String customerName = sc.nextLine();

                    System.out.println("Enter customer phone number: ");
                    String phoneNumber = sc.nextLine();

                    System.out.println("In favor of: ");
                    String inFavorOf = sc.nextLine();

                    System.out.println("Enter Demand Draft amount (in Rs): ");
                    double DDAmount = sc.nextDouble();

                    sc.nextLine();
                    System.out.println("Enter Remarks: ");
                    String ddDescription = sc.nextLine();

                    DemandDraft dd = new DemandDraft();
                    dd.setCustomerName(customerName);
                    dd.setPhoneNumber(phoneNumber);
                    dd.setDateOfTransaction(String.valueOf(date));
                    dd.setInFavorOf(inFavorOf);
                    dd.setDDAmount(DDAmount);
                    dd.setDDDescription(ddDescription);

                    transactionId = service.addDemandDraftDetails(dd);

                    break;
                case 2:
                    System.out.println("\nThank you for using our application!");
                    break;
                default:
                    System.out.println("\nInvalid choice! Please try again.");
                    break;
            }
        } while (choice != 2);

        //sc.close();
    }

}




