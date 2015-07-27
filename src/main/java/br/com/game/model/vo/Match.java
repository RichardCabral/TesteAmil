package br.com.game.model.vo;

import java.util.Date;
import java.util.List;

public class Match {
	private long idMath;
	private Date startMatch;
	private List<Player> shootter;
	private List<Player> victim;
	private List<Weapon> weapon;
	private Date endMatch;
	private boolean flagMatch;
	public Date getStartMatch() {
		return startMatch;
	}
	public void setStartMatch(Date startMatch) {
		this.startMatch = startMatch;
	}
	
	public Date getEndMatch() {
		return endMatch;
	}
	public void setEndMatch(Date endMatch) {
		this.endMatch = endMatch;
	}
	public long getIdMath() {
		return idMath;
	}
	public void setIdMath(long idMath) {
		this.idMath = idMath;
	}
	public boolean isFlagMatch() {
		return flagMatch;
	}
	public void setFlagMatch(boolean flagMatch) {
		this.flagMatch = flagMatch;
	}
	public List<Player> getShootter() {
		return shootter;
	}
	public void setShootter(List<Player> shootter) {
		this.shootter = shootter;
	}
	public List<Player> getVictim() {
		return victim;
	}
	public void setVictim(List<Player> victim) {
		this.victim = victim;
	}
	public List<Weapon> getWeapon() {
		return weapon;
	}
	public void setWeapon(List<Weapon> weapon) {
		this.weapon = weapon;
	}

}
