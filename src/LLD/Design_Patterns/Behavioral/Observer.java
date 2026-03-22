package LLD.Design_Patterns.Behavioral;

import java.util.ArrayList;
import java.util.List;

public class Observer {
    public static void main(String[] args) {
        Channel bbkivines = new Channel("bbkivines");

        User lavesh = new User("lavesh");
        User gaurav = new User("gaurav");

        bbkivines.subscribe(lavesh);
        bbkivines.subscribe(gaurav);
        bbkivines.uploadVideo();

        bbkivines.unSubsribe(gaurav);
        bbkivines.uploadVideo();
    }
}

class User implements IObserver{
    public String userName;
    private List<ISubject> subscribedChannel;

    User(String userName){
        this.userName = userName;
        subscribedChannel = new ArrayList<>();
    }
    public void update(String channelName){
        System.out.println("Hey " + userName + ", " + channelName + " uploaded a new Video!");    }
}

class Channel implements ISubject{
    private List<IObserver> subsriberList;
    public String channelName;

    Channel(String channelName){
        this.channelName = channelName;
        subsriberList = new ArrayList<>();
    }
    public void subscribe(IObserver user){
        subsriberList.add(user);
    }

    public void unSubsribe(IObserver user){
        subsriberList.remove(user);
    }

    public void notifySubscriber(){
        subsriberList.parallelStream().forEach( sub -> sub.update(channelName));
    }

    public void uploadVideo(){
        System.out.println("\n--- " + channelName + " is uploading... ---");
        notifySubscriber();
    }
}

interface IObserver{
    void update(String channelName);
}
interface ISubject{
    void subscribe(IObserver observer);
    void unSubsribe(IObserver observer);
    void notifySubscriber();
}
