package in.co.greenwave.brandschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.co.greenwave.brandschedule.entity.Schedule;

public interface BrandScheduleRepository extends JpaRepository<Schedule,String>{

		
}
