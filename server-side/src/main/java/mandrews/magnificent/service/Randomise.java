package mandrews.magnificent.service;

import liquibase.pro.packaged.T;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Randomise {
    private static SecureRandom rand;

    static {
        try {
            rand = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
    }

    public static <T> List<T> randomiseObjectOrder(List<T> objects) {
        for (int i = objects.size() - 1; i > 0; i--) {
            int index = rand.nextInt(i);
            T tmp = objects.get(index);
            objects.set(index, objects.get(i));
            objects.set(i, tmp);
        }
        return objects;
    }

    public static <T> List<T> randomlyChooseSubset(List<T> objects, int limit) {
        List<T> subset = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            int index = rand.nextInt(objects.size());
            subset.add(objects.get(index));
            objects.remove(index);
        }
        return subset;
    }
}
