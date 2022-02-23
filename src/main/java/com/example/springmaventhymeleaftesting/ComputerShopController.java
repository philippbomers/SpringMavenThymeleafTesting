package com.example.springmaventhymeleaftesting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ComputerShopController {

    @RequestMapping(value = "/")
    public ModelAndView index() {

        // generate a computer with some values
        Computer PhilippsPC = new Computer("Philipps Computer", "Dell", 32, true);
        PhilippsPC.setPurchasingPrice(670.65);
        PhilippsPC.setSellingPrice(455.59);
        PhilippsPC.setOperatingSystem("Fedora");
        PhilippsPC.setRamGb(16);
        PhilippsPC.setNumberOfUsbPorts((byte) 6);
        PhilippsPC.setGraphicCard("AMD");
        PhilippsPC.setHddGb(250);
        PhilippsPC.setCpuMhz(3600);
        PhilippsPC.setType("Workstation");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Computershop");
        modelAndView.addObject("philippscomputer", PhilippsPC);

        PhilippsPC.setRamGb(PhilippsPC.getRamGb() * 2);
        PhilippsPC.setSellingPrice(PhilippsPC.getSellingPrice() + 40);
        PhilippsPC.setPurchasingPrice(PhilippsPC.getPurchasingPrice() + 60);
        modelAndView.addObject("philippscomputer_doubledram", PhilippsPC);

        //generate 5 more computers
        Computer[]
                allComputers = new Computer[5];
        String[]
                manufacturerNames = {"Dell", "IBM", "Apple", "Microsoft", "Samsung"},
                computerTypes = {"Workstation", "Workstation", "Workstation", "Notebook", "Tablet"},
                graphicCards = {"AMD", "AMD", "Intel", "Nvidia", "Adreno"},
                operatingSystems = {null, "RHEL", "MacOs", "Windows", "Android"};
        int[]
                screenSize = {32, 24, 0, 18, 7},
                cpuSpeeds = {3600, 2700, 1600, 3800, 700},
                hddSpaces = {512, 256, 256, 1024, 36},
                ramSpaces = {16, 16, 8, 8, 4};
        boolean[]
                preInstalledOs = {false, true, true, true, true};
        double[]
                purchasingPrices = {857.22, 451.99, 2045.99, 1599.29, 345},
                sellingPrices = {650, 400.10, 1200.99, 1200.20, 300.11};
        byte[]
                numberOfUsbPorts = {5, 8, 2, 3, 1};

        for (int i = 0; i < allComputers.length; i++) {
            allComputers[i] = new Computer(
                    "Computer " + (i + 1),
                    manufacturerNames[i],
                    computerTypes[i],
                    graphicCards[i],
                    operatingSystems[i],
                    cpuSpeeds[i],
                    screenSize[i],
                    ramSpaces[i],
                    hddSpaces[i],
                    numberOfUsbPorts[i],
                    purchasingPrices[i],
                    sellingPrices[i],
                    preInstalledOs[i]
            );
        }
        modelAndView.addObject("computerarray", allComputers);

        // calculate the profit when selling all computers
        double completeProfit = 0;
        for (Computer computer : allComputers) {
            completeProfit += computer.getProfit();
        }
        completeProfit = MathOperations.reduceDecimals(completeProfit);
        modelAndView.addObject("completeprofit", completeProfit);

        return modelAndView;
    }

}
