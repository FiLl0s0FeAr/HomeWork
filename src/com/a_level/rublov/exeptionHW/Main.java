package com.a_level.rublov.exeptionHW;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean a = false;

        while (a!= true) {
            try {
                Scanner in = new Scanner(System.in);
                System.out.print("Enter radius: ");
                int r = in.nextInt();

                if (r < 0) {
                    throw new Exception("Radius must be bigger then 0. Please enter radius again.");
                }
                else {
                    a = true;
                }

                in.close();
                }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
