package at.ac.univie.team17.mariaDB.mariaDBmodelData;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Player;

import java.util.ArrayList;

public class PlayerData
{
    public static ArrayList<Player> getPlayerData()
    {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player(0, "Steven", 18, "Steven@mail.com"));
        players.add(new Player(1, "Sara", 19, "Sara@mail.com"));
        players.add(new Player(2, "Lucy", 20, "Lucy@mail.com"));
        players.add(new Player(3, "Paul", 23, "Paul@mail.com"));
        players.add(new Player(4, "Maria", 25, "Maria@mail.com"));
        players.add(new Player(5, "Michael", 30, "Michael@mail.com"));
        players.add(new Player(6, "Gaius", 45, "Gaius@mail.com"));
        players.add(new Player(7, "xXProXx", 18, "xXProXx@mail.com"));
        players.add(new Player(8, "420Player", 18, "420Player@mail.com"));
        players.add(new Player(9, "Player1", 19, "Player1@mail.com"));
        players.add(new Player(10, "12345", 25, "12345@mail.com"));
        players.add(new Player(11, "Percival98", 21, "Percival98@mail.com"));
        players.add(new Player(12, "9012348", 18, "9012348@mail.com"));
        players.add(new Player(13, "Gollum", 19, "Gollum@mail.com"));
        players.add(new Player(14, "SkyHigh", 20, "SkyHigh@mail.com"));
        players.add(new Player(15, "HAHAHA", 34, "HAHAHA@mail.com"));
        players.add(new Player(16, "NoUser", 39, "NoUser@mail.com"));
        players.add(new Player(17, "Solus", 18, "Solus@mail.com"));
        players.add(new Player(18, "Lith", 26, "Lith@mail.com"));
        players.add(new Player(19, "Torbjörn", 50, "Torbjörn@mail.com"));
        return players;
    }
}
