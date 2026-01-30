package com.upb.agripos.dao;

import com.upb.agripos.db.DatabaseConfig;
import com.upb.agripos.model.transaction.Transaction;
import com.upb.agripos.model.transaction.TransactionDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TransactionDAO {

    public void save(Transaction trx) {

        String insertTrx = """
            INSERT INTO transactions
            (transaction_id, cashier_id, transaction_time, subtotal, discount, total, status)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;

        String insertItem = """
            INSERT INTO transaction_items
            (transaction_id, product_code, qty, price, discount, subtotal)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (
            Connection conn = DatabaseConfig.getConnection();
            PreparedStatement psTrx = conn.prepareStatement(insertTrx);
        ) {
            conn.setAutoCommit(false);

            // ===== TRANSACTION =====
            psTrx.setString(1, trx.getTransactionId());
            psTrx.setString(2, trx.getCashierId());
            psTrx.setTimestamp(3, Timestamp.valueOf(trx.getTransactionTime()));
            psTrx.setDouble(4, trx.getSubtotal());
            psTrx.setDouble(5, trx.getTotalDiscount());
            psTrx.setDouble(6, trx.getGrandTotal());
            psTrx.setString(7, trx.getStatus().name());

            psTrx.executeUpdate();

            // ===== DETAIL ITEMS =====
            try (PreparedStatement psItem = conn.prepareStatement(insertItem)) {

                for (TransactionDetail d : trx.getDetails()) {

    psItem.setString(1, trx.getTransactionId());
    psItem.setString(2, d.getProduct().getCode());

    psItem.setInt(3, d.getQuantity());     // ← sesuaikan
    psItem.setDouble(4, d.getUnitPrice()); // ← sesuaikan

    psItem.setDouble(5, d.getDiscount());
    psItem.setDouble(6, d.getSubtotal());

    psItem.addBatch();
}

                psItem.executeBatch();
            }

            conn.commit();
            System.out.println("✅ Checkout berhasil masuk database");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
