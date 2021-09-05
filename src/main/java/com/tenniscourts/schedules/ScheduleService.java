package com.tenniscourts.schedules;

import com.tenniscourts.tenniscourts.TennisCourtDTO;
import com.tenniscourts.tenniscourts.TennisCourtMapper;
import com.tenniscourts.tenniscourts.TennisCourtService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    private final ScheduleMapper scheduleMapper;

    public ScheduleDTO addSchedule(Long tennisCourtId, CreateScheduleRequestDTO createScheduleRequestDTO) {
        ScheduleDTO scheduleDTO = scheduleMapper.map(createScheduleRequestDTO);
        scheduleDTO.setTennisCourt(findSchedulesByTennisCourtId(tennisCourtId).get(0).getTennisCourt());
        return addTennisCourtSchedule(scheduleDTO);
    }

    public List<ScheduleDTO> findSchedulesByDates(LocalDateTime startDate, LocalDateTime endDate) {
        //TODO: implement
        List<ScheduleDTO> scheduleDTOList = scheduleMapper.map(scheduleRepository.findByStartDateTimeAndEndDateTime(startDate,endDate));
        return scheduleDTOList;
        //return null;
    }

    public ScheduleDTO findSchedule(Long scheduleId) {
        return scheduleMapper.map(scheduleRepository.findScheduleById(scheduleId));
    }

    public List<ScheduleDTO> findSchedulesByTennisCourtId(Long tennisCourtId) {
        return scheduleMapper.map(scheduleRepository.findByTennisCourt_IdOrderByStartDateTime(tennisCourtId));
    }

    public ScheduleDTO addTennisCourtSchedule(ScheduleDTO scheduleDTO) {
        return scheduleMapper.map(scheduleRepository.saveAndFlush(scheduleMapper.map(scheduleDTO)));
    }
}
