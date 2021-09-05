package com.tenniscourts.schedules;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
    ScheduleMapper INSTANCE= Mappers.getMapper(ScheduleMapper.class);
    Schedule map(ScheduleDTO source);

    ScheduleDTO map(Schedule source);

    ScheduleDTO map(CreateScheduleRequestDTO source);


    List<ScheduleDTO> map(List<Schedule> source);
}
