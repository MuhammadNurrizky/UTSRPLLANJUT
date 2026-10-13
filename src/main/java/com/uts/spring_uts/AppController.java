package com.uts.spring_uts;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AppController {

    @Autowired
    private JohnTravoltaService johnTravoltaService;

    @Autowired
    private QuadraticService quadraticService;

    @Autowired
    private RuntimeService runtimeService;


    @GetMapping("/proses-diskon")
    public String triggerDiskon() {
        // PERBAIKAN: Gunakan HashMap, bukan Map langsung
        java.util.Map<String, Object> variables = new java.util.HashMap<>();
        variables.put("totalBelanja", 150000.0);

        runtimeService.startProcessInstanceByKey("Process1", variables);
        return "Proses Diskon berhasil dipicu!";
    }

    // Endpoint khusus untuk memicu Camunda "Hello World" tanpa login/webapp
    @GetMapping(value = "/hello", produces = "text/html")
    public String triggerHelloWorld() {
        // Memulai proses BPMN (pastikan ID proses di BPMN-mu sesuai, misal: "Process_HelloWorld")
        runtimeService.startProcessInstanceByKey("Process2");

        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html><html><head><title>Camunda Hello World</title></head>");
        html.append("<body style='font-family: Arial, sans-serif; margin: 40px;'>");
        html.append("<h2 style='color: green;'>HELLO WORLD!</h2>");
        html.append("</body></html>");

        return html.toString();
    }

}