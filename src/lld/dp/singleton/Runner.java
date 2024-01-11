package lld.dp.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

  public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
    EagerInitializedSingleton eagerInitializedSingleton= EagerInitializedSingleton.getInstance();
    //System.out.println("eagerInitializedSingleton=>"+eagerInitializedSingleton);
    StaticBlockSingleton eagerInitializedSingleton2= StaticBlockSingleton.getInstance();
    //System.out.println("eagerInitializedSingleton2=>"+eagerInitializedSingleton2);

//    ExecutorService service = Executors.newFixedThreadPool(4);
//    for (int i = 0; i < 20; i++) {
//      service.execute(() -> {System.out.println(ThreadSafeSingleton.getInstance());});
//    }
    //System.out.println("EnumSingleton.INSTANCE-->"+EnumSingleton.INSTANCE.hashCode());
   // System.out.println("EnumSingleton.INSTANCE-->"+EnumSingleton.INSTANCE.hashCode());

   // LazyInitializedSingleton eagerInitializedSingleton3= LazyInitializedSingleton.getInstance();
   // System.out.println("eagerInitializedSingleton3=>"+eagerInitializedSingleton3);


    SerializedSingleton instanceOne = SerializedSingleton.getInstance();
    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
        "filename.ser"));
    out.writeObject(instanceOne);
    out.close();

    // deserialize from file to object
    ObjectInput in = new ObjectInputStream(new FileInputStream(
        "filename.ser"));
    SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
    in.close();

    System.out.println("instanceOne hashCode="+instanceOne.hashCode());
    System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());

  }

}
