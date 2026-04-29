package es.enyavi.kash.web.controller;

import es.enyavi.kash.application.service.CategoryService;
import es.enyavi.kash.application.service.EnvelopeService;
import es.enyavi.kash.application.service.MovementService;
import es.enyavi.kash.domain.model.*;
import es.enyavi.kash.web.dto.ExpenseRequestDTO;
import es.enyavi.kash.web.dto.WithdrawalRequestDTO;
import es.enyavi.kash.web.dto.TransferRequestDTO;
import es.enyavi.kash.web.dto.EnvelopeLoadRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movements")
@RequiredArgsConstructor
public class MovementController {

    private final MovementService movementService;
    private final EnvelopeService envelopeService;
    private final CategoryService categoryService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("envelopes", envelopeService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "movements/list";
    }

    @GetMapping("/new/expense")
    public String newExpenseForm(Model model) {
        model.addAttribute("envelopes", envelopeService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("dto", new ExpenseRequestDTO());
        return "movements/expense-form";
    }

    @PostMapping("/new/expense")
    public String saveExpense(@ModelAttribute ExpenseRequestDTO dto) {
        Envelope envelope = envelopeService.findById(dto.getEnvelopeId());
        Category category = categoryService.findById(dto.getCategoryId());
        Expense expense = new Expense(null, dto.getDate(), dto.getAmount(),
                dto.getDescription(), envelope, category);
        movementService.registerExpense(expense);
        return "redirect:/movements";
    }

    @GetMapping("/new/withdrawal")
    public String newWithdrawalForm(Model model) {
        model.addAttribute("envelopes", envelopeService.findAll());
        model.addAttribute("dto", new WithdrawalRequestDTO());
        return "movements/withdrawal-form";
    }

    @PostMapping("/new/withdrawal")
    public String saveWithdrawal(@ModelAttribute WithdrawalRequestDTO dto) {
        Envelope envelope = envelopeService.findById(dto.getEnvelopeId());
        Withdrawal withdrawal = new Withdrawal(null, dto.getDate(), dto.getAmount(),
                dto.getDescription(), envelope, dto.isDirectExpense(), null);
        movementService.registerWithdrawal(withdrawal);
        return "redirect:/movements";
    }

    @GetMapping("/new/transfer")
    public String newTransferForm(Model model) {
        model.addAttribute("envelopes", envelopeService.findAll());
        model.addAttribute("bankAccounts", BankAccount.values());
        model.addAttribute("dto", new TransferRequestDTO());
        return "movements/transfer-form";
    }

    @PostMapping("/new/transfer")
    public String saveTransfer(@ModelAttribute TransferRequestDTO dto) {
        Envelope origin = envelopeService.findById(dto.getEnvelopeId());
        Envelope destinationEnvelope = dto.getDestinationEnvelopeId() != null
                ? envelopeService.findById(dto.getDestinationEnvelopeId()) : null;
        Transfer transfer = new Transfer(null, dto.getDate(), dto.getAmount(),
                dto.getDescription(), origin, dto.getDestinationBank(), destinationEnvelope);
        movementService.registerTransfer(transfer);
        return "redirect:/movements";
    }
}