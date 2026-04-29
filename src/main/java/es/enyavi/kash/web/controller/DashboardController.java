package es.enyavi.kash.web.controller;

import es.enyavi.kash.application.service.EnvelopeService;
import es.enyavi.kash.application.service.MovementService;
import es.enyavi.kash.domain.model.EnvelopeType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    private final EnvelopeService envelopeService;
    private final MovementService movementService;

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("envelopes", envelopeService.findAll());
        model.addAttribute("personalEnvelope", envelopeService.findByType(EnvelopeType.PERSONAL));
        model.addAttribute("sharedEnvelope", envelopeService.findByType(EnvelopeType.SHARED));
        model.addAttribute("recentExpenses", movementService.findExpensesByDateBetween(
                LocalDate.now().minusDays(30), LocalDate.now()));
        return "dashboard";
    }
}