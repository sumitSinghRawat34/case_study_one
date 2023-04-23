package com.capgemini.bank.dao;
import java.time.*;
import com.capgemini.bank.bean.DemandDraft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.*;

import static java.sql.Statement.RETURN_GENERATED_KEYS;


public class DemandDraftDAO implements IDemandDraftDAO {

    @Override
    public int addDemandDraftDetails(DemandDraft demandDraft) {
       int  transactionId=0;
       int rowsInserted = 0;

        String url = "jdbc:mysql://localhost:3306/banking";
        String userName = "root";
        String pass = "99999999";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, userName, pass);
            System.out.println("connection created");

            //try (Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO demand_draft (customer_name, in_favor_of, phone_number, date_of_transaction, dd_amount, dd_commission, dd_description) VALUES (?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

            // preparedStatement.setInt(1, demandDraft.getTransactionId());
            preparedStatement.setString(1, demandDraft.getCustomerName());
            preparedStatement.setString(2, demandDraft.getInFavorOf());
            preparedStatement.setString(3, demandDraft.getPhoneNumber());
            preparedStatement.setString(4, demandDraft.getDateOfTransaction());
            preparedStatement.setDouble(5, demandDraft.getDDAmount());
            preparedStatement.setDouble(6, demandDraft.getDDCommission());
            preparedStatement.setString(7, demandDraft.getDDDescription());

            rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
               //ResultSet rs = preparedStatement.getGeneratedKeys();
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    //int generatedTransactionId = rs.getInt(1);
                    transactionId =rs.getInt(1);
                    //transactionId = rs.getInt("transaction_id");
                   // demandDraft.setTransactionId(generatedTransactionId);

                }
                System.out.println("\nYour Demand Draft request has been successfully registered along with the transaction ID " +transactionId);
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


        return rowsInserted;
    }


    @Override
    public DemandDraft getDemandDraftDetails(int transactionId) {
        DemandDraft demandDraft = null;
        String url = "jdbc:mysql://localhost:3306/banking";
        String userName = "root";
        String pass = "99999999";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, userName, pass);
            System.out.println("connection created");

            //  try (Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM demand_draft WHERE transaction_id = ?");
            preparedStatement.setInt(1, transactionId);


            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    demandDraft = new DemandDraft();
                    demandDraft.setTransactionId(resultSet.getInt("transaction_id"));
                    demandDraft.setCustomerName(resultSet.getString("customer_name"));
                    demandDraft.setInFavorOf(resultSet.getString("in_favor_of"));
                    demandDraft.setPhoneNumber(resultSet.getString("phone_number"));
                    demandDraft.setDateOfTransaction(resultSet.getString("date_of_transaction"));
                    demandDraft.setDDAmount(resultSet.getInt("dd_amount"));
                    demandDraft.setDDCommission(resultSet.getInt("dd_commission"));
                    demandDraft.setDDDescription(resultSet.getString("dd_description"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return demandDraft;

    }
}