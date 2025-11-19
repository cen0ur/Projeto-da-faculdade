package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDb {

    private static final String URL =
            "jdbc:postgresql://ep-rapid-forest-ad89bsmb-pooler.c-2.us-east-1.aws.neon.tech/neondb?sslmode=require";

    private static final String USER = "neondb_owner";
    private static final String PASSWORD = "npg_XFrs9d6jiMZP";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco: " + e.getMessage());
        }
    }
}