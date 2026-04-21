//package com.edu.Institiute.api;
//
//import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
//import com.edu.Institiute.dto.responseDto.CommonResponseDto;
//import com.edu.Institiute.service.PaymentService;
//import com.edu.Institiute.utill.StandardResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin(origins = "http://localhost:4200/")
//@RestController
//@RequestMapping("/api/v1/payment")
//public class PaymentController {
//    @Autowired
//    private PaymentService paymentService;
//
//    @CrossOrigin(origins = "http://localhost:4200/")
//    @PostMapping
//    public ResponseEntity<StandardResponse> savePayment(@RequestBody RequestRegistryDto data){
//        CommonResponseDto commonResponseDto = paymentService.savePayment(data);
//        return new ResponseEntity<>(
//                new StandardResponse(
//                        commonResponseDto.getCode(),
//                        commonResponseDto.getMessage(),
//                        commonResponseDto.getData()
//                ),
//                HttpStatus.CREATED
//        );
//    }
//}
