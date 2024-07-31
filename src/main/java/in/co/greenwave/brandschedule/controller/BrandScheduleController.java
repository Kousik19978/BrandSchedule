package in.co.greenwave.brandschedule.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.co.greenwave.brandschedule.entity.Schedule;
import in.co.greenwave.brandschedule.service.BrandScheduleService;


@RestController
@RequestMapping("/brandschedule")
public class BrandScheduleController {
	
	@Autowired
	BrandScheduleService brandScheduleService;
	
	@GetMapping("/test")
	public String test() {
		
		return "test";
	}
	
	@GetMapping("/schedules")
	public ResponseEntity<Schedule> getBrandSchedulesByMachineId(@RequestParam String machineId){
		
		ResponseEntity<Schedule> brandSchedulesByMachineId = brandScheduleService.getBrandSchedulesByMachineId(machineId);
		
		return brandSchedulesByMachineId;
	}
	
	
	@PostMapping("/saveSchedule")
	public ResponseEntity<Schedule> saveSchedule(@RequestBody Schedule schedule){
		
		ResponseEntity<Schedule> saveSchedule = brandScheduleService.saveSchedule(schedule);
		
		return saveSchedule;
	}
	
	
	@PutMapping("/updateSchedule")
	ResponseEntity<Boolean> updateSchedule(@RequestBody Schedule schedule){
		
		ResponseEntity<Boolean> updateSchedule = brandScheduleService.updateSchedule(schedule);
		
		return updateSchedule;
	}
	
	
	@GetMapping("/getmachinenamebycategoryandnumber")
	public ResponseEntity<Map<String,Object>> getMachineNameByCategoryAndNumber(@RequestParam String machineCategory,@RequestParam String makerNumber){
		
		ResponseEntity<Map<String, Object>> machineNameByCategoryAndNumber = brandScheduleService.getMachineNameByCategoryAndNumber(machineCategory, makerNumber);
		
		return machineNameByCategoryAndNumber;
	}

	
	
	@GetMapping("/interlock")
	ResponseEntity<Map<String, Object>> interlockEnabledStatus(@RequestParam String interlock){
		
		ResponseEntity<Map<String, Object>> interlockEnabledStatus = brandScheduleService.interlockEnabledStatus(interlock);
		
		return interlockEnabledStatus;
	}
	
}
