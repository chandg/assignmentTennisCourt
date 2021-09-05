package com.tenniscourts.reservations;

import com.tenniscourts.config.BaseRestController;
import com.tenniscourts.schedules.ScheduleDTO;
import com.tenniscourts.tenniscourts.TennisCourtDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/ReservationController/")
public class ReservationController extends BaseRestController {

    private final ReservationService reservationService;

    @RequestMapping(value="/bookReservation", method = RequestMethod.POST,
                     produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
                     consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReservationDTO> bookReservation(@RequestBody CreateReservationRequestDTO createReservationRequestDTO) {
        return new ResponseEntity<ReservationDTO>(reservationService.bookReservation(createReservationRequestDTO), HttpStatus.CREATED);

    }

    @GetMapping(value="/findReservation")
    public ResponseEntity<ReservationDTO> findReservation(Long reservationId) {
        return ResponseEntity.ok(reservationService.findReservation(reservationId));
    }

    @PutMapping(value="/cancelReservation")
    public ResponseEntity<ReservationDTO> cancelReservation(Long reservationId) {
        return ResponseEntity.ok(reservationService.cancelReservation(reservationId));
    }

    @PutMapping(value="/rescheduleReservation")
    public ResponseEntity<ReservationDTO> rescheduleReservation(Long reservationId, Long scheduleId) {
        return ResponseEntity.ok(reservationService.rescheduleReservation(reservationId, scheduleId));
    }
}
