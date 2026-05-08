
// class Foo {
//     private CountDownLatch latch1;
//     private CountDownLatch latch2;

//     public Foo() {
//         latch1 = new CountDownLatch(1); // waits for first()
//         latch2 = new CountDownLatch(1); // waits for second()
//     }

//     public void first(Runnable printFirst) throws InterruptedException {
//         // printFirst.run() outputs "first"
//         printFirst.run();
//         latch1.countDown(); // signal that first() is done
//     }

//     public void second(Runnable printSecond) throws InterruptedException {
//         latch1.await(); // wait until first() finishes
//         // printSecond.run() outputs "second"
//         printSecond.run();
//         latch2.countDown(); // signal that second() is done
//     }

//     public void third(Runnable printThird) throws InterruptedException {
//         latch2.await(); // wait until second() finishes
//         // printThird.run() outputs "third"
//         printThird.run();
//     }
// }
import java.util.concurrent.Semaphore;

class Foo {
    private Semaphore sem1 = new Semaphore(0);
    private Semaphore sem2 = new Semaphore(0);

    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        sem1.release(); // allow second() to run
    }

    public void second(Runnable printSecond) throws InterruptedException {
        sem1.acquire(); // wait for first()
        printSecond.run();
        sem2.release(); // allow third() to run
    }

    public void third(Runnable printThird) throws InterruptedException {
        sem2.acquire(); // wait for second()
        printThird.run();
    }
}
