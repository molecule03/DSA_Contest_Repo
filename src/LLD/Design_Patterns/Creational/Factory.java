package LLD.Design_Patterns.Creational;

public class Factory {

    public static void main(String[] args) {

        // Intaniate Factory class
        DocumentFactory documentFactory = new DocumentFactory();

        // Input from user/other service
        String type = "Excel";

        // Instead of creating classes by ourself, outsource it to the factory class
        Document document = documentFactory.createDocument(type);
        document.open();

    }

    interface Document{
        public void open();
    }
    static class PDF implements  Document{
        public void open(){
            System.out.println("This is a PDF Document");
        }
    };
    static class Word implements  Document{
        public void open(){
            System.out.println("This is a Word Document");
        }
    };
    static class Excel implements  Document{
        public void open(){
            System.out.println("This is a Excel Document");
        }
    };

    static class DocumentFactory{

        public Document createDocument(String type){
            Document document = switch (type) {
                case "PDF" -> new PDF();
                case "Word" -> new Word();
                case "Excel" -> new Excel();
                default -> throw new IllegalArgumentException("Not a valid Document type");
            };
            return document;
        }
    }
}
