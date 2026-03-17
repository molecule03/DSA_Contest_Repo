package LLD.Design_Patterns.Creational;

public class Singleton {
    public static void main(String[] args) {

        DBconnection pg = DBconnection.getInstance();
        pg.connect("postgres");
        pg.checkConnection();

        DBconnection pg2 = DBconnection.getInstance();
        pg2.checkConnection();
    }
}
class DBconnection{
    private String connection;
    private static DBconnection dBconnection;
    public void connect(String connect){
        connection = connect;
    }
    public void checkConnection(){
        System.out.println("Connected to "+connection);
    }
    private DBconnection(){
    }

    public static synchronized DBconnection getInstance(){
        if(dBconnection == null){
            dBconnection = new DBconnection();
        }
        return dBconnection;
    }

}


