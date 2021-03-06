package org.covid19;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;

public class PatientAndMessageSerde extends Serdes.WrapperSerde<PatientAndMessage> {
    public PatientAndMessageSerde() {
        super(new Serializer<PatientAndMessage>() {
            private Gson gson = new GsonBuilder().serializeNulls().create();

            @Override
            public byte[] serialize(String s, PatientAndMessage patientAndMessage) {
                return gson.toJson(patientAndMessage).getBytes(StandardCharsets.UTF_8);
            }
        }, new Deserializer<PatientAndMessage>() {
            private Gson gson = new Gson();

            @Override
            public PatientAndMessage deserialize(String s, byte[] bytes) {
                return gson.fromJson(new String(bytes), PatientAndMessage.class);
            }
        });
    }
}
