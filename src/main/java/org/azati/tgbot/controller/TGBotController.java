package org.azati.tgbot.controller;

import lombok.AllArgsConstructor;
import org.azati.tgbot.service.TGBotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TGBotController {

    private TGBotService tgBotService;

    /**
     * Send message from bot to user/group with given chatId
     * @param chatId - chat id of receiver
     * @param message - message
     */
    @GetMapping("/send")
    public ResponseEntity<Void> sendMessage(
        @RequestParam(name = "c") Long chatId,
        @RequestParam(name = "m") String message
    ) {
        if (tgBotService.sendMessage(chatId, message)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }
}
