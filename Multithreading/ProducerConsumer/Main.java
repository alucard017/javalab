package javalab.Multithreading.ProducerConsumer;

public class Main {
    public static void main(String[] args) {
        Common c = new Common();
        Producer p = new Producer(c, "Producer");
        Consumer co = new Consumer(c, "Consumer");

        try {
            p.t.join();
            co.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


// anonymous inner class syntax
// package javalab.Multithreading.ProducerConsumer;

// public class Main {
//     public static void main(String[] args) {
//         Common c = new Common();

//         // Anonymous inner class for Producer
//         Thread p = new Thread(new Runnable() {
//             @Override
//             public void run() {
//                 Producer producer = new Producer(c, "Producer");
//                 producer.produce();
//             }
//         });

//         // Anonymous inner class for Consumer
//         Thread co = new Thread(new Runnable() {
//             @Override
//             public void run() {
//                 Consumer consumer = new Consumer(c, "Consumer");
//                 consumer.consume();
//             }
//         });

//         p.start();
//         co.start();

//         try {
//             p.join();
//             co.join();
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }
//     }
// }
