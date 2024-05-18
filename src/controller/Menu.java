package controller;

import models.CurrencyConvertion;
import service.ApiToCurrenyConvertion;
import service.ConvertingToJsonCurrencyConvertion;
import service.ErrorMessageToMenuInput;
import service.ExitMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    ApiToCurrenyConvertion apiToCurrenyConvertion = new ApiToCurrenyConvertion();
    ConvertingToJsonCurrencyConvertion convertionToJson = new ConvertingToJsonCurrencyConvertion(apiToCurrenyConvertion);
    ErrorMessageToMenuInput errorMessage = new ErrorMessageToMenuInput();
    ExitMenu exitMenu = new ExitMenu();


    public void start() {

        int option = 0;
        String baseCurrency;
        String targetCurrency;
        String optionText =
                """
                *******************************************
                Welcome to Currency Converter!!!
                
                1) Dollar ==> Argentine Peso
                2) Argentine Peso ==> Dollar
                3) Dollar ==> Brazilian Real
                4) Brazilian Real ==> Dollar
                5) Dollar ==> Colombian Peso
                6) Colombian Peso ==> Dollar
                7) Euro ==> Dollar
                8) Dollar ==> Euro
                9) Canadian Dollar ==> Dollar
                10) Dollar ==> Canadian Dollar
                11) Exit
                
                Choose a valid option:
                *******************************************
                """
        ;

        while (option != 11) {
            System.out.println(optionText);

            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");
                scanner.nextLine();
                pressEnterToContinue();
                continue;
            }
            scanner.nextLine();

            switch (option) {
                case 1:
                    baseCurrency = "USD";
                    targetCurrency = "ARS";

                    getConversionInput(baseCurrency, targetCurrency);
                    break;
                case 2:
                    baseCurrency = "ARS";
                    targetCurrency = "USD";

                    getConversionInput(baseCurrency, targetCurrency);
                    break;
                case 3:
                    baseCurrency = "USD";
                    targetCurrency = "BRL";

                    getConversionInput(baseCurrency, targetCurrency);
                    break;
                case 4:
                    baseCurrency = "BRL";
                    targetCurrency = "USD";

                    getConversionInput(baseCurrency, targetCurrency);
                    break;
                case 5:
                    baseCurrency = "USD";
                    targetCurrency = "COP";

                    getConversionInput(baseCurrency, targetCurrency);
                    break;
                case 6:
                    baseCurrency = "COP";
                    targetCurrency = "USD";

                    getConversionInput(baseCurrency, targetCurrency);
                    break;
                case 7:
                    baseCurrency = "EUR";
                    targetCurrency = "USD";

                    getConversionInput(baseCurrency, targetCurrency);
                    break;
                case 8:
                    baseCurrency = "USD";
                    targetCurrency = "EUR";

                    getConversionInput(baseCurrency, targetCurrency);
                    break;
                case 9:
                    baseCurrency = "CAD";
                    targetCurrency = "USD";

                    getConversionInput(baseCurrency, targetCurrency);
                    break;
                case 10:
                    baseCurrency = "USD";
                    targetCurrency = "CAD";

                    getConversionInput(baseCurrency, targetCurrency);
                    break;
                case 11:
                    exitMenu.start();
                    break;
                default:
                    errorMessage.start();
                    pressEnterToContinue();
                    break;
            }
        }
    }

    private void getConversionInput(String baseCurrency, String targetCurrency) {
        String value;
        String regex = "^(\\d+(?:\\.\\d+)?)|(^\\d+)$";

        do {
            System.out.printf("Specify the %s amount you'd like to convert into %s: ", baseCurrency, targetCurrency);
            value = scanner.nextLine();

            if (!value.matches(regex)) {
                System.out.println("Invalid input. Please enter a valid amount");
            }
        } while (!value.matches(regex));

        CurrencyConvertion convertion = convertionToJson.start(baseCurrency, targetCurrency, value);

        System.out.printf("%nAn amount of %s [%s] is equivalent to a final amount of %s [%s]%n%n", value, baseCurrency, convertion.conversion_result(), targetCurrency);
    }

    private void pressEnterToContinue() {
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }
}
