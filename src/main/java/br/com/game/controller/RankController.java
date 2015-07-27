package br.com.game.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.game.model.vo.Match;
import br.com.game.model.vo.Player;
import br.com.game.model.vo.Rank;
import br.com.game.model.vo.Weapon;
import br.com.game.util.Constants;

public class RankController {
	public Match match;
	public List<Player> playersShooters;
	public List<Player> playersDieds;
	public List<Weapon> weapons;
	public List<Match> matchs;
	
	
	public Rank gerarRank() {

		Scanner scanner = new Scanner(System.in);
		System.out.printf("Informe o caminho do Arquivo de Log:\n");
		String nome = scanner.nextLine();
		Player playerKiller = null;
		Player playerDied = null;
		Weapon weaponType = null;
		String killer = null;
		String[] died = null; 
		
		try {
			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha ;
			String[] array = null;
			match = null;
			String[] arrayKiller = null;
			matchs = new ArrayList<Match>();
			Rank rank = new Rank();
			do {
				linha = lerArq.readLine();
				if(linha==(null)){
					break;
				}
			
				array = linha.split(Constants.DELIMITERS);
				SimpleDateFormat formata = new SimpleDateFormat(Constants.MASK_DATE_TIME);
				String dataHora = array[0].trim();
				Date data = null;
				
				try {
					data = formata.parse(dataHora);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if(array[1].contains(Constants.NEW_MATCH)&&array[1].contains(Constants.HAS_STARTED)){
					
					match = new Match();
					match.setStartMatch(data);
					match.setIdMath(Long.parseLong((array[1].substring(10, array[1].indexOf(Constants.HAS_STARTED)).trim())));
					playersShooters = new ArrayList<Player>();
					playersDieds = new ArrayList<Player>();
					weapons = new ArrayList<Weapon>();
				}else if (array[1].contains(Constants.MATCH)&&array[1].contains(Constants.HAS_ENDED)){
					
					match.setWeapon(weapons);
					match.setShootter(playersShooters);
					match.setVictim(playersDieds);
					match.setEndMatch(data);
					matchs.add(match);
					rank.setListMatch(matchs);
				}else{
					
					arrayKiller = array[1].split(Constants.KILLED);
					killer = arrayKiller[0];
					if(arrayKiller[1].contains(Constants.KEY_USING)){
						died = arrayKiller[1].split(Constants.KEY_USING);
					}else if(arrayKiller[1].contains(Constants.KEY_BY)){
						died = arrayKiller[1].split(Constants.KEY_BY);
					}
					if(killer.contains(Constants.WORLD)){
						playerDied = new Player();
						playerDied.setNamePlayer(died[0].trim());
						playersDieds.add(playerDied);
					}else{
						
						playerKiller = new Player();
						playerKiller.setNamePlayer(killer.trim());
						playerDied = new Player();
						playerDied.setNamePlayer(died[0].trim());
						playersShooters.add(playerKiller);
						playersDieds.add(playerDied);
					}
					weaponType = new Weapon();
					weaponType.setNameWeapon(died[1].trim());
					weapons.add(weaponType);
				}
			}while (linha != null);
			arq.close();
			return rank;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
