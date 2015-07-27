package br.com.game.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.game.controller.RankController;
import br.com.game.model.vo.Match;
import br.com.game.model.vo.Player;
import br.com.game.model.vo.Rank;

public class RankAction {

	public static void main(String args[]) {
		RankController controller = new RankController();
		Rank rank = controller.gerarRank();
		Map<String, Integer> mapKiller = new HashMap<String, Integer>();
		Map<String, Integer> mapDied = new HashMap<String, Integer>();
		List<Player> listShooter = null;
		List<Player> listDied = null;

		for (Match match : rank.getListMatch()) {
			System.out.println(match.getStartMatch());
			System.out.println("ID da Partida: " + match.getIdMath());
			listShooter = new ArrayList<Player>(new HashSet<Player>(
					match.getShootter()));
			for (Player shootter : listShooter) {
				mapKiller.put(shootter.getNamePlayer(), Collections.frequency(
						converteInArrayString(match.getShootter()),
						shootter.getNamePlayer()));
			}
			listDied = new ArrayList<Player>(new HashSet<Player>(
					match.getVictim()));
			for (Player victim : listDied) {
				mapDied.put(victim.getNamePlayer(), Collections.frequency(
						converteInArrayString(match.getVictim()),
						victim.getNamePlayer()));
			}
			 System.out.println("Rank de Matadores:");
			Set<String> keys = mapKiller.keySet();
			List<Player> rankKiller = new ArrayList<Player>();
			Player play = null;
			for (final String key : keys) {
				play = new Player();
				play.setNamePlayer(key);
				play.setKilled(mapKiller.get(key));
			    System.out.println(key + " - " + mapKiller.get(key));
				rankKiller.add(play);

			}
					
			List<Player> rankDied = new ArrayList<Player>();
			System.out.println("Rank dos mais mortos:");
			Set<String> keys2 = mapDied.keySet();
			for (final String key : keys2) {
				play = new Player();
				play.setNamePlayer(key);
				play.setDied(mapDied.get(key));
				System.out.println(key + " - " + mapDied.get(key));
				rankDied.add(play);
			}
		
			System.out.println("encerrada a Partida: " + match.getEndMatch());
		}

	}

	public static List<String> converteInArrayString(List<Player> players) {
		List<String> lista = new ArrayList<String>();
		for (Player player : players) {
			lista.add(player.getNamePlayer());
		}
		return lista;

	}

}
