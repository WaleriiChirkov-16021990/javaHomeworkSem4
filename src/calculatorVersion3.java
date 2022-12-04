    /*
В калькулятор добавьте возможность отменить последнюю операцию.
 */

import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class calculatorVersion3 {
        public static void main(String[] args) throws Exception {
            Logger logger = Logger.getLogger(calculatorVersion3.class.getName());
            FileHandler fh = new FileHandler("logCalc.xml");
            logger.addHandler(fh);
            XMLFormatter xml = new XMLFormatter();
            fh.setFormatter(xml);
            logger.info("калькулятор запущен.");
            System.out.println("Перед вами калькулятор.");
            System.out.println("Для работы со мной выберите операцию.");
            Scanner scanner = new Scanner(System.in);
            int input;
            Double num1 ;
            Double num2 ;
            LinkedList<Double> resultData = new LinkedList<>();
            while (true) {
                System.out.println("\n1.Сложение \n2.Вычитание \n3.Умножение \n4.Деление\n5.Выход");
                if (resultData.size() > 0){
                    System.out.println("6.Отменить действие \n7.Очистить историю результатов" );
                    System.out.printf("\nПоследний результат = %s\n", resultData.getLast());
                }
                System.out.println("Выберите действие: ");
                if (scanner.hasNextInt()) {
                    input = scanner.nextInt();
                    logger.info(String.format("пользователь ввел %s", input));
                    if (input > 0 && input < 8) {
                        if (input == 5){
                            logger.info("программа завершена.");
                            fh.close();
                            scanner.close();
                            break;
                        }else if (input==6){
                            logger.info(String.format("пользователь отменил последний результат %s", resultData.getLast()));
                            resultData.remove(resultData.getLast());
                            logger.info(String.format("текущая история результатов '%s'", resultData));
                            continue;
                        } else if (input == 7){
                            logger.info(String.format("пользователь очистил историю результатов %s", resultData));
                            resultData.clear();
                            continue;
                        }
                    } else {
                        System.out.println("Такого пункта нет!");
                        logger.warning("Пользователь ввел неизвестный пункт.");
                        continue;
                    }
                } else {
                    System.out.println("Вы ввели не число");
                    logger.warning("Пользователь ввел неизвестное число.");
                    scanner = new Scanner(System.in);
                    continue;
                }
                while (true) {
                    if(resultData.size() == 0) {
                        System.out.println("Введите 1 число: ");
                        if (scanner.hasNextDouble()) {
                            num1 = scanner.nextDouble();
                            logger.info(String.format("пользователь ввел первое число %s", num1));
                        } else {
                            System.out.println("Вы ввели не число.");
                            logger.warning("Пользователь ввел неизвестное число.");
                            scanner = new Scanner(System.in);
                            continue;
                        }
                    } else {
                        num1 = resultData.getLast();
                        System.out.printf("первое число: %s", num1);
                    }
                    System.out.println("\nВведите второе число: ");
                    if (scanner.hasNextDouble()) {
                        num2 = scanner.nextDouble();
                        logger.info(String.format("пользователь ввел второе число %s", num2));
                        if (input ==4) {
                            if (num2 == 0) {
                                logger.warning(String.format("пользователь пытается делить на '%s'", num2));
                                System.out.println("На 0 делить нельзя!");
                                scanner = new Scanner(System.in);
                                continue;
                            }
                        }
                    } else {
                        System.out.println("Вы ввели не число.");
                        logger.warning("Пользователь ввел неизвестное число.");
                        scanner = new Scanner(System.in);
                        continue;
                    }
                    var result = calc(input, num1, num2);
                    resultData.add(result);
                    logger.info(String.format("пользователь получил результат '%s'", result));
                    logger.info(String.format("текущая история результатов '%s'", resultData));
                    System.out.printf("ответ = %s \n", result);
                    break;
                }
            }
        }

        private static Double calc(int inp, Double num1, Double num2){
            var result = 0.0;
            if (inp == 1) {
                result = num1 + num2;
            }
            else if (inp == 2) {
                result = num1 - num2;
            } else if (inp == 3) {
                result = num1 * num2;
            }else if (inp == 4) {
                result = num1 / num2;
            }
            return result;
        }
}
