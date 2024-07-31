package in.co.greenwave.brandschedule.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.co.greenwave.brandschedule.entity.Schedule;

@Repository
public class BrandScheduleRepositoryService {

	@Autowired
	@Qualifier("SqlServer")
	JdbcTemplate jdbcTemplate;

	@Autowired
	BrandScheduleRepository brandScheduleRepository;

	public Schedule getBrandScheduleByMachineId(String machineId) {

		String query = "SELECT TOP (1) [UserId] ,[BrandScheduleId] ,[Machine] ,[ProductionType] ,[Brand] ,[BrandSapCode] ,[StartDate] ,[Output] ,[Active] FROM [dbo].[BrandSchedule] WHERE [Active]=1 and [Machine]=? order by [StartDate] desc";

		List<Schedule> brandScheduleList = jdbcTemplate.query(query,
				new BeanPropertyRowMapper<Schedule>(Schedule.class), machineId);

		Schedule brandSchedule = null;

		if (brandScheduleList != null && !brandScheduleList.isEmpty()) {

			brandSchedule = brandScheduleList.get(0);

		}

		return brandSchedule;

	}

	public Schedule saveSchedule(Schedule schedule) {

		Schedule savedSchedule = brandScheduleRepository.save(schedule);

		return savedSchedule;
	}

	
	
	public boolean updateSchedule(Schedule schedule) {

		try {
			
			saveSchedule(schedule);

			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return false;
		}
	}
	
	
	public Map<String,Object> getMachineNameByCategoryAndNumber(String machineCategory, String makerNumber){
		
		String query = "SELECT [MachineName],[MachineId] FROM (SELECT ROW_NUMBER() over (order by [MachineId]) [MachineNumber],[MachineName],[MachineId] FROM [dbo].[MachineMaster] WHERE [Active]=1 and [Category]=?) m WHERE [MachineNumber]=?";
		
		 Map<String, Object> map = jdbcTemplate.queryForMap(query);
		
		 return map;
	}
	
	
	public Map<String,Object> interlockEnabledStatus(String interlock){
		
		String query = "SELECT [Enabled] FROM [dbo].[InterlockMaster] WHERE [Active]=1 and [Interlock]=?";
		
		List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(query,interlock); 
		
		
		Map<String, Object> map = null;
		
		if(queryForList != null && !queryForList.isEmpty()) {
			
				 map = queryForList.get(0); 
				 
		}
		
		System.out.println(map.getClass().getSimpleName());
		
		return map;
		
	}
	
	
	
}
