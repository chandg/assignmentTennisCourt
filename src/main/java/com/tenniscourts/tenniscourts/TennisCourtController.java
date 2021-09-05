package com.tenniscourts.tenniscourts;

import com.tenniscourts.config.BaseRestController;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tennisCourt/")
public class TennisCourtController extends BaseRestController {

    private final TennisCourtService tennisCourtService;

    @RequestMapping(value="/addTennisCourt", method = RequestMethod.POST,produces = MimeTypeUtils.APPLICATION_JSON_VALUE, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<TennisCourtDTO> addTennisCourt( @RequestBody TennisCourtDTO tennisCourtDTO) {
        return new ResponseEntity<TennisCourtDTO>(tennisCourtService.addTennisCourt(tennisCourtDTO),HttpStatus.CREATED);
    }

    @GetMapping(value="/findTennisCourtById")
    public ResponseEntity<TennisCourtDTO> findTennisCourtById(Long tennisCourtId) {
        return ResponseEntity.ok(tennisCourtService.findTennisCourtById(tennisCourtId));
    }

    @GetMapping(value="/findTennisCourtWithSchedulesById")
    public ResponseEntity<TennisCourtDTO> findTennisCourtWithSchedulesById(Long tennisCourtId) {
        return ResponseEntity.ok(tennisCourtService.findTennisCourtWithSchedulesById(tennisCourtId));
    }
}
