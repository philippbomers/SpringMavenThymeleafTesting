package com.example.springmaventhymeleaftesting;

public class Computer {
    private String computerName, manufacturerName, type, graphicCard, operatingSystem;
    private int cpuMhz, screenSizeInches, ramGb, hddGb;
    private byte numberOfUsbPorts;
    private double purchasingPrice, sellingPrice;
    private boolean preInstalledOs;

    public Computer() {
    }

    public Computer(String computerName, String manufacturerName, int screenSizeInches, boolean preInstalledOs) {
        this.setComputerName(computerName);
        this.setManufacturerName(manufacturerName);
        this.setScreenSizeInches(screenSizeInches);
        this.setPreInstalledOs(preInstalledOs);
    }

    public Computer(String computerName, String manufacturerName, String type, String graphicCard, String operatingSystem,
                    int cpuMhz, int screenSizeInches, int ramGb, int hddGb,
                    byte numberOfUsbPorts, double purchasingPrice, double sellingPrice,
                    boolean preInstalledOs) {
        this.setComputerName(computerName);
        this.setManufacturerName(manufacturerName);
        this.setType(type);
        this.setGraphicCard(graphicCard);
        this.setOperatingSystem(operatingSystem);
        this.setCpuMhz(cpuMhz);
        this.setScreenSizeInches(screenSizeInches);
        this.setRamGb(ramGb);
        this.setHddGb(hddGb);
        this.setNumberOfUsbPorts(numberOfUsbPorts);
        this.setPurchasingPrice(purchasingPrice);
        this.setSellingPrice(sellingPrice);
        this.setPreInstalledOs(preInstalledOs);
    }

    public String getManufacturerName() {
        if (this.manufacturerName == null)
            return "Unbekannt";
        return this.manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getType() {
        if (this.type == null)
            return "Unbekannt";
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCpuMhz() {
        return this.cpuMhz;
    }

    public void setCpuMhz(int cpuMhz) {
        this.cpuMhz = cpuMhz;
    }

    public String getScreenSizeInches() {
        if (this.screenSizeInches == 0)
            return "Kein Bildschirm vorhanden.";
        return this.screenSizeInches + " Zoll";
    }

    public void setScreenSizeInches(int screenSizeInches) {
        this.screenSizeInches = screenSizeInches;
    }

    public int getRamGb() {
        return this.ramGb;
    }

    public void setRamGb(int ramGb) {
        this.ramGb = ramGb;
    }

    public int getHddGb() {
        return this.hddGb;
    }

    public void setHddGb(int hddGb) {
        this.hddGb = hddGb;
    }

    public byte getNumberOfUsbPorts() {
        return this.numberOfUsbPorts;
    }

    public void setNumberOfUsbPorts(byte numberOfUsbPorts) {
        this.numberOfUsbPorts = numberOfUsbPorts;
    }

    public String isPreInstalledOs() {
        if (this.preInstalledOs) {
            if (this.getOperatingSystem() != null)
                return "Vorinstalliert (" + this.getOperatingSystem() + ")";
            return "Vorinstalliert";
        } else
            return "Nicht vorhanden";
    }

    public void setPreInstalledOs(boolean preInstalledOs) {
        this.preInstalledOs = preInstalledOs;
    }

    public String getGraphicCard() {
        if (this.graphicCard == null)
            return "Unbekannt";
        return this.graphicCard;
    }

    public void setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
    }

    public double getPurchasingPrice() {
        return MathOperations.reduceDecimals(purchasingPrice);
    }

    public void setPurchasingPrice(double purchasingPrice) {
        this.purchasingPrice = purchasingPrice;
    }

    public double getSellingPrice() {
        return MathOperations.reduceDecimals(this.sellingPrice);
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getProfit() {
        return MathOperations.reduceDecimals(this.purchasingPrice - this.sellingPrice);
    }

    public String getOperatingSystem() {
        if (this.operatingSystem == null)
            return "Unbekanntes Betriebssystem";
        return this.operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getComputerName() {
        if (this.computerName == null)
            return "Unbekannter PC";
        return this.computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String toString() {
        return "<b>" + this.getComputerName() + "</b>" +
                "<br>Verkaufspreis: " + this.getPurchasingPrice() + " Euro" +
                "<br>Kaufpreis: " + this.getSellingPrice() + "Euro" +
                "<br>Gewinn: " + this.getProfit() + " Euro" +
                "<br>Hersteller: " + this.getManufacturerName() +
                "<br>Computertyp: " + this.getType() +
                "<br>Grafikkarte: " + this.getGraphicCard() +
                "<br>Prozessorgeschwindigkeit: " + this.getCpuMhz() + " MHZ" +
                "<br>Bildschirmdiagonale: " + this.getScreenSizeInches() +
                "<br>Arbeitsspeicher: " + this.getRamGb() + " Gigabyte" +
                "<br>Festplattenspeicher: " + this.getHddGb() + " Gigabyte" +
                "<br>Anzahl der USB-Ports: " + this.getNumberOfUsbPorts() +
                "<br>Betriebssystem: " + this.isPreInstalledOs();
    }
}
