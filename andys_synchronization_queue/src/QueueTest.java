/**
 * Created with IntelliJ IDEA.
 * User: michelle
 * Date: 11/26/12
 * Time: 9:07 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.HashMap;
import java.util.Map;

public class QueueTest {
    public static void main(String[] args) {
        System.out.println("Queue Test");
        Queue<String> q = new WhatQueue<String>();

        System.out.println("\nTest enqueue()");
        q.clear();
        q.enqueue("A");
        q.enqueue("B");
        System.out.println("Expecting " + "[A, B]" + ":  " + q);
        q.clear();
        q.enqueue("A");
        q.enqueue(null);
        System.out.println("Expecting " + "[A]" + ":  " + q);

        System.out.println("\nTest dequeue()");
        q.clear();
        q.dequeue();
        System.out.println("Expecting " + "[]" + ":  " + q);
        q.clear();
        q.enqueue("A");
        q.enqueue("B");
        System.out.println("Expecting " + "A" + ":  " + q.dequeue());
        System.out.println("Expecting " + "[B]" + ":  " + q);

        System.out.println("\nTest clear()");
        q.clear();
        q.enqueue("A");
        q.enqueue("B");
        q.clear();
        System.out.println("Expecting " + "[]" + ":  " + q);

        System.out.println("\nTest size()");
        q.clear();
        System.out.println("Expecting " + "0" + ":  " + q.size());
        q.enqueue("A");
        q.enqueue("B");
        System.out.println("Expecting " + "2" + ":  " + q.size());

        System.out.println("\nSynchronization test");
        QueueTest test = new QueueTest();
        test.runSynchronizationTest();
        System.out.println("Synchronization test completed");
    }

    public void runSynchronizationTest() {
        int samples = 20000;
        final Queue<Integer> q = new WhatQueue<Integer>();

        // Add items into queue
        for (int i = 0; i < samples; i++) {
            q.enqueue(i);
        }

        // Start two threads to dequeue the queue
        Map<Integer, Integer> dequeuedItems = new HashMap<Integer, Integer>();
        Thread t1 = new DequeueThread(q, samples / 2, dequeuedItems);
        Thread t2 = new DequeueThread(q, samples / 2, dequeuedItems);
        t1.start();
        t2.start();

        // Wait for threads to finish, and go through dequeuedItems map to make sure each item
        // was dequeued exactly once
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int failureCount = 0;
        for (Integer count : dequeuedItems.values()) {
            if (count != 1) {
                failureCount++;
            }
        }
        System.out.println("Synchronization test failure count: " + failureCount + " on "
                + samples + " samples");
    }

    class DequeueThread extends Thread {
        private Queue<Integer> q = null;
        private int iterations;
        private Map<Integer, Integer> dequeuedItems;

        public DequeueThread(Queue<Integer> q, int iterations, Map<Integer, Integer> dequeuedItems) {
            this.q = q;
            this.iterations = iterations;
            this.dequeuedItems = dequeuedItems;
        }

        @Override
        public void run() {
            for (int i = 0; i < iterations; i++) {
                Integer item = q.dequeue();
                Integer count = (dequeuedItems.get(item) == null) ? 0 : dequeuedItems.get(item);
                count++;
                dequeuedItems.put(item, count);
            }
        }
    }
}
