package com.bridgelabz.dao;
import java.util.ArrayList;
public interface JsonDao 
{
	public ArrayList<?> sort_Player_Info(String sort_field,String sort_order);
	public ArrayList<?> search_Info(String search_field, String search_item);
	public ArrayList<?> player_Info(String teamname);
	public ArrayList<?> team_Info(String teamname);
}
