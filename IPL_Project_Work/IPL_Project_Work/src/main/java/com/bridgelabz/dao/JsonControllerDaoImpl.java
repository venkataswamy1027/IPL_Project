package com.bridgelabz.dao;

import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bridgelabz.model.PlayerDto;
import com.bridgelabz.model.TeamDto;
@Repository
public class JsonControllerDaoImpl implements JsonDao {
	@Autowired
	SessionFactory sessionFactory;
	Session session;
	@SuppressWarnings("unchecked")
	public ArrayList<TeamDto>insertTeamDetails(String teaminfo1)
	{
		Long count=0l;
		session = sessionFactory.openSession();
		String hql_query="select count(name) from TeamDto  as o where o.name=?";
		Query query = session.createQuery(hql_query);
		query.setParameter(0, teaminfo1);
		count = (Long)query.uniqueResult();
			if (count!=0) 
			{
				System.out.println("11");
				String hql="from TeamDto as o where o.name=?";
		        query = session.createQuery(hql);
		        query.setParameter(0,teaminfo1);
		        @SuppressWarnings("rawtypes")
				List list1 = query.list();
				if ((list1 != null) && (list1.size() > 0)) 
				{
					return (ArrayList<TeamDto>) list1;
					
				}
			}//end of if
			else
			{
				System.out.println("12");
				ArrayList<TeamDto> playerList = new ArrayList<TeamDto>();
				JSONParser parser = new JSONParser();
				try {
					//read JSON file data  from local repository
					FileReader fileread = new FileReader("/home/bridgeit/venky files/IPL_Project_Work/IPL_Project_Work/src/main/jsonfile/IPLIndividualTeamInfo/"+teaminfo1+".json");
		
					Object obj = parser.parse(fileread);
					JSONArray array = (JSONArray) obj;
		
					for (int i = 0; i < array.size(); i++) {
						JSONObject jsonObject = (JSONObject) array.get(i);
						@SuppressWarnings("unused")
						String name = jsonObject.get("Name").toString();
						JSONArray jsonArray = (JSONArray) jsonObject.get(teaminfo1);
						for (int j = 0; j < jsonArray.size(); j++) {
							TeamDto team = new TeamDto();
							JSONObject jsonObjectArray = (JSONObject) jsonArray.get(j);
							team.setName(jsonObjectArray.get("team_name").toString());
							team.setCouch(jsonObjectArray.get("team_coach").toString());
							team.setCaptain(jsonObjectArray.get("team_captain").toString());
							team.setVeneue(jsonObjectArray.get("team_home_venue").toString());
							team.setOwner(jsonObjectArray.get("team_owner").toString());
							playerList.add(team);
					 		session = sessionFactory.openSession();
					 		Transaction tx = session.beginTransaction();
				            session.save(team);
				            tx.commit();
						}
					}
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
				System.out.println("13");
				String hql="from TeamDto as o where o.name=?";
		        Query queri = session.createQuery(hql);
		        queri.setParameter(0, teaminfo1);
		        @SuppressWarnings("rawtypes")
				List list = queri.list();
				if ((list != null) && (list.size() > 0)) 
				{
					System.out.println("14");
					return (ArrayList<TeamDto>)list;
					
				}
				session.close();
				System.out.println("15");
				}
			return null;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<PlayerDto> insertPlayerDetails(String teamname1)
	{
		System.out.println("player team name 2 :"+teamname1);
		Long count=0l;
		session = sessionFactory.openSession();
		String hql_query="select count(teamname) from PlayerDto  as o where o.teamname=?";
		Query query = session.createQuery(hql_query);
		query.setParameter(0, teamname1);
		count = (Long)query.uniqueResult();
			if (count!=0) 
			{
				System.out.println("1");
				String hql="from PlayerDto as o where o.teamname=?";
		        query = session.createQuery(hql);
		        query.setParameter(0,teamname1);
		        @SuppressWarnings("rawtypes")
				List list1 = query.list();
				if ((list1 != null) && (list1.size() > 0)) 
				{
					return (ArrayList<PlayerDto>) list1;
					
				}
			}
		else
		{
			System.out.println("2");
			ArrayList<PlayerDto> playerList=new ArrayList<PlayerDto>();
			PlayerDto player=new PlayerDto();
	        JSONParser parser= new JSONParser();
	        try {
        	//read JSON file data  from local repository
        	FileReader fr = new FileReader("/home/bridgeit/venky files/IPL_Project_Work/IPL_Project_Work/src/main/jsonfile/IPLPlayer/"+teamname1+".json");
        	Object obj=parser.parse(fr);
        	JSONArray array =(JSONArray)obj;
        	for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject=(JSONObject)array.get(i);
				jsonObject.get("Name").toString();
				JSONArray jsonArray=(JSONArray)jsonObject.get(teamname1);
				for (int j = 0; j < jsonArray.size(); j++) {
					JSONObject jsonObjectArray=(JSONObject)jsonArray.get(j);
					player.setName(jsonObjectArray.get("player_name").toString());
					player.setRole(jsonObjectArray.get("player_role").toString());
					player.setBatting(jsonObjectArray.get("player_batting_style").toString());
					player.setBowler(jsonObjectArray.get("player_bowling_style").toString());
					player.setNation(jsonObjectArray.get("player_nationality").toString());
					player.setDob(stringToDate(jsonObjectArray.get("player_dob").toString()));
					player.setTeamname(jsonObjectArray.get("player_team_name").toString());
					playerList.add(player);
					//JSON data inserted into data base
				 	session = sessionFactory.openSession();
				 	Transaction tx1 = session.beginTransaction();
			        session.save(player);
			        tx1.commit();
				}
        	}
        	}catch (Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("3");
			String hql="from PlayerDto as o where o.teamname=?";
	        query = session.createQuery(hql);
	        query.setParameter(0, teamname1);
			@SuppressWarnings("rawtypes")
			List list1 = query.list();
	        System.out.println("list is :"+list1);
			if ((list1 != null) && (list1.size() > 0)) 
			{
				System.out.println("4");
				return (ArrayList<PlayerDto>) list1;
				
			}
			session.close();
			System.out.println("5");
			}
			return null;
	}
	/*converting JSON String data to date format of data */
	public Date stringToDate(String abc){
		DateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
		try {
			return formatter.parse(abc);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/* sort player information in ascending or descending order */
	public ArrayList<?> sort_Player_Info( String sort_field,String sort_order) {
		System.out.println(sort_field);
		System.out.println(sort_order);
		new PlayerDto();
		Session session = sessionFactory.openSession();
		String SQL_QUERY ="from PlayerDto ORDER BY "+sort_field+" "+sort_order;
		Query query = session.createQuery(SQL_QUERY);
		System.out.println("sort Query executing :"+query);
		 List<?> list = query.list();
			System.out.println("sort list is :"+list);
			if ((list != null) && (list.size() > 0)) 
			{
			}
			session.close();
			return (ArrayList<?>) list;
	}
	/*search information implementation */
	public ArrayList<?> search_Info(String search_field,String search_item){
		new PlayerDto();
		Session session = sessionFactory.openSession();
		boolean listFound = false;
		if((search_field==null)||(search_item==null))
		{
			return null;
		}
		else
		{
		String SQL_QUERY =" from PlayerDto as o where o."+search_field+" LIKE "+"'%"+search_item+"%'";
		Query query = session.createQuery(SQL_QUERY);
		System.out.println(" search Query executing :"+query);
        List<?> list = query.list();
		System.out.println("list is :"+list);
		
		if ((list != null) && (list.size() > 0)) 
		{
			
			listFound= true;
			System.out.println(listFound);
		}
		session.close();
		return (ArrayList<?>) list;
		}
	}
	/* this method take from url of all team info and player info match */
	public ArrayList<?> player_Info(String teamname) 
	{
		System.out.println("player team name 1 :"+teamname);
		return insertPlayerDetails(teamname);
	}
	public ArrayList<?> team_Info(String teamname) {
		System.out.println("team name :"+teamname);
		return insertTeamDetails(teamname);
	}
}