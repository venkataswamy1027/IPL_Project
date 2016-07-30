package com.bridgelabz.dao;
import java.util.ArrayList;
public interface JsonDao 
{
		/*public ArrayList<?> delhiDareDevilsTeamList();
		public ArrayList<?> delhiDareDevilsPlayerList();
		public ArrayList<?> gujratTeam();
		public ArrayList<?> gujratPlayerList();
		public ArrayList<?> punjabTeam();
		public ArrayList<?> punjabPlayerList();
		public ArrayList<?> kkrTeam();
		public ArrayList<?> kkrPlayerList();
		public ArrayList<?> mumbaiIndiansTeam();
		public ArrayList<?> mumbaiPlayerList();
		public ArrayList<?> risingPuneTeam();
		public ArrayList<?> risingPunePlayerList();
		public ArrayList<?> royalChallengesTeam();
		public ArrayList<?> royalChallengesPlayerList();
		public ArrayList<?> sunriseHydrabadTeam();
		public ArrayList<?> sunriseHydrabadPlayerList();*/
		public ArrayList<?> sort_Player_Info(String sort_field,String sort_order);
		public ArrayList<?> search_Info(String search_field, String search_item);
		public ArrayList<?> player_Info(String teamname);
		public ArrayList<?> team_Info(String teamname);
}
