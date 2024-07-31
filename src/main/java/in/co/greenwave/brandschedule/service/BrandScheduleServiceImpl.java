package in.co.greenwave.brandschedule.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.co.greenwave.brandschedule.entity.Schedule;
import in.co.greenwave.brandschedule.repository.BrandScheduleRepositoryService;

@Service
public class BrandScheduleServiceImpl implements BrandScheduleService{

	@Autowired
	BrandScheduleRepositoryService brandScheduleRepositoryService;
	
	@Override
	public ResponseEntity<Schedule> getBrandSchedulesByMachineId(String machineId) {
		
		ResponseEntity<Schedule> responseEntity = null;
		
		try {
			
			Schedule brandScheduleByMachineId = brandScheduleRepositoryService.getBrandScheduleByMachineId(machineId);
			
			responseEntity =  ResponseEntity.ok(brandScheduleByMachineId);
			
		} catch (Exception e) {

			e.printStackTrace();
			
			responseEntity = ResponseEntity.internalServerError().build();
		}
		
		return responseEntity;
	}

	@Override
	public ResponseEntity<Schedule> saveSchedule(Schedule schedule){
		
			ResponseEntity<Schedule> responseEntity = null;
		
			try {
				
				Schedule savedSchedule = brandScheduleRepositoryService.saveSchedule(schedule);
				
				responseEntity = ResponseEntity.ok(savedSchedule);
				
			} catch (Exception e) {
			
				e.printStackTrace();
				
				responseEntity = ResponseEntity.internalServerError().build();
			}
			
			return responseEntity;
	}

	@Override
	public ResponseEntity<Boolean> updateSchedule(Schedule schedule) {
		
		ResponseEntity<Boolean> responseEntity = null;

		
		try {
			
			boolean updated = brandScheduleRepositoryService.updateSchedule(schedule);
			
			responseEntity = ResponseEntity.ok(updated);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			responseEntity = ResponseEntity.internalServerError().build();
		}
		
		return responseEntity;
	}
	
	
	@Override
	public ResponseEntity<Map<String,Object>> getMachineNameByCategoryAndNumber(String machineCategory, String makerNumber){
		
			ResponseEntity<Map<String,Object>> responseEntity = null;
		
			try {
				
				Map<String, Object> machineNameByCategoryAndNumber = brandScheduleRepositoryService.getMachineNameByCategoryAndNumber(machineCategory, makerNumber);
				
				responseEntity = ResponseEntity.ok(machineNameByCategoryAndNumber);
				
			} catch (Exception e) {
			
				e.printStackTrace();
				
				responseEntity = ResponseEntity.internalServerError().build();
			}
			
			return responseEntity;
	}

	
	@Override
	public ResponseEntity<Map<String,Object>> interlockEnabledStatus(String interlock){
		
			ResponseEntity<Map<String,Object>> responseEntity = null;
		
			try {
				
				Map<String, Object> interlockEnabledStatus = brandScheduleRepositoryService.interlockEnabledStatus(interlock);
				
				responseEntity = ResponseEntity.ok(interlockEnabledStatus);
				
			} catch (Exception e) {

				e.printStackTrace();
				
				responseEntity = ResponseEntity.internalServerError().build();
			}
			
			return responseEntity;
	}
}
