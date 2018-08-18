package com.gmail.mitykruglov;

import java.sql.*;

public class ApartamentDAOImpl implements ApartamentDAO{
    private final Connection conn;

    public ApartamentDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void initDB() {
    try {
        Statement st = conn.createStatement();
        try {
            st.execute("DROP TABLE IF EXISTS Apartament");
            st.execute("CREATE TABLE Apartament (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, district VARCHAR(20) NOT NULL,adrress VARCHAR(20) NOT NULL, m2 DOUBLE, numberOfRooms INT,price DOUBLE)");
        } finally {
            st.close();
        }
    }catch (SQLException ex){
        throw new RuntimeException(ex);
    }
    }

    @Override
    public void addApartament(String district, String adrress, double m2, int numberOfRooms, double price) {
       try {
        try (PreparedStatement ps = conn
                .prepareStatement("INSERT INTO Apartament (district, adrress, m2, numberOfRooms,price) VALUES(?, ?, ?, ?, ?)")) {
            ps.setString(1, district);
            ps.setString(2, adrress);
            ps.setDouble(3, m2);
            ps.setInt(4, numberOfRooms);
            ps.setDouble(5, price);
            ps.executeUpdate(); // for INSERT, UPDATE & DELETE
        }
        } catch (SQLException ex){
            throw  new RuntimeException(ex);
        }

    }

    @Override
    public void deleteApartament(int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("DELETE FROM Apartament WHERE id = ?");
        try {
            ps.setInt(1, id);
            ps.executeUpdate(); // for INSERT, UPDATE & DELETE
        } finally {
            ps.close();
        }
    }

    @Override
    public void viewApartament() throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Apartament");
        try {
            ResultSet rs = ps.executeQuery();
            try {
                ResultSetMetaData md = rs.getMetaData();
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    System.out.print(md.getColumnName(i) + "\t\t");
                }
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }
                    System.out.println();
                }
            } finally {
                rs.close(); // rs can't be null according to the docs
            }
        } finally {
            ps.close();
        }
    }

    @Override
    public void viewParameter(String par, String one, String two) throws SQLException {
        String cc = "SELECT * FROM Apartament  WHERE " + par + " >= " + one + " AND " + par + " <= " + two;

        PreparedStatement ps = conn.prepareStatement(cc);
        try {
            ResultSet rs = ps.executeQuery();
            try {
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); i++)
                    System.out.print(md.getColumnName(i) + "\t\t");
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }
                    System.out.println();
                }
            } finally {
                rs.close(); // rs can't be null according to the docs
            }
        } finally {
            ps.close();
        }
    }
}
