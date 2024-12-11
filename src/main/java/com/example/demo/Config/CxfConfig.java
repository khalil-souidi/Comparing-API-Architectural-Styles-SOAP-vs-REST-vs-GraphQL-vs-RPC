package com.example.demo.Config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import com.example.demo.Controllers.ReservationSoapController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfConfig {

    private final Bus bus;
    private final ReservationSoapController reservationSoapController;

    public CxfConfig(Bus bus, ReservationSoapController reservationSoapController) {
        this.bus = bus;
        this.reservationSoapController = reservationSoapController;
    }

    @Bean
    public EndpointImpl endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, reservationSoapController);
        endpoint.publish("/ws"); // SOAP endpoint will be available at /ws
        return endpoint;
    }

}
