package org.csaba79coder;

import org.csaba79coder.controller.FootballController;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) {
        FootballController footballController = new FootballController();
        try {
            Object result = footballController.renderAllFootballTeams();
            System.out.println(result);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}