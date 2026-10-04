package com.zhao;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("欢迎进入游戏世界");
        System.out.println("出拳规则:1.剪刀 2:石头 3.布");

        System.out.print("游戏开始 选择对手(1:深蓝 2:银河 3:天河):");
        int opponentChoice = getValidInput(scanner);

        System.out.print("选择角色(1:刘备 2:孙权 3:曹操):");
        int playerRoleChoice = getValidInput(scanner);

        String opponentName = "";
        switch (opponentChoice) {
            case 1:
                opponentName = "深蓝";
                break;
            case 2:
                opponentName = "银河";
                break;
            case 3:
                opponentName = "天河";
                break;
        }

        String playerRole = "";
        switch (playerRoleChoice) {
            case 1:
                playerRole = "刘备";
                break;
            case 2:
                playerRole = "孙权";
                break;
            case 3:
                playerRole = "曹操";
                break;
        }

        boolean continuePlaying = true;
        int playerMove = 0;
        int computerMove = 0;
        while (continuePlaying) {
            System.out.print("请出拳(1:剪刀 2:石头 3:布):");
            playerMove = getValidInput(scanner);

            computerMove = random.nextInt(3) + 1;

            String playerMoveStr = "";
            switch (playerMove) {
                case 1:
                    playerMoveStr = "剪刀";
                    break;
                case 2:
                    playerMoveStr = "石头";
                    break;
                case 3:
                    playerMoveStr = "布";
                    break;
            }

            String computerMoveStr = "";
            switch (computerMove) {
                case 1:
                    computerMoveStr = "剪刀";
                    break;
                case 2:
                    computerMoveStr = "石头";
                    break;
                case 3:
                    computerMoveStr = "布";
                    break;
            }

            System.out.println(playerRole + "出拳：" + playerMoveStr);
            System.out.println(opponentName + "出拳：" + computerMoveStr);

            if ((playerMove == 1 && computerMove == 3) || (playerMove == 2 && computerMove == 1) || (playerMove == 3 && computerMove == 2)) {
                System.out.println("你赢了！");
            } else if ((playerMove == 1 && computerMove == 2) || (playerMove == 2 && computerMove == 3) || (playerMove == 3 && computerMove == 1)) {
                System.out.println("你输了！");
            } else {
                System.out.println("平局！");
            }

            System.out.print("是否要继续玩?(yes/no):");
            String continueChoice = scanner.next();
            continuePlaying = continueChoice.equalsIgnoreCase("yes");
        }

        System.out.println("对战结果：");
        if ((playerMove == 1 && computerMove == 3) || (playerMove == 2 && computerMove == 1) || (playerMove == 3 && computerMove == 2)) {
            System.out.println(playerRole + "战胜了" + opponentName);
        } else if ((playerMove == 1 && computerMove == 2) || (playerMove == 2 && computerMove == 3) || (playerMove == 3 && computerMove == 1)) {
            System.out.println(opponentName + "战胜了" + playerRole);
        } else {
            System.out.println(playerRole + "与" + opponentName + "战平。");
        }
    }

    private static int getValidInput(Scanner scanner) {
        int choice = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 3) {
                    validInput = true;
                } else {
                    System.out.println("输入错误，请重新输入(1-3 之间的数字):");
                }
            } catch (InputMismatchException e) {
                System.out.println("输入错误，请重新输入(1-3 之间的数字):");
                scanner.next();
            }
        }
        return choice;
    }
}