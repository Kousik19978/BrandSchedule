package in.co.greenwave.brandschedule.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import in.co.greenwave.brandschedule.entity.Schedule;

public interface BrandScheduleService {

		ResponseEntity<Schedule> getBrandSchedulesByMachineId(String machineId);

		ResponseEntity<Schedule> saveSchedule(Schedule schedule);
	
		ResponseEntity<Boolean> updateSchedule(Schedule schedule);

		ResponseEntity<Map<String, Object>> getMachineNameByCategoryAndNumber(String machineCategory,
				String makerNumber);

		ResponseEntity<Map<String, Object>> interlockEnabledStatus(String interlock);
		
		
}	
