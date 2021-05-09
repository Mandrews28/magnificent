package mandrews.magnificent.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

public class Shuffle {
    private static SecureRandom rand;

    static {
        try {
            rand = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<String> playerOrder(List<String> players) {
        for (int i = players.size() - 1; i > 0; i--) {
            int index = rand.nextInt(i);
            String tmp = players.get(index);
            players.set(index, players.get(i));
            players.set(i, tmp);
        }
        return players;
    }
}
