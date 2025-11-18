package com.oracle.exchangerate.main;

import com.oracle.exchangerate.models.ConectionApi;
import com.oracle.exchangerate.models.ExchangeRateApiResponse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String baseCode,
               targetCode;
        double amount;

        Scanner readKeyboard = new Scanner(System.in);

        ConectionApi conectionApi = new ConectionApi();

        // var to have the response from the API
        ExchangeRateApiResponse response;

        System.out.println("****************************************");
        System.out.println("***Bienvenid@ al Conversor de Monedas***");
        System.out.println("****************************************\n");

        while( true ) {
            System.out.println("1) Dólar =>> Peso Argentino");
            System.out.println("2) Peso Argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real Brasileño");
            System.out.println("4) Real Brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso Colombiano");
            System.out.println("6) Peso Colombiano =>> Dólar");
            System.out.println("7) Dólar =>> Colon Costa Rica");
            System.out.println("8) Colon Costa Rica =>> Dólar");
            System.out.println("9) Salir");
            System.out.println("\n****************************************");

            System.out.print("Elija una opción valida: ");

            int option = readKeyboard.nextInt();
            if (option > 9 ) System.out.println("\n\nOPTION NO VALIDA\n\n");

            if ( option == 9 ) {
                String goodbyeMessage = "MUCHAS GRACIAS...!";
                System.out.println("\n\n****************************************");
                System.out.println("**********SALIENDO DEL SISTEMA**********");
                System.out.println("****************************************\n\n");

                // loop to say thanks to user
                for (int i = 0; i < goodbyeMessage.length(); i++) {
                    System.out.print(goodbyeMessage.charAt(i)); // Print current letter
                    try {
                        Thread.sleep(500); // Wait 500 milliseconds (0.5 seconds)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                break;
            } // end finish option if

            switch (option) {
                case 1:
                    baseCode = "USD";
                    targetCode = "ARS";
                    System.out.println("\n****************************************");
                    System.out.println("Dólar" + "( " + baseCode + " )" + " =>> " + "Peso Argentino" + "( " + targetCode + " )");
                    System.out.println("****************************************\n");
                    System.out.print("Ingrese el monto que desea cambiar: ");
                    amount = readKeyboard.nextDouble();
                    response = conectionApi.createConsulChangeRateTotAPI(baseCode, targetCode, amount);
                    System.out.println("\n\nConversion Resultado: " + response.conversion_result() + "\n\n" );
                    break;
                case 2:
                    baseCode = "ARS";
                    targetCode = "USD";
                    System.out.println("\n****************************************");
                    System.out.println("Peso Argentino" + "( " + baseCode + " )" + " =>> " + "Dólar" + "( " + targetCode + " )");
                    System.out.println("****************************************\n");
                    System.out.print("Ingrese el monto que desea cambiar: ");
                    amount = readKeyboard.nextDouble();
                    response = conectionApi.createConsulChangeRateTotAPI(baseCode, targetCode, amount);
                    System.out.println("\n\nConversion Resultado: " + response.conversion_result() + "\n\n" );
                    break;
                case 3:
                    baseCode = "USD";
                    targetCode = "BRL";
                    System.out.println("\n****************************************");
                    System.out.println("Dólar" + "( " + baseCode + " )" + " =>> " + "Real Brasileño" + "( " + targetCode + " )");
                    System.out.println("****************************************\n");
                    System.out.print("Ingrese el monto que desea cambiar: ");
                    amount = readKeyboard.nextDouble();
                    response = conectionApi.createConsulChangeRateTotAPI(baseCode, targetCode, amount);
                    System.out.println("\n\nConversion Resultado: " + response.conversion_result() + "\n\n" );
                    break;
                case 4:
                    baseCode = "BRL";
                    targetCode = "USD";
                    System.out.println("\n****************************************");
                    System.out.println("Real Brasileño" + "( " + baseCode + " )" + " =>> " + "Dólar" + "( " + targetCode + " )");
                    System.out.println("****************************************\n");
                    System.out.print("Ingrese el monto que desea cambiar: ");
                    amount = readKeyboard.nextDouble();
                    response = conectionApi.createConsulChangeRateTotAPI(baseCode, targetCode, amount);
                    System.out.println("\n\nConversion Resultado: " + response.conversion_result() + "\n\n" );
                    break;
                case 5:
                    baseCode = "USD";
                    targetCode = "COP";
                    System.out.println("\n****************************************");
                    System.out.println("Dólar" + "( " + baseCode + " )" + " =>> " + "Peso Colombiano" + "( " + targetCode + " )");
                    System.out.println("****************************************\n");
                    System.out.print("Ingrese el monto que desea cambiar: ");
                    amount = readKeyboard.nextDouble();
                    response = conectionApi.createConsulChangeRateTotAPI(baseCode, targetCode, amount);
                    System.out.println("\n\nConversion Resultado: " + response.conversion_result() + "\n\n" );
                    break;
                case 6:
                    baseCode = "COP";
                    targetCode = "USD";
                    System.out.println("\n****************************************");
                    System.out.println("Peso Colombiano" + "( " + baseCode + " )" + " =>> " + "Dólar" + "( " + targetCode + " )");
                    System.out.println("****************************************\n");
                    System.out.print("Ingrese el monto que desea cambiar: ");
                    amount = readKeyboard.nextDouble();
                    response = conectionApi.createConsulChangeRateTotAPI(baseCode, targetCode, amount);
                    System.out.println("\n\nConversion Resultado: " + response.conversion_result() + "\n\n" );
                    break;
                case 7:
                    baseCode = "USD";
                    targetCode = "CRC";
                    System.out.println("\n****************************************");
                    System.out.println("Dólar" + "( " + baseCode + " )" + " =>> " + "Colon Costa Rica" + "( " + targetCode + " )");
                    System.out.println("****************************************\n");
                    System.out.print("Ingrese el monto que desea cambiar: ");
                    amount = readKeyboard.nextDouble();
                    response = conectionApi.createConsulChangeRateTotAPI(baseCode, targetCode, amount);
                    System.out.println("\n\nConversion Resultado: " + response.conversion_result() + "\n\n" );
                    break;
                case 8:
                    baseCode = "CRC";
                    targetCode = "USD";
                    System.out.println("\n****************************************");
                    System.out.println("Colon Costa Rica" + "( " + baseCode + " )" + " =>> " + "Dólar" + "( " + targetCode + " )");
                    System.out.println("****************************************\n");
                    System.out.print("Ingrese el monto que desea cambiar: ");
                    amount = readKeyboard.nextDouble();
                    response = conectionApi.createConsulChangeRateTotAPI(baseCode, targetCode, amount);
                    System.out.println("\n\nConversion Resultado: " + response.conversion_result() + "\n\n" );
                    break;
            } // end switch case

        } // end While

    } // end main function
} // end Main Class
