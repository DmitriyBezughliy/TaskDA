package com.gmail.mitykruglov;

import java.sql.SQLException;

public interface ApartamentDAO {
    void initDB();
    void addApartament(String district, String adrress, double m2, int numberOfRooms, double price);
    void deleteApartament(int id) throws SQLException;
    void viewApartament() throws SQLException;
    void viewParameter(String par, String one, String two) throws SQLException;
}
