package HW.HW5;

import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    ReentrantLock lock = new ReentrantLock();
    public void pickUp(){
        lock.lock();
    }
    public void putDown(){
        lock.unlock();
    }
}
