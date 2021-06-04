package at.ac.univie.team17.mariaDB.mariaDBmodelData;

import at.ac.univie.team17.mariaDB.mariaDBmodels.Player;

import java.util.ArrayList;

public class PlayerData
{
    public static ArrayList<Player> getPlayerData()
    {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player(0, "Steven", "Steven@mail.com"));
        players.add(new Player(1, "Sara", "Sara@mail.com"));
        players.add(new Player(2, "Lucy", "Lucy@mail.com"));
        players.add(new Player(3, "Paul", "Paul@mail.com"));
        players.add(new Player(4, "Maria", "Maria@mail.com"));
        players.add(new Player(5, "Michael", "Michael@mail.com"));
        players.add(new Player(6, "Gaius", "Gaius@mail.com"));
        players.add(new Player(7, "xXProXx", "xXProXx@mail.com"));
        players.add(new Player(8, "420Player", "420Player@mail.com"));
        players.add(new Player(9, "Player1", "Player1@mail.com"));
        players.add(new Player(10, "12345", "12345@mail.com"));
        players.add(new Player(11, "Percival98", "Percival98@mail.com"));
        players.add(new Player(12, "9012348", "9012348@mail.com"));
        players.add(new Player(13, "Gollum", "Gollum@mail.com"));
        players.add(new Player(14, "SkyHigh", "SkyHigh@mail.com"));
        players.add(new Player(15, "HAHAHA", "HAHAHA@mail.com"));
        players.add(new Player(16, "NoUser", "NoUser@mail.com"));
        players.add(new Player(17, "Solus", "Solus@mail.com"));
        players.add(new Player(18, "Lith", "Lith@mail.com"));
        players.add(new Player(19, "Torbjörn", "Torbjörn@mail.com"));
        return players;
    }
}
