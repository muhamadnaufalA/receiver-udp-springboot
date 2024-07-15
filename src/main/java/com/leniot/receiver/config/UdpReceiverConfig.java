package com.leniot.receiver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.ip.udp.UnicastReceivingChannelAdapter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import com.leniot.receiver.service.DptService;
import com.leniot.receiver.model.DptModel;

import java.nio.charset.StandardCharsets;

@Configuration
@EnableIntegration
public class UdpReceiverConfig {

    @Autowired
    private DptService dptService;

    @Bean
    public MessageChannel udpInboundChannel() {
        return new DirectChannel();
    }

    @Bean
    public UnicastReceivingChannelAdapter udpInboundAdapter() {
        UnicastReceivingChannelAdapter adapter = new UnicastReceivingChannelAdapter(9876);
        adapter.setOutputChannel(udpInboundChannel());
        return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = "udpInboundChannel")
    public MessageHandler udpMessageHandler() {
        return message -> {
            byte[] payloadBytes = (byte[]) message.getPayload();
            String payload = new String(payloadBytes, StandardCharsets.UTF_8);
            System.out.println("Received UDP message: " + payload);
            if (payload.toUpperCase().contains("DPT")) {
                try {
                    DptModel dptData = dptService.decode(payload);
                    System.out.println("Decoded DPT data: " + dptData + "\n");
                } catch (IllegalArgumentException e) {
                    System.out.println("Failed to decode message: " + e.getMessage() + "\n");
                }
            }
            
        };
    }
}
