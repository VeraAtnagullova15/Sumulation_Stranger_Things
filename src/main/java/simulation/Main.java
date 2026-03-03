package simulation;


import simulation.Dialogs.Dialog;
import simulation.Dialogs.EnglishLetterSelectDialog;
import simulation.Dialogs.IntegerMinMaxDialog;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dialog<Integer> integerDialog = new IntegerMinMaxDialog("Введите размер стороны карты от 10 (10х10) до 30 (30х30)",
                "Неверный ввод",
                10, 30);
        RendererWorldMap renderer = new RendererWorldMap();
        int height = integerDialog.input();
        int width = height;

        WorldMap world = new WorldMap(height, width);
        Simulation simulation = new Simulation(world);
        Runnable job = new SimulationThread(simulation);
        simulation.start();
        Thread thread = new Thread(job);
        Dialog<Character> letterSelectDialog = new EnglishLetterSelectDialog("Введите T - сделать один шаг, " +
                "S - запустить симуляцию, P - пауза,"  + "\n" + "R - рестарт симуляции после паузы, Q - завершение программы",
                "Неверная команда");
        while (true) {
            char type = letterSelectDialog.input();
            switch (type) {
                case 't', 'T' -> {
                    simulation.nextTurn();
                }
                case 's', 'S' -> {
                    if(!thread.isAlive())
                    thread.start();
                }
                case 'p', 'P' -> {
                    simulation.pauseSimulation();
                }
                case 'r', 'R' -> simulation.restartSimulation();
                case 'q', 'Q' -> {
                    simulation.pauseSimulation();
                    simulation.isRunning = false;
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return;
                }

            }
        }
    }
}


