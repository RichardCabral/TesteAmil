package br.com.game.model.vo;

public class Player {
	private long idPlayer;
	private String namePlayer;
	private int killed;
	private int died;
	public long getIdPlayer() {
		return idPlayer;
	}
	public void setIdPlayer(long idPlayer) {
		this.idPlayer = idPlayer;
	}
	public String getNamePlayer() {
		return namePlayer;
	}
	public void setNamePlayer(String namePlayer) {
		this.namePlayer = namePlayer;
	}
	public int getKilled() {
		return killed;
	}
	public void setKilled(int killed) {
		this.killed = killed;
	}
	public int getDied() {
		return died;
	}
	public void setDied(int died) {
		this.died = died;
	}

}
