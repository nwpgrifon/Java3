package lesson4;

/*
1. Создать три потока, каждый из которых
выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
Используйте wait/notify/notifyAll.
*/

public class Test {

    public static void main(String[] args) throws InterruptedException {

        Resource resource = new Resource();

        resource.str = "";

        Thread A = new Thread(() -> {
            synchronized (resource) {
                for (int i = 0; i < 5; i++) {
                    while (!resource.str.isEmpty() && !resource.str.endsWith("C")) {
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    resource.str = resource.str.concat("A");
                    resource.notifyAll();
                }
            }
        });
        Thread B = new Thread(() -> {
            synchronized (resource) {
                for (int i = 0; i < 5; i++) {
                    while (!resource.str.endsWith("A")) {
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    resource.str = resource.str.concat("B");
                    resource.notifyAll();
                }
            }
        });
        Thread C = new Thread(() -> {
            synchronized (resource) {
                for (int i = 0; i < 5; i++) {
                    while (!resource.str.endsWith("B")) {
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    resource.str = resource.str.concat("C");
                    resource.notifyAll();
                }

            }
        });

        A.start();
        B.start();
        C.start();

        A.join();
        B.join();
        C.join();

        System.out.println(resource.str);

    }

}
