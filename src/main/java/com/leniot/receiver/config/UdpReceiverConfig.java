package com.leniot.receiver.config;

import com.leniot.receiver.service.HdtService;
import com.leniot.receiver.service.MwdService;
import com.leniot.receiver.service.VhwService;
import com.leniot.receiver.service.WixdrService;
import com.leniot.receiver.service.PanzhrpService;
import com.leniot.receiver.model.HdtModel;
import com.leniot.receiver.model.VhwModel;
import com.leniot.receiver.model.MwdModel;
import com.leniot.receiver.model.PanzhrpModel;
import com.leniot.receiver.model.WixdrModel; 

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
import com.leniot.receiver.service.GllService;
import com.leniot.receiver.service.VtgService;
import com.leniot.receiver.service.MwvService;
import com.leniot.receiver.service.RmcService;
import com.leniot.receiver.model.DptModel;
import com.leniot.receiver.model.GllModel;
import com.leniot.receiver.model.VtgModel;
import com.leniot.receiver.model.MwvModel;
import com.leniot.receiver.model.RmcModel;

import java.nio.charset.StandardCharsets;

@Configuration
@EnableIntegration
public class UdpReceiverConfig {

    @Autowired
    private DptService dptService;

    @Autowired
    private GllService gllService;

    @Autowired
    private VtgService vtgService;

    @Autowired
    private MwvService mwvService;

    @Autowired
    private RmcService rmcService;

    private final HdtService hdtService;
    private final VhwService vhwService;
    private final MwdService mwdService;
    private final WixdrService wixdrService;
    private final PanzhrpService panzhrpService;

    public UdpReceiverConfig(HdtService hdtService, VhwService vhwService, MwdService mwdService, WixdrService wixdrService, PanzhrpService panzhrpService) {
        this.hdtService = hdtService;
        this.vhwService = vhwService;
        this.mwdService = mwdService;
        this.wixdrService = wixdrService;
        this.panzhrpService = panzhrpService;
    }

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
            System.out.println("Received NMEA message: " + payload);
        
            if (payload.contains("HDT")) {
                try {
                    HdtModel hdtModel = hdtService.encodeNmeaToHdt(payload);
                    System.out.println("Encoded HDT Data: " + hdtModel);
                } catch (IllegalArgumentException e) {
                    System.err.println("Invalid NMEA data: " + payload);
                }
            }else if (payload.contains("VHW")){
                try {
                    VhwModel vhwModel = vhwService.encodeNmeaToVhw(payload);
                    System.out.println("Encoded VHW Data: " + vhwModel);
                } catch (IllegalArgumentException e) {
                    System.err.println("Invalid NMEA data: " + payload);
                }
            }else if (payload.contains("MWD")){
                try {
                    MwdModel mwdModel = mwdService.encodeNmeaToMwd(payload);
                    System.out.println("Encoded VHW Data: " + mwdModel);
                } catch (IllegalArgumentException e) {
                    System.err.println("Invalid NMEA data: " + payload);
                }
            }else if (payload.contains("WIXDR")){
                try {
                    WixdrModel wixdrModel = wixdrService.encodeNmeaToWixdr(payload);
                    System.out.println("Encoded WIXDR Data: " + wixdrModel);
                } catch (Exception e) {
                    System.err.println("Invalid NMEA data: " + payload);
                }
            }else if (payload.contains("PANZHRP")){
                try {
                    PanzhrpModel panzhrpModel = panzhrpService.encodeNmeaToPanzhrp(payload);
                    System.out.println("Encoded PANZHRP Data: " + panzhrpModel);
                } catch (Exception e) {
                    System.err.println("Invalid NMEA data: " + payload);
                }
            }else if (payload.toUpperCase().contains("DPT")) {
                try {
                    DptModel dptData = dptService.decode(payload);
                    System.out.println("Decoded DPT data: " + dptData + "\n");
                } catch (IllegalArgumentException e) {
                    System.out.println("Failed to decode message: " + e.getMessage() + "\n");
                }
            } else if (payload.toUpperCase().contains("GLL")) {
                try {
                    GllModel gllData = gllService.decode(payload);
                    System.out.println("Decoded GLL data: " + gllData + "\n");
                } catch (IllegalArgumentException e) {
                    System.out.println("Failed to decode message: " + e.getMessage() + "\n");
                }
            } else if (payload.toUpperCase().contains("VTG")) {
                try {
                    VtgModel vtgData = vtgService.decode(payload);
                    System.out.println("Decoded VTG data: " + vtgData + "\n");
                } catch (IllegalArgumentException e) {
                    System.out.println("Failed to decode message: " + e.getMessage() + "\n");
                }
            } else if (payload.toUpperCase().contains("MWV")) {
                try {
                    MwvModel mwvData = mwvService.decode(payload);
                    System.out.println("Decoded MWV data: " + mwvData + "\n");
                } catch (IllegalArgumentException e) {
                    System.out.println("Failed to decode message: " + e.getMessage() + "\n");
                }
            } else if (payload.toUpperCase().contains("RMC")) {
                try {
                    RmcModel rmcData = rmcService.decode(payload);
                    System.out.println("Decoded RMC data: " + rmcData + "\n");
                } catch (IllegalArgumentException e) {
                    System.out.println("Failed to decode message: " + e.getMessage() + "\n");
                }
            } 
        };
    }
}
