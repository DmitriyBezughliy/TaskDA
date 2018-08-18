package com.gmail.mitykruglov;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main2 {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/dbapartament?serverTimezone=Europe/Kiev";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "root";

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        ConnectionFactory factory = new ConnectionFactory(
                DB_CONNECTION, DB_USER, DB_PASSWORD
        );

        Connection conn = factory.getConnection();

        try{
            ApartamentDAO dao = new ApartamentDAOImpl(conn);
            dao.initDB();
            while (true) {
                System.out.println("1: add apartament");
                System.out.println("2: delete apartament");
                System.out.println("3: view all apartaments");
                System.out.println("4: view apartaments by parameters");
                System.out.print("-> ");

                String s = sc.nextLine();
                switch (s) {
                    case "1":
                        System.out.print("Enter district: ");
                        String district = sc.nextLine();
                        System.out.print("Enter adrress: ");
                        String adrress = sc.nextLine();
                        System.out.print("Enter M2: ");
                        String sM2 = sc.nextLine();
                        double m2 = Double.parseDouble(sM2);
                        System.out.print("Enter  number of rooms: ");
                        String sNumberOfRooms = sc.nextLine();
                        int numberOfRooms = Integer.parseInt(sNumberOfRooms);
                        System.out.print("Enter price: ");
                        String sPrice = sc.nextLine();
                        double price = Double.parseDouble(sPrice);
                        dao.addApartament(district,adrress,m2,numberOfRooms,price);
                        break;
                    case "2":
                        System.out.print("Enter id: ");
                        int id = sc.nextInt();
                        dao.deleteApartament(id);
                        break;
                    case "3":
                        dao.viewApartament();
                        break;
                    case "4":
                        System.out.println("Selecet ");
                        System.out.println("1: m2");
                        System.out.println("2: number of rooms");
                        System.out.println("3: price");
                        String sel = sc.nextLine();
                        System.out.println("Enter min <");
                        String one = sc.nextLine();
                        System.out.println("Enter max >");
                        String two = sc.nextLine();
                        String par="";
                        switch (sel) {
                            case "1":
                                par="m2";
                                break;
                            case "2":
                                par="numberOfRooms";
                                break;
                            case "3":
                                par="price";
                                break;
                            default:
                                return;
                        }
                        dao.viewParameter(par,one,two);
                        break;
                    default:
                        return;
                }
            }
        } finally {
            sc.close();
            if (conn != null) conn.close();
        }


    }

}
