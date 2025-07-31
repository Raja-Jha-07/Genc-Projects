package com.example.solid;

// Interface for Printer
interface Printer {
    void printDocument(String document);
}

// Interface for Scanner
interface Scanner {
    void scanDocument(String document);
}

interface Writable{
    void writeDocument(String document);
}

// MultiFunctionPrinter implements both Printer and Scanner interfaces
class MultiFunctionPrinter implements Printer, Scanner , Writable {
    @Override
    public void printDocument(String document) {
        System.out.println("Printing document: " + document);
    }

    @Override
    public void scanDocument(String document) {
        System.out.println("Scanning document: " + document);
    }

    @Override
    public void writeDocument(String document){
        System.out.println("writing document"+document);
    }
}

// SimplePrinter implements only Printer interface
class SimplePrinter implements Printer {
    @Override
    public void printDocument(String document) {
        System.out.println("Printing document: " + document);
    }
}
class simpleWritable implements Writable{
    @Override
    public void writeDocument(String document){
        System.out.println("Writing new document"+document);
    }
}