package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String playerName;
	private String teamName;
	private int age;
	
	public Player() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", playerName=" + playerName + ", teamName=" + teamName + ", age=" + age + "]";
	}

	public Player(int id, String playerName, String teamName, int age) {
		super();
		this.id = id;
		this.playerName = playerName;
		this.teamName = teamName;
		this.age = age;
	}

	public Player(String playerName, String teamName, int age) {
		super();
		this.playerName = playerName;
		this.teamName = teamName;
		this.age = age;
	}
	
	

}
