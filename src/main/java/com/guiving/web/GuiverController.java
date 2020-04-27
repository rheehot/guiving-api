package com.guiving.web;

import com.guiving.domain.vo.enums.JoinType;
import com.guiving.service.GuiverService;
import com.guiving.service.UserService;
import com.guiving.web.dto.guiver.GuiverSaveRequestDto;
import com.guiving.web.dto.user.UserSaveRequestDto;
import com.guiving.web.dto.user.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GuiverController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final GuiverService guiverService;

    @PostMapping("/api/v1/guiver")
    public ResponseEntity<?> save(JoinType request) throws Exception {
        logger.debug("requestdto  : "  + request);
        ResponseEntity<?> result;
        try {
            //Long id = guiverService.save(request);
            result = new ResponseEntity<>(HttpStatus.OK) ;
        }
        catch(Exception e) {
            e.printStackTrace();
            result = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST) ;
        }
        return result;
    }

}
