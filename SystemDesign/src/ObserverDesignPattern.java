import java.util.ArrayList;
import java.util.List;

abstract class IChannal {
    abstract void unsubscirbe(ISubscriber ch);

    abstract void subscirbe(ISubscriber ch);

    public abstract void notifyUser();
}

abstract class ISubscriber {
    abstract void update();
}
class Channal extends IChannal {
    List<ISubscriber> sub = new ArrayList<>();
    String name;
    String latestvideo;

    public Channal(String name) {
        this.name = name;
        this.sub=new ArrayList<>();
    }

    void uploading(String title) {
        latestvideo=title;
        System.out.println("video is uploading");
        notifyUser();
    }

    @Override
    void unsubscirbe(ISubscriber ch) {
        sub.remove(ch);
    }

    @Override
    void subscirbe(ISubscriber ch) {
        if(!sub.contains(ch)){
            sub.add(ch);
        }
    }

    @Override
    public void notifyUser() {
        for (ISubscriber s : sub) {
            s.update();
        }
    }
    public void uploadVideo(String video){
        this.latestvideo=video;
        System.out.println("video is uploading");
        notifyUser();
    }
    String getData(){
        return latestvideo;
    }
}

class Subscriber extends ISubscriber {
    String name;
    Channal channal;
public Subscriber(String name,Channal ch){
    this.name=name;
    this.channal=ch;
}
    @Override
    void update() {
        System.out.println("hey "+name+","+this.channal.getData()+" uploaded");
    }
}

public class ObserverDesignPattern {
    public static void main(String[] args) {
        Channal ch = new Channal("Coder");
        Subscriber s1=new Subscriber("sakshi",ch);
        Subscriber s2=new Subscriber("priya",ch);
        ch.subscirbe(s1);
        ch.subscirbe(s2);
        ch.uploadVideo("time series data");
        ch.unsubscirbe(s2);
        ch.uploadVideo("time series data part 2");
    }
}
