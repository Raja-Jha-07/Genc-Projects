package com.example.solid;

public class MainInterface {

    public static void main(String[] args) {
        Printer printer = new SimplePrinter();
        printer.printDocument("MyDocument.txt");

        Scanner scanner = new MultiFunctionPrinter();
        scanner.scanDocument("MyDocument.txt");

        Writable writable=new simpleWritable();
        writable.writeDocument("yesWritabledocument");

    }

}